package org.nasdanika.webtest;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.ModelFactory;
import org.nasdanika.webtest.model.PageMethodResult;
import org.nasdanika.webtest.model.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult implements HttpPublisher, DirectoryPublisher, InstanceTracker {

	private final Class<? extends Page<WebDriver>> pageClass;
	
	private String id;
	private String title;

	private List<Field> webElements;
	
	public String getId() {
		return id;
	}
	
	boolean isProxy() {
		return Proxy.isProxyClass(pageClass);				
	}
	
	public String getTitle() {
		return title;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, List<Field> webElements,	String title) {
		this.pageClass = pageClass;
		this.webElements = webElements;
		this.title = title;
	}

//	PageResult(Class<? extends Page<WebDriver>> pageClass, List<Field> webElements) {
//		this(pageClass, webElements, pageClass.getAnnotation(Title.class)==null ? null : pageClass.getAnnotation(Title.class).value());
//	}
	
	PageResult(
			Class<? extends Page<WebDriver>> pageClass, 
			List<Field> webElements, 
			String title,
			String id) {
		this(pageClass, webElements, title);
		this.id = id;
	}
	
	public List<Field> webElements() {
		return webElements;
	}
	
	List<OperationResult<?,?>> results = new ArrayList<>();

	public List<OperationResult<?,?>> getResults() {
		return results;
	}
	
//	public Class<? extends Page<WebDriver>> getPageClass() {
//		return pageClass;
//	}
	
	public String getPageKey() {
		return !isProxy() || title==null || title.trim().length()==0 ? getPageInterface().getName() : getPageInterface().getName()+":"+title;
	}
		
	@SuppressWarnings("unchecked")
	public Class<? extends Page<WebDriver>> getPageInterface() {
		if (pageClass.isInterface()) {
			return pageClass;
		}
		for (Class<?> i: pageClass.getInterfaces()) {
			if (Page.class.isAssignableFrom(i) && !Page.class.equals(i)) {
				return (Class<? extends Page<WebDriver>>) i;
			}
		}
		return pageClass;
	}
		
	public void merge(PageResult anotherResult) {
		results.addAll(anotherResult.getResults());
		if (this.webElements == null) {
			this.webElements = anotherResult.webElements;
		} else if (anotherResult.webElements != null){
			for (Field we: anotherResult.webElements) {
				if (!this.webElements.contains(we)) {
					this.webElements.add(we);
				}
			}
		}
		if (anotherResult.getId()!=null) {
			id = anotherResult.getId();
		}
	}
	
	public Map<Method, Integer> getCoverage() {
		Map<Method, Integer> ret = new HashMap<>();
		for (Method m: getPageInterface().getMethods()) {
			if (!Page.class.equals(m.getDeclaringClass())) {
				int counter = 0;
				for (OperationResult<?,?> r: results) {
					if (m.equals(r.getOperation())) {
						++counter;
					}
				}
				
				ret.put(m, counter);
			}
		}
		return ret;
	}
	
	@Override
	public void publish(
			URL url, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception {
		
		if (monitor!=null) {
			monitor.onPublishing("Page result "+getPageInterface().getName(), url);
		}
		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
			toJSON(idMap).write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			id = pConnection.getHeaderField("ID");
			idMap.put(this, id);
		} else {
			throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
		}
	}

	private JSONObject toJSON(Map<Object, String> idMap) throws JSONException {
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToJSON(getPageInterface(), data);
		if (getTitle()!=null) {
			data.put("title", getTitle());
		}
		if (isProxy()) {
			data.put("qualifiedName", getPageKey());
		}
		data.put("isProxy", isProxy());		
		JSONArray resultIDs = new JSONArray();
		data.put("results", resultIDs);
		for (OperationResult<?,?> r: getResults()) {
			String rId = idMap.get(r);
			if (rId==null) {
				throw new IllegalStateException("Operation result is not yet published");
			}
			resultIDs.put(rId);
		}
		
		JSONArray webElements = new JSONArray();
		data.put("webElements", webElements);
		if (this.webElements!=null) {
			for (Field we: this.webElements) {
				JSONObject webElement = new JSONObject(); 
				webElements.put(webElement);
				WebTestUtil.titleAndDescriptionAndLinksToJSON(we, webElement);
				if (!webElement.has("title")) {
					webElement.put("title", WebTestUtil.title(we.getName()));
				}
				webElement.put("name", we.getName());
				webElement.put("declaringClass", we.getDeclaringClass().getName());
				webElement.put("qualifiedName", we.getDeclaringClass().getName()+"."+we.getName());
				List<FindBy> findByList = new ArrayList<>();
				FindBy findBy = we.getAnnotation(FindBy.class);
				if (findBy!=null) {
					findByList.add(findBy);
				}
				FindBys findBys = we.getAnnotation(FindBys.class);
				if (findBys!=null) {
					for (FindBy fb: findBys.value()) {
						findByList.add(fb);
					}
				}
				JSONArray locators = new JSONArray();
				webElement.put("locators", locators);
				if (findByList.isEmpty()) {
					JSONObject locator = new JSONObject();
					locator.put("id", we.getName());
					locators.put(locator);
				} else {
					for (FindBy fb: findByList) {
						JSONObject locator = new JSONObject();
						locators.put(locator);
						String className = fb.className();
						if (!WebTestUtil.isBlank(className)) {
							locator.put("className", className);
						} else {
							String css = fb.css();
							if (!WebTestUtil.isBlank(css)) {
								locator.put("css", css);								
							} else {
								String id = fb.id();
								if (!WebTestUtil.isBlank(id)) {
									locator.put("id", id);								
								} else {
									String linkText = fb.linkText();
									if (!WebTestUtil.isBlank(linkText)) {
										locator.put("linkText", linkText);								
									} else {
										String name = fb.name();
										if (!WebTestUtil.isBlank(name)) {
											locator.put("name", name);								
										} else {
											String plt = fb.partialLinkText();
											if (!WebTestUtil.isBlank(plt)) {
												locator.put("partialLinkText", plt);								
											} else {
												String tagName = fb.tagName();
												if (!WebTestUtil.isBlank(tagName)) {
													locator.put("tagName", tagName);								
												} else {
													String xpath = fb.xpath();
													if (!WebTestUtil.isBlank(xpath)) {
														locator.put("xpath", xpath);								
													} else {
														How how = fb.how();
														switch (how) {
														case CLASS_NAME:
															locator.put("className", fb.using());
															break;
														case CSS:
															locator.put("css", fb.using());
															break;
														case ID:
															locator.put("id", fb.using());
															break;
														case ID_OR_NAME:
															locator.put("idOrName", fb.using());
															break;
														case LINK_TEXT:
															locator.put("linkText", fb.using());
															break;
														case NAME:
															locator.put("name", fb.using());
															break;
														case PARTIAL_LINK_TEXT:
															locator.put("partialLinkText", fb.using());
															break;
														case TAG_NAME:
															locator.put("tagName", fb.using());
															break;
														case XPATH:
															locator.put("xpath", fb.using());
															break;
														default:
															System.err.println("Unexpected How: "+how);
															break;														
														}														
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		JSONArray coverage = new JSONArray();
		data.put("coverage", coverage);
		for (Entry<Method, Integer> ce: getCoverage().entrySet()) {
			JSONObject coverageEntry = new JSONObject();
			coverage.put(coverageEntry);
			WebTestUtil.titleAndDescriptionAndLinksToJSON(ce.getKey(), coverageEntry);
			if (!coverageEntry.has("title")) {
				coverageEntry.put("title", WebTestUtil.title(ce.getKey().getName()));
			}
			coverageEntry.put("qualifiedName", ce.getKey().toString());
			coverageEntry.put("invocations", ce.getValue());
		}
		return data;
	}			

	@Override
	public int publishSize() {
		return 1;
	}
	
	@Override
	public String publish(
			Directory directory, 
			boolean publishPerformance, 
			Map<Object, String> idMap,
			DirectoryPublishMonitor monitor) throws Exception {

		String path = "pages/"+getPageInterface().getName().replace('.', '/')+".json";
		
		if (monitor!=null) {
			monitor.onPublishing("Page result "+getPageInterface().getName(), path);
		}
		idMap.put(this, path);
		directory.store(toJSON(idMap), path);
		return path;
	}

	org.nasdanika.webtest.model.PageResult toModel(File screenshotsDir, Map<Object, Object> objectMap) {
		ModelFactory modelFactory = org.nasdanika.webtest.model.ModelFactory.eINSTANCE;
		org.nasdanika.webtest.model.PageResult pageResult = modelFactory.createPageResult();
		objectMap.put(this, pageResult);
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToDescriptor(getPageInterface(), pageResult);
		if (getTitle()!=null) {
			pageResult.setTitle(getTitle());
		}
		if (isProxy()) {
			pageResult.setQualifiedName(getPageKey());
		}
		pageResult.setProxy(isProxy());		
		pageResult.setDelegate(Delegate.class.isAssignableFrom(getPageInterface()));
		for (OperationResult<?,?> r: getResults()) {
			org.nasdanika.webtest.model.PageMethodResult modelResult = (PageMethodResult) objectMap.get(r);
			if (modelResult == null) {
				throw new IllegalStateException("Operation result is not yet published");
			}
			pageResult.getResults().add(modelResult);
		}
		
		if (this.webElements!=null) {
			for (Field we: this.webElements) {
				WebElement webElement = modelFactory.createWebElement();
				pageResult.getWebElements().add(webElement);
				WebTestUtil.titleAndDescriptionAndLinksToDescriptor(we, webElement);
				if (WebTestUtil.isBlank(webElement.getTitle())) {
					webElement.setTitle(WebTestUtil.title(we.getName()));
				}
				//webElement.put("name", we.getName());
				//webElement.put("declaringClass", we.getDeclaringClass().getName());
				webElement.setQualifiedName(we.getDeclaringClass().getName()+"."+we.getName());
				List<FindBy> findByList = new ArrayList<>();
				FindBy findBy = we.getAnnotation(FindBy.class);
				if (findBy!=null) {
					findByList.add(findBy);
				}
				FindBys findBys = we.getAnnotation(FindBys.class);
				if (findBys!=null) {
					for (FindBy fb: findBys.value()) {
						findByList.add(fb);
					}
				}
				if (findByList.isEmpty()) {
					Locator locator = modelFactory.createLocator();
					locator.setHow(How.ID.name());
					locator.setUsing(we.getName());
					webElement.getLocators().add(locator);
				} else {
					for (FindBy fb: findByList) {
						Locator locator = modelFactory.createLocator();
						webElement.getLocators().add(locator);
						String className = fb.className();
						if (!WebTestUtil.isBlank(className)) {
							locator.setHow(How.CLASS_NAME.name());
							locator.setUsing(className);
						} else {
							String css = fb.css();
							if (!WebTestUtil.isBlank(css)) {
								locator.setHow(How.CSS.name());
								locator.setUsing(css);
							} else {
								String id = fb.id();
								if (!WebTestUtil.isBlank(id)) {
									locator.setHow(How.ID.name());
									locator.setUsing(id);
								} else {
									String linkText = fb.linkText();
									if (!WebTestUtil.isBlank(linkText)) {
										locator.setHow(How.LINK_TEXT.name());
										locator.setUsing(linkText);
									} else {
										String name = fb.name();
										if (!WebTestUtil.isBlank(name)) {
											locator.setHow(How.NAME.name());
											locator.setUsing(name);
										} else {
											String plt = fb.partialLinkText();
											if (!WebTestUtil.isBlank(plt)) {
												locator.setHow(How.PARTIAL_LINK_TEXT.name());
												locator.setUsing(plt);
											} else {
												String tagName = fb.tagName();
												if (!WebTestUtil.isBlank(tagName)) {
													locator.setHow(How.TAG_NAME.name());
													locator.setUsing(tagName);
												} else {
													String xpath = fb.xpath();
													if (!WebTestUtil.isBlank(xpath)) {
														locator.setHow(How.XPATH.name());
														locator.setUsing(xpath);
													} else {
														How how = fb.how();
														if (how!=How.UNSET) {
															locator.setHow(how.name());
															locator.setUsing(fb.using());
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return pageResult;
	}	

	
	private Collection<Page<?>> pages = new ArrayList<>();
	
	void addInstance(Page<?> page) {
		pages.add(page);
	}

	@Override
	public boolean isInstance(Object obj) {
		return pages.contains(obj);
	}				
	
}
