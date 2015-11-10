package org.nasdanika.cdo.web.doc.extensions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.cdo.web.doc.ConfigurableExtension;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.UIElement.Style;

public class JavadocWikiLinkResolver implements WikiLinkResolver, ConfigurableExtension {

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		for (Entry<String, String> pe: packageMap.entrySet()) {
			String key = pe.getKey();
			String value = pe.getValue();
			if (!value.endsWith("/")) {
				value+="/";
			}
			if (key.equals(spec)) { // Package
				return value+spec.replace('.', '/')+"/package-summary.html";
			}
			
			if ((spec.startsWith(key+".")) // Class
					|| spec.startsWith(key+".")) {
				
				return value+spec.replace('.', '/').replace('$', '.')+".html";				
			}
		}
		return null;
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
		for (Entry<String, String> pe: packageMap.entrySet()) {
			Row pRow = packageMapTable.row();
			pRow.cell(pe.getKey());
			pRow.cell(htmlFactory.link(pe.getValue(), pe.getValue()));
		}
		
		return htmlFactory.panel(Style.INFO, "Package map", packageMapTable, null);
	}

}
