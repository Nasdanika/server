package org.nasdanika.webtest;

/**
 * An interface which actor or page classes can implement to indicate that the class is 
 * not the primary actor/page, but a helper. Reporting tools may choose to not to display delegates in the list 
 * of actors/pages.  
 * @author Pavel Vlasov
 *
 */
public interface Delegate<T> {
	
	T getDelegatedBy();

}
