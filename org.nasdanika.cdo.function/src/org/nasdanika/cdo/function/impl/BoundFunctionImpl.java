/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.function.Function;
import org.nasdanika.function.FunctionException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.BoundFunctionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.BoundFunctionImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundFunctionImpl<CR, T, R> extends AbstractFunctionImpl<CR, T, R> implements BoundFunction<CR, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.BOUND_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(FunctionPackage.Literals.BOUND_FUNCTION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(FunctionPackage.Literals.BOUND_FUNCTION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<Integer, EObject> getBindings() {
		return (EMap<Integer, EObject>)eGet(FunctionPackage.Literals.BOUND_FUNCTION__BINDINGS, true);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR> context) {
		try {
			EObject target = getTarget();		
			try (Function<CDOTransactionContext<CR>, ?, ?> targetFunction = (Function<CDOTransactionContext<CR>, ?, ?>) BoxUtil.unbox(target, context)) { 
				Class<?>[] targetParameterTypes = targetFunction.getParameterTypes(context);
				EMap<Integer, EObject> bindings = getBindings();
				Class<?>[] ret = new Class<?>[targetParameterTypes.length - bindings.size()];
				for (int i=0, j=0; i<targetParameterTypes.length; ++i) {
					if (!bindings.containsKey(i)) {
						ret[j++] = targetParameterTypes[i];
					}
				}
				return ret;
			}
		} catch (Exception e) {
			throw new FunctionException(e);
		}
	}

	@Override
	public Class<R> getReturnType(CDOTransactionContext<CR> context) {
		try {
			EObject target = getTarget();		
			try (@SuppressWarnings({ "unchecked" })	Function<CDOTransactionContext<CR>, ?, R> targetFunction = (Function<CDOTransactionContext<CR>, ?, R>) BoxUtil.unbox(target, context)) {
				return targetFunction.getReturnType(context);
			}
		} catch (Exception e) {
			throw new FunctionException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public R execute(CDOTransactionContext<CR> context, T... args) throws Exception {
		EObject target = getTarget();		
		try (Function<CDOTransactionContext<CR>, T, R> targetFunction = (Function<CDOTransactionContext<CR>, T, R>) BoxUtil.unbox(target, context)) {				
			Class<?>[] targetParameterTypes = targetFunction.getParameterTypes(context);
			T[] targetArguments = (T[]) new Object[targetParameterTypes.length]; // This line may force T always be Object.
			EMap<Integer, EObject> bindings = getBindings();
			for (int i=0, j=0; i<targetParameterTypes.length; ++i) {
				if (bindings.containsKey(i)) {
					EObject binding = bindings.get(new Integer(i));
					targetArguments[i] = (T) BoxUtil.unbox(binding, context);
				} else {
					targetArguments[i] = args[j++];
				}
			}
			return targetFunction.execute(context, targetArguments);
		}
	}
	
	@Override
	protected R invoke(CDOTransactionContext<CR> context, Object[] args) throws Exception {
		throw new UnsupportedOperationException("Shall never happen - execute() is overridden");
	}

} //BoundFunctionImpl
