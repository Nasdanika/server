package org.nasdanika.cdo;

import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;

/**
 * Filter which allows to replace master context and default access decision.
 * @author Pavel
 *
 * @param <V>
 * @param <CR>
 * @param <MC>
 */
public class CDOViewContextFilter<V extends CDOView, CR> implements CDOViewContext<V, CR> {
	
	protected  CDOViewContext<V, CR> target;

	public <T> T adapt(Class<T> targetType) throws Exception {
		return target.adapt(targetType);
	}

	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return this.target.authorize(target, action, qualifier, environment);
	}

	public V getView() {
		return target.getView();
	}

	public Principal getPrincipal() throws Exception {
		return target.getPrincipal();
	}

	public void close() throws Exception {
		target.close();
	}

	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		return target.convert(source, targetType);
	}

	public Realm<CR> getSecurityRealm() {
		return target.getSecurityRealm();
	}

	public Principal authenticate(CR credentials) throws Exception {
		return target.authenticate(credentials);
	}

	public CDOViewContextFilter(CDOViewContext<V, CR> target) {
		this.target = target;
	}

	@Override
	public CDOViewContextSubject<V, CR> getSubject() throws Exception {
		return target.getSubject();
	}

}
