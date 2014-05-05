package org.nasdanika.core.convert.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.Converter;
import org.nasdanika.core.ConverterContext;

public class Collection {
	
	public static class ToJSON implements Converter<java.util.Collection<?>, JSONArray, ConverterContext> {

		@Override
		public JSONArray convert(
				java.util.Collection<?> source, 
				Class<JSONArray> target,
				ConverterContext context) throws Exception {
			
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
	
	public static class FromJSON implements Converter<JSONArray, ArrayList<Object>, ConverterContext> {

		@Override
		public ArrayList<Object> convert(JSONArray source, Class<ArrayList<Object>> target, ConverterContext context) throws Exception {
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
