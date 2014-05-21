package org.nasdanika.cdo.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NasdanikaCDOUtil {

	private static final String HTML_CLOSE_TAG = "</html>";
	private static final String HTML_OPEN_TAG = "<html>";

	private NasdanikaCDOUtil() {
		// Singleton
	}

	
	public static String stripExtension(String str) {
		int idx = str.lastIndexOf('.');
		return idx==-1 ? str : str.substring(0, idx);
	}
	
	public static String getDocumentation(EModelElement modelElement) {
		String doc = EcoreUtil.getDocumentation(modelElement);
		if (doc==null) {
			return "&nbsp;";
		}
		String trimmedDoc = doc.trim();
		if (trimmedDoc.startsWith(HTML_OPEN_TAG) && trimmedDoc.endsWith(HTML_CLOSE_TAG)) {
			return trimmedDoc.substring(HTML_OPEN_TAG.length(), trimmedDoc.length()-HTML_CLOSE_TAG.length());
		}
		
		return "<pre>"+StringEscapeUtils.escapeHtml4(doc)+"</pre>";
	}

	/**
	 * Returns first sentence (till first dot) of the documentation.
	 * @param modelElement
	 * @return
	 */
	public static String getSummary(EModelElement modelElement) {
		String doc = EcoreUtil.getDocumentation(modelElement);
		if (doc==null) {
			return "&nbsp;";
		}
		String trimmedDoc = doc.trim();
		if (trimmedDoc.startsWith(HTML_OPEN_TAG) && trimmedDoc.endsWith(HTML_CLOSE_TAG)) {
			String htmlDoc = trimmedDoc.substring(HTML_OPEN_TAG.length(), trimmedDoc.length()-HTML_CLOSE_TAG.length());
			int idx = htmlDoc.indexOf(".");
			return idx==-1 ? htmlDoc : htmlDoc.substring(0, idx+1);
		}
		
		String escapedDoc = StringEscapeUtils.escapeHtml4(doc);
		int idx = escapedDoc.indexOf(".");
		return idx==-1 ? "<pre>"+escapedDoc+"</pre>" : escapedDoc.substring(0, idx+1);
	}
	
	public static String nameToLabel(String name) {
		String[] words = StringUtils.splitByCharacterTypeCamelCase(StringUtils.capitalize(name));
		for (int i=1; i<words.length; ++i) {
			words[i] = words[i].toLowerCase();
		}
		return StringEscapeUtils.escapeHtml4(StringUtils.join(words, " "));
	}
	
}
