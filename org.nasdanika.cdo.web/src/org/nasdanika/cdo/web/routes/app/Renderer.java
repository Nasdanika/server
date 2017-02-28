package org.nasdanika.cdo.web.routes.app;

import java.io.BufferedReader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.jsoup.Jsoup;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.web.CDOIDCodec;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Color;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.Button.Type;
import org.nasdanika.html.FieldContainer;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.FontAwesome;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.JsTree;
import org.nasdanika.html.Modal;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.TextArea;
import org.nasdanika.html.UIElement;
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
	
	public static final String TITLE_KEY = "title";

	public static final String NAME_KEY = "name";

	public static final String REFERRER_KEY = ".referrer";

	public static final String ANNOTATION_KEY_VIEW_TAB = "view-tab";
	
	public static final String ANNOTATION_KEY_IS_TAB = "is-tab";

	public static final String INDEX_HTML = "index.html";

	/**
	 * Documentation annotation key.
	 */
	String ANNOTATION_KEY_DOCUMENTATION = "documentation";

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
	
	String ANNOTATION_MODEL_ELEMENT_LABEL = "model-element-label";
	
	
	Pattern SENTENCE_PATTERN = Pattern.compile(".+?[\\.?!]+\\s+");	
	
	int MIN_FIRST_SENTENCE_LENGTH = 20;
	int MAX_FIRST_SENTENCE_LENGTH = 250;
		
	// multi-line
	// input type
	// select options	
	
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
	 * Retrieves render annotation. 
	 * 
	 * If the model element is {@link ENamedElement}, then annotation value is
	 * retrieved as a resource string with key ``<Named element EClass name without first E uncapitalized>.<named element name>.render.<key>``. 
	 * For example ``attribute.name.render.label`` or ``reference.guest.render.visible``. This approach keeps resource string keys simple enough, but
	 * may result in name clashes if used in a base renderer which serves two different model elements with different features with the same name. If it happens,
	 * define per-model element renderers and render annotations within their resource bundles - this is the approach which https://github.com/Nasdanika/codegen-ecore-web-ui takes.
	 * 
	 * If there is no resource string matching the annotation key, then annotation value is read from the details entry with the specified key of
	 * he model element annotation with source ``org.nasdanika.cdo.web.render``.
	 * 
	 * This method can be overridden to read annotations from another source,
	 * e.g. keeping render annotations associated with the current user would allow to customize UI on per-user basis.
	 * Along the same lines the UI may be customized based on the locale or geography. 
	 * All these and other options may be chained, e.g. if user profile does not cusomize rendering, then fall-back to 
	 * locale profile, and then to the model annotation (call super.getRenderAnnotation()).  
	 * @param context
	 * @param modelElement
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	default String getRenderAnnotation(C context, EModelElement modelElement, String key) throws Exception {
		if (modelElement instanceof ENamedElement) {
			String name = ((ENamedElement) modelElement).getName();
			String className = modelElement.eClass().getName();
			if (className.startsWith("E")) {
				className = className.substring(1);
			}
			String rs = getResourceString(context, StringUtils.uncapitalize(className)+"."+name+".render."+key, false);
			if (rs != null) {
				return rs;
			}
		}
		
		EAnnotation ra = modelElement.getEAnnotation(RENDER_ANNOTATION_SOURCE);
		if (ra != null) {
			String value = ra.getDetails().get(key);
			if (value != null) {
				return value;
			}
		}
		if (modelElement instanceof EClass) {
			return RenderUtil.getRenderAnnotation((EClass) modelElement, key);
		}
		
		return null;
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
	 * returns all object features authorized to read which are not annotated with <code>visible</code> details annotation set to <code>false</code>
	 * @throws Exception 
	 */
	default List<EStructuralFeature> getVisibleFeatures(C context, T obj) throws Exception {
		List<EStructuralFeature> ret = new ArrayList<>();
		for (EStructuralFeature sf: obj.eClass().getEAllStructuralFeatures()) {
			if (!"false".equals(getRenderAnnotation(context, sf, ANNOTATION_KEY_VISIBLE)) && context.authorizeRead(obj, sf.getName(), null)) {
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
			Object cLabel = cRenderer.renderIconAndLabel(context, c);
			if (cLabel != null) {
				String objectURI = cRenderer.getObjectURI(context, c);
				breadCrumbs.item(objectURI == null ? objectURI : objectURI+"/"+INDEX_HTML, cLabel);
			}
		}
		if (action == null) {
			breadCrumbs.item(null , renderIconAndLabel(context, obj));
		} else {
			String objectURI = getObjectURI(context, obj);
			breadCrumbs.item(objectURI == null ? objectURI : objectURI+"/"+INDEX_HTML, renderLabel(context, obj));
			breadCrumbs.item(null, breadCrumbs.getFactory().tag(TagName.b, StringEscapeUtils.escapeHtml4(action)));
		}
	}

	/**
	 * Renders object path to a fragment with a given separator. This implementation traverses the object containment path up to the top level object in the resource.
	 * @param target
	 * @param context
	 * @param action Action, e.g. Edit or Add reference.
	 * @param breadCrumbs
	 * @throws Exception
	 */
	default Fragment renderObjectPath(C context, T obj, Object separator) throws Exception {
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment ret = htmlFactory.fragment();
		List<EObject> cPath = new ArrayList<EObject>();
		for (EObject c = obj.eContainer(); c != null; c = c.eContainer()) {
			cPath.add(c);
		}
		Collections.reverse(cPath);
		for (EObject c: cPath) {
			Renderer<C, EObject> cRenderer = getRenderer(c);
			Object cLink = cRenderer.renderLink(context, c, false);
			if (cLink != null) {
				if (!ret.isEmpty()) {
					ret.content(separator);
				}
				ret.content(cLink);
			}
		}
		if (!ret.isEmpty()) {
			ret.content(separator);
		}
		ret.content(renderLink(context, obj, false));
		return ret;
	}

	/**
	 * Renders object label. This implementation interpolates the value of ``label`` annotation if it is found in 
	 * the object's EClass or any of its subclasses. The objects is used as the interpolation token source with 
	 * visible features names as token names and values as values. ``eclass-name`` token expands to object's EClass name.
	 * 
	 * If ``label`` annotation is not found, then the value
	 * of the first feature is used as object label.  
	 *  
	 * Label value is HTML-escaped. 
	 * 
	 * @param context
	 * @param obj
	 * @return Object label or null if there are no visible features (e.g. the principal does not have permission to view the object.
	 * @throws Exception
	 */
	default Object renderLabel(C context, T obj) throws Exception {
		String labelAnnotation = getRenderAnnotation(context, obj.eClass(), ANNOTATION_KEY_LABEL);
		
		if (labelAnnotation != null) {
			Map<String, EStructuralFeature> vsfm = new HashMap<>();
			for (EStructuralFeature vsf: getVisibleFeatures(context, obj)) {
				vsfm.put(vsf.getName(), vsf);
			}
			String label = getHTMLFactory(context).interpolate(labelAnnotation, token -> {
				if ("eclass-name".equals(token)) {
					return obj.eClass().getName();
				}
				EStructuralFeature vsf = vsfm.get(token);
				return vsf == null ? null : obj.eGet(vsf);
			});
			return StringEscapeUtils.escapeHtml4(label);
		}
		
		for (EStructuralFeature vsf: getVisibleFeatures(context, obj)) {
			Object label = obj.eGet(vsf);
			return label == null ? label : StringEscapeUtils.escapeHtml4(String.valueOf(label));
		}
		
		return null;		
	}
	
	/**
	 * Renders icon and label.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Object renderIconAndLabel(C context, T obj) throws Exception {
		Object label = renderLabel(context, obj);
		if (label == null) {
			return renderIcon(context, obj);
		}
		
		Object icon = renderIcon(context, obj);
		if (icon == null) {
			return label;
		}
		return getHTMLFactory(context).fragment(icon, " ", label);		
	}
	
	/**
	 * Invokes getIcon(). If it returns null, this method also returns null.
	 * Otherwise, if the return value contains ``/``, then it returns ``img`` tag with ``src`` attribute set to icon value.
	 * If there is no ``/``, then it returns ``span`` with ``class`` attribute set to icon value (for glyphs, such as {@link Bootstrap.Glyphicon} or {@link FontAwesome}).
	 * @param context
	 * @param modelElement
	 * @return
	 * @throws Exception
	 */
	default Object renderIcon(C context, T obj) throws Exception {
		String icon = getIcon(context, obj);
		if (icon == null) {
			return null;			
		}
		HTMLFactory htmlFactory = getHTMLFactory(context);
		if (icon.indexOf("/") == -1) {
			return htmlFactory.span().addClass(icon);
		}
		return htmlFactory.tag(TagName.img).attribute("src", icon);
	}
	
	/**
	 * Icon "location" for a given object. This implementation returns icon of the object's {@link EClass}.
	 * If icon contains ``/`` it is treated as URL, otherwise it is treated as css class, e.g. Bootstrap's ``glyphicon glyphicon-close``.
	 * @param context
	 * @param modelElement
	 * @return
	 * @throws Exception 
	 */
	default String getIcon(C context, T obj) throws Exception {
		if (obj == null) {
			return null;
		}
		return getModelElementIcon(context, obj.eClass());
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
	default Object renderLink(C context, T obj, boolean withPathTooltip) throws Exception {
		String objectURI = getObjectURI(context, obj);
		Tag ret = getHTMLFactory(context).link(objectURI == null ? "#" : objectURI+"/"+INDEX_HTML, renderIconAndLabel(context, obj));
		if (withPathTooltip) {
			String pathTxt = Jsoup.parse(renderObjectPath(context, obj, " > ").toString()).text();
			ret.attribute("title", pathTxt);
		}
		ret.setData(obj);
		return ret;
	}

	/**
	 * 
	 * @param context
	 * @param namedElement
	 * @return Value of ``model-element-label`` render annotation if it is present or element name passed through nameToLabel() conversion.
	 * 
	 * @throws Exception
	 */
	default Object renderNamedElementLabel(C context, ENamedElement namedElement) throws Exception {
		String label = getRenderAnnotation(context, namedElement, ANNOTATION_MODEL_ELEMENT_LABEL);
		if (label != null) {
			return label;
		}		
		return nameToLabel(namedElement.getName());
	}
	
	/**
	 * 
	 * @param context
	 * @param namedElement
	 * @return Named element icon and label.
	 * @throws Exception
	 */
	default Object renderNamedElementIconAndLabel(C context, ENamedElement namedElement) throws Exception {
		Object label = renderNamedElementLabel(context, namedElement);
		if (label == null) {
			return renderModelElementIcon(context, namedElement);
		}
		
		Object icon = renderModelElementIcon(context, namedElement);
		if (icon == null) {
			return label;
		}
		return getHTMLFactory(context).fragment(icon, " ", label);		
	}
	
	/**
	 * Invokes getModelElementIcon(). If it returns null, this method also returns null.
	 * Otherwise, if the return value contains ``/``, then it returns ``img`` tag with ``src`` attribute set to icon value.
	 * If there is no ``/``, then it returns ``span`` with ``class`` attribute set to icon value (for glyphs, such as {@link Bootstrap.Glyphicon} or {@link FontAwesome}).
	 * @param context
	 * @param modelElement
	 * @return
	 * @throws Exception
	 */
	default Object renderModelElementIcon(C context, EModelElement modelElement) throws Exception {
		String icon = getModelElementIcon(context, modelElement);
		if (icon == null) {
			return null;			
		}
		HTMLFactory htmlFactory = getHTMLFactory(context);
		if (icon.indexOf("/") == -1) {
			return htmlFactory.span().addClass(icon);
		}
		return htmlFactory.tag(TagName.img).attribute("src", icon);
	}
	
	/**
	 * Icon "location" for a given model element. This implementation returns ``icon`` render annotation.
	 * If icon contains ``/`` it is treated as URL, otherwise it is treated as css class, e.g. Bootstrap's ``glyphicon glyphicon-close``.
	 * @param context
	 * @param modelElement
	 * @return
	 * @throws Exception 
	 */
	default String getModelElementIcon(C context, EModelElement modelElement) throws Exception {
		return getRenderAnnotation(context, modelElement, "icon");
	}
	
	/**
	 * Renders individual feature value. This implementation: 
	 * 
	 * * Nulls are rendered as empty strings.
	 * * For booleans invokes renderTrue() or renderFalse();
	 * * For dates uses ``format`` annotation to format with {@link SimpleDateFormat}, if the annotation is present.
	 * * For numbers uses ``format`` annotation to format with {@link DecimalFormat}, if the annotation is present.
	 * * Otherwise converts value to string and then html-escapes it.
	 * @param context
	 * @param feature
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	default Object renderFeatureValue(C context, EStructuralFeature feature, Object value) throws Exception {
		if (value instanceof EObject) {
			return getRenderer(((EObject) value).eClass()).renderLink(context, (EObject) value, true);
		}
		if (value == null) {
			return "";
		}
		if (value instanceof Boolean) {
			return (Boolean) value ?  renderTrue(context) : renderFalse(context);
		}
		if (value instanceof Enumerator) {
			return StringEscapeUtils.escapeHtml4(((Enumerator) value).getLiteral());
		}		
		if (value instanceof Date) {
			String format = getRenderAnnotation(context, feature, "format");
			if (format != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.format((Date) value);
			}
		} else if (value instanceof Number) {
			String format = getRenderAnnotation(context, feature, "format");
			if (format != null) {
				DecimalFormat df = new DecimalFormat(format);
				return df.format(value);
			}
		}			
			
		 return StringEscapeUtils.escapeHtml4(value.toString());		
	}
	
	/**
	 * Parses/converts string value to be compatible with the feature value type.
	 * 
	 * * Booleans - ``true`` and ``on`` are truthy values, ``false``, ``null``, ``off`` and empty string are falsey, all other values are illegal.
	 * * Date - uses ``format`` annotation, if present, to parse using {@link SimpleDateFormat}.
	 * * Number - uses ``format`` annotation, if present, to parse using {@link DecimalFormat}.
	 * * Otherwise uses context.convert() method.
	 * @param context
	 * @param feature
	 * @param strValue
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	default Object parseFeatureValue(C context, EStructuralFeature feature, String strValue) throws Exception {
		Class<?> featureTypeInstanceClass = feature.getEType().getInstanceClass();
		if (Boolean.class == featureTypeInstanceClass || boolean.class == featureTypeInstanceClass) {
			if (strValue == null) {
				return false;
			}
			switch (strValue) {
			case "true":
			case "on":
				return true;
			case "false":
			case "off":
				return false;
			default:
				throw new IllegalArgumentException("Cannot convert to boolean: " + strValue);
			}
		}
		
		if (featureTypeInstanceClass.isEnum()) {
			return featureTypeInstanceClass.getField(strValue).get(null);
		}
		
		if (CDOObject.class.isAssignableFrom(featureTypeInstanceClass) && context instanceof CDOViewContext<?, ?>) {
			return ((CDOViewContext<CDOView, ?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, strValue));
		}
		
		if (Date.class == featureTypeInstanceClass) {
			String format = getRenderAnnotation(context, feature, "format");
			if (format != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.parse(strValue);
			}			
		}
		
		if (Number.class.isAssignableFrom(featureTypeInstanceClass)) {
			String format = getRenderAnnotation(context, feature, "format");
			if (format != null) {
				DecimalFormat df = new DecimalFormat(format);
				if (BigDecimal.class == featureTypeInstanceClass) {
					df.setParseBigDecimal(true);
					return df.parse(strValue);
				}				
				Number parsed = df.parse(strValue);				
				if (Byte.class == featureTypeInstanceClass) {
					return parsed.byteValue();
				}
				if (Double.class == featureTypeInstanceClass) {
					return parsed.doubleValue();
				}
				if (Float.class == featureTypeInstanceClass) {
					return parsed.floatValue();
				}
				if (Integer.class == featureTypeInstanceClass) {
					return parsed.intValue();
				}
				if (Long.class == featureTypeInstanceClass) {
					return parsed.longValue();
				}
				if (Short.class == featureTypeInstanceClass) {
					return parsed.shortValue();
				}				
				return context.convert(parsed, featureTypeInstanceClass);
			}
		}
		
		return context.convert(strValue, featureTypeInstanceClass);
	}
	
	/**
	 * Sets feature value from the context to the object. This implementation loads feature value(s) 
	 * from the {@link HttpServletRequest} parameters.
	 * @param context
	 * @param feature
	 * @throws Exception
	 */
	default void setFeatureValue(C context, T obj, EStructuralFeature feature) throws Exception {
		if (context instanceof HttpServletRequestContext) {
			HttpServletRequest request = ((HttpServletRequestContext) context).getRequest();
			if (feature.isMany()) {
				@SuppressWarnings("unchecked")
				Collection<Object> fv = (Collection<Object>) obj.eGet(feature);
				fv.clear();
				String[] values = request.getParameterValues(feature.getName());
				if (values != null) {
					for (String val: values) {
						fv.add(parseFeatureValue(context, feature, val));
					}
				}						
			} else {
				String value = request.getParameter(feature.getName());
				if (value == null) {
					obj.eUnset(feature);
				} else {
					obj.eSet(feature, parseFeatureValue(context, feature, value));
				}
			}
		}		
	}
	
	/**
	 * Renders true value. This implementation renders a checkmark of SUCCESS color.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Object renderTrue(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.ok).style().color().bootstrapColor(Color.SUCCESS);
	}
	
	/**
	 * Renders false value. This implementation renders empty string.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Object renderFalse(C context) throws Exception {
		return "";
	}

	/**
	 * Renders element documentation. Documentation is retrieved from "documentation" annotation key 
	 * and, if not found, from Ecore GenModel annotation.
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
		HTMLFactory ret = context == null ? HTMLFactory.INSTANCE : context.adapt(HTMLFactory.class);
		return ret == null ? HTMLFactory.INSTANCE : ret;
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
		docModal.title(getHTMLFactory(context).tag(TagName.h4, modelElement instanceof ENamedElement ? renderNamedElementIconAndLabel(context, (ENamedElement) modelElement) : "Documentation"));
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
	 * @param docModal Doc modal to open on icon click. Can be null.
	 * @param superscript if true, the icon is wrapped into ``sup`` tag.
	 * @return
	 * @throws Exception
	 */
	default Tag renderDocumentationIcon(C context, EModelElement modelElement, Modal docModal, boolean superscript) throws Exception {
		String doc = renderDocumentation(context, modelElement);
		if (doc == null) {
			return null;
		}
		String textDoc = Jsoup.parse(doc).text();
		String firstSentence = firstSentence(context, textDoc);					
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Tag helpTag = renderHelpIcon(context);
		if (superscript) {
			helpTag = htmlFactory.tag(TagName.sup, helpTag);
		}
		helpTag.attribute(TITLE_KEY, firstSentence);
		
		// More than one sentence - opens doc modal.
		if (!textDoc.equals(firstSentence) && docModal != null) {
			helpTag.on(Event.click, "$('#"+docModal.getId()+"').modal('show')");
			helpTag.style("cursor", "pointer");
			return helpTag;
		}
		
		// Opens EClass documentation, if configured.
		EClass eClass = null;
		if (modelElement instanceof EClass) {
			eClass = (EClass) modelElement;
		} else if (modelElement.eContainer() instanceof EClass) {
			eClass = (EClass) modelElement.eContainer();
		}
		if (eClass != null) {
			String href = getEClassDocRef(context, eClass);
			if (href != null) {
				helpTag.on(Event.click, "window.open('"+href+"', '_blank');");
				helpTag.style("cursor", "pointer");
				return helpTag;
			}
		}
		
		// Shows help icon
		helpTag.style("cursor", "help");			
		return helpTag;
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
	 * @throws Exception 
	 */
	default String firstHtmlSentence(C context, String html) throws Exception {
		if (CoreUtil.isBlank(html)) {
			return "";
		}

		return firstSentence(context, Jsoup.parse(html).text());
	}

	default int getMinFirstSentenceLength() {
		return MIN_FIRST_SENTENCE_LENGTH;
	}
	
	default int getMaxFirstSentenceLength() {
		return MAX_FIRST_SENTENCE_LENGTH;
	}
	
	default String firstSentence(C context, String text) throws Exception {
		if (text == null || text.length() < getMinFirstSentenceLength()) {
			return text;
		}
		Matcher matcher = SENTENCE_PATTERN.matcher(text);		
		Z: while (matcher.find()) {
			String group = matcher.group();
			for (String abbr: getResourceString(context, "abbreviations", false).split("|")) {
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
		return doc instanceof String ? firstHtmlSentence(context, (String) doc) : null;
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
	 * @return Resource string for a given key. This implementation uses resource bundle. If property with given key is not found in the resource bundle, then
	 * this implementation reads ``<key>@`` property (property reference), e.g. ``documentation@`` for documentation. If such property is present, then a classloader
	 * resource with the name equal to the property value is loaded, if present, and stringified with {@link CoreUtil}.stringify() method. If resource reference property value ends with ``.md``,
	 * then its value is treated as markdown and is converted to HTML. Resource references and markdown conversion can be leveraged in localization of documentation
	 * resources. 
	 * @throws Exception
	 */
	default String getResourceString(C context, String key, boolean interpolate) throws Exception {
		LinkedList<Class<?>> resourceBundleClasses = getResourceBundleClasses(context);
		
		String rs = null;
		for (Class<?> rbc: resourceBundleClasses) {
			ResourceBundle rb = ResourceBundle.getBundle(rbc.getName(), getLocale(context), rbc.getClassLoader());
			if (rb.containsKey(key)) {
				rs = rb.getString(key);
				break;
			}
			
			String refKey = key + '@';
			if (rb.containsKey(refKey)) {
				String rsRef = rb.getString(refKey);
				URL rsRes = rbc.getResource(rsRef);
				if (rsRes != null) {
					rs = CoreUtil.stringify(rsRes);
					if (rsRef.endsWith(".md")) {
						rs = markdownToHtml(context, rs);
					}
					break;
				}
			}			
		}		
		
		if (rs != null && interpolate) {
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
	 * 
	 * @param context
	 * @param obj
	 * @param key
	 * @return Resource for a given key. This implementation uses resource bundle. If property with given key is not found in the resource bundle, then
	 * this implementation reads ``<key>@`` property (property reference), e.g. ``documentation@`` for documentation. If such property is present, then a classloader
	 * resource ({@link URL}) with the name equal to the property value is returned, if present.  
	 * @throws Exception
	 */
	default Object getResource(C context, String key) throws Exception {
		LinkedList<Class<?>> resourceBundleClasses = getResourceBundleClasses(context);
		
		Object res = null;
		for (Class<?> rbc: resourceBundleClasses) {
			ResourceBundle rb = ResourceBundle.getBundle(rbc.getName(), getLocale(context), rbc.getClassLoader());
			if (rb.containsKey(key)) {
				res = rb.getObject(key);
				break;
			}
			
			String refKey = key + '@';
			if (rb.containsKey(refKey)) {
				String rsRef = rb.getString(refKey);
				URL rsRes = rbc.getResource(rsRef);
				if (rsRes != null) {
					res = rsRes;
					// TODO - special handling of .properties, .json, and .yml resources - parse and return parse result - Properties, JSONObject or JSONArray, Maps/lists
					// If URL has a fragment, then treat is as a path in the result e.g. usd/rate.
					break;
				}
			}			
		}		
		
		return res;
	}
	
	/**
	 * @param context
	 * @return List of classes to load resource bundles from to search for resource strings. 
	 * This implementation returns list containing Renderer.class.
	 * 
	 * Subtypes may override this method to add additional bundles. 
	 * @throws Exception
	 */
	default LinkedList<Class<?>> getResourceBundleClasses(C context) throws Exception {
		LinkedList<Class<?>> ret = new LinkedList<>();
		ret.add(Renderer.class);
		return ret;
	}
	
	/**
	 * Renders feature documentation modal dialogs.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Map<EStructuralFeature, Modal> renderFeaturesDocModals(C context, T obj, Collection<EStructuralFeature> features) throws Exception {
		Map<EStructuralFeature, Modal> featureDocModals = new HashMap<>();
		for (EStructuralFeature vf: features) {
			Modal fdm = renderDocumentationModal(context, vf);
			if (fdm != null) {
				featureDocModals.put(vf, fdm);
			}
		}		
		return featureDocModals;
	}

	/**
	 * Renders doc modals for visible features.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Map<EStructuralFeature, Modal> renderVisibleFeaturesDocModals(C context, T obj) throws Exception {
		return renderFeaturesDocModals(context, obj, getVisibleFeatures(context, obj));
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

		for (EStructuralFeature vf: getVisibleFeatures(context, obj)) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals ==  null ? null : featureDocModals.get(vf), true);
			if (!isTab(context, vf)) {
				Row fRow = featuresTable.body().row();
				Cell fLabelCell = fRow.header(renderNamedElementIconAndLabel(context, vf)).style().whiteSpace().nowrap();
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
	default Button renderEditButton(C context, T obj) throws Exception {
		if (context.authorizeUpdate(obj, null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button editButton = htmlFactory.button(renderEditIcon(context).style().margin().right("5px"), getResourceString(context, "edit", false)).style(Style.PRIMARY);
			wireEditButton(context, obj, editButton);

			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String tooltip = htmlFactory.interpolate(getResourceString(context, "editTooltip", false), env);
			editButton.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			return editButton;
		}
		return null;
	}
	
	/**
	 * Assigns an action to the edit button. This implementation adds onClick handler which navigates to edit page.
	 * @param feature
	 * @param idx
	 * @param editButton
	 */
	default void wireEditButton(C context, T obj, Button editButton) throws Exception {
		editButton.on(Event.click, "window.location='edit.html';");		
	}	
	
	/**
	 * Renders Save button.   
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Button renderSaveButton(C context, T obj) throws Exception {
		if (context.authorizeUpdate(obj, null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button saveButton = htmlFactory.button(renderSaveIcon(context).style().margin().right("5px"), getResourceString(context, "save", false)).style(Style.PRIMARY);
			wireSaveButton(context, obj, saveButton);

			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String tooltip = htmlFactory.interpolate(getResourceString(context, "saveTooltip", false), env);
			saveButton.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			return saveButton;
		}
		return null;
	}	

	/**
	 * Assigns an action to the save button. This implementation set the button type to Submit.
	 * @param feature
	 * @param idx
	 * @param editButton
	 */
	default void wireSaveButton(C context, T obj, Button saveButton) throws Exception {
		saveButton.type(Type.SUBMIT);
	}	
	
	/**
	 * Renders Save button.   
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Button renderCancelButton(C context, T obj) throws Exception {
		if (context.authorizeUpdate(obj, null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button cancelButton = htmlFactory.button(renderCancelIcon(context).style().margin().right("5px"), getResourceString(context, "cancel", false)).style(Style.DANGER);
			wireCancelButton(context, obj, cancelButton);

			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String tooltip = htmlFactory.interpolate(getResourceString(context, "cancelTooltip", false), env);
			cancelButton.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			return cancelButton;
		}
		return null;
	}	

	/**
	 * Assigns an action to the cancel button. If there is "referrer" parameter, then this implementation sets onClick to navigate to the parameter name, 
	 * otherwise it sets button type to RESET.
	 *  the button type to Submit.
	 * @param feature
	 * @param idx
	 * @param editButton
	 */
	default void wireCancelButton(C context, T obj, Button cancelButton) throws Exception {
		if (context instanceof HttpServletRequestContext) {
			HttpServletRequest request = ((HttpServletRequestContext) context).getRequest();
			String referrer = request.getParameter(REFERRER_KEY);
			if (referrer == null) {
				referrer = request.getHeader("referer");
			}
			if (referrer == null) {
				referrer = ((HttpServletRequestContext) context).getObjectPath(obj)+"/"+INDEX_HTML;
			}
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String cancelConfirmationMessage = StringEscapeUtils.escapeEcmaScript(htmlFactory.interpolate(getResourceString(context, "confirmCancel", false), env));			
			cancelButton.on(Event.click, "if (confirm('"+cancelConfirmationMessage+"?')) window.location='"+referrer+"';return false;");
			return;
		}
		cancelButton.type(Type.RESET);
	}	
	
	/**
	 * Renders edit icon. This implementation renders Bootstrap Glyphicon pencil.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderEditIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.edit);		
	}

	/**
	 * Renders delete icon. This implementation renders Bootstrap Glyphicon trash.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderDeleteIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.trash);		
	}

	/**
	 * Renders clear icon. This implementation renders Bootstrap Glyphicon erase.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderClearIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.erase);		
	}
	
	/**
	 * Renders "details" icon. This implementation renders Bootstrap Glyphicon option_horizontal.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderDetailsIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.option_horizontal);		
	}

	/**
	 * Renders clear icon. This implementation renders Bootstrap Glyphicon erase.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderCreateIcon(C context) throws Exception {
		return getHTMLFactory(context).fontAwesome().webApplication(WebApplication.magic).getTarget();		
	}

	/**
	 * Renders clear icon. This implementation renders Bootstrap Glyphicon erase.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderAddIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.plus_sign);		
	}

	/**
	 * Renders clear icon. This implementation renders Bootstrap Glyphicon erase.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderCancelIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.remove);		
	}
	

	/**
	 * Renders clear icon. This implementation renders Bootstrap Glyphicon erase.
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	default Tag renderSaveIcon(C context) throws Exception {
		return getHTMLFactory(context).glyphicon(Glyphicon.save);		
	}
		
	/**
	 * Renders edit button. 
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Button renderDeleteButton(C context, T obj) throws Exception {
		if (obj.eContainer() != null && context.authorizeDelete(obj, null, null)) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Button deleteButton = htmlFactory.button(renderDeleteIcon(context).style().margin().right("5px"), getResourceString(context, "delete", false)).style(Style.DANGER);
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
			String tooltip = htmlFactory.interpolate(getResourceString(context, "deleteTooltip", false), env);
			deleteButton.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			wireDeleteButton(context, obj, deleteButton);
			
			return deleteButton;
		}
		return null;
	}

	/**
	 * Assigns action to the delete button. This implementation sets onClick handler which navigates to the delete page.
	 * @param context
	 * @param obj
	 * @param deleteButton
	 * @throws Exception
	 */
	default void wireDeleteButton(C context, T obj, Button deleteButton) throws Exception {
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Map<String, Object> env = new HashMap<>();
		env.put(NAME_KEY, renderNamedElementLabel(context, obj.eClass())+" '"+renderLabel(context, obj)+"'");
		String deleteConfirmationMessage = StringEscapeUtils.escapeEcmaScript(htmlFactory.interpolate(getResourceString(context, "confirmDelete", false), env));			
		// Delete through GET, not REST-compliant, but works with simple JavaScript. 
		deleteButton.on(Event.click, "if (confirm('"+deleteConfirmationMessage+"?')) window.location='delete.html';"); 
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
		for (EStructuralFeature vf: getVisibleFeatures(context, obj)) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals ==  null ? null : featureDocModals.get(vf), true);
			if (isTab(context, vf)) {
				Tag nameSpan = getHTMLFactory(context).span(renderNamedElementIconAndLabel(context, vf));
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
	 * the features in the order in appearance, whitespace separated. 
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
		env.put(NAME_KEY, feature.getName());
		Object featureValue = obj.eGet(feature);
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
						if (!sf.isMany() && context.authorizeRead(obj, feature.getName()+"/"+sf.getName(), null)) {
							tableFeatures.add(sf);
						}
					}
				} else {
					for (String vf: viewFeaturesAnnotation.split("\\s+")) {
						if (!CoreUtil.isBlank(vf)) {
							EStructuralFeature sf = refType.getEStructuralFeature(vf.trim());
							if (sf != null && context.authorizeRead(obj, feature.getName()+"/"+sf.getName(), null)) {
								tableFeatures.add(sf);
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
				
				Table featureTable = ret.getFactory().table().bordered().style().margin().bottom("5px");
				Row headerRow = featureTable.header().row().style(Style.INFO);
				for (EStructuralFeature sf: tableFeatures) {
					Tag featureDocIcon = renderDocumentationIcon(context, sf, featureDocModals ==  null ? null : featureDocModals.get(sf), true);
					Cell headerCell = headerRow.header(renderNamedElementIconAndLabel(context, sf));
					if (featureDocIcon != null) {
						headerCell.content(featureDocIcon);
					}
				}
				
				headerRow.header(getResourceString(context, "actions", false)).style().text().align().center();
				int idx = 0;
				for (EObject fv: (Collection<EObject>) featureValue) {
					Row vRow = featureTable.body().row();
					for (EStructuralFeature sf: tableFeatures) {
						vRow.cell(getRenderer(fv).renderFeatureView(context, fv, sf, false));						
					}
					Cell actionCell = vRow.cell().style().text().align().center();
					actionCell.content(renderFeatureValueViewButton(context, obj, feature, idx, fv));
					actionCell.content(renderFeatureValueDeleteButton(context, obj, feature, idx, fv));
					
					++idx;
				}
				
				ret.content(featureTable);
				ret.content(renderFeatureAddButton(context, obj, feature));
			} else {
				Tag ul = getHTMLFactory(context).tag(TagName.ul);
				int idx = 0;
				for (Object v: ((Collection<Object>) featureValue)) {
					Fragment liFragment = ret.getFactory().fragment(renderFeatureValue(context, feature, v));
					if (feature instanceof EAttribute) {
						if (showActionButtons) {
							liFragment.content(renderFeatureValueEditButton(context, obj, feature, idx, v));
						}												
					}
					if (showActionButtons) {
						liFragment.content(renderFeatureValueDeleteButton(context, obj, feature, idx, v));
					}
					ul.content(getHTMLFactory(context).tag(TagName.li, liFragment));
					++idx;
				}
				ret.content(ul);
				if (showActionButtons) { 
					ret.content(renderFeatureAddButton(context, obj, feature));							
				}
			}
		} else {
			ret.content(renderFeatureValue(context, feature, featureValue));
			if (showActionButtons && feature instanceof EReference) {
				ret.content(renderFeatureValueEditButton(context, obj, feature, -1, featureValue));
				ret.content(renderFeatureValueDeleteButton(context, obj, feature, -1, featureValue));
			}
		}
		return ret;
	}

	/**
	 * Renders a button to add a new value to the feature, maybe by creating one. 
	 * @param context
	 * @param obj
	 * @param feature
	 * @return
	 * @throws Exception
	 */
	default Button renderFeatureAddButton(C context, T obj, EStructuralFeature feature)	throws Exception {
		if (context.authorizeCreate(obj, feature.getName(), null)) { // Adding to a reference is considered create.
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, feature.getName());
			boolean isCreate = feature instanceof EReference && ((EReference) feature).isContainment();
			String tooltip = htmlFactory.interpolate(getResourceString(context, isCreate ? "createTooltip" : "addTooltip", false), env);
	
			@SuppressWarnings("resource")
			Tag icon = isCreate ? renderCreateIcon(context) : renderAddIcon(context);
			Button addButton = htmlFactory.button(icon.style().margin().right("5px"), getResourceString(context, isCreate ? "create" : "add", false))
					.style(Style.PRIMARY)
					.style().margin().left("5px")
					.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			wireFeatureAddButton(context, obj, feature, addButton);
			return addButton;
		}
		return null;
	}

	/**
	 * Assigns an action to the button. This implementation adds onClick handler which navigates to add/create page.
	 * If the feature supports multiple object type which can be added to it, use {@link Button}.item() method to
	 * create a drop-down button with multiple add handlers.
	 * @param context
	 * @param obj
	 * @param feature
	 * @return
	 * @throws Exception
	 */
	default void wireFeatureAddButton(C context, T obj, EStructuralFeature feature, Button addButton) throws Exception {
		// Example of items - addButton.item(getHTMLFactory(context).link("#", "My class"));
		
		addButton.on(Event.click, "window.location='add/"+feature.getName()+".html';");
	}	

	/**
	 * Renders delete button for feature value.
	 * @param context
	 * @param obj
	 * @param feature
	 * @param idx
	 * @param value
	 * @return
	 * @throws Exception
	 */
	default Button renderFeatureValueDeleteButton(C context, T obj, EStructuralFeature feature, int idx, Object value) throws Exception {
		boolean authorized;
		if (value instanceof EObject && feature instanceof EReference && ((EReference) feature).isContainment()) {
			// Deletion from the repository.
			authorized = context.authorizeDelete(value, null, null); 
		} else {
			// Removal from feature.
			authorized = context.authorizeDelete(obj, feature.getName(), null);
		}
		if (authorized) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, feature.getName());
			String tooltip = htmlFactory.interpolate(getResourceString(context, idx == -1 ? "clearTooltip" : "deleteTooltip", false), env);
	
			// Again, deletion through GET, not REST-compliant, but JavaScript part is kept simple.
			Button deleteButton = htmlFactory.button(idx == -1 ? renderClearIcon(context) : renderDeleteIcon(context))
					.style(Style.DANGER)
					.style().margin().left("5px")
					.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			wireFeatureValueDeleteButton(context, obj, feature, idx, value, deleteButton);
			return deleteButton;
		}
		return null;
	}

	/**
	 * Assigns an action to the button. This implementation adds onClick handler which navigates to delete page.
	 * @param feature
	 * @param idx
	 * @param editButton
	 */
	default void wireFeatureValueDeleteButton(C context, T obj, EStructuralFeature feature, int idx, Object value, Button deleteButton) throws Exception {
		Map<String, Object> env = new HashMap<>();
		env.put(NAME_KEY, feature.getName());
		String deleteConfirmationMessage = StringEscapeUtils.escapeEcmaScript(getHTMLFactory(context).interpolate(getResourceString(context, idx == -1 ? "confirmClear" : "confirmDelete", false), env));
		String deleteLocation;
		if (value instanceof EObject && feature instanceof EReference && ((EReference) feature).isContainment()) {
			deleteLocation = getRenderer(((EObject) value).eClass()).getObjectURI(context, (EObject) value)+"/delete.html";
		} else if (idx == -1) {
			deleteLocation = "delete/"+feature.getName()+".html";
		} else {
			deleteLocation = "delete/"+feature.getName()+"/"+idx+".html";			
		}
		deleteButton.on(Event.click, "if (confirm('"+deleteConfirmationMessage+"?')) window.location='"+deleteLocation+"';");
	}

	/**
	 * Renders edit button for feature value
	 * @param context
	 * @param feature
	 * @param idx Value index, shall be -1 for single-value features.
	 * @return
	 * @throws Exception
	 */
	default Button renderFeatureValueEditButton(C context, T obj, EStructuralFeature feature, int idx, Object value) throws Exception {		
		if (context.authorizeUpdate(obj, feature.getName(), null)) {
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, feature.getName());
			HTMLFactory htmlFactory = getHTMLFactory(context);
			String tooltip = htmlFactory.interpolate(getResourceString(context, idx == -1 ? "selectTooltip" : "editTooltip", false), env);
			Button editButton = htmlFactory.button(renderEditIcon(context))
				.style(Style.PRIMARY)
				.style().margin().left("5px")
				.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			wireFeatureValueEditButton(context, obj, feature, idx, value, editButton); 
			return editButton;
		}
		return null;
	}

	/**
	 * Assigns an action to the button. This implementation adds onClick handler which navigates to edit page.
	 * @param feature
	 * @param idx
	 * @param editButton
	 */
	default void wireFeatureValueEditButton(C context, T obj, EStructuralFeature feature, int idx, Object value, Button editButton) throws Exception {
		if (idx == -1) {
			editButton.on(Event.click, "window.location='edit/"+feature.getName()+".html");
		} else {
			editButton.on(Event.click, "window.location='edit/"+feature.getName()+"/"+idx+".html");			
		}
	}
	
	/**
	 * Renders button which navigates to feature value details page.
	 * @param context
	 * @param feature
	 * @param idx Value index, shall be -1 for single-value features.
	 * @return
	 * @throws Exception
	 */
	default Button renderFeatureValueViewButton(C context, T obj, EStructuralFeature feature, int idx, EObject value) throws Exception {		
		if (context.authorizeRead(value, null, null)) {
			Map<String, Object> env = new HashMap<>();
			env.put(NAME_KEY, getRenderer(value).renderLabel(context, value));
			HTMLFactory htmlFactory = getHTMLFactory(context);
			String tooltip = htmlFactory.interpolate(getResourceString(context, "viewTooltip", false), env);
			Button viewButton = htmlFactory.button(renderDetailsIcon(context))
				.style(Style.PRIMARY)
				.style().margin().left("5px")
				.attribute(TITLE_KEY, StringEscapeUtils.escapeHtml4(tooltip));
			
			wireFeatureValueViewButton(context, obj, feature, idx, value, viewButton); 
			return viewButton;
		}
		return null;
	}

	/**
	 * Assigns an action to the button. This implementation adds onClick handler which navigates to the value object page.
	 * @param feature
	 * @param idx
	 * @param editButton
	 * @throws Exception 
	 */
	default void wireFeatureValueViewButton(C context, T obj, EStructuralFeature feature, int idx, EObject value, Button viewButton) throws Exception {
		viewButton.on(Event.click, "window.location='"+getRenderer(((EObject) value).eClass()).getObjectURI(context, (EObject) value)+"/index.html'");
	}
	
	// Forms rendering 

	/**
	 * 
	 * @param obj
	 * @return A list of structural features to include into the object edit form. This implementation
	 * returns all visible features with !isTab() and authorized to update unless <code>editable</code> annotation is set to <code>false</code>  
	 * @throws Exception 
	 */
	default List<EStructuralFeature> getEditableFeatures(C context, T obj) throws Exception {
		List<EStructuralFeature> ret = new ArrayList<>();
		for (EStructuralFeature vsf: getVisibleFeatures(context, obj)) {
			if (context.authorizeUpdate(obj, vsf.getName(), null)) {
				String eav = getRenderAnnotation(context, vsf, ANNOTATION_KEY_EDITABLE);
				boolean isEditable = eav == null ? !isTab(context, vsf)  : !"false".equals(eav);
				if (isEditable) {
					ret.add(vsf);
				}
			}
		}
		return ret;
	}
	
	/**
	 * Renders control for the feature, e.g. input, select, or text area.
	 * 
	 * Annotations:
	 * 
	 * * ``control`` - defaults to input for attributes and multi-value features and select for references.
	 *     * input (default),
	 *     * select
	 *     * textarea
	 * * ``input-type`` - for ``input`` control - one of {@link HTMLFactory.InputType} values. Checkbox for booleans and multi-value features, text otherwise.
	 * @param context
	 * @param obj
	 * @param feature
	 * @return Null for checkboxes and radios - they are added directly to the fieldContainer. Control to add to a field group otherwise.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	default UIElement<?> renderFeatureControl(
			C context, 
			T obj, 
			EStructuralFeature feature, 
			FieldContainer<?> fieldContainer, 
			Modal docModal, 
			ValidationResult validationResult,
			boolean helpTooltip) throws Exception {
		Object fv = obj.eGet(feature);
		String controlType = getRenderAnnotation(context, feature, "control");
		if (controlType == null) {
			if (feature.isMany()) {
				controlType = "input";
			} else if (feature instanceof EAttribute) {				
				controlType = feature.getEType() instanceof EEnum ? "select" : "input";
			} else {
				controlType = "select";
			}
		}
		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Object label = renderNamedElementIconAndLabel(context, feature);
		String textLabel = Jsoup.parse(label.toString()).text();
		if (helpTooltip) {
			label = getHTMLFactory(context).fragment(label, renderDocumentationIcon(context, feature, docModal, true));			
		}
		switch (controlType) {
		case "input":
			String inputTypeStr = getRenderAnnotation(context, feature, "input-type");
			InputType inputType = inputTypeStr == null ? null : HTMLFactory.InputType.valueOf(inputTypeStr);
			if (inputType == null) {
				if (feature.isMany()) {
					inputType = InputType.checkbox;
				} else {
					Class<?> featureTypeInstanceClass = feature.getEType().getInstanceClass();
					if (Boolean.class == featureTypeInstanceClass || boolean.class == featureTypeInstanceClass) {
						inputType = InputType.checkbox;
					} else if (Number.class.isAssignableFrom(featureTypeInstanceClass)) {
						inputType = InputType.number;
					} else if (Date.class == featureTypeInstanceClass) {
						inputType = InputType.date;
					} else {
						inputType = InputType.text;
					}
				}
			}
			
			switch (inputType) {
			case checkbox:
				if (feature.isMany()) {
					// Render a checkbox per choice.
					FieldSet checkboxesFieldSet = fieldContainer.fieldset();
					checkboxesFieldSet.style()
						.border().bottom("solid 1px "+Bootstrap.Color.GRAY_LIGHT.code)
						.style().margin().bottom("5px");
					checkboxesFieldSet.legend(label);
					Set<String> valuesToSelect = new HashSet<>();
					for (Object fev: ((Collection<Object>) fv)) {
						valuesToSelect.add(renderFeatureValue(context, feature, fev).toString());
					}
					for (Entry<String, String> fc: getFeatureChoices(context, obj, feature)) {
						Input checkbox = htmlFactory.input(inputType);
						checkbox.name(feature.getName());
						checkbox.value(StringEscapeUtils.escapeHtml4(fc.getKey()));
						if (valuesToSelect.contains(fc.getKey())) {
							checkbox.attribute("checked", "true");
						}
						checkboxesFieldSet.checkbox(fc.getValue(), checkbox, false);
					}					
					return null;
				}
				
				Input checkbox = htmlFactory.input(inputType);
				checkbox.name(feature.getName());
				checkbox.value(true);
				if (Boolean.TRUE.equals(fv)) {
					checkbox.attribute("checked", "true");					
				}

				fieldContainer.checkbox(renderNamedElementLabel(context, feature), checkbox, true);
				return null;
			case radio:
				// Radio - get values and labels from options.
				FieldSet radiosFieldSet = fieldContainer.fieldset();
				radiosFieldSet.style()
					.border().bottom("solid 1px "+Bootstrap.Color.GRAY_LIGHT.code)
					.style().margin().bottom("5px");
				radiosFieldSet.legend(label);
				String valueToSelect = fv == null ? null : renderFeatureValue(context, feature, fv).toString();
				for (Entry<String, String> fc: getFeatureChoices(context, obj, feature)) {
					Input radio = htmlFactory.input(inputType)
							.name(feature.getName())
							.value(StringEscapeUtils.escapeHtml4(renderFeatureValue(context, feature, fv).toString()))
							.placeholder(textLabel)
							.required(isRequired(context, obj, feature));
					if (valueToSelect != null && valueToSelect.equals(fc.getKey())) {
						radio.attribute("checked", "true");
					}
					radiosFieldSet.radio(fc.getValue(), radio, false);
				}
				return null;
			default:
				return htmlFactory.input(inputType)
					.name(feature.getName())
					.value(StringEscapeUtils.escapeHtml4(renderFeatureValue(context, feature, fv).toString()))
					.placeholder(textLabel)
					.required(isRequired(context, obj, feature));								
			}
		case "select":
			Select select = htmlFactory.select()
				.name(feature.getName())
				.required(isRequired(context, obj, feature));
			String valueToSelect = fv == null ? null : renderFeatureValue(context, feature, fv).toString();
			for (Entry<String, String> fc: getFeatureChoices(context, obj, feature)) {
				select.option(StringEscapeUtils.escapeHtml4(fc.getKey()), StringEscapeUtils.escapeHtml4(fc.getValue()), valueToSelect != null && valueToSelect.equals(fc.getKey()), false);
			}
			return select;
		case "textarea":
			TextArea textArea = htmlFactory.textArea()
				.name(feature.getName())
				.placeholder(textLabel)
				.required(isRequired(context, obj, feature));			
			textArea.content(StringEscapeUtils.escapeHtml4(renderFeatureValue(context, feature, fv).toString()));
			return textArea;
		default:
			throw new IllegalArgumentException("Unsupported control type: "+controlType);
		}
	}
	
	/**
	 * Returns true if given feature is required. This implementation returns true if feature is not many and lower bound is not 0.
	 * @param context
	 * @param obj
	 * @param feature
	 * @throws Exception
	 */
	default boolean isRequired(C context, T obj, EStructuralFeature feature) throws Exception {
		return !feature.isMany() && feature.getLowerBound() != 0;
	}

	/**
	 * Invoked for select, radio and checkbox on non-boolean types. 
	 * 
	 * This implementation loads choices from the ``choices`` annotation.
	 * Choices are defined each on a new line as a value - label pair <value>=<label>.     
	 * @return
	 */
	default Collection<Map.Entry<String, String>> getFeatureChoices(C context, T obj, EStructuralFeature feature) throws Exception {
		Map<String,String> collector = new LinkedHashMap<>();
		String choicesAnnotation = getRenderAnnotation(context, feature, "choices");
		if (choicesAnnotation == null) {
			Class<?> featureTypeInstanceClass = feature.getEType().getInstanceClass();
			if (featureTypeInstanceClass.isEnum()) {
				for (Field field: featureTypeInstanceClass.getFields()) {
					if (field.isEnumConstant()) {
						Object fieldValue = field.get(null);
						if (fieldValue instanceof Enumerator) {
							collector.put(field.getName(), ((Enumerator) fieldValue).getLiteral());
						} else {
							collector.put(field.getName(), fieldValue.toString());							
						}
					}
				}
			}
		} else {
			try (BufferedReader br = new BufferedReader(new StringReader(choicesAnnotation))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (!CoreUtil.isBlank(line) && !line.startsWith("#")) {
						int idx = line.indexOf('=');
						if (idx == -1) {
							collector.put(line, line);
						} else {
							collector.put(line.substring(0, idx), line.substring(idx+1));							
						}
					}
				}
			}
		}
		
		return Collections.unmodifiableCollection(collector.entrySet());
	}
	
	/**
	 * Renders doc modals for editable features.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Map<EStructuralFeature, Modal> renderEditableFeaturesDocModals(C context, T obj) throws Exception {
		return renderFeaturesDocModals(context, obj, getEditableFeatures(context, obj));
	}	
	
	default Object renderFeatureFormGroupHelpText(C context, T obj, EStructuralFeature feature, Modal docModal) throws Exception {		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment ret = htmlFactory.fragment();		
		String doc = renderDocumentation(context, feature);
		if (doc != null) {
			String textDoc = Jsoup.parse(doc).text();
			String firstSentence = firstSentence(context, textDoc);			
			ret.content(firstSentence);
			if (!textDoc.equals(firstSentence) && docModal != null) {
				Tag helpGlyph = renderHelpIcon(context);
				helpGlyph.on(Event.click, "$('#"+docModal.getId()+"').modal('show')");
				helpGlyph.style("cursor", "pointer");
				ret.content(helpGlyph);
			}
		}
		return ret.isEmpty() ? null : ret;
	}	
	
	/**
	 * Renders help icon. This implementation uses FontAwesome WebApplication.question_circle_o.
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	default Tag renderHelpIcon(C context) throws Exception {
		return getHTMLFactory(context).fontAwesome().webApplication(WebApplication.question_circle_o).getTarget();
	}
	
	/**
	 * Renders form group if renderFeatureControl() returns non-null value.
	 * This implementation renders FormInputGroup if:
	 * 
	 * * ``form-input-group`` annotation is true.
	 * * ``form-input-group`` annotation is not present and:
	 *     * control is ``input`` tag.
	 *     * Feature has either icon (rendered on the left) or help icon (rendered on the right).  
	 * 
	 * @param context
	 * @param obj
	 * @param feature
	 * @param fieldContainer
	 * @param docModal
	 * @param errorMessage
	 * @param helpTooltip If true, help message is rendered as a tooltip over a help annotation, like in the view. Otherwise it is renders as form group help text
	 *  (not visible in some layouts). 
	 * @return FormGroup. 
	 * @throws Exception
	 */
	default FormGroup<?> renderFeatureFormGroup(
			C context, 
			T obj, 
			EStructuralFeature feature, 
			FieldContainer<?> fieldContainer, 
			Modal docModal, 
			ValidationResult validationResult,
			boolean helpTooltip) throws Exception {
		
		UIElement<?> control = renderFeatureControl(context, obj, feature, fieldContainer, docModal, validationResult, helpTooltip);
		if (control == null) {
			return null;
		}
		
		Object icon = renderModelElementIcon(context, feature);
		Tag docIcon = renderDocumentationIcon(context, feature, docModal, false);
		
		boolean isFormInputGroup;
		String formInputGroupAnnotation = getRenderAnnotation(context, feature, "form-input-group");
		if (formInputGroupAnnotation == null) {
			isFormInputGroup = control instanceof Input && (icon != null || docIcon != null);	
		} else {
			isFormInputGroup = "true".equals(formInputGroupAnnotation);
		}
		
		Object helpText = helpTooltip ? null : renderFeatureFormGroupHelpText(context, obj, feature, docModal);

		HTMLFactory htmlFactory = getHTMLFactory(context);
		
		if (validationResult != null) {
			Tag validationLabel = htmlFactory.label(validationResult.status.toStyle(), validationResult.message);
			if (helpText == null) {
				helpText = validationLabel;
			} else {
				helpText = htmlFactory.fragment(validationLabel, " ", helpText);
			}
		}
		
		if (isFormInputGroup) {
			Object label = renderNamedElementLabel(context, feature);
			if (isRequired(context, obj, feature)) {
				label = htmlFactory.fragment(label, "*");
			}
			FormInputGroup ret = fieldContainer.formInputGroup(label, control, helpText);
			if (icon != null) {
				ret.leftAddOn(icon);
			}
			if (docIcon != null) {
				ret.rightAddOn(docIcon);
			}
			if (validationResult != null) {
				ret.status(validationResult.status);
			}			
			return ret;
		}
				
		Object label = renderNamedElementIconAndLabel(context, feature);
		if (isRequired(context, obj, feature)) {
			label = htmlFactory.fragment(label, "*");
		}
		
		if (helpTooltip && docIcon != null) {
			label = htmlFactory.fragment(label, htmlFactory.tag(TagName.sup, docIcon));
		}
		FormGroup<?> ret = fieldContainer.formGroup(label, control, helpText);
		if (validationResult != null) {
			ret.status(validationResult.status);
		}
		return ret;
	}
	
	/**
	 * Helper class to pass validation results around.
	 * @author Pavel
	 *
	 */
	class ValidationResult {
		
		final FormGroup.Status status;
		final String message;
		
		public ValidationResult(FormGroup.Status status, String message) {
			super();
			this.status = status;
			this.message = message;
		}
		
	}
	
	/**
	 * Renders form groups for editable features.
	 * @param context
	 * @param obj
	 * @param fieldContainer
	 * @param docModals
	 * @param validationResults
	 * @param helpTooltip
	 * @throws Exception
	 */
	default List<FormGroup<?>> renderEditableFeaturesFormGroups(
			C context, 
			T obj, 
			FieldContainer<?> fieldContainer, 
			Map<EStructuralFeature, Modal> docModals, 
			Map<EStructuralFeature,ValidationResult> errorMessages,
			boolean helpTooltip) throws Exception {
		
		List<FormGroup<?>> ret = new ArrayList<>();
		for (EStructuralFeature esf: getEditableFeatures(context, obj)) {
			FormGroup<?> fg = renderFeatureFormGroup(context, obj, esf, fieldContainer, docModals.get(esf), errorMessages.get(esf), helpTooltip);
			if (fg != null) {
				ret.add(fg);
			}
		}
		return ret;
	}
	
	/** 
	 * Reads feature values for editable features from the request, parses them and sets feature values.
	 * Then validates the object. Invokes diagnostic consumer, if it is not null, for object-level results and results associated with one of editable features.
	 * @return true if there are no errors in object-level and editable features results.
	 */
	default boolean setEditableFeatures(C context, T obj, Consumer<Diagnostic> diagnosticConsumer) throws Exception {		
		List<EStructuralFeature> editableFeatures = getEditableFeatures(context, obj);
		for (EStructuralFeature esf: editableFeatures) {
			setFeatureValue(context, obj, esf);
		}
		Diagnostic vr = validate(context, obj);
		boolean noErrors = true;
		for (Diagnostic vc: vr.getChildren()) {
			List<?> vcData = vc.getData();
			if (!vcData.isEmpty() 
					&& vcData.get(0) == obj 
					&& (vcData.size() == 1 || editableFeatures.contains(vcData.get(1)))) {
				
				if (vc.getSeverity() == Diagnostic.ERROR) {
					noErrors = false;
				}
				if (diagnosticConsumer != null) {
					diagnosticConsumer.accept(vc);
				}
			}
		}
		
		return noErrors;
	}
	
	default Diagnostic validate(C context, T obj) throws Exception {
		Diagnostician diagnostician = new Diagnostician() {
			
			@Override
			public String getObjectLabel(EObject eObject) {
				try {
					Object label = getRenderer(eObject).renderLabel(context, eObject);
					String ret = label== null ? null : Jsoup.parse(label.toString()).text();
					return ret == null ? super.getObjectLabel(eObject) : ret;
				} catch (Exception e) {
					return super.getObjectLabel(eObject);
				}
			}
			
			@Override
			public Map<Object, Object> createDefaultContext() {
				Map<Object, Object> ret = super.createDefaultContext();
				ret.put(Context.class, context);
				ret.put(Renderer.class, this);
				return ret;
			}
			
		}; 

		return diagnostician.validate(obj);
	}
	
	/**
	 * Renders a tree item for the object with the tree features under.
	 * @param context Context
	 * @param obj Object
	 * @param depth tree depth, -1 - infinite depth.
	 * @param itemFilter If not null, it is invoked when object list items are created. Filters can decorate or replace list items. Filter is invoked twice per item - first for the label and then for 
	 * the entire ``li`` tag. In both cases data is set to the object. For the ``li`` invocation ``role`` property is set to ``item``
	 * @param jsTree If true, list items are rendered for jsTree. It is responsibility of the caller code to create jsTree container and provide event handler for clicks.
	 * @return
	 */
	default Object renderTreeItem(C context, T obj, int depth, Function<Object, Object> itemFilter, boolean jsTree) throws Exception {
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Tag ret = htmlFactory.tag(TagName.li);
		ret.setData(obj);
		ret.setData("role", "item");
		if (jsTree) {
			JsTree jt = ret.jsTree();
			jt.icon(getIcon(context, obj));
			String objectURI = getObjectURI(context, obj);
			Object link = htmlFactory.link(objectURI == null ? "#" : objectURI+"/"+INDEX_HTML, renderLabel(context, obj)).setData(obj);
			if (itemFilter != null) {
				link = itemFilter.apply(link);
			}
			ret.content(link);
		} else {
			Object link = renderLink(context, obj, true);
			if (itemFilter != null) {
				link = itemFilter.apply(link);
			}
			ret.content(link);
		}
		
		ret.content(renderReferencesTree(context, obj, depth, itemFilter, jsTree));
		return itemFilter == null ? ret : itemFilter.apply(ret);
	}	

	/**
	 * Renders an object tree of tree references of the argument object. Tree features are those listed in the ``tree-references`` annotation separated by space.
	 * If there is no annotation, then containing many features are considered as tree features. If ``tree-node`` annotation of the feature is set to false, then feature elements
	 * appear directly under the container. Otherwise, a tree node with feature name and icon (if available) is created to hold feature elements. 
	 * @param context Context
	 * @param obj Object
	 * @param depth tree depth, -1 - infinite depth.
	 * @param itemFilter If not null, it is invoked when object list items are created. Filters can decorate or replace list items. 
	 * @param jsTree If true, list items are rendered for jsTree.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default Object renderReferencesTree(C context, T obj, int depth, Function<Object, Object> itemFilter, boolean jsTree) throws Exception {
		if (depth == 0) {
			return null;
		}
		
		List<EReference> treeReferences = new ArrayList<EReference>();
		EClass eClass = obj.eClass();
		String treeReferencesAnnotation = getRenderAnnotation(context, eClass, "tree-references");
		if (treeReferencesAnnotation == null) {
			for (EReference ref: eClass.getEAllReferences()) {
				if (ref.isContainment() && ref.isMany() && context.authorizeRead(obj, ref.getName(), null)) {
					treeReferences.add(ref);
				}
			}
		} else {
			for (String refName: treeReferencesAnnotation.split("\\s+")) {
				if (!CoreUtil.isBlank(refName)) {
					EReference sf = (EReference) eClass.getEStructuralFeature(refName.trim());
					if (sf instanceof EReference && context.authorizeRead(obj, sf.getName(), null)) {
						treeReferences.add(sf);
					}
				}
			}
		}
		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Tag ret = htmlFactory.tag(TagName.ul);
		for (EReference treeReference: treeReferences) {
			String treeNodeAnnotation = getRenderAnnotation(context, treeReference, "tree-node");
			boolean isTreeNode = !"false".equals(treeNodeAnnotation);
			Tag itemContainer = ret;
			if (isTreeNode) {
				Tag refNode = htmlFactory.tag(TagName.li);
				refNode.setData(treeReference);
				refNode.setData("role", "item");
				if (jsTree) {
					JsTree jt = refNode.jsTree();
					jt.icon(getModelElementIcon(context, treeReference));
					refNode.content(renderNamedElementLabel(context, treeReference));
				} else {
					refNode.content(renderNamedElementIconAndLabel(context, treeReference));
				}
				itemContainer = htmlFactory.tag(TagName.ul);
				refNode.content(itemContainer);
			} 
			
			if (treeReference.isMany()) {
				for (EObject ref: (Collection<? extends EObject>) obj.eGet(treeReference)) {
					itemContainer.content(getRenderer(ref).renderTreeItem(context, ref, depth == -1 ? -1 : depth - 1, itemFilter, jsTree));
				}
			} else {
				Object ref = obj.eGet(treeReference);
				if (ref instanceof EObject) {
					itemContainer.content(getRenderer((EObject) ref).renderTreeItem(context, (EObject) ref, depth == -1 ? -1 : depth - 1, itemFilter, jsTree));
				}				
			}
		}
		
		return ret.isEmpty() ? null : ret;
	}
	
		
}
