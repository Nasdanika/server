/**
 */
package org.nasdanika.cdo.sca.impl;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.WireImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.WireImpl#isTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.WireImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.WireImpl#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.WireImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WireImpl extends CDOObjectImpl implements Wire {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.WIRE;
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
		return (String)eGet(ScaPackage.Literals.WIRE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ScaPackage.Literals.WIRE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypeName() {
		return (Boolean)eGet(ScaPackage.Literals.WIRE__TYPE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(boolean newTypeName) {
		eSet(ScaPackage.Literals.WIRE__TYPE_NAME, newTypeName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getTarget() {
		return (Component)eGet(ScaPackage.Literals.WIRE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Component newTarget) {
		eSet(ScaPackage.Literals.WIRE__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetName() {
		return (String)eGet(ScaPackage.Literals.WIRE__TARGET_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetName(String newTargetName) {
		eSet(ScaPackage.Literals.WIRE__TARGET_NAME, newTargetName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, EObject> getProperties() {
		return (EMap<String, EObject>)eGet(ScaPackage.Literals.WIRE__PROPERTIES, true);
	}

} //WireImpl
