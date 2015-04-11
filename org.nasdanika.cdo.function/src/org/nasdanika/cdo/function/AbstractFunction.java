/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.Context;
import org.nasdanika.function.cdo.CDOTransactionContextFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.AbstractFunction#getRunAs <em>Run As</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getAbstractFunction()
 * @model abstract="true" superTypes="org.nasdanika.cdo.function.CDOTransactionContextFunction<CR, MC, T, R>" MCBounds="org.nasdanika.cdo.function.Context"
 * @extends CDOObject
 * @generated
 */
public interface AbstractFunction<CR, MC extends Context, T, R> extends CDOObject, CDOTransactionContextFunction<CR, MC, T, R> {

	/**
	 * Returns the value of the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run As</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run As</em>' reference.
	 * @see #setRunAs(Principal)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getAbstractFunction_RunAs()
	 * @model
	 * @generated
	 */
	Principal getRunAs();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.AbstractFunction#getRunAs <em>Run As</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run As</em>' reference.
	 * @see #getRunAs()
	 * @generated
	 */
	void setRunAs(Principal value);
} // AbstractFunction
