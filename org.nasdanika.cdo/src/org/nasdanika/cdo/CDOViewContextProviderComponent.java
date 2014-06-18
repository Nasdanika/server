package org.nasdanika.cdo;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;

public abstract class CDOViewContextProviderComponent<CR> implements CDOViewContextProvider<CR> {
	
	private CDOSessionProvider sessionProvider;
	
	public void setSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = sessionProvider;
	}
	
	public void clearSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = null;
	}	

	@Override
	public CDOViewContext<CDOView, CR> createContext() {
		if (sessionProvider!=null) {			
			return new CDOViewContext<CDOView, CR>() {
				
				private CDOView view = sessionProvider.getSession().openView();
				
				@Override
				public void close() throws Exception {
					view.close();
				}
				
				@Override
				public CDOView getView() {
					return view;
				}
				
				private Principal authenticatedPrincipal;

				@Override
				public Principal getPrincipal() {
					if (authenticatedPrincipal!=null) {
						return authenticatedPrincipal;
					}
					ProtectionDomain<CR> pd = getProtectionDomain();
					return pd==null ? null : pd.getUnauthenticatedPrincipal();
				}

				@Override
				public ProtectionDomain<CR> getProtectionDomain() {
					return CDOViewContextProviderComponent.this.getProtectionDomain(getView());
				}

				@Override
				public boolean authenticate(CR credentials) {
					ProtectionDomain<CR> pd = getProtectionDomain();
					if (pd==null) {
						return false;
					}
					authenticatedPrincipal = pd.authenticate(credentials);
					return authenticatedPrincipal!=null;
				}
			};
		}
		return null;
	}
	
	protected abstract ProtectionDomain<CR> getProtectionDomain(CDOView view);

}
