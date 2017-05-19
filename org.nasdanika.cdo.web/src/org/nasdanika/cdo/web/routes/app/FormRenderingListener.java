package org.nasdanika.cdo.web.routes.app;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.core.Context;
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
public class FormRenderingListener<C extends Context, T extends EObject> {
	
	private static final FormRenderingListener<Context, EObject> NOP_LISTENER = new FormRenderingListener<Context, EObject>();
	
	@SuppressWarnings("unchecked")
	public static <C extends Context, T extends EObject> FormRenderingListener<C,T> nopListener() {
		return (FormRenderingListener<C, T>) NOP_LISTENER;
	}
	
	public UIElement<?> onFormControlRendering(C context, T obj, ETypedElement typedElement, Object value, UIElement<?> control) {
		return control;
	}
	
	// TODO - onFieldSet

}
