package org.nasdanika.cdo.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.CDOViewContextProvider;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.LoginPasswordCDOViewContextSubject;
import org.nasdanika.cdo.TokenCDOViewContextSubject;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.core.Context;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.RoutingServlet;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

@SuppressWarnings("serial")
public abstract class CDOViewRoutingServletBase<V extends CDOView, CR, C extends CDOViewContext<V, CR>> extends RoutingServlet {
	
	private static final String AUTHORIZATION_BASIC = "Basic ";

	/**
	 * Special token type to avoid clash with other authorization types.
	 */
	public static final String AUTHORIZATION_TOKEN_TYPE = "NSD-CDO";

	/**
	 * Name of the host which passes user name header for SSO.  * matches any host. If not set then 
	 * defaults to localhost.
	 */
	public static final String USER_NAME_HEADER_HOST_PROPERTY = "org.nasdanika.cdo.web.userNameHeaderHost";
	
	protected ServiceTracker<CDOViewContextProvider<V,CR,C>, CDOViewContextProvider<V,CR,C>> cdoViewContextProviderServiceTracker;
	private String userNameHeader;
	private String userNameHeaderHost;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userNameHeader = config.getInitParameter("user-name-header");
		if (userNameHeader != null) {
			String userNameHeaderHostStr = System.getProperty(USER_NAME_HEADER_HOST_PROPERTY);
			try {
				if (userNameHeaderHostStr == null) {
					userNameHeaderHostStr = "127.0.0.1";
				}
				
				if ("*".equals(userNameHeaderHostStr)) {
					System.out.println("Accepting user name header " +userNameHeader + " from any host");				
				} else {
					userNameHeaderHost = InetAddress.getByName(userNameHeaderHostStr).getHostAddress();
					System.out.println("Accepting user name header " +userNameHeader + " from "+userNameHeaderHost);
				}
			} catch (UnknownHostException e) {
				throw new ServletException("Unknown user-name-header-host", e);
			}
		}
		
		BundleContext bundleContext = getBundleContext();
		if (bundleContext==null) {
			bundleContext = FrameworkUtil.getBundle(RoutingServlet.class).getBundleContext();
		}
		if (bundleContext==null) {
			throw new IllegalStateException("Bundle context is not available, make sure that bundle "+FrameworkUtil.getBundle(RoutingServlet.class).getSymbolicName()+" is activated");
		}
		
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
	
	/**
	 * Forbidden for Guest is the same as unauthorized - unauthorized requests are redirected to the login page.
	 * @throws Exception 
	 */
	@Override
	protected Action filterAction(HttpServletRequest req, HttpServletResponse resp, HttpServletRequestContext context, Action action) throws Exception {
		if (action == Action.FORBIDDEN) {
			@SuppressWarnings("unchecked")
			C ctx = (C) context;
			Realm<CR> securityRealm = ctx.getSecurityRealm();
			List<org.nasdanika.cdo.security.Principal> principals = ctx.getPrincipals();
			if (securityRealm != null && principals.size() == 1 && principals.get(0) == securityRealm.getGuest()) {
				return Action.UNAUTHORIZED;
			}
			
		}
		return super.filterAction(req, resp, context, action);
	}

	@Override
	protected HttpServletRequestContext createContext(String[] path, final HttpServletRequest req, HttpServletResponse resp, String reqUrl, Context... chain) throws Exception {
		CDOViewContextProvider<V,CR,C> provider = cdoViewContextProviderServiceTracker.getService();
		if (provider==null) {
			throw new ServletException("View provider not found");
		}
		
		CDOViewContextSubject<V, CR> subject = null;
		String authHeader = req.getHeader("Authorization");
		if (authHeader != null) {
			if (authHeader.startsWith(AUTHORIZATION_TOKEN_TYPE+" ")) {
				// Token authorization
				subject = new TokenCDOViewContextSubject<V, CR>(req.getRemoteHost(), authHeader.substring(AUTHORIZATION_TOKEN_TYPE.length()+1));
			} else if (authHeader.startsWith(AUTHORIZATION_BASIC)) {
				// Basic authorization
				String decoded = new String(Base64.decode(authHeader.substring(AUTHORIZATION_BASIC.length())));
				int idx = decoded.indexOf(":");
				if (idx != -1) {
					subject = new LoginPasswordCDOViewContextSubject<V, CR>(decoded.substring(0, idx), decoded.substring(idx+1));
				}							
			}
		}
		
		if (subject == null) {
			subject = new HttpSessionCDOViewContextSubject<V, CR>(req.getSession(), getPrincipalNames(req));
		}
		C viewContext = provider.createContext(subject);
		HttpServletRequestContext compositeContext = createCompositeContext(path, req, resp, reqUrl, viewContext, chain);
		compositeContext.getRootObjectsPaths().put(viewContext.getView(), reqUrl);
		return compositeContext;
	}

	/**
	 * Retrieves principals names from the request.
	 * Returns singleton list with user principal name if user principal is not null. Otherwise returns singleton list with the value of the header specified in ``user-name-header`` init parameter, if any.
	 * Override to derive principal name(s) by some other means, e.g. decryption of authentication token and/or pulling principal roles from LDAP or by iterating over a list of roles and invoking isUserInRole().  
	 * @param req
	 * @return
	 */
	protected List<String> getPrincipalNames(HttpServletRequest req) {
		Principal userPrincipal = req.getUserPrincipal();
		if (userPrincipal != null) {
			return Collections.singletonList(userPrincipal.getName());
		}
		if (userNameHeader == null) {
			return Collections.emptyList();
		}
		String principalName = req.getHeader(userNameHeader);
		if (principalName == null) {
			return Collections.emptyList();
		}
		// Validating correctness of the remote address
		if (userNameHeaderHost!= null) {
			if (!userNameHeaderHost.equals(req.getRemoteAddr())) {
				return Collections.emptyList();				
			}
		}
				
		return Collections.singletonList(principalName);
	}
	
	protected abstract HttpServletRequestContext createCompositeContext(String[] path, final HttpServletRequest req, HttpServletResponse resp, String reqUrl, C viewContext, Context[] chain) throws Exception;
	
	@Override
	protected Iterable<Route> matchRootRoutes(RequestMethod method, String[] path) throws Exception {		
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
							final Action eAction = context.getAction(e, 1, null, context.getPath()[1]);
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
					CDOID id = CDOIDCodec.INSTANCE.decode(context, NasdanikaCDOUtil.stripExtension(context.getPath()[1]));
					@SuppressWarnings("unchecked")
					CDOView view = ((CDOViewContext<?, CR>) context).getView();
					try {
						return context.getAction(view.getObject(id), 1, null, context.getPath()[1]);
					} catch (ObjectNotFoundException e) {
						return Action.NOT_FOUND;
					}
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
		
		return super.matchRootRoutes(method, path);
	}
	
}
