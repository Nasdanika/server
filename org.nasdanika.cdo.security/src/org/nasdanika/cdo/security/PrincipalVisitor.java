package org.nasdanika.cdo.security;

/**
 * @author Pavel Vlasov
 *
 */
public interface PrincipalVisitor {
	
	/**
	 * Visits a principal
	 * @param principal
	 * @return If principal is {@link Group} and this method returns <code>false</code> then group members shall not be visited.
	 */
	boolean visit(Principal principal);

}
