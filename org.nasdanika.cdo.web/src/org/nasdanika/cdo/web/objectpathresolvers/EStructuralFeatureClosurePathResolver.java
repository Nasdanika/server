package org.nasdanika.cdo.web.objectpathresolvers;

import java.net.URLEncoder;

import org.nasdanika.cdo.EStructuralFeatureClosure;
import org.nasdanika.core.Context;
import org.nasdanika.web.ObjectPathResolver;
import org.nasdanika.web.HttpServletRequestContext;

public class EStructuralFeatureClosurePathResolver implements ObjectPathResolver<EStructuralFeatureClosure<?, ?>> {

	@Override
	public String resolve(
			EStructuralFeatureClosure<?, ?> obj, 
			ObjectPathResolver<Object> master, 
			Context context) throws Exception {
		return master.resolve(obj.getObject(), master, context)+"/feature/"+URLEncoder.encode(obj.getFeature().getName(), ((HttpServletRequestContext) context).getCharacterEncoding());
	}


}
