package org.nasdanika.webtest;

import java.io.OutputStreamWriter;
import java.io.Writer;
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

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult implements HttpPublisher {

	private final Class<? extends Page<WebDriver>> pageClass;
	
	private String id;

	private int size;
	
	public String getId() {
		return id;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, int size) {
		this.pageClass = pageClass;
		this.size = size;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, String id, int size) {
		this(pageClass, size);
		this.id = id;
	}
	
	public int size() {
		return size;
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
		if (this.size<anotherResult.size()) {
			this.size = anotherResult.size();
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
		JSONObject coverage = new JSONObject();
		data.put("coverage", coverage);
		data.put("size", size());
		for (Entry<Method, Integer> ce: getCoverage().entrySet()) {
			coverage.put(ce.getKey().toString(), ce.getValue());
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
