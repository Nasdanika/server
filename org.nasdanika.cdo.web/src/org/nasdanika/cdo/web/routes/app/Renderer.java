package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpServletRequestContext;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

/**
 * Renders HTML elements such as form inputs, tables, e.t.c.
 * @author Pavel
 *
 * @param <T>
 */
public interface Renderer<C extends Context, T extends EObject> {
	
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
	 * On EClass this annotation defines EClass label/display name.
	 */
	String ANNOTATION_KEY_ECLASS_LABEL = "eclass-label";
	
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
	
	default Renderer<?, ?> getRenderer(EClass eClass) {
		// TODO extension point.
		return INSTANCE;
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
				breadCrumbs.item(objectURI == null ? objectURI : objectURI+"/index.html", cLabel);
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
			String label = HTMLFactory.INSTANCE.interpolate(labelAnnotation, token -> {
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
	 * and ``#`` otherwise.
	 * @throws Exception
	 */
	default String getObjectURI(C context, T obj) throws Exception {
		if (context instanceof HttpServletRequestContext) {
			return ((HttpServletRequestContext) context).getObjectPath(obj);		
		}
		
		return "#";
	}
	
	/**
	 * Renders object link using object label and path.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderLink(C context, T obj) throws Exception {
		return HTMLFactory.INSTANCE.link(getObjectURI(context, obj), renderLabel(context, obj));
	}

	/**
	 * 
	 * @param context
	 * @param namedElement
	 * @return Value of ``label`` render annotation if it is present or element name passed through nameToLabel() conversion.
	 * @throws Exception
	 */
	default Object renderLabel(C context, ENamedElement namedElement) throws Exception {
		String label = getRenderAnnotation(context, namedElement, ANNOTATION_KEY_LABEL);
		return label == null ? nameToLabel(namedElement.getName()) : label;
	}
	
	/**
	 * Renders individual feature value. This implementation converts value to string and then html-escapes it.
	 * nulls are rendered as blank.
	 * @param context
	 * @param feature
	 * @param value
	 * @return
	 */
	default Object renderFeatureValue(C context, EStructuralFeature feature, Object value) {
		return value == null ? "" : StringEscapeUtils.escapeHtml4(value.toString());
	}

	/**
	 * Renders element documentation. Documentation is retrieved from "documentation" annotation key 
	 * and if not found from Ecore GenModel annotation.
	 * @param context
	 * @param modelElement
	 * @return gendoc annotation rendered as markdown in a div with ...
	 * @throws Exception
	 */
	default Object renderDocumentation(C context, EModelElement modelElement) throws Exception {
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
	
	default String markdownToHtml(C context, String markdown) {
		return new PegDownProcessor(PEGDOWN_OPTIONS).markdownToHtml(markdown);		
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
	
//	HTMLFactory.INSTANCE.div(markdownToHtml(context, markdown)).addClass("markdown-body");
	
	default Object renderFirstDocumentationSentence(C context, EModelElement modelElement) throws Exception {
		Object doc = renderDocumentation(context, modelElement);
		return doc instanceof String ? firstHtmlSentence((String) doc) : null;
	}

}
