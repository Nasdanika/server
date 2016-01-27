package org.nasdanika.webtest;

/**
 * Actors and pages may implement this interface to assign meaningful aliases to actor/page instances
 * to differentiate between them in situations when more than one instance of the same type participates
 * in a test. If actors/pages do not implement this interface, aliases are assigned automatically.
 * @author Pavel Vlasov
 *
 */
public interface Aliased {
	
	String getAlias();

}
