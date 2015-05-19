package org.nasdanika.cdo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;

/**
 * Helper class for resolving permissions.
 * @author Pavel
 *
 */
public class AuthorizationHelper {

	public static final String ANNOTATION_PERMISSIONS = "org.nasdanika.cdo.security:permissions";
	private static final String SLASH = "/";
	private Principal principal;
	
	public AuthorizationHelper(Principal principal) {
		this.principal = principal;
	}
	
	public AccessDecision authorize(SecurityPolicy securityPolicy, Context context, Object target, String action, String qualifier, Map<String, Object> environment) {
		if (target!=null) {
			environment = environment == null ? new HashMap<String, Object>() : new HashMap<String, Object>(environment); 
			environment.put("target", target);
		}
		return authorize(securityPolicy, principal, context, target, action, qualifier, SLASH, environment, new HashSet<Principal>());
	}
	
	private static AccessDecision authorize(
			SecurityPolicy securityPolicy,
			Principal principal, 
			Context context,
			Object target, 
			String action,
			String qualifier,
			String path, 
			Map<String, Object> environment, 
			Set<Principal> traversed) {
		
//		System.out.println("Authorizing: "+target+" "+action+" "+qualifier+" "+path);
		
		// Superuser
		ProtectionDomain<?> protectionDomain = principal.getProtectionDomain();
		if (protectionDomain.getSuperUsersGroup()!=null && protectionDomain.getSuperUsersGroup().isMember(principal)) {
			return AccessDecision.ALLOW;
		}
		
		if (target!=null 
				&& (target.getClass().getName().startsWith("[") 
						|| target.getClass().getName().startsWith("java.") 
						|| target.getClass().getName().startsWith("javax."))) {			
			return AccessDecision.ALLOW; // No security on JDK classes and arrays.
		}
		
		// Own permissions and implies
		for (Permission p: filterAndSortPermissions(principal.getPermissions(), target)) {			
			String qualifiedPath = path;
			if (qualifier!=null) {
				if (!qualifiedPath.endsWith(SLASH)) {
					qualifiedPath+=SLASH;
				}
				qualifiedPath+=qualifier;
			}
			AccessDecision accessDecision = p.authorize(securityPolicy, context, target, action, qualifiedPath, environment);
			if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
				return accessDecision;
			}
			
			if (protectionDomain instanceof SecurityPolicy) {
				AccessDecision pdAccessDecision = p.authorize((SecurityPolicy) protectionDomain, context, target, action, qualifiedPath, environment);
				if (!AccessDecision.ABSTAIN.equals(pdAccessDecision)) {
					return pdAccessDecision;
				}					
			}
			
			if (protectionDomain instanceof ActionContainer) {
				AccessDecision pdAccessDecision = p.authorize(asSecurityPolicy((ActionContainer) protectionDomain), context, target, action, qualifiedPath, environment);
				if (!AccessDecision.ABSTAIN.equals(pdAccessDecision)) {
					return pdAccessDecision;
				}					
			}
			
		}
		
		// Implies from the permissions annotation
		if (target instanceof EObject) {
			List<EAnnotation> permissionsAnnotations = new ArrayList<EAnnotation>();
			EClass eClass = ((EObject) target).eClass();
			EAnnotation pa = eClass.getEAnnotation(ANNOTATION_PERMISSIONS);
			if (pa!=null) {
				permissionsAnnotations.add(pa);
			}
			for (EClass st: eClass.getEAllSuperTypes()) {
				pa = st.getEAnnotation(ANNOTATION_PERMISSIONS);
				if (pa!=null) {
					permissionsAnnotations.add(pa);
				}				
			}
			for (EAnnotation permissionsAnnotation: permissionsAnnotations) {
				for (Entry<String, String> de: permissionsAnnotation.getDetails().entrySet()) {
					for (String implied: de.getValue().split("\\r?\\n")) {
						if (!CoreUtil.isBlank(implied) && !implied.trim().startsWith("#")) {
							int idx = implied.indexOf(SLASH);
							String impliedAction = (idx==-1 ? implied : implied.substring(0, idx)).trim();
							if ("*".equals(impliedAction) || impliedAction.equals(action)) {
								String impliedPattern = idx==-1 ? SLASH : implied.substring(idx).trim();
								String fullPath = path.endsWith(SLASH) ? path+qualifier : path+SLASH+qualifier;
								if (Pattern.matches(impliedPattern, fullPath)) {
									int iidx = de.getKey().indexOf(SLASH);
									String implyingAction = (iidx==-1 ? de.getKey() : de.getKey().substring(0, iidx)).trim();
									String implyingQualifier = iidx==-1 || iidx==de.getKey().length()-1 ? null : de.getKey().substring(iidx+1);
									AccessDecision implyingAccessDecision = authorize(securityPolicy, principal, context, target, implyingAction, implyingQualifier, SLASH, environment, traversed);
									if (AccessDecision.ALLOW.equals(implyingAccessDecision)) {
										return implyingAccessDecision;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (traversed.add(principal)) { // prevention of infinite loops if groups are cyclically nested.
			// Groups
			for (Group g: principal.getMemberOf()) {
				AccessDecision accessDecision = authorize(securityPolicy, g, context, target, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}			
			}
			
			// Everyone
			if (principal instanceof User) {
				if (!principal.equals(protectionDomain.getUnauthenticatedPrincipal())) {
					Group everyoneGroup = protectionDomain.getEveryoneGroup();
					if (everyoneGroup!=null) {
						AccessDecision accessDecision = authorize(securityPolicy, everyoneGroup, context, target, action, qualifier, path, environment, traversed);
						if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
							return accessDecision;
						}
					}
				}
			}
		}

		// Containment
		if (target instanceof EObject) {
			EObject targetContainer = ((EObject) target).eContainer();
			EStructuralFeature targetContainingFeature = ((EObject) target).eContainingFeature();
			if (targetContainer!=null && targetContainingFeature!=null) {
				if (path.equals(SLASH)) {
					path=SLASH+targetContainingFeature.getName();
				} else {
					path=SLASH+targetContainingFeature.getName()+path;
				}
				AccessDecision accessDecision = authorize(securityPolicy, principal, context, targetContainer, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}
			}
		}
		
		return AccessDecision.ABSTAIN;
	}

	private static List<Permission> filterAndSortPermissions(EList<Permission> permissions, Object target) {
		// Global permissions
		if (target==null) { 
			List<Permission> ret = new ArrayList<>();
			for (Permission p: permissions) {
				if (CoreUtil.isBlank(p.getTargetNamespaceURI()) && CoreUtil.isBlank(p.getTargetClass())) {
					ret.add(p);
				}
			}	
			return ret;
		}
		
		// Class permissions
		class PermissionEntry implements Comparable<PermissionEntry> {
			Permission permission;
			int distance;
			public PermissionEntry(Permission permission, int distance) {
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
		if (target instanceof EObject) {
			EClass eClass = target instanceof EClass ? (EClass) target : ((EObject) target).eClass();
			for (Permission p: permissions) {
				int distance = (p.getTarget()!=null && p.getTarget().equals(target)) ? 0 : distance(p, eClass);
				if (distance!=-1) {
					tmp.add(new PermissionEntry(p, distance));
				}
			}
		} else {
			Class<? extends Object> targetClass = target instanceof Class ? (Class<?>) target : target.getClass();
			for (Permission p: permissions) {
				int distance = (p.getTarget()!=null && p.getTarget().equals(target)) ? 0 : distance(p, targetClass);
				if (distance!=-1) {
					tmp.add(new PermissionEntry(p, distance));
				}
			}			
		}
		Collections.sort(tmp);
		List<Permission> ret = new ArrayList<>();
		for (PermissionEntry pe: tmp) {
			ret.add(pe.permission);
		}
		return ret;
	}

	private static int distance(Permission p, EClass eClass) {
		if (eClass.getName().equals(p.getTargetClass()) && eClass.getEPackage().getNsURI().equals(p.getTargetNamespaceURI())) {
			return 0;
		}
		for (EClass sc: eClass.getESuperTypes()) {
			int sd = distance(p, sc);
			if (sd!=-1) {
				return sd+1;
			}
		}
		return -1;
	}
	
	private static String[] classQualifiedName(Class<?> clazz) {
		String className = clazz.getName();
		int idx = className.lastIndexOf('.');
		if (idx==-1) {
			return new String[] {"java://default", className};
		}
		return new String[] {"java://"+className.substring(0, idx), className.substring(idx+1)};
	}

	private static int distance(Permission p, Class<?> clazz) {
		if (clazz==null) {
			return -1;
		}
		String[] qName = classQualifiedName(clazz);
		if (qName[1].equals(p.getTargetClass()) && qName[0].equals(p.getTargetNamespaceURI())) {
			return 0;
		}
		int sd = distance(p, clazz.getSuperclass());
		if (sd!=-1) {
			return sd;
		}
		for (Class<?> i: clazz.getInterfaces()) {
			int id = distance(p, i);
			if (id!=-1) {
				return id+1;
			}
		}
		return -1;
	}
	
	/**
	 * Inherits condition.
	 * @return
	 */
	public static String effectiveTargetNamespaceURI(Action action) {
		for (Action a = action; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			String ret = a.getTargetNamespaceURI();
			if (!CoreUtil.isBlank(ret)) {
				return ret;
			}
		}
		return action.getTargetNamespaceURI();
	}
		
	/**
	 * Inherits condition.
	 * @return
	 */
	public static String effectiveTargetClass(Action action) {
		for (Action a = action; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			String ret = a.getTargetClass();
			if (!CoreUtil.isBlank(ret)) {
				return ret;
			}
		}
		return action.getTargetClass();
	}

	public static SecurityPolicy asSecurityPolicy(final ActionContainer actionContainer) {
		return new SecurityPolicy() {
			
			private void getGrantableActions(Action action, String targetNamespaceURI, String targetClass, Collection<Action> collector) {
				if (action.isGrantable()
						&& equal(effectiveTargetNamespaceURI(action), targetNamespaceURI)
						&& equal(effectiveTargetClass(action), targetClass)) {
					collector.add(action);
				}
				for (Action c: action.getActions()) {
					getGrantableActions(c, targetNamespaceURI, targetClass, collector);
				}
			}
			
			@Override
			public Collection<Action> getGrantableActions(String targetNamespaceURI, String targetClass) {
				List<Action> ret = new ArrayList<>();
				if (actionContainer instanceof Action 
						&& ((Action) actionContainer).isGrantable()
						&& equal(effectiveTargetNamespaceURI((Action) actionContainer), targetNamespaceURI)
						&& equal(effectiveTargetClass((Action) actionContainer), targetClass)) {
					ret.add((Action) actionContainer);
				}
				for (Action a: actionContainer.getActions()) {
					getGrantableActions(a, targetNamespaceURI, targetClass, ret);
				}
				return ret;
			}
			
			@Override
			public Action getAction(ActionKey actionKey) {
				return findAction(actionKey, actionContainer, null, null, null);
			}
			
		};
	}	
	
	private static boolean equal(String str1, String str2) {
		if (CoreUtil.isBlank(str1)) {
			return CoreUtil.isBlank(str2);
		}
		if (CoreUtil.isBlank(str2)) {
			return false;
		}
		return str1.trim().equals(str2.trim());
	}

	public static Action findAction(
			ActionKey actionKey, 
			ActionContainer ac, 
			String inheritedNamespace, 
			String inheritedClass, 
			String inheritedName) {
		for (Action action: ac.getActions()) {
//			System.out.println(actionKey.getName());
			String effectiveNamespace = effective(action.getTargetNamespaceURI(), inheritedNamespace);
			String effectiveClass = effective(action.getTargetClass(), inheritedClass);
			String effectiveName = effective(action.getName(), inheritedName);
			if (equal(actionKey.getTargetNamespaceURI(), effectiveNamespace)
					&& equal(actionKey.getTargetClass(), effectiveClass)
					&& ("*".equals(effectiveName) || equal(actionKey.getName(), effectiveName)) 
					&& equal(actionKey.getQualifier(), action.getQualifier())) {
				return action;
			}
			Action subAction = findAction(actionKey, action, effectiveNamespace, effectiveClass, effectiveName);
			if (subAction!=null) {
				return subAction;
			}
		}
		return null;
	}
	
	private static String effective(String val, String inherited) {
		return CoreUtil.isBlank(val) ? inherited : val;
	}

	
}
