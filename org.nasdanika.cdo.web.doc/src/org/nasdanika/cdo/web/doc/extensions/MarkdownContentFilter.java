package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;

import org.nasdanika.cdo.web.doc.ContentFilter;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.core.CoreUtil;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

/**
 * Converts markdown to HTML
 * @author Pavel
 *
 */
public class MarkdownContentFilter implements ContentFilter {
	
	@Override
	public Object filter(Object content, DocRoute docRoute, URI baseURI, String urlPrefix) throws Exception {
		LinkRenderer linkRenderer = docRoute.createMarkdownLinkRenderer(baseURI, urlPrefix);
		if (linkRenderer==null) {
			linkRenderer = new LinkRenderer();
		}
		String markdown = CoreUtil.stringify(content);
		// TODO - expand markdown
		return "<div class=\"markdown-body\">"+new PegDownProcessor(DocRoute.MARKDOWN_OPTIONS).markdownToHtml(docRoute.preProcessMarkdown(markdown, baseURI, urlPrefix), linkRenderer)+"</div>";
	}

}
