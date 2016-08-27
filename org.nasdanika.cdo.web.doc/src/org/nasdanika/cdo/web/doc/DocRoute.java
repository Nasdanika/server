package org.nasdanika.cdo.web.doc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.MimetypesFileTypeMap;

// TODO? - switch to org.osgi.service.component.runtime.ServiceComponentRuntime when it is (easily) available in Equinox

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.Component;
import org.apache.felix.scr.ScrService;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.SearcherFactory;
import org.apache.lucene.search.SearcherManager;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.nasdanika.cdo.web.doc.MarkdownPreProcessor.Region;
import org.nasdanika.cdo.web.doc.TocNode.TocNodeVisitor;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.LinkInfo;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Resolver;
import org.nasdanika.cdo.web.doc.story.StoryDocumentationGenerator;
import org.nasdanika.cdo.web.doc.webtest.TestResultsDocumentationGenerator;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.AbstractRoutingServlet;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.ValueAction;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Version;
import org.osgi.service.component.ComponentContext;
import org.pegdown.Extensions;
import org.pegdown.LinkRenderer;
import org.pegdown.LinkRenderer.Rendering;
import org.pegdown.PegDownProcessor;

public class DocRoute implements Route, BundleListener, DocumentationContentProvider {
		
	public static final String ROUTER_DOC_CONTENT_FRAGMENT_PREFIX = "#router/doc-content/";
	static final String COMPONENT_NAME = "component-name";
	static final String BUNDLE_VERSION = "bundle-version";
	private static final String BUNDLE_SYMBOLIC_NAME = "bundle-symbolic-name";
	private static final String VERSION = "version";
	private static final String SYMBOLIC_NAME = "symbolic-name";
	public static final String NS_URI = "ns-uri";
	private static final String DIAGRAM_PNG = "diagram.png";
	private static final String INDEX_HTML = "index.html";
	private static final String PACKAGE_SUMMARY_HTML = "package-summary.html";
	public static final String MIME_TYPE_HTML = "text/html";
	private static final String WIKI_LINK_RENDERER = "wiki-link-renderer";
	private static final String WIKI_LINK_RESOLVER = "wiki-link-resolver";
	private static final String EPACKAGE_DOCUMENTATION_GENERATOR = "epackage-documentation-generator";
	private static final String ECLASS_DOCUMENTATION_GENERATOR = "eclass-documentation-generator";
	private static final String EDATATYPE_DOCUMENTATION_GENERATOR = "edatatype-documentation-generator";
	private static final String EENUM_DOCUMENTATION_GENERATOR = "eenum-documentation-generator";
	private static final String MIME_TYPE = "mime-type";
	private static final String MARKDOWN_PRE_PROCESSOR = "markdown-pre-processor";
	private static final String EANNOTATION_RENDERER = "eannotation-renderer";
	private static final String CONTENT_FILTER = "content-filter";
	
	private static final String TOC = "toc";
	private static final String EPACKAGE_TOC = "epackage-toc";
	private static final String ECLASSIFIER_TOC = "eclassifier-toc";
	private static final String BUNDLE_TOC = "bundle-toc";
	private static final String COMPONENT_TOC = "component-toc";
	
	private static final String RESOURCES_PATH = "/resources/";
	public static final String BUNDLE_PATH = "/bundle/";
	public static final String BUNDLE_INFO_PATH = "/bundle-info/";
	public static final String COMPONENT_INFO_PATH = "/component-info/";	
	private static final String PACKAGES_PATH = "/packages/";
	private static final String PACKAGES_SESSION_PATH = PACKAGES_PATH + "session/";
	private static final String PACKAGES_GLOBAL_PATH = PACKAGES_PATH + "global/";
	private static final String TOC_PATH = "/toc/";
	
	public static final String STORY_PATH = "/story/";
	public static final String TEST_RESULTS_PATH = "/test-results/";	
	
	public static final String CONTEXT_MODEL_ELEMENT_PATH_KEY = "contextModelElementPath";
	public static final int MARKDOWN_OPTIONS = 	Extensions.ALL ^ Extensions.HARDWRAPS ^ Extensions.SUPPRESS_HTML_BLOCKS ^ Extensions.SUPPRESS_ALL_HTML;

	private ScrService scrService;
	private int pathOffset = 1;
	private BundleContext bundleContext;
	private Directory searchIndexDirectory;
	private SearcherManager searcherManager;
	private StandardAnalyzer analyzer;
	private CDOSessionProvider cdoSessionProvider;
	private HTMLFactory htmlFactory = HTMLFactory.INSTANCE;
	private String docRoutePath = "/router/doc";
	private String docAppPath = "/router/doc.html";
	private long reloadDelay = 30000; // Wait 30 seconds before reloading index on extension tracker notifications. 
	private Timer loadTimer;
	
	private Boolean includeSessionRegistry = true;
	private Boolean includeGlobalRegistry = true;
	private Boolean bundleToc = true;
	private List<Pattern> bundleIncludes = new ArrayList<>();
	private List<Pattern> bundleExcludes = new ArrayList<>();
	private List<Pattern> packageIncludes = new ArrayList<>();
	private List<Pattern> packageExcludes = new ArrayList<>();
		
	private static Pattern SENTENCE_PATTERN = Pattern.compile(".+?[\\.?!]+\\s+");	
	
	private static String[] ABBREVIATIONS = { "e.g.", "i.e." }; // TODO - load from extensions?
		
	private int maxFirstSentenceLength = 250;
	
	public void setMaxFirstSentenceLength(int maxFirstSentenceLength) {
		this.maxFirstSentenceLength = maxFirstSentenceLength;
	}
	
	public int getMaxFirstSentenceLength() {
		return maxFirstSentenceLength;
	}	
	
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
	
	public Map<String, EAnnotationRenderer> getEAnnotationRenderers() {
		Map<String, EAnnotationRenderer> ret = new ConcurrentHashMap<>();
		for (Entry<String, ExtensionEntry<EAnnotationRenderer>> e: eAnnotationRenderers.entrySet()) {
			ret.put(e.getKey(), e.getValue().extension);
		}
		return ret;
	}
	
	private Collection<String> storyModels = new ArrayList<>();
	private Collection<String> testResultsModels = new ArrayList<>();
	
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
	
	static class EModelElementDocumentationGeneratorKey implements Comparable<EModelElementDocumentationGeneratorKey> {
		
		private String type;
		private int priority;
		private String nsURI;
		private String name;

		EModelElementDocumentationGeneratorKey(IConfigurationElement ce) {
			type = ce.getName();
			priority = Integer.parseInt(ce.getAttribute("priority").trim());
			nsURI = ce.getAttribute(NS_URI);
			if (nsURI==null) {
				nsURI = "";
			} else {
				nsURI = nsURI.trim();
			}
			name = ce.getAttribute("name");
			if (name==null) {
				name = "";
			} else {
				name = name.trim();
			}
		}
		
		boolean match(EPackage ePackage) {
			return CoreUtil.isBlank(nsURI) || nsURI.equals(ePackage.getNsURI());
		}
		
		boolean match(EClassifier eClassifier) {
			return match(eClassifier.getEPackage()) && (CoreUtil.isBlank(name) || name.equals(eClassifier.getName()));
		}

		@Override
		public int compareTo(EModelElementDocumentationGeneratorKey o) {
			if (o.priority!=priority) {
				return o.priority - priority;
			}
			
			if (o.nsURI.length()!=nsURI.length()) {
				return o.nsURI.length()-nsURI.length();
			}
			
			if (!o.nsURI.equals(nsURI)) {
				return nsURI.compareTo(o.nsURI);
			}
			
			if (o.name.length()!=name.length()) {
				return o.name.length()-name.length();
			}
			
			return name.compareTo(o.name);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((nsURI == null) ? 0 : nsURI.hashCode());
			result = prime * result + priority;
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			EModelElementDocumentationGeneratorKey other = (EModelElementDocumentationGeneratorKey) obj;
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
			if (priority != other.priority)
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}	

	}
	
	private Map<String, ExtensionEntry<WikiLinkProcessor.Renderer>> wikiLinkRendererMap = new ConcurrentHashMap<>();
	private Map<String, ExtensionEntry<WikiLinkResolver>> wikiLinkResolverMap = new ConcurrentHashMap<>();
	private Map<String, ExtensionEntry<List<String>>> mimeTypeMap = new ConcurrentHashMap<>();
	private List<ExtensionEntry<MarkdownPreProcessor>> preProcessors = new ArrayList<>();
	private List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
	
	private Map<EClassifierKey,Set<EClassifierKey>> inheritanceMap = new ConcurrentHashMap<>(); 
	
	public Map<EClassifierKey, Set<EClassifierKey>> getInheritanceMap() {
		return inheritanceMap;
	}
	
	public static class PackageTocNodeFactoryEntry {

		public final List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
		
		public final Map<String, List<TocNodeFactory>> classifierTocNodeFactories = new HashMap<>();
		
	}

	private Map<String, PackageTocNodeFactoryEntry> packageTocNodeFactories = new HashMap<>();

	public static class BundleTocNodeFactoryEntry {

		public final List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
		
		public final Map<String, List<TocNodeFactory>> componentTocNodeFactories = new HashMap<>();
		
	}
	
	private Map<String, Map<Version, BundleTocNodeFactoryEntry>> bundleTocNodeFactories = new HashMap<>();
	
	public Map<String, PackageTocNodeFactoryEntry> getPackageTocNodeFactories() {
		return packageTocNodeFactories;
	}
	
	//private MimetypesFileTypeMap mimeTypesMap;
	private boolean preProcessMarkdown = true;
	private BundleDocumentationGenerator bundleDocumentationGenerator;
	private ComponentDocumentationGenerator componentDocumentationGenerator;
	private IndexWriter searchIndexWriter;
	private ExecutorService searchIndexerExecutor;
	
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
	
	private interface Task {
		void execute() throws Exception;
	}
	
	private AtomicLong indexPassCounter = new AtomicLong();
	
	private void executeIndexWriterTask(Task task, long indexPass) {
		searchIndexerExecutor.submit(new Runnable() {

			@Override
			public void run() {
				// If deactivating or from the previous pass - don't waste time.
				if (!deactivating && indexPassCounter.get() == indexPass) {
					try {
						task.execute();
						// Might have been closed while the task was executing
						if (!deactivating) {
							searcherManager.maybeRefresh();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});
	}
	
	public BundleContext getBundleContext() {
		return bundleContext;
	}
		
	public void activate(ComponentContext context) throws Exception {
		Dictionary<String, Object> properties = context.getProperties();
		Object pathOffsetProp = properties.get("path-offset");
		if (pathOffsetProp instanceof Number) {
			pathOffset = ((Number) pathOffsetProp).intValue();
		}
		bundleContext = context.getBundleContext();
		
		Object preProcessMarkdownProperty = properties.get("pre-process-markdown");
		if (preProcessMarkdownProperty instanceof Boolean) {
			preProcessMarkdown = (Boolean) preProcessMarkdownProperty;
		}
		
		Object reloadDelayProperty = properties.get("reload-delay");
		if (reloadDelayProperty instanceof Number) {
			reloadDelay = ((Number) reloadDelayProperty).longValue();
		}
		
		Object sessionRegistry = properties.get("session-registry");
		if (sessionRegistry instanceof Boolean) {
			includeSessionRegistry = (Boolean) sessionRegistry;
		}
		
		Object packageRegistry = properties.get("global-registry");
		if (packageRegistry instanceof Boolean) {
			includeGlobalRegistry = (Boolean) packageRegistry;
		}
		
		Object bundleTocProp = properties.get("bundle-toc");
		if (bundleTocProp instanceof Boolean) {
			bundleToc = (Boolean) bundleTocProp;
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
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		searchIndexWriter = new IndexWriter(searchIndexDirectory, config);
		searcherManager = new SearcherManager(searchIndexWriter, true, true, new SearcherFactory());
		searchIndexerExecutor = Executors.newSingleThreadExecutor();
    	
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
    	
    	Object bundleContextDiagramDefaultIncludesProperty = properties.get("bundle-context-diagram-default-includes");
    	StringBuilder bundleContextDiagramDefaultIncludesBuilder = new StringBuilder();
    	if (bundleContextDiagramDefaultIncludesProperty instanceof String) {
    		bundleContextDiagramDefaultIncludesBuilder.append(bundleContextDiagramDefaultIncludesProperty);
    	} else if (bundleContextDiagramDefaultIncludesProperty instanceof String[]) {
    		for (String s: (String[]) bundleContextDiagramDefaultIncludesProperty) {
    			bundleContextDiagramDefaultIncludesBuilder.append(s).append(System.lineSeparator());
    		}
    	}
    	Object bundleContextDiagramDefaultExcludesProperty = properties.get("bundle-context-diagram-default-excludes");
    	StringBuilder bundleContextDiagramDefaultExcludesBuilder = new StringBuilder();
    	if (bundleContextDiagramDefaultExcludesProperty instanceof String) {
    		bundleContextDiagramDefaultExcludesBuilder.append(bundleContextDiagramDefaultExcludesProperty);
    	} else if (bundleContextDiagramDefaultExcludesProperty instanceof String[]) {
    		for (String s: (String[]) bundleContextDiagramDefaultExcludesProperty) {
    			bundleContextDiagramDefaultExcludesBuilder.append(s).append(System.lineSeparator());
    		}
    	}
    	
    	bundleDocumentationGenerator = new BundleDocumentationGenerator(
    			this, 
    			bundleContextDiagramDefaultIncludesBuilder.toString(), 
    			bundleContextDiagramDefaultExcludesBuilder.toString());
    	
    	componentDocumentationGenerator = new ComponentDocumentationGenerator(
    			this, 
    			bundleContextDiagramDefaultIncludesBuilder.toString(), 
    			bundleContextDiagramDefaultExcludesBuilder.toString());    			
    	
    	IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
    	extensionTracker = new ExtensionTracker(extensionRegistry);
    	
    	doLoad.set(true); // To prevent scheduling of delayed loading.
    	
    	// Tracking doc extensions
    	trackDocExtensions(extensionRegistry);
		
    	// Tracking TOC extensions
    	trackToc(extensionRegistry);
    	
    	// Tracking stories
    	trackStories(extensionRegistry);
    	
    	// Tracking test results
    	trackTestResults(extensionRegistry);
    	
		// Global package registry changes
		listenForGeneratedPackagesChange(extensionRegistry);		

		bundleContext.addBundleListener(this);		
    				
		loadTimer = new Timer();
		loadTimer.schedule(new LoadTask(), 500);		
	}

	private void listenForGeneratedPackagesChange(IExtensionRegistry extensionRegistry) {
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
		
		extensionTracker.registerHandler(generatedPackageExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(generatedPackageExtensionPoint));
	}

	private void trackToc(IExtensionRegistry extensionRegistry) {
		IExtensionPoint tocExtensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.toc");    	
    	IExtensionChangeHandler tocExtensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				switch (ce.getName()) {
    				case TOC:
						addTocExtension(tracker, extension, ce);
    					break;
    				case EPACKAGE_TOC:
						addEPackageTocExtension(tracker, extension, ce);
    					break;
    				case ECLASSIFIER_TOC:
						addEClassifierTocExtension(tracker, extension, ce);
    					break;
    				case BUNDLE_TOC:
						addBundleTocExtension(tracker, extension, ce);
    					break;
    				case COMPONENT_TOC:
						addComponentTocExtension(tracker, extension, ce);
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
						synchronized (packageTocNodeFactories) {
							for (PackageTocNodeFactoryEntry ptnf: packageTocNodeFactories.values()) {
								ptnf.tocNodeFactories.remove(obj);
								ptnf.classifierTocNodeFactories.remove(obj);
							}
						}
						synchronized (bundleTocNodeFactories) {
							for (Map<Version, BundleTocNodeFactoryEntry> vbtnfm: bundleTocNodeFactories.values()) {
								for (BundleTocNodeFactoryEntry btnf: vbtnfm.values()) {
									btnf.tocNodeFactories.remove(obj);
									btnf.componentTocNodeFactories.remove(obj);
								}
							}
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
	}
	
	private void trackTestResults(IExtensionRegistry extensionRegistry) {
		IExtensionPoint testResultsExtensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.webtest.model.results");    	
    	IExtensionChangeHandler testResultsExtensionChangeHandler = new IExtensionChangeHandler() {

			@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {    			
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
	    			String contributorName = ce.getContributor().getName();
	    			String location = ce.getAttribute("model");
					String modelLocation = contributorName+"/"+location;
					tracker.registerObject(extension, modelLocation, IExtensionTracker.REF_WEAK);
					synchronized (testResultsModels) {
						testResultsModels.add(modelLocation);
					}
    			}
    			
    			scheduleReloading();
			}
			
			@Override
			public void removeExtension(IExtension extension, Object[] objects) {
				if (objects!=null && objects.length > 0) {
					synchronized (testResultsModels) {
						for (Object obj: objects) {
							testResultsModels.remove(obj);
						}
					}
	    			scheduleReloading();
				}
			}
			
		};
		
		extensionTracker.registerHandler(testResultsExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(testResultsExtensionPoint));
		for (IExtension ex: testResultsExtensionPoint.getExtensions()) {
			testResultsExtensionChangeHandler.addExtension(extensionTracker, ex);
		}
	}
	
	private void trackStories(IExtensionRegistry extensionRegistry) {
		IExtensionPoint testResultsExtensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.story.model");    	
    	IExtensionChangeHandler testResultsExtensionChangeHandler = new IExtensionChangeHandler() {

			@Override
			public void addExtension(IExtensionTracker tracker, IExtension extension) {    			
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
	    			String contributorName = ce.getContributor().getName();
	    			String location = ce.getAttribute("model");
					String modelLocation = contributorName+"/"+location;
					tracker.registerObject(extension, modelLocation, IExtensionTracker.REF_WEAK);
					synchronized (storyModels) {
						storyModels.add(modelLocation);
					}
    			}
    			
    			scheduleReloading();
			}
			
			@Override
			public void removeExtension(IExtension extension, Object[] objects) {
				if (objects!=null && objects.length > 0) {
					synchronized (storyModels) {
						for (Object obj: objects) {
							storyModels.remove(obj);
						}
					}
	    			scheduleReloading();
				}
			}
			
		};
		
		extensionTracker.registerHandler(testResultsExtensionChangeHandler, ExtensionTracker.createExtensionPointFilter(testResultsExtensionPoint));
		for (IExtension ex: testResultsExtensionPoint.getExtensions()) {
			testResultsExtensionChangeHandler.addExtension(extensionTracker, ex);
		}
	}	

	private void trackDocExtensions(IExtensionRegistry extensionRegistry) {
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
    				case MARKDOWN_PRE_PROCESSOR:
    					try {
							ExtensionEntry<MarkdownPreProcessor> markdownPreProcessor = new ExtensionEntry<MarkdownPreProcessor>((MarkdownPreProcessor) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce);
							synchronized (preProcessors) {
								preProcessors.add(markdownPreProcessor);
							}
							tracker.registerObject(extension, markdownPreProcessor, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
							e.printStackTrace();
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
    				case EPACKAGE_DOCUMENTATION_GENERATOR:
    					try {
							EModelElementDocumentationGeneratorKey key = new EModelElementDocumentationGeneratorKey(ce);
							ePackageDocumentationGenerators.put(key, new ExtensionEntry<EModelElementDocumentationGenerator<EPackage>>((EModelElementDocumentationGenerator<EPackage>) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
							tracker.registerObject(extension, key, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
							e.printStackTrace();
						}
						break;
    				case ECLASS_DOCUMENTATION_GENERATOR:
    					try {
							EModelElementDocumentationGeneratorKey key = new EModelElementDocumentationGeneratorKey(ce);
							eClassDocumentationGenerators.put(key, new ExtensionEntry<EModelElementDocumentationGenerator<EClass>>((EModelElementDocumentationGenerator<EClass>) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
							tracker.registerObject(extension, key, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
							e.printStackTrace();
						}
						break;
    				case EDATATYPE_DOCUMENTATION_GENERATOR:
    					try {
							EModelElementDocumentationGeneratorKey key = new EModelElementDocumentationGeneratorKey(ce);
							eDataTypeDocumentationGenerators.put(key, new ExtensionEntry<EModelElementDocumentationGenerator<EDataType>>((EModelElementDocumentationGenerator<EDataType>) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
							tracker.registerObject(extension, key, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
							e.printStackTrace();
						}
						break;
    				case EENUM_DOCUMENTATION_GENERATOR:
    					try {
							EModelElementDocumentationGeneratorKey key = new EModelElementDocumentationGeneratorKey(ce);
							eEnumDocumentationGenerators.put(key, new ExtensionEntry<EModelElementDocumentationGenerator<EEnum>>((EModelElementDocumentationGenerator<EEnum>) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")), ce));
							tracker.registerObject(extension, key, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
							e.printStackTrace();
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
    				case MIME_TYPE: 
	    				String mimeType = ce.getAttribute("type");
	    				List<String> extensionsList = new ArrayList<>();
	    				for (IConfigurationElement ext: ce.getChildren("mime-type-extension")) {
	    					extensionsList.add(ext.getValue().trim());
	    				}
    					try {
							mimeTypeMap.put(mimeType, new ExtensionEntry<List<String>>(extensionsList, ce));
							tracker.registerObject(extension, MIME_TYPE+":"+mimeType, IExtensionTracker.REF_WEAK);
						} catch (Exception e) {
							// TODO - proper logging
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
					if (obj instanceof String) {
						if (((String) obj).startsWith(WIKI_LINK_RENDERER+":")) {
							wikiLinkRendererMap.remove(((String) obj).substring(WIKI_LINK_RENDERER.length()+1));
						} else if (((String) obj).startsWith(WIKI_LINK_RESOLVER+":")) {
							wikiLinkResolverMap.remove(((String) obj).substring(WIKI_LINK_RESOLVER.length()+1));
						} else if (((String) obj).startsWith(MIME_TYPE+":")) {
							mimeTypeMap.remove(((String) obj).substring(MIME_TYPE.length()+1));
						} else if (((String) obj).startsWith(EANNOTATION_RENDERER+":")) {
							eAnnotationRenderers.remove(((String) obj).substring(EANNOTATION_RENDERER.length()+1));
						} 						
					} else if (obj instanceof ExtensionEntry) {
						Object ext = ((ExtensionEntry<?>) obj).extension;
						if (ext instanceof MarkdownPreProcessor) {
							synchronized (preProcessors) {
								preProcessors.remove(obj);
							}
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
					} else if (obj instanceof EModelElementDocumentationGeneratorKey) {
						ExtensionEntry<EModelElementDocumentationGenerator<EPackage>> pExt = ePackageDocumentationGenerators.remove(obj);
						if (pExt!=null) {
							pExt.extension.close();
						}
						ExtensionEntry<EModelElementDocumentationGenerator<EClass>> cExt = eClassDocumentationGenerators.remove(obj);
						if (cExt!=null) {
							cExt.extension.close();
						}
						ExtensionEntry<EModelElementDocumentationGenerator<EDataType>> dtExt = eDataTypeDocumentationGenerators.remove(obj);
						if (dtExt!=null) {
							dtExt.extension.close();
						}
						ExtensionEntry<EModelElementDocumentationGenerator<EEnum>> eExt = eEnumDocumentationGenerators.remove(obj);
						if (eExt!=null) {
							eExt.extension.close();
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
	}
	
	public String getContentType(String filename) {
		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap(AbstractRoutingServlet.class.getResourceAsStream("mime.types"));
		for (Entry<String, ExtensionEntry<List<String>>> mtx: mimeTypeMap.entrySet()) {
			StringBuilder mteb = new StringBuilder(mtx.getKey());
			for (String ext: mtx.getValue().extension) {
				mteb.append(" ").append(ext);
			}
			mimeTypesMap.addMimeTypes(mteb.toString());			
		}
		return mimeTypesMap.getContentType(filename);
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
	
	// TODO - content provider extension?
	private StoryDocumentationGenerator storyDocumentationGenerator;
	private TestResultsDocumentationGenerator testResultsDocumentationGenerator;
	
	void scheduleReloading() {
		if (loadTimer!=null && !doLoad.getAndSet(true)) {
			loadTimer.schedule(new LoadTask(), reloadDelay);
		}
	}
	
	private class LoadTask extends TimerTask {
		
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
	
	public EClassifier getEClassifier(EClassifierKey key) {
		if (key==null) {
			return null;
		}
		EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(key.getNsURI());
		if (pkg==null) {
			return null;
		}
		return pkg.getEClassifier(key.getName());
	}
	
	public static final Comparator<Bundle> BUNDLE_COMPARATOR = new Comparator<Bundle>() {

		@Override
		public int compare(Bundle b1, Bundle b2) {
			if (b1 == b2) {
				return 0;
			}
			int cmp = b1.getSymbolicName().compareTo(b2.getSymbolicName());
			if (cmp!=0) {
				return cmp;
			}
			cmp = b1.getVersion().compareTo(b2.getVersion());					
			if (cmp!=0) {
				return cmp;
			}
			if (b1.getBundleId() > b2.getBundleId()) {
				return 1;
			}
			if (b1.getBundleId() < b2.getBundleId()) {
				return -1;
			}
			return 0;
		}
		
	};

	/**
	 * (Re)Builds TOC and index. 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void load() throws IOException {
		if (deactivating) {
			return;
		}
		lock.writeLock().lock();
		try {
			// Load stories & test results
			storyDocumentationGenerator = new StoryDocumentationGenerator(this, storyModels);
			testResultsDocumentationGenerator = new TestResultsDocumentationGenerator(this, testResultsModels);
			
			// TOC
			tocRoot = new TocNode(null, null, null, null, false);
			TocNode packagesToc = tocRoot.createChild("Packages", null, null, null, null, false);
			if (isGlobalRegistry()) {
				TocNode globalPackageRegistryToc = packagesToc.createChild(
						"Global", 
						null, 
						"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/database.png", 
						null, 
						null, 
						false);
				createPackageRegistryToc(EPackage.Registry.INSTANCE, globalPackageRegistryToc, "/packages/global");
			}
			
			if (isSessionRegistry()) {
				TocNode sessionPackageRegistryToc = packagesToc.createChild(
						"Session", 
						null, 
						"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/database_yellow.png", 
						null,
						null, 
						false);
				createPackageRegistryToc(cdoSessionProvider.getSession().getPackageRegistry(), sessionPackageRegistryToc, "/packages/session");				
			}
			
			// Bundles
			if (bundleToc) {
				TocNode bundlesToc = tocRoot.createChild("Bundles", BUNDLE_INFO_PATH+"summary.html", null, null, null, false);
				Bundle[] bundles = bundleContext.getBundles().clone();
				Arrays.sort(bundles, BUNDLE_COMPARATOR);
				final Map<String, Object> rootBucket = new TreeMap<String, Object>();
				for (Bundle bundle: bundles) {
					String[] bna = bundle.getSymbolicName().split("\\.");
					Map<String, Object> bucket = rootBucket;
					for (int i=0; i<bna.length; ++i) {
						if (i==bna.length-1) {
							bucket.put(bna[i], bundle);
						} else {
							Object entry = bucket.get(bna[i]);
							if (entry instanceof Bundle) {
								bucket.put(CoreUtil.join(bna, ".", i), bundle);
								break;
							}
							if (entry == null) {
								entry = new TreeMap<String, Object>();
								bucket.put(bna[i], entry);
							}
							bucket = (Map<String, Object>) entry;
						}
					}
				}
				createBundlesToc(rootBucket, bundlesToc);
			}
			
			storyDocumentationGenerator.createRootTocEntries(tocRoot);	
			testResultsDocumentationGenerator.createRootTocEntries(tocRoot);	
			
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
			
			long indexPass = indexPassCounter.incrementAndGet();
			
        	executeIndexWriterTask(()->searchIndexWriter.deleteAll(), indexPass);
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
						URI theBaseURI = new URI(baseURL);
						if (path.startsWith(PACKAGES_GLOBAL_PATH) || path.startsWith(PACKAGES_SESSION_PATH)) {
							// Always HTML String for packages if not null.
								final Object content = DocRoute.this.getContent(null, theBaseURI.resolve(DocRoute.this.docRoutePath+path), urlPrefix, path);
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
						String contentType = getContentType(fn);
						if (contentType!=null) {
							if (MIME_TYPE_HTML.equals(contentType)) {
								final String content = CoreUtil.stringify(DocRoute.this.getContent(null, theBaseURI.resolve(DocRoute.this.docRoutePath+path), urlPrefix, path));
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
								String content = CoreUtil.stringify(DocRoute.this.getContent(null, theBaseURI.resolve(DocRoute.this.docRoutePath+path), urlPrefix, path));
								if (content!=null) {
									final String htmlContent = String.valueOf(cf.filter(content, DocRoute.this, new URI(urlPrefix+docRoutePath+path), urlPrefix));
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
			final Indexer indexer = new Indexer(searchableContentProvider, searchIndexWriter, baseURL) {
				
				private String prefix = "http://localhost:18080"+docAppPath+ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath+"/";
				
				@Override
				protected boolean isInternalLink(String href) {
					return href.startsWith(prefix);
				}
				
				@Override
				protected String internalLinkPath(String href) {
					return href.substring(prefix.length()-1);
				}
				
			};
			
			int[] indexTasksCounter = {0};
			tocRoot.accept(new TocNodeVisitor() {
				
				@Override
				public void visit(TocNode tocNode) {
					if (tocNode.getHref()!=null) {						
						executeIndexWriterTask(()->indexer.index(tocNode.getHref()), indexPass);
						++indexTasksCounter[0];
					}						
				}
				
			});
			
	        System.out.println("Submitted "+indexTasksCounter[0]+" indexing tasks");			

			// Terminator task
	        executeIndexWriterTask(new Task() {
				
				@Override
				public void execute() throws Exception {
					DocRoute.this.linkMap = indexer.getLinkMap();
					DocRoute.this.missingPaths = indexer.getMissingPaths();		
			        System.out.println("[Pass "+indexPass+"] Indexed "+searchIndexWriter.numDocs()+" pages");
					if (!missingPaths.isEmpty()) {
						System.out.println("Missing paths:");
						for (String mp: missingPaths) {
							System.out.println("\t"+mp);
						}
					}
				}
			}, indexPass);
			
		} finally {
			lock.writeLock().unlock();
		}
	}

	@SuppressWarnings("unchecked")
	private void createBundlesToc(Map<String, Object> bucket, TocNode parentToc) {
		for (Entry<String, Object> e: bucket.entrySet()) {
			String localName = e.getKey();
			if (e.getValue() instanceof Bundle) {
				Bundle bundle = (Bundle) e.getValue();
				TocNode bundleToc = parentToc.createChild(
						localName+" ("+bundle.getVersion()+")", 
						BUNDLE_INFO_PATH+bundle.getBundleId()+"/index.html", 
						"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/box_closed.png", 
						null,
						obj->obj instanceof Bundle && ((Bundle) obj).getSymbolicName().equals(bundle.getSymbolicName()) && ((Bundle) obj).getVersion().equals(bundle.getVersion()), 
						false);
				
				if (scrService != null) {
					Component[] components = scrService.getComponents(bundle);
					if (components != null) {
						Map<String, Component> componentMap = new TreeMap<>();
						for (Component component: components) {
							componentMap.put(component.getName(), component);
						}
						for (Component component: componentMap.values()) {
							TocNode componentToc = bundleToc.createChild(
									component.getName(), 
									COMPONENT_INFO_PATH+component.getId()+"/index.html", 
									"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/cog.png", 
									null,
									obj->obj instanceof Component && ((Component) obj).getId() == component.getId(), 
									false);

							synchronized (bundleTocNodeFactories) {
								BundleTocNodeFactoryEntry be = matchVersion(bundle);
								if (be!=null) {
									List<TocNodeFactory> ctnfl = be.componentTocNodeFactories.get(component.getName());
									if (ctnfl!=null) {
										for (TocNodeFactory tnf: ctnfl) {
											if (!tnf.isSection() && !tnf.isElementDoc() && tnf.isRoot(be.tocNodeFactories)) {
												tnf.createTocNode(componentToc, be.tocNodeFactories, false);
											}
										}
									}
								}
							}						
						}
					}
				}
				
				synchronized (bundleTocNodeFactories) {
					BundleTocNodeFactoryEntry be = matchVersion(bundle);
					if (be!=null) {
						for (TocNodeFactory tnf: be.tocNodeFactories) {
							if (!tnf.isSection() && !tnf.isElementDoc() && tnf.isRoot(be.tocNodeFactories)) {
								tnf.createTocNode(bundleToc, be.tocNodeFactories, false);
							}
						}
					}
				}						
			} else {				
				Map<String, Object> subBucket = (Map<String, Object>) e.getValue();
				if (subBucket.size()==1) {
					if (!singlePath(subBucket, parentToc, localName)) {
						createBundlesToc(subBucket, parentToc.createChild(localName, null, null, null, null, false));						
					}
				} else {
					createBundlesToc(subBucket, parentToc.createChild(localName, null, null, null, null, false));						
				}
			}
		}		
	}

	/**
	 * Find a TOC with a version lower than the bundle version.
	 * If none is found, return the lowest version.
	 * @param bundle
	 * @return
	 */
	private BundleTocNodeFactoryEntry matchVersion(Bundle bundle) {
		Map<Version, BundleTocNodeFactoryEntry> vbm = bundleTocNodeFactories.get(bundle.getSymbolicName());
		if (vbm!=null) {
			List<Version> versions = new ArrayList<>(vbm.keySet());
			Collections.reverse(versions);
			for (Version version: versions) {
				if (version.compareTo(bundle.getVersion()) <= 0) {
					return vbm.get(version);
				}
			}
			if (!vbm.isEmpty()) {
				return vbm.values().iterator().next(); // Lowest version 
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private boolean singlePath(Map<String, Object> bucket, TocNode parentToc, String path) {
		if (bucket.size()==1) {
			for (Entry<String, Object> e: bucket.entrySet()) {
				String localName = e.getKey();
				if (e.getValue() instanceof Bundle) {
					Bundle bundle = (Bundle) e.getValue();
					TocNode bundleToc = parentToc.createChild(
							path+"."+localName+" "+bundle.getVersion(), 
							BUNDLE_INFO_PATH+bundle.getBundleId()+"/index.html", 
							"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/box_closed.png", 
							null,
							obj->obj instanceof Bundle && ((Bundle) obj).getSymbolicName().equals(bundle.getSymbolicName()) && ((Bundle) obj).getVersion().equals(bundle.getVersion()), 
							false);
					
					if (scrService != null) {
						Component[] components = scrService.getComponents(bundle);
						if (components != null) {
							Map<String, Component> componentMap = new TreeMap<>();
							for (Component component: components) {
								componentMap.put(component.getName(), component);
							}
							for (Component component: componentMap.values()) {
								bundleToc.createChild(
										component.getName(), 
										COMPONENT_INFO_PATH+component.getId()+"/index.html", 
										"/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/cog.png", 
										null,
										obj->obj instanceof Component && ((Component) obj).getId() == component.getId(), 
										false);
							}
						}
					}
					return true;
				}
				return singlePath((Map<String, Object>) e.getValue(), parentToc, path+"."+localName);
			}
		}
		return false;
	}

	public boolean isSessionRegistry() {
		return includeSessionRegistry && cdoSessionProvider!=null;
	}

	public boolean isGlobalRegistry() {
		return includeGlobalRegistry==null ? cdoSessionProvider==null : includeGlobalRegistry;
	}
	
	private boolean hasDuplicateName(EPackage ePackage, Collection<EPackage> ePackages) {
		for (EPackage otherPackage: ePackages) {
			if (otherPackage != ePackage && otherPackage.getName().equals(ePackage.getName())) {
				return true;
			}
		}
		return false;
	}
	
	private void createPackageRegistryToc(Registry registry, TocNode owner, String prefix) {
		List<EPackage> packages = new ArrayList<>();
		for (String nsURI: registry.keySet()) {			
			EPackage ePackage = registry.getEPackage(nsURI);
			if (ePackage!=null) {
				EPackage sp = ePackage.getESuperPackage();
				if (sp == null || registry.getEPackage(sp.getNsURI()) == null) {
					packages.add(ePackage);
				}
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
			createEPackageToc(owner, ePackage, prefix, hasDuplicateName(ePackage, packages));
		}
	}
		
	private void createEPackageToc(TocNode parent, EPackage ePackage, String prefix, boolean hasDuplicateName) {
		TocNode ePackageToc = parent.createChild(
				ePackage.getName() + (hasDuplicateName ? " ("+StringEscapeUtils.escapeHtml4(ePackage.getNsURI())+")" : ""), 
				prefix+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */))+"/"+PACKAGE_SUMMARY_HTML, 
				"/resources/images/EPackage.gif", 
				null,
				obj->obj instanceof EPackage && ((EPackage) obj).getNsURI().equals(ePackage.getNsURI()), 
				false);
		List<EPackage> subPackages = new ArrayList<>(ePackage.getESubpackages());
		Collections.sort(subPackages, new Comparator<EPackage>() {

			@Override
			public int compare(EPackage o1, EPackage o2) {
				return o1.getName().equals(o2.getName()) ? o1.getNsURI().compareTo(o2.getNsURI()) : o1.getName().compareTo(o2.getName());
			}
			
		});
		
		for (EPackage subPackage: subPackages) {
			createEPackageToc(ePackageToc, subPackage, prefix, hasDuplicateName(subPackage, subPackages));
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
		Predicate<Object> predicate = obj->obj instanceof EClassifier && ((EClassifier) obj).getName().equals(eClassifier.getName()) && ((EClassifier) obj).getEPackage().getNsURI().equals(eClassifier.getEPackage().getNsURI());
		if (eClassifier instanceof EClass) {
			cToc = parent.createChild(
					eClassifier.getName(), 
					href, 
					"/resources/images/EClass.gif", 
					null,
					predicate, 
					false);
			
			EClassifierKey subTypeKey = new EClassifierKey((EClass) eClassifier);
			for (EClass sc: ((EClass) eClassifier).getESuperTypes()) {
				EClassifierKey superTypeKey = new EClassifierKey(sc);
				Set<EClassifierKey> subTypes = inheritanceMap.get(superTypeKey);
				if (subTypes==null) {
					subTypes = new TreeSet<>();
					inheritanceMap.put(superTypeKey, subTypes);
				}
				subTypes.add(subTypeKey);
			}
			
			storyDocumentationGenerator.createEClassTocEntries((EClass) eClassifier, cToc);
		} else if (eClassifier instanceof EEnum) {
			cToc = parent.createChild(
					eClassifier.getName(), 
					href, 
					"/resources/images/EEnum.gif", 
					null,
					predicate, 
					false);
		} else {
			cToc = parent.createChild(
					eClassifier.getName(), 
					href, 
					"/resources/images/EDataType.gif", 
					null,
					predicate, 
					false);
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
	
	@Override
	public Object getContent(HttpServletRequestContext context, URI baseURI, String urlPrefix, String path) {
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
				return getEPackageContent(baseURI, urlPrefix, ePackage, docRoutePath+"/packages/global");
			}
			EClassifier eClassifier = ePackage.getEClassifier(subPath[1]);
			return eClassifier==null ? null : getEClassifierContent(baseURI, urlPrefix, eClassifier, docRoutePath+"/packages/global");
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
				return getEPackageContent(baseURI, urlPrefix, ePackage, docRoutePath+"/packages/session");
			}
			EClassifier eClassifier = ePackage.getEClassifier(subPath[1]);
			return eClassifier==null ? null : getEClassifierContent(baseURI, urlPrefix, eClassifier, docRoutePath+"/packages/global");				
		} 
		
		if (path.startsWith(BUNDLE_PATH)) {
			int idx = path.indexOf("/", BUNDLE_PATH.length());
			if (idx==-1) {
				return null;
			}
			String bundleId = path.substring(BUNDLE_PATH.length(), idx);
			
			// A hack to document extensions, need a better way in the future
			if ("org.nasdanika.cdo.web.doc".equals(bundleId) && "extensions.html".equals(path.substring(idx+1))) {
				return generateExtensionsDocumentation(baseURI, urlPrefix, path);
			}			
			
			for (Bundle targetBundle: bundleContext.getBundles()) {
				if (bundleId.equals(targetBundle.getSymbolicName())) {
					return targetBundle.getEntry(path.substring(idx+1));
				}
			}
			return null;
		} 
		
		if (path.startsWith(RESOURCES_PATH)) {
			return getResource(getClass(), path.substring(RESOURCES_PATH.length()));
		}
		
		if (path.startsWith(BUNDLE_INFO_PATH)) {
			String tail = path.substring(BUNDLE_INFO_PATH.length());
			if ("summary.html".equals(tail)) {
				return bundleDocumentationGenerator.generateBundlesSummary();
			}
			
			if (DIAGRAM_PNG.equals(tail)) {
				return bundleDocumentationGenerator.generateBundlesDiagram(context);
			}			
			
			String[] ta = tail.split("/");
			if (ta.length != 2) {
				return null;
			}
			Bundle bundle = bundleContext.getBundle(Long.parseLong(ta[0]));
			if (bundle != null) {
				if (INDEX_HTML.equals(ta[1])) {
					return bundleDocumentationGenerator.generateBundleInfo(bundle);
				}
				
				if (DIAGRAM_PNG.equals(ta[1])) {
					return bundleDocumentationGenerator.generateBundleContextDiagram(context, bundle);
				}
				
				return null;
			}
			return null;
		}
						
		if (path.startsWith(COMPONENT_INFO_PATH)) {
			String tail = path.substring(COMPONENT_INFO_PATH.length());
			
			String[] ta = tail.split("/");
			if (ta.length != 2 || scrService == null) {
				return null;
			}
			Component component = scrService.getComponent(Long.parseLong(ta[0]));
			if (component != null) {
				if (INDEX_HTML.equals(ta[1])) {
					return componentDocumentationGenerator.generateComponentInfo(component);
				}
				
				if (DIAGRAM_PNG.equals(ta[1])) {
					return componentDocumentationGenerator.generateComponentContextDiagram(context, component);
				}
				
				return null;
			}
			return null;
		}
		
		if (path.startsWith(STORY_PATH)) {
			return storyDocumentationGenerator.getContent(context, baseURI, urlPrefix, path);
		}		
		
		if (path.startsWith(TEST_RESULTS_PATH)) {
			return testResultsDocumentationGenerator.getContent(context, baseURI, urlPrefix, path);
		}				
		
		// TODO - diagrams - package/classifier - session/global. Delegate to extensions. 
		
		// TODO - extensions
		
		return null; // Not found
	}
		
	// Not thread-safe - there is a chance of concurrent modification exception if documentation is rendered when a new generator gets registered/unregistered.
	private Map<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EClass>>> eClassDocumentationGenerators = new TreeMap<>();	
	private Map<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EPackage>>> ePackageDocumentationGenerators = new TreeMap<>();	
	private Map<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EDataType>>> eDataTypeDocumentationGenerators = new TreeMap<>();	
	private Map<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EEnum>>> eEnumDocumentationGenerators = new TreeMap<>();	
	
	private static class EClassInheritanceElement implements Comparable<EClassInheritanceElement> {
		
		private EClass eClass;
		private int distance;
		private int depth;


		public EClassInheritanceElement(EClass eClass, int distance, int depth) {
			this.eClass = eClass;
			this.distance = distance;
			this.depth = depth;
		}
		

		@Override
		public int compareTo(EClassInheritanceElement o) {
			if (o.depth == depth) {
				return distance - o.distance;
			}
			return depth - o.depth;
		}
		
	}
	
	private Collection<EClassInheritanceElement> traverseEClassHierarchy(EClass eClass, int distance, int depth, Collection<EClassInheritanceElement> collector) {
		collector.add(new EClassInheritanceElement(eClass, distance, depth));
		int scDistance = 0;
		for (EClass sc: eClass.getESuperTypes()) {
			traverseEClassHierarchy(sc, scDistance++, depth+1, collector);
		}
		return collector;
	}
	
	private Object getEClassifierContent(URI baseURI, String urlPrefix, EClassifier eClassifier, String registryPath) {
		if (eClassifier instanceof EClass) {
			for (EClassInheritanceElement cie: traverseEClassHierarchy((EClass) eClassifier, 0, 0, new TreeSet<EClassInheritanceElement>())) {
				for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EClass>>> e: eClassDocumentationGenerators.entrySet()) {
					if (e.getKey().match(cie.eClass)) {
						return e.getValue().extension.generate(this, baseURI, urlPrefix, registryPath, (EClass) eClassifier);						
					}
				}
			}
			
			return "No matching generator";
		} 
		
		if (eClassifier instanceof EEnum) {
			for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EEnum>>> e: eEnumDocumentationGenerators.entrySet()) {
				if (e.getKey().match(eClassifier)) {
					return e.getValue().extension.generate(this, baseURI, urlPrefix, registryPath, (EEnum) eClassifier);						
				}
			}
			return "No matching generator";
		}
		
		for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EDataType>>> e: eDataTypeDocumentationGenerators.entrySet()) {
			if (e.getKey().match(eClassifier)) {
				return e.getValue().extension.generate(this, baseURI, urlPrefix, registryPath, (EDataType) eClassifier);						
			}
		}
		return "No matching generator";
	}

	private Object getEPackageContent(URI baseURI, String urlPrefix, EPackage ePackage, String registryPath) {
		for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EPackage>>> e: ePackageDocumentationGenerators.entrySet()) {
			if (e.getKey().match(ePackage)) {
				return e.getValue().extension.generate(this, baseURI, urlPrefix, registryPath, ePackage);						
			}
		}
		return "No matching generator";
	}
	
	volatile boolean deactivating;
	
	public void deactivate(ComponentContext context) throws Exception {
		deactivating = true;
		bundleContext.removeBundleListener(this);
		
		if (loadTimer!=null) {
			loadTimer.cancel();
			loadTimer = null;
		}
	
		lock.writeLock().lock();
		try {
			if (searchIndexerExecutor != null) {
				searchIndexerExecutor.shutdown();
			}
			if (searcherManager!=null) {
				searcherManager.close();
			}
			if (searchIndexWriter!=null) {
				searchIndexWriter.close();
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
		} finally {
			lock.writeLock().unlock();
		}
		
		if (storyDocumentationGenerator != null) {
			storyDocumentationGenerator.close();
		}
		
		if (testResultsDocumentationGenerator != null) {
			testResultsDocumentationGenerator.close();
		}
		
	}
	
	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		boolean doNavWrap = !"no".equals(context.getRequest().getParameter("navWrap"));
		String[] path = new String[context.getPath().length-pathOffset];
		System.arraycopy(context.getPath(), pathOffset, path, 0, path.length);
		if (RequestMethod.GET.equals(context.getMethod())) {
			if (path.length==1) {
				if ("toc.js".equals(path[0])) {
					if (lock.readLock().tryLock(30, TimeUnit.SECONDS)) {
						try {
							final String hrefPrefix = ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath; 
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
						} finally {
							lock.readLock().unlock();
						}
					} else {
						System.out.println("Could not perform action due to toc being rebuilt");
						return Action.INTERNAL_SERVER_ERROR; // TODO - better info if reloading takes too long
					}
				} else if ("search".equals(path[0])) {
			        QueryParser parser = new QueryParser("text", analyzer);
			        Query query = parser.parse(context.getRequest().getParameter("query"));
			        IndexSearcher indexSearcher = searcherManager.acquire();
			        try {
						ScoreDoc[] scoreDocs = indexSearcher.search(query, 150).scoreDocs;
						JSONArray searchResults = new JSONArray();
				        for (ScoreDoc scoreDoc: scoreDocs) {
							Document hitDoc = indexSearcher.doc(scoreDoc.doc);
							JSONObject searchResult = new JSONObject();
							searchResults.put(searchResult);
							String hitPath = hitDoc.get("path");
							searchResult.put("href", ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath+hitPath);
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
			        } finally {
			        	searcherManager.release(indexSearcher);
			        }
				}				
				return Action.NOT_FOUND;
			} 
									
			String requestURL = context.getRequest().getRequestURL().toString();
			String requestURI = context.getRequest().getRequestURI();
			String urlPrefix = requestURL.endsWith(requestURI) ? requestURL.substring(0, requestURL.length()-requestURI.length()) : null;
			String prefix = docAppPath+ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath;			
			String pathStr = "/"+StringUtils.join(path, "/");
			Object content = getContent(context, new URI(requestURL), urlPrefix, pathStr);
			// Sub-routes
			if (content instanceof Action) {
				return (Action) content;
			}
			if (content!=null) {
				if (path.length>0) {
					String contentType = "packages".equals(path[0]) ? MIME_TYPE_HTML : getContentType(path[path.length-1]);
					if (contentType!=null) {
						Map<String, ExtensionEntry<ContentFilter>> tm = contentFilters.get(contentType);
						if (tm!=null) {
							for (Entry<String, ExtensionEntry<ContentFilter>> tme: tm.entrySet()) {
								context.getResponse().setContentType(tme.getKey());
								Object filteredContent = tme.getValue().extension.filter(content, this, new URI(requestURL), urlPrefix);
								if (MIME_TYPE_HTML.equals(tme.getKey()) && filteredContent instanceof String) {
									TocNode toc = tocRoot.find(pathStr);
									if (doNavWrap && toc!=null) {
										filteredContent = navWrap(context.adapt(HTMLFactory.class), toc, (String) filteredContent, prefix);
									}
								}
								return new ValueAction(filteredContent);
							}
						}
					}
					if (MIME_TYPE_HTML.equals(contentType) && content instanceof String) {
						TocNode toc = tocRoot.find(pathStr);
						if (doNavWrap && toc!=null) {
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
				return new ValueAction(doNavWrap ? navWrap(context.adapt(HTMLFactory.class), toc, fragment.toString(), prefix) : fragment.toString());
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
			URL res = docBundle.getEntry(resourcePath);
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
	
	public String generateExtensionsDocumentation(URI baseURI, String urlPrefix, String path) {		
		try {
			Tabs ret = htmlFactory.tabs();
			PegDownProcessor pegDownProcessor = new PegDownProcessor(MARKDOWN_OPTIONS);
			LinkRenderer mlr = createMarkdownLinkRenderer(baseURI.resolve(path), urlPrefix);
			synchronized (preProcessors) {
				if (!preProcessors.isEmpty()) {
					Table pluginTable = htmlFactory.table().bordered();
					Row hRow = pluginTable.row().style(Bootstrap.Style.INFO);
					hRow.header("Type");
					hRow.header("Description");
					hRow.header("Configuration");
					for (ExtensionEntry<MarkdownPreProcessor> extensionEntry: preProcessors) {
						Row rRow = pluginTable.row();
						rRow.cell(extensionEntry.extension.getClass().getName());					
						rRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
						if (extensionEntry.extension instanceof ConfigurableExtension) {
							rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
						} else {
							rRow.cell("");
						}
					}
					ret.item("Pre-processors", pluginTable);
				}
			}
			if (!wikiLinkResolverMap.isEmpty()) {
				Table resolverTable = htmlFactory.table().bordered();
				Row hRow = resolverTable.row().style(Bootstrap.Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(wikiLinkResolverMap.keySet())) {
					Row rRow = resolverTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<WikiLinkResolver> extensionEntry = wikiLinkResolverMap.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
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
				Row hRow = rendererTable.row().style(Bootstrap.Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(wikiLinkRendererMap.keySet())) {
					Row rRow = rendererTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<Renderer> extensionEntry = wikiLinkRendererMap.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Wiki Link Renderers", rendererTable);				
			}
			if (!mimeTypeMap.isEmpty()) {
				Table mimeTypesTable = htmlFactory.table().bordered();
				Row hRow = mimeTypesTable.row().style(Bootstrap.Style.INFO);
				hRow.header("Type");
				hRow.header("Extensions");
				hRow.header("Description");
				for (String mimeType: new TreeSet<String>(mimeTypeMap.keySet())) {
					Row typeRow = mimeTypesTable.row();
					ExtensionEntry<List<String>> extensionEntry = mimeTypeMap.get(mimeType);
					typeRow.cell(StringEscapeUtils.escapeHtml4(mimeType)).rowspan(extensionEntry.extension.size());
					boolean isFirst = true;
					for (String extension: new TreeSet<String>(extensionEntry.extension)) {
						if (!isFirst) {
							typeRow = mimeTypesTable.row();
						}
						typeRow.cell(extension);
						if (isFirst) {
							typeRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
						}
						isFirst = false;
					}
				}
				ret.item("MIME Types", mimeTypesTable);				
			}
			if (!contentFilters.isEmpty()) {
				Table contentFiltersTable = htmlFactory.table().bordered();
				Row hRow = contentFiltersTable.row().style(Bootstrap.Style.INFO);
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
						filterRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
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
				Row hRow = rendererTable.row().style(Bootstrap.Style.INFO);
				hRow.header("Name");
				hRow.header("Description");
				hRow.header("Configuration");
				for (String rName: new TreeSet<String>(eAnnotationRenderers.keySet())) {
					Row rRow = rendererTable.row();
					rRow.cell(StringEscapeUtils.escapeHtml4(rName));					
					ExtensionEntry<EAnnotationRenderer> extensionEntry = eAnnotationRenderers.get(rName);
					rRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(extensionEntry.description, baseURI, urlPrefix), mlr));
					if (extensionEntry.extension instanceof ConfigurableExtension) {
						rRow.cell(((ConfigurableExtension) extensionEntry.extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						rRow.cell("");
					}
				}
				ret.item("Annotation Renderers", rendererTable);				
			}
			
			Fragment modelGeneratorsFragment = htmlFactory.fragment();
			if (!ePackageDocumentationGenerators.isEmpty()) {
				modelGeneratorsFragment.content(htmlFactory.tag(TagName.h3, "EPackage"));
				
				Table pTable = htmlFactory.table().bordered();
				Row hRow = pTable.row().style(Bootstrap.Style.INFO);
				hRow.header("NsURI");
				hRow.header("Priority");
				hRow.header("Class");
				hRow.header("Description");
				hRow.header("Configuration");
				
				for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EPackage>>> pe: ePackageDocumentationGenerators.entrySet()) {
					Row pRow = pTable.row();
					pRow.cell(StringEscapeUtils.escapeHtml4(pe.getKey().nsURI));					
					pRow.cell(pe.getKey().priority).style().text().align().center();
					pRow.cell(pegDownProcessor.markdownToHtml("[[javadoc>"+pe.getValue().extension.getClass().getName()+"|"+pe.getValue().extension.getClass().getName()+"]]", mlr));					
					pRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(pe.getValue().description, baseURI, urlPrefix), mlr));
					if (pe.getValue().extension instanceof ConfigurableExtension) {
						pRow.cell(((ConfigurableExtension) pe.getValue().extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						pRow.cell("");
					}					
				}
				
				modelGeneratorsFragment.content(pTable);
			}
			
			if (!eClassDocumentationGenerators.isEmpty()) {
				modelGeneratorsFragment.content(htmlFactory.tag(TagName.h3, "EClass"));
				
				Table pTable = htmlFactory.table().bordered();
				Row hRow = pTable.row().style(Bootstrap.Style.INFO);
				hRow.header("NsURI");
				hRow.header("Name");
				hRow.header("Priority");
				hRow.header("Class");
				hRow.header("Description");
				hRow.header("Configuration");
				
				for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EClass>>> ce: eClassDocumentationGenerators.entrySet()) {
					Row pRow = pTable.row();
					pRow.cell(StringEscapeUtils.escapeHtml4(ce.getKey().nsURI));					
					pRow.cell(StringEscapeUtils.escapeHtml4(ce.getKey().name));					
					pRow.cell(ce.getKey().priority).style().text().align().center();
					pRow.cell(pegDownProcessor.markdownToHtml("[[javadoc>"+ce.getValue().extension.getClass().getName()+"|"+ce.getValue().extension.getClass().getName()+"]]", mlr));					
					pRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(ce.getValue().description, baseURI, urlPrefix), mlr));
					if (ce.getValue().extension instanceof ConfigurableExtension) {
						pRow.cell(((ConfigurableExtension) ce.getValue().extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						pRow.cell("");
					}					
				}
				
				modelGeneratorsFragment.content(pTable);
			}

			if (!eEnumDocumentationGenerators.isEmpty()) {
				modelGeneratorsFragment.content(htmlFactory.tag(TagName.h3, "EEnum"));
				
				Table pTable = htmlFactory.table().bordered();
				Row hRow = pTable.row().style(Bootstrap.Style.INFO);
				hRow.header("NsURI");
				hRow.header("Name");
				hRow.header("Priority");
				hRow.header("Class");
				hRow.header("Description");
				hRow.header("Configuration");
				
				for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EEnum>>> ee: eEnumDocumentationGenerators.entrySet()) {
					Row pRow = pTable.row();
					pRow.cell(StringEscapeUtils.escapeHtml4(ee.getKey().nsURI));					
					pRow.cell(StringEscapeUtils.escapeHtml4(ee.getKey().name));					
					pRow.cell(ee.getKey().priority).style().text().align().center();
					pRow.cell(pegDownProcessor.markdownToHtml("[[javadoc>"+ee.getValue().extension.getClass().getName()+"|"+ee.getValue().extension.getClass().getName()+"]]", mlr));					
					pRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(ee.getValue().description, baseURI, urlPrefix), mlr));
					if (ee.getValue().extension instanceof ConfigurableExtension) {
						pRow.cell(((ConfigurableExtension) ee.getValue().extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						pRow.cell("");
					}					
				}
				
				modelGeneratorsFragment.content(pTable);
			}
			
			if (!eDataTypeDocumentationGenerators.isEmpty()) {
				modelGeneratorsFragment.content(htmlFactory.tag(TagName.h3, "EDataType"));
				
				Table pTable = htmlFactory.table().bordered();
				Row hRow = pTable.row().style(Bootstrap.Style.INFO);
				hRow.header("NsURI");
				hRow.header("Name");
				hRow.header("Priority");
				hRow.header("Class");
				hRow.header("Description");
				hRow.header("Configuration");
				
				for (Entry<EModelElementDocumentationGeneratorKey, ExtensionEntry<EModelElementDocumentationGenerator<EDataType>>> dte: eDataTypeDocumentationGenerators.entrySet()) {
					Row pRow = pTable.row();
					pRow.cell(StringEscapeUtils.escapeHtml4(dte.getKey().nsURI));					
					pRow.cell(StringEscapeUtils.escapeHtml4(dte.getKey().name));					
					pRow.cell(dte.getKey().priority).style().text().align().center();
					pRow.cell(pegDownProcessor.markdownToHtml("[[javadoc>"+dte.getValue().extension.getClass().getName()+"|"+dte.getValue().extension.getClass().getName()+"]]", mlr));					
					pRow.cell(pegDownProcessor.markdownToHtml(preProcessMarkdown(dte.getValue().description, baseURI, urlPrefix), mlr));
					if (dte.getValue().extension instanceof ConfigurableExtension) {
						pRow.cell(((ConfigurableExtension) dte.getValue().extension).generateConfigurationDocumentation(htmlFactory));
					} else {
						pRow.cell("");
					}					
				}
				
				modelGeneratorsFragment.content(pTable);
			}
			
			
//			if (!eClassDocumentationGenerators.isEmpty() || !ePackageDocumentationGenerators.isEmpty() || !eEnumDocumentationGenerators.isEmpty() || !eDataTypeDocumentationGenerators.isEmpty()) {


			if (!modelGeneratorsFragment.isEmpty()) {
				ret.item("ECore Documentation Generators", modelGeneratorsFragment);
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
					bcContent = htmlFactory.tag(TagName.img).attribute("src", getDocRoutePath()+pathElement.getIcon()).style().margin().right("3px") + pathElement.getText();
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
		String prefix = ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath;
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
	
	public LinkRenderer createMarkdownLinkRenderer(final URI baseURI, final String urlPrefix) {
		Renderer.Registry rendererRegistry = new Renderer.Registry() {

			@Override
			public Renderer getRenderer(String name) {
				ExtensionEntry<Renderer> extensionEntry = wikiLinkRendererMap.get(name);
				return extensionEntry==null ? null : extensionEntry.extension;
			}
			
		};
		
		final String absDocRoutePath = urlPrefix+docRoutePath;	
		final Map<Object, Object> env = new HashMap<>();
		String baseURLStr = baseURI.toString();
		if (baseURLStr.startsWith(absDocRoutePath)) {
			String relPath = baseURLStr.substring(absDocRoutePath.length());
			for (TocNode toc = tocRoot==null ? null : tocRoot.find(relPath); toc!=null; toc = toc.getParent()) {
				if (toc.getHref()!=null && toc.getHref().startsWith(PACKAGES_PATH)) {
					env.put(CONTEXT_MODEL_ELEMENT_PATH_KEY, docRoutePath+toc.getHref());
					break;
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
			public LinkInfo getLinkInfo(String location) {
				String absURL = baseURI.resolve(location).toString();
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
							return CoreUtil.isBlank(toc.getIcon()) ? "" : htmlFactory.tag(TagName.img).attribute("src", docRoutePath+toc.getIcon()).style().margin().right("1px").style("vertical-align", "text-top").toString();
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
				return null;
			}
		};
		
		URLRewriter urlRewriter = new URLRewriter() {
			
			@Override
			public String rewrite(String spec) {
				URI uri = baseURI.resolve(spec);
				String ret = uri.toString();
				if (ret.startsWith(urlPrefix)) {
					String relURL = ret.substring(urlPrefix.length());
					if (relURL.startsWith(docRoutePath)) {
						if (relURL.startsWith(docRoutePath+"/packages/") || relURL.startsWith(docRoutePath+"/toc/")) {
							return tocLink(ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+relURL);								
						}
						int idx = relURL.lastIndexOf('/');
						String fn = idx==-1 ? relURL : relURL.substring(idx+1);
						String contentType = getContentType(fn);
						if (contentType!=null) {
							if (!MIME_TYPE_HTML.equals(contentType)) {
								Map<String, ExtensionEntry<ContentFilter>> tm = contentFilters.get(contentType);
								if (tm!=null && tm.containsKey(MIME_TYPE_HTML)) {
									contentType = MIME_TYPE_HTML;
								}
							}
							if (MIME_TYPE_HTML.equals(contentType)) {
								return tocLink(ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+relURL);
							}
						}
					}
				}
				return ret;
			}
		};
		
		return new MarkdownLinkRenderer(baseURI, rendererRegistry, resolverRegistry, linkRegistry, urlRewriter);				
	}
	
	/**
	 * Converts content from one type to another using registered content filters.
	 * @param content
	 * @param sourceContentType
	 * @param targetContentType
	 * @return
	 * @throws Exception 
	 */
	public Object filterContent(
			Object content, 
			String sourceContentType, 
			String targetContentType,
			URI baseURI,
			String urlPrefix) throws Exception {
		if (sourceContentType.equals(targetContentType)) {
			return content;
		}
		Map<String, ExtensionEntry<ContentFilter>> cfe = contentFilters.get(sourceContentType);
		if (cfe == null) {
			return null;
		}
		ExtensionEntry<ContentFilter> cf = cfe.get(targetContentType);
		if (cf == null) {
			return null;
		}
		return cf.extension.filter(content, this, baseURI, urlPrefix);
	}
	
	/**
	 * Iterates over registered {@link MarkdownPreProcessor}s. Invokes <code>match</code> for each pre-processor.
	 * Selects the matching preprocessor with the earliest match region and invokes its pre-process method. If pre-processor
	 * returns null, goes to the next pre-processor in the list. Otherwise continues with pre-processors which matched regions
	 * after the first pre-processor region. 
	 * @param content
	 * @param path
	 * @return
	 */
	public String preProcessMarkdown(String content, final URI baseURI, final String urlPrefix) {		
		if (!preProcessMarkdown || content == null || content.length()==0) {
			return "";			
		}
		
		MarkdownPreProcessor.Region.Chain chain = new MarkdownPreProcessor.Region.Chain() {
			
			@Override
			public String process(String content) {
				return preProcessMarkdown(CoreUtil.stringify(content), baseURI, urlPrefix);
			}
			
		};
		
		List<MarkdownPreProcessor.Region> matchedRegions = new ArrayList<>();
		synchronized (preProcessors) {
			for (ExtensionEntry<MarkdownPreProcessor> extensionEntry: preProcessors) {
				matchedRegions.addAll(extensionEntry.extension.match(content));
			}
		}
		Collections.sort(matchedRegions, new Comparator<MarkdownPreProcessor.Region>() {

			@Override
			public int compare(Region r1, Region r2) {
				if (r1.getStart() == r2.getStart()) {
					if (r1.getEnd() == r2.getEnd()) {
						return r1.hashCode() - r2.hashCode();
					}
					return r2.getEnd() - r1.getEnd(); // Larger regions get precedence
				}
				
				return r1.getStart() - r2.getStart(); // Earlier regions get precedence
			}
		});
		
		StringBuilder out = new StringBuilder();
		int start = 0;
		for (MarkdownPreProcessor.Region region: matchedRegions) {
			int regionStart = region.getStart();
			if (regionStart>=start) {
				if (regionStart>start) {
					out.append(content.substring(start, regionStart));
					start = regionStart;
				}
				String result = region.process(baseURI, urlPrefix, chain, this);
				if (result != null) {
					out.append(result);
					start = region.getEnd();
				}
			}
		}
		if (start<content.length()) {
			out.append(content.substring(start));
		}
		return out.toString();
	}
	
	public Resolver.Registry getResolverRegistry(URI baseURI, String urlPrefix) {
		final String absDocRoutePath = urlPrefix+docRoutePath;	
		final Map<Object, Object> env = new HashMap<>();
		String baseURLStr = baseURI.toString();
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

	@Override
	public void bundleChanged(BundleEvent event) {
		scheduleReloading();		
	}
	
	public void setScrService(ScrService scrService) {
		this.scrService = scrService;		
	}
	
	public ScrService getScrService() {
		return scrService;
	}

	protected void addTocExtension(IExtensionTracker tracker, IExtension extension, IConfigurationElement ce) {
		if (isIncluded(ce)) {
			try {
				//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
				TocNodeFactory tocNodeFactory = new TocNodeFactory(
						DocRoute.this, 
						baseURL,
						urlPrefix,
						docRoutePath,
						extension.getContributor().getName(),
						contentFilters,
						ce);
				
				synchronized (tocNodeFactories) {
					tocNodeFactories.add(tocNodeFactory);
				}								
				tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
			} catch (Exception e) {
				// TODO proper logging
				e.printStackTrace();
			}
		}
	}

	protected boolean isIncluded(IConfigurationElement ce) {
		for (Pattern p: bundleExcludes) {
			if (p.matcher(ce.getContributor().getName()).matches()) {
				return false;
			}
		}
		if (bundleIncludes.isEmpty()) {
			return true;
		}
		
		for (Pattern p: bundleIncludes) {
			if (p.matcher(ce.getContributor().getName()).matches()) {
				return true;
			}
		}				
		return false;
	}
	
	protected void addEPackageTocExtension(IExtensionTracker tracker, IExtension extension, IConfigurationElement ce) {
		if (isIncluded(ce)) {
			try {			
				//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
				TocNodeFactory tocNodeFactory = new TocNodeFactory(
						DocRoute.this, 
						baseURL,
						urlPrefix,
						docRoutePath,
						extension.getContributor().getName(),
						contentFilters,
						ce);
				
				String nsURI = ce.getAttribute(NS_URI);
				synchronized (packageTocNodeFactories) {
					PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(nsURI);
					if (pe==null) {
						pe = new PackageTocNodeFactoryEntry();
						packageTocNodeFactories.put(nsURI, pe);
					}
					pe.tocNodeFactories.add(tocNodeFactory);
				}																
				tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
			} catch (Exception e) {
				// TODO proper logging
				e.printStackTrace();
			}
		}
	}
	
	protected void addEClassifierTocExtension(IExtensionTracker tracker, IExtension extension, IConfigurationElement ce) {
		if (isIncluded(ce)) {
			try {
				//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
				TocNodeFactory tocNodeFactory = new TocNodeFactory(
						DocRoute.this, 
						baseURL,
						urlPrefix,
						docRoutePath,
						extension.getContributor().getName(),
						contentFilters,
						ce);
				
				String nsURI = ce.getAttribute(NS_URI);
				synchronized (packageTocNodeFactories) {
					PackageTocNodeFactoryEntry pe = packageTocNodeFactories.get(nsURI);
					if (pe==null) {
						pe = new PackageTocNodeFactoryEntry();
						packageTocNodeFactories.put(nsURI, pe);
					}
					String classifier = ce.getAttribute("classifier");
					List<TocNodeFactory> ctnfl = pe.classifierTocNodeFactories.get(classifier);
					if (ctnfl==null) {
						ctnfl = new ArrayList<TocNodeFactory>();
						pe.classifierTocNodeFactories.put(classifier, ctnfl);
					}
					ctnfl.add(tocNodeFactory);
				}																
				tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
			} catch (Exception e) {
				// TODO proper logging
				e.printStackTrace();
			}
		}
	}
	
	protected void addComponentTocExtension(IExtensionTracker tracker, IExtension extension, IConfigurationElement ce) {
		if (isIncluded(ce)) {
			try {
				//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
				TocNodeFactory tocNodeFactory = new TocNodeFactory(
						DocRoute.this, 
						baseURL,
						urlPrefix,
						docRoutePath,
						extension.getContributor().getName(),
						contentFilters,
						ce);
				
				String symbolicName = ce.getAttribute(SYMBOLIC_NAME);
				if (CoreUtil.isBlank(symbolicName)) {
					symbolicName = ce.getContributor().getName();
				}
				synchronized (bundleTocNodeFactories) {
					Map<Version, BundleTocNodeFactoryEntry> vbe = bundleTocNodeFactories.get(symbolicName);
					if (vbe==null) {
						vbe = new TreeMap<>();
						bundleTocNodeFactories.put(symbolicName, vbe);
					}
					String versionStr = ce.getAttribute(VERSION);
					Version version = CoreUtil.isBlank(versionStr) ? Version.emptyVersion : new Version(versionStr);
					BundleTocNodeFactoryEntry be = vbe.get(version);
					if (be == null) {
						be = new BundleTocNodeFactoryEntry();
						vbe.put(version, be);
					}
					String componentName = ce.getAttribute(COMPONENT_NAME);
					List<TocNodeFactory> ctnfl = be.componentTocNodeFactories.get(componentName);
					if (ctnfl==null) {
						ctnfl = new ArrayList<TocNodeFactory>();
						be.componentTocNodeFactories.put(componentName, ctnfl);
					}
					ctnfl.add(tocNodeFactory);
				}																
				tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
			} catch (Exception e) {
				// TODO proper logging
				e.printStackTrace();
			}
		}
	}
	
	protected void addBundleTocExtension(IExtensionTracker tracker, IExtension extension, IConfigurationElement ce) {
		if (isIncluded(ce)) {
			try {
				//Map<Object, Object> contentFilterEnv = createExtensionEnvironment(new URL(baseURL), urlPrefix);
				TocNodeFactory tocNodeFactory = new TocNodeFactory(
						DocRoute.this, 
						baseURL,
						urlPrefix,
						docRoutePath,
						extension.getContributor().getName(),
						contentFilters,
						ce);
				
				String symbolicName = ce.getAttribute(BUNDLE_SYMBOLIC_NAME);
				if (CoreUtil.isBlank(symbolicName)) {
					symbolicName = ce.getContributor().getName();
				}
				synchronized (bundleTocNodeFactories) {
					Map<Version, BundleTocNodeFactoryEntry> vbe = bundleTocNodeFactories.get(symbolicName);
					if (vbe==null) {
						vbe = new TreeMap<>();
						bundleTocNodeFactories.put(symbolicName, vbe);
					}
					String versionStr = ce.getAttribute(BUNDLE_VERSION);
					Version version = CoreUtil.isBlank(versionStr) ? Version.emptyVersion : new Version(versionStr);
					BundleTocNodeFactoryEntry be = vbe.get(version);
					if (be == null) {
						be = new BundleTocNodeFactoryEntry();
						vbe.put(version, be);
					}
					be.tocNodeFactories.add(tocNodeFactory);
				}																
				tracker.registerObject(extension, tocNodeFactory, IExtensionTracker.REF_WEAK);
			} catch (Exception e) {
				// TODO proper logging
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Generates section content from TOC nodes linked with "#" prefix to EPackages, EClasses, bundles and components. 
	 * @param section
	 * @param level
	 * @param sectionFragment
	 */
	public String section(TocNode section, int level) {		
		Fragment sectionFragment = getHtmlFactory().fragment();
		if (level!=-1) {
			String header = StringEscapeUtils.escapeHtml4(section.getText().substring(1));
			if (section.getIcon()!=null) {
				header = getHtmlFactory().tag(TagName.img).attribute("src", getHtmlFactory()+section.getIcon()).style("margin-right", "5px") + header;
			}
			sectionFragment.content(getHtmlFactory().tag("h"+level, header));
		}		
		
		String content = section.getContent();
		if (content==null) {
			// TODO - inclusion instead of AJAX
			String sectionId = "section_"+getHtmlFactory().nextId();
			String script = getHtmlFactory().tag(TagName.script, "nsdLoad('#"+sectionId+"','"+getDocRoutePath()+section.getHref()+"?navWrap=no');").toString();
			sectionFragment.content(getHtmlFactory().div().id(sectionId), script); 
		} else {
			sectionFragment.content(content); 
		}
		
		for (TocNode subSection: section.getChildren()) {
			sectionFragment.content(section(subSection, level==-1 ? 3 : Math.min(6, level+1)));
		}
		
		return sectionFragment.toString();
	}
		
	public void mountedDocumentation(Bundle bundle, String componentName, Fragment sink) {
		
		TocNode elementDoc = new TocNode(null, null, null, null, false);
		
		synchronized (bundleTocNodeFactories) {
			BundleTocNodeFactoryEntry be = matchVersion(bundle);
			if (be!=null) {				
				List<TocNodeFactory> tnfl = CoreUtil.isBlank(componentName) ? be.tocNodeFactories : be.componentTocNodeFactories.get(componentName);
				if (tnfl!=null) {
					for (TocNodeFactory tnf: tnfl) {
						if (tnf.isElementDoc() && tnf.isRoot(tnfl)) {
							tnf.createTocNode(elementDoc, tnfl, false);
						}
					}
				}					
			}
		}
		
		for (TocNode eDoc: elementDoc.getChildren()) {
			sink.content(section(eDoc, -1));
		}						
	}
	
	protected void sections(Bundle bundle, String componentName, Tabs tabs) {		
		TocNode sections = new TocNode(null, null, null, null, false);
		
		synchronized (bundleTocNodeFactories) {
			BundleTocNodeFactoryEntry be = matchVersion(bundle);
			if (be!=null) {				
				List<TocNodeFactory> tnfl = CoreUtil.isBlank(componentName) ? be.tocNodeFactories : be.componentTocNodeFactories.get(componentName);
				if (tnfl!=null) {
					for (TocNodeFactory tnf: tnfl) {
						if (tnf.isSection() && tnf.isRoot(tnfl)) {
							tnf.createTocNode(sections, tnfl, false);
						}
					}
				}
			}
		}
		
		sections.sort(false);
		
		for (TocNode section: sections.getChildren()) {
			String tabName = StringEscapeUtils.escapeHtml4(section.getText().substring(1));
			if (section.getIcon()!=null) {
				tabName = getHtmlFactory().tag(TagName.img).attribute("src", getDocRoutePath()+section.getIcon()).style("margin-right", "5px") + tabName;
			}
			Fragment sectionFragment = getHtmlFactory().fragment();
			sectionFragment.content(section(section, -1));
			tabs.item(tabName, sectionFragment);
		}		
	}
	
	/**
	 * Helper method.
	 * @param baseURI
	 * @param urlPrefix
	 * @param markdownSource
	 * @return
	 */
	public String markdownToHtml(URI baseURI, String urlPrefix, String markdownSource) {
		return CoreUtil.isBlank(markdownSource) ? "" : new PegDownProcessor(DocRoute.MARKDOWN_OPTIONS).markdownToHtml(preProcessMarkdown(markdownSource, baseURI, urlPrefix), createMarkdownLinkRenderer(baseURI, urlPrefix));
	}
	
	/**
	 * Helper method.
	 * @param markdownSource
	 * @return
	 */
	public String markdownToHtml(String markdownSource) {
		try {
			return markdownToHtml(new URI(baseURL), urlPrefix, markdownSource);
		} catch (URISyntaxException e) {
			return htmlFactory.span("Exception: "+e).bootstrap().text().color(Style.DANGER).toString();
		}		
	}
	
	/**
	 * Helper method.
	 * @param baseURI
	 * @param urlPrefix
	 * @param markdownSource
	 * @return
	 */
	public Tag markdownToHtmlDiv(URI baseURI, String urlPrefix, String markdownSource) {
		return htmlFactory.div(markdownToHtml(baseURI, urlPrefix, markdownSource)).addClass("markdown-body");
	}
	
	/**
	 * Helper method.
	 * @param markdownSource
	 * @return
	 */
	public Tag markdownToHtmlDiv(String markdownSource) {
		try {
			return markdownToHtmlDiv(new URI(baseURL), urlPrefix, markdownSource);
		} catch (URISyntaxException e) {
			return htmlFactory.div("Exception: "+e).bootstrap().text().color(Style.DANGER);
		}					
	}		

	public String javaDocLink(String className, boolean qualified, boolean isArray) {
		try {
			if (qualified) {
				return markdownToHtml(new URI(baseURL), urlPrefix, " [[javadoc>"+className+"|"+className+"]]"+(isArray ? "[]" : ""));
			}
			
			return markdownToHtml(new URI(baseURL), urlPrefix, " [[javadoc>"+className+"]]");
		} catch (URISyntaxException e) {
			return htmlFactory.span("Exception: "+e).bootstrap().text().color(Style.DANGER).toString();
		}						
	}
	
	public Tag bundleLink(Bundle bundle) {
		return htmlFactory.link(ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath+BUNDLE_INFO_PATH+bundle.getBundleId()+"/index.html", StringEscapeUtils.escapeHtml4(bundle.getSymbolicName()));		
	}
	
	public Tag componentLink(String componentName, long componentId) {
		return htmlFactory.link(ROUTER_DOC_CONTENT_FRAGMENT_PREFIX+docRoutePath+COMPONENT_INFO_PATH+componentId+"/index.html", StringEscapeUtils.escapeHtml4(componentName));		
	}	
	
	public Tag componentLink(Component component) {
		return componentLink(component.getName(), component.getId());
	}
	
	public Tag componentLink(Bundle bundle, String componentName) {
		if (scrService == null) {
			return htmlFactory.span(StringEscapeUtils.escapeHtml4("SCR service not available, component not found: '"+componentName+"' in "+bundle.getSymbolicName()+" "+bundle.getVersion()));
		}
		Component[] bundleComponents = scrService.getComponents(bundle);
		if (bundleComponents != null) {
			for (Component cmp: bundleComponents) {
				if (componentName.equals(cmp.getName())) {
					return componentLink(cmp);
				}
			}
		}
				
		return htmlFactory.span(StringEscapeUtils.escapeHtml4("Component not found: '"+componentName+"' in "+bundle.getSymbolicName()+" "+bundle.getVersion()));
	}

	public String findStoryElement(String spec) {
		if (CoreUtil.isBlank(spec)) {
			return null;
		}
		int dashIdx = spec.indexOf("#");		
		if (dashIdx==-1) {
			return null;
		}
		
		String location = spec.substring(0, dashIdx);
		String id = spec.substring(dashIdx+1);
		
		int cIdx = id.indexOf(":");
		return storyDocumentationGenerator.findModelElement(
				location, 
				cIdx == -1 ? id : id.substring(0, cIdx),
				cIdx == -1 ? null : id.substring(cIdx+1));		
	}
	
	public String firstMarkdownSentence(String markdown) {
		if (CoreUtil.isBlank(markdown)) {
			return "";
		}

		try {
			return firstSentence(Jsoup.parse(markdownToHtml(new URI(baseURL), urlPrefix, markdown)).text());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String firstSentence(String text) {
		Matcher matcher = SENTENCE_PATTERN.matcher(text);		
		Z: while (matcher.find()) {
			String group = matcher.group();
			for (String abbr: ABBREVIATIONS) {
				if (group.trim().endsWith(abbr)) {
					continue Z;
				}
			}
			if (matcher.end()<maxFirstSentenceLength) {
				return text.substring(0, matcher.end());
			}
		}
		
		return text.length()<maxFirstSentenceLength ? text : text.substring(0, maxFirstSentenceLength)+"...";
	}
	
	/**
	 * 
	 * @param obj
	 * @return Toc node for a given object or null.
	 */
	public TocNode findToc(Object obj) {
		return tocRoot.match(obj);
	}
}
