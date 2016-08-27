/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Captures operation argument value and type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.OperationArgument#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationArgument#isMasked <em>Masked</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.OperationArgument#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getOperationArgument()
 * @model
 * @generated
 */
public interface OperationArgument extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(EObject)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationArgument_Value()
	 * @model containment="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationArgument#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Argument type, java.lang.String for masked parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationArgument_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationArgument#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Masked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True for masked parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Masked</em>' attribute.
	 * @see #setMasked(boolean)
	 * @see org.nasdanika.webtest.model.ModelPackage#getOperationArgument_Masked()
	 * @model
	 * @generated
	 */
	boolean isMasked();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.OperationArgument#isMasked <em>Masked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Masked</em>' attribute.
	 * @see #isMasked()
	 * @generated
	 */
	void setMasked(boolean value);

} // OperationArgument
