package org.nasdanika.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.BundleClassLoadingContext;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.osgi.framework.FrameworkUtil;

@SuppressWarnings("serial")
public class RoutingServlet extends AbstractRoutingServlet {
	
	protected ClassLoadingContext classLoadingContext;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);		
		classLoadingContext = new BundleClassLoadingContext(FrameworkUtil.getBundle(getClass()));
	}
	
	@Override
	protected HttpServletRequestContext createContext(
			String[] path,
			HttpServletRequest req, 
			HttpServletResponse resp, 
			String reqUrl) throws Exception {
		
		return new HttpServletRequestContextImpl(
				path, 
				null, 
				extensionManager, 
				classLoadingContext,
				null,
				req, 
				resp,
				reqUrl, 
				null,
				new Context[] {});
		}
	
	@Override
	public void destroy() {
		try {
			classLoadingContext.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}

}
