package org.nasdanika.cdo.web.doc.extensions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.nasdanika.cdo.web.doc.ConfigurableExtension;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.pegdown.LinkRenderer.Rendering;

public class JavadocWikiLinkResolver implements WikiLinkResolver, ConfigurableExtension, Renderer {
	
	private ThreadLocal<String> specTL = new ThreadLocal<>();

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		specTL.set(spec);
		int hashIdx = spec.indexOf("#");
		if (hashIdx != -1) {
			spec = spec.substring(0, hashIdx);
		}
		for (Entry<String, String> location: locations.entrySet()) {
			String key = location.getKey();
			String value = location.getValue();
			if (key.equals(spec)) { // Package
				return value+spec.replace('.', '/')+"/"+DocRoute.PACKAGE_SUMMARY_HTML;
			}
			
			int idx = spec.lastIndexOf('.');
			if (idx != -1 && spec.substring(0, idx).equals(key)) { // Class
				return value+spec.replace('.', '/').replace('$', '.')+".html";				
			}
		}
		
		for (Entry<String, String> pe: packageMap.entrySet()) {
			String key = pe.getKey();
			String value = pe.getValue();
			if (!value.endsWith("/")) {
				value+="/";
			}
			if (key.equals(spec)) { // Package
				return value+spec.replace('.', '/')+"/"+DocRoute.PACKAGE_SUMMARY_HTML;
			}
			
			if (spec.startsWith(key+".")) { // Class
				return value+spec.replace('.', '/').replace('$', '.')+".html";				
			}
		}
		return null;
	}

	// A map populated from downloaded package-list files - exact match, supercedes packageMap. 
	private Map<String, String> locations = new ConcurrentHashMap<>();
	
	/**
	 * Sets API documentation location. The resolver downloads package-list file from the location 
	 * to map packages to API doc URL's. 
	 * @param location
	 */
	public void setLocation(String location) {
		
		new Thread("Package list downloader for location "+location) {
			
			@Override
			public void run() {				
				String normalizedLocation = location;
				if (!normalizedLocation.endsWith("/")) {
					normalizedLocation += "/";
				}
				try {
					URL packageListURL = new URL(normalizedLocation+"package-list");
					HttpURLConnection packageListConnection = (HttpURLConnection) packageListURL.openConnection();
					int responseCode = packageListConnection.getResponseCode();
					if (responseCode==HttpURLConnection.HTTP_OK) {
						try (BufferedReader br = new BufferedReader(new InputStreamReader(packageListConnection.getInputStream()))){
							String line;
							while ((line = br.readLine()) != null) {
								locations.put(line.trim(), normalizedLocation);
							}
						}
					} else {
						System.err.println("[WARN] Could not download package list from "+packageListURL+", response code: "+responseCode+", response message: "+packageListConnection.getResponseMessage());
					}
				} catch (Exception e) {
					System.err.println("[WARN] Could not download package list from "+location+" - "+e);
				}
			}
			
		}.start();			
	}
	
	private Map<String, String> packageMap = new LinkedHashMap<String, String>();
	
	public Map<String, String> getPackageMap() {
		return packageMap;
	}
	
	@Override
	public Object generateConfigurationDocumentation(HTMLFactory htmlFactory) {
		Table packageMapTable = htmlFactory.table().bordered();
		Row hRow = packageMapTable.row();
		hRow.header("Package");
		hRow.header("Location");
		for (Entry<String, String> location: new TreeMap<>(locations).entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell("<b>"+location.getKey()+"</b>");
			pRow.cell(htmlFactory.link(location.getValue(), location.getValue()));
		}
		for (Entry<String, String> pe: new TreeMap<>(packageMap).entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell(pe.getKey());
			pRow.cell(htmlFactory.link(pe.getValue(), pe.getValue()));
		}
		
		return htmlFactory.collapsible(Bootstrap.Style.INFO, "Package map", true, packageMapTable);
	}
	
	private boolean convertMethodSignature = true;
	
	public void setConvertMethodSignature(boolean convertMethodSignature) {
		this.convertMethodSignature = convertMethodSignature;
	}
	
	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		String spec = specTL.get();
		int hashIdx = spec.indexOf("#");
		if (hashIdx != -1) {
			String fragment = spec.substring(hashIdx+1);
			int firstParenthesisIdx = fragment.indexOf("(");
			if (convertMethodSignature && firstParenthesisIdx > 0 && fragment.endsWith(")")) {
				// Convert (type[,type]) to -type-type-						
				StringBuilder fragmentBuilder = new StringBuilder(fragment.substring(0, firstParenthesisIdx)).append("-");
				String[] pTypes = fragment.substring(firstParenthesisIdx+1, fragment.length()-1).split(",");
				for (String pType: pTypes) {
					pType = pType.trim();
					int bIdx = pType.indexOf("[]");
					if (bIdx == -1) {
						fragmentBuilder.append(pType);
					} else {
						fragmentBuilder.append(pType.substring(0, bIdx));
						for (int bc = bIdx; bc < pType.length(); bc+=2) {
							fragmentBuilder.append(":A");
						}
					}
					fragmentBuilder.append("-");
				}
				fragment = fragmentBuilder.toString();
			} 
			href += "#" + fragment;
		}
		
		Rendering ret = new Rendering(isMissing ? "#" : href, content);
		if (spec!=null && !content.equals(spec)) {
			ret.withAttribute("title", spec);
		}
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		} else {
			ret.withAttribute("target", "javaDoc");
		}
		specTL.set(null);
		return ret;
	}

}
