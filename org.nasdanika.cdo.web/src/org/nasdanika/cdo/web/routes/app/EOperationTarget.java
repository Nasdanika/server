package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.jxpath.JXPathContext;
import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.DispatchingRoute.Target;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;

/**
 * Dispatching target invoking EOperation.
 * @author Pavel
 *
 */
public class EOperationTarget<C extends HttpServletRequestContext, T extends EObject> implements Target {
		
	private EOperation eOperation;
	private Map<String, Object> spec;
	private Map<EParameter, Object> parameterBindings;
	private Route<C, T> route;

	public EOperationTarget(Route<C,T> route, EOperation eOperation, Map<String, Object> spec, Map<EParameter, Object> parameterBindings) {
		this.route = route;
		this.eOperation = eOperation;
		this.spec = spec;
		this.parameterBindings = parameterBindings;
	}
	
	public boolean hasFormParameters() {
		for (EParameter eParameter: eOperation.getEParameters()) {
			if (isFormParameter(eParameter)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPartParameters() {
		for (Object binding: parameterBindings.values()) {
			if ("part".equals(binding)) {
				return true;
			}
			if (binding instanceof Map) {
				for (Object key: ((Map<?,?>) binding).keySet()) {
					if ("part".equals(key)) {
						return true;
					}					
				}
			}
		}
		return false;
	}
			
	public boolean isFormParameter(EParameter eParameter) {
		Object binding = parameterBindings.get(eParameter);
		if (binding == null) {
			return true; // default
		}
		
		if ("form".equals(binding) || "part".equals(binding)) {
			return true;
		}
		if (binding instanceof Map) {
			for (Object key: ((Map<?,?>) binding).keySet()) {
				if ("form".equals(key) || "part".equals(key)) {
					return true;
				}					
			}
		}
		return false;
	}	
	
	public Map<String, Object> getSpec() {
		return spec;
	}
	
	public EOperation getEOperation() {
		return eOperation;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		return route.executeEOperation((C) context, this, pathParameters, arguments);
	}

	/**
	 * Binds EParameter, invoked by Route.executeEOperation(). Delegates to Route.bindEParameter().
	 * @param context
	 * @param pathParameters
	 * @param eParameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	EParameterBinding bind(HttpServletRequestContext context, Map<String, String> pathParameters, EParameter eParameter) throws Exception {
		return route.bindEParameter((C) context, pathParameters, eParameter, parameterBindings.get(eParameter));
	}
	
	/**
	 * Invokes EOperation guarded by a lock if necessary. closes bindings.
	 * @param context
	 * @param bindings
	 * @param args
	 * @return
	 * @throws Exception
	 */
	Object invoke(HttpServletRequestContext context, EList<EParameterBinding> bindings) throws Exception {
		String lockPath = null;
		String lockType = "imply-from-http-method";
		long lockTimeout = 60000;
		
		Object lockSpec = spec.get("lock");
		if (lockSpec instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, String> lockSpecMap = (Map<String,String>) lockSpec;
			lockPath = lockSpecMap.get("path");
			if (lockSpecMap.containsKey("type")) {
				lockType = lockSpecMap.get("type");
			}
			if (lockSpecMap.containsKey("timout")) {
				lockTimeout = Long.parseLong(lockSpecMap.get("timeout"));
			}			
		}
		
		try {
			CDOLock cdoLock = null;
			if (context.getTarget() instanceof CDOObject) {
				CDOObject lockTarget = (CDOObject) context.getTarget();
				if (!CoreUtil.isBlank(lockPath)) {
					lockTarget = (CDOObject) JXPathContext.newContext(lockTarget).getValue(lockPath);
				}
				switch (lockType) {
				case "read":
					cdoLock = lockTarget.cdoReadLock();
					break;
				case "write":
					cdoLock = lockTarget.cdoWriteLock();
					break;
				case "imply-from-http-method":
					switch (context.getMethod()) {
					case DELETE:
					case PATCH:
					case POST:
					case PUT:
						cdoLock = lockTarget.cdoWriteLock();
						break;
					default:
						cdoLock = lockTarget.cdoReadLock();							
						break;
					}
				default:
					break;					
				}
			}
			
			EList<Object> args = ECollections.newBasicEList();
			for (EParameterBinding binding: bindings) {
				args.add(binding.getValue());
			}
			
			if (cdoLock == null) {
				return ((EObject) context.getTarget()).eInvoke(eOperation, args);
			}
			
			if (cdoLock.tryLock(lockTimeout, TimeUnit.MILLISECONDS)) {
				try {
					return ((EObject) context.getTarget()).eInvoke(eOperation, args);
				} finally {
					cdoLock.unlock();
				}						
			}
			
			return Action.SERVICE_UNAVAILABLE;
		} finally {
			for (EParameterBinding binding: bindings) {
				binding.close();
			}
		}
	}		

}
