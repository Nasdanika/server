/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Information about an interactive page web element, e.g. a link or a button.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.WebElement#getLocators <em>Locators</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getWebElement()
 * @model
 * @generated
 */
public interface WebElement extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Locators</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.Locator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Web element locators.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Locators</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getWebElement_Locators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Locator> getLocators();

} // WebElement
