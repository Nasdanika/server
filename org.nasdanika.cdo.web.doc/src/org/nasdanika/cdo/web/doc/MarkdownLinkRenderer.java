package org.nasdanika.cdo.web.doc;

import static org.pegdown.FastEncoder.encode;

import org.nasdanika.cdo.web.doc.WikiLinkProcessor.LinkInfo;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Resolver;
import org.nasdanika.core.CoreUtil;
import org.pegdown.LinkRenderer;
import org.pegdown.ast.ExpImageNode;
import org.pegdown.ast.ExpLinkNode;
import org.pegdown.ast.RefImageNode;
import org.pegdown.ast.RefLinkNode;
import org.pegdown.ast.WikiLinkNode;

public class MarkdownLinkRenderer extends LinkRenderer {

	private URLRewriter urlRewriter;
	private WikiLinkProcessor wikiLinkProcessor;

	public MarkdownLinkRenderer(
			Renderer.Registry rendererRegistry, 
			Resolver.Registry resolverRegistry, 
			LinkInfo.Registry linkRegistry,
			URLRewriter urlRewriter) {
		this.urlRewriter = urlRewriter;
		if (this.urlRewriter==null) {
			this.urlRewriter = new URLRewriter() {
				
				@Override
				public String rewrite(String url) {
					return url; // NOP
				}
			};
		}
		this.wikiLinkProcessor = new WikiLinkProcessor(
				rendererRegistry, 
				resolverRegistry, 
				linkRegistry, 
				urlRewriter);
	}
		
    public Rendering render(ExpLinkNode node, String text) {
        Rendering rendering = new Rendering(urlRewriter.rewrite(node.url), text);
        Rendering ret = CoreUtil.isBlank(node.title) ? rendering : rendering.withAttribute("title", encode(node.title));
        String target = getLinkTarget(node.url);
        if (!CoreUtil.isBlank(target)) {
        	ret.withAttribute("target", target);
        }
		return ret;
    }

    public Rendering render(ExpImageNode node, String text) {
        Rendering rendering = new Rendering(urlRewriter.rewrite(node.url), text);
        Rendering ret = CoreUtil.isBlank(node.title) ? rendering : rendering.withAttribute("title", encode(node.title));
        String target = getLinkTarget(node.url);
        if (!CoreUtil.isBlank(target)) {
        	ret.withAttribute("target", target);
        }
		return ret;
    }

    public Rendering render(RefLinkNode node, String url, String title, String text) {
        Rendering rendering = new Rendering(urlRewriter.rewrite(url), text);
        Rendering ret = CoreUtil.isBlank(title) ? rendering : rendering.withAttribute("title", encode(title));
        String target = getLinkTarget(url);
        if (!CoreUtil.isBlank(target)) {
        	ret.withAttribute("target", target);
        }
		return ret;
    }

    public Rendering render(RefImageNode node, String url, String title, String alt) {
        Rendering rendering = new Rendering(urlRewriter.rewrite(url), alt);
        Rendering ret = CoreUtil.isBlank(title) ? rendering : rendering.withAttribute("title", encode(title));
        String target = getLinkTarget(url);
        if (!CoreUtil.isBlank(target)) {
        	ret.withAttribute("target", target);
        }
		return ret;
    }

    public Rendering render(WikiLinkNode node) {
    	return wikiLinkProcessor.wikiLinkToRendering(node.getText());
    }
    	
	/**
	 * Subclasses can override this method to add "target" attribute to links. 
	 * @param href
	 * @return
	 */
	protected String getLinkTarget(String href) {
		return null;
	}
		
//	/**
//	 * Subclasses can override this method to look up wiki link icon.
//	 * @param href
//	 * @return
//	 */
//	protected String linkIcon(String href) {
//		return null;
//	}
//
//	
//	protected String resolve(String resolver, String url) {
//		if ("url".equals(resolver)) {
//			return url;
//		}
//		if ("bundle".equals(resolver)) {
//			return "bundle://"+url;
//		}
//		return resolver+">"+url;
//	}
//	
//	/**
//	 * Subclasses can override this method to render broken links in red
//	 * @param href
//	 * @return
//	 */
//	protected boolean isMissing(String href) {
//		return false;
//	}
	
}


