/**
 */
package org.nasdanika.cdo.function.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.JavaFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getThrownExceptions <em>Thrown Exceptions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getParameterNames <em>Parameter Names</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaFunctionImpl#getCodeURL <em>Code URL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaFunctionImpl<CR, T, R> extends AbstractFunctionImpl<CR, T, R> implements JavaFunction<CR, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.JAVA_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<T>> getParameterTypes() {
		return (EList<ClassBox<T>>)eGet(FunctionPackage.Literals.JAVA_FUNCTION__PARAMETER_TYPES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ClassBox<R> getReturnType() {
		return (ClassBox<R>)eGet(FunctionPackage.Literals.JAVA_FUNCTION__RETURN_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(ClassBox<R> newReturnType) {
		eSet(FunctionPackage.Literals.JAVA_FUNCTION__RETURN_TYPE, newReturnType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ClassBox<Object>> getThrownExceptions() {
		return (EList<ClassBox<Object>>)eGet(FunctionPackage.Literals.JAVA_FUNCTION__THROWN_EXCEPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getParameterNames() {
		return (EList<String>)eGet(FunctionPackage.Literals.JAVA_FUNCTION__PARAMETER_NAMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return (String)eGet(FunctionPackage.Literals.JAVA_FUNCTION__CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		eSet(FunctionPackage.Literals.JAVA_FUNCTION__CODE, newCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodeURL() {
		return (String)eGet(FunctionPackage.Literals.JAVA_FUNCTION__CODE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeURL(String newCodeURL) {
		eSet(FunctionPackage.Literals.JAVA_FUNCTION__CODE_URL, newCodeURL);
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
	public Class<R> getReturnType(CDOTransactionContext<CR> context) {
		return getReturnType().get(context);
	}

	@Override
	protected R invoke(CDOTransactionContext<CR> context, Object[] args) throws Exception {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
} //JavaFunctionImpl
