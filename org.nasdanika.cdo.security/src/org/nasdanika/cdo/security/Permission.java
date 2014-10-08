/**
 */
package org.nasdanika.cdo.security;

import java.util.Date;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <html>Permission is an association of a repository object with a principal.</html>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Permission#isAllow <em>Allow</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#isWithGrantOption <em>With Grant Option</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Permission#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission()
 * @model
 * @generated
 */
public interface Permission extends ActionKey {
	/**
	 * Returns the value of the '<em><b>Allow</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>If true, action is allowed. Otherwise it is denied.</html>
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
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Target object.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>With Grant Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>If true, user can grant given action to other users.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>With Grant Option</em>' attribute.
	 * @see #setWithGrantOption(boolean)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPermission_WithGrantOption()
	 * @model
	 * @generated
	 */
	boolean isWithGrantOption();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Permission#isWithGrantOption <em>With Grant Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Grant Option</em>' attribute.
	 * @see #isWithGrantOption()
	 * @generated
	 */
	void setWithGrantOption(boolean value);

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Permission effective start date. Can be null.</html>
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
	 * <html>Permission effective end date, can be null.</html>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.security.AccessDecision" securityPolicyType="org.nasdanika.cdo.security.SecurityPolicy" contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	AccessDecision authorize(SecurityPolicy securityPolicy, Context context, Object target, String action, String path, Map<String, Object> environment);

} // Permission
