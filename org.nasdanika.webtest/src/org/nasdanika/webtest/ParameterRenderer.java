package org.nasdanika.webtest;

import java.io.File;

/**
 * If a parameterized test implements this interface, then it
 * can customize how parameter values are rendered in the report. 
 * @author Pavel Vlasov
 *
 */
public interface ParameterRenderer {
	
	String renderParameter(int idx, Object value, File outputDir);

}
