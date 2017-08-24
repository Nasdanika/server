package org.nasdanika.cdo.scheduler;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.core.ContextRunnable;
import org.nasdanika.core.Provider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.yaml.snakeyaml.Yaml;

/**
 * Executes given EOperation on an object with given ID with given arguments. 
 * EOperation parameters can be annotated to bind them to context and OSGi serivces.
 * Annotation source shall be <code>org.nasdanika.cdo</code>. To bind to context add a details entry with <code>bind</code> key and <code>context</code> value.
 * To bind to a service add a details entry with <code>bind</code> key and either <code>service</code> string value or YAML map value 
 * <pre>
 *    service:
 *        type: serviceType 
 *        filter: service filter
 * </pre>
 * both type and filter keys are optional.
 * In the first case EParameter type is used as service type. In the second case EParameter type is used as service type if service key is not present.  
 * @author Pavel Vlasov
 *
 * @param <CR>
 */
public class EOperationContextRunnable<CR, R> implements ContextRunnable<SchedulerContext<CR>> {
	
	protected CDOID targetId;
	private EOperation eOperation;
	private Object[] args;

	public EOperationContextRunnable(CDOObject target, EOperation eOperation, Object... args) {
		this(target.cdoID(), eOperation, args); // Transaction handler if ID is temporary - to get the permanent one upon commit?
	}

	public EOperationContextRunnable(CDOID targetId, EOperation eOperation, Object... args) {
		this.targetId = targetId;
		this.eOperation = eOperation;
		this.args = args;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(SchedulerContext<CR> context) throws Exception {
		try {
			List<ServiceReference<?>> toUnget = new ArrayList<>();
			try {
				CDOObject target = context.getView().getObject(targetId);
				EList<Object> arguments = ECollections.newBasicEList();
				int argIdx = 0;
				for (EParameter eParameter: eOperation.getEParameters()) {
					EAnnotation cdoAnnotation = eParameter.getEAnnotation("org.nasdanika.cdo");
					if (cdoAnnotation != null) {
						String bindStr = cdoAnnotation.getDetails().get("bind");
						if ("context".equals(bindStr)) {
							arguments.add(context);
							continue;
						}
						
						String serviceType = null;
						String filter = null;
						if ("service".equals(bindStr)) {
							serviceType = eParameter.getEType().getInstanceClassName();
						} else if (bindStr != null) {
							Yaml yaml = new Yaml();
							Object bindSpec = yaml.load(bindStr);
							if (bindSpec instanceof Map) {
								Map<String, Map<String, String>> bindSpecMap = (Map<String, Map<String, String>>) bindSpec;
								Map<String, String> serviceSpecMap = bindSpecMap.get("service");
								if (serviceSpecMap != null) {
									serviceType = serviceSpecMap.get("type");
									filter = serviceSpecMap.get("filter");
								}
							}
						}
						
						if (serviceType != null) {
							BundleContext bundleContext = context.getBundleContext();
							ServiceReference<?>[] serviceReferences = bundleContext.getServiceReferences(serviceType, filter);									
							if (serviceReferences == null) {
								if (eParameter.isMany()) {
									arguments.add(ECollections.emptyEList());
								} else {
									arguments.add(null);
								}
							} else {
								if (eParameter.isMany()) {
									BasicEList<Object> services = ECollections.newBasicEList();
									for (ServiceReference<?> sr: serviceReferences) {
										services.add(bundleContext.getService(sr));
										toUnget.add(sr);
									}
									arguments.add(services);
								} else {
									if (serviceReferences.length == 0) {
										arguments.add(null);
									} else {
										ServiceReference<?> sr = serviceReferences[0];
										arguments.add(bundleContext.getService(sr));
										toUnget.add(sr);
									}
								}																				
							}
							continue;
						}
					}
					Object argument = argIdx < args.length ? args[argIdx++] : null;
					if (argument instanceof Provider && !(eParameter.getEType().getInstanceClass().isInstance(argument))) {
						argument = ((Provider<SchedulerContext<CR>, ?>) argument).get(context);
					}
					arguments.add(argument);
				}
				invoke(target, arguments);
			} finally {
				for (ServiceReference<?> sr: toUnget) {
					context.getBundleContext().ungetService(sr);
				}
			}
		} catch (Exception e) {
			context.setRollbackOnly();
			context.submit(ctx -> processException(ctx, e), context.getSubject());
		}
	}

	/**
	 * Invokes EOperation on the target object. Override as needed, e.g. to apply locks.
	 * @param target
	 * @param arguments
	 * @return
	 * @throws InvocationTargetException
	 */
	protected Object invoke(CDOObject target, EList<Object> arguments) throws Exception {
		return target.eInvoke(eOperation, arguments);
	}
	
	/**
	 * Processes eoperation return value.
	 * @param context
	 * @param result
	 */
	protected void processResult(SchedulerContext<CR> context, R result) {
		
	}
	
	/**
	 * In case of exception the transaction is marked for roll back and this method is invoked in a different transaction which allows it to make modifications
	 * in the model, which will not be rolled back. 
	 * @param e
	 */
	protected void processException(SchedulerContext<CR> context, Exception exception) {
		exception.printStackTrace();
	}

}
