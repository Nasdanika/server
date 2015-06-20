package org.nasdanika.cdo.web.doc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
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
	PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL);

	@Override
	public Object filter(Object content, Map<Object, Object> env) throws Exception {
		if (content==null) {
			return null;
		}
		if (content instanceof String) {
			LinkRenderer linkRenderer = (LinkRenderer) env.get(LinkRenderer.class);
			if (linkRenderer==null) {
				linkRenderer = new LinkRenderer();
			}
			return "<div class=\"markdown-body\">"+pegDownProcessor.markdownToHtml((String) content, linkRenderer)+"</div>";
		}		
		if (content instanceof Reader) {
			StringWriter sw = new StringWriter();
			try (Reader reader = (Reader) content) {
				for (int ch = reader.read(); ch!=-1; ch = reader.read()) {
					sw.write(ch);
				}
			} 
			sw.close();
			return filter(sw.toString(), env);
		}
		if (content instanceof InputStream) {
			try (InputStream in = (InputStream) content) {
				return filter(new InputStreamReader(in), env);
			}
		}
		if (content instanceof URL) {
			return filter(((URL) content).openStream(), env);
		}
		
		throw new IllegalArgumentException("Unexpected content: "+content);
	}

}
