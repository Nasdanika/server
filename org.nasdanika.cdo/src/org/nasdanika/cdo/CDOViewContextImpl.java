package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.cdo.security.User;
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
		if (subject!=null) {
			authenticatedPrincipals = subject.getPrincipals(this);
		}

		if (!authenticatedPrincipals.isEmpty()) {
			return authenticatedPrincipals;
		}
		
		Realm<CR> pd = getSecurityRealm();
		Principal guest = pd == null ? null : pd.getGuest();
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
		User<CR> ap = pd.authenticate(credentials);
		if (ap != null) {
			authenticatedPrincipals = Collections.singletonList(ap);
			if (subject!=null) {
				subject.setPrincipals(this, authenticatedPrincipals);
			}
		}
		return authenticatedPrincipals;
	}

	@Override
	public final boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		if (target instanceof EObject) {
			for (Principal principal: getPrincipals()) {
				AccessDecision accessDecision = principal.authorize(this, (EObject) target, action, qualifier, environment);
				if (!AccessDecision.ABSTAIN.equals(accessDecision)) {
					return AccessDecision.ALLOW.equals(accessDecision);
				}
			}

			// Authorize any action on objects which are not yet part of the repository.
			if (((EObject) target).eResource() == null && ((EObject) target).eContainer() == null) {
				return true;
			}
		}
		return super.authorize(target, action, qualifier, environment);
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
