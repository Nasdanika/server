package org.nasdanika.examples.bank.component;

import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.session.CDOSession;
import org.nasdanika.cdo.CDOSessionInitializer;
import org.nasdanika.examples.bank.BankPackage;

public class BankSessionInitializerComponent implements CDOSessionInitializer {
	
	@Override
	public void init(CDOSession session) {
		CDOPackageRegistry packageRegistry = session.getPackageRegistry();
		packageRegistry.putEPackage(BankPackage.eINSTANCE);
	}

}
