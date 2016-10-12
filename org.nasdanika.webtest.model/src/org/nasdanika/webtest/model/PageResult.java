/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Result of page class interactions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.PageResult#getWebElements <em>Web Elements</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.PageResult#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.PageResult#isDelegate <em>Delegate</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.PageResult#getMethods <em>Methods</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getPageResult()
 * @model
 * @generated
 */
public interface PageResult extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Web Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.WebElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Information about the page web elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Web Elements</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getPageResult_WebElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<WebElement> getWebElements();

	/**
	 * Returns the value of the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 'true' if page class is a proxy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Proxy</em>' attribute.
	 * @see #setProxy(boolean)
	 * @see org.nasdanika.webtest.model.ModelPackage#getPageResult_Proxy()
	 * @model
	 * @generated
	 */
	boolean isProxy();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.PageResult#isProxy <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy</em>' attribute.
	 * @see #isProxy()
	 * @generated
	 */
	void setProxy(boolean value);

	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if actor class is a proxy.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Delegate</em>' attribute.
	 * @see #setDelegate(boolean)
	 * @see org.nasdanika.webtest.model.ModelPackage#getPageResult_Delegate()
	 * @model
	 * @generated
	 */
	boolean isDelegate();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.PageResult#isDelegate <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate</em>' attribute.
	 * @see #isDelegate()
	 * @generated
	 */
	void setDelegate(boolean value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.webtest.model.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.nasdanika.webtest.model.ModelPackage#getPageResult_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getMethods();

} // PageResult
