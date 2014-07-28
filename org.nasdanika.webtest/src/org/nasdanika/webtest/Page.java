package org.nasdanika.webtest;

/**
 * Represents UI page/screen. Page methods shall correspond to interactions with individual page elements, 
 * grouping of interactions into steps shall be implemented by Actor methods.
 * @author Pavel Vlasov
 *
 */
public interface Page {
	
	/**
	 * Verifies that what is currently displayed in the browser matches this page.
	 * @return
	 */
	boolean match();

}
