package org.nasdanika.cdo.web.doc;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.nasdanika.cdo.web.doc.DocRoute.ExtensionEntry;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.Topic;

public class TocNodeFactory {
	
	private String name;
	private String id;
	private String icon;
	private String tooltip;
	private String location;
	private String content;
	private String linkTo;		
	private List<String> links = new ArrayList<>();
	private List<TocNodeFactory> children = new ArrayList<>();
	private Topic topic;
	
	public TocNodeFactory(
			DocRoute docRoute,
			String docBaseURL,
			String urlPrefix,
			String docRoutePath,
			String contributorName,
			Map<String, Map<String, DocRoute.ExtensionEntry<ContentFilter>>> contentFilters,
			IConfigurationElement iConfigurationElement) throws Exception {
		
		ContentFilter textFilter = new ContentFilter() {

			@Override
			public Object filter(Object content, DocRoute docRoute, URI baseURI, String urlPrefix) {
				return "<div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(String.valueOf(content))+"</div>";
			}

		};
		
		Map<String, DocRoute.ExtensionEntry<ContentFilter>> tm = contentFilters.get("text/plain");
		if (tm!=null) {
			ExtensionEntry<ContentFilter> ee = tm.get("text/html");
			textFilter = ee==null ? null : ee.extension;
		}
		
		ContentFilter markdownFilter = new ContentFilter() {

			@Override
			public Object filter(Object content, DocRoute docRoute, URI baseURI, String urlPrefix) {
				return "<H1>Cannot convert markdown to HTML</H1><div style=\"white-space:pre-wrap; font-family:monospace\">"+StringEscapeUtils.escapeHtml4(String.valueOf(content))+"</div>";
			}

		};
		
		tm = contentFilters.get("text/markdown");
		if (tm!=null) {
			ExtensionEntry<ContentFilter> ee = tm.get("text/html");
			markdownFilter = ee==null ? null : ee.extension;
		}
		
		URI baseURI = new URI(docBaseURL+"/bundle/"+contributorName+"/");
		name = iConfigurationElement.getAttribute("name");
		id = iConfigurationElement.getAttribute("id");
		if (id!=null) {
			id = contributorName+"/"+id;
		}
		icon = iConfigurationElement.getAttribute("icon");
		if (icon!=null) {
			icon = baseURI.resolve(icon).toString();
			if (icon.startsWith(docBaseURL)) {
				icon=icon.substring(docBaseURL.length());
			}
		}
		tooltip = iConfigurationElement.getAttribute("tooltip");
		
		if (iConfigurationElement.getAttribute("class")==null) {
			location = iConfigurationElement.getAttribute("location");
			if (location==null) {
				IConfigurationElement[] contentElements = iConfigurationElement.getChildren("markdown");
				if (contentElements.length==0) {
					contentElements = iConfigurationElement.getChildren("text");
					if (contentElements.length==0) {
						contentElements = iConfigurationElement.getChildren("html");
						if (contentElements.length!=0) {
							content = contentElements[0].getValue();
						}
					} else {
						content = (String) textFilter.filter(contentElements[0].getValue(), docRoute, baseURI, urlPrefix);
					}
				} else {
					content = (String) markdownFilter.filter(contentElements[0].getValue(), docRoute, baseURI, urlPrefix);
				}
			} else {
				location = baseURI.resolve(location).toString();
				if (location.startsWith(docBaseURL)) {
					location = location.substring(docBaseURL.length());
				}
			}
		} else {
			topic = CoreUtil.injectProperties(iConfigurationElement, (Topic) iConfigurationElement.createExecutableExtension("class"));
		}
		
		linkTo = iConfigurationElement.getAttribute("linkTo");
		for (IConfigurationElement link: iConfigurationElement.getChildren("link")) {
			links.add(link.getAttribute("id"));
		}
		
		for (IConfigurationElement child: iConfigurationElement.getChildren("topic")) {
			children.add(new TocNodeFactory(
					docRoute,
					docBaseURL,
					urlPrefix,
					docRoutePath, 
					contributorName, 
					contentFilters, 
					child));
		}
	}

	public void createTocNode(TocNode parent, List<TocNodeFactory> tocNodeFactories, boolean merge) {
		boolean doSort = false;
		TocNode node = parent;
		if (!merge) {
			node = parent.createChild(name, location, icon, tooltip, id, null, false);
			if (topic!=null) {
				if (CoreUtil.isBlank(topic.getLocation())) {
					node.setContent(topic.getContent());
				} else {
					node.setHref(topic.getLocation());
				}
			} else if (content!=null) {
				node.setContent(content);
			}
		}
		
		if (topic!=null) {
			Map<String, Topic> subTopics = topic.getSubTopics();
			if (subTopics!=null && !subTopics.isEmpty()) {
				doSort = !children.isEmpty();
				for (Entry<String, Topic> ste: subTopics.entrySet()) {
					createTocNode(node, ste.getKey(), ste.getValue());
				}
			}
		}
		
		for (TocNodeFactory child: children) {
			child.createTocNode(node, tocNodeFactories, false);
		}
		for (String link: links) {
			TocNodeFactory linkedChild = find(link);
			if (linkedChild!=null) {
				linkedChild.createTocNode(node, tocNodeFactories, true);
				doSort = true;
			}
		}
		for (TocNodeFactory tnf: tocNodeFactories) {
			for (TocNodeFactory linked: tnf.findLinked(id)) {
				linked.createTocNode(node, tocNodeFactories, true);
				doSort = true;
			}
		}
		if (doSort) {
			node.sort(false);
		}
	}
	
	private void createTocNode(TocNode parent, String name, Topic topic) {
		TocNode node = parent.createChild(name, null, topic.getIcon(), topic.getTooltip(), null, null, false);					
		if (CoreUtil.isBlank(topic.getLocation())) {
			node.setContent(topic.getContent());
		} else {
			node.setHref(topic.getLocation());
		}
		
		Map<String, Topic> subTopics = topic.getSubTopics();
		if (subTopics!=null && !subTopics.isEmpty()) {
			for (Entry<String, Topic> ste: subTopics.entrySet()) {
				createTocNode(node, ste.getKey(), ste.getValue());
			}
		}		
	}
	
	private List<TocNodeFactory> findLinked(String linkTo) {
		List<TocNodeFactory> linked = new ArrayList<>();
		if (this.linkTo!=null && this.linkTo.equals(linkTo)) {
			linked.add(this);
		}
		for (TocNodeFactory child: children) {
			linked.addAll(child.findLinked(linkTo));
		}
		return linked;
	}
	
	private TocNodeFactory find(String id) {
		if (this.id!=null && this.id.equals(id)) {
			return this;
		}
		for (TocNodeFactory child: children) {
			TocNodeFactory ret = child.find(id);
			if (ret!=null) {
				return ret;
			}
		}
		return null;
	}
	
	private boolean isLinking(String id) {
		if (id==null) {
			return false;
		}
		for (String link: links) {
			if (id.equals(link)) {
				return true;
			}
		}
		for (TocNodeFactory child: children) {
			if (child.isLinking(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean isRoot(List<TocNodeFactory> tocNodeFactories) {
		if (linkTo!=null) {
			for (TocNodeFactory tnf: tocNodeFactories) {
				if (tnf.find(linkTo)!=null || (id!=null && tnf.isLinking(id))) {
					return false;
				}
			}
		}
				
		return true;
	}

	public boolean isSection() {
		return name!=null && name.startsWith("#") && !isElementDoc();
	}
	
	public boolean isElementDoc() {
		return name!=null && "#".equals(name.trim());
	}
	
}
