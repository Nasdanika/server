package org.nasdanika.cdo.web.routes.app;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.core.Context;
import org.nasdanika.web.DispatchingRoute.Target;

/**
 * Actions contribute buttons to object or feature views and context menu items to object and feature nodes.
 * They can also act as object builder and editors. Action paths shall be unique within the defined object.
 * @author Pavel Vlasov
 *
 * @param <C>
 * @param <T>
 */
public interface Action<C extends Context, T extends EObject> extends Target {
	
	// TODO - location (view/left panel)
	
	enum Role {
		/**
		 * Regular action
		 */
		action,
		/**
		 * Builder action - contributes to create items of its feature, applicable only to feature actions.
		 */
		builder,		
		/**
		 * Editor action - replaces the edit button.
		 */
		editor
	}
	
	String getIcon() throws Exception;
	
	String getLabel() throws Exception;
	
	Role getRole() throws Exception;
	
	/**
	 * Confirmation message to guard action execution.
	 * @return
	 * @throws Exception
	 */
	String getConfirmation() throws Exception;
	
	/**
	 * @return {@link EStructuralFeature} this action is associated with.
	 * @throws Exception
	 */
	EStructuralFeature getFeature() throws Exception;
		
	boolean canExecute() throws Exception;	
	
}
