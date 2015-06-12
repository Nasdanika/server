package org.nasdanika.cdo.web.doc;

/**
 * Instances of this interface are provided to content processors to rewrite regular URL's to
 * SPA router url's, e.g. <code>/myapp/router/doc/bundle/org.nasdanika.core/MyPage.md</code> to 
 * <code>#router/doc-content//myapp/router/doc/bundle/org.nasdanika.core/MyPage.md</code>
 * 
 * @author Pavel
 *
 */
public interface URLRewriter {
	
	String rewrite(String url);

}
