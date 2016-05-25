package org.nasdanika.cdo.web.doc.story;

import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.OperationResult;

class OperationResultDocumentationGenerator<T extends OperationResult> implements StoryElementDocumentationGenerator<T> {

	protected StoryDocumentationGenerator storyDocumentationGenerator;

	protected OperationResultDocumentationGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public void createToc(T operationResult, TocNode parent) {
		try {
			parent.createChild(
					operationResult.getTitle(), 
					storyDocumentationGenerator.getObjectPath(operationResult)+"/index.html",
					getIcon(), 
					null,
					obj -> obj == operationResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
					StringEscapeUtils.escapeHtml4(obj.getTitle())));
		
		ret.content(htmlFactory.div("<B>Status: </B>", StringEscapeUtils.escapeHtml4(obj.getStatus().name())).style().margin().bottom("10px"));
		
		// TODO - description
//		if (!CoreUtil.isBlank(obj.getDescription())) {
//			ret.content(storyDocumentationGenerator.getDocRoute().markdownToHtmlDiv(baseURL, urlPrefix, obj.getDescription()).style().margin().top("10px").style().margin().bottom("10px"));
//		}
		
		return ret;
	}

}
