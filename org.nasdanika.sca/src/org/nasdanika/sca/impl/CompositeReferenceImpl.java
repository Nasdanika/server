/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.sca.Composite;
import org.nasdanika.sca.CompositeReference;
import org.nasdanika.sca.ScaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.CompositeReferenceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeReferenceImpl extends AbstractComponentImpl implements CompositeReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite getTarget() {
		return (Composite)eGet(ScaPackage.Literals.COMPOSITE_REFERENCE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Composite newTarget) {
		eSet(ScaPackage.Literals.COMPOSITE_REFERENCE__TARGET, newTarget);
	}

} //CompositeReferenceImpl
