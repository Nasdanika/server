package org.nasdanika.cdo.web.doc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Style;

public class JavadocWikiLinkResolver implements WikiLinkResolver, ConfigurableExtension {
	
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

	@Override
	public Object generateConfigurationDocumentation(HTMLFactory htmlFactory) {
		Table packageMapTable = htmlFactory.table().bordered();
		Row hRow = packageMapTable.row();
		hRow.header("Package");
		hRow.header("Location");
		for (Entry<String, String> pe: packageMap.entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell(pe.getKey());
			pRow.cell(htmlFactory.link(pe.getValue(), pe.getValue()));
		}
		
		return htmlFactory.panel(Style.INFO, "Package map", packageMapTable, null);
	}

}
