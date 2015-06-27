package org.nasdanika.cdo.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Allows to push progress notifications to the client side session.
 * Notifications are sent as text messages.
 * @author Pavel Vlasov
 * 
 */
@SuppressWarnings("serial")
public class SessionWebSocketServlet<CR> extends WebSocketServlet {
	
	private ServiceTracker<CDOTransactionContextProvider<CR>, CDOTransactionContextProvider<CR>> cdoTransactionContextProviderServiceTracker;
	private String viewPath;
	private BundleContext bundleContext;
	
	//org.eclipse.equinox.http.jetty.context.path

	public interface WebSocketContext<CR> extends CDOTransactionContext<CR> {
		
		/**
		 * Sends a notification to the client side.
		 * @param progressNotification
		 */
		void onProgress(Object progressNotification) throws Exception;

		String getViewPath();

		String getObjectPath(CDOObject cdoObject);
		
		/**
		 * Stores an attribute in the socket object.
		 * @param name
		 * @param value
		 */
		void setAttribute(String name, Object value);
		
		/**
		 * Retrieves attribute from the socket object.
		 * @param name
		 * @return
		 */
		Object getAttribute(String name);
		
	}
	
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(10000);
        factory.setCreator(new WebSocketCreator() {
			
			@Override
			public Object createWebSocket(ServletUpgradeRequest request, ServletUpgradeResponse response) {
			       for (String subprotocol : request.getSubProtocols()) {
			            if ("text".equals(subprotocol)) {
			            	response.setAcceptedSubProtocol(subprotocol);
			                return new SessionWebSocket<CR>(
			                		cdoTransactionContextProviderServiceTracker, 
			                		viewPath,
			                		bundleContext,
			                		getServletContext(),
			                		request);
			            }
			        }				
				return null;
			}
		});
    }	
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		Thread currentThread = Thread.currentThread();
		ClassLoader ccl = currentThread.getContextClassLoader();
		try {			
			currentThread.setContextClassLoader(getClass().getClassLoader());
			super.init(config);
		} finally {
			currentThread.setContextClassLoader(ccl);
		}
		viewPath = config.getInitParameter("view-path");
		String contextPath = config.getServletContext().getContextPath();
		if (!"/".equals(contextPath)) {
			viewPath = contextPath+viewPath;
		}
		
		bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		String serviceFilter = config.getInitParameter("cdo-transaction-context-provider-service-filter");
		
		// TODO - bundle is still null???
		if (serviceFilter==null || serviceFilter.trim().length()==0) {
			cdoTransactionContextProviderServiceTracker = new ServiceTracker<>(bundleContext, CDOTransactionContextProvider.class.getName(), null);
		} else {
			String theFilter = "(&(" + Constants.OBJECTCLASS + "=" + CDOTransactionContextProvider.class.getName() + ")"+serviceFilter+")";
			try {
				cdoTransactionContextProviderServiceTracker = new ServiceTracker<>(bundleContext, bundleContext.createFilter(theFilter), null);
			} catch (InvalidSyntaxException e) {
				throw new ServletException("Invalid service filter ("+e+"): "+serviceFilter, e);
			}
		}
		cdoTransactionContextProviderServiceTracker.open();
	}
	
	@Override
	public void destroy() {
		if (cdoTransactionContextProviderServiceTracker!=null) {
			cdoTransactionContextProviderServiceTracker.close();
		}
		super.destroy();
	}

    
}



