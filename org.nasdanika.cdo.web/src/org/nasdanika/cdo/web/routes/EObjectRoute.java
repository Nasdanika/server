package org.nasdanika.cdo.web.routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.ValueAction;
import org.nasdanika.web.routes.ObjectRoute;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class EObjectRoute extends ObjectRoute {
	
	/**
	 * EObject route. Has feature, operation, resource, and code sub-routes.
	 */
	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
		final EObject eObject = (EObject) context.getTarget();
		String[] path = context.getPath();
		
		for (EOperation op: eObject.eClass().getEAllOperations()) {
			EAnnotation routeAnnotation = op.getEAnnotation(CDOWebUtil.ANNOTATION_HOME_ROUTE); 
			boolean isHomeRoute = routeAnnotation!=null && eObject instanceof CDOObject;
			if (!isHomeRoute) {
				routeAnnotation = op.getEAnnotation(CDOWebUtil.ANNOTATION_ROUTE);
			}
			if (routeAnnotation==null) {
				continue;
			}
			
			if (isHomeRoute) {
				if (path.length!=1) {
					continue;
				}
				StringBuilder sb = new StringBuilder();
				CDOIDUtil.write(sb, ((CDOObject) eObject).cdoID());
				sb.append(".html");
				if (!path[0].equals(sb.toString())) {
					// Possibly hierarchical addressing - check container or resource.
					EObject container = eObject.eContainer();
					if (container==null) {
						int idx = eObject.eResource().getContents().indexOf(eObject);
						if (idx==-1) {
							continue;
						}
						if (!path[0].equals(idx+".html")) {
							continue;
						}
					} else {
						EStructuralFeature cf = eObject.eContainingFeature();
						if (cf.isMany()) {
							int idx = ((List<?>) container.eGet(cf)).indexOf(eObject);
							if (idx==-1) {
								continue;
							}
							if (!path[0].equals(idx+".html")) {
								continue;
							}
						} else {
							if (!path[0].equals(cf.getName()+".html")) {
								continue;
							}
						}
					}
				}
			} else {
				String patternStr = routeAnnotation.getDetails().get("pattern");
				if (patternStr==null) {
					if (path.length!=2) {
						continue;
					}
					
					if (!op.getName().equals(path[1])) {
						continue;
					}
				} else {
					if (!Pattern.matches(patternStr, CoreUtil.join(path, "/", 1))) {
						continue;
					}
				}
			}
			
			String methods = routeAnnotation.getDetails().get("method");
			if (methods!=null) {
				boolean methodMatch = false;
				for (String method: methods.split(",")) {
					if (context.getMethod().name().equalsIgnoreCase(method.trim())) {
						methodMatch = true;
						break;
					}
				}
				if (!methodMatch) {
					continue;
				}
			}
			
			Map<String,Object> argMap = new HashMap<>();
			List<ServiceReference<?>> toUnget = new ArrayList<>();
			EList<Object> opArgs = new BasicEList<>();
			BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
			for (EParameter p: op.getEParameters()) {
				Object arg = null;
				if (p.getEAnnotation(CDOWebUtil.ANNOTATION_CONTEXT_PARAMETER)!=null) {
					arg = context.adapt(p.getEType().getInstanceClass());
				} else if (p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER)!=null) {
					String serviceFilter = p.getEAnnotation(CDOWebUtil.ANNOTATION_SERVICE_PARAMETER).getDetails().get("filter");
					for (ServiceReference<?> ref: bundleContext.getServiceReferences(p.getEType().getInstanceClass(), serviceFilter)) {
						Object service = bundleContext.getService(ref);
						if (service!=null) {
							arg = service;
							toUnget.add(ref);
							break;
						}
					}
				}
				opArgs.add(arg);
				if (arg!=null) {
					argMap.put(p.getName(), arg);
				}
			}

			try {				
				String action = routeAnnotation.getDetails().get("action");
				if (action==null) {
					action = context.getMethod().name();
				}
				String qualifier = routeAnnotation.getDetails().get("qualifier");
				if (qualifier==null) {
					qualifier = op.getName();
				}
							
				if (!context.authorize(eObject, action, qualifier, null)) {
					return Action.FORBIDDEN;
				}

				return new ValueAction(eObject.eInvoke(op, opArgs));
			} finally {
				for (ServiceReference<?> sr: toUnget) {
					bundleContext.ungetService(sr);
				}													
			}
		}		
										
		if (path.length>=2 && ("container".equals(path[1]) || path[1].startsWith("container.")) ) {
			return context.getAction(eObject.eContainer(), 1);
		}
		
		if (path.length>2) {
			switch (path[1]) {			
			case "feature":
				String featureName = path[2];
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
				String operationName = path[2];
				for (EOperation op: eObject.eClass().getEAllOperations()) {
					if (operationName.equals(op.getName()) && op.getEParameters().size()<=path.length-3) {
						return context.getAction(new EOperationClosure<EObject>(eObject, op), 2);
					}
				}
				return Action.NOT_FOUND;
			}			
		}
		return super.execute(context);
	}

}
