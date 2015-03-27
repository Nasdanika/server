/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.cdo.CDOObject;

import org.nasdanika.core.Context;

import org.nasdanika.function.cdo.CDOTransactionContextFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Function</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getAbstractFunction()
 * @model abstract="true" superTypes="org.nasdanika.cdo.function.CDOTransactionContextFunction<CR, MC, T, R>" MCBounds="org.nasdanika.cdo.function.Context"
 * @extends CDOObject
 * @generated
 */
public interface AbstractFunction<CR, MC extends Context, T, R> extends CDOObject, CDOTransactionContextFunction<CR, MC, T, R> {
} // AbstractFunction
