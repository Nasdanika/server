/**
 */
package org.nasdanika.cdo.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.sca.PropertySetting;
import org.nasdanika.cdo.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.PropertySettingImpl#getTargetName <em>Target Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertySettingImpl extends CDOObjectImpl implements PropertySetting {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.PROPERTY_SETTING;
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
	public String getTargetName() {
		return (String)eGet(ScaPackage.Literals.PROPERTY_SETTING__TARGET_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetName(String newTargetName) {
		eSet(ScaPackage.Literals.PROPERTY_SETTING__TARGET_NAME, newTargetName);
	}

} //PropertySettingImpl
