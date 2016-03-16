package org.nasdanika.cdo.security;

/**
 * @author Pavel Vlasov
 *
 */
public interface PrincipalVisitor {
	
	void visit(Principal principal);

}
