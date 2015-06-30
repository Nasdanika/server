package org.nasdanika.cdo.web.doc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JavadocWikiLinkResolver implements WikiLinkResolver {
	
	private Map<String, String> packageMap = new LinkedHashMap<String, String>();

	@Override
	public String resolve(String spec, String docRoutePath) {
		for (Entry<String, String> pe: packageMap.entrySet()) {
			String key = pe.getKey();
			String value = pe.getValue();
			if (!value.endsWith("/")) {
				value+="/";
			}
			if (key.equals(spec)) { // Package
				return value+spec.replace('.', '/')+"/package-summary.html";
			}
			
			if ((key.endsWith(".*") && spec.startsWith(key.substring(0, key.length()-1))) // Class
					|| spec.startsWith(key+".")) {
				
				return value+spec.replace('.', '/')+".html";				
			}
		}
		return null;
	}
	
	public Map<String, String> getPackageMap() {
		return packageMap;
	}

}
