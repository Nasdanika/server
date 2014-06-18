package org.nasdanika.cdo.web.objectpathresolvers;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;
import org.nasdanika.web.WebContext;

public class EPackagePathResolver implements ObjectPathResolver<EPackage> {

	@Override
	public String resolve(EPackage obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		CDOView view;
		if (context instanceof CDOViewContext) {
			view = ((CDOViewContext<?,?>) context).getView();
		} else {
			return null;
		}
		if (!view.getSession().getPackageRegistry().containsKey(obj.getNsURI())) {
			return null;
		}
		String viewPath = master.resolve(view, null, context);
		if (viewPath==null) {
			return null;
		}
		if (context instanceof WebContext) {
			return viewPath+"/packages/"+((WebContext) context).getSessionStore().put(obj.getNsURI());
		}
		return null;
	}

}
