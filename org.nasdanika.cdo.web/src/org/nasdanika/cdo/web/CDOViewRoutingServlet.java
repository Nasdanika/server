package org.nasdanika.cdo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.CDOViewContextFilter;
import org.nasdanika.cdo.CDOViewContextProvider;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.core.Context;
import org.nasdanika.web.HttpServletRequestContext;

@SuppressWarnings("serial")
public class CDOViewRoutingServlet<CR> extends CDOViewRoutingServletBase<CDOView, CR, CDOViewContext<CDOView,CR>> {

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<CDOViewContextProvider> getProviderType() {
		return CDOViewContextProvider.class;
	}

	@Override
	protected HttpServletRequestContext createCompositeContext(
			String[] path,
			HttpServletRequest req, 
			HttpServletResponse resp, 
			String reqUrl,
			CDOViewContext<CDOView,CR> viewContext,
			Context[] chain) throws Exception {
		
		return new CDOViewHttpServletRequestContextImpl<CR>(
				path, 
				null, 
				extensionManager, 
				classLoadingContext,
				null,
				req, 
				resp,
				reqUrl, 
				null,
				chain,				
				viewContext);	
	}
			
}
