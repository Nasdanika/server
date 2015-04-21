/**
 */
package org.nasdanika.sca;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.Composite#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.sca.Composite#getExportedServices <em>Exported Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.Composite#getImportedReferences <em>Imported References</em>}</li>
 *   <li>{@link org.nasdanika.sca.Composite#getImportedProperties <em>Imported Properties</em>}</li>
 *   <li>{@link org.nasdanika.sca.Composite#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.Composite#getImplementationClass <em>Implementation Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getComposite()
 * @model
 * @generated
 */
public interface Composite extends AbstractComponent {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.AbstractComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getComposite_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractComponent> getComponents();

	/**
	 * Returns the value of the '<em><b>Exported Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.ServiceExport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported Services</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getComposite_ExportedServices()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceExport> getExportedServices();

	/**
	 * Returns the value of the '<em><b>Imported References</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.ReferenceImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported References</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getComposite_ImportedReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceImport> getImportedReferences();

	/**
	 * Returns the value of the '<em><b>Imported Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.sca.PropertyImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Properties</em>' containment reference list.
	 * @see org.nasdanika.sca.ScaPackage#getComposite_ImportedProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyImport> getImportedProperties();

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' reference.
	 * @see #setImplementation(org.nasdanika.cdo.sca.Composite)
	 * @see org.nasdanika.sca.ScaPackage#getComposite_Implementation()
	 * @model
	 * @generated
	 */
	org.nasdanika.cdo.sca.Composite getImplementation();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.Composite#getImplementation <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(org.nasdanika.cdo.sca.Composite value);

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
	 * @see org.nasdanika.sca.ScaPackage#getComposite_ImplementationClass()
	 * @model
	 * @generated
	 */
	EClass getImplementationClass();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.Composite#getImplementationClass <em>Implementation Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Class</em>' reference.
	 * @see #getImplementationClass()
	 * @generated
	 */
	void setImplementationClass(EClass value);

} // Composite
