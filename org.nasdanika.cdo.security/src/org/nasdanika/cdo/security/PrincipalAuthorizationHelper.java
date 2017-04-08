package org.nasdanika.cdo.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;

/**
 * Helper (mix-in) class for resolving principal permissions.
 * @author Pavel
 *
 */
public class PrincipalAuthorizationHelper {

	private static final String PARENT_NAVIGATION = "../";
	private Principal principal;
	
	/**
	 * Creates authorization helper for a given principal.
	 * @param principal
	 */
	public PrincipalAuthorizationHelper(Principal principal) {
		this.principal = principal;
	}
	
	/**
	 * Authorizes the helper's principal to perform an action against specified target in
	 * @param context
	 * @param target
	 * @param action
	 * @param qualifier
	 * @param environment
	 * @return
	 */
	public AccessDecision authorize(Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
		if (target!=null) {
			environment = environment == null ? new HashMap<String, Object>() : new HashMap<String, Object>(environment); 
			environment.put("target", target);
		}
		return authorize(principal, context, target, action, qualifier, new ArrayList<>(), environment, new HashSet<Principal>());
	}
	
	/**
	 * If this method returns true principals have all rights on object contained by the principal. 
	 * For example, Customer extends Principal and contains Accounts which contain Statements which in turn contain transactions. If this 
	 * method returns true, Customer would have all rights on their accounts, statements and transactions, as well as to self. 
	 * This implementation returns <code>true</code>.
	 * Containment is evaluated after explicitly granted/denied permissions, so some actions can be explicitly denied to the containing principal.
	 * Override as needed.
	 * @return
	 */
	protected boolean isContainmentOwnership() {
		return true;
	}
		
	/**
	 * Sorts permissions in the order of inheritance distance of the permission's action EClass to the target EClass.
	 * @param permissions
	 * @param target
	 * @return
	 */
	private static <P extends Permission> List<P> filterAndSortPermissions(List<P> permissions, EObject target) {
		class PermissionEntry implements Comparable<PermissionEntry> {
			P permission;
			int distance;
			public PermissionEntry(P permission, int distance) {
				this.permission = permission;
				this.distance = distance;
			}
			
			@Override
			public int compareTo(PermissionEntry o) {
				if (permission.getTarget()==o.permission.getTarget()) {
					int dd = distance - o.distance;
					return dd==0 ? permission.hashCode() - o.permission.hashCode() : dd;
				}
				
				if (permission.getTarget()==null) {
					return 1;
				}
				
				if (o.permission.getTarget()==null) {
					return -1;
				}
				
				return permission.hashCode() - o.permission.hashCode();
			}
		}
		List<PermissionEntry> tmp = new ArrayList<>();
		EClass targetClass = target.eClass(); 
		for (P p: permissions) {
			if (p.getTarget().equals(target)) {
				int distance = distance(targetClass, getActionClass(p.getAction(), targetClass));
				if (distance!=-1) {
					tmp.add(new PermissionEntry(p, distance));
				}
			}
		}
		Collections.sort(tmp);
		List<P> ret = new ArrayList<>();
		for (PermissionEntry pe: tmp) {
			ret.add(pe.permission);
		}
		return ret;
	}
	
	/**
	 * Traverses target class supertypes to find a supertype matching action's containing class and package.
	 * @param action
	 * @param targetClass
	 * @return Action class or null.
	 */
	private static EClass getActionClass(Action action, EClass targetClass) {
		EObject container = action.eContainer();
		while (container instanceof Action) {
			container = container.eContainer();
		}
		Class cls = (Class) container;
		Package pkg = (Package) cls.eContainer();
		if (targetClass.getName().equals(cls.getName()) && targetClass.getEPackage().getNsURI().equals(pkg.getNsURI())) {
			return targetClass;
		}
		for (EClass sc: targetClass.getEAllSuperTypes()) {
			if (sc.getName().equals(cls.getName()) && sc.getEPackage().getNsURI().equals(pkg.getNsURI())) {
				return sc;
			}
		}
		
		return null;
	}

	/**
	 * Inheritance distance between two classes.
	 * @param subClass
	 * @param superClass
	 * @return
	 */
	private static int distance(EClass subClass, EClass superClass) {
		if (superClass != null && superClass.isSuperTypeOf(subClass)) {
			if (subClass.equals(superClass)) {
				return 0;
			}
			int increment = 1000;
			for (EClass sc: subClass.getESuperTypes()) {
				++increment;
				int sd = distance(sc, superClass);
				if (sd!=-1) {
					return sd+increment;
				}
			}
		}
		return -1;
	}
	
	private AccessDecision authorize(
			Principal principal, 
			Context context,
			EObject target, 
			String action,
			String qualifier, 
			List<EStructuralFeature> path, 
			Map<String, Object> environment,
			Set<Principal> traversed) {
		
//		System.out.println("Authorizing: "+target+" "+action+" "+qualifier+" "+path);
		
		// Root
		Realm<?> realm = principal.getRealm();
		if (realm.getRoot() == principal) {
			return AccessDecision.ALLOW;
		}
		if (realm.getRoot() instanceof Group && ((Group) realm.getRoot()).isMember(principal)) {
			return AccessDecision.ALLOW;
		}
		
		StringBuilder qualifierBuilder = new StringBuilder();
		for (EStructuralFeature pe: path) {
			if (qualifierBuilder.length() > 0) {
				qualifierBuilder.append("/");
			}
			qualifierBuilder.append(pe.getName());
		}
		if (!CoreUtil.isBlank(qualifier)) {
			if (qualifierBuilder.length() > 0) {
				qualifierBuilder.append("/");
			}			
			qualifierBuilder.append(qualifier);
		}
		
		// Protected
		if (target instanceof Protected) {
			AccessDecision tad = ((Protected) target).authorize(context, principal, action, qualifierBuilder.toString(), environment);
			if (tad != AccessDecision.ABSTAIN) {
				return tad;
			}
		}
		
		// Own permissions and implies
		for (Permission p: filterAndSortPermissions(principal.getPermissions(), target)) {
			AccessDecision accessDecision = p.authorize(context, action, qualifierBuilder.toString(), environment);
			if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
				return accessDecision;
			}			
		}
				
		if (traversed.add(principal)) { // prevention of infinite loops if groups are cyclically nested.
			// Groups
			for (Group g: principal.getMemberOf()) {
				AccessDecision accessDecision = authorize(g, context, target, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}			
			}
			
			// Everyone
			Principal everyone = principal.getRealm().getEveryone();
			if (everyone != null && everyone != principal && principal.getRealm().getGuest() != principal) {
				AccessDecision accessDecision = authorize(everyone, context, target, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}
			}
		}

		// Containment
		if (target instanceof EObject) {
			EObject targetContainer = ((EObject) target).eContainer();
			EStructuralFeature targetContainingFeature = ((EObject) target).eContainingFeature();
			if (targetContainer!=null && targetContainingFeature!=null) {
				if (qualifier!=null && qualifier.startsWith(PARENT_NAVIGATION)) {
					qualifier = qualifier.substring(PARENT_NAVIGATION.length());
				} else {
					path.add(0, targetContainingFeature);
				}
				AccessDecision accessDecision = authorize(principal, context, targetContainer, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}
			}
		}
		
		// Containment ownership
		if (isContainmentOwnership() && EcoreUtil.isAncestor(principal, target)) {
			return AccessDecision.ALLOW;
		}
					
		return AccessDecision.ABSTAIN;
	}
	
}
