/**
 */
package org.nasdanika.cdo.sca.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.Composite;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.CompositeImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.CompositeImpl#getExports <em>Exports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeImpl extends ComponentImpl implements Composite {
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
	public EList<Component> getComponents() {
		return (EList<Component>)eGet(ScaPackage.Literals.COMPOSITE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Wire> getExports() {
		return (EList<Wire>)eGet(ScaPackage.Literals.COMPOSITE__EXPORTS, true);
	}

} //CompositeImpl
