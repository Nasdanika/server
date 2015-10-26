## DocRoute configuration

expand-content

		Dictionary<String, Object> properties = context.getProperties();
		Object pathOffsetProp = properties.get("path-offset");
		if (pathOffsetProp instanceof Number) {
			pathOffset = ((Number) pathOffsetProp).intValue();
		}
		bundleContext = context.getBundleContext();
		
		Object sessionRegistry = properties.get("session-registry");
		if (sessionRegistry instanceof Boolean) {
			includeSessionRegistry = (Boolean) sessionRegistry;
		}
		
		Object packageRegistry = properties.get("global-registry");
		if (packageRegistry instanceof Boolean) {
			includeGlobalRegistry = (Boolean) packageRegistry;
		}
		
		patternProperty(properties.get("bundle-excludes"), bundleExcludes);
		patternProperty(properties.get("bundle-includes"), bundleIncludes);
		patternProperty(properties.get("package-excludes"), packageExcludes);
		patternProperty(properties.get("package-includes"), packageIncludes);
		
		File searchIndexDir = context.getBundleContext().getBundle().getDataFile("searchIndex");
		if (searchIndexDir==null) {
			searchIndexDirectory = new RAMDirectory();
		} else {
			searchIndexDirectory = new NIOFSDirectory(searchIndexDir.toPath());
		}
    	analyzer = new StandardAnalyzer();
    	
    	baseURL = "http://localhost";
    	String port = System.getProperty("org.osgi.service.http.port");
    	if (port!=null) {
    		baseURL+=":"+port;
    	}
    	urlPrefix = baseURL;
    	
    	String docRoutePathPrp = (String) properties.get("doc-route-path");
    	if (docRoutePathPrp!=null) {
    		docRoutePath = docRoutePathPrp; 
    	}
    	
    	String docAppPathPrp = (String) properties.get("doc-app-path");
    	if (docAppPathPrp!=null) {
    		docAppPath = docAppPathPrp; 
    	}
    	
    	String contextPath = System.getProperty("org.eclipse.equinox.http.jetty.context.path");
    	if (contextPath!=null) {
    		docRoutePath = contextPath + docRoutePath;
    		docAppPath = contextPath + docAppPath;
    	}
    	baseURL+=docAppPath;
