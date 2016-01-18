/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Locator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Web element locator.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.Locator#getHow <em>How</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.Locator#getUsing <em>Using</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getLocator()
 * @model
 * @generated
 */
public interface Locator extends EObject {
	/**
	 * Returns the value of the '<em><b>How</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>How</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates how web element should be located, e.g. by ID, by CSS, or by XPATH.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>How</em>' attribute.
	 * @see #setHow(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getLocator_How()
	 * @model
	 * @generated
	 */
	String getHow();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.Locator#getHow <em>How</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>How</em>' attribute.
	 * @see #getHow()
	 * @generated
	 */
	void setHow(String value);

	/**
	 * Returns the value of the '<em><b>Using</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Locator value, e.g. CSS path if value of 'how' is 'CSS'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Using</em>' attribute.
	 * @see #setUsing(String)
	 * @see org.nasdanika.webtest.model.ModelPackage#getLocator_Using()
	 * @model
	 * @generated
	 */
	String getUsing();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.Locator#getUsing <em>Using</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Using</em>' attribute.
	 * @see #getUsing()
	 * @generated
	 */
	void setUsing(String value);

} // Locator
