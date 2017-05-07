/**
 */
package org.nasdanika.cdo.security;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.security.SecurityFactory
 * @model kind="package"
 * @generated
 */
public interface SecurityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "security";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.security";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.security";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SecurityPackage eINSTANCE = org.nasdanika.cdo.security.impl.SecurityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.Realm <em>Realm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.Realm
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getRealm()
	 * @generated
	 */
	int REALM = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Guest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM__GUEST = 1;

	/**
	 * The feature id for the '<em><b>Everyone</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM__EVERYONE = 2;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM__PACKAGES = 3;

	/**
	 * The number of structural features of the '<em>Realm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Authenticate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM___AUTHENTICATE__OBJECT = 0;

	/**
	 * The operation id for the '<em>Get All Users</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM___GET_ALL_USERS = 1;

	/**
	 * The operation id for the '<em>Clear Permissions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM___CLEAR_PERMISSIONS__EOBJECT = 2;

	/**
	 * The number of operations of the '<em>Realm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALM_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.PackageImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NS_URI = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CLASSES = 3;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.ClassImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ACTIONS = 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.LoginPasswordCredentials <em>Login Password Credentials</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.LoginPasswordCredentials
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordCredentials()
	 * @generated
	 */
	int LOGIN_PASSWORD_CREDENTIALS = 8;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl <em>Login Password Realm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordRealm()
	 * @generated
	 */
	int LOGIN_PASSWORD_REALM = 9;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.PrincipalImpl <em>Principal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.PrincipalImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipal()
	 * @generated
	 */
	int PRINCIPAL = 4;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.GroupImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 10;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.LoginUserImpl <em>Login User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.LoginUserImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginUser()
	 * @generated
	 */
	int LOGIN_USER = 12;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.LoginPasswordHashUser <em>Login Password Hash User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.LoginPasswordHashUser
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordHashUser()
	 * @generated
	 */
	int LOGIN_PASSWORD_HASH_USER = 13;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.ActionImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Patterns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PATTERNS = 1;

	/**
	 * The feature id for the '<em><b>Grantable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__GRANTABLE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Implies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__IMPLIES = 4;

	/**
	 * The feature id for the '<em><b>Implied By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__IMPLIED_BY = 5;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__CATEGORY = 6;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__CHILDREN = 7;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Match</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___MATCH__CONTEXT_EOBJECT_STRING_STRING_MAP = 0;

	/**
	 * The operation id for the '<em>Create Principal Permission</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___CREATE_PRINCIPAL_PERMISSION = 1;

	/**
	 * The operation id for the '<em>Create Protected Permission</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___CREATE_PROTECTED_PERMISSION = 2;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL__MEMBER_OF = 0;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL__PERMISSIONS = 1;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL__DISABLED = 2;

	/**
	 * The number of structural features of the '<em>Principal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL___ACCEPT__PRINCIPALVISITOR = 1;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL___GET_REALM = 2;

	/**
	 * The number of operations of the '<em>Principal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.PermissionImpl <em>Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.PermissionImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPermission()
	 * @generated
	 */
	int PERMISSION = 5;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ACTION = 0;

	/**
	 * The feature id for the '<em><b>Allow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ALLOW = 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__START_DATE = 3;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__END_DATE = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__COMMENT = 5;

	/**
	 * The number of structural features of the '<em>Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP = 0;

	/**
	 * The operation id for the '<em>Get Principal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION___GET_PRINCIPAL = 1;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION___GET_TARGET = 2;

	/**
	 * The number of operations of the '<em>Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.PrincipalPermissionImpl <em>Principal Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.PrincipalPermissionImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipalPermission()
	 * @generated
	 */
	int PRINCIPAL_PERMISSION = 6;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__ACTION = PERMISSION__ACTION;

	/**
	 * The feature id for the '<em><b>Allow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__ALLOW = PERMISSION__ALLOW;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__CONDITION = PERMISSION__CONDITION;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__START_DATE = PERMISSION__START_DATE;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__END_DATE = PERMISSION__END_DATE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__COMMENT = PERMISSION__COMMENT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION__TARGET = PERMISSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Principal Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION_FEATURE_COUNT = PERMISSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP = PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Get Principal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION___GET_PRINCIPAL = PERMISSION___GET_PRINCIPAL;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION___GET_TARGET = PERMISSION___GET_TARGET;

	/**
	 * The number of operations of the '<em>Principal Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINCIPAL_PERMISSION_OPERATION_COUNT = PERMISSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.ProtectedPermissionImpl <em>Protected Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.ProtectedPermissionImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getProtectedPermission()
	 * @generated
	 */
	int PROTECTED_PERMISSION = 7;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__ACTION = PERMISSION__ACTION;

	/**
	 * The feature id for the '<em><b>Allow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__ALLOW = PERMISSION__ALLOW;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__CONDITION = PERMISSION__CONDITION;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__START_DATE = PERMISSION__START_DATE;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__END_DATE = PERMISSION__END_DATE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__COMMENT = PERMISSION__COMMENT;

	/**
	 * The feature id for the '<em><b>Principal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION__PRINCIPAL = PERMISSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Protected Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION_FEATURE_COUNT = PERMISSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP = PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Get Principal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION___GET_PRINCIPAL = PERMISSION___GET_PRINCIPAL;

	/**
	 * The operation id for the '<em>Get Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION___GET_TARGET = PERMISSION___GET_TARGET;

	/**
	 * The number of operations of the '<em>Protected Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_PERMISSION_OPERATION_COUNT = PERMISSION_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Login Password Credentials</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_CREDENTIALS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Login Password Credentials</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_CREDENTIALS_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM__ROOT = REALM__ROOT;

	/**
	 * The feature id for the '<em><b>Guest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM__GUEST = REALM__GUEST;

	/**
	 * The feature id for the '<em><b>Everyone</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM__EVERYONE = REALM__EVERYONE;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM__PACKAGES = REALM__PACKAGES;

	/**
	 * The number of structural features of the '<em>Login Password Realm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM_FEATURE_COUNT = REALM_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Authenticate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM___AUTHENTICATE__OBJECT = REALM___AUTHENTICATE__OBJECT;

	/**
	 * The operation id for the '<em>Get All Users</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM___GET_ALL_USERS = REALM___GET_ALL_USERS;

	/**
	 * The operation id for the '<em>Clear Permissions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM___CLEAR_PERMISSIONS__EOBJECT = REALM___CLEAR_PERMISSIONS__EOBJECT;

	/**
	 * The operation id for the '<em>Set Password Hash</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING = REALM_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get User</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM___GET_USER__STRING = REALM_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Login Password Realm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_REALM_OPERATION_COUNT = REALM_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__MEMBER_OF = PRINCIPAL__MEMBER_OF;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PERMISSIONS = PRINCIPAL__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DISABLED = PRINCIPAL__DISABLED;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__MEMBERS = PRINCIPAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = PRINCIPAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = PRINCIPAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = PRINCIPAL_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP___ACCEPT__PRINCIPALVISITOR = PRINCIPAL___ACCEPT__PRINCIPALVISITOR;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP___GET_REALM = PRINCIPAL___GET_REALM;

	/**
	 * The operation id for the '<em>Is Member</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP___IS_MEMBER__PRINCIPAL = PRINCIPAL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = PRINCIPAL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.UserImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getUser()
	 * @generated
	 */
	int USER = 11;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__MEMBER_OF = PRINCIPAL__MEMBER_OF;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PERMISSIONS = PRINCIPAL__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DISABLED = PRINCIPAL__DISABLED;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = PRINCIPAL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___ACCEPT__PRINCIPALVISITOR = PRINCIPAL___ACCEPT__PRINCIPALVISITOR;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER___GET_REALM = PRINCIPAL___GET_REALM;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = PRINCIPAL_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER__MEMBER_OF = USER__MEMBER_OF;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER__PERMISSIONS = USER__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER__DISABLED = USER__DISABLED;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER__LOGIN = USER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Login User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER_FEATURE_COUNT = USER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = USER___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER___ACCEPT__PRINCIPALVISITOR = USER___ACCEPT__PRINCIPALVISITOR;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER___GET_REALM = USER___GET_REALM;

	/**
	 * The number of operations of the '<em>Login User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_USER_OPERATION_COUNT = USER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER__MEMBER_OF = LOGIN_USER__MEMBER_OF;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER__PERMISSIONS = LOGIN_USER__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER__DISABLED = LOGIN_USER__DISABLED;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER__LOGIN = LOGIN_USER__LOGIN;

	/**
	 * The feature id for the '<em><b>Password Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH = LOGIN_USER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Login Password Hash User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER_FEATURE_COUNT = LOGIN_USER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = LOGIN_USER___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER___ACCEPT__PRINCIPALVISITOR = LOGIN_USER___ACCEPT__PRINCIPALVISITOR;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER___GET_REALM = LOGIN_USER___GET_REALM;

	/**
	 * The number of operations of the '<em>Login Password Hash User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PASSWORD_HASH_USER_OPERATION_COUNT = LOGIN_USER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.impl.GuestImpl <em>Guest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.impl.GuestImpl
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getGuest()
	 * @generated
	 */
	int GUEST = 14;

	/**
	 * The feature id for the '<em><b>Member Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST__MEMBER_OF = PRINCIPAL__MEMBER_OF;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST__PERMISSIONS = PRINCIPAL__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST__DISABLED = PRINCIPAL__DISABLED;

	/**
	 * The number of structural features of the '<em>Guest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST_FEATURE_COUNT = PRINCIPAL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST___ACCEPT__PRINCIPALVISITOR = PRINCIPAL___ACCEPT__PRINCIPALVISITOR;

	/**
	 * The operation id for the '<em>Get Realm</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST___GET_REALM = PRINCIPAL___GET_REALM;

	/**
	 * The number of operations of the '<em>Guest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUEST_OPERATION_COUNT = PRINCIPAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.security.Protected <em>Protected</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.Protected
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getProtected()
	 * @generated
	 */
	int PROTECTED = 15;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__PERMISSIONS = 0;

	/**
	 * The number of structural features of the '<em>Protected</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Authorize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED___AUTHORIZE__CONTEXT_PRINCIPAL_STRING_STRING_MAP = 0;

	/**
	 * The number of operations of the '<em>Protected</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Context
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 16;

	/**
	 * The meta object id for the '<em>Principal Visitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.security.PrincipalVisitor
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipalVisitor()
	 * @generated
	 */
	int PRINCIPAL_VISITOR = 17;

	/**
	 * The meta object id for the '<em>Access Decision</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.AuthorizationProvider.AccessDecision
	 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getAccessDecision()
	 * @generated
	 */
	int ACCESS_DECISION = 18;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Realm <em>Realm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realm</em>'.
	 * @see org.nasdanika.cdo.security.Realm
	 * @generated
	 */
	EClass getRealm();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.security.Realm#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see org.nasdanika.cdo.security.Realm#getRoot()
	 * @see #getRealm()
	 * @generated
	 */
	EReference getRealm_Root();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.security.Realm#getGuest <em>Guest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guest</em>'.
	 * @see org.nasdanika.cdo.security.Realm#getGuest()
	 * @see #getRealm()
	 * @generated
	 */
	EReference getRealm_Guest();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.security.Realm#getEveryone <em>Everyone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Everyone</em>'.
	 * @see org.nasdanika.cdo.security.Realm#getEveryone()
	 * @see #getRealm()
	 * @generated
	 */
	EReference getRealm_Everyone();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Realm#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.nasdanika.cdo.security.Realm#getPackages()
	 * @see #getRealm()
	 * @generated
	 */
	EReference getRealm_Packages();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Realm#authenticate(java.lang.Object) <em>Authenticate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Authenticate</em>' operation.
	 * @see org.nasdanika.cdo.security.Realm#authenticate(java.lang.Object)
	 * @generated
	 */
	EOperation getRealm__Authenticate__Object();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Realm#getAllUsers() <em>Get All Users</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Users</em>' operation.
	 * @see org.nasdanika.cdo.security.Realm#getAllUsers()
	 * @generated
	 */
	EOperation getRealm__GetAllUsers();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Realm#clearPermissions(org.eclipse.emf.ecore.EObject) <em>Clear Permissions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Clear Permissions</em>' operation.
	 * @see org.nasdanika.cdo.security.Realm#clearPermissions(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getRealm__ClearPermissions__EObject();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.nasdanika.cdo.security.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Package#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.security.Package#getName()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Package#getNsURI <em>Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ns URI</em>'.
	 * @see org.nasdanika.cdo.security.Package#getNsURI()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_NsURI();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Package#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.cdo.security.Package#getComment()
	 * @see #getPackage()
	 * @generated
	 */
	EAttribute getPackage_Comment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Package#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see org.nasdanika.cdo.security.Package#getClasses()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Classes();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.nasdanika.cdo.security.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Class#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.security.Class#getName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Class#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.cdo.security.Class#getComment()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Comment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Class#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.nasdanika.cdo.security.Class#getActions()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Actions();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.LoginPasswordCredentials <em>Login Password Credentials</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login Password Credentials</em>'.
	 * @see org.nasdanika.cdo.security.LoginPasswordCredentials
	 * @model instanceClass="org.nasdanika.cdo.security.LoginPasswordCredentials"
	 * @generated
	 */
	EClass getLoginPasswordCredentials();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.LoginPasswordRealm <em>Login Password Realm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login Password Realm</em>'.
	 * @see org.nasdanika.cdo.security.LoginPasswordRealm
	 * @generated
	 */
	EClass getLoginPasswordRealm();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.LoginPasswordRealm#setPasswordHash(org.nasdanika.cdo.security.LoginPasswordHashUser, java.lang.String) <em>Set Password Hash</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Password Hash</em>' operation.
	 * @see org.nasdanika.cdo.security.LoginPasswordRealm#setPasswordHash(org.nasdanika.cdo.security.LoginPasswordHashUser, java.lang.String)
	 * @generated
	 */
	EOperation getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.LoginPasswordRealm#getUser(java.lang.String) <em>Get User</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get User</em>' operation.
	 * @see org.nasdanika.cdo.security.LoginPasswordRealm#getUser(java.lang.String)
	 * @generated
	 */
	EOperation getLoginPasswordRealm__GetUser__String();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Principal <em>Principal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Principal</em>'.
	 * @see org.nasdanika.cdo.security.Principal
	 * @generated
	 */
	EClass getPrincipal();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.security.Principal#getMemberOf <em>Member Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member Of</em>'.
	 * @see org.nasdanika.cdo.security.Principal#getMemberOf()
	 * @see #getPrincipal()
	 * @generated
	 */
	EReference getPrincipal_MemberOf();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Principal#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permissions</em>'.
	 * @see org.nasdanika.cdo.security.Principal#getPermissions()
	 * @see #getPrincipal()
	 * @generated
	 */
	EReference getPrincipal_Permissions();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Principal#isDisabled <em>Disabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Disabled</em>'.
	 * @see org.nasdanika.cdo.security.Principal#isDisabled()
	 * @see #getPrincipal()
	 * @generated
	 */
	EAttribute getPrincipal_Disabled();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Principal#authorize(org.nasdanika.core.Context, org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String, java.util.Map) <em>Authorize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Authorize</em>' operation.
	 * @see org.nasdanika.cdo.security.Principal#authorize(org.nasdanika.core.Context, org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String, java.util.Map)
	 * @generated
	 */
	EOperation getPrincipal__Authorize__Context_EObject_String_String_Map();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Principal#accept(org.nasdanika.cdo.security.PrincipalVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.nasdanika.cdo.security.Principal#accept(org.nasdanika.cdo.security.PrincipalVisitor)
	 * @generated
	 */
	EOperation getPrincipal__Accept__PrincipalVisitor();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Principal#getRealm() <em>Get Realm</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Realm</em>' operation.
	 * @see org.nasdanika.cdo.security.Principal#getRealm()
	 * @generated
	 */
	EOperation getPrincipal__GetRealm();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.nasdanika.cdo.security.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.security.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.nasdanika.cdo.security.Group#getMembers()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Members();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.security.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Group#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.cdo.security.Group#getDescription()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Description();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Group#isMember(org.nasdanika.cdo.security.Principal) <em>Is Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Member</em>' operation.
	 * @see org.nasdanika.cdo.security.Group#isMember(org.nasdanika.cdo.security.Principal)
	 * @generated
	 */
	EOperation getGroup__IsMember__Principal();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.nasdanika.cdo.security.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.LoginUser <em>Login User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login User</em>'.
	 * @see org.nasdanika.cdo.security.LoginUser
	 * @generated
	 */
	EClass getLoginUser();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.LoginUser#getLogin <em>Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login</em>'.
	 * @see org.nasdanika.cdo.security.LoginUser#getLogin()
	 * @see #getLoginUser()
	 * @generated
	 */
	EAttribute getLoginUser_Login();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.LoginPasswordHashUser <em>Login Password Hash User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login Password Hash User</em>'.
	 * @see org.nasdanika.cdo.security.LoginPasswordHashUser
	 * @generated
	 */
	EClass getLoginPasswordHashUser();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.LoginPasswordHashUser#getPasswordHash <em>Password Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Hash</em>'.
	 * @see org.nasdanika.cdo.security.LoginPasswordHashUser#getPasswordHash()
	 * @see #getLoginPasswordHashUser()
	 * @generated
	 */
	EAttribute getLoginPasswordHashUser_PasswordHash();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Guest <em>Guest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guest</em>'.
	 * @see org.nasdanika.cdo.security.Guest
	 * @generated
	 */
	EClass getGuest();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Protected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protected</em>'.
	 * @see org.nasdanika.cdo.security.Protected
	 * @generated
	 */
	EClass getProtected();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Protected#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permissions</em>'.
	 * @see org.nasdanika.cdo.security.Protected#getPermissions()
	 * @see #getProtected()
	 * @generated
	 */
	EReference getProtected_Permissions();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Protected#authorize(org.nasdanika.core.Context, org.nasdanika.cdo.security.Principal, java.lang.String, java.lang.String, java.util.Map) <em>Authorize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Authorize</em>' operation.
	 * @see org.nasdanika.cdo.security.Protected#authorize(org.nasdanika.core.Context, org.nasdanika.cdo.security.Principal, java.lang.String, java.lang.String, java.util.Map)
	 * @generated
	 */
	EOperation getProtected__Authorize__Context_Principal_String_String_Map();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.nasdanika.cdo.security.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.cdo.security.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.cdo.security.Action#getPatterns <em>Patterns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Patterns</em>'.
	 * @see org.nasdanika.cdo.security.Action#getPatterns()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Patterns();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Action#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.cdo.security.Action#getDescription()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Action#isGrantable <em>Grantable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grantable</em>'.
	 * @see org.nasdanika.cdo.security.Action#isGrantable()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Grantable();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.security.Action#getImplies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implies</em>'.
	 * @see org.nasdanika.cdo.security.Action#getImplies()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Implies();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.security.Action#getImpliedBy <em>Implied By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implied By</em>'.
	 * @see org.nasdanika.cdo.security.Action#getImpliedBy()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ImpliedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Action#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.nasdanika.cdo.security.Action#getCategory()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Category();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.security.Action#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.cdo.security.Action#getChildren()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Children();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Action#match(org.nasdanika.core.Context, org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String, java.util.Map) <em>Match</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Match</em>' operation.
	 * @see org.nasdanika.cdo.security.Action#match(org.nasdanika.core.Context, org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String, java.util.Map)
	 * @generated
	 */
	EOperation getAction__Match__Context_EObject_String_String_Map();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Action#createPrincipalPermission() <em>Create Principal Permission</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Principal Permission</em>' operation.
	 * @see org.nasdanika.cdo.security.Action#createPrincipalPermission()
	 * @generated
	 */
	EOperation getAction__CreatePrincipalPermission();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Action#createProtectedPermission() <em>Create Protected Permission</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Protected Permission</em>' operation.
	 * @see org.nasdanika.cdo.security.Action#createProtectedPermission()
	 * @generated
	 */
	EOperation getAction__CreateProtectedPermission();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.Permission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission</em>'.
	 * @see org.nasdanika.cdo.security.Permission
	 * @generated
	 */
	EClass getPermission();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Permission#isAllow <em>Allow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow</em>'.
	 * @see org.nasdanika.cdo.security.Permission#isAllow()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Allow();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Permission#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.nasdanika.cdo.security.Permission#getStartDate()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Permission#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see org.nasdanika.cdo.security.Permission#getEndDate()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_EndDate();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Permission#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.cdo.security.Permission#getComment()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.security.Permission#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.nasdanika.cdo.security.Permission#getAction()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_Action();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.security.Permission#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.nasdanika.cdo.security.Permission#getCondition()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_Condition();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Permission#authorize(org.nasdanika.core.Context, java.lang.String, java.lang.String, java.util.Map) <em>Authorize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Authorize</em>' operation.
	 * @see org.nasdanika.cdo.security.Permission#authorize(org.nasdanika.core.Context, java.lang.String, java.lang.String, java.util.Map)
	 * @generated
	 */
	EOperation getPermission__Authorize__Context_String_String_Map();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Permission#getPrincipal() <em>Get Principal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Principal</em>' operation.
	 * @see org.nasdanika.cdo.security.Permission#getPrincipal()
	 * @generated
	 */
	EOperation getPermission__GetPrincipal();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.security.Permission#getTarget() <em>Get Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Target</em>' operation.
	 * @see org.nasdanika.cdo.security.Permission#getTarget()
	 * @generated
	 */
	EOperation getPermission__GetTarget();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.PrincipalPermission <em>Principal Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Principal Permission</em>'.
	 * @see org.nasdanika.cdo.security.PrincipalPermission
	 * @generated
	 */
	EClass getPrincipalPermission();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.security.PrincipalPermission#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.security.PrincipalPermission#getTarget()
	 * @see #getPrincipalPermission()
	 * @generated
	 */
	EReference getPrincipalPermission_Target();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.security.ProtectedPermission <em>Protected Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protected Permission</em>'.
	 * @see org.nasdanika.cdo.security.ProtectedPermission
	 * @generated
	 */
	EClass getProtectedPermission();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.security.ProtectedPermission#getPrincipal <em>Principal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Principal</em>'.
	 * @see org.nasdanika.cdo.security.ProtectedPermission#getPrincipal()
	 * @see #getProtectedPermission()
	 * @generated
	 */
	EReference getProtectedPermission_Principal();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.core.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Context</em>'.
	 * @see org.nasdanika.core.Context
	 * @model instanceClass="org.nasdanika.core.Context"
	 * @generated
	 */
	EDataType getContext();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.security.PrincipalVisitor <em>Principal Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Principal Visitor</em>'.
	 * @see org.nasdanika.cdo.security.PrincipalVisitor
	 * @model instanceClass="org.nasdanika.cdo.security.PrincipalVisitor"
	 * @generated
	 */
	EDataType getPrincipalVisitor();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.core.AuthorizationProvider.AccessDecision <em>Access Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Access Decision</em>'.
	 * @see org.nasdanika.core.AuthorizationProvider.AccessDecision
	 * @model instanceClass="org.nasdanika.core.AuthorizationProvider.AccessDecision"
	 * @generated
	 */
	EDataType getAccessDecision();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SecurityFactory getSecurityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.Realm <em>Realm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.Realm
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getRealm()
		 * @generated
		 */
		EClass REALM = eINSTANCE.getRealm();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALM__ROOT = eINSTANCE.getRealm_Root();

		/**
		 * The meta object literal for the '<em><b>Guest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALM__GUEST = eINSTANCE.getRealm_Guest();

		/**
		 * The meta object literal for the '<em><b>Everyone</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALM__EVERYONE = eINSTANCE.getRealm_Everyone();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REALM__PACKAGES = eINSTANCE.getRealm_Packages();

		/**
		 * The meta object literal for the '<em><b>Authenticate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REALM___AUTHENTICATE__OBJECT = eINSTANCE.getRealm__Authenticate__Object();

		/**
		 * The meta object literal for the '<em><b>Get All Users</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REALM___GET_ALL_USERS = eINSTANCE.getRealm__GetAllUsers();

		/**
		 * The meta object literal for the '<em><b>Clear Permissions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REALM___CLEAR_PERMISSIONS__EOBJECT = eINSTANCE.getRealm__ClearPermissions__EObject();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.PackageImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NAME = eINSTANCE.getPackage_Name();

		/**
		 * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__NS_URI = eINSTANCE.getPackage_NsURI();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE__COMMENT = eINSTANCE.getPackage_Comment();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__CLASSES = eINSTANCE.getPackage_Classes();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.ClassImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__NAME = eINSTANCE.getClass_Name();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__COMMENT = eINSTANCE.getClass_Comment();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ACTIONS = eINSTANCE.getClass_Actions();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.LoginPasswordCredentials <em>Login Password Credentials</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.LoginPasswordCredentials
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordCredentials()
		 * @generated
		 */
		EClass LOGIN_PASSWORD_CREDENTIALS = eINSTANCE.getLoginPasswordCredentials();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl <em>Login Password Realm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordRealm()
		 * @generated
		 */
		EClass LOGIN_PASSWORD_REALM = eINSTANCE.getLoginPasswordRealm();

		/**
		 * The meta object literal for the '<em><b>Set Password Hash</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOGIN_PASSWORD_REALM___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING = eINSTANCE.getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String();

		/**
		 * The meta object literal for the '<em><b>Get User</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOGIN_PASSWORD_REALM___GET_USER__STRING = eINSTANCE.getLoginPasswordRealm__GetUser__String();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.PrincipalImpl <em>Principal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.PrincipalImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipal()
		 * @generated
		 */
		EClass PRINCIPAL = eINSTANCE.getPrincipal();

		/**
		 * The meta object literal for the '<em><b>Member Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINCIPAL__MEMBER_OF = eINSTANCE.getPrincipal_MemberOf();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINCIPAL__PERMISSIONS = eINSTANCE.getPrincipal_Permissions();

		/**
		 * The meta object literal for the '<em><b>Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRINCIPAL__DISABLED = eINSTANCE.getPrincipal_Disabled();

		/**
		 * The meta object literal for the '<em><b>Authorize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP = eINSTANCE.getPrincipal__Authorize__Context_EObject_String_String_Map();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRINCIPAL___ACCEPT__PRINCIPALVISITOR = eINSTANCE.getPrincipal__Accept__PrincipalVisitor();

		/**
		 * The meta object literal for the '<em><b>Get Realm</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PRINCIPAL___GET_REALM = eINSTANCE.getPrincipal__GetRealm();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.GroupImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__MEMBERS = eINSTANCE.getGroup_Members();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__DESCRIPTION = eINSTANCE.getGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Is Member</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUP___IS_MEMBER__PRINCIPAL = eINSTANCE.getGroup__IsMember__Principal();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.UserImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.LoginUserImpl <em>Login User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.LoginUserImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginUser()
		 * @generated
		 */
		EClass LOGIN_USER = eINSTANCE.getLoginUser();

		/**
		 * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIN_USER__LOGIN = eINSTANCE.getLoginUser_Login();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.LoginPasswordHashUser <em>Login Password Hash User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.LoginPasswordHashUser
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getLoginPasswordHashUser()
		 * @generated
		 */
		EClass LOGIN_PASSWORD_HASH_USER = eINSTANCE.getLoginPasswordHashUser();

		/**
		 * The meta object literal for the '<em><b>Password Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH = eINSTANCE.getLoginPasswordHashUser_PasswordHash();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.GuestImpl <em>Guest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.GuestImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getGuest()
		 * @generated
		 */
		EClass GUEST = eINSTANCE.getGuest();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.Protected <em>Protected</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.Protected
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getProtected()
		 * @generated
		 */
		EClass PROTECTED = eINSTANCE.getProtected();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTED__PERMISSIONS = eINSTANCE.getProtected_Permissions();

		/**
		 * The meta object literal for the '<em><b>Authorize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROTECTED___AUTHORIZE__CONTEXT_PRINCIPAL_STRING_STRING_MAP = eINSTANCE.getProtected__Authorize__Context_Principal_String_String_Map();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.ActionImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Patterns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__PATTERNS = eINSTANCE.getAction_Patterns();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DESCRIPTION = eINSTANCE.getAction_Description();

		/**
		 * The meta object literal for the '<em><b>Grantable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__GRANTABLE = eINSTANCE.getAction_Grantable();

		/**
		 * The meta object literal for the '<em><b>Implies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__IMPLIES = eINSTANCE.getAction_Implies();

		/**
		 * The meta object literal for the '<em><b>Implied By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__IMPLIED_BY = eINSTANCE.getAction_ImpliedBy();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__CATEGORY = eINSTANCE.getAction_Category();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__CHILDREN = eINSTANCE.getAction_Children();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___MATCH__CONTEXT_EOBJECT_STRING_STRING_MAP = eINSTANCE.getAction__Match__Context_EObject_String_String_Map();

		/**
		 * The meta object literal for the '<em><b>Create Principal Permission</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___CREATE_PRINCIPAL_PERMISSION = eINSTANCE.getAction__CreatePrincipalPermission();

		/**
		 * The meta object literal for the '<em><b>Create Protected Permission</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ACTION___CREATE_PROTECTED_PERMISSION = eINSTANCE.getAction__CreateProtectedPermission();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.PermissionImpl <em>Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.PermissionImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPermission()
		 * @generated
		 */
		EClass PERMISSION = eINSTANCE.getPermission();

		/**
		 * The meta object literal for the '<em><b>Allow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__ALLOW = eINSTANCE.getPermission_Allow();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__START_DATE = eINSTANCE.getPermission_StartDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__END_DATE = eINSTANCE.getPermission_EndDate();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__COMMENT = eINSTANCE.getPermission_Comment();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__ACTION = eINSTANCE.getPermission_Action();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__CONDITION = eINSTANCE.getPermission_Condition();

		/**
		 * The meta object literal for the '<em><b>Authorize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP = eINSTANCE.getPermission__Authorize__Context_String_String_Map();

		/**
		 * The meta object literal for the '<em><b>Get Principal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERMISSION___GET_PRINCIPAL = eINSTANCE.getPermission__GetPrincipal();

		/**
		 * The meta object literal for the '<em><b>Get Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PERMISSION___GET_TARGET = eINSTANCE.getPermission__GetTarget();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.PrincipalPermissionImpl <em>Principal Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.PrincipalPermissionImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipalPermission()
		 * @generated
		 */
		EClass PRINCIPAL_PERMISSION = eINSTANCE.getPrincipalPermission();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINCIPAL_PERMISSION__TARGET = eINSTANCE.getPrincipalPermission_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.security.impl.ProtectedPermissionImpl <em>Protected Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.impl.ProtectedPermissionImpl
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getProtectedPermission()
		 * @generated
		 */
		EClass PROTECTED_PERMISSION = eINSTANCE.getProtectedPermission();

		/**
		 * The meta object literal for the '<em><b>Principal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTED_PERMISSION__PRINCIPAL = eINSTANCE.getProtectedPermission_Principal();

		/**
		 * The meta object literal for the '<em>Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Context
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getContext()
		 * @generated
		 */
		EDataType CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em>Principal Visitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.security.PrincipalVisitor
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getPrincipalVisitor()
		 * @generated
		 */
		EDataType PRINCIPAL_VISITOR = eINSTANCE.getPrincipalVisitor();

		/**
		 * The meta object literal for the '<em>Access Decision</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.AuthorizationProvider.AccessDecision
		 * @see org.nasdanika.cdo.security.impl.SecurityPackageImpl#getAccessDecision()
		 * @generated
		 */
		EDataType ACCESS_DECISION = eINSTANCE.getAccessDecision();

	}

} //SecurityPackage
