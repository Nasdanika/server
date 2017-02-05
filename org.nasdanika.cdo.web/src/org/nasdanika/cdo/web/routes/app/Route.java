package org.nasdanika.cdo.web.routes.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Resource;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.TargetParameter;
import org.osgi.framework.BundleContext;

/**
 * Application route providing CRUD operations for the underlying EObject.
 * @author Pavel
 *
 * @param <T>
 */
@Resource(
		value="/", 
		bundle="org.nasdanika.web.resources", 
		path="resources/", 
		comment="Web resources")
public class Route<C extends HttpServletRequestContext, T extends EObject> extends EDispatchingRoute implements Renderer<C, T> {

	protected Route(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext, targets);
	} 

	/**
	 * Renders object view page - single value features in a table with two columns 
	 * and "many" features in tabs. 
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Renders object view with breadcrumbs, single features in a table, edit button, and many features in tabs with add/edit/delete controls")
	public Object getIndexHtml(
			@ContextParameter C context, 
			@TargetParameter T target) throws Exception {
		
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(((EObject) context.getTarget()).eClass().getName()));
		Fragment content = HTMLFactory.INSTANCE.fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		List<EStructuralFeature> visibleFeatures = getVisibleStructuralFeatures(context, target);
		
		Map<EStructuralFeature, Modal> featureDocModals = new HashMap<>();
		for (EStructuralFeature vf: visibleFeatures) {
			Modal fdm = renderDocumentationModal(context, vf);
			if (fdm != null) {
				featureDocModals.put(vf, fdm);
				content.content(fdm);
			}
		}
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// Header
		Tag header = content.getFactory().tag(TagName.h3, renderNamedElementLabel(context, target.eClass()), " ", renderLabel(context, target));
		Tag classDocIcon = renderDocumentationIcon(context, target.eClass(), classDocModal);
		if (classDocIcon != null) {
			header.content(classDocIcon);
		}
		content.content(header);
		
		// !many features - label, question mark, tooltip, modal.
		Table featuresTable = content.getFactory().table();
		content.content(featuresTable);
		featuresTable.col().bootstrap().grid().col(1);
		featuresTable.col().bootstrap().grid().col(11);

		Tabs featureTabs = content.getFactory().tabs();
		for (EStructuralFeature vf: visibleFeatures) {
			Tag featureDocIcon = renderDocumentationIcon(context, vf, featureDocModals.get(vf));
			if (vf.isMany()) {
				Tag nameSpan = content.getFactory().span(renderNamedElementLabel(context, vf));
				if (featureDocIcon != null) {
					nameSpan.content(featureDocIcon);
				}
				featureTabs.item(nameSpan, "TODO - table, add button");
			} else {
				Row fRow = featuresTable.body().row();
				Cell fLabelCell = fRow.header(renderNamedElementLabel(context, vf));
				if (featureDocIcon != null) {
					fLabelCell.content(featureDocIcon);
				}
				fRow.cell(renderFeatureValue(context, vf, target.eGet(vf)));
			}
		}
		
		// Edit button
		
		// many features => tabs
		
		if (!featureTabs.isEmpty()) {
			content.content(featureTabs);
		}
		
		// page template
		
		Map<String, Object> env = new HashMap<>();
		env.put("title", title);
		env.put("content", content);
		return HTMLFactory.INSTANCE.interpolate(getPageTemplate(), env);		
		
	}
	
	/**
	 * @return page template which takes <code>template</code> and <code>content</code> tokens for interpolation.
	 * This implementation returns a minimalistic page template with Bootstrap, Knockout, require.js, jquery.js and knockout.js scripts.
	 * 
	 */
	protected Object getPageTemplate() {
		return Route.class.getResource("page-template.html");
	}
	
	@Override
	protected String getApiDocPath() {
		return "api.html";
	}
	
	
	// Object diagram png
	
}
