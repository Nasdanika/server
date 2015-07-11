package org.nasdanika.cdo.web.doc;

import java.util.Map;

import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;

/**
 * Converts markdown to HTML
 * @author Pavel
 *
 */
public class MarkdownContentFilter implements ContentFilter {
	PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL ^ Extensions.HARDWRAPS);

	@Override
	public Object filter(Object content, Map<Object, Object> env) throws Exception {
		LinkRenderer linkRenderer = (LinkRenderer) env.get(LinkRenderer.class);
		if (linkRenderer==null) {
			linkRenderer = new LinkRenderer();
		}
		return "<div class=\"markdown-body\">"+pegDownProcessor.markdownToHtml(DocRoute.stringify(content), linkRenderer)+"</div>";
	}

}
