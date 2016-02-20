package org.nasdanika.core;

import java.util.Set;

/**
 * Runtime components such as extensions and services may implement this interface to 
 * report runtime documentation/configuration to the documentation system.
 * @author Pavel Vlasov
 *
 */
public interface DocumentationProvider {
	
	/**
	 * @return Array of supported formats, e.g. text/html, text/md, text/plain
	 */
	String[] getSupportedDocumentationFormats();
	
	/**
	 * Returns documentation in requested format.
	 * @param format One of formats returned by getSupportedDocumentationFormats() method.
	 * @return
	 */
	String getDocumentation(String format);

}
