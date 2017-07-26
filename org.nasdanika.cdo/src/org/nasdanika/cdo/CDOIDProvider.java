package org.nasdanika.cdo;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.nasdanika.core.Provider;

/**
 * Provides {@link CDOObject} by its {@link CDOID}.
 * @author Pavel Vlasov
 *
 */
public class CDOIDProvider implements Provider<CDOTransactionContext<?>, CDOObject> {
	
	private CDOID id;

	public CDOIDProvider(CDOID id) {
		this.id = id;
	}

	@Override
	public CDOObject get(CDOTransactionContext<?> context) throws Exception {
		return context.getView().getObject(id);
	}

}
