/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.Composite#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.Composite#getExports <em>Exports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.sca.ScaPackage#getComposite()
 * @model
 * @generated
 */
public interface Composite extends Component {

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.sca.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see org.nasdanika.cdo.sca.ScaPackage#getComposite_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.sca.Wire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exports</em>' containment reference list.
	 * @see org.nasdanika.cdo.sca.ScaPackage#getComposite_Exports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Wire> getExports();
} // Composite
