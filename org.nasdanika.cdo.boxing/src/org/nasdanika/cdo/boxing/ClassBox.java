/**
 */
package org.nasdanika.cdo.boxing;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.ClassBox#getBundleName <em>Bundle Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.ClassBox#getBundleVersion <em>Bundle Version</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.ClassBox#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getClassBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.eclipse.emf.ecore.EJavaClass<T>, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface ClassBox<T> extends Box<Class<T>, Context> {

	/**
	 * Returns the value of the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Name</em>' attribute.
	 * @see #setBundleName(String)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getClassBox_BundleName()
	 * @model
	 * @generated
	 */
	String getBundleName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.ClassBox#getBundleName <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Name</em>' attribute.
	 * @see #getBundleName()
	 * @generated
	 */
	void setBundleName(String value);

	/**
	 * Returns the value of the '<em><b>Bundle Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Version</em>' attribute.
	 * @see #setBundleVersion(String)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getClassBox_BundleVersion()
	 * @model
	 * @generated
	 */
	String getBundleVersion();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.ClassBox#getBundleVersion <em>Bundle Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Version</em>' attribute.
	 * @see #getBundleVersion()
	 * @generated
	 */
	void setBundleVersion(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getClassBox_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.ClassBox#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);
} // ClassBox
