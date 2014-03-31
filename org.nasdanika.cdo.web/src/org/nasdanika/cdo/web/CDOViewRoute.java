package org.nasdanika.cdo.web;

import java.util.Collection;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.view.CDOView;
import org.json.JSONArray;
import org.nasdanika.cdo.web.http.CDOViewHttpContextImpl;
import org.nasdanika.web.Action;
import org.nasdanika.web.Context;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.ProcessingError;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 * This class uses a single session provider to open a CDO view.
 * This route shall be used for read-only actions.
 * @author Pavel
 *
 */
public class CDOViewRoute implements Route, AutoCloseable {
	
	private CDOSession session;

	private String sessionProviderFilter;

	private BundleContext bundleContext;

	private ServiceReference<CDOSessionProvider> serviceReference;
	
	protected synchronized CDOSession getSession() throws InvalidSyntaxException {
		if (session == null) {
			bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
			if (sessionProviderFilter==null || sessionProviderFilter.trim().length()==0) {
				serviceReference = bundleContext.getServiceReference(CDOSessionProvider.class);
			} else {
				Collection<ServiceReference<CDOSessionProvider>> refs = bundleContext.getServiceReferences(CDOSessionProvider.class, sessionProviderFilter);
				if (!refs.isEmpty()) {
					serviceReference = refs.iterator().next();
				}
			}
			if (serviceReference!=null) {
				CDOSessionProvider sessionProvider = bundleContext.getService(serviceReference);
				if (sessionProvider!=null) {
					session = sessionProvider.getSession();
				}
			}			
		}
		return session;
	}

	@Override
	public Action navigate(Context context) throws Exception {
		CDOSession sess = getSession();
		if (sess==null) {
			return Action.INTERNAL_SERVER_ERROR;
		}
		
		final CDOView view = sess.openView();
		if (context instanceof HttpContextImpl) {
			context = new CDOViewHttpContextImpl((HttpContextImpl) context, view);
		}
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(view, "read")) {
					final JSONArray viewInfo = new JSONArray();
					for (CDOResourceNode e: view.getElements()) {
						viewInfo.put(e.getName());
					}
					
					return new Action() {
	
						@Override
						public Object execute() throws Exception {						
							return viewInfo;
						}

						@Override
						public void close() throws Exception {
							view.close();							
						}
						
					};
				} 
				view.close();
				return Action.FORBIDDEN;
			}
			
			return Action.NOT_FOUND;
		} 
		
		if ("$packageRegistry".equals(context.getPath()[1])) {
			final Action prAction = context.getAction(sess.getPackageRegistry(), 1);
			return new Action() {

				@Override
				public Object execute() throws Exception {
					return prAction==null ? ProcessingError.NOT_FOUND : prAction.execute();
				}

				@Override
				public void close() throws Exception {
					if (prAction!=null) {
						prAction.close();
					}
					view.close();						
				}
				
			};
		}
		
		for (CDOResourceNode e: view.getElements()) {
			if (e.getName().equals(context.getPath()[1])) {
				final Action eAction = context.getAction(e, 1);
				return new Action() {
					
					@Override
					public void close() throws Exception {
						if (eAction!=null) {
							eAction.close();
						}
						view.close();						
					}
					
					@Override
					public Object execute() throws Exception {
						return eAction==null ? ProcessingError.NOT_FOUND : eAction.execute();
					}
				};
			}
		}
		
		return Action.NOT_FOUND;
	}
	
	/**
	 * Sets OSGi filter to select a particular CDO session provider if more than one is available
	 * at runtime.
	 * @param sessionProviderSelector
	 */
	public void setSessionProviderFilter(String sessionProviderFilter) {
		this.sessionProviderFilter = sessionProviderFilter;
	}

	@Override
	public void close() throws Exception {
		if (session!=null) {
			session.close();
		}
		
		if (bundleContext!=null && serviceReference!=null) {
			try {
				bundleContext.ungetService(serviceReference); // Might throw exception if service bundle is shut down before the servlet.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
