package org.nasdanika.codegen;

import java.util.function.Predicate;

/**
 * Adding this service to the context allows to filter generators to be invoked,
 * e.g. only a generator path to a particular generator in the tree can be executed 
 * instead of the entire tree. 
 * @author Pavel Vlasov
 *
 */
public interface GeneratorFilter extends Predicate<Generator<?>> {
		

}
