package org.nasdanika.cdo.web.doc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.activation.MimetypesFileTypeMap;

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
import org.eclipse.core.runtime.CoreException;
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
import org.nasdanika.cdo.web.doc.TocNode.TocNodeVisitor;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
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

public class DocRoute implements Route {
		
	private static final String WIKI_LINK_RENDERER = "wiki-link-renderer";
	private static final String WIKI_LINK_RESOLVER = "wiki-link-resolver";
	private static final String CONTENT_FILTER = "content-filter";
	private static final String TOC = "toc";
	private static final String RESOURCES_PATH = "/resources/";
	private static final String BUNDLE_PATH = "/bundle/";
	private static final String PACKAGES_SESSION_PATH = "/packages/session/";
	private static final String PACKAGES_GLOBAL_PATH = "/packages/global/";
	private static final String TOC_PATH = "/toc/";
	private int pathOffset = 1;
	private Bundle docBundle;
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
	
	private Map<String, Map<String, ContentFilter>> contentFilters = new ConcurrentHashMap<>();
	
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
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ExtensionTracker extensionTracker;
	
	private Map<String, WikiLinkProcessor.Renderer> wikiLinkRendererMap = new ConcurrentHashMap<>();
	private Map<String, WikiLinkProcessor.Resolver> wikiLinkResolverMap = new ConcurrentHashMap<>();
	private List<TocNodeFactory> tocNodeFactories = new ArrayList<>();
	private MimetypesFileTypeMap mimeTypesMap;
		
	public void activate(ComponentContext context) throws Exception {
		Object pathOffsetProp = context.getProperties().get("pathOffset");
		if (pathOffsetProp instanceof Number) {
			pathOffset = ((Number) pathOffsetProp).intValue();
		}
		bundleContext = context.getBundleContext();
		docBundle = FrameworkUtil.getBundle(getClass());
		
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
    	String contextPath = System.getProperty("org.eclipse.equinox.http.jetty.context.path");
    	if (contextPath!=null) {
    		docRoutePath = contextPath + docRoutePath;
    		docAppPath = contextPath + docAppPath;
    		baseURL+=contextPath;
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
								wikiLinkRendererMap.put(rendererName, (Renderer) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")));
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
								wikiLinkResolverMap.put(resolverName, (WikiLinkProcessor.Resolver) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class")));
								tracker.registerObject(extension, WIKI_LINK_RESOLVER+":"+resolverName, IExtensionTracker.REF_WEAK);
							} catch (Exception e) {
								// TODO - proper logging
								e.printStackTrace();
							}
	    				}
						break;
    				case CONTENT_FILTER: 
	    				String sourceType = ce.getAttribute("source-type");
	    				Map<String, ContentFilter> targetMap = contentFilters.get(sourceType);
	    				if (targetMap==null) {
	    					targetMap = new ConcurrentHashMap<>();
	    					contentFilters.put(sourceType, targetMap);
	    				}
	    				String targetType = ce.getAttribute("target-type");
						if (!targetMap.containsKey(targetType)) {
	    					try {
								ContentFilter contentFilter = (ContentFilter) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class"));
								targetMap.put(targetType, contentFilter);
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
						} 						
					} else if (obj instanceof ContentFilter) {
						for (Map<String, ContentFilter> tm: contentFilters.values()) {
							Iterator<ContentFilter> cfit = tm.values().iterator();
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
							TocNodeFactory tocNodeFactory = new TocNodeFactory(
									baseURL,
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
    	
		loadTimer = new Timer();
		doLoad.set(false);
		loadTimer.schedule(loadTask, 500);
	}

	private TocNode tocRoot;
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
			TocNode packagesToc = tocRoot.createChild("Packages", null, null);
			createPackageRegistryToc(EPackage.Registry.INSTANCE, packagesToc.createChild("Global", null, null), "/packages/global");
			if (cdoSessionProvider!=null) {
				createPackageRegistryToc(cdoSessionProvider.getSession().getPackageRegistry(), packagesToc.createChild("Session", null, null), "/packages/session");				
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
							if (tocNode!=null && !CoreUtil.isBlank(tocNode.getContent())) {
								return new ContentEntry() {
									
									@Override
									public boolean isHTML() {
										return true; // Embedded content is always rendered to HTML
									}
									
									@Override
									public String getContent() {
										return tocNode.getContent();
									}
								};
							}
							return null; // We don't index automatically generated TOC pages
						}
						
						if (path.startsWith(PACKAGES_GLOBAL_PATH) || path.startsWith(PACKAGES_SESSION_PATH)) {
							// Always HTML String for packages if not null.
							try {
								final Object content = DocRoute.this.getContent(path);
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
							} catch (Exception de) {
								de.printStackTrace(); // TODO - proper logging.
							}
							return null;
						}
						// TODO - do the rest, type guessing by extension.
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
	        indexSearcher = new IndexSearcher(searchIndexReader);
		} finally {
			lock.writeLock().unlock();
		}
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
		for (EPackage ePackage: packages) {
			createEPackageToc(owner, ePackage, prefix);
		}
	}
		
	private void createEPackageToc(TocNode parent, EPackage ePackage, String prefix) {
		TocNode ePackageToc = parent.createChild(ePackage.getName(), prefix+"/"+Hex.encodeHexString(ePackage.getNsURI().getBytes(/* UTF-8? */)), "/resources/images/EPackage.gif");
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
		
		// TODO - from extensions
	}

	private void createEClassifierToc(TocNode parent, EClassifier eClassifier, String prefix) {
		String href = prefix+"/"+Hex.encodeHexString(eClassifier.getEPackage().getNsURI().getBytes(/* UTF-8? */))+"/"+eClassifier.getName();			
		if (eClassifier instanceof EClass) {
			parent.createChild(eClassifier.getName(), href, "/resources/images/EClass.gif");
		} else if (eClassifier instanceof EEnum) {
			parent.createChild(eClassifier.getName(), href, "/resources/images/EEnum.gif");
		} else {
			parent.createChild(eClassifier.getName(), href, "/resources/images/EDataType.gif");
		}
		// TODO - from extensions
	}
	
	private Object getContent(String path) throws Exception {
		if (path.startsWith(PACKAGES_GLOBAL_PATH)) {
			String[] subPath = path.substring(PACKAGES_GLOBAL_PATH.length()).split("/");
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(new String(Hex.decodeHex(subPath[0].toCharArray())));
			if (subPath.length==1) {
				return getEPackageContent(ePackage, docRoutePath+"/packages/global");
			}
			return getEClassifierContent(ePackage.getEClassifier(subPath[1]), docRoutePath+"/packages/global");
		} 
		
		if (path.startsWith(PACKAGES_SESSION_PATH)) {
			String[] subPath = path.substring(PACKAGES_SESSION_PATH.length()).split("/");
			EPackage ePackage = cdoSessionProvider.getSession().getPackageRegistry().getEPackage(new String(Hex.decodeHex(subPath[0].toCharArray())));
			if (subPath.length==1) {
				return getEPackageContent(ePackage, docRoutePath+"/packages/session");
			}
			return getEClassifierContent(ePackage.getEClassifier(subPath[1]), docRoutePath+"/packages/global");				
		} 
		
		if (path.startsWith(BUNDLE_PATH)) {
			int idx = path.indexOf("/", BUNDLE_PATH.length());
			if (idx==-1) {
				return null;
			}
			String bundleId = path.substring(BUNDLE_PATH.length(), idx);
			for (Bundle targetBundle: bundleContext.getBundles()) {
				if (bundleId.equals(targetBundle.getSymbolicName())) {
					return targetBundle.getResource(path.substring(idx+1));
				}
			}
			return null;
		} 
		
		if (path.startsWith(RESOURCES_PATH)) {
			// TODO - .md processing
			return docBundle.getResource(path.substring(RESOURCES_PATH.length()));
		} 
		
		if (path.startsWith(TOC_PATH)) {
			// TODO - generate 
		}
		
		// TODO - extensions
		
		return null; // Not found
	}
	
	private EClassDocumentationGenerator eClassDocumentationGenerator = new EClassDocumentationGenerator();	
	private EDataTypeDocumentationGenerator eDataTypeDocumentationGenerator = new EDataTypeDocumentationGenerator();	
	private EEnumDocumentationGenerator eEnumDocumentationGenerator = new EEnumDocumentationGenerator();	
	
	private Object getEClassifierContent(EClassifier eClassifier, String registryPath) {
		if (eClassifier instanceof EClass) {
			return eClassDocumentationGenerator.generate(htmlFactory, docRoutePath, registryPath, (EClass) eClassifier);
		} 
		
		if (eClassifier instanceof EEnum) {
			return eEnumDocumentationGenerator.generate(htmlFactory, docRoutePath, registryPath, (EEnum) eClassifier);			
		}
		
		return eDataTypeDocumentationGenerator.generate(htmlFactory, docRoutePath, registryPath, (EDataType) eClassifier);			
	}
	
	private EPackageDocumentationGenerator ePackageDocumentationGenerator = new EPackageDocumentationGenerator();

	private Object getEPackageContent(EPackage ePackage, String registryPath) {
		return ePackageDocumentationGenerator.generate(htmlFactory, docRoutePath, registryPath, ePackage);
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

			} 
			
			Object content = getContent("/"+StringUtils.join(path, "/"));
			if (content!=null) {
				return new ValueAction(content);
			}
			
			if (path.length==2 && "toc".equals(path[0])) {
				String nodePath = StringUtils.join(path, "/");
				TocNode toc = tocRoot.find("/"+nodePath);
				if (toc==null) {
					return Action.NOT_FOUND;
				}
								
				context.getResponse().setContentType("text/html");
				Fragment fragment = htmlFactory.fragment(htmlFactory.tag(TagName.h1, StringEscapeUtils.escapeHtml4(toc.getText())));
				if (CoreUtil.isBlank(toc.getContent())) {
					Tag childList = htmlFactory.tag(TagName.ul);
					fragment.content(childList);
					for (TocNode ch: toc.getChildren()) {
						String prefix = docAppPath+"#router/doc-content/"+docRoutePath;
						childList.content(htmlFactory.tag(TagName.li, htmlFactory.link(prefix+ch.getHref(), StringEscapeUtils.escapeHtml4(ch.getText()))));
					}										
				} else {
					fragment.content(toc.getContent());
				}
				return new ValueAction(fragment.toString());
				
			}
			
			if (path.length>2 && "resources".equals(path[0])) {
				String resourcePath = StringUtils.join(path, "/", 1, path.length);
				URL res = docBundle.getResource(resourcePath);
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

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
		
	}


}
