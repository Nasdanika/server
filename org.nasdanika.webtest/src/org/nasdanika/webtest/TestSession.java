package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.json.JSONObject;

/**
 * Publishes test results to HTTP report server, directory, or bundle.
 * @author Pavel Vlasov
 *
 */
class TestSession implements HttpPublisher, DirectoryPublisher {

	private Class<?> klass;
	private List<? extends TestResult> testResults;

	TestSession(Class<?> klass, Collection<? extends TestResult> testResults) {
		this.klass = klass;		
		this.testResults = new ArrayList<>(testResults);
	}
	
	@Override
	public void publish(
			URL pURL, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception {
		
		if (monitor!=null) {
			monitor.onPublishing("Test Session "+klass.getName(), pURL);
		}
		// 1. Initiate publish by POST to publish URL. It shall return URL of new report to post results to.
		HttpURLConnection pConnection = (HttpURLConnection) pURL.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToJSON(klass, data);
		data.put("size", publishSize());
		data.put("node", InetAddress.getLocalHost().getHostName());
		try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
			data.write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			String location = pConnection.getHeaderField("Location");
			URL sessionTestResultsURL = new URL(location+"/testResults");
			idMap.put(this, pConnection.getHeaderField("ID"));
			try {
				Map<String, ActorResult> actorResults = new HashMap<>();
				Map<String, PageResult> pageResults = new HashMap<>();
				for (TestResult tr: testResults) {
					tr.publish(sessionTestResultsURL, securityToken, publishPerformance, idMap, monitor);				
					for (ActorResult car: tr.getActorResults()) {
						ActorResult aar = actorResults.get(car.getActorKey());
						if (aar==null) {
							aar = new ActorResult(car.getActorInterface(), car.getTitle());
							actorResults.put(car.getActorKey(), aar);
						}
						aar.merge(car);
					}
					for (PageResult cpr: tr.getPageResults()) {
						PageResult apr = pageResults.get(cpr.getPageKey());
						if (apr==null) {
							apr = new PageResult(cpr.getPageInterface(), cpr.webElements(), cpr.getTitle());
							pageResults.put(cpr.getPageKey(), apr);
						}
						apr.merge(cpr);
					}
				}
				
				URL sessionPageResultsURL = new URL(location+"/pageResults");
				for (PageResult pr: pageResults.values()) {
					pr.publish(sessionPageResultsURL, securityToken, publishPerformance, idMap, monitor);
				}
				
				URL sessionActorResultsURL = new URL(location+"/actorResults");
				for (ActorResult ar: actorResults.values()) {
					ar.publish(sessionActorResultsURL, securityToken, publishPerformance, idMap, monitor);
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
	
	@Override
	public String publish(
			Directory directory, 
			boolean publishPerformance, 
			Map<Object, String> idMap,
			DirectoryPublishMonitor monitor) throws Exception {
		
		throw new UnsupportedOperationException("TODO!");
	}	
	
	/**
	 * Takes configuration from {@link ResultsModel} annotation.
	 * @throws IOException 
	 */
	public void writeModel() throws IOException {
		ResultsModel resultsModel = klass.getAnnotation(ResultsModel.class);
		if (resultsModel!=null) {
			Map<String, Object> env = new HashMap<>();
			String testClassQualifiedName = klass.getName();
			env.put("classQualifiedName", testClassQualifiedName);
			int lastDotIdx = testClassQualifiedName.lastIndexOf('.');
			env.put("className", lastDotIdx==-1 ? testClassQualifiedName : testClassQualifiedName.substring(lastDotIdx+1));
			env.put("packageName", lastDotIdx==-1 ? "" : testClassQualifiedName.substring(0, lastDotIdx));
			env.put("packageHierarchy", lastDotIdx==-1 ? "" : testClassQualifiedName.substring(0, lastDotIdx).replace('.', '/'));
			
			File resultsOutputDir = new File(WebTestUtil.interpolate(resultsModel.outputDir(), env));
			if (resultsOutputDir.exists()) {
				for (File c: resultsOutputDir.listFiles()) {
					WebTestUtil.delete(c);
				}
			} else if (!resultsOutputDir.mkdirs()) {
				throw new IOException("Could not create results directory "+resultsOutputDir.getAbsolutePath());
			}
			writeModel(resultsOutputDir, WebTestUtil.interpolate(resultsModel.model(), env), WebTestUtil.interpolate(resultsModel.screenshotsDirectory(), env));
		}
		
	}
	
	/**
	 * Writes test results model and screenshots to the specified output directory.
	 * @param outputDir
	 * @throws IOException 
	 */
	public void writeModel(File outputDir, String modelFileName, String screenshotsDirName) throws IOException {		
		org.nasdanika.webtest.model.TestSession testSession = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createTestSession();
		testSession.setNode(InetAddress.getLocalHost().getHostName());
		
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToDescriptor(klass, testSession);
		if (WebTestUtil.isBlank(testSession.getTitle())) {
			testSession.setTitle(WebTestUtil.title(klass.getName()));
		}
		testSession.setTimestamp(System.currentTimeMillis());
		
		Map<String, ActorResult> actorResults = new HashMap<>();
		Map<String, PageResult> pageResults = new HashMap<>();
		File screenshotsDir = new File(outputDir, screenshotsDirName);
		if (screenshotsDir.exists()) {
			for (File f: screenshotsDir.listFiles()) {
				if (!f.delete()) {
					throw new IOException("Could not clean up screenshots directory, could not delete "+f.getAbsolutePath());
				}
			}
		} else {
			if (!screenshotsDir.mkdirs()) {
				throw new IOException("Could not create screenshots directory "+screenshotsDir.getAbsolutePath());
			}
		}
		Map<Object, Object> objectMap = new IdentityHashMap<>();
		// objectMap.put(this, testSession);
		for (TestResult tr: testResults) {
			org.nasdanika.webtest.model.TestResult trModel = tr.toModel(testSession.getScreenshots(), screenshotsDir, objectMap);
			if (trModel!=null) {
				testSession.getTestResults().add(trModel);
				for (ActorResult car: tr.getActorResults()) {
					ActorResult aar = actorResults.get(car.getActorKey());
					if (aar==null) {
						aar = new ActorResult(car.getActorInterface(), car.getTitle());
						actorResults.put(car.getActorKey(), aar);
					}
					aar.merge(car);
				}
				for (PageResult cpr: tr.getPageResults()) {
					PageResult apr = pageResults.get(cpr.getPageKey());
					if (apr==null) {
						apr = new PageResult(cpr.getPageInterface(), cpr.webElements(), cpr.getTitle());
						pageResults.put(cpr.getPageKey(), apr);
					}
					apr.merge(cpr);
				}
			}
		}
		
		for (PageResult pr: pageResults.values()) {
			testSession.getPageResults().add(pr.toModel(screenshotsDir, objectMap));
		}
		
		for (ActorResult ar: actorResults.values()) {
			testSession.getActorResults().add(ar.toModel(screenshotsDir, objectMap));
		}
		
		File modelFile = new File(outputDir, modelFileName);
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(modelFile.getAbsolutePath());
		Resource resource = resourceSet.createResource(uri);		
		resource.getContents().add(testSession);
		resource.save(null);				
	}
		
}
