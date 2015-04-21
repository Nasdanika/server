/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.sca.Reference;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.WireTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.ReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ReferenceImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ReferenceImpl#getWireTarget <em>Wire Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends CDOObjectImpl implements Reference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ScaPackage.Literals.WIREABLE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ScaPackage.Literals.WIREABLE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfiguration() {
		return (String)eGet(ScaPackage.Literals.WIREABLE__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(String newConfiguration) {
		eSet(ScaPackage.Literals.WIREABLE__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireTarget getWireTarget() {
		return (WireTarget)eGet(ScaPackage.Literals.WIRE_SOURCE__WIRE_TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWireTarget(WireTarget newWireTarget) {
		eSet(ScaPackage.Literals.WIRE_SOURCE__WIRE_TARGET, newWireTarget);
	}

} //ReferenceImpl
