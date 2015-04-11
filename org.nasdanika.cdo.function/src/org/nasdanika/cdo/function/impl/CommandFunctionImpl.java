/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.function.CommandFunction;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.core.Command;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.CommandFunctionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.CommandFunctionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.CommandFunctionImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandFunctionImpl<CR, T, R> extends AbstractFunctionImpl<CR, T, R> implements CommandFunction<CR, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.COMMAND_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(FunctionPackage.Literals.COMMAND_FUNCTION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(FunctionPackage.Literals.COMMAND_FUNCTION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<T>> getParameterTypes() {
		return (EList<ClassBox<T>>)eGet(FunctionPackage.Literals.COMMAND_FUNCTION__PARAMETER_TYPES, true);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ClassBox<R> getReturnType() {
		return (ClassBox<R>)eGet(FunctionPackage.Literals.COMMAND_FUNCTION__RETURN_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(ClassBox<R> newReturnType) {
		eSet(FunctionPackage.Literals.COMMAND_FUNCTION__RETURN_TYPE, newReturnType);
	}

	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR> context) {
		EList<ClassBox<T>> ptl = getParameterTypes();
		Class<?>[] ret = new Class<?>[ptl.size()];
		int idx = 0;
		for (ClassBox<T> pt: ptl) {
			ret[idx++] = pt.get(context);
		}
		return ret;
	}
	
	@Override
	public Class<?> getReturnType(CDOTransactionContext<CR> context) {
		return getReturnType().get(context);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected R invoke(CDOTransactionContext<CR> context, Object[] args) throws Exception {
		return ((Command<CDOTransactionContext<CR>,T,R>) BoxUtil.unbox(getTarget(), context)).execute(context, (T[]) args);
	}	

} //CommandFunctionImpl
