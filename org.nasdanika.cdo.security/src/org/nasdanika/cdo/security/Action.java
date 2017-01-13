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
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Action#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#isGrantable <em>Grantable</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getImplies <em>Implies</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getImpliedBy <em>Implied By</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getCategory <em>Category</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Action#getChildren <em>Children</em>}</li>
 * </ul>
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Action name, which is used as a pattern to match ``<action>:<qualifier>`` string.  ``*`` matches any character sequence.
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
	 * <!-- begin-model-doc -->
	 * Action description.
	 * <!-- end-model-doc -->
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
	 * Returns the value of the '<em><b>Grantable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only grantable actions can have permission associations. 
	 * Grantable action corresponds to a user story or to a role. 
	 * A non-grantable action shall have an impliedBy relationship with at least one grantable action or be contained in a grantable action.
	 * Use of grantable actions allows to use fine-grained action permission checks at development time and define coarse-grained user stories (grantable actions implying or containing other actions) at runtime time.
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
	 * References actions which are explicitly implied by this action. 
	 * 
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
	 * Opposite to ``implies``.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implied By</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_ImpliedBy()
	 * @see org.nasdanika.cdo.security.Action#getImplies
	 * @model opposite="implies"
	 * @generated
	 */
	EList<Action> getImpliedBy();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Categories allow to group related actions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Category()
	 * @model
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Action#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Child actions, implicitly implied by the parent action.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getAction_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Matches this action to action string, qualifier in a given context and environment.
	 * The default implementation constructs a string ``<action>:<qualifier>`` and uses name as a simplified glob pattern to match the string.
	 * 
	 * For example:
	 * 
	 * * ``*:*`` matches any request.
	 * * ``read:description`` matches action ``read`` for the qualifier ``descriptor``.
	 * * ``*:accounts`` matches any action for the ``accounts`` qualifier.
	 * @param context Matching context, e.g. ``CDOTransactionContext``.
	 * @param action Action name, a verb. E.g. ``read`` or ``create``
	 * @param qualifier
	 *   Qualifier, a noun, e.g. ``description`` for a description attribute or ``doSomething(java.lang.String)`` for an operation.
	 *   Qualifier is typically a feature/operation path.
	 * @param environment
	 *   Environment can be used to parameterize conditional actions. 
	 *   For example an application can define an action class ``TransferFunds`` with ``amountLimit`` ``BigDecimal`` attribute and match logic comparing ``amount`` key of the environment to the ``amount`` attribute of the action and matching only if the key is equal or greater than the attribute.. 
	 *   Then the application model may contain ``largeTransfer`` action instance with amount set to, say, ``10000``. Permission to execute this action then can be allowed to denied  to some principals.
	 *   
	 * <!-- end-model-doc -->
	 * @model contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	boolean match(Context context, String action, String qualifier, Map<String, Object> environment);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a permission for this action. 
	 * Subclasses may customize permissions created for actions. 
	 * E.g. ``transferFunds`` action may create a conditional permission
	 * wich checks transfer amount and matches only if the amount is less or greater
	 * than a specified limit.
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Permission createPermission();

} // Action
