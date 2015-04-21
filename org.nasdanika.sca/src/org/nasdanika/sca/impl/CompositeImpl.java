/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.sca.AbstractComponent;
import org.nasdanika.sca.Composite;
import org.nasdanika.sca.PropertyImport;
import org.nasdanika.sca.ReferenceImport;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.ServiceExport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getExportedServices <em>Exported Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImportedReferences <em>Imported References</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImportedProperties <em>Imported Properties</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImplementationClass <em>Implementation Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeImpl extends AbstractComponentImpl implements Composite {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractComponent> getComponents() {
		return (EList<AbstractComponent>)eGet(ScaPackage.Literals.COMPOSITE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceExport> getExportedServices() {
		return (EList<ServiceExport>)eGet(ScaPackage.Literals.COMPOSITE__EXPORTED_SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ReferenceImport> getImportedReferences() {
		return (EList<ReferenceImport>)eGet(ScaPackage.Literals.COMPOSITE__IMPORTED_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PropertyImport> getImportedProperties() {
		return (EList<PropertyImport>)eGet(ScaPackage.Literals.COMPOSITE__IMPORTED_PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.sca.Composite getImplementation() {
		return (org.nasdanika.cdo.sca.Composite)eGet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(org.nasdanika.cdo.sca.Composite newImplementation) {
		eSet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationClass() {
		return (EClass)eGet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(EClass newImplementationClass) {
		eSet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION_CLASS, newImplementationClass);
	}

} //CompositeImpl
