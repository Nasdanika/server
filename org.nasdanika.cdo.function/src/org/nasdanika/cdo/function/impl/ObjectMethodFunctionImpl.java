/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.ObjectMethodFunction;
import org.nasdanika.core.Context;
import org.nasdanika.function.FunctionException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Method Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.ObjectMethodFunctionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectMethodFunctionImpl<CR, MC extends Context, T, R> extends AbstractFunctionImpl<CR, MC, T, R> implements ObjectMethodFunction<CR, MC, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectMethodFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.OBJECT_METHOD_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return (String)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__METHOD_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		eSet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__METHOD_NAME, newMethodName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<T>> getParameterTypes() {
		return (EList<ClassBox<T>>)eGet(FunctionPackage.Literals.OBJECT_METHOD_FUNCTION__PARAMETER_TYPES, true);
	}
	
	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR, MC> context) {
		EList<ClassBox<T>> ptl = getParameterTypes();
		Class<?>[] ret = new Class<?>[ptl.size()];
		int idx = 0;
		for (ClassBox<T> pt: ptl) {
			ret[idx++] = pt.get(context);
		}
		return ret;
	}
	
	@Override
	public Class<?> getReturnType(CDOTransactionContext<CR, MC> context) {
		Object target = BoxUtil.unbox(getTarget(), context);
		try {
			return target.getClass().getMethod(getMethodName(), getParameterTypes(context)).getReturnType();
		} catch (Exception e) {
			throw new FunctionException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected R invoke(CDOTransactionContext<CR, MC> context, Object[] args) throws Exception {
		Object target = BoxUtil.unbox(getTarget(), context);
		return (R) target.getClass().getMethod(getMethodName(), getParameterTypes(context)).invoke(target, args);
	}
	
} //ObjectMethodFunctionImpl
