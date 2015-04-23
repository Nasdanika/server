package org.nasdanika.cdo.sca;

import org.nasdanika.core.Context;

/**
 * @author Pavel
 *
 */
public interface ComponentFactory {
	
	/**
	 * Creates a component
	 * @param componentId Component unique identifier.
	 * @return Component instance or null, if given id is not supported.
	 */
	Component createComponent(Context context, String componentId) throws Exception;

}
