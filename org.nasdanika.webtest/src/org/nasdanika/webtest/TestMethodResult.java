package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.html.HTMLFactory.Glyphicon;

public class TestMethodResult extends MethodResult {

	private Object[] parameters;
	private int index;

	TestMethodResult(String id, Method method, Object[] arguments, OperationResult<?> parent, int index, Object[] parameters) {
		super(id, method, arguments, parent);
		this.index = index;
		this.parameters = parameters;
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.search;
	}
	
	public Object[] getParameters() {
		return parameters;
	}
	
	/**
	 * Use parameters instead of arguments in format.
	 */
	protected String format(String str) {
		if (str == null) {
			return null;
		}
		String pattern = str.replaceAll("\\{index\\}", Integer.toString(index));
		if (parameters==null || parameters.length==0) {
			return pattern;
		}
		return MessageFormat.format(pattern, parameters);
	}	
		
	@Override
	protected void extraPublishInfo(JSONObject data) throws Exception {
		if (parameters!=null) {
			// Simplistic approach for now
			JSONArray prms = new JSONArray();
			data.put("parameters", prms);
			for (Object prm: parameters) {
				prms.put(prm==null ? null : prm.toString());
			}
		}
	}	

}
