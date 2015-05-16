package org.nasdanika.cdo.web.objectpathresolvers;

import java.net.URLEncoder;

import org.eclipse.emf.ecore.EClassifier;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;
import org.nasdanika.web.HttpServletRequestContext;

public class EClassifierPathResolver implements ObjectPathResolver<EClassifier> {

	@Override
	public String resolve(EClassifier obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		return master.resolve(obj.getEPackage(), master, context)+"/"+URLEncoder.encode(obj.getName(), ((HttpServletRequestContext) context).getCharacterEncoding());
	}

}
