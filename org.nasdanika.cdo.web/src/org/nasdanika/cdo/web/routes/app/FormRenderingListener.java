package org.nasdanika.cdo.web.routes.app;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.core.Context;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.UIElement;

/**
 * Subclasses of this class can be passed to form rendering methods to 
 * receive notifications of rendering of different form elements such as controls, form groups and fieldsets
 * in order to customize or replace (e.g. wrap) rendered elements.
 * 
 * Methods of this class do nothing, they simply return form elements passed to them, override as needed.
 * @author Pavel Vlasov
 *
 */
public class FormRenderingListener<C extends Context, T extends EObject, TE extends ETypedElement> {
	
	private static final FormRenderingListener<Context, EObject, ETypedElement> NOP_LISTENER = new FormRenderingListener<Context, EObject, ETypedElement>();
	
	@SuppressWarnings("unchecked")
	public static <C extends Context, T extends EObject, TE extends ETypedElement> FormRenderingListener<C,T,TE> nopListener() {
		return (FormRenderingListener<C, T, TE>) NOP_LISTENER;
	}
	
	public UIElement<?> onFormControlRendering(C context, T obj, TE typedElement, Object value, UIElement<?> control) {
		return control;
	}

	public void onFormGroupRendering(C context, T obj, TE typedElement, Object value, FormGroup<?> formGroup) {
		
	}
	
	public void onCategoryFieldSet(C context, T obj, String category, List<TE> categoryMembers, FieldSet categoryFieldSet) {
		
	}

	/**
	 * Invoked before form rendering.
	 * @param context
	 * @param obj
	 * @param form
	 */
	public void onBeforeFormRendering(C context, T obj, Form form) {
		
	}
	
	// TODO - onFieldSet

}
