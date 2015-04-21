/**
 */
package org.nasdanika.sca;

import org.eclipse.emf.ecore.EClass;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.Component#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.Component#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.nasdanika.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends AbstractComponent {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' reference.
	 * @see #setImplementation(org.nasdanika.cdo.sca.Component)
	 * @see org.nasdanika.sca.ScaPackage#getComponent_Implementation()
	 * @model
	 * @generated
	 */
	org.nasdanika.cdo.sca.Component getImplementation();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.Component#getImplementation <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(org.nasdanika.cdo.sca.Component value);

	/**
	 * Returns the value of the '<em><b>Implementation Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Class</em>' reference.
	 * @see #setImplementationClass(EClass)
	 * @see org.nasdanika.sca.ScaPackage#getComponent_ImplementationClass()
	 * @model
	 * @generated
	 */
	EClass getImplementationClass();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.Component#getImplementationClass <em>Implementation Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class</em>' reference.
	 * @see #getImplementationClass()
	 * @generated
	 */
	void setImplementationClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Immediately Activated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediately Activated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediately Activated</em>' attribute.
	 * @see #setImmediatelyActivated(boolean)
	 * @see org.nasdanika.sca.ScaPackage#getComponent_ImmediatelyActivated()
	 * @model
	 * @generated
	 */
	boolean isImmediatelyActivated();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.Component#isImmediatelyActivated <em>Immediately Activated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediately Activated</em>' attribute.
	 * @see #isImmediatelyActivated()
	 * @generated
	 */
	void setImmediatelyActivated(boolean value);

} // Component
