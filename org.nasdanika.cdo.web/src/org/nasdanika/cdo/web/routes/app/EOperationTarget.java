package org.nasdanika.cdo.web.routes.app;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.core.Context;
import org.nasdanika.web.DispatchingRoute.Target;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;

/**
 * Dispatching target invoking EOperation.
 * @author Pavel
 *
 */
public class EOperationTarget implements Target {
		
	private EOperation eOperation;
	private Object webOperationAnnotation;
	private Map<EParameter, Object> parameterBindings;

	public EOperationTarget(EOperation eOperation, Object webOperationAnnotation, Map<EParameter, Object> parameterBindings) {
		this.eOperation = eOperation;
		this.webOperationAnnotation = webOperationAnnotation;
		this.parameterBindings = parameterBindings;
	}

	@Override
	public RequestMethod[] getRequestMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pattern getPattern() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProduces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getConsumes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQualifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		// Lock
		// TODO Auto-generated method stub
		return ((EObject) context.getTarget()).eInvoke(eOperation, ECollections.emptyEList()); // for initial testing.
	}

}
