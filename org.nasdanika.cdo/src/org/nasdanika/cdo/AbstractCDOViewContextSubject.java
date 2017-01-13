package org.nasdanika.cdo;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.User;

public abstract class AbstractCDOViewContextSubject<V extends CDOView, CR> implements CDOViewContextSubject<V, CR> {
	
	protected abstract void setPrincipalID(CDOID cdoID);

	protected abstract CDOID getPrincipalID();
	
	protected abstract String getPrincipalName();
	
	@Override
	public Principal getPrincipal(CDOViewContext<V, CR> context) {		
		Object idAttr = getPrincipalID();
		if (idAttr instanceof CDOID) {
			return (Principal) context.getView().getObject((CDOID) idAttr);
		}
		
		if (context.getSecurityRealm()==null) {
			return null;
		}
		
		if (getPrincipalName() != null) {
			for (User pdu : context.getSecurityRealm().getAllUsers()) { 
				// TODO - find(login) to optimize search in large user populations
				if (pdu instanceof LoginUser && ((LoginUser) pdu).getLogin().equalsIgnoreCase(getPrincipalName())) {
					if (((LoginUser) pdu).isDisabled() || (pdu instanceof LoginPasswordHashUser && ((LoginPasswordHashUser) pdu).getPasswordHash() != null)) {
						break;
					} else {
						setPrincipalID(pdu.cdoID());
						return pdu;
					}
				}
			}
		}
		
		Principal guest = context.getSecurityRealm().getGuest();
		if (guest!=null) {
			setPrincipal(context, guest);
		}
		return guest;
	}						

	@Override
	public void setPrincipal(CDOViewContext<V, CR> context, final Principal principal) {
		if (principal == null) {
			setPrincipalID(null);
		} else {
			V view = context.getView();
			if (view instanceof CDOTransaction && principal.cdoID().isTemporary()) {
				((CDOTransaction) view).addTransactionHandler(new CDOTransactionHandler2() {

					@Override
					public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
						setPrincipalID(principal.cdoID());
					}

					@Override
					public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
						// NOP
						
					}

					@Override
					public void rolledBackTransaction(CDOTransaction transaction) {
						// NOP
						
					}
					
				});
			} else {					
				setPrincipalID(principal.cdoID());
			}
		}
	}
	
}

