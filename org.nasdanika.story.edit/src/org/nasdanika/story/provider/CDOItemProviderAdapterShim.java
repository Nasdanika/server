package org.nasdanika.story.provider;

import org.eclipse.emf.cdo.edit.CDOItemProviderAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * Fixes a problem in CDOItemProviderAdapter.getParent() - see https://bugs.eclipse.org/bugs/show_bug.cgi?id=477693
 * @author Pavel Vlasov
 *
 */
abstract class CDOItemProviderAdapterShim extends CDOItemProviderAdapter {
	
	protected CDOItemProviderAdapterShim(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public Object getParent(Object object) {
		Object parent = super.getParent(object);
		if (parent == null && object instanceof EObject) {
			EObject container = ((EObject) object).eContainer();
			parent = container == null ? ((EObject) object).eResource() : container;
		}
		return parent;
	}	

}
