package org.nasdanika.function;


public interface PromiseFacade<C, F extends Function<C>, FC> extends Promise<C, F, PromiseFacade<C,F,FC>>, Facade<C, FC, PromiseFacade<C,F,FC>> {

}
