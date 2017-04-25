package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.core.AuthorizationProvider;
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
	private Map<String, Object> spec;
	private Map<EParameter, Object> parameterBindings;

	public EOperationTarget(EOperation eOperation, Map<String, Object> spec, Map<EParameter, Object> parameterBindings) {
		this.eOperation = eOperation;
		this.spec = spec;
		this.parameterBindings = parameterBindings;
	}

	@Override
	public RequestMethod[] getRequestMethods() {
		String method = (String) spec.get("method");
		return method == null ? new RequestMethod[] { RequestMethod.GET, RequestMethod.POST } : new RequestMethod[] { RequestMethod.valueOf(method) }; 
	}

	@Override
	public Pattern getPattern() {
		return null;
	}

	@Override
	public String getPath() {
		String path = (String) spec.get("path");
		return path == null ? eOperation.getName() : path;
	}

	@Override
	public String getProduces() {
		return (String) spec.get("produces");
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] getConsumes() {
		Object consumes = spec.get("consumes");
		if (consumes instanceof String) {
			return new String[] { (String) consumes };
		}
		if (consumes instanceof Collection) {
			return ((Collection<Object>) consumes).stream().filter(e -> e instanceof String).collect(Collectors.toList()).toArray(new String[0]);			
		}
		return null;
	}

	@Override
	public String getAction() {
		String action = (String) spec.get("action");
		return action == null ? AuthorizationProvider.StandardAction.execute.name() : action;
	}

	@Override
	public String getQualifier() {
		String qualifier = (String) spec.get("qualifier");
		return qualifier == null ? eOperation.getName() : qualifier;
	}

	@Override
	public String getComment() {
		return "Invokes "+eOperation;
	}

	@Override
	public Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		// Lock
		// TODO Auto-generated method stub
		return ((EObject) context.getTarget()).eInvoke(eOperation, ECollections.singletonEList(null)); // for initial testing.
	}

}
