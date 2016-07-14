package org.nasdanika.cdo.web.doc.story;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;

abstract class CatalogElementDocumentationGenerator<T extends CatalogElement> implements DocumentationGenerator<T> {

	protected StoryDocumentationGenerator storyDocumentationGenerator;

	protected CatalogElementDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public void createToc(T catalogElement, TocNode parent) {
		try {
			TocNode catalogElementToc = parent.createChild(
					catalogElement.getName(), 
					storyDocumentationGenerator.getObjectPath(catalogElement)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == catalogElement);

			for (EObject el: getTocChildren(catalogElement)) {
				DocumentationGenerator<Object> elTocBuilderRoute = storyDocumentationGenerator.getDocumentationGenerator(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, catalogElementToc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Collection<? extends EObject> getTocChildren(T catalogElement) {
		return Collections.emptyList();		
	}

	protected String getIcon() {
		return null;
	}
			
	@Override
	public Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		if (path.endsWith("/index.html")) {
			return getIndex(obj, context, baseURL, urlPrefix, path).toString();
		}
		
		return Action.NOT_FOUND;
	}

	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(
			htmlFactory.tag(
					TagName.h3, 
					htmlFactory.tag(TagName.img).attribute("src", storyDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon()).style().margin().right("5px"),
					StringEscapeUtils.escapeHtml4(obj.getName()),
					" (", obj.eClass().getName(), ")"));
		
		String resolvedID = StoryDocumentationGenerator.resolveCatalogElementID(obj);
		if (!CoreUtil.isBlank(resolvedID)) {
			ret.content(htmlFactory.div("<B>ID: </B>", StringEscapeUtils.escapeHtml4(resolvedID)).style().margin().bottom("10px"));
		}
		
		if (!CoreUtil.isBlank(obj.getDescription())) {
			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getDescription()).style().margin().top("10px").style().margin().bottom("10px"));
		}
		
		return ret;
	}

}
