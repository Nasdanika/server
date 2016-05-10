/**
 */
package org.nasdanika.osgi.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.Bundle#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Bundle#getSymbolicName <em>Symbolic Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Bundle#getVersion <em>Version</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Bundle#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.Bundle#getRequiredBy <em>Required By</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.osgi.model.ModelPackage#getBundle()
 * @model
 * @generated
 */
public interface Bundle extends Element {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getBundle_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Name</em>' attribute.
	 * @see #setSymbolicName(String)
	 * @see org.nasdanika.osgi.model.ModelPackage#getBundle_SymbolicName()
	 * @model
	 * @generated
	 */
	String getSymbolicName();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.Bundle#getSymbolicName <em>Symbolic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbolic Name</em>' attribute.
	 * @see #getSymbolicName()
	 * @generated
	 */
	void setSymbolicName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.nasdanika.osgi.model.ModelPackage#getBundle_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.nasdanika.osgi.model.Bundle#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.Bundle}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.osgi.model.Bundle#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getBundle_Requires()
	 * @see org.nasdanika.osgi.model.Bundle#getRequiredBy
	 * @model opposite="requiredBy"
	 * @generated
	 */
	EList<Bundle> getRequires();

	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.osgi.model.Bundle}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.osgi.model.Bundle#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference list.
	 * @see org.nasdanika.osgi.model.ModelPackage#getBundle_RequiredBy()
	 * @see org.nasdanika.osgi.model.Bundle#getRequires
	 * @model opposite="requires"
	 * @generated
	 */
	EList<Bundle> getRequiredBy();

} // Bundle
