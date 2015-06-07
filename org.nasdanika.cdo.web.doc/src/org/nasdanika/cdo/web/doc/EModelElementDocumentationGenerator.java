package org.nasdanika.cdo.web.doc;

import static org.pegdown.FastEncoder.encode;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.jsoup.Jsoup;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Style;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ast.ExpImageNode;
import org.pegdown.ast.ExpLinkNode;
import org.pegdown.ast.RefImageNode;
import org.pegdown.ast.RefLinkNode;
import org.pegdown.ast.WikiLinkNode;

public class EModelElementDocumentationGenerator {
	
	private static final String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	private Pattern sentencePattern;
	private int maxFirstSentenceLength = 250;

	public EModelElementDocumentationGenerator() {
		sentencePattern = Pattern.compile("[^\\.?!]+[\\.?!]+");
	}
	
	public void setMaxFirstSentenceLength(int maxFirstSentenceLength) {
		this.maxFirstSentenceLength = maxFirstSentenceLength;
	}
	
	public int getMaxFirstSentenceLength() {
		return maxFirstSentenceLength;
	}
	
	public String markdownToHtml(String markdownSource) {
		PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL);
		return pegDownProcessor.markdownToHtml(markdownSource, new LinkRenderer() {
			
		    public Rendering render(ExpLinkNode node, String text) {
		        Rendering rendering = new Rendering(rewrite(node.url), text);
		        Rendering ret = CoreUtil.isBlank(node.title) ? rendering : rendering.withAttribute("title", encode(node.title));
		        String target = getLinkTarget(node.url);
		        if (!CoreUtil.isBlank(target)) {
		        	ret.withAttribute("target", target);
		        }
				return ret;
		    }

		    public Rendering render(ExpImageNode node, String text) {
		        Rendering rendering = new Rendering(rewrite(node.url), text);
		        Rendering ret = CoreUtil.isBlank(node.title) ? rendering : rendering.withAttribute("title", encode(node.title));
		        String target = getLinkTarget(node.url);
		        if (!CoreUtil.isBlank(target)) {
		        	ret.withAttribute("target", target);
		        }
				return ret;
		    }

		    public Rendering render(RefLinkNode node, String url, String title, String text) {
		        Rendering rendering = new Rendering(rewrite(url), text);
		        Rendering ret = CoreUtil.isBlank(title) ? rendering : rendering.withAttribute("title", encode(title));
		        String target = getLinkTarget(url);
		        if (!CoreUtil.isBlank(target)) {
		        	ret.withAttribute("target", target);
		        }
				return ret;
		    }

		    public Rendering render(RefImageNode node, String url, String title, String alt) {
		        Rendering rendering = new Rendering(rewrite(url), alt);
		        Rendering ret = CoreUtil.isBlank(title) ? rendering : rendering.withAttribute("title", encode(title));
		        String target = getLinkTarget(url);
		        if (!CoreUtil.isBlank(target)) {
		        	ret.withAttribute("target", target);
		        }
				return ret;
		    }

		    public Rendering render(WikiLinkNode node) {
	        	WikiLink wikiLink = new WikiLink(node.getText());		        	
	            String url = resolve(wikiLink.getResolver(), wikiLink.getHref());
	            String linkText = StringEscapeUtils.escapeHtml4(linkText(url, wikiLink.getText()));
	            String icon = linkIcon(url);
	            if (icon!=null) {
	            	linkText = "<img src=\""+icon+"\"> "+linkText;
	            }
				Rendering ret = new Rendering(rewrite(url), linkText);
	            if (isMissing(url)) {
	            	ret.withAttribute("style", "color:red");
	            }
		        String target = getLinkTarget(url);
		        if (!CoreUtil.isBlank(target)) {
		        	ret.withAttribute("target", target);
		        }
				return ret;
		    }
			
		});
	}
	
	protected String resolve(String resolver, String url) {
		if ("url".equals(resolver)) {
			return url;
		}
		if ("bundle".equals(resolver)) {
			return "bundle://"+url;
		}
		return resolver+">"+url;
	}
	
	/**
	 * Parses wiki link ([[...]]) in format <code>resolver>location|text</code>, e.g.
	 * <UL>
	 * <LI><code>[[global>urn:org.nasdanika.cdo.security/ProtectionDomain]]</code> - resolver is 'global' - resolves a link to ProtectionDomain EClass in 
	 * a package with NsURI urn:org.nasdanika.cdo.security in the global package registry.</LI>
	 * <LI><code>[[global>urn:org.nasdanika.cdo.security/ProtectionDomain|Protection Domain package]]</code> - same as above with link text 'Protection Domain package' 
	 * </UL>
	 * Use backslash to escape control characters - &gt; and |.
	 * All parts are optional, but the renderer specification is considered to be present only if the resolver is present, i.e. if there is no escaped &gt; in the link.
	 * @author Pavel
	 *
	 */
	public static class WikiLink {
		
		private String resolver = "url";
		private String href;
		private String text;
		
		public WikiLink(String wikiLink) {
			int gtIdx = indexOf(wikiLink, 0, '>');
			if (gtIdx!=-1) {
				resolver=unescape(wikiLink.substring(0, gtIdx));
			}			
			int pipeIdx = indexOf(wikiLink, gtIdx+1, '|');
			if (pipeIdx==-1) {
				href = unescape(wikiLink.substring(gtIdx+1));
			} else {
				href = unescape(wikiLink.substring(gtIdx+1, pipeIdx));
				text = wikiLink.substring(pipeIdx+1);
			}
			// TODO Auto-generated constructor stub
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
		
		public String getResolver() {
			return resolver;
		}
		
		public String getHref() {
			return href;
		}
		
		public String getText() {
			return text;
		}
		
	}
	
	/**
	 * Subclasses can override this method to rewrite href's.
	 * @param href
	 * @return
	 */
	protected String rewrite(String href) {
		return href;
	}
	
	/**
	 * Subclasses can override this method to look-up wiki link text in the table of contents.
	 * @param text
	 * @return
	 */
	protected String linkText(String href, String text) {
		if (CoreUtil.isBlank(text)) {
			int slashIdx = href.lastIndexOf('/');
			if (slashIdx!=-1) {
				href = href.substring(slashIdx+1);				
			}
			int dotIdx = href.lastIndexOf('.');
			if (dotIdx!=-1) {
				href = href.substring(0, dotIdx);
			}
			return href.replace('_', ' ');
		}
		return text;
	}
	
	/**
	 * Subclasses can override this method to look up wiki link icon.
	 * @param href
	 * @return
	 */
	protected String linkIcon(String href) {
		return null;
	}
	
	/**
	 * Subclasses can override this method to render broken links in red
	 * @param href
	 * @return
	 */
	protected boolean isMissing(String href) {
		return false;
	}
	
	public String getModelDocumentation(EModelElement modelElement) {
		EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
		if (docAnn==null) {
			return null;
		}
		String markdown = docAnn.getDetails().get("documentation");
		if (CoreUtil.isBlank(markdown)) {
			return null;
		}
		return markdownToHtml(markdown);		
	}
	
	public String getFirstDocSentence(EModelElement modelElement) {
		String html = getModelDocumentation(modelElement);
		if (CoreUtil.isBlank(html)) {
			return "";
		}
		String text = Jsoup.parse(html).text();
		Matcher matcher = sentencePattern.matcher(text);
		if (matcher.find()) {
			String group = matcher.group();
			if (group.length()<maxFirstSentenceLength) {
				return group;
			}
		}
		
		return "";
	}
	
	/**
	 * Subclasses can override this method to add "target" attribute to links. 
	 * @param href
	 * @return
	 */
	protected String getLinkTarget(String href) {
		return null;
	}
	
	protected String documentAnnotation(HTMLFactory htmlFactory, EAnnotation eAnnotation) {
		if (ECORE_DOC_ANNOTATION_SOURCE.equals(eAnnotation.getSource())) {
			return ""; // Already generated as doc.
		}
		
		// TODO - extensions
		
		
		// Forms, routes, form controls - in sub-classes.
		
		// Default - table.
		Table detailsTable = htmlFactory.table().bordered();
		for (String key: new TreeSet<String>(eAnnotation.getDetails().keySet())) {
			Row row = detailsTable.row();
			row.cell(StringEscapeUtils.escapeHtml4(key));
			row.cell(StringEscapeUtils.escapeHtml4(eAnnotation.getDetails().get(key))).style("white-space", "pre-wrap").style("font-family", "monospace");
		}
		return htmlFactory.panel(Style.INFO, "Annotation " + StringEscapeUtils.escapeHtml4(eAnnotation.getSource()), detailsTable, null).toString();		
	}

}
