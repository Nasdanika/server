package org.nasdanika.cdo.web.routes.app;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.commons.jxpath.JXPathContext;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.web.Action;
import org.nasdanika.web.DispatchingRoute.Target;
import org.nasdanika.web.HttpServletRequestContext;

/**
 * Dispatching target invoking EOperation.
 * @author Pavel
 *
 */
public class EOperationTarget<C extends HttpServletRequestContext, T extends EObject> extends EOperationTargetInfo implements Target {
		
	private Route<C, T> route;
	
	public EOperationTarget(C context, Route<C,T> route, EOperation eOperation, Map<String, Object> spec) throws Exception {
		super(context, route, eOperation, spec);
		this.route = route;
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
			Lock cdoLock = null;
			if (context.getTarget() instanceof CDOObject) {
				CDOObject lockTarget = (CDOObject) context.getTarget();
				if (!CoreUtil.isBlank(lockPath)) {
					lockTarget = (CDOObject) JXPathContext.newContext(lockTarget).getValue(lockPath);
				}
				switch (lockType) {
				case "read":
					cdoLock = ((CDOTransactionContext<?>) context).getReadLock(lockTarget);
					break;
				case "write":
					cdoLock = ((CDOTransactionContext<?>) context).getWriteLock(lockTarget);
					break;
				case "imply-from-http-method":
					switch (context.getMethod()) {
					case DELETE:
					case PATCH:
					case POST:
					case PUT:
						cdoLock = ((CDOTransactionContext<?>) context).getWriteLock(lockTarget);
						break;
					default:
						cdoLock = ((CDOTransactionContext<?>) context).getReadLock(lockTarget);							
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
				return ((EObject) context.getTarget()).eInvoke(getEOperation(), args);
			}
			
			if (cdoLock.tryLock(lockTimeout, TimeUnit.MILLISECONDS)) {
				try {
					return ((EObject) context.getTarget()).eInvoke(getEOperation(), args);
				} finally {
					cdoLock.unlock();
				}						
			}
			
			return Action.SERVICE_UNAVAILABLE;
		} catch (Exception e) {
			if (context instanceof TransactionContext) {
				((TransactionContext) context).setRollbackOnly();
			}
			throw e;
		} finally {
			for (EParameterBinding binding: bindings) {
				binding.close();
			}
		}
	}		

}
