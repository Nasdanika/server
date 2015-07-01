package org.nasdanika.cdo.web.objectpathresolvers;

import java.net.URLEncoder;

import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.core.Context;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.ObjectPathResolver;

public class EOperationClosurePathResolver implements ObjectPathResolver<EOperationClosure<?>> {

	@Override
	public String resolve(
			EOperationClosure<?> obj, 
			ObjectPathResolver<Object> master, 
			Context context) throws Exception {
		return master.resolve(obj.getObject(), master, context)+"/operation/"+URLEncoder.encode(obj.getOperation().getName()+"()", ((HttpServletRequestContext) context).getCharacterEncoding());
	}


}
