/**
 */
package org.nasdanika.cdo.boxing.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.FieldEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.FieldEntryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.FieldEntryImpl#getDeclaringClass <em>Declaring Class</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.FieldEntryImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldEntryImpl extends CDOObjectImpl implements FieldEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FieldEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.FIELD_ENTRY;
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
		return (String)eGet(BoxingPackage.Literals.FIELD_ENTRY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BoxingPackage.Literals.FIELD_ENTRY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeclaringClass() {
		return (String)eGet(BoxingPackage.Literals.FIELD_ENTRY__DECLARING_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringClass(String newDeclaringClass) {
		eSet(BoxingPackage.Literals.FIELD_ENTRY__DECLARING_CLASS, newDeclaringClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getValue() {
		return (EObject)eGet(BoxingPackage.Literals.FIELD_ENTRY__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(EObject newValue) {
		eSet(BoxingPackage.Literals.FIELD_ENTRY__VALUE, newValue);
	}

} //FieldEntryImpl
