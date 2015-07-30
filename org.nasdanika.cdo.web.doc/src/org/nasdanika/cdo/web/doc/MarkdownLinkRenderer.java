package org.nasdanika.cdo.web.doc;

import static org.pegdown.FastEncoder.encode;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.LinkInfo;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.LinkInfo.Registry;
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
	private Registry linkRegistry;

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
		
		this.linkRegistry = linkRegistry;
	}
	
	protected Rendering createRendering(String href, String text, String title) {
		LinkInfo linkInfo = linkRegistry==null || href==null ? null : linkRegistry.getLinkInfo(href);
		if (CoreUtil.isBlank(text)) {
			if (linkInfo!=null) {
				text = linkInfo.getLabel(); 
			}
			if (CoreUtil.isBlank(text)) {
				text = href;
				int slashIdx = text.lastIndexOf('/');
				if (slashIdx!=-1) {
					text = text.substring(slashIdx+1);				
				}
				int dotIdx = text.lastIndexOf('.');
				if (dotIdx!=-1) {
					text = text.substring(0, dotIdx);
				}
				text = text.replace('_', ' ');				
			}
		}

		if (urlRewriter!=null && href!=null) {
			href = urlRewriter.rewrite(href);
		}
		
		boolean isMissing = href==null || (linkInfo!=null && linkInfo.isMissing());
		String iconTag = linkInfo==null ? null : linkInfo.getIconTag();
		String linkContent = (CoreUtil.isBlank(iconTag) ? "" : iconTag) + StringEscapeUtils.escapeHtml4(text);
		
		Rendering ret = new Rendering(href==null ? "#" : href, linkContent);
		
		if (isMissing) {
			ret.withAttribute("style", "color:red");
		}
		
		String target = getLinkTarget(href);
        if (!CoreUtil.isBlank(target)) {
        	ret.withAttribute("target", target);
        }
        
        if (!CoreUtil.isBlank(title)) {
        	ret.withAttribute("title", encode(title));
        }
		
        return ret;		
	}
		
    public Rendering render(ExpLinkNode node, String text) {
    	return createRendering(node.url, text, node.title);
    }

    public Rendering render(ExpImageNode node, String text) {
    	return createRendering(node.url, text, node.title);
    }

    public Rendering render(RefLinkNode node, String url, String title, String text) {
    	return createRendering(url, text, title);
    }

    public Rendering render(RefImageNode node, String url, String title, String alt) {
    	return createRendering(url, alt, title);
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


