/**
 */
package org.nasdanika.cdo.function.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.function.AbstractFunction;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.FunctionFactory;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.core.Context;
import org.nasdanika.function.Function;
import org.nasdanika.function.FunctionException;

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
	public R execute(CDOTransactionContext<CR, MC> context, T... args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Invoked by execute() after resolving service references and adapting context arguments. 
	 * @param context
	 * @param args
	 * @return
	 * @throws Exception
	 */
	protected abstract R invoke(CDOTransactionContext<CR, MC> context, Object[] args) throws Exception;

} //AbstractFunctionImpl
