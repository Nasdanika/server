/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.sca.Component;
import org.nasdanika.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends AbstractComponentImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.sca.Component getImplementation() {
		return (org.nasdanika.cdo.sca.Component)eGet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(org.nasdanika.cdo.sca.Component newImplementation) {
		eSet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationClass() {
		return (EClass)eGet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(EClass newImplementationClass) {
		eSet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION_CLASS, newImplementationClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediatelyActivated() {
		return (Boolean)eGet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediatelyActivated(boolean newImmediatelyActivated) {
		eSet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, newImmediatelyActivated);
	}

} //ComponentImpl
