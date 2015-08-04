package org.nasdanika.cdo.web.doc;

import java.net.URL;

import org.nasdanika.core.CoreUtil;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

/**
 * Converts markdown to HTML
 * @author Pavel
 *
 */
public class MarkdownContentFilter implements ContentFilter {
	PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL ^ Extensions.HARDWRAPS ^ Extensions.SUPPRESS_HTML_BLOCKS);

	@Override
	public Object filter(Object content, DocRoute docRoute, URL baseURL, String urlPrefix) throws Exception {
		LinkRenderer linkRenderer = docRoute.createMarkdownLinkRenderer(baseURL, urlPrefix);
		if (linkRenderer==null) {
			linkRenderer = new LinkRenderer();
		}
		String markdown = CoreUtil.stringify(content);
		// TODO - expand markdown
		return "<div class=\"markdown-body\">"+pegDownProcessor.markdownToHtml(markdown, linkRenderer)+"</div>";
	}

}
