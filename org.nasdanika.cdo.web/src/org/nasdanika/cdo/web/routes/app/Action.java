package org.nasdanika.cdo.web.routes.app;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.Context;
import org.nasdanika.web.DispatchingRoute.Target;
import org.nasdanika.web.RequestMethod;

/**
 * Actions contribute buttons to object or feature views and context menu items to object and feature nodes.
 * They can also act as object factories and editors. Action paths shall be unique within the defined object.
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
		 * Factory action - contributes to create items of its feature, applicable only to feature actions.
		 */
		factory,		
		/**
		 * Editor action - replaces the edit button.
		 */
		editor
	}
	
	default String getIcon() throws Exception {
		return null;
	};
	
	String getLabel() throws Exception;
	
	default Role getRole() throws Exception {
		return Role.action;
	}; 
	
	/**
	 * Confirmation message to guard action execution.
	 * @return
	 * @throws Exception
	 */
	default String getConfirmation() throws Exception {
		return null;
	};
	
	/**
	 * @return {@link EStructuralFeature} this action is associated with.
	 * @throws Exception
	 */
	default EStructuralFeature getFeature() throws Exception {
		return null;
	};
		
	default boolean canExecute() throws Exception {
		return true;
	};	

	/**
	 * Actions shall not use patterns because they are addressed from the UI by their path.
	 */
	@Override
	default Pattern getPattern() {
		return null;
	}
	
	@Override
	default String getAction() {
		return AuthorizationProvider.StandardAction.execute.name();
	}
	
	/**
	 * Serve all by default
	 */
	@Override
	default RequestMethod[] getRequestMethods() {
		return RequestMethod.values();
	}

	@Override
	default String getProduces() {
		return null;
	}

	@Override
	default String[] getConsumes() {
		return null;
	}

	@Override
	default public String getQualifier() {
		return null;
	}

	@Override
	default public String getComment() {
		return null;
	}
		
}
