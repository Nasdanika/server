package org.nasdanika.webtest;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Publishes test results to HTTP report server.
 * @author Pavel Vlasov
 *
 */
class HttpPublisher {

	private Class<?> klass;
	private List<? extends TestResult> testResults;
	private String publishUrl;
	private String securityToken;

	HttpPublisher(Class<?> klass, Collection<? extends TestResult> testResults) {
		this.klass = klass;
		Publish publish = klass.getAnnotation(Publish.class);
		this.publishUrl = publish.url();
		this.securityToken = publish.securityToken();
		
		this.testResults = new ArrayList<>(testResults);
	}
	
	void publish() throws Exception {
		// 1. Initiate publish by POST to publish URL. It shall return URL of new report to post results to.
		URL pURL = new URL(publishUrl);
		HttpURLConnection pConnection = (HttpURLConnection) pURL.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		pConnection.setRequestProperty("Size", String.valueOf(testResults.size()));
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			try (InputStream is = pConnection.getInputStream()) {
				try (Reader reader = new InputStreamReader(is)) {
					int ch;
					while ((ch=reader.read())!=-1) {
						System.out.print((char) ch);
					}
				}
			}
		} else {
			throw new PublishException("Server error: "+responseCode);
		}
	}
	
}
