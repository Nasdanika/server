/**
 */
package org.nasdanika.cdo.security;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Permission allows/denies a principal to perform an action on a model element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getAction <em>Action</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#isAllow <em>Allow</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getComment <em>Comment</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Permission extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Allow</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, action is allowed. Otherwise it is denied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Allow</em>' attribute.
	 * @see #setAllow(boolean)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_Allow()
	 * @model default="true"
	 * @generated
	 */
	boolean isAllow();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#isAllow <em>Allow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow</em>' attribute.
	 * @see #isAllow()
	 * @generated
	 */
	void setAllow(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permission effective start date. Can be ``null``.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_StartDate()
	 * @model
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permission effective end date, can be ``null``.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_EndDate()
	 * @model
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permission's action.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Condition is a boolean XPath expression evaluated by [JXPath](http://commons.apache.org/proper/commons-jxpath/).
	 * 
	 * The expression is evaluated in the context of the target object with the following variables:
	 * 
	 * * ``context``
	 * * ``environment``
	 * * ``action``
	 * * ``qualifier``
	 * * ``permission``
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * @param context 
	 * @param action 
	 * @param qualifier 
	 * @param environment 
	 * <!-- end-model-doc -->
	 * @model dataType="org.nasdanika.cdo.security.AccessDecision" contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	AccessDecision authorize(Context context, String action, String qualifier, Map<String, Object> environment);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Principal getPrincipal();

} // Permission
