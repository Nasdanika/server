package org.nasdanika.core;

import org.json.JSONObject;

/**
 * Interface for classes which know how to load information from JSONObject. 
 * @author Pavel
 *
 */
public interface JSONLoader {
	
	void loadJSON(JSONObject json, ConverterContext context) throws Exception;

}
