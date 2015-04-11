package org.nasdanika.cdo.xa;

import java.util.Map;

import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.nasdanika.cdo.xa.MapXACDOSession.Views;

public class ViewsProviderComponent implements ViewsProvider {

	private static final String ALIAS_PROPERTY = "alias";
	private MapXACDOSession<String> xaSession = new MapXACDOSession<>();

	public void setTransactionManager(TransactionManager transactionManager) {
		xaSession.setTransactionManager(transactionManager);
	}
	
	public void addSession(CDOSessionProvider sessionProvider, Map<?,?> props) {
		xaSession.getSessions().put(alias(props), sessionProvider.getSession());
	}

	public String alias(Map<?, ?> props) {
		Object ap = props.get(ALIAS_PROPERTY);
		if (ap instanceof String) {
			return (String) ap;
		}
		return String.valueOf(props.get("component.name"));
	}
	
	public void removeSession(CDOSessionProvider sessionProvider, Map<?,?> props) {
		xaSession.getSessions().remove(alias(props));		
	}
	
	@Override
	public Views<String> openViews() throws SystemException, RollbackException {
		return xaSession.getViews();
	}

}
