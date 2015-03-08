package org.nasdanika.function;

public interface DeferredFacade<C, F extends Function<C>, P extends Promise<C,F,P>, FC> extends Deferred<C,F,P>, Facade<C, FC, Deferred<C,F,P>> {

}
