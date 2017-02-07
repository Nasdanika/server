package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.jsoup.Jsoup;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.web.HttpServletRequestContext;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.PegDownProcessor;
import org.pegdown.ast.AnchorLinkNode;
import org.pegdown.ast.AutoLinkNode;
import org.pegdown.ast.ExpLinkNode;
import org.pegdown.ast.RefLinkNode;
import org.pegdown.ast.WikiLinkNode;

/**
 * Renders HTML elements for a target object such as form inputs, tables, e.t.c.
 * @author Pavel
 *
 * @param <T>
 */
public interface Renderer<C extends Context, T extends EObject> {
	
	public static final String ANNOTATION_KEY_VIEW_TAB = "view-tab";
	
	public static final String ANNOTATION_KEY_IS_TAB = "is-tab";

	public static final String INDEX_HTML = "index.html";

	/**
	 * Documentation annotation key.
	 */
	String ANNOTATION_KEY_DOCUMENTATION = "documentation";
	
	/**
	 * Default pegdown options.
	 */
	int PEGDOWN_OPTIONS = 	Extensions.ALL ^ Extensions.HARDWRAPS ^ Extensions.SUPPRESS_HTML_BLOCKS ^ Extensions.SUPPRESS_ALL_HTML;

	/**
	 * Source for Ecore GenModel documentation.
	 */
	String ECORE_DOC_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";	
	
	/**
	 * Set this annotation details key to ``false`` to hide structural feature from view.
	 */
	String ANNOTATION_KEY_VISIBLE = "visible";

	/**
	 * Set this annotation details key to ``false`` to hide make visible structural feature read-only in the edit form.
	 */
	String ANNOTATION_KEY_EDITABLE = "editable";
	
	/**
	 * On EClass this annotation is a pattern which is interpolated to generate object label.
	 * On features and operations this annotation defines feature/operation label, a.k.a. "Display name". 
	 */
	String ANNOTATION_KEY_LABEL = "label";
	
	/**
	 * Defines named element label/display name.
	 */
	String ANNOTATION_KEY_ENAMED_ELEMENT_LABEL = "enamed-element-label";
	
	Pattern SENTENCE_PATTERN = Pattern.compile(".+?[\\.?!]+\\s+");	
	
	int MIN_FIRST_SENTENCE_LENGTH = 20;
	int MAX_FIRST_SENTENCE_LENGTH = 250;
	
	String[] ABBREVIATIONS = { "e.g.", "i.e." }; // TODO - load from extensions?
	
	// multi-line
	// input type
	// select options	
	
	
	public static final String ACTION_VIEW = "view";

	/**
	 * Rendering can be customized by annotating model element with
	 * annotations with this source.
	 * Adding ui annotations to the model mixes modeling and UI concerns.
	 * Also annotations allow to define only one way of rendering a particular model element.
	 * Other customization options include overriding <code>getRenderAnnotation()</code> method or rendering methods, and
	 * UI code generation, which leverages method overriding.  
	 */
	String RENDER_ANNOTATION_SOURCE = "org.nasdanika.cdo.web.render";
	
	Renderer<Context, EObject> INSTANCE = new Renderer<Context, EObject>() {
		
	};
	
	@SuppressWarnings("unchecked")
	default Renderer<C, EObject> getRenderer(EClass eClass) {
		// TODO extension point.
		return (Renderer<C, EObject>) INSTANCE;
	}

	/**
	 * Returns renderer for an object.
	 * @param modelObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default <M extends EObject> Renderer<C, M> getRenderer(M modelObject) {		
		return modelObject == null ? null : (Renderer<C, M>) getRenderer(modelObject.eClass());
	}
		
	/**
	 * Retrieves render annotation. This implementation reads render annotations from "org.nasdanika.cdo.web.render"
	 * annotation on the model element. This method can be overridden to read annotations from another source,
	 * e.g.  
	 * @param context
	 * @param modelElement
	 * @param key
	 * @return
	 */
	default String getRenderAnnotation(C context, EModelElement modelElement, String key) {
		EAnnotation ra = modelElement.getEAnnotation(RENDER_ANNOTATION_SOURCE);
		return ra == null ? null : ra.getDetails().get(key);
	}
	
	/**
	 * Derives label (display name) from a name. This implementation splits by camel case,
	 * lowercases 1+ segments and capitalizes the 0 segment. E.g. myCoolName becomes My cool name.
	 * @param name
	 * @return
	 */
	default String nameToLabel(String name) {
		String[] cca = StringUtils.splitByCharacterTypeCamelCase(name);
		cca[0] = StringUtils.capitalize(cca[0]);
		for (int i=1; i<cca.length; ++i) {
			cca[i] = cca[i].toLowerCase();
		}
		String classLabel = StringUtils.join(cca, " ");
		return classLabel;
	}

	/**
	 * 
	 * @param obj
	 * @return A list of structural features to include into the object view. This implementation
	 * returns all object features authorized to view.
	 * @throws Exception 
	 */
	default List<EStructuralFeature> getVisibleStructuralFeatures(C context, T obj) throws Exception {
		List<EStructuralFeature> ret = new ArrayList<>();
		for (EStructuralFeature sf: obj.eClass().getEAllStructuralFeatures()) {
			if (!"false".equals(getRenderAnnotation(context, sf, ANNOTATION_KEY_VISIBLE)) && context.authorize(obj, ACTION_VIEW, sf.getName(), null)) {
				ret.add(sf);
			}
		}
		return ret;
	}
	
	/**
	 * Renders object path to breadcrumbs. This implementation traverses the object containment path up to the top level object in the resource.
	 * @param target
	 * @param context
	 * @param breadCrumbs
	 * @return true if breadcrumbs shall be added to the page, i.e. if it has any items.
	 * @throws Exception
	 */
	default void renderObjectPath(C context, T obj, Breadcrumbs breadCrumbs) throws Exception {
		List<EObject> cPath = new ArrayList<EObject>();
		for (EObject c = obj.eContainer(); c != null; c = c.eContainer()) {
			cPath.add(c);
		}
		Collections.reverse(cPath);
		for (EObject c: cPath) {
			Renderer<C, EObject> cRenderer = getRenderer(c);
			Object cLabel = cRenderer.renderLabel(context, c);
			if (cLabel != null) {
				String objectURI = cRenderer.getObjectURI(context, c);
				breadCrumbs.item(objectURI == null ? objectURI : objectURI+"/"+INDEX_HTML, cLabel);
			}
		}
		breadCrumbs.item(null, renderLabel(context, obj));
	}

	/**
	 * Renders object label. This implementation interpolates the value of ``label`` annotation if it is found in 
	 * the object's EClass or any of its subclasses. The objects is used as the interpolation token source with 
	 * visible features names as token names and values as values. 
	 * 
	 * If ``label`` annotation is not found, then the value
	 * of the first feature is used as object label.  
	 *  
	 * Label value is HTML-escaped. 
	 * @param context
	 * @param obj
	 * @return Object label or null if there are no visible features (e.g. the principal does not have permission to view the object.
	 * @throws Exception
	 */
	default Object renderLabel(C context, T obj) throws Exception {
		String labelAnnotation = getRenderAnnotation(context, obj.eClass(), ANNOTATION_KEY_LABEL);
		if (labelAnnotation == null) {
			for (EClass st: obj.eClass().getEAllSuperTypes()) {
				labelAnnotation = getRenderAnnotation(context, st, ANNOTATION_KEY_LABEL);
				if (labelAnnotation != null) {
					break;
				}
			}
		}
		
		if (labelAnnotation != null) {
			Map<String, EStructuralFeature> vsfm = new HashMap<>();
			for (EStructuralFeature vsf: getVisibleStructuralFeatures(context, obj)) {
				vsfm.put(vsf.getName(), vsf);
			}
			String label = getHTMLFactory(context).interpolate(labelAnnotation, token -> {
				EStructuralFeature vsf = vsfm.get(token);
				return vsf == null ? null : obj.eGet(vsf);
			});
			return StringEscapeUtils.escapeHtml4(label);
		}
		
		for (EStructuralFeature vsf: getVisibleStructuralFeatures(context, obj)) {
			Object label = obj.eGet(vsf);
			return label == null ? label : StringEscapeUtils.escapeHtml4(String.valueOf(label));
		}
		
		return null;
		
	}
	
	/**
	 * @param context
	 * @param obj
	 * @return Object URI. This implementation returns object path if context is instanceof {@link HttpServletRequestContext} 
	 * and ``null`` otherwise.
	 * @throws Exception
	 */
	default String getObjectURI(C context, T obj) throws Exception {
		if (context instanceof HttpServletRequestContext) {
			return ((HttpServletRequestContext) context).getObjectPath(obj);		
		}
		
		return null;
	}
	
	/**
	 * Renders object link using object label and path.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderLink(C context, T obj) throws Exception {
		String objectURI = getObjectURI(context, obj);
		return getHTMLFactory(context).link(objectURI == null ? "#" : objectURI+"/"+INDEX_HTML, renderLabel(context, obj));
	}

	/**
	 * 
	 * @param context
	 * @param namedElement
	 * @return Value of ``label`` render annotation if it is present or element name passed through nameToLabel() conversion.
	 * @throws Exception
	 */
	default Object renderNamedElementLabel(C context, ENamedElement namedElement) throws Exception {
		String label = getRenderAnnotation(context, namedElement, ANNOTATION_KEY_ENAMED_ELEMENT_LABEL);
		return label == null ? nameToLabel(namedElement.getName()) : label;
	}
	
	/**
	 * Renders individual feature value. This implementation converts value to string and then html-escapes it.
	 * nulls are rendered as blank.
	 * @param context
	 * @param feature
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	default Object renderFeatureValue(C context, EStructuralFeature feature, Object value) throws Exception {
		if (value instanceof EObject) {
			return getRenderer(((EObject) value).eClass()).renderLink(context, (EObject) value);
		}
		return value == null ? "" : StringEscapeUtils.escapeHtml4(value.toString());
	}

	/**
	 * Renders element documentation. Documentation is retrieved from "documentation" annotation key 
	 * and if not found from Ecore GenModel annotation.
	 * @param context
	 * @param modelElement
	 * @return gendoc annotation rendered as markdown to HTML or null if there is no documentation.
	 * @throws Exception
	 */
	default String renderDocumentation(C context, EModelElement modelElement) throws Exception {
		String markdown = getRenderAnnotation(context, modelElement, ANNOTATION_KEY_DOCUMENTATION);
		
		if (markdown == null) {
			EAnnotation docAnn = modelElement.getEAnnotation(ECORE_DOC_ANNOTATION_SOURCE);
			if (docAnn==null) {
				return null;
			}
			markdown = docAnn.getDetails().get(ANNOTATION_KEY_DOCUMENTATION);
		}
		
		if (CoreUtil.isBlank(markdown)) {
			return null;
		}
		
		return markdownToHtml(context, markdown);				
	}
	
	default HTMLFactory getHTMLFactory(C context) throws Exception {
		return HTMLFactory.INSTANCE;
	}
	
	/**
	 * @param context
	 * @param obj
	 * @return Documentation reference for EClass or null.
	 * @throws Exception
	 */
	default String getEClassDocRef(C context, EClass eClass) throws Exception {
		return null;
	}
	
	/**
	 * Renders documentation modal if the element has documenation.
	 * @param context
	 * @param modelElement
	 * @return documentation modal or null if the element is not documented.
	 * @throws Exception 
	 */
	default Modal renderDocumentationModal(C context, EModelElement modelElement) throws Exception {
		String doc = renderDocumentation(context, modelElement);
		if (doc == null) {
			return null;
		}
		Modal docModal = getHTMLFactory(context).modal();
		if (doc.length() < 500) {
			docModal.small();				
		} else if (doc.length() > 2000) {
			docModal.large();
		}
		docModal.title(getHTMLFactory(context).tag(TagName.h4, modelElement instanceof ENamedElement ? renderNamedElementLabel(context, (ENamedElement) modelElement) : "Documentation"));
		docModal.body(getHTMLFactory(context).div(doc).addClass("markdown-body"));
		EClass eClass = null;
		if (modelElement instanceof EClass) {
			eClass = (EClass) modelElement;
		} else if (modelElement.eContainer() instanceof EClass) {
			eClass = (EClass) modelElement.eContainer();
		}
		if (eClass != null) {
			String href = getEClassDocRef(context, eClass);
			if (href != null) {
				docModal.footer(getHTMLFactory(context).link(href, getResourceString(context, "informationCenter", false)).attribute("target", "_blank"));
			}
		}
		return docModal;
	}
	
	/**
	 * If element has documentation this method renders a question mark glyph icon with a tooltip containing the first sentence of documentation.
	 * If docModal is not null, then the cursor is set to pointer and click on the icon opens the doc modal.
	 * @param context
	 * @param modelElement
	 * @return
	 * @throws Exception
	 */
	default Tag renderDocumentationIcon(C context, EModelElement modelElement, Modal docModal) throws Exception {
		String doc = renderDocumentation(context, modelElement);
		if (doc == null) {
			return null;
		}
		Tag helpGlyph = getHTMLFactory(context).fontAwesome().webApplication(WebApplication.question_circle_o).getTarget();//.style().margin().left("5px");
		helpGlyph.attribute("title", firstHtmlSentence(doc));
		if (docModal != null) {
			helpGlyph.on(Event.click, "$('#"+docModal.getId()+"').modal('show')");
			helpGlyph.style("cursor", "pointer");
		}
		return getHTMLFactory(context).tag(TagName.sup, helpGlyph);
	}
	
	/**
	 * Converts markdown to HTML using {@link PegDownProcessor}.
	 * @param context
	 * @param markdown
	 * @return
	 * @throws Exception 
	 */
	default String markdownToHtml(C context, String markdown) throws Exception {		
		return new PegDownProcessor(PEGDOWN_OPTIONS).markdownToHtml(markdown, createPegDownLinkRenderer(context));		
	}
	
	/**
	 * Creates link renderer. This implementation creates a renderer which opens links in new tabs
	 * @param context
	 * @return
	 * @throws Exception
	 */
	default LinkRenderer createPegDownLinkRenderer(C context) throws Exception {
		return new LinkRenderer() {
			
			@Override
			public Rendering render(AnchorLinkNode node) {
				return super.render(node).withAttribute("target", "_blank");
			}
			
			@Override
			public Rendering render(AutoLinkNode node) {
				return super.render(node).withAttribute("target", "_blank");
			}
			
			@Override
			public Rendering render(ExpLinkNode node, String text) {
				return super.render(node, text).withAttribute("target", "_blank");
			}
			
			@Override
			public Rendering render(RefLinkNode node, String url, String title, String text) {
				return super.render(node, url, title, text).withAttribute("target", "_blank");
			}
			
			@Override
			public Rendering render(WikiLinkNode arg0) {
				return super.render(arg0).withAttribute("target", "_blank");
			}
			
		};		
	}
	
	/**
	 * Extracts the first sentence from HTML as plain text.
	 * @param html
	 * @return
	 */
	default String firstHtmlSentence(String html) {
		if (CoreUtil.isBlank(html)) {
			return "";
		}

		return firstSentence(Jsoup.parse(html).text());
	}

	default int getMinFirstSentenceLength() {
		return MIN_FIRST_SENTENCE_LENGTH;
	}
	
	default int getMaxFirstSentenceLength() {
		return MAX_FIRST_SENTENCE_LENGTH;
	}
	
	default String firstSentence(String text) {
		if (text == null || text.length() < getMinFirstSentenceLength()) {
			return text;
		}
		Matcher matcher = SENTENCE_PATTERN.matcher(text);		
		Z: while (matcher.find(getMinFirstSentenceLength())) {
			String group = matcher.group();
			for (String abbr: ABBREVIATIONS) {
				if (group.trim().endsWith(abbr)) {
					continue Z;
				}
			}
			if (matcher.end() < getMaxFirstSentenceLength()) {
				return text.substring(0, matcher.end());
			}
		}
		
		return text.length() < getMaxFirstSentenceLength() ? text : text.substring(0, getMaxFirstSentenceLength())+"...";
	}
	
//	getHTMLFactory().div(markdownToHtml(context, markdown)).addClass("markdown-body");
	
	default Object renderFirstDocumentationSentence(C context, EModelElement modelElement) throws Exception {
		Object doc = renderDocumentation(context, modelElement);
		return doc instanceof String ? firstHtmlSentence((String) doc) : null;
	}
	
	/**
	 * @param context
	 * @param obj
	 * @return true if view shall be rendered in a tab. This implementation return true if <code>view-tab</code> is set to true.
	 * If there is no annotation this method returns true if number of attributes is more then ten.
	 */
	default boolean isViewTab(C context, T obj) throws Exception {
		String viewTabAnnotation = getRenderAnnotation(context, obj.eClass(), ANNOTATION_KEY_VIEW_TAB);
		return viewTabAnnotation == null ? obj.eClass().getEAllAttributes().size() > 9 : "true".equals(viewTabAnnotation);
	}
	
	/**
	 * @param context
	 * @param obj
	 * @return true if feature shall be rendered in a tab. 
	 * This implementation return true if <code>is-tab</code> is set to true. 
	 * If there is no annotation this method returns true if <code>isMany()</code> returns true.
	 */
	default boolean isTab(C context, EStructuralFeature structuralFeature) throws Exception {
		String isTabAnnotation = getRenderAnnotation(context, structuralFeature, ANNOTATION_KEY_IS_TAB);
		return isTabAnnotation == null ? structuralFeature.isMany() : "true".equals(isTabAnnotation);
	}
	
	/**
	 * Renders label for the view tab, if view is rendered in a tab.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderViewTabLabel(C context, T obj) throws Exception {
		return getResourceString(context, "viewTabLabel", false);
	}
	
	/**
	 * 
	 * @param context
	 * @param obj
	 * @return Locale to use in resource strings. This implementation uses request locale if context is {@link HttpServletRequestContext} or default JVM locale.
	 * @throws Exception
	 */
	default Locale getLocale(C context) throws Exception {
		return context instanceof HttpServletRequestContext ? ((HttpServletRequestContext) context).getRequest().getLocale() : Locale.getDefault(); 
	}
	
	/**
	 * 
	 * @param context
	 * @param obj
	 * @param key
	 * @param interpolate If true, the value of the key, if found, is interpolated using a context that resolves tokens to resource strings.
	 * @return Resource string for a given key. This implementation uses resource bundle.
	 * @throws Exception
	 */
	default String getResourceString(C context, String key, boolean interpolate) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle(Renderer.class.getName(), getLocale(context));
		if (!rb.containsKey(key)) {
			return null;
		}
				
		String rs = rb.getString(key);
		if (interpolate) {
			return getHTMLFactory(context).interpolate(rs, token -> {
				try {
					return getResourceString(context, token, true);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			});
		}
		return rs;
	}
	
	/**
	 * Renders feature documentation modal dialogs.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Map<EStructuralFeature, Modal> renderFeatureDocModals(C context, T obj) throws Exception {
		Map<EStructuralFeature, Modal> featureDocModals = new HashMap<>();
		for (EStructuralFeature vf: getVisibleStructuralFeatures(context, obj)) {
			Modal fdm = renderDocumentationModal(context, vf);
			if (fdm != null) {
				featureDocModals.put(vf, fdm);
			}
		}		
		return featureDocModals;
	}
	
	/**
	 * Renders object view.
	 * @param context
	 * @param obj
	 * @param featureDocModals
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	default Object renderView(C context, T obj, Map<EStructuralFeature, Modal> featureDocModals) throws Exception {
		Table featuresTable = getHTMLFactory(context).table();
		featuresTable.col().bootstrap().grid().col(1);
		featuresTable.col().bootstrap().grid().col(11);

		for (EStructuralFeature vf: getVisibleStructuralFeatures(context, obj)) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals ==  null ? null : featureDocModals.get(vf));
			if (!isTab(context, vf)) {
				Row fRow = featuresTable.body().row();
				Cell fLabelCell = fRow.header(renderNamedElementLabel(context, vf));
				if (featureDocIcon != null) {
					fLabelCell.content(featureDocIcon);
				}
				if (vf.isMany()) {
					Tag ul = getHTMLFactory(context).tag(TagName.ul);
					for (Object v: ((Collection<Object>) obj.eGet(vf))) {
						ul.content(getHTMLFactory(context).tag(TagName.li, renderFeatureValue(context, vf, v)));
					}
					fRow.cell(ul);
				} else {
					fRow.cell(renderFeatureValue(context, vf, obj.eGet(vf)));
				}
			}
		}
		
				
		// TODO - Edit button
		
		// TODO - Delete button
		
		// TODO - Web operations buttons

		return featuresTable;
	}
	
	/**
	 * Renders tabs.
	 * @param context
	 * @param obj
	 * @param tabs
	 * @param featureDocModals
	 * @throws Exception
	 */
	default void renderTabs(C context, T obj, Tabs tabs, Map<EStructuralFeature, Modal> featureDocModals) throws Exception {
		if (isViewTab(context, obj)) {
			tabs.item(renderViewTabLabel(context, obj), renderView(context, obj, featureDocModals));
		}
		for (EStructuralFeature vf: getVisibleStructuralFeatures(context, obj)) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals ==  null ? null : featureDocModals.get(vf));
			if (isTab(context, vf)) {
				Tag nameSpan = getHTMLFactory(context).span(renderNamedElementLabel(context, vf));
				if (featureDocIcon != null) {
					nameSpan.content(featureDocIcon);
				}
				tabs.item(nameSpan, "TODO - table, add button");
			}
		}		
	}

}
