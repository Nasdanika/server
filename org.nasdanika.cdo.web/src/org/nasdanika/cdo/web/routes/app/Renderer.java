package org.nasdanika.cdo.web.routes.app;

import java.io.BufferedReader;
import java.io.StringReader;
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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.jsoup.Jsoup;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.RowContainer;
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
	 * 
	 * Adding UI rendering annotations to the model mixes modeling and UI concerns.
	 * Also model annotations allow to define only one way of rendering a particular model element.
	 * 
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
	 * e.g. keeping render annotations associated with the current user would allow to customize UI on per-user basis.
	 * Along the same lines the UI may be customized based on the locale or geography. 
	 * All these and other options may be chained, e.g. if user profile does not cusomize rendering, then fall-back to 
	 * locale profile, and then to the model annotation (call super.getRenderAnnotation()).  
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
	 * @param action Action, e.g. Edit or Add reference.
	 * @param breadCrumbs
	 * @return true if breadcrumbs shall be added to the page, i.e. if it has any items.
	 * @throws Exception
	 */
	default void renderObjectPath(C context, T obj, String action, Breadcrumbs breadCrumbs) throws Exception {
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
		if (action == null) {
			breadCrumbs.item(null , renderLabel(context, obj));
		} else {
			String objectURI = getObjectURI(context, obj);
			breadCrumbs.item(objectURI == null ? objectURI : objectURI+"/"+INDEX_HTML, renderLabel(context, obj));
			breadCrumbs.item(null, breadCrumbs.getFactory().tag(TagName.i, StringEscapeUtils.escapeHtml4(action)));
		}
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
		docModal.body(getHTMLFactory(context).div(doc).addClass("markdown-body").style().background().color().value("white")); // Forcing white background to work with dark schemes - ugly but visible..
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
		Z: while (matcher.find()) {
			String group = matcher.group();
			for (String abbr: ABBREVIATIONS) {
				if (group.trim().endsWith(abbr)) {
					continue Z;
				}
			}
			if (matcher.end() > getMinFirstSentenceLength() && matcher.end() < getMaxFirstSentenceLength()) {
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
	default Object renderView(C context, T obj, Map<EStructuralFeature, Modal> featureDocModals) throws Exception {
		return getHTMLFactory(context).fragment(renderViewFeatures(context, obj, featureDocModals), renderViewButtons(context, obj));
	}

	/**
	 * Renders view features with <code>!isTab()</code>. This implementation renders them in a table.
	 * @param context
	 * @param obj
	 * @param featureDocModals
	 * @return
	 * @throws Exception
	 */
	default Object renderViewFeatures(C context, T obj, Map<EStructuralFeature, Modal> featureDocModals) throws Exception {
		Table featuresTable = getHTMLFactory(context).table();
		featuresTable.col().bootstrap().grid().col(1);
		featuresTable.col().bootstrap().grid().col(11);

		for (EStructuralFeature vf: getVisibleStructuralFeatures(context, obj)) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals ==  null ? null : featureDocModals.get(vf));
			if (!isTab(context, vf)) {
				Row fRow = featuresTable.body().row();
				Cell fLabelCell = fRow.header(renderNamedElementLabel(context, vf)).style().whiteSpace().nowrap();
				if (featureDocIcon != null) {
					fLabelCell.content(featureDocIcon);
				}
				fRow.cell(renderFeatureView(context, obj, vf, false));
			}
		}
		return featuresTable;
	}
	
	/**
	 * Renders view buttons. This implementation renders Edit and Delete buttons.
	 * @param context
	 * @param obj
	 * @param featureDocModals
	 * @return
	 * @throws Exception
	 */
	default Object renderViewButtons(C context, T obj) throws Exception {
		Tag ret = getHTMLFactory(context).div().style().margin("5px"); 
		ret.content(renderEditButton(context, obj));
		ret.content(renderDeleteButton(context, obj));
		return ret;
	}

	/**
	 * Renders edit button. 
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderEditButton(C context, T obj) throws Exception {
		if (context.authorize(obj, "edit", null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button editButton = htmlFactory.button(htmlFactory.glyphicon(Glyphicon.pencil).style().margin().right("5px"), getResourceString(context, "edit", false)).style(Style.PRIMARY);
			editButton.on(Event.click, "window.location='edit.html';");

			Map<String, Object> env = new HashMap<>();
			env.put("name", renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String tooltip = htmlFactory.interpolate(getResourceString(context, "editTooltip", false), env);
			editButton.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));
			
			return editButton;
		}
		return null;
	}

	/**
	 * Renders edit button. 
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderDeleteButton(C context, T obj) throws Exception {
		if (obj.eContainer() != null && context.authorize(obj, "delete", null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button deleteButton = htmlFactory.button(htmlFactory.glyphicon(Glyphicon.trash).style().margin().right("5px"), getResourceString(context, "delete", false)).style(Style.DANGER);
			Map<String, Object> env = new HashMap<>();
			env.put("name", renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String deleteConfirmationMessage = StringEscapeUtils.escapeEcmaScript(htmlFactory.interpolate(getResourceString(context, "confirmDelete", false), env));
			
			// Delete through GET, not REST-compliant, but works with simple JavaScript. 
			deleteButton.on(Event.click, "if (confirm('"+deleteConfirmationMessage+"?')) window.location='delete.html';"); // TODO - extract into a method, so it is easy to override.

			String tooltip = htmlFactory.interpolate(getResourceString(context, "deleteTooltip", false), env);
			deleteButton.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));
			
			return deleteButton;
		}
		return null;
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
				tabs.item(nameSpan, tabs.getFactory().div(renderFeatureView(context, obj, vf, true)).style().margin("3px"));
			}
		}		
	}

	/**
	 * Renders a view of the feature value. 
	 * A feature is rendered as a list if <code>view</code> annotation value is <code>list</code> or 
	 * if it is not present and the feature is rendered in the view (<code>!isTab()</code>).
	 * <P/>
	 * If <code>view</code> annotation value is <code>table</code> or 
	 * if it is not present and the feature is rendered in a tab (<code>isTab()</code>), 
	 * then the feature value is rendered as a table. Object features to show and their order in the
	 * table can be defined using <code>view-features</code> annotation. Annotation value shall list 
	 * the features in the order in appearance, each feature on a new line. 
	 * If this annotation is not present, all visible single-value features are shown in the order of their declaration.
	 * @param context
	 * @param obj
	 * @param feature
	 * @param showButtons if true, action buttons such as edit/delete/add/create/clear/select are shown if user is authorized to perform action.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	default Object renderFeatureView(C context, T obj, EStructuralFeature feature, boolean showActionButtons) throws Exception {
		Fragment ret = getHTMLFactory(context).fragment();
		Map<String, Object> env = new HashMap<>();
		env.put("name", feature.getName());
		if (feature.isMany()) {
			String viewAnnotation = getRenderAnnotation(context, feature, "view");
			boolean asTable = false;
			if (feature instanceof EReference) {
				boolean isTab = isTab(context, feature);
				if (viewAnnotation == null) {
					asTable = isTab;
				} else {
					if (isTab) {
						asTable = !"view".equals(viewAnnotation);
					} else {
						asTable = "table".equals(viewAnnotation);
					}
				}
			}
			if (asTable) {
				EClass refType = ((EReference) feature).getEReferenceType();
				List<EStructuralFeature> tableFeatures = new ArrayList<EStructuralFeature>();
				String viewFeaturesAnnotation = getRenderAnnotation(context, feature, "view-features");
				if (viewFeaturesAnnotation == null) {
					for (EStructuralFeature sf: refType.getEAllStructuralFeatures()) {
						if (!sf.isMany() && context.authorize(obj, "view", feature.getName()+"/"+sf.getName(), null)) {
							tableFeatures.add(sf);
						}
					}
				} else {
					try (BufferedReader br = new BufferedReader(new StringReader(viewFeaturesAnnotation))) {
						String line;
						while ((line = br.readLine()) != null) {
							if (!CoreUtil.isBlank(line)) {
								EStructuralFeature sf = refType.getEStructuralFeature(line);
								if (sf != null && context.authorize(obj, "view", feature.getName()+"/"+sf.getName(), null)) {
									tableFeatures.add(sf);
								}
							}
						}
					}
				}
				
				Map<EStructuralFeature, Modal> featureDocModals = new HashMap<>();
				for (EStructuralFeature sf: tableFeatures) {
					Modal fdm = renderDocumentationModal(context, sf);
					if (fdm != null) {
						featureDocModals.put(sf, fdm);
					}
					ret.content(fdm);
				}		
				
				Table featureTable = ret.getFactory().table().bordered();
				Row headerRow = featureTable.header().row().style(Style.INFO);
				for (EStructuralFeature sf: tableFeatures) {
					Tag featureDocIcon = renderDocumentationIcon(context, sf, featureDocModals ==  null ? null : featureDocModals.get(sf));
					Cell headerCell = headerRow.header(renderNamedElementLabel(context, sf));
					if (featureDocIcon != null) {
						headerCell.content(featureDocIcon);
					}
				}
				
				headerRow.header(getResourceString(context, "actions", false)).style().text().align().center();
				for (EObject fv: (Collection<EObject>) obj.eGet(feature)) {
					Row vRow = featureTable.body().row();
					for (EStructuralFeature sf: tableFeatures) {
						vRow.cell(getRenderer(fv).renderFeatureView(context, fv, sf, false));						
					}
					vRow.cell("TODO - action buttons").style().text().align().center();
				}
				
				ret.content(featureTable);
				ret.content("TODO - add/create buttons - collect all concrete subclasses of reference type - drop-down button if more than one");
				// TODO Add/Create buttons
			} else {
				Tag ul = getHTMLFactory(context).tag(TagName.ul);
				int idx = 0;
				for (Object v: ((Collection<Object>) obj.eGet(feature))) {
					Fragment liFragment = ret.getFactory().fragment(renderFeatureValue(context, feature, v));
					if (feature instanceof EAttribute) {
						if (showActionButtons && context.authorize(obj, "edit", feature.getName(), null)) {
							String tooltip = ret.getFactory().interpolate(getResourceString(context, "editTooltip", false), env);
							Button editButton = ret.getFactory().button(ret.getFactory().glyphicon(Glyphicon.pencil))
								.style(Style.PRIMARY)
								.style().margin().left("5px")
								.on(Event.click, "window.location='edit/"+feature.getName()+"/"+idx+".html") // TODO - extract into a method, so it is easy to override.
								.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));
							liFragment.content(editButton);
						}												
					}
					if (v instanceof EObject && feature instanceof EReference && ((EReference) feature).isContainment()) {
						if (showActionButtons && context.authorize(v, "delete", null, null)) {
							String deleteConfirmationMessage = StringEscapeUtils.escapeEcmaScript(ret.getFactory().interpolate(getResourceString(context, "confirmDelete", false), env));;
							String tooltip = ret.getFactory().interpolate(getResourceString(context, "deleteTooltip", false), env);

							// Again, deletion through GET, not REST-compliant, but JavaScript part is kept simple.
							Button deleteButton = ret.getFactory().button(ret.getFactory().glyphicon(Glyphicon.trash))
									.style(Style.DANGER)
									.style().margin().left("5px")
									.on(Event.click, "if (confirm('"+deleteConfirmationMessage+"?')) window.location='"+getRenderer(((EObject) v).eClass()).getObjectURI(context, (EObject) v)+"/delete.html';") // TODO - extract into a method, so it is easy to override.
									.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));

							liFragment.content(deleteButton);
						}
					} else {
						if (showActionButtons && context.authorize(obj, "delete", feature.getName(), null)) {
							String deleteConfirmationMessage = StringEscapeUtils.escapeEcmaScript(ret.getFactory().interpolate(getResourceString(context, "confirmDelete", false), env));;
							String tooltip = ret.getFactory().interpolate(getResourceString(context, "deleteTooltip", false), env);

							// And yet again, deletion through GET, not REST-compliant, but JavaScript part is kept simple.
							Button deleteButton = ret.getFactory().button(ret.getFactory().glyphicon(Glyphicon.trash))
									.style(Style.DANGER)
									.style().margin().left("5px")
									.on(Event.click, "if (confirm('"+deleteConfirmationMessage+"?')) window.location='delete/"+feature.getName()+"/"+idx+".html';") // TODO - extract into a method, so it is easy to override.
									.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));

							liFragment.content(deleteButton);							
						}										
					}
					ul.content(getHTMLFactory(context).tag(TagName.li, liFragment));
					++idx;
				}
				ret.content(ul);
				if (showActionButtons && context.authorize(obj, "add", feature.getName(), null)) {
					boolean isCreate = feature instanceof EReference && ((EReference) feature).isContainment();
					String tooltip = ret.getFactory().interpolate(getResourceString(context, isCreate ? "createTooltip" : "addTooltip", false), env);

					// TODO - create - concrete subclasses of reference type - drop-down button if more than one.
					Button addButton = ret.getFactory().button(getResourceString(context, isCreate ? "create" : "add", false))
							.style(Style.PRIMARY)
							.style().margin().left("5px")
							.on(Event.click, "window.location='add/"+feature.getName()+".html';") // TODO - extract into a method, so it is easy to override.
							.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));

					ret.content(addButton);							
				}
			}
		} else {
			ret.content(renderFeatureValue(context, feature, obj.eGet(feature)));
			if (feature instanceof EReference) {
				if (showActionButtons && context.authorize(obj, "edit", feature.getName(), null)) {
					String tooltip = ret.getFactory().interpolate(getResourceString(context, "selectTooltip", false), env);
					Button selectButton = ret.getFactory().button(ret.getFactory().glyphicon(Glyphicon.pencil))
						.style(Style.PRIMARY)
						.style().margin().left("5px")
						.on(Event.click, "window.location='select/"+feature.getName()+".html") // TODO - extract into a method, so it is easy to override.
						.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));
					ret.content(selectButton);
				}
				if (showActionButtons && context.authorize(obj, "delete", feature.getName(), null)) {
					String clearConfirmationMessage = StringEscapeUtils.escapeEcmaScript(ret.getFactory().interpolate(getResourceString(context, "confirmClear", false), env));;
					String tooltip = ret.getFactory().interpolate(getResourceString(context, "clearTooltip", false), env);

					// And yet again, deletion through GET, not REST-compliant, but JavaScript part is kept simple.
					Button deleteButton = ret.getFactory().button(ret.getFactory().glyphicon(Glyphicon.erase))
							.style(Style.DANGER)
							.style().margin().left("5px")
							.on(Event.click, "if (confirm('"+clearConfirmationMessage+"?')) window.location='clear/"+feature.getName()+".html';") // TODO - extract into a method, so it is easy to override.
							.attribute("title", StringEscapeUtils.escapeHtml4(tooltip));

					ret.content(deleteButton);							
				}										
			}
		}
		return ret;
	}
	
}
