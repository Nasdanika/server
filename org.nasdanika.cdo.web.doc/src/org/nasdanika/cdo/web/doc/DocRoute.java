package org.nasdanika.cdo.web.doc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

import javax.activation.MimetypesFileTypeMap;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.cdo.web.doc.TocNode.TocNodeVisitor;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.LinkInfo;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Resolver;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.html.impl.DefaultHTMLFactory;
import org.nasdanika.web.AbstractRoutingServlet;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.ValueAction;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.ComponentContext;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.LinkRenderer.Rendering;
import org.pegdown.PegDownProcessor;

public class DocRoute implements Route {
		
	private static final String PACKAGE_SUMMARY_HTML = "package-summary.html";
	private static final String MIME_TYPE_HTML = "text/html";
	private static final String WIKI_LINK_RENDERER = "wiki-link-renderer";
	private static final String WIKI_LINK_RESOLVER = "wiki-link-resolver";
	private static final String PLUGIN = "plugin";
	private static final String EANNOTATION_RENDERER = "eannotation-renderer";
	private static final String CONTENT_FILTER = "content-filter";
	private static final String TOC = "toc";
	private static final String RESOURCES_PATH = "/resources/";
	private static final String BUNDLE_PATH = "/bundle/";
	private static final String PACKAGES_PATH = "/packages/";
	private static final String PACKAGES_SESSION_PATH = PACKAGES_PATH + "session/";
	private static final String PACKAGES_GLOBAL_PATH = PACKAGES_PATH + "global/";
	private static final String TOC_PATH = "/toc/";
	
	public static final String CONTEXT_MODEL_ELEMENT_PATH_KEY = "contextModelElementPath";

	private int pathOffset = 1;
	private BundleContext bundleContext;
	private Directory searchIndexDirectory;
	private DirectoryReader searchIndexReader;
	private IndexSearcher indexSearcher;
	private StandardAnalyzer analyzer;
	private CDOSessionProvider cdoSessionProvider;
	private HTMLFactory htmlFactory = new DefaultHTMLFactory();
	private String docRoutePath = "/router/doc";
	private String docAppPath = "/router/doc.html";
	private long reloadDelay = 30000; // Wait 30 seconds before reloading index on extension tracker notifications. 
	private Timer loadTimer;
	
	private Boolean includeSessionRegistry = true;
	private Boolean includeGlobalRegistry;
	private List<Pattern> bundleIncludes = new ArrayList<>();
	private List<Pattern> bundleExcludes = new ArrayList<>();
	private List<Pattern> packageIncludes = new ArrayList<>();
	private List<Pattern> packageExcludes = new ArrayList<>();
	
	public HTMLFactory getHtmlFactory() {
		return htmlFactory;
	}
	
	public String getDocAppPath() {
		return docAppPath;
	}
	
	public String getDocRoutePath() {
		return docRoutePath;
	}
	
	private Map<String, Map<String, ExtensionEntry<ContentFilter>>> contentFilters = new ConcurrentHashMap<>();
	private Map<String, ExtensionEntry<EAnnotationRenderer>> eAnnotationRenderers = new ConcurrentHashMap<>();
	
	public Map<String, EAnnotationRenderer> geteAnnotationRenderers() {
		Map<String, EAnnotationRenderer> ret = new ConcurrentHashMap<>();
		for (Entry<String, ExtensionEntry<EAnnotationRenderer>> e: eAnnotationRenderers.entrySet()) {
			ret.put(e.getKey(), e.getValue().extension);
		}
		return ret;
	}	
	public void setReloadDelay(long reloadDelay) {
		this.reloadDelay = reloadDelay;
	}
	
	public void setHtmlFactory(HTMLFactory htmlFactory) {
		this.htmlFactory = htmlFactory;
	}	
	
	public void setDocRoutePath(String docRoutePath) {
		this.docRoutePath = docRoutePath;
	}
	
	public void setDocAppPath(String docAppPath) {
		this.docAppPath = docAppPath;
	}
	
	private String baseURL;
	private String urlPrefix;	
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ExtensionTracker extensionTracker;
	
	static class ExtensionEntry<T> {
		
		T extension;
		String description;
		
		ExtensionEntry(T extension, IConfigurationElement ce) {
			this.extension = extension;
			StringBuilder descriptionBuilder = new StringBuilder();
			for (IConfigurationElement de: ce.getChildren("description")) {
				descriptionBuilder.append(de.getValue());
			}
			this.description = descriptionBuilder.toString();
		}						
		
	}
	
	private Map<String, ExtensionEntry<WikiLinkProcessor.Renderer>> wikiLinkRendererMap = new ConcurrentHashMap<>();
	private Map<String, ExtensionEntry<WikiLinkResolver>> wikiLinkResolverMap = new ConcurrentHashMap<>();
	private Map<String, ExtensionEntry<Plugin>> pluginMap = new ConcurrentHashMap<>();
	private List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
	
	static class EClassKey implements Comparable<EClassKey> {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((nsURI == null) ? 0 : nsURI.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EClassKey other = (EClassKey) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (nsURI == null) {
				if (other.nsURI != null)
					return false;
			} else if (!nsURI.equals(other.nsURI))
				return false;
			return true;
		}

		public String getNsURI() {
			return nsURI;
		}

		public String getName() {
			return name;
		}
		
		public String getDocumentation() {
			return documentation;
		}

		String nsURI;
		String name;
		String documentation;
		
		public EClassKey(EClass eClass) {
			nsURI = eClass.getEPackage().getNsURI();
			name = eClass.getName();
			EAnnotation docAnn = eClass.getEAnnotation(EModelElementDocumentationGenerator.ECORE_DOC_ANNOTATION_SOURCE);
			if (docAnn==null) {
				documentation = "";
			} else {
				documentation = docAnn.getDetails().get("documentation");
			}
		}

		@Override
		public int compareTo(EClassKey o) {
			if (o==this) {
				return 0;
			}
			
			if (o.nsURI.equals(nsURI)) {
				return name.compareTo(o.getName());
			}
			
			return nsURI.compareTo(o.nsURI);
		}
		
	}
	
	private Map<EClassKey,Set<EClassKey>> inheritanceMap = new ConcurrentHashMap<>(); 
	
	public Map<EClassKey, Set<EClassKey>> getInheritanceMap() {
		return inheritanceMap;
	}
	
	static class PackageTocNodeFactoryEntry {

		List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
		
		Map<String, List<TocNodeFactory>> classifierTocNodeFactories = new HashMap<>();
		
	}

	private Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = new HashMap<>();	
	
	public Map<String, PackageTocNodeFactoryEntry> getPackageTocNodeFactories() {
		return packageTocNodeFactories;
	}
	
	private MimetypesFileTypeMap mimeTypesMap;
	private boolean expandContent = true;
	
	private static void patternProperty(Object value, List<Pattern> accumulator) {
		if (value instanceof String[]) {
			for (String p: (String[]) value) {
				patternProperty(p, accumulator);
			}
		} else if (value instanceof String) {
			if (!CoreUtil.isBlank((String) value)) {
				accumulator.add(Pattern.compile((String) value));
			}			
		}
	}
		
	public void activate(ComponentContext context) throws Exception {
		Dictionary<String, Object> properties = context.getProperties();
		Object pathOffsetProp = properties.get("path-offset");
		if (pathOffsetProp instanceof Number) {
			pathOffset = ((Number) pathOffsetProp).intValue();
		}
		bundleContext = context.getBundleContext();
		
		Object expandContentProperty = properties.get("expand-content");
		if (expandContentProperty instanceof Boolean) {
			expandContent = (Boolean) expandContentProperty;
		}
		
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
    	
    	IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
    	extensionTracker = new ExtensionTracker(extensionRegistry);
    	
    	doLoad.set(true); // To prevent scheduling of delayed loading.
    	
    	// Tracking doc extensions
    	IExtensionPoint docExtensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.cdo.web.doc.extensions");    	
    	IExtensionChangeHandler docExtensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				switch (ce.getName()) {
    				case WIKI_LINK_RENDERER:
	    				String rendererName = ce.getAttribute("name");
						if (!wikiLinkRendererMap.containsKey(rendererName)) {
	    					try {
								wikiLinkRendererMap.put(rendererName, new ExtensionEntry<Renderer>((Renderer) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
								tracker.registerObject(extension, WIKI_LINK_RENDERER+":"+rendererName, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								e.printStackTrace();
							}
	    				}
						break;
    				case WIKI_LINK_RESOLVER:
	    				String resolverName = ce.getAttribute("name");
						if (!wikiLinkResolverMap.containsKey(resolverName)) {
	    					try {
								wikiLinkResolverMap.put(resolverName, new ExtensionEntry<WikiLinkResolver>((WikiLinkResolver) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
								tracker.registerObject(extension, WIKI_LINK_RESOLVER+":"+resolverName, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								// TODO - proper logging
								e.printStackTrace();
							}
	    				}
						break;
    				case PLUGIN:
	    				String pluginName = ce.getAttribute("name");
						if (!pluginMap.containsKey(pluginName)) {
	    					try {
								pluginMap.put(pluginName, new ExtensionEntry<Plugin>((Plugin) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
								tracker.registerObject(extension, PLUGIN+":"+pluginName, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								// TODO - proper logging
								e.printStackTrace();
							}
	    				}
						break;
    				case EANNOTATION_RENDERER:
	    				String source = ce.getAttribute("source");
						if (!eAnnotationRenderers.containsKey(source)) {
	    					try {
								eAnnotationRenderers.put(source, new ExtensionEntry<EAnnotationRenderer>((EAnnotationRenderer) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
								tracker.registerObject(extension, EANNOTATION_RENDERER+":"+source, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								// TODO - proper logging
								e.printStackTrace();
							}
	    				}
						break;
    				case CONTENT_FILTER: 
	    				String sourceType = ce.getAttribute("source-type");
	    				Map<String, ExtensionEntry<ContentFilter>> targetMap = contentFilters.get(sourceType);
	    				if (targetMap==null) {
	    					targetMap = new ConcurrentHashMap<>();
	    					contentFilters.put(sourceType, targetMap);
	    				}
	    				String targetType = ce.getAttribute("target-type");
						if (!targetMap.containsKey(targetType)) {
	    					try {
								ContentFilter contentFilter = (ContentFilter) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class"));
								targetMap.put(targetType, new ExtensionEntry<ContentFilter>(contentFilter, ce));
								tracker.registerObject(extension, contentFilter, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								// TODO - proper logging
								e.printStackTrace();
							}
	    				}
    					
    					break;
    				default:
    					System.err.println("Unrecognized extension: "+ce.getName());
    				}
    			}
    			scheduleReloading();
			}
			
			@Override
			public void removeExtension(IExtension extension, Object[] objects) {
				for (Object obj: objects) {
					if (obj instanceof String) {
						if (((String) obj).startsWith(WIKI_LINK_RENDERER+":")) {
							wikiLinkRendererMap.remove(((String) obj).substring(WIKI_LINK_RENDERER.length()+1));
						} else if (((String) obj).startsWith(WIKI_LINK_RESOLVER+":")) {
							wikiLinkResolverMap.remove(((String) obj).substring(WIKI_LINK_RESOLVER.length()+1));
						} else if (((String) obj).startsWith(PLUGIN+":")) {
							pluginMap.remove(((String) obj).substring(PLUGIN.length()+1));
						} else if (((String) obj).startsWith(EANNOTATION_RENDERER+":")) {
							eAnnotationRenderers.remove(((String) obj).substring(EANNOTATION_RENDERER.length()+1));
						} 						
					} else if (obj instanceof ContentFilter) {
						for (Map<String, ExtensionEntry<ContentFilter>> tm: contentFilters.values()) {
							Iterator<ExtensionEntry<ContentFilter>> cfit = tm.values().iterator();
							while (cfit.hasNext()) {
								if (obj == cfit.next()) {
									cfit.remove();
									break;
								}
							}
						}
					}
				}
    			scheduleReloading();				
			}
			
		};
		
		extensionTracker.registerHandler(docExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(docExtensionPoint));
		for (IExtension ex: docExtensionPoint.getExtensions()) {
			docExtensionChangeHandler.addExtension(extensionTracker, ex);
		}
		
    	// Tracking TOC extensions
    	IExtensionPoint tocExtensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.toc");    	
    	IExtensionChangeHandler tocExtensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				switch (ce.getName()) {
    				case TOC:
						try {
							for (Pattern p: bundleExcludes) {
								if (p.matcher(ce.getContributor().getName()).matches()) {
									return;
								}
							}
							if (!bundleIncludes.isEmpty()) {
								boolean included = false;
								for (Pattern p: bundleIncludes) {
									if (p.matcher(ce.getContributor().getName()).matches()) {
										included = true;
										break;
									}
								}				
								if (!included) {
									return;
								}
							}
							
							//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
							TocNodeFactory tocNodeFactory = new TocNodeFactory(
									DocRoute.this, 
									baseURL,
									urlPrefix,
									docRoutePath,
									extension.getContributor().getName(),
									contentFilters,
									ce);
							
							String nsURI = ce.getAttribute("nsURI");
							if (CoreUtil.isBlank(nsURI)) {
		   						synchronized (tocNodeFactories) {
		   							tocNodeFactories.add(tocNodeFactory);
		   						}								
							} else {
		   						synchronized (packageTocNodeFactories) {
		   							PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(nsURI);
		   							if (pe==null) {
		   								pe = new PackageTocNodeFactoryEntry();
		   								packageTocNodeFactories.put(nsURI, pe);
		   							}
		   							String classifier = ce.getAttribute("classifier");
		   							if (CoreUtil.isBlank(classifier)) {
		   								pe.tocNodeFactories.add(tocNodeFactory);
		   							} else {
		   								List<TocNodeFactory> ctnfl = pe.classifierTocNodeFactories.get(classifier);
		   								if (ctnfl==null) {
		   									ctnfl = new ArrayList<TocNodeFactory>();
		   									pe.classifierTocNodeFactories.put(classifier, ctnfl);
		   								}
		   								ctnfl.add(tocNodeFactory);
		   							}
		   						}																
							}
							tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO proper logging
							e.printStackTrace();
						}
    					break;
    				default:
    					System.err.println("Unrecognized extension: "+ce.getName());
    				}
    			}
    			scheduleReloading();
			}
			
			@Override
			public void removeExtension(IExtension extension, Object[] objects) {
				for (Object obj: objects) {
					if (obj instanceof TocNodeFactory) {
						synchronized (tocNodeFactories) {
							tocNodeFactories.remove(obj);
						}
					} 						
				}
    			scheduleReloading();				
			}
			
		};
		
		extensionTracker.registerHandler(tocExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(tocExtensionPoint));
		for (IExtension ex: tocExtensionPoint.getExtensions()) {
			tocExtensionChangeHandler.addExtension(extensionTracker, ex);
		}
    	
		// Global package registry changes
		IExtensionPoint generatedPackageExtensionPoint = extensionRegistry.getExtensionPoint("org.eclipse.emf.ecore.generated_package");
		IExtensionChangeHandler generatedPackageExtensionChangeHandler = new IExtensionChangeHandler() {
			
			@Override
			public void removeExtension(IExtension extension, Object[] objects) {
				scheduleReloading();				
			}
			
			@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {
				scheduleReloading();				
			}
			
		};
		
		mimeTypesMap = new MimetypesFileTypeMap(AbstractRoutingServlet.class.getResourceAsStream("mime.types"));		
		mimeTypesMap.addMimeTypes("text/markdown md");
		
		extensionTracker.registerHandler(generatedPackageExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(generatedPackageExtensionPoint));		
    			
		eClassDocumentationGenerator = new EClassDocumentationGenerator(this);	
		eDataTypeDocumentationGenerator = new EDataTypeDocumentationGenerator(this);	
		eEnumDocumentationGenerator = new EEnumDocumentationGenerator(this);			
		ePackageDocumentationGenerator = new EPackageDocumentationGenerator(this);				
		
		loadTimer = new Timer();
		doLoad.set(false);
		loadTimer.schedule(loadTask, 500);
	}
		
	private TocNode tocRoot;
	
	public TocNode getTocRoot() {
		return tocRoot;
	}
	
	private Map<String, List<String>> linkMap;
	private Set<String> missingPaths;
	
	public void setCdoSessionProvider(CDOSessionProvider cdoSessionProvider) {
		this.cdoSessionProvider = cdoSessionProvider;
	}

	/**
	 * doLoad is set to true when loading is scheduled and 
	 * reset to false when loading is completed.
	 */
	private AtomicBoolean doLoad = new AtomicBoolean();
	
	void scheduleReloading() {
		if (!doLoad.getAndSet(true)) {
			loadTimer.schedule(loadTask, reloadDelay);
		}
	}
	
	TimerTask loadTask = new TimerTask() {
		
		@Override
		public void run() {
			do {
				try {
					load();
				} catch (Exception e) {
					// TODO proper logging
					System.err.println("Loading failed: "+e);
					e.printStackTrace();
				}
			} while (doLoad.getAndSet(false));
		}
	};	

	/**
	 * (Re)Builds TOC and index. 
	 * @throws IOException
	 */
	private void load() throws IOException {
		lock.writeLock().lock();
		try {
			// TOC
			tocRoot = new TocNode(null, null, null);
			TocNode packagesToc = tocRoot.createChild("Packages", null, null, null);
			if (isGlobalRegistry()) {
				createPackageRegistryToc(EPackage.Registry.INSTANCE, packagesToc.createChild("Global", null, null, null), "/packages/global");
			}
			
			if (isSessionRegistry()) {
				createPackageRegistryToc(cdoSessionProvider.getSession().getPackageRegistry(), packagesToc.createChild("Session", null, null, null), "/packages/session");				
			}
			
			synchronized (tocNodeFactories) {
				for (TocNodeFactory tnf: tocNodeFactories) {
					if (tnf.isRoot(tocNodeFactories)) {
						tnf.createTocNode(tocRoot, tocNodeFactories, false);
					}
				}
			}
			
			tocRoot.sort(false);
						
			// TODO - from extensions
			
			// Index
			if (searchIndexReader!=null) {
				searchIndexReader.close();
				searchIndexReader = null;
			}
			
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
	        try (IndexWriter writer = new IndexWriter(searchIndexDirectory, config)) {
	        	writer.deleteAll();
	        	SearchableContentProvider searchableContentProvider = new SearchableContentProvider() {

					@Override
					public ContentEntry get(String path) {				
						if (path.startsWith(TOC_PATH)) {
							final TocNode tocNode = tocRoot.find(path);
							if (tocNode!=null) {
								return new ContentEntry() {
									
									@Override
									public boolean isHTML() {
										return true; // Embedded content is always rendered to HTML
									}
									
									@Override
									public String getContent() {
										return CoreUtil.isBlank(tocNode.getContent()) ? "" : tocNode.getContent();
									}
								};
							}
							return null;
						}
						
						try {
							URL theBaseURL = new URL(baseURL);
							if (path.startsWith(PACKAGES_GLOBAL_PATH) || path.startsWith(PACKAGES_SESSION_PATH)) {
								// Always HTML String for packages if not null.
									final Object content = DocRoute.this.getContent(new URL(theBaseURL, DocRoute.this.docRoutePath+path), urlPrefix, path);
									if (content instanceof String) { 
										return new ContentEntry() {
		
											@Override
											public boolean isHTML() {
												return true;
											}
											
											@Override
											public String getContent() {
												return (String) content;
											}
										};
									}
							}
							
							int idx = path.lastIndexOf('/');
							String fn = idx==-1 ? path : path.substring(idx+1);
							String contentType = mimeTypesMap.getContentType(fn);
							if (contentType!=null) {
								if (MIME_TYPE_HTML.equals(contentType)) {
									final String content = CoreUtil.stringify(DocRoute.this.getContent(new URL(theBaseURL, DocRoute.this.docRoutePath+path), urlPrefix, path));
									return new ContentEntry() {
	
										@Override
										public boolean isHTML() {
											return true;
										}
										
										@Override
										public String getContent() {
											return content;
										}
									};
								}
								
								Map<String, ExtensionEntry<ContentFilter>> tm = contentFilters.get(contentType);
								ExtensionEntry<ContentFilter> extensionEntry = tm==null ? null : tm.get(MIME_TYPE_HTML);
								ContentFilter cf = extensionEntry==null ? null : extensionEntry.extension;
								if (cf!=null) {
									String content = CoreUtil.stringify(DocRoute.this.getContent(new URL(theBaseURL, DocRoute.this.docRoutePath+path), urlPrefix, path));
									if (content!=null) {
										final String htmlContent = String.valueOf(cf.filter(content, DocRoute.this, new URL(urlPrefix+docRoutePath+path), urlPrefix));
										return new ContentEntry() {
		
											@Override
											public boolean isHTML() {
												return true;
											}
											
											@Override
											public String getContent() {
												return htmlContent;
											}
										};
									}
								}
							}
						} catch (Exception de) {
							de.printStackTrace(); 
						}
						
						return null;
					}
	        		
	        	};
				final Indexer indexer = new Indexer(searchableContentProvider, writer, baseURL) {
					
					private String prefix = "http://localhost:18080"+docAppPath+"#router/doc-content/"+docRoutePath+"/";
					
					@Override
					protected boolean isInternalLink(String href) {
						return href.startsWith(prefix);
					}
					
					@Override
					protected String internalLinkPath(String href) {
						return href.substring(prefix.length()-1);
					}
					
				};
				tocRoot.accept(new TocNodeVisitor() {
					
					@Override
					public void visit(TocNode tocNode) {
						if (tocNode.getHref()!=null) {
							indexer.index(tocNode.getHref());
						}						
					}
					
				});
	
				this.linkMap = indexer.getLinkMap();
				this.missingPaths = indexer.getMissingPaths();
	        }
			
	        searchIndexReader = DirectoryReader.open(searchIndexDirectory);
	        System.out.println("Indexed "+searchIndexReader.numDocs()+" pages");
			if (!missingPaths.isEmpty()) {
				System.out.println("Missing paths:");
				for (String mp: missingPaths) {
					System.out.println("\t"+mp);
				}
			}
	        indexSearcher = new IndexSearcher(searchIndexReader);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public boolean isSessionRegistry() {
		return includeSessionRegistry && cdoSessionProvider!=null;
	}

	public boolean isGlobalRegistry() {
		return includeGlobalRegistry==null ? cdoSessionProvider==null : includeGlobalRegistry;
	}
	
	private void createPackageRegistryToc(Registry registry, TocNode owner, String prefix) {
		List<EPackage> packages = new ArrayList<>();
		for (String nsURI: registry.keySet()) {			
			EPackage ePackage = registry.getEPackage(nsURI);
			if (ePackage.getESuperPackage()==null) {
				packages.add(ePackage);
			}
		}
		Collections.sort(packages, new Comparator<EPackage>() {

			@Override
			public int compare(EPackage o1, EPackage o2) {
				return o1.getName().equals(o2.getName()) ? o1.getNsURI().compareTo(o2.getNsURI()) : o1.getName().compareTo(o2.getName());
			}
			
		});
		Z: for (EPackage ePackage: packages) {
			for (Pattern p: packageExcludes) {
				if (p.matcher(ePackage.getNsURI()).matches()) {
					continue Z;
				}
			}
			if (!packageIncludes.isEmpty()) {
				boolean included = false;
				for (Pattern p: packageIncludes) {
					if (p.matcher(ePackage.getNsURI()).matches()) {
						included = true;
						break;
					}
				}				
				if (!included) {
					continue Z;
				}
			}
			createEPackageToc(owner, ePackage, prefix);
		}
	}
		
	private void createEPackageToc(TocNode parent, EPackage ePackage, String prefix) {
		TocNode ePackageToc = parent.createChild(ePackage.getName(), prefix+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */))+"/"+PACKAGE_SUMMARY_HTML, "/resources/images/EPackage.gif", null);
		List<EPackage> subPackages = new ArrayList<>(ePackage.getESubpackages());
		Collections.sort(subPackages, new Comparator<EPackage>() {

			@Override
			public int compare(EPackage o1, EPackage o2) {
				return o1.getName().equals(o2.getName()) ? o1.getNsURI().compareTo(o2.getNsURI()) : o1.getName().compareTo(o2.getName());
			}
			
		});
		
		for (EPackage subPackage: subPackages) {
			createEPackageToc(ePackageToc, subPackage, prefix);
		}
		
		List<EClassifier> pClassifiers = new ArrayList<>(ePackage.getEClassifiers());
		Collections.sort(pClassifiers, new Comparator<EClassifier>() {

			@Override
			public int compare(EClassifier o1, EClassifier o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		for (EClassifier eClassifier: pClassifiers) {
			createEClassifierToc(ePackageToc, eClassifier, prefix);				
		}
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(ePackage.getNsURI());
			if (pe!=null) {
				for (TocNodeFactory tnf: pe.tocNodeFactories) {
					if (!tnf.isSection() && !tnf.isElementDoc() && tnf.isRoot(pe.tocNodeFactories)) {
						tnf.createTocNode(ePackageToc, pe.tocNodeFactories, false);
					}
				}
			}
		}		
	}

	private void createEClassifierToc(TocNode parent, EClassifier eClassifier, String prefix) {
		String href = prefix+"/"+Hex.encodeHexString(eClassifier.getEPackage().getNsURI().getBytes(/* UTF-8? */))+"/"+eClassifier.getName();
		TocNode cToc;
		if (eClassifier instanceof EClass) {
			cToc = parent.createChild(eClassifier.getName(), href, "/resources/images/EClass.gif", null);
			EClassKey subTypeKey = new EClassKey((EClass) eClassifier);
			for (EClass sc: ((EClass) eClassifier).getESuperTypes()) {
				EClassKey superTypeKey = new EClassKey(sc);
				Set<EClassKey> subTypes = inheritanceMap.get(superTypeKey);
				if (subTypes==null) {
					subTypes = new TreeSet<>();
					inheritanceMap.put(superTypeKey, subTypes);
				}
				subTypes.add(subTypeKey);
			}
		} else if (eClassifier instanceof EEnum) {
			cToc = parent.createChild(eClassifier.getName(), href, "/resources/images/EEnum.gif", null);
		} else {
			cToc = parent.createChild(eClassifier.getName(), href, "/resources/images/EDataType.gif", null);
		}
		
		synchronized (packageTocNodeFactories) {
			PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(eClassifier.getEPackage().getNsURI());
			if (pe!=null) {
				List<TocNodeFactory> ctnfl = pe.classifierTocNodeFactories.get(eClassifier.getName());
				if (ctnfl!=null) {
					for (TocNodeFactory tnf: ctnfl) {
						if (!tnf.isSection() && !tnf.isElementDoc() && tnf.isRoot(ctnfl)) {
							tnf.createTocNode(cToc, ctnfl, false);
						}
					}
				}
			}
		}
		
		// TODO - from extensions
	}
	
	public Object getContent(URL baseURL, String urlPrefix, String path) {
		if (path.startsWith(PACKAGES_GLOBAL_PATH)) {
			String[] subPath = path.substring(PACKAGES_GLOBAL_PATH.length()).split("/");
			EPackage ePackage;
			try {
				ePackage = EPackage.Registry.INSTANCE.getEPackage(new String(Hex.decodeHex(subPath[0].toCharArray())));
			} catch (DecoderException e) {
				throw new NasdanikaException(e);
			}
			if (ePackage==null) {
				return null;
			}
			if (subPath.length==1 || PACKAGE_SUMMARY_HTML.equals(subPath[1])) {
				return getEPackageContent(baseURL, urlPrefix, ePackage, docRoutePath+"/packages/global");
			}
			EClassifier eClassifier = ePackage.getEClassifier(subPath[1]);
			return eClassifier==null ? null : getEClassifierContent(baseURL, urlPrefix, eClassifier, docRoutePath+"/packages/global");
		} 
		
		if (path.startsWith(PACKAGES_SESSION_PATH)) {
			if (cdoSessionProvider==null) {
				return null;
			}
			String[] subPath = path.substring(PACKAGES_SESSION_PATH.length()).split("/");
			EPackage ePackage;
			try {
				ePackage = cdoSessionProvider.getSession().getPackageRegistry().getEPackage(new String(Hex.decodeHex(subPath[0].toCharArray())));
			} catch (DecoderException e) {
				throw new NasdanikaException(e);
			}
			if (ePackage==null) {
				return null;
			}
			if (subPath.length==1 || PACKAGE_SUMMARY_HTML.equals(subPath[1])) {
				return getEPackageContent(baseURL, urlPrefix, ePackage, docRoutePath+"/packages/session");
			}
			EClassifier eClassifier = ePackage.getEClassifier(subPath[1]);
			return eClassifier==null ? null : getEClassifierContent(baseURL, urlPrefix, eClassifier, docRoutePath+"/packages/global");				
		} 
		
		if (path.startsWith(BUNDLE_PATH)) {
			int idx = path.indexOf("/", BUNDLE_PATH.length());
			if (idx==-1) {
				return null;
			}
			String bundleId = path.substring(BUNDLE_PATH.length(), idx);
			
			// A hack to document extensions, need a better way in the future
			if ("org.nasdanika.cdo.web.doc".equals(bundleId) && "extensions.html".equals(path.substring(idx+1))) {
				return generateExtensionsDocumentation(baseURL, urlPrefix, path);
			}			
			
			for (Bundle targetBundle: bundleContext.getBundles()) {
				if (bundleId.equals(targetBundle.getSymbolicName())) {
					return targetBundle.getResource(path.substring(idx+1));
				}
			}
			return null;
		} 
		
		if (path.startsWith(RESOURCES_PATH)) {
			return getResource(getClass(), path.substring(RESOURCES_PATH.length()));
		} 
		
		// TODO - extensions
		
		return null; // Not found
	}
	
	private EClassDocumentationGenerator eClassDocumentationGenerator;	
	private EDataTypeDocumentationGenerator eDataTypeDocumentationGenerator;	
	private EEnumDocumentationGenerator eEnumDocumentationGenerator;	
	
	private Object getEClassifierContent(URL baseURL, String urlPrefix, EClassifier eClassifier, String registryPath) {
		if (eClassifier instanceof EClass) {
			return eClassDocumentationGenerator.generate(baseURL, urlPrefix, htmlFactory, docRoutePath, registryPath, (EClass) eClassifier);
		} 
		
		if (eClassifier instanceof EEnum) {
			return eEnumDocumentationGenerator.generate(baseURL, urlPrefix, htmlFactory, docRoutePath, registryPath, (EEnum) eClassifier);			
		}
		
		return eDataTypeDocumentationGenerator.generate(baseURL, urlPrefix, htmlFactory, docRoutePath, registryPath, (EDataType) eClassifier);			
	}
	
	private EPackageDocumentationGenerator ePackageDocumentationGenerator;

	private Object getEPackageContent(URL baseURL, String urlPrefix, EPackage ePackage, String registryPath) {
		return ePackageDocumentationGenerator.generate(baseURL, urlPrefix, htmlFactory, docRoutePath, registryPath, ePackage);
	}

	public void deactivate(ComponentContext context) throws Exception {
		if (searchIndexReader!=null) {
			searchIndexReader.close();
		}
		if (searchIndexDirectory!=null) {
			searchIndexDirectory.close();
			searchIndexDirectory = null;
		}
		if (analyzer!=null) {
			analyzer.close();
			analyzer = null;
		}
		if (extensionTracker!=null) {
			extensionTracker.close();
			extensionTracker = null;
		}
		if (loadTimer!=null) {
			loadTimer.cancel();
			loadTimer = null;
		}
	}
	
	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		String[] path = new String[context.getPath().length-pathOffset];
		System.arraycopy(context.getPath(), pathOffset, path, 0, path.length);
		if (RequestMethod.GET.equals(context.getMethod())) {
			if (path.length==1) {
				if (lock.readLock().tryLock(30, TimeUnit.SECONDS)) {
					try {
						if ("toc.js".equals(path[0])) {
							final String hrefPrefix = "#router/doc-content/"+docRoutePath; 
							final JSONObject idMap = new JSONObject();
							tocRoot.accept(new TocNodeVisitor() {
								
								@Override
								public void visit(TocNode tocNode) {
									try{
										idMap.put(tocNode.getId(), hrefPrefix+tocNode.getHref());
									} catch (JSONException e) {
										e.printStackTrace(); // TODO - better handling.
									}
									
								}
							});
							JSONObject ret = new JSONObject();
							ret.put("idMap", idMap);
							ret.put("tree", tocRoot.toJSON(docRoutePath).get("children"));
							return new ValueAction("define("+ret+")");
						} else if ("search".equals(path[0])) {
					        QueryParser parser = new QueryParser("text", analyzer);
					        Query query = parser.parse(context.getRequest().getParameter("query"));
							ScoreDoc[] scoreDocs = indexSearcher.search(query, 150).scoreDocs;
							JSONArray searchResults = new JSONArray();
					        for (ScoreDoc scoreDoc: scoreDocs) {
								Document hitDoc = indexSearcher.doc(scoreDoc.doc);
								JSONObject searchResult = new JSONObject();
								searchResults.put(searchResult);
								String hitPath = hitDoc.get("path");
								searchResult.put("href", "#router/doc-content/"+docRoutePath+hitPath);
								TocNode tocEntry = tocRoot.find(hitPath);
								if (tocEntry==null || tocEntry.getText()==null) {
									int idx = hitPath.lastIndexOf("/");
									String lastSegment = idx==-1 ? hitPath : hitPath.substring(idx+1);
									idx = lastSegment.lastIndexOf(".");
									String title = idx==-1 ? lastSegment : lastSegment.substring(0, idx);
									searchResult.put("name", title.replace('_', ' '));
									searchResult.put("icon", "");
								} else {
									searchResult.put("name", tocEntry.getText());
									searchResult.put("icon", tocEntry.getIcon()==null ? "" : context.getContextURL()+"/doc"+tocEntry.getIcon());
								}
								  
					        }
					        return new ValueAction(searchResults.toString());
						}
					} finally {
						lock.readLock().unlock();
					}
				} else {
					System.out.println("Could not perform action due to toc and index being rebuilt");
					return Action.INTERNAL_SERVER_ERROR; // TODO - better info if reloading takes too long
				}
				
				return Action.NOT_FOUND;
			} 
									
			String requestURL = context.getRequest().getRequestURL().toString();
			String requestURI = context.getRequest().getRequestURI();
			String urlPrefix = requestURL.endsWith(requestURI) ? requestURL.substring(0, requestURL.length()-requestURI.length()) : null;
			String prefix = docAppPath+"#router/doc-content/"+docRoutePath;
			String pathStr = "/"+StringUtils.join(path, "/");
			Object content = getContent(new URL(requestURL), urlPrefix, pathStr);
			if (content!=null) {
				if (path.length>0) {
					String contentType = "packages".equals(path[0]) ? "text/html" : mimeTypesMap.getContentType(path[path.length-1]);
					if (contentType!=null) {
						Map<String, ExtensionEntry<ContentFilter>> tm = contentFilters.get(contentType);
						if (tm!=null) {
							for (Entry<String, ExtensionEntry<ContentFilter>> tme: tm.entrySet()) {
								context.getResponse().setContentType(tme.getKey());
								Object filteredContent = tme.getValue().extension.filter(content, this, new URL(requestURL), urlPrefix);
								if ("text/html".equals(tme.getKey()) && filteredContent instanceof String) {
									TocNode toc = tocRoot.find(pathStr);
									if (toc!=null) {
										filteredContent = navWrap(context.adapt(HTMLFactory.class), toc, (String) filteredContent, prefix);
									}
								}
								return new ValueAction(filteredContent);
							}
						}
					}
					if ("text/html".equals(contentType) && content instanceof String) {
						TocNode toc = tocRoot.find(pathStr);
						if (toc!=null) {
							content = navWrap(context.adapt(HTMLFactory.class), toc, (String) content, prefix);
						}
					}
				}
				return new ValueAction(content);
			}
			
			if ("toc".equals(path[0])) {
				TocNode toc;
				if (path.length==2) {
					toc = tocRoot.find(pathStr);
				} else {					
					toc = tocRoot.findByTocId(CoreUtil.join(path, "/", 1));
				}
					
				if (toc==null) {
					return Action.NOT_FOUND;
				}
								
				context.getResponse().setContentType(MIME_TYPE_HTML);
				Fragment fragment = htmlFactory.fragment(htmlFactory.tag(TagName.h1, StringEscapeUtils.escapeHtml4(toc.getText())));
				if (CoreUtil.isBlank(toc.getContent())) {
					Tag childList = htmlFactory.tag(TagName.ul);
					fragment.content(childList);
					for (TocNode ch: toc.getChildren()) {
						childList.content(htmlFactory.tag(TagName.li, htmlFactory.link(prefix+ch.getHref(), StringEscapeUtils.escapeHtml4(ch.getText()))));
					}										
				} else {
					fragment.content(toc.getContent());
				}
				return new ValueAction(navWrap(context.adapt(HTMLFactory.class), toc, fragment.toString(), prefix));
			}
			
			if (path.length>2 && "resources".equals(path[0])) {
				String resourcePath = StringUtils.join(path, "/", 1, path.length);
				URL res = getResource(getClass(), resourcePath);
				if (res==null) {
					return Action.NOT_FOUND;
				}						
				
				HttpServletRequestContext httpContext = (HttpServletRequestContext) context;
				
				try (InputStream resourceStream = new BufferedInputStream(res.openStream()); OutputStream out = new BufferedOutputStream(httpContext.getResponse().getOutputStream())) {
					for (int b = resourceStream.read(); b!=-1; b = resourceStream.read()) {
						out.write(b);
					}
				}
				
				return Action.NOP; 
			}
		}
		return Action.NOT_FOUND;
	}
	
	protected URL getResource(Class<?> clazz, String resourcePath) {
		Bundle docBundle = FrameworkUtil.getBundle(clazz);
		if (docBundle!=null) {
			URL res = docBundle.getResource(resourcePath);
			if (res!=null) {
				return res;
			}
		}
		
		Class<?> superClass = clazz.getSuperclass();
		if (superClass!=null) {
			URL res = getResource(superClass, resourcePath);
			if (res!=null) {
				return res;
			}
		}
		
		for (Class<?> i: clazz.getInterfaces()) {
			URL res = getResource(i, resourcePath);
			if (res!=null) {
				return res;
			}			
		}
		
		return null;
	}
	
	public String generateExtensionsDocumentation(URL baseURL, String urlPrefix, String path) {		
		try {
			Tabs ret = htmlFactory.tabs();
			PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.ALL ^ Extensions.HARDWRAPS);
			LinkRenderer mlr = createMarkdownLinkRenderer(new URL(baseURL, path), urlPrefix);
			if (!pluginMap.isEmpty()) {
				Table pluginTable = htmlFactory.table().bordered();
				Row hRow = pluginTable.row().style(Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(pluginMap.keySet())) {
					Row rRow = pluginTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<Plugin> extensionEntry = pluginMap.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(expand(extensionEntry.description, baseURL, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Plugins", pluginTable);
			}
			if (!wikiLinkResolverMap.isEmpty()) {
				Table resolverTable = htmlFactory.table().bordered();
				Row hRow = resolverTable.row().style(Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(wikiLinkResolverMap.keySet())) {
					Row rRow = resolverTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<WikiLinkResolver> extensionEntry = wikiLinkResolverMap.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(expand(extensionEntry.description, baseURL, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Wiki Link Resolvers", resolverTable);
			}
			if (!wikiLinkRendererMap.isEmpty()) {
				Table rendererTable = htmlFactory.table().bordered();
				Row hRow = rendererTable.row().style(Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(wikiLinkRendererMap.keySet())) {
					Row rRow = rendererTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<Renderer> extensionEntry = wikiLinkRendererMap.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(expand(extensionEntry.description, baseURL, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Wiki Link Renderers", rendererTable);				
			}
			if (!contentFilters.isEmpty()) {
				Table contentFiltersTable = htmlFactory.table().bordered();
				Row hRow = contentFiltersTable.row().style(Style.INFO);
				hRow.header("From");
				hRow.header("To");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String fromType: new TreeSet<String>(contentFilters.keySet())) {
					Row filterRow = contentFiltersTable.row();
					Map<String, ExtensionEntry<ContentFilter>> toFilters = contentFilters.get(fromType);
					filterRow.cell(StringEscapeUtils.escapeHtml4(fromType)).rowspan(toFilters.size());
					boolean isFirst = true;
					for (String toType: new TreeSet<String>(toFilters.keySet())) {
						if (!isFirst) {
							filterRow = contentFiltersTable.row();
						}
						filterRow.cell(toType);
						ExtensionEntry<ContentFilter> extensionEntry = toFilters.get(toType);
						filterRow.cell(pegDownProcessor.markdownToHtml(expand(extensionEntry.description, baseURL, urlPrefix), mlr));
						if (extensionEntry.extension instanceof ConfigurableExtension) {
							filterRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
						} else {
							filterRow.cell("");
						}						
						isFirst = false;
					}
				}
				ret.item("Content Filters", contentFiltersTable);				
			}
			
			if (!eAnnotationRenderers.isEmpty()) {
				Table rendererTable = htmlFactory.table().bordered();
				Row hRow = rendererTable.row().style(Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(eAnnotationRenderers.keySet())) {
					Row rRow = rendererTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<EAnnotationRenderer> extensionEntry = eAnnotationRenderers.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(expand(extensionEntry.description, baseURL, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Annotation Renderers", rendererTable);				
			}
					
			return ret.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	private static HighlightModuleGenerator HIGHLIGHT_MODULE_GENERATOR = new HighlightModuleGenerator();
	private static SelectTocNodeModuleGenerator SELECT_TOC_NODE_MODULE_GENERATOR = new SelectTocNodeModuleGenerator();
	
	protected String navWrap(HTMLFactory htmlFactory, TocNode toc, String content, String prefix) {
		Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs();
		for (TocNode pathElement: toc.getPath()) {
			if (pathElement.getText()!=null) {
				String bcContent;
				if (pathElement.getIcon()==null) {
					bcContent = pathElement.getText();
				} else {
					bcContent = htmlFactory.tag(TagName.img).attribute("src", getDocRoutePath()+pathElement.getIcon()).style("margin-right", "1px") + pathElement.getText();
				}
				breadcrumbs.item(pathElement==toc ? null : "javascript:"+tocNodeSelectScript(pathElement.getId()), bcContent); // prefix+pathElement.getHref()
			}
		}
		
		// TODO - backlinks collapsible.
		
		return breadcrumbs.toString() + 
				(toc.getText()==null ? "Documentation" : htmlFactory.title(toc.getText())) +
				content + 
				htmlFactory.tag(TagName.script, HIGHLIGHT_MODULE_GENERATOR.generate(docRoutePath)) +
				htmlFactory.tag(TagName.script, SELECT_TOC_NODE_MODULE_GENERATOR.generate(new Object[] {docRoutePath, toc.getId()}));
		
	}
	
	/**
	 * For paths corresponding to TOC node returns javascript to activate path through content tree
	 * @param relPath
	 * @return
	 */
	public String tocLink(String href) {
		String prefix = "#router/doc-content/"+docRoutePath;
		if (href==null || !href.startsWith(prefix)) {
			return href;
		}
		
		String path = href.substring(prefix.length());
		TocNode toc = tocRoot.find(path);
		if (toc==null) {
			return href;
		}
		return "javascript:"+tocNodeSelectScript(toc.getId());
	}

	public static String tocNodeSelectScript(String nodeID) {
		String selectScript = 
				"var tocTree = jQuery('#toc'); "
				+ "if (!tocTree.jstree('is_selected', '#"+nodeID+"')) { "
				+ "tocTree.jstree('deselect_all');  tocTree.jstree('select_node', '#"+nodeID+"'); }";
		return selectScript;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
		
	}
	
	public LinkRenderer createMarkdownLinkRenderer(final URL baseURL, final String urlPrefix) {
		Renderer.Registry rendererRegistry = new Renderer.Registry() {

			@Override
			public Renderer getRenderer(String name) {
				ExtensionEntry<Renderer> extensionEntry = wikiLinkRendererMap.get(name);
				return extensionEntry==null ? null : extensionEntry.extension;
			}
			
		};
		
		final String absDocRoutePath = urlPrefix+docRoutePath;	
		final Map<Object, Object> env = new HashMap<>();
		String baseURLStr = baseURL.toString();
		if (baseURLStr.startsWith(absDocRoutePath)) {
			String relPath = baseURLStr.substring(absDocRoutePath.length());
			for (TocNode toc = tocRoot==null ? null : tocRoot.find(relPath); toc!=null; toc = toc.getParent()) {
				if (toc.getHref()!=null && toc.getHref().startsWith(PACKAGES_PATH)) {
					env.put(CONTEXT_MODEL_ELEMENT_PATH_KEY, docRoutePath+toc.getHref());
				}
			}
		}
		env.put(DocRoute.class, this);
		
		Resolver.Registry resolverRegistry = new Resolver.Registry() {
			
			@Override
			public Resolver getResolver(String name) {
				ExtensionEntry<WikiLinkResolver> resolverExtensionEntry = wikiLinkResolverMap.get(name);
				final WikiLinkResolver toWrap = resolverExtensionEntry==null ? null : resolverExtensionEntry.extension;
				if (toWrap==null) {
					return null;
				}
				if (toWrap instanceof Renderer) {
					class JackOfTwoTrades implements Renderer, Resolver {

						@Override
						public String resolve(String href) {
							return toWrap.resolve(href, absDocRoutePath, env);
						}

						@Override
						public Rendering render(String href, String content, String config, boolean isMissing) {
							return ((Renderer) toWrap).render(href, content, config, isMissing);
						}
						
					}
					
					return new JackOfTwoTrades();
				}
				
				return new Resolver() {

					@Override
					public String resolve(String href) {
						return toWrap.resolve(href, absDocRoutePath, env);
					}
					
				};
			}
		};
		
		LinkInfo.Registry linkRegistry = new LinkInfo.Registry() {
			
			@Override
			public LinkInfo getLinkInfo(String url) {
				try {
					String absURL = new URL(baseURL, url).toString();
					if (absURL.startsWith(absDocRoutePath)) {
						String relPath = absURL.substring(absDocRoutePath.length());
						final boolean isMissing = missingPaths!=null && missingPaths.contains(relPath);
						final TocNode toc = tocRoot.find(relPath);						
						if (toc==null) {
							return new LinkInfo() {

								@Override
								public String getIconTag() {
									return null;
								}

								@Override
								public String getLabel() {
									return null;
								}

								@Override
								public boolean isMissing() {
									return isMissing;
								}
								
							};
						}						
						
						return new LinkInfo() {

							@Override
							public String getIconTag() {
								return CoreUtil.isBlank(toc.getIcon()) ? "" : "<img style=\"vertical-align: text-top; margin-right:1px;\" src=\""+docRoutePath+toc.getIcon()+"\"/>";
							}

							@Override
							public String getLabel() {
								return toc.getText();
							}

							@Override
							public boolean isMissing() {
								return isMissing;
							}
							
						};
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		
		URLRewriter urlRewriter = new URLRewriter() {
			
			@Override
			public String rewrite(String spec) {
				try {
					URL url = new URL(baseURL, spec);
					String ret = url.toString();
					if (ret.startsWith(urlPrefix)) {
						String relURL = ret.substring(urlPrefix.length());
						if (relURL.startsWith(docRoutePath)) {
							if (relURL.startsWith(docRoutePath+"/packages/") || relURL.startsWith(docRoutePath+"/toc/")) {
								return tocLink("#router/doc-content/"+relURL);								
							}
							int idx = relURL.lastIndexOf('/');
							String fn = idx==-1 ? relURL : relURL.substring(idx+1);
							String contentType = mimeTypesMap.getContentType(fn);
							if (contentType!=null) {
								if (!MIME_TYPE_HTML.equals(contentType)) {
									Map<String, ExtensionEntry<ContentFilter>> tm = contentFilters.get(contentType);
									if (tm!=null && tm.containsKey(MIME_TYPE_HTML)) {
										contentType = MIME_TYPE_HTML;
									}
								}
								if (MIME_TYPE_HTML.equals(contentType)) {
									return tocLink("#router/doc-content/"+relURL);
								}
							}
						}
					}
					return ret;
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return spec;
				}
			}
		};
		
		return new MarkdownLinkRenderer(baseURL, rendererRegistry, resolverRegistry, linkRegistry, urlRewriter);				
	}
	
	/**
	 * Expands {{plugin(config)&gt;content}} tokens. Example: <code>{{youtube(large)&gt;qfvr6HWo_Ok}}</code>.
	 * Plugin name is mandatory, config and content are optional. <code>}}</code> in config and content can be escaped with <code>\</code>, e.g. <code>\}}</code>
	 * @param content
	 * @param path
	 * @return
	 */
	public String expand(String content, final URL baseURL, final String urlPrefix) {		
		if (!expandContent || content == null || content.length()==0) {
			return "";			
		}
		
		Plugin.Filter filter = new Plugin.Filter() {
			
			@Override
			public String filter(Object filterContent) {
				return expand(CoreUtil.stringify(filterContent), baseURL, urlPrefix);
			}
			
		};				
	
		StringBuilder out = new StringBuilder();
		int pos = 0;
		O: for (int openTagIdx = DocUtil.indexOf(content, pos, '{'); openTagIdx!=-1; openTagIdx = DocUtil.indexOf(content, pos, '{')) {
			
			if (openTagIdx==content.length()-1) {
				break;
			}
						
			// No second {
			if (content.charAt(openTagIdx+1)!='{') {
				if (content.length()>openTagIdx+2 && content.substring(openTagIdx+1, openTagIdx+3).equals("\\{")) {
					out.append(content.substring(pos, openTagIdx+1)).append("{");					
					pos = openTagIdx+3;					
				} else {
					out.append(content.substring(pos, openTagIdx+1));
					pos = openTagIdx+1;
				}
				continue;
			}
			
			for (int closeTagIdx = DocUtil.indexOf(content, openTagIdx+2, '}'); closeTagIdx!=-1; closeTagIdx = DocUtil.indexOf(content, closeTagIdx+1, '}')) {
				
				if (closeTagIdx==content.length()-1) {
					break O;
				}			
				
				// No second {
				if (content.charAt(closeTagIdx+1)!='}') {
					closeTagIdx++;
					continue;
				}
												
				int gtIdx = DocUtil.indexOf(content, openTagIdx+2, '>');
				String pluginSpec = content.substring(openTagIdx+2, gtIdx==-1 || gtIdx>closeTagIdx ? closeTagIdx : gtIdx);
				ExtensionEntry<Plugin> pluginExtension = null;
				String pluginConfig = null;
				int lParIdx = DocUtil.indexOf(pluginSpec, 0, '(');
				if (lParIdx==-1) {
					pluginExtension = pluginMap.get(DocUtil.unescape(pluginSpec));
				} else {
					int rParIdx = DocUtil.indexOf(pluginSpec, lParIdx, ')');
					if (rParIdx!=-1) {
						pluginConfig = DocUtil.unescape(pluginSpec.substring(lParIdx+1, rParIdx));
						pluginExtension = pluginMap.get(DocUtil.unescape(pluginSpec.substring(0, lParIdx)));					
					}
				}
				if (pluginExtension==null) {
					out.append(content.substring(pos, openTagIdx+2));
					pos = openTagIdx+2;
					continue O;						
				}
				
				String pluginContent = gtIdx==-1 || gtIdx>closeTagIdx ? null : expand(content.substring(gtIdx+1, closeTagIdx), baseURL, urlPrefix);  
				
				Object processed = pluginExtension.extension.process(pluginConfig, pluginContent, baseURL, urlPrefix, filter, this);
				if (processed == null) {
					out.append(content.substring(pos, openTagIdx+2));
					pos = openTagIdx+2;
				} else {					
					out.append(content.substring(pos, openTagIdx));
					out.append(CoreUtil.stringify(processed));
					pos = closeTagIdx+2;
				}
				break;
			}
		}
		out.append(content.substring(pos));
		return out.toString();
	}
	
	public Resolver.Registry getResolverRegistry(URL baseURL, String urlPrefix) {
		final String absDocRoutePath = urlPrefix+docRoutePath;	
		final Map<Object, Object> env = new HashMap<>();
		String baseURLStr = baseURL.toString();
		if (baseURLStr.startsWith(absDocRoutePath)) {
			String relPath = baseURLStr.substring(absDocRoutePath.length());
			for (TocNode toc = tocRoot==null ? null : tocRoot.find(relPath); toc!=null; toc = toc.getParent()) {
				if (toc.getHref()!=null && toc.getHref().startsWith(PACKAGES_PATH)) {
					env.put(CONTEXT_MODEL_ELEMENT_PATH_KEY, docRoutePath+toc.getHref());
				}
			}
		}
		env.put(DocRoute.class, this);
		return new Resolver.Registry() {
			
			@Override
			public Resolver getResolver(String name) {
				ExtensionEntry<WikiLinkResolver> resolverExtensionEntry = wikiLinkResolverMap.get(name);
				final WikiLinkResolver toWrap = resolverExtensionEntry==null ? null : resolverExtensionEntry.extension;
				if (toWrap==null) {
					return null;
				}
				if (toWrap instanceof Renderer) {
					class JackOfTwoTrades implements Renderer, Resolver {

						@Override
						public String resolve(String href) {
							return toWrap.resolve(href, absDocRoutePath, env);
						}

						@Override
						public Rendering render(String href, String content, String config, boolean isMissing) {
							return ((Renderer) toWrap).render(href, content, config, isMissing);
						}
						
					}
					
					return new JackOfTwoTrades();
				}
				
				return new Resolver() {

					@Override
					public String resolve(String href) {
						return toWrap.resolve(href, absDocRoutePath, env);
					}
					
				};
			}
		};
		
	}
	
}
