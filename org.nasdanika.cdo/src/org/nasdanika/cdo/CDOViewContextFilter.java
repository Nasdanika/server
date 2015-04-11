package org.nasdanika.cdo;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;

/**
 * Filter which allows to replace master context and default access decision.
 * @author Pavel
 *
 * @param <V>
 * @param <CR>
 * @param <MC>
 */
public class CDOViewContextFilter<V extends CDOView, CR, MC> extends CDOViewContextBase<V, CR, MC> {
	
	private CDOViewContextBase<V, CR, MC> target;

	public CDOViewContextFilter(CDOViewContextBase<V, CR, MC> target) {
		this.target = target;
	}

	public <T> T adapt(Class<T> targetType) throws Exception {
		return target.adapt(targetType);
	}

	public V getView() {
		return target.getView();
	}

	public void close() throws Exception {
		target.close();
	}

	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		return target.convert(source, targetType);
	}

	public ProtectionDomain<CR> getProtectionDomain() {
		return target.getProtectionDomain();
	}

	@Override
	protected MC getMasterContext() {
		return target.getMasterContext();
	}

	@Override
	protected AccessDecision getDefaultAccessDecision() {
		return target.getDefaultAccessDecision();
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return target.loadClass(name);
	}

	public URL getResource(String name) {
		return target.getResource(name);
	}

	public Iterable<URL> getResources(String name) throws IOException {
		return target.getResources(name);
	}

}
