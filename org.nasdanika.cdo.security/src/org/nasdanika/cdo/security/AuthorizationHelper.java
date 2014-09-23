package org.nasdanika.cdo.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * Helper class for resolving permissions.
 * @author Pavel
 *
 */
public class AuthorizationHelper {

	private static final String SLASH = "/";
	private Principal principal;
	
	public AuthorizationHelper(Principal principal) {
		this.principal = principal;
	}
	
	public AccessDecision authorize(SecurityPolicy securityPolicy, Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
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
			EObject target, 
			String action,
			String qualifier,
			String path, 
			Map<String, Object> environment, 
			Set<Principal> traversed) {
		
		if (traversed.add(principal)) { // prevention of infinite loops if groups are cyclically nested.
			// Superuser
			ProtectionDomain<?> protectionDomain = principal.getProtectionDomain();
			if (protectionDomain.getSuperUsersGroup()!=null && protectionDomain.getSuperUsersGroup().isMember(principal)) {
				return AccessDecision.ALLOW;
			}
			
			// Own permissions and implies
			for (Permission p: principal.getPermissions()) {
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
			}
			
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
	
			// Containment
			EObject targetContainer = target.eContainer();
			EStructuralFeature targetContainingFeature = target.eContainingFeature();
			if (targetContainer!=null && targetContainingFeature!=null) {
				if (!path.endsWith(SLASH)) {
					path+=SLASH;
				}
				path+=targetContainingFeature.getName();
				AccessDecision accessDecision = authorize(securityPolicy, principal, context, targetContainer, action, qualifier, path, environment, traversed);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return accessDecision;
				}
			}
		}
		
		return AccessDecision.ABSTAIN;
	}	

}
