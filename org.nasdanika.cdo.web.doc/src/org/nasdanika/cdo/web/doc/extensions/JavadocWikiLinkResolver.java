package org.nasdanika.cdo.web.doc.extensions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.nasdanika.cdo.web.doc.ConfigurableExtension;
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
		for (Entry<String, String> location: locations.entrySet()) {
			String key = location.getKey();
			String value = location.getValue();
			if (key.equals(spec)) { // Package
				return value+spec.replace('.', '/')+"/package-summary.html";
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
				return value+spec.replace('.', '/')+"/package-summary.html";
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
				try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(normalizedLocation+"package-list").openStream()))){
					String line;
					while ((line = br.readLine()) != null) {
						locations.put(line.trim(), normalizedLocation);
					}					
				} catch (Exception e) {
					System.err.println("Could not download package list from "+location+" - "+e);
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
		for (Entry<String, String> location: locations.entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell("<b>"+location.getKey()+"</b>");
			pRow.cell(htmlFactory.link(location.getValue(), location.getValue()));
		}
		for (Entry<String, String> pe: packageMap.entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell(pe.getKey());
			pRow.cell(htmlFactory.link(pe.getValue(), pe.getValue()));
		}
		
		return htmlFactory.collapsible(Bootstrap.Style.INFO, "Package map", true, packageMapTable);
	}

	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		Rendering ret = new Rendering(href, content);
		String spec = specTL.get();
		if (spec!=null) {
			ret.withAttribute("title", spec);
		}
		ret.withAttribute("target", "javaDoc");
		specTL.set(null);
		return ret;
	}

}
