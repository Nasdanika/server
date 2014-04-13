package org.nasdanika.cdo;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.view.CDOView;

public class CDOViewContextProviderComponent implements	CDOViewContextProvider {
	
	private CDOSessionProvider sessionProvider;
	
	public void setSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = sessionProvider;
	}
	
	public void clearSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = null;
	}	

	@Override
	public CDOViewContext createContext() {
		if (sessionProvider!=null) {			
			return new CDOViewContext() {
				
				private CDOView view = sessionProvider.getSession().openView();
				
				@Override
				public void close() throws Exception {
					view.close();
				}
				
				@Override
				public CDOView getView() {
					return view;
				}
			};
		}
		return null;
	}

}
