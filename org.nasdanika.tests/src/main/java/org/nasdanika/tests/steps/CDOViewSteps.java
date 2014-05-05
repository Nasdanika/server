package org.nasdanika.tests.steps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class CDOViewSteps {
	
	private String routingServletURL;
	private String contentType;
	private byte[] content;
	private String contentEncoding;
	
	@When("I issue $method on $path")
	public void request(String method, String path) throws Exception {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			switch (method) {
			case "GET":
				HttpGet httpGet = new HttpGet(routingServletURL+path);
				try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
					Assert.assertEquals(200, response.getStatusLine().getStatusCode());
					this.contentType = response.getFirstHeader("Content-Type").getValue();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					Header contentEncodingHeader = response.getEntity().getContentEncoding();
					if (contentEncodingHeader!=null) {
						this.contentEncoding = contentEncodingHeader.getValue();
					}
					response.getEntity().writeTo(baos);
					this.content = baos.toByteArray();
					
				}
			}
		}
	}
	
	@Given("Routing servlet URL $servletURL")
	public void setRoutingServletURL(String routingServletURL){
		 this.routingServletURL = routingServletURL; 
	}
	
	@Then("it shall return $content with $contentType content type")
	public void validateResponse(String content, String contentType) throws Exception {
		 Assert.assertTrue(contentType.equals(this.contentType) || this.contentType.startsWith(contentType+";"));
		 try (ByteArrayInputStream bais = new ByteArrayInputStream(this.content)) {
			 try (Reader r = contentEncoding==null ? new InputStreamReader(bais) : new InputStreamReader(bais, contentEncoding)) {
				 StringWriter sw = new StringWriter();
				 char[] cbuf = new char[20];
				 int l;
				 while ((l=r.read(cbuf))!=-1) {
					 sw.write(cbuf, 0, l);
				 }
				 sw.close();
				 Assert.assertEquals(content, sw.toString());
			 }
		 }
	}
}