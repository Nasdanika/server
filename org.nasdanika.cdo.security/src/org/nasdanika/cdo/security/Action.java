/**
 */
package org.nasdanika.cdo.security;

import java.util.Map;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <html>Action defined for instances of given EClass</html>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Action#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getTargetNamespaceURI <em>Target Namespace URI</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#isGrantable <em>Grantable</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getImplies <em>Implies</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getImpliedBy <em>Implied By</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getPathPatterns <em>Path Patterns</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getAction()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Action extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Target Namespace URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Namespace URI of the target class' package.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Namespace URI</em>' attribute.
	 * @see #setTargetNamespaceURI(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_TargetNamespaceURI()
	 * @model
	 * @generated
	 */
	String getTargetNamespaceURI();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getTargetNamespaceURI <em>Target Namespace URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Namespace URI</em>' attribute.
	 * @see #getTargetNamespaceURI()
	 * @generated
	 */
	void setTargetNamespaceURI(String value);

	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Name of the target class.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' attribute.
	 * @see #setTargetClass(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_TargetClass()
	 * @model
	 * @generated
	 */
	String getTargetClass();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getTargetClass <em>Target Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' attribute.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(String value);

	/**
	 * Returns the value of the '<em><b>Grantable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Only grantable actions can have permission associations. Grantable action corresponds to a role. A non-grantable action shall have an impliedBy relationship with at least one grantable action.
	 * Use of grantable actions allows to use fine-grained action permission checks at development time and define coarse-grained roles (grantable actions implying other actions) at runtime time.
	 * </html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Grantable</em>' attribute.
	 * @see #setGrantable(boolean)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Grantable()
	 * @model
	 * @generated
	 */
	boolean isGrantable();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#isGrantable <em>Grantable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grantable</em>' attribute.
	 * @see #isGrantable()
	 * @generated
	 */
	void setGrantable(boolean value);

	/**
	 * Returns the value of the '<em><b>Implies</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Action}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.cdo.security.Action#getImpliedBy <em>Implied By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>References actions which are explicitly implied by this action. Actions are also implicitly implied by using action naming convention with dot as a separator - e.g. <code>myAction</code> implies <code>myAction.mySubAction</code>.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implies</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Implies()
	 * @see org.nasdanika.cdo.security.Action#getImpliedBy
	 * @model opposite="impliedBy"
	 * @generated
	 */
	EList<Action> getImplies();

	/**
	 * Returns the value of the '<em><b>Implied By</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Action}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.cdo.security.Action#getImplies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Opposite to <code>implies</code>.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implied By</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_ImpliedBy()
	 * @see org.nasdanika.cdo.security.Action#getImplies
	 * @model opposite="implies"
	 * @generated
	 */
	EList<Action> getImpliedBy();

	/**
	 * Returns the value of the '<em><b>Path Patterns</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Path patterns allow to compute permissions using containment path, i.e. container object may define actions on contained objects. Containment path is computed from reference names, e.g. path of a customer account relative to the customer object would be <code>/accounts</code>, and relative to the system of records would be <code>/customers/accounts</code>. Container object's path is '/', If pathPatterns is empty then it is assumed that the action applies to the target object, i.e. that there is a single pattern <code>/</code>.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path Patterns</em>' attribute list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_PathPatterns()
	 * @model
	 * @generated
	 */
	EList<String> getPathPatterns();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	boolean match(Context context, String action, String path, Map<String, Object> environment);

} // Action
