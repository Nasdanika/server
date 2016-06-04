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

	@Override
	protected CDOViewWebSocketContext<CDOView, CR> createWebSocketContext(CDOViewContextSubject<CDOView, CR> subject, final CDOID targetID) {
		CDOViewContextProvider<CDOView, CR, CDOViewContext<CDOView, CR>> provider = cdoViewContextProviderServiceTracker.getService();
		if (provider==null) {
			throw new IllegalStateException("View provider not found");
		}
		
		class CDOViewWebSocketContextImpl extends CDOViewContextFilter<CDOView,CR> implements CDOViewContext<CDOView, CR>, CDOViewWebSocketContext<CDOView,CR> {

			public CDOViewWebSocketContextImpl(CDOViewContext<CDOView,CR> target) {
				super(target);
			}

			@Override
			public CDOObject getTargetObject() {
				if (targetID == null) {
					return null;
				}
				return getView().getObject(targetID);
			}
			
		}
	
		return new CDOViewWebSocketContextImpl(provider.createContext(subject));
	}	
			
}
