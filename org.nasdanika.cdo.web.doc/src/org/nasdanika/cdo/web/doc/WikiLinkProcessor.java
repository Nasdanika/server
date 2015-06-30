package org.nasdanika.cdo.web.doc;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.CoreUtil;
import org.pegdown.LinkRenderer.Rendering;

/**
 * Parses wiki link ([[...]]) in format <code>renderer(config):resolver>location|text</code>, e.g.
 * <UL>
 * <LI><code>[[global>urn:org.nasdanika.cdo.security/ProtectionDomain]]</code> - resolver is 'global' - resolves a link to ProtectionDomain EClass in 
 * a package with NsURI urn:org.nasdanika.cdo.security in the global package registry.</LI>
 * <LI><code>[[global>urn:org.nasdanika.cdo.security/ProtectionDomain|Protection Domain package]]</code> - same as above with link text 'Protection Domain package' 
 * <LI><code>[[lightbox:someimage.png]]</code> - renders lightbox link to an image located in the same directory with the source page.  
 * </UL>
 * Use backslash to escape control characters - &gt; and |.
 * All parts are optional.
 * @author Pavel
 *
 */
public class WikiLinkProcessor {
	
	public interface Renderer {
		
		interface Registry {
			
			Renderer getRenderer(String name);
			
		}
		
		Rendering render(
				String href, 
				String content, 
				String config,
				boolean isMissing);
		
	}
	
	public interface Resolver {
		
		interface Registry {
			
			Resolver getResolver(String name);
			
		}
		
		String resolve (String href);
		
	}
	
	/**
	 * Provides information about internal links.
	 * @author Pavel
	 *
	 */
	public interface LinkInfo {
		
		interface Registry {
			
			LinkInfo getLinkInfo(String url);
			
		}
		
		String getIconTag();
		
		String getLabel();
		
		boolean isMissing();
		
	}
		
	private Renderer.Registry rendererRegistry;
	private Resolver.Registry resolverRegistry;
	private URLRewriter urlRewriter;
	private LinkInfo.Registry linkRegistry;
		
	public WikiLinkProcessor(
			Renderer.Registry rendererRegistry, 
			Resolver.Registry resolverRegistry,
			LinkInfo.Registry linkRegistry,
			URLRewriter urlRewriter) {
		this.rendererRegistry = rendererRegistry;
		this.resolverRegistry = resolverRegistry;
		this.urlRewriter = urlRewriter;
		this.linkRegistry = linkRegistry;
	}
	
	public Rendering wikiLinkToRendering(String wikiLink) {
		Renderer renderer = null;
		String rendererConfig = null;
		int colonIdx = indexOf(wikiLink, 0, ':');
		if (colonIdx!=-1) {
			String rendererSpec = wikiLink.substring(0, colonIdx);
			int lParIdx = indexOf(rendererSpec, 0, '(');
			if (lParIdx==-1) {
				renderer = rendererRegistry.getRenderer(unescape(rendererSpec));
			} else {
				int rParIdx = indexOf(rendererSpec, lParIdx, ')');
				if (rParIdx!=-1) {
					rendererConfig = unescape(rendererSpec.substring(lParIdx+1, rParIdx));
					renderer = rendererRegistry==null ? null : rendererRegistry.getRenderer(unescape(rendererSpec.substring(0, lParIdx)));					
				}
			}
			if (renderer==null) {
				colonIdx = -1; // Not a renderer spec, but perhaps URL, e.g. http://
			}
		}
		
		Resolver resolver = null;
		int gtIdx = indexOf(wikiLink, colonIdx+1, '>');
		if (gtIdx!=-1) {			
			resolver = resolverRegistry==null ? null : resolverRegistry.getResolver(unescape(wikiLink.substring(colonIdx+1, gtIdx)));
			if (resolver==null) {
				gtIdx = -1;
			}
		}	
		if (gtIdx==-1) {
			gtIdx = colonIdx;
		}
		
		String href;
		String text = null;
		int pipeIdx = indexOf(wikiLink, gtIdx+1, '|');
		if (pipeIdx==-1) {
			href = unescape(wikiLink.substring(gtIdx+1));	
		} else {
			href = unescape(wikiLink.substring(gtIdx+1, pipeIdx));
			text = wikiLink.substring(pipeIdx+1);
		}
		if (resolver!=null) {
			href = resolver.resolve(href);
		}
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
		String linkContent = (CoreUtil.isBlank(iconTag) ? "" : iconTag+" ") + StringEscapeUtils.escapeHtml4(text);
		
		if (renderer==null) {
			Rendering ret = new Rendering(href==null ? "#" : href, linkContent);
			if (isMissing) {
				ret.withAttribute("style", "color:red");
			}
			return ret;
		}
		
		return renderer.render(href, linkContent, rendererConfig, isMissing);
	}
	
	private String unescape(String str) {
		StringBuilder sb = new StringBuilder();
		boolean inEscape = false;
		for (int i=0; i<str.length(); ++i) {
			if (inEscape) {
				inEscape = false;
				sb.append(str.charAt(i));
			} else {
				if (str.charAt(i) == '\\') {
					inEscape = true;
				} else {
					sb.append(str.charAt(i));
				}
			}				
		}
		return sb.toString();
	}
	
	private int indexOf(String str, int from, char ch) {
		boolean inEscape = false;
		for (int i=from; i<str.length(); ++i) {
			if (inEscape) {
				inEscape = false;
			} else {
				if (str.charAt(i)=='\\') {
					inEscape = true;
				} else {
					if (str.charAt(i)==ch) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
}