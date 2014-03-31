package org.nasdanika.web.convert.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.Context;
import org.nasdanika.web.Converter;

public class Map {
	
	public static class ToJSONObject implements Converter<java.util.Map<?,?>, JSONObject> {

		@Override
		public JSONObject convert(java.util.Map<?, ?> source, Class<JSONObject> target, Context context) throws Exception {
			for (Object key: source.keySet()) {
				if (!(key instanceof String)) {
					return null;
				}
			}
			
			JSONObject ret = new JSONObject();
			for (Entry<?, ?> e: source.entrySet()) {
				ret.put((String) e.getKey(), context.convert(e.getValue(), JSONObject.class)); 
			}
			return ret;			
		}
		
	}
	
	public static class ToJSONArray implements Converter<java.util.Map<?,?>, JSONArray> {

		@Override
		public JSONArray convert(java.util.Map<?, ?> source, Class<JSONArray> target, Context context) throws Exception {
			boolean stringKeys = true;
			for (Object key: source.keySet()) {
				if (!(key instanceof String)) {
					stringKeys = false;
					break;
				}
			}
			if (stringKeys) {
				return null; // Shall be handled by ToJSONObject.
			}
			
			JSONArray ret = new JSONArray();
			for (Entry<?, ?> e: source.entrySet()) {
				JSONObject je = new JSONObject();
				je.put("key", context.convert(e.getKey(), JSONObject.class));
				je.put("value", context.convert(e.getValue(), JSONObject.class));				
				ret.put(je); 
			}
			return ret;
		}
		
	}
	
	public static class FromJSON implements Converter<JSONObject, HashMap<String, Object>> {

		@Override
		public HashMap<String, Object> convert(
				JSONObject source, 
				Class<HashMap<String, Object>> target, 
				Context context) throws Exception {
			
			HashMap<String, Object> ret = new HashMap<>();
			for (String key: JSONObject.getNames(source)) {
				ret.put(key, context.convert(source.get(key), Object.class));
			}
			return ret;
		}
		
	}


}
