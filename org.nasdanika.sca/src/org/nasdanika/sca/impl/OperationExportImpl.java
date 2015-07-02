/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.sca.InvocationTarget;
import org.nasdanika.sca.OperationExport;
import org.nasdanika.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Export</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.OperationExportImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.OperationExportImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.OperationExportImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.OperationExportImpl#getInvocationTarget <em>Invocation Target</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.OperationExportImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationExportImpl extends CDOObjectImpl implements OperationExport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationExportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.OPERATION_EXPORT;
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
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfiguration() {
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(String newConfiguration) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationTarget getInvocationTarget() {
		return (InvocationTarget)eGet(ScaPackage.Literals.INVOCATION_SOURCE__INVOCATION_TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvocationTarget(InvocationTarget newInvocationTarget) {
		eSet(ScaPackage.Literals.INVOCATION_SOURCE__INVOCATION_TARGET, newInvocationTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBindings() {
		return (String)eGet(ScaPackage.Literals.INVOCATION_SOURCE__BINDINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindings(String newBindings) {
		eSet(ScaPackage.Literals.INVOCATION_SOURCE__BINDINGS, newBindings);
	}

} //OperationExportImpl
