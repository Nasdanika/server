package org.nasdanika.cdo.xa;

import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.nasdanika.cdo.xa.MapXACDOSession.Views;

public interface ViewsProvider {

	Views<String> openViews() throws SystemException, RollbackException;
	
}
