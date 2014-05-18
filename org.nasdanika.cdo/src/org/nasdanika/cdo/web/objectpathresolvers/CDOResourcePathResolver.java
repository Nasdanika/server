package org.nasdanika.cdo.web.objectpathresolvers;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;

public class CDOResourcePathResolver implements ObjectPathResolver<CDOResource> {

	@Override
	public String resolve(CDOResource obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		CDOView view = obj.cdoView();
		if (view==null) {
			return null;
		}
		String viewPath = master.resolve(view, null, context);
		if (viewPath==null) {
			return null;
		}
		return viewPath+"/elements"+obj.getPath();
	}

}
