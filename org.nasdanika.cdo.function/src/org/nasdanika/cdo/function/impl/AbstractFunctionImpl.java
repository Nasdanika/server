/**
 */
package org.nasdanika.cdo.function.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.function.AbstractFunction;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.ContextArgument;
import org.nasdanika.cdo.function.FunctionFactory;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.core.Context;
import org.nasdanika.function.Function;
import org.nasdanika.function.FunctionException;
import org.nasdanika.function.ServiceBinding;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractFunctionImpl<CR, MC extends Context, T, R> extends CDOObjectImpl implements AbstractFunction<CR, MC, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.ABSTRACT_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}
	
	@Override
	public Function<CDOTransactionContext<CR, MC>, T, R> bind(CDOTransactionContext<CR, MC> context, Map<Integer, Object> bindings) {
		if (bindings.isEmpty()) {
			return this;
		}
		BoundFunction<CR, MC, T, R> ret = FunctionFactory.eINSTANCE.createBoundFunction();		
		try {
			ret.setTarget(BoxUtil.box(this, context));
			for (Entry<Integer, Object> be: bindings.entrySet()) {
				ret.getBindings().put(be.getKey(), BoxUtil.box(be.getValue(), context));
			}
		} catch (Exception e) {
			throw new FunctionException(e);
		}
		return ret;
	}
	
	@Override
	public Function<CDOTransactionContext<CR, MC>, T, R> bind(CDOTransactionContext<CR, MC> context, Object... bindings) {
		Map<Integer, Object> mBindings = new HashMap<Integer, Object>();
		for (int i=0; i<bindings.length; ++i) {
			mBindings.put(i, bindings[i]);
		}
		return bind(context, mBindings);
	}
	
	@Override
	public R execute(CDOTransactionContext<CR, MC> context, @SuppressWarnings("unchecked") T... args) throws Exception {
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		Class<?>[] parameterTypes = getParameterTypes(context);
		List<ServiceReference<?>> toUnget = new ArrayList<>();
		Object[] arguments = new Object[args.length];
		for (int i=0; i<args.length; ++i) {
			if (args[i] instanceof ContextArgument) {
				arguments[i] = context.adapt(parameterTypes[i]);
			} else if (args[i] instanceof ServiceBinding) {
				ServiceBinding sb = (ServiceBinding) args[i];
				ServiceReference<?>[] refs = bundleContext.getServiceReferences(sb.getServiceType(), sb.getFilter());
				if (refs!=null) {
					for (ServiceReference<?> ref: refs) {
						Object service = bundleContext.getService(ref);
						if (service!=null) {
							arguments[i] = service;
							toUnget.add(ref);
							break;
						}
					}
				}				
			} else {
				arguments[i] = args[i];
			}
		}
		try {
			return invoke(context, arguments);
		} finally {
			for (ServiceReference<?> sr: toUnget) {
				bundleContext.ungetService(sr);
			}
		}
	}
	
	/**
	 * Invoked by execute() after resolving service references and adapting context arguments. 
	 * @param context
	 * @param args
	 * @return
	 * @throws Exception
	 */
	protected abstract R invoke(CDOTransactionContext<CR, MC> context, Object[] args) throws Exception;
	
	@Override
	public void close() throws Exception {
		// NOP		
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}

} //AbstractFunctionImpl
