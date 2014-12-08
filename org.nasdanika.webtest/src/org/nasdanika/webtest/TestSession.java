package org.nasdanika.webtest;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * Publishes test results to HTTP report server.
 * @author Pavel Vlasov
 *
 */
class TestSession implements HttpPublisher {

	private Class<?> klass;
	private List<? extends TestResult> testResults;

	TestSession(Class<?> klass, Collection<? extends TestResult> testResults) {
		this.klass = klass;		
		this.testResults = new ArrayList<>(testResults);
	}
	
	@Override
	public void publish(URL pURL, String securityToken, Map<Object, String> idMap, PublishMonitor monitor) throws Exception {
		if (monitor!=null) {
			monitor.onPublishing("Test Session "+klass.getName(), pURL);
		}
		// 1. Initiate publish by POST to publish URL. It shall return URL of new report to post results to.
		HttpURLConnection pConnection = (HttpURLConnection) pURL.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionToJSON(klass, data);
		data.put("size", publishSize());
		data.put("node", InetAddress.getLocalHost().getHostName());
		try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
			data.write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			String location = pConnection.getHeaderField("Location");
			URL sessionResultsURL = new URL(location+"/results");
			idMap.put(this, pConnection.getHeaderField("ID"));
			try {
				for (TestResult tr: testResults) {
					tr.publish(sessionResultsURL, securityToken, idMap, monitor);				
				}
				// Informing test session that upload is complete by issuing PUT request.
				HttpURLConnection uConnection = (HttpURLConnection) new URL(location).openConnection();
				uConnection.setRequestMethod("PUT");
				uConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
				if (uConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
					throw new PublishException(uConnection.getURL()+" error: "+uConnection.getResponseCode()+" "+uConnection.getResponseMessage());
				}
			} catch (Exception e) {
				HttpURLConnection uConnection = (HttpURLConnection) new URL(location).openConnection();
				uConnection.setRequestMethod("DELETE");
				uConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
				if (uConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
					throw new PublishException(uConnection.getURL()+" error: "+uConnection.getResponseCode()+" "+uConnection.getResponseMessage(), e);
				}				
				throw e;
			}
		} else {
			throw new PublishException(pURL+" error: "+responseCode+" "+pConnection.getResponseMessage());
		}
	}

	@Override
	public int publishSize() {
		int ret = 1;
		for (TestResult tr: testResults) {
			ret+=tr.publishSize();				
		}
		return ret;
	}				
	
}
