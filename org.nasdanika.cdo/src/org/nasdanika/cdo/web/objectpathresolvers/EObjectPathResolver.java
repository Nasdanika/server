package org.nasdanika.cdo.web.objectpathresolvers;

import java.net.URLEncoder;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;
import org.nasdanika.web.WebContext;

/**
 * Resolves EObject path relative to its resource using URI fragment.
 * @author Pavel
 *
 */
public class EObjectPathResolver implements ObjectPathResolver<EObject> {

	@Override
	public String resolve(EObject obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		Resource res = obj.eResource();
		if (res!=null) {
			String resPath = master.resolve(res, master, context);
			if (resPath!=null) {
				String fragment = res.getURIFragment(obj);
				if (fragment != null) {
					return resPath+"/"+fragment;
				}
			}
		}
		// Resolving by containment
		EObject container = obj.eContainer();
		EReference containmentReference = obj.eContainmentFeature();
		if (container!=null && containmentReference!=null) {
			String containerPath = master.resolve(container, master, context);
			if (containerPath!=null) {
				String ret = containerPath+"/"+URLEncoder.encode(containmentReference.getName(), ((WebContext) context).getCharacterEncoding());
				if (containmentReference.isMany()) {
					int idx = ((List<?>) container.eGet(containmentReference)).indexOf(obj);
					if (idx==-1) {
						return null;
					}
					ret+="/"+idx;
				}
				return ret;
			}			
		}
		return null;
	}

}
