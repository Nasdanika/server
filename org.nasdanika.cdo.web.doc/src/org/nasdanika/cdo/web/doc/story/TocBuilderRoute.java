package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.TocNode;
import org.nasdanika.web.Route;

/**
 * A combination of a route and toc node factory.
 * @author Pavel Vlasov
 *
 */
public interface TocBuilderRoute<T> extends Route {
	
	void createToc(T obj, TocNode parent);

}
