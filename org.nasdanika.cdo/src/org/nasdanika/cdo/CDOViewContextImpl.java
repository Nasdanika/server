package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public abstract class CDOViewContextImpl<V extends CDOView, CR> extends ContextImpl implements CDOViewContext<V,CR>, ClassLoadingContext {
	
	/**
	 * @param bundle
	 * @param securityPolicyManager
	 * @param deny If true then default authorization action is DENY (high security).
	 * @throws Exception
	 */
	public CDOViewContextImpl(
			Bundle bundle, 
			AccessDecision defaultAccessDecision,
			CDOViewContextSubject<V, CR> subject,
			Context... chain) throws Exception {
		super(bundle.getBundleContext(), chain);
		this.subject = subject;
		this.bundle = bundle;
		view = openView();
		setDefaultAccessDecision(defaultAccessDecision);
	}
	
	protected CDOViewContextSubject<V,CR> subject;
	protected List<Principal> authenticatedPrincipals = Collections.emptyList();
	
	@Override
	public CDOViewContextSubject<V, CR> getSubject() throws Exception {
		if (subject == null) {
			List<Principal> principals = getPrincipals();
			if (!principals.isEmpty()) {
				subject = new CDOIDSubject<V,CR>(principals, null);
			}
		}
		return subject;
	}

	@Override
	public final List<Principal> getPrincipals() throws Exception {
		Realm<CR> securityRealm = getSecurityRealm();
		if (subject!=null && securityRealm != null) {
			authenticatedPrincipals = new ArrayList<>();
			for (Principal principal: subject.getPrincipals(this)) {
				if (principal != getSecurityRealm().getGuest()) {
					authenticatedPrincipals.add(principal);
				}
			}
		}

		if (!authenticatedPrincipals.isEmpty()) {
			return authenticatedPrincipals;
		}
		
		Principal guest = securityRealm == null ? null : securityRealm.getGuest();
		return guest == null ? Collections.emptyList() : Collections.singletonList(guest);
	}

	/**
	 * Override to associate context with more than one principal, e.g. login user and its externally defined roles.
	 */
	@Override
	public final List<Principal> authenticate(CR credentials) throws Exception {
		Realm<CR> pd = getSecurityRealm();
		if (pd == null) {
			return Collections.emptyList();
		}
		EList<Principal> ap = pd.authenticate(credentials);
		if (!ap.isEmpty()) {
			authenticatedPrincipals = ap;
			if (subject!=null) {
				subject.setPrincipals(this, authenticatedPrincipals);
			}
		}
		return authenticatedPrincipals;
	}

	@Override
	public final boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		if (target instanceof CDOObject && ((CDOObject) target).cdoView() == getView()) {
			for (Principal principal: getPrincipals()) {
				AccessDecision accessDecision = principal.authorize(this, (EObject) target, action, qualifier, environment);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return AccessDecision.ALLOW.equals(accessDecision);
				}
			}
		} else {
			return authorizeNonViewObject(target, action, qualifier, environment);
		}
		return super.authorize(target, action, qualifier, environment);
	}
	
	/**
	 * Authorizes access to a non-view object. This implementation returns true to allow access to non-view objects because the realm can only check permissions on view objects.
	 * @param target
	 * @param action
	 * @param qualifier
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	protected boolean authorizeNonViewObject(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return true; // TODO - customize as necessary
//		return super.authorize(target, action, qualifier, environment);
	}
	
	
	private V view;
	
	private Bundle bundle;

	protected abstract V openView();

	@Override
	public void close() throws Exception {
		view.close();
		super.close();
	}

	@Override
	public V getView() {
		return view;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		if (targetType.isInstance(bundle)) {
			return (T) bundle;
		}
		BundleContext bc = bundle.getBundleContext();
		if (targetType.isInstance(bc)) {
			return (T) bc;
		}
		
		return super.adapt(targetType);
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return bundle.loadClass(name);
	}
	
	@Override
	public Iterable<URL> getResources(String name) throws IOException {
		return Collections.<URL>list(bundle.getResources(name));
	}
	
	@Override
	public URL getResource(String name) {
		return bundle.getResource(name);
	}
}
