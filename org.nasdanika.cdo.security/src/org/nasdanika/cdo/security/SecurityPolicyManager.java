package org.nasdanika.cdo.security;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.core.CoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Helper class which loads adapters from extensions and services.
 * @author Pavel
 *
 */
public class SecurityPolicyManager implements AutoCloseable, SecurityPolicy {
	
	private ServiceTracker<SecurityPolicy, SecurityPolicy> securityPolicyProviderServiceTracker;
	
	private Map<Class<?>, Object> adapterMap = new ConcurrentHashMap<>();

	private List<SecurityPolicy> extensionSecurityPolicies = new ArrayList<>();
	
	public SecurityPolicyManager(BundleContext context, String securityPolicyServiceFilter) throws Exception {
		if (context==null) {
			context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		}
		if (securityPolicyServiceFilter==null || securityPolicyServiceFilter.trim().length()==0) {
			securityPolicyProviderServiceTracker = new ServiceTracker<>(context, SecurityPolicy.class.getName(), null);
		} else {
			String apServiceFilter = "(&(" + Constants.OBJECTCLASS + "=" + SecurityPolicy.class.getName() + ")"+securityPolicyServiceFilter+")";
			securityPolicyProviderServiceTracker = new ServiceTracker<>(context, context.createFilter(apServiceFilter), null);
		}
		securityPolicyProviderServiceTracker.open();
		
		// Load policies from extensions
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(SecurityPackage.eNS_URI, SecurityPackage.eINSTANCE);
		
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(SECURITY_POLICY_ID)) {
			if ("policy_resource".equals(ce.getName())) {
				IContributor contributor = ce.getContributor();		
				Bundle bundle = Platform.getBundle(contributor.getName());				
				URL resURL = bundle.getResource(ce.getAttribute("resource"));
				URI uri = URI.createURI(resURL.toString());
				Resource resource = resourceSet.getResource(uri, true);
				for (EObject eObject : resource.getContents()) {
					if (eObject instanceof SecurityPolicy) {
						extensionSecurityPolicies.add((SecurityPolicy) eObject);
					}
				}
			} else if ("policy_class".equals(ce.getName())) {
				extensionSecurityPolicies.add(CoreUtil.injectProperties(ce, (SecurityPolicy) ce.createExecutableExtension("class")));
			}
		}		
	}
				
	public static final String SECURITY_POLICY_ID = "org.nasdanika.cdo.security.security_policy";
	
	@Override
	public void close() throws Exception {
		for (Object a: adapterMap.values()) {
			if (a instanceof AutoCloseable) {
				try {
					((AutoCloseable) a).close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			securityPolicyProviderServiceTracker.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Override
	public Action getAction(ActionKey actionKey) {
		for (SecurityPolicy sp: extensionSecurityPolicies) {
			Action action = sp.getAction(actionKey);
			if (action!=null) {
				return action;
			}
		}
		
		for (ServiceReference<SecurityPolicy> spr: securityPolicyProviderServiceTracker.getServiceReferences()) {
			SecurityPolicy sp = securityPolicyProviderServiceTracker.getService(spr);
			Action action = sp.getAction(actionKey);
			if (action!=null) {
				return action;
			}			
		}
		
		return null;
	}
	
	private boolean equal(Action a1, Action a2) {
		// TODO - implement action comparison.
		return false;
	}
	
	@Override
	public Iterable<Action> getGrantableActions(String targetNamespaceURI, String targetClass) {
		List<Action> ret = new ArrayList<Action>();
		// TODO Eliminate possible duplicates
		for (SecurityPolicy sp: extensionSecurityPolicies) {
			Z: for (Action action: sp.getGrantableActions(targetNamespaceURI, targetClass)) {
				for (Action ea: ret) {
					if (equal(ea, action)) {
						continue Z;
					}
				}
				ret.add(action);
			}
		}
		
		for (ServiceReference<SecurityPolicy> spr: securityPolicyProviderServiceTracker.getServiceReferences()) {
			Z: for (Action action: securityPolicyProviderServiceTracker.getService(spr).getGrantableActions(targetNamespaceURI, targetClass)) {
				for (Action ea: ret) {
					if (equal(ea, action)) {
						continue Z;
					}
				}
				ret.add(action);
			}
		}

		return ret;
	}
	
}
