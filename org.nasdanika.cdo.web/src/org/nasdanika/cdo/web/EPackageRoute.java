package org.nasdanika.cdo.web;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.Action;
import org.nasdanika.web.Context;
import org.nasdanika.web.Route;

public class EPackageRoute implements Route {

	@Override
	public Action navigate(Context context) throws Exception {
		final EPackage ePackage = (EPackage) context.getTarget();
		if (context.getPath().length==1) {
			return new Action() {

				@Override
				public void close() throws Exception {
					// NOP					
				}

				@Override
				public Object execute() throws Exception {
					JSONObject info = new JSONObject();
					info.put("name", ePackage.getName());
					info.put("uri", ePackage.getNsURI());
					JSONArray classifiers = new JSONArray();
					for (EClassifier c: ePackage.getEClassifiers()) {
						classifiers.put(c.getName());
					}
					info.put("classifiers", classifiers);
					return info;
				}
				
			};
		}
		return context.getAction(ePackage.getEClassifier(context.getPath()[1]), 1);
	}

}
