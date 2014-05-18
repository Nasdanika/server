package org.nasdanika.web;

import java.util.HashMap;
import java.util.Map;

import org.nasdanika.core.Context;

public class MapObjectPathResolver implements ObjectPathResolver<Object> {

	private Map<Object, String> pathMap = new HashMap<>();

	public Map<Object, String> getPathMap() {
		return pathMap;
	}
	
	@Override
	public String resolve(Object obj, ObjectPathResolver<Object> master, Context context) {		
		return pathMap.get(obj);
	}

}
