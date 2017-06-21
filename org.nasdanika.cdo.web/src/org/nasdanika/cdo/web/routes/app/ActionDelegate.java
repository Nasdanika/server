package org.nasdanika.cdo.web.routes.app;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * Actions defined through annotations use delegates for actual execution.
 * Such delegates must implement this interface.
 * @author Pavel Vlasov
 *
 * @param <C>
 * @param <T>
 */
public interface ActionDelegate<C extends Context, T extends EObject> {
	
	Object execute(C context, T obj, Renderer<C,T> renderer) throws Exception;

}
