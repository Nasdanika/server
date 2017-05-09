/**
 */
package org.nasdanika.cdo.security.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Guest;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginPasswordRealm;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.PrincipalPermission;
import org.nasdanika.cdo.security.PrincipalVisitor;
import org.nasdanika.cdo.security.Protected;
import org.nasdanika.cdo.security.ProtectedPermission;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.cdo.security.SecurityFactory;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecurityPackageImpl extends EPackageImpl implements SecurityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass principalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginPasswordHashUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass principalPermissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectedPermissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginPasswordCredentialsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginPasswordRealmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType accessDecisionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType contextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType principalVisitorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.nasdanika.cdo.security.SecurityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SecurityPackageImpl() {
		super(eNS_URI, SecurityFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SecurityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SecurityPackage init() {
		if (isInited) return (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage(SecurityPackage.eNS_URI);

		// Obtain or create and register package
		SecurityPackageImpl theSecurityPackage = (SecurityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SecurityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SecurityPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSecurityPackage.createPackageContents();

		// Initialize created meta-data
		theSecurityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSecurityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SecurityPackage.eNS_URI, theSecurityPackage);
		return theSecurityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealm() {
		return realmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealm_Root() {
		return (EReference)realmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealm_Guest() {
		return (EReference)realmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealm_Everyone() {
		return (EReference)realmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealm_Packages() {
		return (EReference)realmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRealm__Authenticate__Object() {
		return realmEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRealm__GetAllUsers() {
		return realmEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRealm__ClearPermissions__EObject() {
		return realmEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackage_Name() {
		return (EAttribute)packageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackage_NsURI() {
		return (EAttribute)packageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackage_Comment() {
		return (EAttribute)packageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Classes() {
		return (EReference)packageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Name() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Comment() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Actions() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrincipal() {
		return principalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrincipal_MemberOf() {
		return (EReference)principalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrincipal_Permissions() {
		return (EReference)principalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrincipal_Disabled() {
		return (EAttribute)principalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__Authorize__Context_EObject_String_String_Map() {
		return principalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__Accept__PrincipalVisitor() {
		return principalEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__GetRealm() {
		return principalEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Members() {
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Name() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Description() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroup__IsMember__Principal() {
		return groupEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginUser() {
		return loginUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoginUser_Login() {
		return (EAttribute)loginUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginPasswordHashUser() {
		return loginPasswordHashUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoginPasswordHashUser_PasswordHash() {
		return (EAttribute)loginPasswordHashUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuest() {
		return guestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtected() {
		return protectedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtected_Permissions() {
		return (EReference)protectedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtected__Authorize__Context_Principal_String_String_Map() {
		return protectedEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtected__GetGrantees() {
		return protectedEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Name() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_IncludePatterns() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_ExcludePatterns() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Description() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Grantable() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Implies() {
		return (EReference)actionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_ImpliedBy() {
		return (EReference)actionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Category() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Children() {
		return (EReference)actionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__Match__Context_EObject_String_String_Map() {
		return actionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__CreatePrincipalPermission() {
		return actionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAction__CreateProtectedPermission() {
		return actionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPermission() {
		return permissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_Allow() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_StartDate() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_EndDate() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_Comment() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Action() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_Condition() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPermission__Authorize__Context_String_String_Map() {
		return permissionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPermission__GetPrincipal() {
		return permissionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPermission__GetTarget() {
		return permissionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrincipalPermission() {
		return principalPermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrincipalPermission_Target() {
		return (EReference)principalPermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtectedPermission() {
		return protectedPermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectedPermission_Principal() {
		return (EReference)protectedPermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginPasswordCredentials() {
		return loginPasswordCredentialsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginPasswordRealm() {
		return loginPasswordRealmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String() {
		return loginPasswordRealmEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoginPasswordRealm__GetUser__String() {
		return loginPasswordRealmEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAccessDecision() {
		return accessDecisionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getContext() {
		return contextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrincipalVisitor() {
		return principalVisitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityFactory getSecurityFactory() {
		return (SecurityFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		realmEClass = createEClass(REALM);
		createEReference(realmEClass, REALM__ROOT);
		createEReference(realmEClass, REALM__GUEST);
		createEReference(realmEClass, REALM__EVERYONE);
		createEReference(realmEClass, REALM__PACKAGES);
		createEOperation(realmEClass, REALM___AUTHENTICATE__OBJECT);
		createEOperation(realmEClass, REALM___GET_ALL_USERS);
		createEOperation(realmEClass, REALM___CLEAR_PERMISSIONS__EOBJECT);

		packageEClass = createEClass(PACKAGE);
		createEAttribute(packageEClass, PACKAGE__NAME);
		createEAttribute(packageEClass, PACKAGE__NS_URI);
		createEAttribute(packageEClass, PACKAGE__COMMENT);
		createEReference(packageEClass, PACKAGE__CLASSES);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__NAME);
		createEAttribute(classEClass, CLASS__COMMENT);
		createEReference(classEClass, CLASS__ACTIONS);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__NAME);
		createEAttribute(actionEClass, ACTION__INCLUDE_PATTERNS);
		createEAttribute(actionEClass, ACTION__EXCLUDE_PATTERNS);
		createEAttribute(actionEClass, ACTION__GRANTABLE);
		createEAttribute(actionEClass, ACTION__DESCRIPTION);
		createEReference(actionEClass, ACTION__IMPLIES);
		createEReference(actionEClass, ACTION__IMPLIED_BY);
		createEAttribute(actionEClass, ACTION__CATEGORY);
		createEReference(actionEClass, ACTION__CHILDREN);
		createEOperation(actionEClass, ACTION___MATCH__CONTEXT_EOBJECT_STRING_STRING_MAP);
		createEOperation(actionEClass, ACTION___CREATE_PRINCIPAL_PERMISSION);
		createEOperation(actionEClass, ACTION___CREATE_PROTECTED_PERMISSION);

		principalEClass = createEClass(PRINCIPAL);
		createEReference(principalEClass, PRINCIPAL__MEMBER_OF);
		createEReference(principalEClass, PRINCIPAL__PERMISSIONS);
		createEAttribute(principalEClass, PRINCIPAL__DISABLED);
		createEOperation(principalEClass, PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP);
		createEOperation(principalEClass, PRINCIPAL___ACCEPT__PRINCIPALVISITOR);
		createEOperation(principalEClass, PRINCIPAL___GET_REALM);

		permissionEClass = createEClass(PERMISSION);
		createEReference(permissionEClass, PERMISSION__ACTION);
		createEAttribute(permissionEClass, PERMISSION__ALLOW);
		createEAttribute(permissionEClass, PERMISSION__CONDITION);
		createEAttribute(permissionEClass, PERMISSION__START_DATE);
		createEAttribute(permissionEClass, PERMISSION__END_DATE);
		createEAttribute(permissionEClass, PERMISSION__COMMENT);
		createEOperation(permissionEClass, PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP);
		createEOperation(permissionEClass, PERMISSION___GET_PRINCIPAL);
		createEOperation(permissionEClass, PERMISSION___GET_TARGET);

		principalPermissionEClass = createEClass(PRINCIPAL_PERMISSION);
		createEReference(principalPermissionEClass, PRINCIPAL_PERMISSION__TARGET);

		protectedPermissionEClass = createEClass(PROTECTED_PERMISSION);
		createEReference(protectedPermissionEClass, PROTECTED_PERMISSION__PRINCIPAL);

		loginPasswordCredentialsEClass = createEClass(LOGIN_PASSWORD_CREDENTIALS);

		loginPasswordRealmEClass = createEClass(LOGIN_PASSWORD_REALM);
		createEOperation(loginPasswordRealmEClass, LOGIN_PASSWORD_REALM___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING);
		createEOperation(loginPasswordRealmEClass, LOGIN_PASSWORD_REALM___GET_USER__STRING);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__MEMBERS);
		createEAttribute(groupEClass, GROUP__NAME);
		createEAttribute(groupEClass, GROUP__DESCRIPTION);
		createEOperation(groupEClass, GROUP___IS_MEMBER__PRINCIPAL);

		userEClass = createEClass(USER);

		loginUserEClass = createEClass(LOGIN_USER);
		createEAttribute(loginUserEClass, LOGIN_USER__LOGIN);

		loginPasswordHashUserEClass = createEClass(LOGIN_PASSWORD_HASH_USER);
		createEAttribute(loginPasswordHashUserEClass, LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH);

		guestEClass = createEClass(GUEST);

		protectedEClass = createEClass(PROTECTED);
		createEReference(protectedEClass, PROTECTED__PERMISSIONS);
		createEOperation(protectedEClass, PROTECTED___AUTHORIZE__CONTEXT_PRINCIPAL_STRING_STRING_MAP);
		createEOperation(protectedEClass, PROTECTED___GET_GRANTEES);

		// Create data types
		contextEDataType = createEDataType(CONTEXT);
		principalVisitorEDataType = createEDataType(PRINCIPAL_VISITOR);
		accessDecisionEDataType = createEDataType(ACCESS_DECISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter realmEClass_CR = addETypeParameter(realmEClass, "CR");
		addETypeParameter(userEClass, "CR");
		ETypeParameter loginUserEClass_CR = addETypeParameter(loginUserEClass, "CR");

		// Set bounds for type parameters

		// Add supertypes to classes
		principalPermissionEClass.getESuperTypes().add(this.getPermission());
		protectedPermissionEClass.getESuperTypes().add(this.getPermission());
		EGenericType g1 = createEGenericType(this.getRealm());
		EGenericType g2 = createEGenericType(this.getLoginPasswordCredentials());
		g1.getETypeArguments().add(g2);
		loginPasswordRealmEClass.getEGenericSuperTypes().add(g1);
		groupEClass.getESuperTypes().add(this.getPrincipal());
		userEClass.getESuperTypes().add(this.getPrincipal());
		g1 = createEGenericType(this.getUser());
		g2 = createEGenericType(loginUserEClass_CR);
		g1.getETypeArguments().add(g2);
		loginUserEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLoginUser());
		g2 = createEGenericType(this.getLoginPasswordCredentials());
		g1.getETypeArguments().add(g2);
		loginPasswordHashUserEClass.getEGenericSuperTypes().add(g1);
		guestEClass.getESuperTypes().add(this.getPrincipal());

		// Initialize classes, features, and operations; add parameters
		initEClass(realmEClass, Realm.class, "Realm", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRealm_Root(), this.getPrincipal(), null, "root", null, 0, 1, Realm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealm_Guest(), this.getPrincipal(), null, "guest", null, 0, 1, Realm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealm_Everyone(), this.getPrincipal(), null, "everyone", null, 0, 1, Realm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealm_Packages(), this.getPackage(), null, "packages", null, 0, -1, Realm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getRealm__Authenticate__Object(), this.getPrincipal(), "authenticate", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(realmEClass_CR);
		addEParameter(op, g1, "credentials", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRealm__GetAllUsers(), null, "getAllUsers", 0, -1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "U");
		g1 = createEGenericType(this.getUser());
		g2 = createEGenericType(realmEClass_CR);
		g1.getETypeArguments().add(g2);
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getRealm__ClearPermissions__EObject(), null, "clearPermissions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(packageEClass, org.nasdanika.cdo.security.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackage_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.nasdanika.cdo.security.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackage_NsURI(), ecorePackage.getEString(), "nsURI", null, 0, 1, org.nasdanika.cdo.security.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackage_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, org.nasdanika.cdo.security.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackage_Classes(), this.getClass_(), null, "classes", null, 0, -1, org.nasdanika.cdo.security.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classEClass, org.nasdanika.cdo.security.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Name(), ecorePackage.getEString(), "name", null, 0, 1, org.nasdanika.cdo.security.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, org.nasdanika.cdo.security.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Actions(), this.getAction(), null, "actions", null, 0, -1, org.nasdanika.cdo.security.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_IncludePatterns(), ecorePackage.getEString(), "includePatterns", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_ExcludePatterns(), ecorePackage.getEString(), "excludePatterns", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Grantable(), ecorePackage.getEBoolean(), "grantable", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Description(), ecorePackage.getEString(), "description", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Implies(), this.getAction(), this.getAction_ImpliedBy(), "implies", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_ImpliedBy(), this.getAction(), this.getAction_Implies(), "impliedBy", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Category(), ecorePackage.getEString(), "category", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Children(), this.getAction(), null, "children", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAction__Match__Context_EObject_String_String_Map(), ecorePackage.getEBoolean(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__CreatePrincipalPermission(), this.getPrincipalPermission(), "createPrincipalPermission", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAction__CreateProtectedPermission(), this.getProtectedPermission(), "createProtectedPermission", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(principalEClass, Principal.class, "Principal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrincipal_MemberOf(), this.getGroup(), this.getGroup_Members(), "memberOf", null, 0, -1, Principal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrincipal_Permissions(), this.getPrincipalPermission(), null, "permissions", null, 0, -1, Principal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrincipal_Disabled(), ecorePackage.getEBoolean(), "disabled", null, 0, 1, Principal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPrincipal__Authorize__Context_EObject_String_String_Map(), this.getAccessDecision(), "authorize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPrincipal__Accept__PrincipalVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipalVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPrincipal__GetRealm(), null, "getRealm", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getRealm());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(permissionEClass, Permission.class, "Permission", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPermission_Action(), this.getAction(), null, "action", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_Allow(), ecorePackage.getEBoolean(), "allow", "true", 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_EndDate(), ecorePackage.getEDate(), "endDate", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPermission__Authorize__Context_String_String_Map(), this.getAccessDecision(), "authorize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPermission__GetPrincipal(), this.getPrincipal(), "getPrincipal", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPermission__GetTarget(), ecorePackage.getEObject(), "getTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(principalPermissionEClass, PrincipalPermission.class, "PrincipalPermission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrincipalPermission_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, PrincipalPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protectedPermissionEClass, ProtectedPermission.class, "ProtectedPermission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtectedPermission_Principal(), this.getPrincipal(), null, "principal", null, 0, 1, ProtectedPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginPasswordCredentialsEClass, LoginPasswordCredentials.class, "LoginPasswordCredentials", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(loginPasswordRealmEClass, LoginPasswordRealm.class, "LoginPasswordRealm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String(), null, "setPasswordHash", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLoginPasswordHashUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "password", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLoginPasswordRealm__GetUser__String(), this.getLoginPasswordHashUser(), "getUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "login", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_Members(), this.getPrincipal(), this.getPrincipal_MemberOf(), "members", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Description(), ecorePackage.getEString(), "description", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGroup__IsMember__Principal(), ecorePackage.getEBoolean(), "isMember", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "principal", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userEClass, User.class, "User", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loginUserEClass, LoginUser.class, "LoginUser", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoginUser_Login(), ecorePackage.getEString(), "login", null, 0, 1, LoginUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginPasswordHashUserEClass, LoginPasswordHashUser.class, "LoginPasswordHashUser", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoginPasswordHashUser_PasswordHash(), ecorePackage.getEByteArray(), "passwordHash", null, 0, 1, LoginPasswordHashUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guestEClass, Guest.class, "Guest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(protectedEClass, Protected.class, "Protected", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtected_Permissions(), this.getProtectedPermission(), null, "permissions", null, 0, -1, Protected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getProtected__Authorize__Context_Principal_String_String_Map(), this.getAccessDecision(), "authorize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "principal", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProtected__GetGrantees(), this.getPrincipal(), "getGrantees", 0, -1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(contextEDataType, Context.class, "Context", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(principalVisitorEDataType, PrincipalVisitor.class, "PrincipalVisitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(accessDecisionEDataType, AccessDecision.class, "AccessDecision", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// org.nasdanika.cdo.web.render
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (realmEClass, 
		   source, 
		   new String[] {
			 "documentation", "Realm establishes associations between users and actions on model objects which users are allowed to perform.\r\nThere is no Role class/interface in the domain. A grantable actions is Role.\r\n\r\nTypically the root of the application model would implement this interface."
		   });	
		addAnnotation
		  (getRealm__Authenticate__Object(), 
		   source, 
		   new String[] {
			 "documentation", "Authenticates provided credentials, e.g. user login and password pair.\r\nReturns a list of principals (subject) associated with the provided credentials."
		   });	
		addAnnotation
		  (getRealm__GetAllUsers(), 
		   source, 
		   new String[] {
			 "documentation", "Realm does not have a containment reference for principals, subclasses may\r\nhave one or more principal containment references, direct or through contained objects.\r\n\r\nThis method returns all principals defined in the realm.\r\n"
		   });	
		addAnnotation
		  (getRealm__ClearPermissions__EObject(), 
		   source, 
		   new String[] {
			 "documentation", "Removes permissions associated with the target object from all principals in the realm.\r\nThis method shall be invoked before deleting an object."
		   });	
		addAnnotation
		  ((getRealm__ClearPermissions__EObject()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Target object."
		   });	
		addAnnotation
		  (getRealm_Root(), 
		   source, 
		   new String[] {
			 "documentation", "Root has all permissions. \r\nIf root is not set or root is a group with no members, then any user is treated as a superuser. \r\nThis functionality allows to configure the system after installation and then secure it by setting/adding root(s)."
		   });	
		addAnnotation
		  (getRealm_Guest(), 
		   source, 
		   new String[] {
			 "documentation", "Unauthenticated principal."
		   });	
		addAnnotation
		  (getRealm_Everyone(), 
		   source, 
		   new String[] {
			 "documentation", "If this reference is set then all authenticated users implicitly inherit permissions from the ``everyone`` principal."
		   });	
		addAnnotation
		  (getRealm_Packages(), 
		   source, 
		   new String[] {
			 "documentation", "In a security realm principals are granted permissios to perform actions on\r\nprotected objects.\r\nActions are associated with classed defined in packages."
		   });	
		addAnnotation
		  (packageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Package corresponds to Ecore EPackage."
		   });	
		addAnnotation
		  (getPackage_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Package name for display purposes."
		   });	
		addAnnotation
		  (getPackage_NsURI(), 
		   source, 
		   new String[] {
			 "documentation", "Namespace URI is used to match EPackage."
		   });	
		addAnnotation
		  (getPackage_Comment(), 
		   source, 
		   new String[] {
			 "documentation", "Comment."
		   });	
		addAnnotation
		  (getPackage_Classes(), 
		   source, 
		   new String[] {
			 "documentation", "Package contains classes which match EClass\'es"
		   });	
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "documentation", "Class corresponds to EClass and contains actions which can be performed on\r\ninstances of the corresponding EClass.."
		   });	
		addAnnotation
		  (getClass_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Class name, used for matching EClass."
		   });	
		addAnnotation
		  (getClass_Comment(), 
		   source, 
		   new String[] {
			 "documentation", "Comment."
		   });	
		addAnnotation
		  (getClass_Actions(), 
		   source, 
		   new String[] {
			 "documentation", "Actions which can be preformed on instances of corresponding EClass."
		   });	
		addAnnotation
		  (actionEClass, 
		   source, 
		   new String[] {
			 "documentation", "<html>Action defined for instances of given EClass</html>"
		   });	
		addAnnotation
		  (getAction__Match__Context_EObject_String_String_Map(), 
		   source, 
		   new String[] {
			 "documentation", "Matches this action to action string, qualifier in a given context and environment.\r\nThe default implementation constructs a string ``<action>:<qualifier>`` and uses name as a simplified glob pattern to match the string.\r\n\r\nFor example:\r\n\r\n* ``*:*`` matches any request.\r\n* ``read:description`` matches action ``read`` for the qualifier ``descriptor``.\r\n* ``*:accounts`` matches any action for the ``accounts`` qualifier."
		   });	
		addAnnotation
		  ((getAction__Match__Context_EObject_String_String_Map()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Matching context, e.g. ``CDOTransactionContext``."
		   });	
		addAnnotation
		  ((getAction__Match__Context_EObject_String_String_Map()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Permission target object. "
		   });	
		addAnnotation
		  ((getAction__Match__Context_EObject_String_String_Map()).getEParameters().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Action name, a verb. E.g. ``read`` or ``create``"
		   });	
		addAnnotation
		  ((getAction__Match__Context_EObject_String_String_Map()).getEParameters().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Qualifier, a noun, e.g. ``description`` for a description attribute or ``doSomething(java.lang.String)`` for an operation.\r\nQualifier is typically a feature/operation path."
		   });	
		addAnnotation
		  ((getAction__Match__Context_EObject_String_String_Map()).getEParameters().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Environment can be used to parameterize conditional actions. \r\nFor example an application can define an action class ``TransferFunds`` with ``amountLimit`` ``BigDecimal`` attribute and match logic comparing ``amount`` key of the environment to the ``amount`` attribute of the action and matching only if the key is equal or greater than the attribute.. \r\nThen the application model may contain ``largeTransfer`` action instance with amount set to, say, ``10000``. Permission to execute this action then can be allowed to denied  to some principals.\r\n"
		   });	
		addAnnotation
		  (getAction__CreatePrincipalPermission(), 
		   source, 
		   new String[] {
			 "documentation", "Creates a permission for this action. \r\nSubclasses may customize permissions created for actions. \r\nE.g. ``transferFunds`` action may create a conditional permission\r\nwich checks transfer amount and matches only if the amount is less or greater\r\nthan a specified limit.\r\n"
		   });	
		addAnnotation
		  (getAction__CreateProtectedPermission(), 
		   source, 
		   new String[] {
			 "documentation", "Creates a permission for this action. \r\nSubclasses may customize permissions created for actions. \r\nE.g. ``transferFunds`` action may create a conditional permission\r\nwich checks transfer amount and matches only if the amount is less or greater\r\nthan a specified limit.\r\n"
		   });	
		addAnnotation
		  (getAction_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Action display name, e.g. \"Post transaction\"."
		   });	
		addAnnotation
		  (getAction_IncludePatterns(), 
		   source, 
		   new String[] {
			 "documentation", "Patterns to match - ``<action>:<qualifier>`` string.  ``*`` matches any character sequence.\r\nAction is matched if it matches at least one include pattern and none of exclude patterns.\r\nIf empty, then action is not matched. E.g. grantable actions may not define their own patterns, but be just gropings of lower level actions. "
		   });	
		addAnnotation
		  (getAction_ExcludePatterns(), 
		   source, 
		   new String[] {
			 "documentation", "Patterns to exclude from the match - ``<action>:<qualifier>`` string.  ``*`` matches any character sequence. \r\nAction is matched if it matches at least one include pattern and none of exclude patterns.\r\n"
		   });	
		addAnnotation
		  (getAction_Grantable(), 
		   source, 
		   new String[] {
			 "documentation", "Only grantable actions can have permission associations. \r\nGrantable action corresponds to a user story or to a role. \r\nA non-grantable action shall have an impliedBy relationship with at least one grantable action or be contained in a grantable action.\r\nUse of grantable actions allows to use fine-grained action permission checks at development time and define coarse-grained user stories (grantable actions implying or containing other actions) at runtime time."
		   });	
		addAnnotation
		  (getAction_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Action description."
		   });	
		addAnnotation
		  (getAction_Implies(), 
		   source, 
		   new String[] {
			 "documentation", "References actions which are explicitly implied by this action. \r\n"
		   });	
		addAnnotation
		  (getAction_ImpliedBy(), 
		   source, 
		   new String[] {
			 "documentation", "Opposite to ``implies``."
		   });	
		addAnnotation
		  (getAction_Category(), 
		   source, 
		   new String[] {
			 "documentation", "Categories allow to group related actions."
		   });	
		addAnnotation
		  (getAction_Children(), 
		   source, 
		   new String[] {
			 "documentation", "Child actions, implicitly implied by the parent action."
		   });	
		addAnnotation
		  (principalEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permissions to perform actions on model elements are granted or denied to principals."
		   });	
		addAnnotation
		  (getPrincipal__Authorize__Context_EObject_String_String_Map(), 
		   source, 
		   new String[] {
			 "documentation", "Authorizes to execute an action with a qualifier on an object in a context and an environment.\r\nIf target is instanceof Protected then its authorize() method is invoked and takes precedence over the Principal\'s authorize()."
		   });	
		addAnnotation
		  ((getPrincipal__Authorize__Context_EObject_String_String_Map()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Authorization context."
		   });	
		addAnnotation
		  ((getPrincipal__Authorize__Context_EObject_String_String_Map()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Permission target object."
		   });	
		addAnnotation
		  ((getPrincipal__Authorize__Context_EObject_String_String_Map()).getEParameters().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Action name, e.g. ``read``, ``add``, or ``invoke``."
		   });	
		addAnnotation
		  ((getPrincipal__Authorize__Context_EObject_String_String_Map()).getEParameters().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Action qualifier. E.g. attribute name for ``read`` or operation signature for ``invoke``."
		   });	
		addAnnotation
		  ((getPrincipal__Authorize__Context_EObject_String_String_Map()).getEParameters().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Authorization environment, e.g. for ``transferFunds`` environment may contain ``transferAmount`` key.\r\nEnvironment may be used by conditional actions and/or conditional permissions."
		   });	
		addAnnotation
		  (getPrincipal__Accept__PrincipalVisitor(), 
		   source, 
		   new String[] {
			 "documentation", "Invokes ``PrincipalVisitor.visit()`` on this principal. For groups invokes ``accept(principalVisitor)`` on all group members."
		   });	
		addAnnotation
		  ((getPrincipal__Accept__PrincipalVisitor()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (getPrincipal__GetRealm(), 
		   source, 
		   new String[] {
			 "documentation", "Realm this principal belongs to. The default implementation traverses containment\r\nhierarchy until it finds a container of type ``Realm``."
		   });	
		addAnnotation
		  (getPrincipal_MemberOf(), 
		   source, 
		   new String[] {
			 "documentation", "Opposite to ``Group.members``."
		   });	
		addAnnotation
		  (getPrincipal_Permissions(), 
		   source, 
		   new String[] {
			 "documentation", "Permissions of this principal."
		   });	
		addAnnotation
		  (getPrincipal_Disabled(), 
		   source, 
		   new String[] {
			 "documentation", "Disabling a principal has the same effect as deleting it, \r\nbut with the ability to enable at some later point of time."
		   });	
		addAnnotation
		  (permissionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permission allows/denies a principal to perform an action on a model element."
		   });	
		addAnnotation
		  (getPermission__Authorize__Context_String_String_Map(), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  ((getPermission__Authorize__Context_String_String_Map()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  ((getPermission__Authorize__Context_String_String_Map()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  ((getPermission__Authorize__Context_String_String_Map()).getEParameters().get(2), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  ((getPermission__Authorize__Context_String_String_Map()).getEParameters().get(3), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (getPermission_Action(), 
		   source, 
		   new String[] {
			 "documentation", "Permission\'s action."
		   });	
		addAnnotation
		  (getPermission_Allow(), 
		   source, 
		   new String[] {
			 "documentation", "If true, action is allowed. Otherwise it is denied."
		   });	
		addAnnotation
		  (getPermission_Condition(), 
		   source, 
		   new String[] {
			 "documentation", "Condition is a boolean XPath expression evaluated by [JXPath](http://commons.apache.org/proper/commons-jxpath/).\r\n\r\nThe expression is evaluated in the context of the target object with the following variables:\r\n\r\n* ``context``\r\n* ``environment``\r\n* ``action``\r\n* ``qualifier``\r\n* ``permission``"
		   });	
		addAnnotation
		  (getPermission_StartDate(), 
		   source, 
		   new String[] {
			 "documentation", "Permission effective start date. Can be ``null``."
		   });	
		addAnnotation
		  (getPermission_EndDate(), 
		   source, 
		   new String[] {
			 "documentation", "Permission effective end date, can be ``null``."
		   });	
		addAnnotation
		  (getPermission_Comment(), 
		   source, 
		   new String[] {
			 "documentation", "Comment."
		   });	
		addAnnotation
		  (principalPermissionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permission owned by a principal to execute action on the target object."
		   });	
		addAnnotation
		  (getPrincipalPermission_Target(), 
		   source, 
		   new String[] {
			 "documentation", "Target object."
		   });	
		addAnnotation
		  (protectedPermissionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permission owned by a protected object to execute action by the referenced principal."
		   });	
		addAnnotation
		  (getProtectedPermission_Principal(), 
		   source, 
		   new String[] {
			 "documentation", "Target object."
		   });	
		addAnnotation
		  (loginPasswordCredentialsEClass, 
		   source, 
		   new String[] {
			 "documentation", "Credentials which consist of login name and password."
		   });	
		addAnnotation
		  (loginPasswordRealmEClass, 
		   source, 
		   new String[] {
			 "documentation", "Realm which supports user authentication with user name and password."
		   });	
		addAnnotation
		  (getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String(), 
		   source, 
		   new String[] {
			 "documentation", "Sets user password hash."
		   });	
		addAnnotation
		  ((getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "User to set password hash."
		   });	
		addAnnotation
		  ((getLoginPasswordRealm__SetPasswordHash__LoginPasswordHashUser_String()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Password to compute password hash from."
		   });	
		addAnnotation
		  (getLoginPasswordRealm__GetUser__String(), 
		   source, 
		   new String[] {
			 "documentation", "finds user by login name."
		   });	
		addAnnotation
		  ((getLoginPasswordRealm__GetUser__String()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "User login."
		   });	
		addAnnotation
		  (groupEClass, 
		   source, 
		   new String[] {
			 "documentation", "Group of principals. Group permissions are inherited by its members."
		   });	
		addAnnotation
		  (getGroup__IsMember__Principal(), 
		   source, 
		   new String[] {
			 "documentation", "Checks direct/indirect membership in the group."
		   });	
		addAnnotation
		  ((getGroup__IsMember__Principal()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Principal."
		   });	
		addAnnotation
		  (getGroup_Members(), 
		   source, 
		   new String[] {
			 "documentation", "Group members."
		   });	
		addAnnotation
		  (getGroup_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Group name."
		   });	
		addAnnotation
		  (getGroup_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Group description."
		   });	
		addAnnotation
		  (userEClass, 
		   source, 
		   new String[] {
			 "documentation", "User is a Principal which can be authenticated using credentials."
		   });	
		addAnnotation
		  (loginUserEClass, 
		   source, 
		   new String[] {
			 "documentation", "Login user is a principal identified by a login string. \r\nLogin user does not necessarily have a password. The realm performs only authorization, with authentication already performed by other layers.\r\n\r\nFor example:\r\n\r\n* A web application may transparently authenticate users against a Windows domain with Waffle or Apache NTML module. In this case the realm receives the name of already authenticated.\r\n* Two-way certificate authentication - the realm receives cn of the client certificate."
		   });	
		addAnnotation
		  (getLoginUser_Login(), 
		   source, 
		   new String[] {
			 "documentation", "A unique string identifying the user."
		   });	
		addAnnotation
		  (loginPasswordHashUserEClass, 
		   source, 
		   new String[] {
			 "documentation", "With LoginPasswordHashUser Realm performs authentication and authorization."
		   });	
		addAnnotation
		  (getLoginPasswordHashUser_PasswordHash(), 
		   source, 
		   new String[] {
			 "documentation", "Password one-way hash allows to verify a password provided during authentication, \r\nbut recovery of the original password from hash would require considerable \r\ncomputational resources."
		   });	
		addAnnotation
		  (guestEClass, 
		   source, 
		   new String[] {
			 "documentation", "Guest is a marker class which would typically be used in ``Realm.guest`` containment reference. The application may feature a Guest route service the application landing page and login form."
		   });	
		addAnnotation
		  (protectedEClass, 
		   source, 
		   new String[] {
			 "documentation", "Classes extending this interface maintain a list of permissions referencing principals."
		   });	
		addAnnotation
		  (getProtected__Authorize__Context_Principal_String_String_Map(), 
		   source, 
		   new String[] {
			 "documentation", "Authorizes the principal to execute an action with a qualifier in a context and an environment.\r\nIf return value of this methos is ALLOW or DENY, it takes precedence over Principal\'s authorize() return value\r\n(i.e. Principal\'s authorize() is not invoked if this method returns anything other than ABSTAIN).\r\n\r\nThe default implementation of this method iterates over protected permissions."
		   });	
		addAnnotation
		  ((getProtected__Authorize__Context_Principal_String_String_Map()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Authorization context."
		   });	
		addAnnotation
		  ((getProtected__Authorize__Context_Principal_String_String_Map()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Permission target object."
		   });	
		addAnnotation
		  ((getProtected__Authorize__Context_Principal_String_String_Map()).getEParameters().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Action name, e.g. ``read``, ``add``, or ``invoke``."
		   });	
		addAnnotation
		  ((getProtected__Authorize__Context_Principal_String_String_Map()).getEParameters().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Action qualifier. E.g. attribute name for ``read`` or operation signature for ``invoke``."
		   });	
		addAnnotation
		  ((getProtected__Authorize__Context_Principal_String_String_Map()).getEParameters().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Authorization environment, e.g. for ``transferFunds`` environment may contain ``transferAmount`` key.\r\nEnvironment may be used by conditional actions and/or conditional permissions."
		   });	
		addAnnotation
		  (getProtected__GetGrantees(), 
		   source, 
		   new String[] {
			 "documentation", "Returns a list of principals which can be granted access to this protected. \r\nThe default implementation returns a list of all realm users excluding roots\r\nplus everyone group."
		   });	
		addAnnotation
		  (getProtected_Permissions(), 
		   source, 
		   new String[] {
			 "documentation", "Permissions on this object."
		   });
	}

	/**
	 * Initializes the annotations for <b>org.nasdanika.cdo.web.render</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.nasdanika.cdo.web.render";	
		addAnnotation
		  (principalEClass, 
		   source, 
		   new String[] {
			 "label", "{{eclass-name}}",
			 "icon", "fa fa-user-o"
		   });	
		addAnnotation
		  (groupEClass, 
		   source, 
		   new String[] {
			 "label", "{{name}}",
			 "icon", "fa fa-group"
		   });	
		addAnnotation
		  (getGroup_Members(), 
		   source, 
		   new String[] {
			 "typed-element-location", "item",
			 "view", "list"
		   });	
		addAnnotation
		  (userEClass, 
		   source, 
		   new String[] {
			 "icon", "fa fa-user"
		   });	
		addAnnotation
		  (loginUserEClass, 
		   source, 
		   new String[] {
			 "label", "{{login}}"
		   });	
		addAnnotation
		  (guestEClass, 
		   source, 
		   new String[] {
			 "icon", "fa fa-user-secret"
		   });
	}

} //SecurityPackageImpl
