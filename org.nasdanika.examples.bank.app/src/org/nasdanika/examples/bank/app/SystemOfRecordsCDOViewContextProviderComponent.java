package org.nasdanika.examples.bank.app;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOViewContextProviderComponent;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.examples.bank.LoginPasswordCredentials;

public class SystemOfRecordsCDOViewContextProviderComponent extends	CDOViewContextProviderComponent<LoginPasswordCredentials> {

	@SuppressWarnings("unchecked")
	@Override
	protected ProtectionDomain<LoginPasswordCredentials> getProtectionDomain(CDOView view) {
		CDOResource bankRes = view.getResource("bank");
		if (bankRes!=null) {
			for (EObject e: bankRes.getContents()) {
				if (e instanceof ProtectionDomain) {
					return (ProtectionDomain<LoginPasswordCredentials>) e;
				}
			}
		}
		return null;
	}

}
