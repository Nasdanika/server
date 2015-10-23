package org.nasdanika.cdo.h2;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.db.CDODBUtil;
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy;
import org.eclipse.net4j.db.DBUtil;
import org.eclipse.net4j.db.IDBAdapter;
import org.eclipse.net4j.db.IDBConnectionProvider;
import org.eclipse.net4j.db.h2.H2Adapter;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.h2.jdbcx.JdbcDataSource;
import org.nasdanika.cdo.RepositoryProvider;
import org.osgi.service.component.ComponentContext;

public class H2RepositoryProvider implements RepositoryProvider {
	
	private static final String H2_URL_PROPERTY = ".h2.url";
	private static final String AUDITS_PROPERTY = ".audits";
	private static final String BRANCHES_PROPERTY = ".branches";
	private static final String REPO_PROPERTIES_PREFIX = ".repository.";
	private static final String REPO_NAME_PROPERTY = ".repositoryName";
	
	private IRepository repository;

	public void activate(ComponentContext context) {
		JdbcDataSource dataSource = new JdbcDataSource();
		Object componentName = context.getProperties().get("component.name");
		Object urlStr = context.getProperties().get(H2_URL_PROPERTY);
		if (urlStr==null) {
			// If URL is not specified then database is created in bundle's storage area.
			urlStr = context.getBundleContext().getDataFile("db").getAbsolutePath()+File.separator+componentName;
		}
		dataSource.setURL("jdbc:h2:"+urlStr);
		IDBAdapter dbAdapter = new H2Adapter();
		IDBConnectionProvider dbConnectionProvider = DBUtil.createConnectionProvider(dataSource);
		
		boolean audits = Boolean.TRUE.equals(context.getProperties().get(AUDITS_PROPERTY)); 
		boolean branches = Boolean.TRUE.equals(context.getProperties().get(BRANCHES_PROPERTY)); 
				
		IMappingStrategy mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(audits, branches);
		IStore store = CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider);

		Map<String, String> props = new HashMap<String, String>();
		if (audits) {
			props.put(IRepository.Props.SUPPORTING_AUDITS, "true");
		}
		if (branches) {
			props.put(IRepository.Props.SUPPORTING_BRANCHES, "true");
		}
		
		Enumeration<?> pne = context.getProperties().keys();
		while (pne.hasMoreElements()) {
			Object pn = pne.nextElement();
			if (pn instanceof String && ((String) pn).startsWith(REPO_PROPERTIES_PREFIX)) {
				props.put(((String) pn).substring(0, REPO_PROPERTIES_PREFIX.length()), String.valueOf(context.getProperties().get(pn)));
			}
		}
 
		Object rn = context.getProperties().get(REPO_NAME_PROPERTY);
		String repoName = rn instanceof String ? (String) rn : String.valueOf(componentName);
		repository = CDOServerUtil.createRepository(repoName, store, props);
		LifecycleUtil.activate(repository);
	}

	@Override
	public IRepository getRepository() {
		return repository;
	}
	
	public void deactivate() {
		if (repository!=null) {
			LifecycleUtil.deactivate(repository);
		}
	}
	
}
