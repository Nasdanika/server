package org.nasdanika.web.convert.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.Converter;

public class Collection {
	
	public static class ToJSON implements Converter<java.util.Collection<?>, JSONArray> {

		@Override
		public JSONArray convert(
				java.util.Collection<?> source, 
				Class<JSONArray> target,
				WebContext context) throws Exception {
			
			JSONArray ret = new JSONArray();
			for (Object e: source) {
				ret.put(context.convert(e, JSONObject.class));
			}
			
			return ret;
		}

		@Override
		public void close() throws Exception {
			// NOP
		}
		
	}
	
	public static class FromJSON implements Converter<JSONArray, ArrayList<Object>> {

		@Override
		public ArrayList<Object> convert(JSONArray source, Class<ArrayList<Object>> target, WebContext context) throws Exception {
			ArrayList<Object> ret = new ArrayList<>();
			for (int i=0; i<source.length(); ++i) {
				ret.add(context.convert(source.get(i), Object.class));
			}
			return ret;
		}

		@Override
		public void close() throws Exception {
			// NOP
		}
		
	}

}
