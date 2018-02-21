package org.nasdanika.cdo.web.routes.app;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.jsoup.Jsoup;
import org.nasdanika.core.AuthorizationProvider.StandardAction;
import org.nasdanika.core.Context;
import org.nasdanika.html.Bootstrap.Color;
import org.nasdanika.html.Dropdown;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.HttpServletRequestContext;

/**
 * Manages filter drop-downs in column headers and filters table rows.
 * @author Pavel Vlasov
 *
 * @param <C>
 * @param <T>
 */
public class FeatureTableFilterManager<C extends Context, T extends EObject> extends TypedElementTableRenderListenerFilter<C, T> implements Predicate<Object> {
	
	private final String featureFilterParameterPrefix;
	private C context;
	private EStructuralFeature feature;
	private Renderer<C, T> renderer;
	private EClass featureType;
	private Consumer<Object> appConsumer;	
	
	public FeatureTableFilterManager(C context, EStructuralFeature feature, Renderer<C,T> renderer, TypedElementTableRenderListener<C,T> chain, Consumer<Object> appConsumer) {
		super(chain);
		this.context = context;
		this.feature = feature;
		this.renderer = renderer;
		this.appConsumer = appConsumer;
		featureType = (EClass) feature.getEType();	
		featureFilterParameterPrefix = "filter-"+feature.getName()+"-";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onFeatureHeader(
			C context, 
			T obj, 
			ETypedElement typedElement, 
			Object typedElementValue,
			EStructuralFeature tableFeature, 
			Object featureSpec, 
			Cell featureHeader) throws Exception {
		
		super.onFeatureHeader(context, obj, typedElement, typedElementValue, tableFeature, featureSpec, featureHeader);
		
		if (featureSpec instanceof Map && Boolean.TRUE.equals(((Map<?,?>) featureSpec).get("filter")) && context instanceof HttpServletRequestContext) {
			Set<Object> filterChoices = new HashSet<>(); 
			for (EObject element: (Collection<EObject>) typedElementValue) {
				if (test(element) && context.authorize(element, StandardAction.read, null, null)) {
					Object fv = element.eGet(tableFeature);
					if (fv != null) {
						if (fv instanceof EObject && !context.authorize(fv, StandardAction.read, null, null)) {
							continue;
						}						
						filterChoices.add(fv);
					}
				}								
			}
			
			boolean showFilter = filterChoices.size() > 1;
			
			HTMLFactory htmlFactory = featureHeader.getFactory();
			Dropdown<?> filterDropDown = htmlFactory.caretDropdown().attribute("title", "Filters rows by column value");
			String filterParameterName = featureFilterParameterPrefix+tableFeature.getName();
			HttpServletRequest request = ((HttpServletRequestContext) context).getRequest();
			String filterParameterValue = request.getParameter(filterParameterName);
			Renderer<C, EObject> typeRenderer = renderer.getRenderer((EClass) typedElement.getEType());
			
			StringBuilder queryBuilder = new StringBuilder();
			String requestQueryString = request.getQueryString();					
			if (requestQueryString != null) {
				for (String segment: requestQueryString.split("&")) {
					if (!segment.startsWith(filterParameterName+"=") && !segment.startsWith("context-feature=")) {
						if (queryBuilder.length() == 0) {
							queryBuilder.append("?");
						} else {
							queryBuilder.append("&");
						}
						queryBuilder.append(segment);
					}
				}
			}
			
			// Context feature
			if (queryBuilder.length() == 0) {
				queryBuilder.append("?");
			} else {
				queryBuilder.append("&");
			}
			queryBuilder.append("context-feature="+feature.getName());
			
			if (filterParameterValue == null) {
				filterDropDown.header("Filter");						
			} else {						
				showFilter = true;
				Object filterValue = typeRenderer.parseTypedElementValue(context, tableFeature, filterParameterValue);
				filterChoices.remove(filterValue);
				Object filterIconAndLabel;
				if (filterValue instanceof EObject) {
					filterIconAndLabel = renderer.getRenderer((EObject) filterValue).renderIconAndLabel(context, (EObject) filterValue);
				} else {
					filterIconAndLabel = typeRenderer.renderTypedElementValue(context, typedElement, filterValue, appConsumer, false);
				}
				Tag trashCanIcon = htmlFactory.tag(TagName.i).addClass("far fa-trash-alt").style().color().bootstrapColor(Color.PRIMARY);
				// TODO - build query
				Tag clearFilterLink = htmlFactory.link(request.getRequestURI()+queryBuilder, trashCanIcon).attribute("title", "Clear filter");						
				filterDropDown.header(htmlFactory.span("Filter: ", filterIconAndLabel, " ", clearFilterLink).style().color().bootstrapColor(Color.PRIMARY));						
				filterDropDown.style().color().bootstrapColor(Color.PRIMARY);
			}
			
			if (showFilter) {
				// Object, icon and label, text
				List<Object[]> dropDownItems = new ArrayList<>();
				for (Object filterChoice: filterChoices) {
					Object filterChoiceIconAndLabel;
					if (filterChoice instanceof EObject) {
						filterChoiceIconAndLabel = renderer.getRenderer((EObject) filterChoice).renderIconAndLabel(context, (EObject) filterChoice);
					} else {
						filterChoiceIconAndLabel = typeRenderer.renderTypedElementValue(context, typedElement, filterChoice, appConsumer, false);
					}			
					dropDownItems.add(new Object[] { 
							filterChoice, 
							filterChoiceIconAndLabel, 
							Jsoup.parse(String.valueOf(filterChoiceIconAndLabel)).text() });
				}
										
				dropDownItems.sort((a,b) -> ((String) a[2]).compareTo((String) b[2]));
				for (Object[] dropDownItem: dropDownItems) {
					String filterSegment = filterParameterName+"="+URLEncoder.encode(typeRenderer.getFormControlValue(context, null, tableFeature, dropDownItem[0], appConsumer), StandardCharsets.UTF_8.name());
					String href = request.getRequestURI() + queryBuilder + (queryBuilder.length() == 0 ? "?" : "&") + filterSegment;
					filterDropDown.item(htmlFactory.link(href, dropDownItem[1]));
				}
				featureHeader.content(filterDropDown);
			}
		}
		
		super.onFeatureHeader(context, obj, typedElement, typedElementValue, tableFeature, featureSpec, featureHeader);							
	}

	/**
	 * Filters rows
	 */
	@Override
	public boolean test(Object element) {
		if (context instanceof HttpServletRequestContext) {
			for (EStructuralFeature esf: ((EClass) featureType).getEAllStructuralFeatures()) {
				String filterParameterValue = ((HttpServletRequestContext) context).getRequest().getParameter(featureFilterParameterPrefix+esf.getName());
				if (filterParameterValue != null) {
					try {
						Object filterValue = renderer.getRenderer((EObject) element).parseTypedElementValue(context, esf, filterParameterValue);
						if (!filterValue.equals(((EObject) element).eGet(esf))) {
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}
}