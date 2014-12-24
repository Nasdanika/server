package org.nasdanika.webtest;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult implements HttpPublisher {

	private final Class<? extends Page<WebDriver>> pageClass;
	
	private String id;

	private List<Field> webElements;
	
	public String getId() {
		return id;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, List<Field> webElements) {
		this.pageClass = pageClass;
		this.webElements = webElements;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, String id, List<Field> webElements) {
		this(pageClass, webElements);
		this.id = id;
	}
	
	public List<Field> webElements() {
		return webElements;
	}
	
	List<OperationResult<?>> results = new ArrayList<>();

	public List<OperationResult<?>> getResults() {
		return results;
	}
	
//	public Class<? extends Page<WebDriver>> getPageClass() {
//		return pageClass;
//	}
		
	@SuppressWarnings("unchecked")
	public Class<? extends Page<WebDriver>> getPageInterface() {
		if (pageClass.isInterface()) {
			return pageClass;
		}
		for (Class<?> i: pageClass.getInterfaces()) {
			if (Page.class.isAssignableFrom(i)) {
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
				for (OperationResult<?> r: results) {
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
	public void publish(URL url, String securityToken, Map<Object, String> idMap, PublishMonitor monitor) throws Exception {
		if (monitor!=null) {
			monitor.onPublishing("Page result "+getPageInterface().getName(), url);
		}
		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionToJSON(getPageInterface(), data);
		JSONArray resultIDs = new JSONArray();
		data.put("results", resultIDs);
		for (OperationResult<?> r: getResults()) {
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
				WebTestUtil.titleAndDescriptionToJSON(we, webElement);
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
			WebTestUtil.titleAndDescriptionToJSON(ce.getKey(), coverageEntry);
			if (!coverageEntry.has("title")) {
				coverageEntry.put("title", WebTestUtil.title(ce.getKey().getName()));
			}
			coverageEntry.put("qualifiedName", ce.getKey().toString());
			coverageEntry.put("invocations", ce.getValue());
		}
		try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
			data.write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			id = pConnection.getHeaderField("ID");
			idMap.put(this, id);
		} else {
			throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
		}
	}			

	@Override
	public int publishSize() {
		return 1;
	}				
		
}
