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
import org.nasdanika.cdo.security.ActionContainer;
import org.nasdanika.cdo.security.ActionKey;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginPasswordProtectionDomain;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Property;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityFactory;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyContainer;
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
	private EClass protectionDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginPasswordProtectionDomainEClass = null;

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
	private EClass actionKeyEClass = null;

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
	private EClass propertyEClass = null;

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
	private EClass actionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityPolicyContainerEClass = null;

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
	private EDataType accessDecisionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType contextEDataType = null;

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
	public EClass getProtectionDomain() {
		return protectionDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectionDomain_SuperUsersGroup() {
		return (EReference)protectionDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectionDomain_UnauthenticatedPrincipal() {
		return (EReference)protectionDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtectionDomain_EveryoneGroup() {
		return (EReference)protectionDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionDomain__Authenticate__Object() {
		return protectionDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionDomain__ClearPermissions__EObject() {
		return protectionDomainEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProtectionDomain__GetAllUsers() {
		return protectionDomainEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginPasswordProtectionDomain() {
		return loginPasswordProtectionDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoginPasswordProtectionDomain__SetPasswordHash__LoginPasswordHashUser_String() {
		return loginPasswordProtectionDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLoginPasswordProtectionDomain__GetUser__String() {
		return loginPasswordProtectionDomainEClass.getEOperations().get(1);
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
	public EReference getPrincipal_ProtectionDomain() {
		return (EReference)principalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__Authorize__SecurityPolicy_Context_Object_String_String_Map() {
		return principalEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__SendMessage__Principal_String_String_Object() {
		return principalEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__SendMessage__Principal_String_Map() {
		return principalEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPrincipal__SendMessage__Principal_String_String() {
		return principalEClass.getEOperations().get(3);
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
	public EAttribute getLoginUser_Disabled() {
		return (EAttribute)loginUserEClass.getEStructuralFeatures().get(1);
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
	public EClass getActionKey() {
		return actionKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionKey_Name() {
		return (EAttribute)actionKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionKey_TargetNamespaceURI() {
		return (EAttribute)actionKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionKey_TargetClass() {
		return (EAttribute)actionKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionKey_Qualifier() {
		return (EAttribute)actionKeyEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getAction_Description() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Grantable() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Implies() {
		return (EReference)actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_ImpliedBy() {
		return (EReference)actionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_PathPatterns() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Condition() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Properties() {
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
	public EOperation getAction__Match__Context_String_String_Map() {
		return actionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Value() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Type() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Comment() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
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
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Target() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_WithGrantOption() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(2);
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
	public EOperation getPermission__Authorize__SecurityPolicy_Context_Object_String_String_Map() {
		return permissionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionContainer() {
		return actionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionContainer_Actions() {
		return (EReference)actionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityPolicy() {
		return securityPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityPolicyContainer() {
		return securityPolicyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityPolicyContainer_Name() {
		return (EAttribute)securityPolicyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecurityPolicyContainer_Description() {
		return (EAttribute)securityPolicyContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityPolicyContainer_Imports() {
		return (EReference)securityPolicyContainerEClass.getEStructuralFeatures().get(2);
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
		loginPasswordCredentialsEClass = createEClass(LOGIN_PASSWORD_CREDENTIALS);

		protectionDomainEClass = createEClass(PROTECTION_DOMAIN);
		createEReference(protectionDomainEClass, PROTECTION_DOMAIN__SUPER_USERS_GROUP);
		createEReference(protectionDomainEClass, PROTECTION_DOMAIN__UNAUTHENTICATED_PRINCIPAL);
		createEReference(protectionDomainEClass, PROTECTION_DOMAIN__EVERYONE_GROUP);
		createEOperation(protectionDomainEClass, PROTECTION_DOMAIN___AUTHENTICATE__OBJECT);
		createEOperation(protectionDomainEClass, PROTECTION_DOMAIN___CLEAR_PERMISSIONS__EOBJECT);
		createEOperation(protectionDomainEClass, PROTECTION_DOMAIN___GET_ALL_USERS);

		loginPasswordProtectionDomainEClass = createEClass(LOGIN_PASSWORD_PROTECTION_DOMAIN);
		createEOperation(loginPasswordProtectionDomainEClass, LOGIN_PASSWORD_PROTECTION_DOMAIN___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING);
		createEOperation(loginPasswordProtectionDomainEClass, LOGIN_PASSWORD_PROTECTION_DOMAIN___GET_USER__STRING);

		principalEClass = createEClass(PRINCIPAL);
		createEReference(principalEClass, PRINCIPAL__MEMBER_OF);
		createEReference(principalEClass, PRINCIPAL__PERMISSIONS);
		createEReference(principalEClass, PRINCIPAL__PROTECTION_DOMAIN);
		createEOperation(principalEClass, PRINCIPAL___AUTHORIZE__SECURITYPOLICY_CONTEXT_OBJECT_STRING_STRING_MAP);
		createEOperation(principalEClass, PRINCIPAL___SEND_MESSAGE__PRINCIPAL_STRING_STRING_OBJECT);
		createEOperation(principalEClass, PRINCIPAL___SEND_MESSAGE__PRINCIPAL_STRING_MAP);
		createEOperation(principalEClass, PRINCIPAL___SEND_MESSAGE__PRINCIPAL_STRING_STRING);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__MEMBERS);
		createEAttribute(groupEClass, GROUP__NAME);
		createEAttribute(groupEClass, GROUP__DESCRIPTION);
		createEOperation(groupEClass, GROUP___IS_MEMBER__PRINCIPAL);

		userEClass = createEClass(USER);

		loginUserEClass = createEClass(LOGIN_USER);
		createEAttribute(loginUserEClass, LOGIN_USER__LOGIN);
		createEAttribute(loginUserEClass, LOGIN_USER__DISABLED);

		loginPasswordHashUserEClass = createEClass(LOGIN_PASSWORD_HASH_USER);
		createEAttribute(loginPasswordHashUserEClass, LOGIN_PASSWORD_HASH_USER__PASSWORD_HASH);

		actionKeyEClass = createEClass(ACTION_KEY);
		createEAttribute(actionKeyEClass, ACTION_KEY__NAME);
		createEAttribute(actionKeyEClass, ACTION_KEY__TARGET_NAMESPACE_URI);
		createEAttribute(actionKeyEClass, ACTION_KEY__TARGET_CLASS);
		createEAttribute(actionKeyEClass, ACTION_KEY__QUALIFIER);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__DESCRIPTION);
		createEAttribute(actionEClass, ACTION__GRANTABLE);
		createEReference(actionEClass, ACTION__IMPLIES);
		createEReference(actionEClass, ACTION__IMPLIED_BY);
		createEAttribute(actionEClass, ACTION__PATH_PATTERNS);
		createEAttribute(actionEClass, ACTION__CONDITION);
		createEReference(actionEClass, ACTION__PROPERTIES);
		createEAttribute(actionEClass, ACTION__CATEGORY);
		createEOperation(actionEClass, ACTION___MATCH__CONTEXT_STRING_STRING_MAP);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__VALUE);
		createEAttribute(propertyEClass, PROPERTY__TYPE);
		createEAttribute(propertyEClass, PROPERTY__COMMENT);

		permissionEClass = createEClass(PERMISSION);
		createEAttribute(permissionEClass, PERMISSION__ALLOW);
		createEReference(permissionEClass, PERMISSION__TARGET);
		createEAttribute(permissionEClass, PERMISSION__WITH_GRANT_OPTION);
		createEAttribute(permissionEClass, PERMISSION__START_DATE);
		createEAttribute(permissionEClass, PERMISSION__END_DATE);
		createEAttribute(permissionEClass, PERMISSION__COMMENT);
		createEOperation(permissionEClass, PERMISSION___AUTHORIZE__SECURITYPOLICY_CONTEXT_OBJECT_STRING_STRING_MAP);

		actionContainerEClass = createEClass(ACTION_CONTAINER);
		createEReference(actionContainerEClass, ACTION_CONTAINER__ACTIONS);

		securityPolicyEClass = createEClass(SECURITY_POLICY);

		securityPolicyContainerEClass = createEClass(SECURITY_POLICY_CONTAINER);
		createEAttribute(securityPolicyContainerEClass, SECURITY_POLICY_CONTAINER__NAME);
		createEAttribute(securityPolicyContainerEClass, SECURITY_POLICY_CONTAINER__DESCRIPTION);
		createEReference(securityPolicyContainerEClass, SECURITY_POLICY_CONTAINER__IMPORTS);

		// Create data types
		contextEDataType = createEDataType(CONTEXT);
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
		ETypeParameter protectionDomainEClass_CR = addETypeParameter(protectionDomainEClass, "CR");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getProtectionDomain());
		EGenericType g2 = createEGenericType(this.getLoginPasswordCredentials());
		g1.getETypeArguments().add(g2);
		loginPasswordProtectionDomainEClass.getEGenericSuperTypes().add(g1);
		groupEClass.getESuperTypes().add(this.getPrincipal());
		userEClass.getESuperTypes().add(this.getPrincipal());
		loginUserEClass.getESuperTypes().add(this.getUser());
		loginPasswordHashUserEClass.getESuperTypes().add(this.getLoginUser());
		actionEClass.getESuperTypes().add(this.getActionKey());
		actionEClass.getESuperTypes().add(this.getActionContainer());
		permissionEClass.getESuperTypes().add(this.getActionKey());
		securityPolicyContainerEClass.getESuperTypes().add(this.getSecurityPolicy());
		securityPolicyContainerEClass.getESuperTypes().add(this.getActionContainer());

		// Initialize classes, features, and operations; add parameters
		initEClass(loginPasswordCredentialsEClass, LoginPasswordCredentials.class, "LoginPasswordCredentials", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(protectionDomainEClass, ProtectionDomain.class, "ProtectionDomain", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtectionDomain_SuperUsersGroup(), this.getGroup(), null, "superUsersGroup", null, 0, 1, ProtectionDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtectionDomain_UnauthenticatedPrincipal(), this.getUser(), null, "unauthenticatedPrincipal", null, 0, 1, ProtectionDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtectionDomain_EveryoneGroup(), this.getGroup(), null, "everyoneGroup", null, 0, 1, ProtectionDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getProtectionDomain__Authenticate__Object(), this.getUser(), "authenticate", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(protectionDomainEClass_CR);
		addEParameter(op, g1, "credentials", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getProtectionDomain__ClearPermissions__EObject(), null, "clearPermissions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getProtectionDomain__GetAllUsers(), this.getUser(), "getAllUsers", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(loginPasswordProtectionDomainEClass, LoginPasswordProtectionDomain.class, "LoginPasswordProtectionDomain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLoginPasswordProtectionDomain__SetPasswordHash__LoginPasswordHashUser_String(), null, "setPasswordHash", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLoginPasswordHashUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "password", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLoginPasswordProtectionDomain__GetUser__String(), this.getUser(), "getUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "login", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(principalEClass, Principal.class, "Principal", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrincipal_MemberOf(), this.getGroup(), this.getGroup_Members(), "memberOf", null, 0, -1, Principal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrincipal_Permissions(), this.getPermission(), null, "permissions", null, 0, -1, Principal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getProtectionDomain());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getPrincipal_ProtectionDomain(), g1, null, "protectionDomain", null, 0, 1, Principal.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPrincipal__Authorize__SecurityPolicy_Context_Object_String_String_Map(), this.getAccessDecision(), "authorize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSecurityPolicy(), "securityPolicy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPrincipal__SendMessage__Principal_String_String_Object(), null, "sendMessage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "from", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "bodyMimeType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "body", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPrincipal__SendMessage__Principal_String_Map(), null, "sendMessage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "from", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "bodyMap", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPrincipal__SendMessage__Principal_String_String(), null, "sendMessage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "from", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "body", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_Members(), this.getPrincipal(), this.getPrincipal_MemberOf(), "members", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroup_Description(), ecorePackage.getEString(), "description", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGroup__IsMember__Principal(), ecorePackage.getEBoolean(), "isMember", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrincipal(), "principal", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(userEClass, User.class, "User", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loginUserEClass, LoginUser.class, "LoginUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoginUser_Login(), ecorePackage.getEString(), "login", null, 0, 1, LoginUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoginUser_Disabled(), ecorePackage.getEBoolean(), "disabled", null, 0, 1, LoginUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginPasswordHashUserEClass, LoginPasswordHashUser.class, "LoginPasswordHashUser", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoginPasswordHashUser_PasswordHash(), ecorePackage.getEByteArray(), "passwordHash", null, 0, 1, LoginPasswordHashUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionKeyEClass, ActionKey.class, "ActionKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActionKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionKey_TargetNamespaceURI(), ecorePackage.getEString(), "targetNamespaceURI", null, 0, 1, ActionKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionKey_TargetClass(), ecorePackage.getEString(), "targetClass", null, 0, 1, ActionKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionKey_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, 1, ActionKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Description(), ecorePackage.getEString(), "description", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Grantable(), ecorePackage.getEBoolean(), "grantable", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Implies(), this.getAction(), this.getAction_ImpliedBy(), "implies", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_ImpliedBy(), this.getAction(), this.getAction_Implies(), "impliedBy", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_PathPatterns(), ecorePackage.getEString(), "pathPatterns", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Properties(), this.getProperty(), null, "properties", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Category(), ecorePackage.getEString(), "category", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAction__Match__Context_String_String_Map(), ecorePackage.getEBoolean(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Type(), ecorePackage.getEString(), "type", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionEClass, Permission.class, "Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermission_Allow(), ecorePackage.getEBoolean(), "allow", "true", 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPermission_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_WithGrantOption(), ecorePackage.getEBoolean(), "withGrantOption", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_EndDate(), ecorePackage.getEDate(), "endDate", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPermission__Authorize__SecurityPolicy_Context_Object_String_String_Map(), this.getAccessDecision(), "authorize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSecurityPolicy(), "securityPolicy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "action", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "environment", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(actionContainerEClass, ActionContainer.class, "ActionContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionContainer_Actions(), this.getAction(), null, "actions", null, 0, -1, ActionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securityPolicyEClass, SecurityPolicy.class, "SecurityPolicy", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(securityPolicyContainerEClass, SecurityPolicyContainer.class, "SecurityPolicyContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecurityPolicyContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, SecurityPolicyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSecurityPolicyContainer_Description(), ecorePackage.getEString(), "description", null, 0, 1, SecurityPolicyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityPolicyContainer_Imports(), this.getActionContainer(), null, "imports", null, 0, -1, SecurityPolicyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(contextEDataType, Context.class, "Context", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(accessDecisionEDataType, AccessDecision.class, "AccessDecision", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
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
		  (protectionDomainEClass, 
		   source, 
		   new String[] {
			 "documentation", "<html>Protection domain establishes associations between users and actions which they can execute by the means of groups and permissions. There is no Role class/interface in the domain. A grantable actions is Role.</html>"
		   });	
		addAnnotation
		  (getProtectionDomain__Authenticate__Object(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Authenticates user given provided credentials, e.g. user login and password pair.</html>"
		   });	
		addAnnotation
		  (getProtectionDomain__ClearPermissions__EObject(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Removes permissions associated with the object allowing it to be detached from the model.</html>"
		   });	
		addAnnotation
		  (getProtectionDomain_SuperUsersGroup(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Superusers have all permissions. If this collection is empty, then any user is treated as a superuser. This functionality allows to configure the system after installation and then secure it by adding superusers.</html>"
		   });	
		addAnnotation
		  (getProtectionDomain_UnauthenticatedPrincipal(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Unauthenticated principal.</html>"
		   });	
		addAnnotation
		  (getProtectionDomain_EveryoneGroup(), 
		   source, 
		   new String[] {
			 "documentation", "<html>If this reference is set then all authenticated users are considered to be implicit members of this group.</html>"
		   });	
		addAnnotation
		  (getActionKey_Name(), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (getActionKey_TargetNamespaceURI(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Namespace URI of the target class\' package.</html>"
		   });	
		addAnnotation
		  (getActionKey_TargetClass(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Name of the target class.</html>"
		   });	
		addAnnotation
		  (getActionKey_Qualifier(), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (actionEClass, 
		   source, 
		   new String[] {
			 "documentation", "<html>Action defined for instances of given EClass</html>"
		   });	
		addAnnotation
		  (getAction_Grantable(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Only grantable actions can have permission associations. Grantable action corresponds to a role. A non-grantable action shall have an impliedBy relationship with at least one grantable action.\r\nUse of grantable actions allows to use fine-grained action permission checks at development time and define coarse-grained roles (grantable actions implying other actions) at runtime time.\r\n</html>"
		   });	
		addAnnotation
		  (getAction_Implies(), 
		   source, 
		   new String[] {
			 "documentation", "<html>References actions which are explicitly implied by this action. Actions are also implicitly implied by using action naming convention with dot as a separator - e.g. <code>myAction</code> implies <code>myAction.mySubAction</code>.</html>"
		   });	
		addAnnotation
		  (getAction_ImpliedBy(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Opposite to <code>implies</code>.</html>"
		   });	
		addAnnotation
		  (getAction_PathPatterns(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Path patterns allow to compute permissions using containment path, i.e. container object may define actions on contained objects. Containment path is computed from reference names, e.g. path of a customer account relative to the customer object would be <code>/accounts</code>, and relative to the system of records would be <code>/customers/accounts</code>. Container object\'s path is \'/\', If pathPatterns is empty then it is assumed that the action applies to the target object, i.e. that there is a single pattern <code>/</code>.</html>"
		   });	
		addAnnotation
		  (getAction_Category(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Path patterns allow to compute permissions using containment path, i.e. container object may define actions on contained objects. Containment path is computed from reference names, e.g. path of a customer account relative to the customer object would be <code>/accounts</code>, and relative to the system of records would be <code>/customers/accounts</code>. Container object\'s path is \'/\', If pathPatterns is empty then it is assumed that the action applies to the target object, i.e. that there is a single pattern <code>/</code>.</html>"
		   });	
		addAnnotation
		  (permissionEClass, 
		   source, 
		   new String[] {
			 "documentation", "<html>Permission is an association of a repository object with a principal.</html>"
		   });	
		addAnnotation
		  (getPermission_Allow(), 
		   source, 
		   new String[] {
			 "documentation", "<html>If true, action is allowed. Otherwise it is denied.</html>"
		   });	
		addAnnotation
		  (getPermission_Target(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Target object.</html>"
		   });	
		addAnnotation
		  (getPermission_WithGrantOption(), 
		   source, 
		   new String[] {
			 "documentation", "<html>If true, user can grant given action to other users.</html>"
		   });	
		addAnnotation
		  (getPermission_StartDate(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Permission effective start date. Can be null.</html>"
		   });	
		addAnnotation
		  (getPermission_EndDate(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Permission effective end date, can be null.</html>"
		   });	
		addAnnotation
		  (getActionContainer_Actions(), 
		   source, 
		   new String[] {
			 "documentation", "<html>Actions. Each action is associated with EClass.</html>"
		   });	
		addAnnotation
		  (getSecurityPolicyContainer_Name(), 
		   source, 
		   new String[] {
			 "documentation", ""
		   });
	}

} //SecurityPackageImpl
