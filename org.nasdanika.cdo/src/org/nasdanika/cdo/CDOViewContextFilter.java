package org.nasdanika.cdo;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.osgi.framework.BundleContext;

/**
 * Filter which allows to replace master context and default access decision.
 * @author Pavel
 *
 * @param <V>
 * @param <CR>
 * @param <MC>
 */
public abstract class CDOViewContextFilter<V extends CDOView, CR, MC, T extends CDOViewContext<V, CR>> extends CDOViewContextBase<V, CR, MC> {
	
	protected final T target;

	public CDOViewContextFilter(BundleContext bundleContext, T target) {
		super(bundleContext);
		this.target = target;
	}

	public <ST> ST adapt(Class<ST> targetType) throws Exception {
		ST ret = super.adapt(targetType);
		return ret==null ? target.adapt(targetType) : ret;
	}

	public V getView() {
		return target.getView();
	}

	public void close() throws Exception {
		target.close();
		super.close();
	}

	public <ST> ST convert(Object source, Class<ST> targetType) throws Exception {
		return target.convert(source, targetType);
	}

	public ProtectionDomain<CR> getProtectionDomain() {
		return target.getProtectionDomain();
	}

}
