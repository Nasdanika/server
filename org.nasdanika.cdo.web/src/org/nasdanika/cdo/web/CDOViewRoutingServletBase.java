package org.nasdanika.cdo.web;

import java.util.Collections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.CDOViewContextProvider;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.User;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.cdo.web.routes.CDOViewSessionModuleGenerator;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.RoutingServlet;
import org.nasdanika.web.ValueAction;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

@SuppressWarnings("serial")
public abstract class CDOViewRoutingServletBase<V extends CDOView, CR, C extends CDOViewContext<V, CR>> extends RoutingServlet {
	
	private static final String PRINCIPAL_ID_ATTRIBUTE_NAME = Principal.class.getName()+":id";
	private ServiceTracker<CDOViewContextProvider<V,CR,C>, CDOViewContextProvider<V,CR,C>> cdoViewContextProviderServiceTracker;
	private String sessionWebSocketServletPath;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		sessionWebSocketServletPath = config.getInitParameter("ws-session-path");
		
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		String serviceFilter = config.getInitParameter("cdo-view-context-provider-service-filter");
		// TODO - bundle is still null???
		if (serviceFilter==null || serviceFilter.trim().length()==0) {
			cdoViewContextProviderServiceTracker = new ServiceTracker<>(bundleContext, getProviderType().getName(), null);
		} else {
			String theFilter = "(&(" + Constants.OBJECTCLASS + "=" + getProviderType().getName() + ")"+serviceFilter+")";
			try {
				cdoViewContextProviderServiceTracker = new ServiceTracker<>(bundleContext, bundleContext.createFilter(theFilter), null);
			} catch (InvalidSyntaxException e) {
				throw new ServletException("Invalid service filter ("+e+"): "+serviceFilter, e);
			}
		}
		cdoViewContextProviderServiceTracker.open();
	}

	@SuppressWarnings("rawtypes")
	protected abstract Class<? extends CDOViewContextProvider> getProviderType();
	
	@Override
	public void destroy() {
		if (cdoViewContextProviderServiceTracker!=null) {
			cdoViewContextProviderServiceTracker.close();
		}
		super.destroy();
	}
	
	private static final CDOViewSessionModuleGenerator cdoViewSessionModuleGenerator = new CDOViewSessionModuleGenerator();	

	@Override
	protected HttpServletRequestContext createContext(String[] path, final HttpServletRequest req, HttpServletResponse resp, String reqUrl) throws Exception {
		CDOViewContextProvider<V,CR,C> provider = cdoViewContextProviderServiceTracker.getService();
		if (provider==null) {
			throw new ServletException("View provider not found");
		}
		
		CDOViewContextSubject<V, CR> subject = new CDOViewContextSubject<V, CR>() {

			@Override
			public Principal getPrincipal(CDOViewContext<V, CR> context) {
				HttpSession session = req.getSession();
				Object idAttr = session.getAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME);
				if (idAttr instanceof CDOID) {
					return (Principal) context.getView().getObject((CDOID) idAttr);
				}
				
				java.security.Principal securityPrincipal = req.getUserPrincipal();
				if (securityPrincipal != null) {
					for (User pdu : context.getProtectionDomain().getAllUsers()) { 
						// TODO - find(login) to optimize search in large user populations
						if (pdu instanceof LoginUser && ((LoginUser) pdu).getLogin().equalsIgnoreCase(securityPrincipal.getName())) {
							if (((LoginUser) pdu).isDisabled() || (pdu instanceof LoginPasswordHashUser && ((LoginPasswordHashUser) pdu).getPasswordHash() != null)) {
								break;
							} else {
								session.setAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME, pdu.cdoID());								
								return pdu;
							}
						}
					}
				}
				
				User unauthenticatedPrincipal = context.getProtectionDomain().getUnauthenticatedPrincipal();
				if (unauthenticatedPrincipal!=null) {
					session.setAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME, unauthenticatedPrincipal.cdoID());
				}
				return unauthenticatedPrincipal;
			}						

			@Override
			public void setPrincipal(CDOViewContext<V, CR> context, final Principal principal) {
				if (principal == null) {
					req.getSession().removeAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME);
				} else {
					V view = context.getView();
					if (view instanceof CDOTransaction && principal.cdoID().isTemporary()) {
						((CDOTransaction) view).addTransactionHandler(new CDOTransactionHandler2() {

							@Override
							public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
								req.getSession().setAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME, principal.cdoID());
							}

							@Override
							public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
								// NOP
								
							}

							@Override
							public void rolledBackTransaction(CDOTransaction transaction) {
								// NOP
								
							}
							
						});
					} else {					
						req.getSession().setAttribute(PRINCIPAL_ID_ATTRIBUTE_NAME, principal.cdoID());
					}
				}
			}

		};
		C viewContext = provider.createContext(subject);
		HttpServletRequestContext compositeContext = createCompositeContext(path, req, resp, reqUrl, viewContext);
		compositeContext.getRootObjectsPaths().put(viewContext.getView(), reqUrl);
		return compositeContext;
	}
	
	protected abstract HttpServletRequestContext createCompositeContext(String[] path, final HttpServletRequest req, HttpServletResponse resp, String reqUrl, C viewContext) throws Exception; 
	
	@Override
	protected Iterable<Route> matchRootRoutes(HttpServletRequest req, String[] path) throws Exception {		
		if (path.length==0) { 
			return Collections.<Route>singleton(new Route() {
				
				@Override
				public void close() throws Exception {
					// NOP					
				}
				
				@Override
				public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
					if (RequestMethod.GET.equals(context.getMethod())) {
						CDOView view = ((CDOViewContext<?,?>) context).getView();
						if (context.authorize(view, "read", null, null)) {
							int dotIdx = context.getPath()[0].lastIndexOf(".");
							String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
							Action extensionAction = context.getExtensionAction(view, extension);
							return extensionAction==null ? Action.NOT_FOUND : extensionAction;
						} 
						return Action.FORBIDDEN;
					}
					
					return Action.NOT_FOUND;
				}
				
				@Override
				public boolean canExecute() {
					return true;
				}
			});			
		} 
						
		if ("elements".equals(path[0])) {
			
			return Collections.<Route>singleton(new Route() {

				@Override
				public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
					@SuppressWarnings("unchecked")
					CDOView view = ((CDOViewContext<?, CR>) context).getView();
					for (CDOResourceNode e: view.getElements()) {
						if (e.getName().equals(NasdanikaCDOUtil.stripExtension(context.getPath()[1]))) {
							final Action eAction = context.getAction(e, 1);
							return eAction==null ? Action.NOT_FOUND : eAction;
						}
					}	
					
					return Action.NOT_FOUND;
				}

				@Override
				public boolean canExecute() {
					return true;
				}

				@Override
				public void close() throws Exception {
					// NOP					
				}
			
			});
			
		}
			// TODO - create resources.
		if ("objects".equals(path[0])) {
			return Collections.<Route>singleton(new Route() {

				@Override
				public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
					CDOID id = CDOIDUtil.read(NasdanikaCDOUtil.stripExtension(context.getPath()[1]));
					@SuppressWarnings("unchecked")
					CDOView view = ((CDOViewContext<?, CR>) context).getView();
					return context.getAction(view.getObject(id), 1);
				}

				@Override
				public boolean canExecute() {
					return true;
				}

				@Override
				public void close() throws Exception {
					// NOP					
				}
			
			});
		}	
		
		if (path.length==1 && "session.js".equals(path[0])) {			
			return Collections.<Route>singleton(new Route() {

				@Override
				public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
					@SuppressWarnings("unchecked")
					CDOView view = ((CDOViewContext<?, CR>) context).getView();
					if (RequestMethod.GET.equals(context.getMethod())) {
						context.getResponse().setContentType("application/javascript");						
						String fullSessionWebSocketServletPath = "ws://"+context.getRequest().getServerName()+":"+context.getRequest().getServerPort()+context.getRequest().getContextPath()+"/"+sessionWebSocketServletPath+"";
						return new ValueAction(cdoViewSessionModuleGenerator.generate(context, view, fullSessionWebSocketServletPath));
					}
					
					return Action.NOT_FOUND;
				}

				@Override
				public boolean canExecute() {
					return true;
				}

				@Override
				public void close() throws Exception {
					// NOP					
				}
			
			});
		}
		
		return super.matchRootRoutes(req, path);
	}
			
}
