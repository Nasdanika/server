/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.ecore.EFactory;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.function.FunctionPackage
 * @generated
 */
public interface FunctionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionFactory eINSTANCE = org.nasdanika.cdo.function.impl.FunctionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bound Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> BoundFunction<CR, MC, T, R> createBoundFunction();

	/**
	 * Returns a new object of class '<em>CDO Service Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CDO Service Binding</em>'.
	 * @generated
	 */
	CDOServiceBinding createCDOServiceBinding();

	/**
	 * Returns a new object of class '<em>Context Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context Argument</em>'.
	 * @generated
	 */
	ContextArgument createContextArgument();

	/**
	 * Returns a new object of class '<em>Command Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> CommandFunction<CR, MC, T, R> createCommandFunction();

	/**
	 * Returns a new object of class '<em>Java Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> JavaFunction<CR, MC, T, R> createJavaFunction();

	/**
	 * Returns a new object of class '<em>Java Script Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Script Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> JavaScriptFunction<CR, MC, T, R> createJavaScriptFunction();

	/**
	 * Returns a new object of class '<em>Object Method Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Method Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> ObjectMethodFunction<CR, MC, T, R> createObjectMethodFunction();

	/**
	 * Returns a new object of class '<em>Service Method Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Method Function</em>'.
	 * @generated
	 */
	<CR, MC extends Context, T, R> ServiceMethodFunction<CR, MC, T, R> createServiceMethodFunction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctionPackage getFunctionPackage();

} //FunctionFactory
