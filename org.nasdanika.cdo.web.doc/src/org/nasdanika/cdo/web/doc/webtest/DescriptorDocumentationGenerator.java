package org.nasdanika.cdo.web.doc.webtest;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.json.JSONArray;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.DocumentationGenerator;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Container;
import org.nasdanika.html.FontAwesome;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.webtest.model.Description;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.TestClassResult;

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
	public Object getContent(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		if (path.endsWith("/index.html")) {
			return getIndex(obj, context, baseURI, urlPrefix, path).toString();
		}
		
		return Action.NOT_FOUND;
	}
	
	protected Fragment getIndex(T obj, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) throws Exception {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		Fragment ret = htmlFactory.fragment(header(obj));

		qualifiedName(obj, ret, context, baseURI, urlPrefix, path);		
		description(obj, ret, context, baseURI, urlPrefix);
		links(obj, ret, context, baseURI, urlPrefix);
		
		return ret;
	}

	protected Object header(T obj) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		return htmlFactory.tag(
				TagName.h3, 
				getIcon(obj)==null ? "" : htmlFactory.tag(TagName.img).attribute("src", testResultsDocumentationGenerator.getDocRoute().getDocRoutePath()+getIcon(obj)).style().margin().right("5px"),
				StringEscapeUtils.escapeHtml4(getTitle(obj)));
	}
	
	protected void qualifiedName(Descriptor obj, Container<?> content, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix, String path) {
		
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
				String html = testResultsDocumentationGenerator.getDocRoute().markdownToHtml(baseURI, urlPrefix, "[[javadoc>"+spec+"|"+qualifiedName+"]]");				
				content.content(html);
				break;
			default:
			
			}
		}
	}	
	
	protected void links(Descriptor obj, Container<?> container, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix) throws Exception {
//		getLinks() - TODO
		
	}
	
	protected void description(Descriptor obj, Container<?> container, HttpServletRequestContext context, java.net.URI baseURI, String urlPrefix) throws Exception {
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
			Object html = testResultsDocumentationGenerator.getDocRoute().filterContent(descriptionText.toString(), description.getContentType(), DocRoute.MIME_TYPE_HTML, baseURI, urlPrefix);
			if (html == null) {
				html = testResultsDocumentationGenerator.getDocRoute().filterContent(StringEscapeUtils.escapeHtml4(descriptionText.toString()), "text/plain", DocRoute.MIME_TYPE_HTML, baseURI, urlPrefix);				
			}
			
			container.content(html);
			
			if (description.getUrl() != null) {
				container.content(
						htmlFactory.div(
								htmlFactory.link(description.getUrl(), descriptionText.toString().trim().length() == 0 ? "Description" : "Additional information...")
									.attribute("target", "_blank")
									.style().margin().top("5px")));
			}
		}
	}
	
	protected enum Type { CLASS, CONSTRUCTOR, METHOD }
	
	protected abstract Type getType(Descriptor obj);
	
	protected EMap<OperationStatus, Integer> testResultStats(Descriptor obj) {
		EMap<OperationStatus, Integer> ret = new BasicEMap<>();
		if (obj instanceof TestClassResult) {
			addStats((TestClassResult) obj, ret);
		} else {		
			TreeIterator<EObject> cit = obj.eAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof TestClassResult) {
					addStats((TestClassResult) next, ret);					
					cit.prune();
				}
			}
		}		
		return ret;
	}

	public void addStats(TestClassResult testClassResult, EMap<OperationStatus, Integer> ret) {
		for (Entry<String, Integer> se: testClassResult.getStats()) {
			if (se.getValue() != 0) {
				Integer val = ret.get(se.getKey());
				if (val == null) {
					ret.put(OperationStatus.get(se.getKey()), se.getValue());
				} else {
					ret.put(OperationStatus.get(se.getKey()), se.getValue() + val);
				}
			}
		};
	}
	
	protected void statsChart(EMap<OperationStatus, Integer> sessionStats, Container<?> container) {	
		HTMLFactory htmlFactory = testResultsDocumentationGenerator.getDocRoute().getHtmlFactory();
		Tag chartDiv = htmlFactory.div().id("test_stats_chart_"+htmlFactory.nextId());
		container.content(chartDiv);
		JSONArray columns = new JSONArray();
		sessionStats.sort(new Comparator<Entry<OperationStatus, Integer>>() {

			@Override
			public int compare(Entry<OperationStatus, Integer> o1, Entry<OperationStatus, Integer> o2) {				
				return o1.getKey().getValue() - o2.getKey().getValue();
			}
			
		});
		for (Entry<OperationStatus, Integer> se: sessionStats) {
			JSONArray statColumn = new JSONArray();
			columns.put(statColumn);
			statColumn.put(se.getKey().getName());
			statColumn.put(se.getValue());
		}
		
		Map<String, Object> env = new HashMap<>();
		env.put("columns", columns.toString());
		env.put("selector", "#"+chartDiv.getId());
					
		container.content(htmlFactory.tag(TagName.script, htmlFactory.interpolate(getClass().getResource("stats-chart.js"), env)));
	}	
	
	protected static Tag operationStatusGlyph(OperationStatus operationStatus) {
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
		FontAwesome<Tag> flask = htmlFactory.fontAwesome().webApplication(WebApplication.flask);
		switch (operationStatus) {		
		case ERROR:		
			flask.style(Style.WARNING);
			break;
		case FAIL:
			flask.style(Style.DANGER);
			break;
		case PASS:
			flask.style(Style.SUCCESS);
			break;
		case PENDING:
			flask.style(Style.MUTED);
			break;
		default:
			break;		
		}
		return flask.getTarget();		
	}

}
