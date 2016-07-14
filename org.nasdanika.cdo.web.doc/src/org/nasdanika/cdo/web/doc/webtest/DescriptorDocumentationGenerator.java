package org.nasdanika.cdo.web.doc.webtest;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Description;
import org.nasdanika.webtest.model.Descriptor;

abstract class DescriptorDocumentationGenerator<T extends Descriptor> implements DocumentationGenerator<T> {

	protected TestResultsDocumentationGenerator testResultsDocumentationGenerator;

	protected DescriptorDocumentationGenerator(TestResultsDocumentationGenerator testResultsDocumentationGenerator) {
		this.testResultsDocumentationGenerator = testResultsDocumentationGenerator;
	}

	@Override
	public void createToc(T descriptor, TocNode parent) {
		try {
			TocNode descriptorToc = parent.createChild(
					getTitle(descriptor), 
					testResultsDocumentationGenerator.getObjectPath(descriptor)+"/index.html",
					getIcon(descriptor), 
					null,
					obj -> obj == descriptor);
			
			for (EObject el: getTocChildren(descriptor)) {
				DocumentationGenerator<Object> elTocBuilderRoute = testResultsDocumentationGenerator.getDocumentationGenerator(el.eClass());
				if (elTocBuilderRoute != null) {
					elTocBuilderRoute.createToc(el, descriptorToc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getTitle(T descriptor) {
		return descriptor.getTitle();
	}
	
	protected Collection<? extends EObject> getTocChildren(T catalogElement) {
		return Collections.emptyList();		
	}	

	protected String getIcon(T descriptor) {
		return null;
	}
			
	@Override
	public Object getContent(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		if (path.endsWith("/index.html")) {
			return getIndex(obj, context, baseURL, urlPrefix, path).toString();
		}
		
		return Action.NOT_FOUND;
	}
	
	protected Fragment getIndex(T obj, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(header(obj));

		qualifiedName(obj, ret, context, baseURL, urlPrefix, path);		
		description(obj, ret, context, baseURL, urlPrefix);
		links(obj, ret, context, baseURL, urlPrefix);
		
		return ret;
	}

	protected Object header(T obj) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		return htmlFactory.tag(
				TagName.h3, 
				getIcon(obj)==null ? "" : htmlFactory.tag(TagName.img).attribute("src", testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon(obj)).style().margin().right("5px"),
				StringEscapeUtils.escapeHtml4(getTitle(obj)));
	}
	
	protected void qualifiedName(Descriptor obj, Fragment content, HttpServletRequestContext context, URL baseURL, String urlPrefix, String path) {
		
		// Qualified name
		String qualifiedName = obj.getQualifiedName();
		if (!CoreUtil.isBlank(qualifiedName)) {
			Type type = getType(obj);
			switch (type) {
			case CLASS:
				content.content(testResultsDocumentationGenerator.getDocRoute().javaDocLink(qualifiedName, true, false));
				break;
			case CONSTRUCTOR:
			case METHOD:
				int firstParenthesisIdx = qualifiedName.indexOf("(");
				int lastParenthesisIdx = qualifiedName.indexOf(")", firstParenthesisIdx);
				int lastSpaceIdx = qualifiedName.substring(0, firstParenthesisIdx).lastIndexOf(' ');
				int lastDotIdx = qualifiedName.substring(0, firstParenthesisIdx).lastIndexOf(".");
				
				String spec = qualifiedName.substring(lastSpaceIdx+1, lastDotIdx)+"#"+qualifiedName.substring(lastDotIdx+1, lastParenthesisIdx+1);
				String html = testResultsDocumentationGenerator.getDocRoute().markdownToHtml(baseURL, urlPrefix, "[[javadoc>"+spec+"|"+qualifiedName+"]]");				
				content.content(html);
				break;
			default:
			
			}
		}
	}	
	
	protected void links(Descriptor obj, Fragment content, HttpServletRequestContext context, URL baseURL, String urlPrefix) throws Exception {
//		getLinks() - TODO
		
	}
	
	protected void description(Descriptor obj, Fragment content, HttpServletRequestContext context, URL baseURL, String urlPrefix) throws Exception {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Description description = obj.getDescription();
		if (description != null) {
			StringBuilder descriptionText = new StringBuilder();
			for (String de: description.getValue()) {
				if (descriptionText.length()>0) {
					descriptionText.append(System.lineSeparator());
				}
				descriptionText.append(de);
			}
			Object html = testResultsDocumentationGenerator.getDocRoute().filterContent(descriptionText.toString(), description.getContentType(), DocRoute.MIME_TYPE_HTML, baseURL, urlPrefix);
			if (html == null) {
				html = testResultsDocumentationGenerator.getDocRoute().filterContent(StringEscapeUtils.escapeHtml4(descriptionText.toString()), "text/plain", DocRoute.MIME_TYPE_HTML, baseURL, urlPrefix);				
			}
			
			content.content(html);
			
			if (description.getUrl() != null) {
				content.content(
						htmlFactory.div(
								htmlFactory.link(description.getUrl(), descriptionText.toString().trim().length() == 0 ? "Description" : "Additional information...")
									.attribute("target", "_blank")
									.style().margin().top("5px")));
			}
		}
	}
	
	protected enum Type { CLASS, CONSTRUCTOR, METHOD }
	
	protected abstract Type getType(Descriptor obj);

}
