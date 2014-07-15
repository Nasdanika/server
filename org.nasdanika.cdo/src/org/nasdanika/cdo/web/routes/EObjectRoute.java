package org.nasdanika.cdo.web.routes;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EObjectRoute implements Route {

	/**
	 * EObject route. Has feature, operation, resource, and code sub-routes.
	 */
	@Override
	public Action execute(final WebContext context) throws Exception {
		final EObject eObject = (EObject) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(eObject, "read", null, null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(eObject, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 

		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(eObject)+".html", context.toHTML(eObject, "label", null));

		if (context.getPath().length>2) {
			switch (context.getPath()[1]) {
			case "feature":
				String featureName = context.getPath()[2];
				int idx = featureName.lastIndexOf('.');
				if (idx!=-1) {
					featureName = featureName.substring(0, idx);
				}
		
				EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
				if (feature instanceof EReference) {
					return context.getAction(new EReferenceClosure<EObject>(eObject, (EReference) feature), 2);
				}
				if (feature instanceof EAttribute) {
					return context.getAction(new EAttributeClosure<EObject>(eObject, (EAttribute) feature), 2);
				}
				return Action.NOT_FOUND;
			case "operation":
				String operationName = context.getPath()[2];
				for (EOperation op: eObject.eClass().getEAllOperations()) {
					if (operationName.equals(op.getName()) && op.getEParameters().size()<=context.getPath().length-3) {
						return context.getAction(new EOperationClosure<EObject>(eObject, op), 2);
					}
				}
				return Action.NOT_FOUND;
			case "resource":				
				String resourceName = StringUtils.join(context.getPath(), "/", 2, context.getPath().length); 
				if (RequestMethod.GET.equals(context.getMethod())) {
					if (context.authorize(eObject, "resource", resourceName, null)) {
						// TODO - MIME types.
						InputStream resourceStream = findResource(eObject.getClass(), resourceName);
						if (resourceStream==null) {
							return Action.NOT_FOUND;
						}
						
						try (OutputStream out = ((HttpContext) context).getResponse().getOutputStream()) {
							byte[] buf = new byte[4096];
							int l;
							while ((l=resourceStream.read(buf))!=-1) {
								out.write(buf, 0, l);
							}
						} finally {
							resourceStream.close();
						}
						
						return null; 
					} 
					return Action.FORBIDDEN;
				}				
				return Action.NOT_FOUND;
			case "code":				
				String codeName = StringUtils.join(context.getPath(), "/", 2, context.getPath().length); 
				if (RequestMethod.GET.equals(context.getMethod())) {
					if (context.authorize(eObject, "code", codeName, null)) {
						InputStream resourceStream = eObject.getClass().getClassLoader().getResourceAsStream(codeName);
						if (resourceStream==null) {
							return Action.NOT_FOUND;
						}
						
						try (OutputStream out = ((HttpContext) context).getResponse().getOutputStream()) {
							byte[] buf = new byte[4096];
							int l;
							while ((l=resourceStream.read(buf))!=-1) {
								out.write(buf, 0, l);
							}
						} finally {
							resourceStream.close();
						}
						
						return null; 
					} 
					return Action.FORBIDDEN;
				}				
			}			
		}
		return Action.NOT_FOUND;
	}

	private InputStream findResource(Class<?> clazz, String resourceName) {
		if (clazz==null || Object.class.equals(clazz)) {
			return null;
		}
		
		InputStream ret = clazz.getClassLoader().getResourceAsStream(clazz.getName().replace('.',  '/')+"$"+resourceName);
		if (ret!=null) {
			return ret;
		}
		ret = findResource(clazz.getSuperclass(), resourceName);
		if (ret!=null) {
			return ret;
		}
		for (Class<?> i: clazz.getInterfaces()) {
			ret = findResource(i, resourceName);
			if (ret!=null) {
				return ret;
			}			
		}
		return null;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
		
	}

}
