/**
 */
package org.nasdanika.cdo.function.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.function.AbstractFunction;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.CDOServiceBinding;
import org.nasdanika.cdo.function.CommandFunction;
import org.nasdanika.cdo.function.ContextArgument;
import org.nasdanika.cdo.function.FunctionFactory;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.JavaFunction;
import org.nasdanika.cdo.function.JavaScriptFunction;
import org.nasdanika.cdo.function.ObjectMethodFunction;
import org.nasdanika.cdo.function.ServiceMethodFunction;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.Context;
import org.nasdanika.function.ServiceBinding;
import org.nasdanika.function.cdo.CDOTransactionContextFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionPackageImpl extends EPackageImpl implements FunctionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cdoTransactionContextFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cdoServiceBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaScriptFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectMethodFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceMethodFunctionEClass = null;

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FunctionPackageImpl() {
		super(eNS_URI, FunctionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FunctionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FunctionPackage init() {
		if (isInited) return (FunctionPackage)EPackage.Registry.INSTANCE.getEPackage(FunctionPackage.eNS_URI);

		// Obtain or create and register package
		FunctionPackageImpl theFunctionPackage = (FunctionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FunctionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FunctionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BoxingPackage.eINSTANCE.eClass();
		SecurityPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFunctionPackage.createPackageContents();

		// Initialize created meta-data
		theFunctionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFunctionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FunctionPackage.eNS_URI, theFunctionPackage);
		return theFunctionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCDOTransactionContextFunction() {
		return cdoTransactionContextFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractFunction() {
		return abstractFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFunction_RunAs() {
		return (EReference)abstractFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundFunction() {
		return boundFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundFunction_Target() {
		return (EReference)boundFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundFunction_Bindings() {
		return (EReference)boundFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgumentBinding() {
		return argumentBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgumentBinding_Key() {
		return (EAttribute)argumentBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgumentBinding_Value() {
		return (EReference)argumentBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceBinding() {
		return serviceBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCDOServiceBinding() {
		return cdoServiceBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCDOServiceBinding_Filter() {
		return (EAttribute)cdoServiceBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCDOServiceBinding_ServiceType() {
		return (EAttribute)cdoServiceBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextArgument() {
		return contextArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandFunction() {
		return commandFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandFunction_Target() {
		return (EReference)commandFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandFunction_ParameterTypes() {
		return (EReference)commandFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandFunction_ReturnType() {
		return (EReference)commandFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaFunction() {
		return javaFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaFunction_ParameterTypes() {
		return (EReference)javaFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaFunction_ReturnType() {
		return (EReference)javaFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaFunction_ThrownExceptions() {
		return (EReference)javaFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaFunction_ParameterNames() {
		return (EAttribute)javaFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaFunction_Code() {
		return (EAttribute)javaFunctionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaFunction_CodeURL() {
		return (EAttribute)javaFunctionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptBinding() {
		return scriptBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptBinding_Key() {
		return (EAttribute)scriptBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptBinding_Value() {
		return (EReference)scriptBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaScriptFunction() {
		return javaScriptFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaScriptFunction_Code() {
		return (EAttribute)javaScriptFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaScriptFunction_CodeURL() {
		return (EAttribute)javaScriptFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaScriptFunction_ParameterNames() {
		return (EAttribute)javaScriptFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaScriptFunction_Bindings() {
		return (EReference)javaScriptFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectMethodFunction() {
		return objectMethodFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectMethodFunction_Target() {
		return (EReference)objectMethodFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectMethodFunction_MethodName() {
		return (EAttribute)objectMethodFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectMethodFunction_ParameterTypes() {
		return (EReference)objectMethodFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceMethodFunction() {
		return serviceMethodFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethodFunction_ServiceType() {
		return (EAttribute)serviceMethodFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethodFunction_Filter() {
		return (EAttribute)serviceMethodFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethodFunction_MethodName() {
		return (EAttribute)serviceMethodFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceMethodFunction_ParameterTypes() {
		return (EReference)serviceMethodFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionFactory getFunctionFactory() {
		return (FunctionFactory)getEFactoryInstance();
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
		contextEClass = createEClass(CONTEXT);

		cdoTransactionContextFunctionEClass = createEClass(CDO_TRANSACTION_CONTEXT_FUNCTION);

		abstractFunctionEClass = createEClass(ABSTRACT_FUNCTION);
		createEReference(abstractFunctionEClass, ABSTRACT_FUNCTION__RUN_AS);

		boundFunctionEClass = createEClass(BOUND_FUNCTION);
		createEReference(boundFunctionEClass, BOUND_FUNCTION__TARGET);
		createEReference(boundFunctionEClass, BOUND_FUNCTION__BINDINGS);

		argumentBindingEClass = createEClass(ARGUMENT_BINDING);
		createEAttribute(argumentBindingEClass, ARGUMENT_BINDING__KEY);
		createEReference(argumentBindingEClass, ARGUMENT_BINDING__VALUE);

		serviceBindingEClass = createEClass(SERVICE_BINDING);

		cdoServiceBindingEClass = createEClass(CDO_SERVICE_BINDING);
		createEAttribute(cdoServiceBindingEClass, CDO_SERVICE_BINDING__FILTER);
		createEAttribute(cdoServiceBindingEClass, CDO_SERVICE_BINDING__SERVICE_TYPE);

		contextArgumentEClass = createEClass(CONTEXT_ARGUMENT);

		commandFunctionEClass = createEClass(COMMAND_FUNCTION);
		createEReference(commandFunctionEClass, COMMAND_FUNCTION__TARGET);
		createEReference(commandFunctionEClass, COMMAND_FUNCTION__PARAMETER_TYPES);
		createEReference(commandFunctionEClass, COMMAND_FUNCTION__RETURN_TYPE);

		javaFunctionEClass = createEClass(JAVA_FUNCTION);
		createEReference(javaFunctionEClass, JAVA_FUNCTION__PARAMETER_TYPES);
		createEReference(javaFunctionEClass, JAVA_FUNCTION__RETURN_TYPE);
		createEReference(javaFunctionEClass, JAVA_FUNCTION__THROWN_EXCEPTIONS);
		createEAttribute(javaFunctionEClass, JAVA_FUNCTION__PARAMETER_NAMES);
		createEAttribute(javaFunctionEClass, JAVA_FUNCTION__CODE);
		createEAttribute(javaFunctionEClass, JAVA_FUNCTION__CODE_URL);

		scriptBindingEClass = createEClass(SCRIPT_BINDING);
		createEAttribute(scriptBindingEClass, SCRIPT_BINDING__KEY);
		createEReference(scriptBindingEClass, SCRIPT_BINDING__VALUE);

		javaScriptFunctionEClass = createEClass(JAVA_SCRIPT_FUNCTION);
		createEAttribute(javaScriptFunctionEClass, JAVA_SCRIPT_FUNCTION__CODE);
		createEAttribute(javaScriptFunctionEClass, JAVA_SCRIPT_FUNCTION__CODE_URL);
		createEAttribute(javaScriptFunctionEClass, JAVA_SCRIPT_FUNCTION__PARAMETER_NAMES);
		createEReference(javaScriptFunctionEClass, JAVA_SCRIPT_FUNCTION__BINDINGS);

		objectMethodFunctionEClass = createEClass(OBJECT_METHOD_FUNCTION);
		createEReference(objectMethodFunctionEClass, OBJECT_METHOD_FUNCTION__TARGET);
		createEAttribute(objectMethodFunctionEClass, OBJECT_METHOD_FUNCTION__METHOD_NAME);
		createEReference(objectMethodFunctionEClass, OBJECT_METHOD_FUNCTION__PARAMETER_TYPES);

		serviceMethodFunctionEClass = createEClass(SERVICE_METHOD_FUNCTION);
		createEAttribute(serviceMethodFunctionEClass, SERVICE_METHOD_FUNCTION__SERVICE_TYPE);
		createEAttribute(serviceMethodFunctionEClass, SERVICE_METHOD_FUNCTION__FILTER);
		createEAttribute(serviceMethodFunctionEClass, SERVICE_METHOD_FUNCTION__METHOD_NAME);
		createEReference(serviceMethodFunctionEClass, SERVICE_METHOD_FUNCTION__PARAMETER_TYPES);
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

		// Obtain other dependent packages
		SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage(SecurityPackage.eNS_URI);
		BoxingPackage theBoxingPackage = (BoxingPackage)EPackage.Registry.INSTANCE.getEPackage(BoxingPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(cdoTransactionContextFunctionEClass, "CR");
		addETypeParameter(cdoTransactionContextFunctionEClass, "T");
		addETypeParameter(cdoTransactionContextFunctionEClass, "R");
		ETypeParameter abstractFunctionEClass_CR = addETypeParameter(abstractFunctionEClass, "CR");
		ETypeParameter abstractFunctionEClass_T = addETypeParameter(abstractFunctionEClass, "T");
		ETypeParameter abstractFunctionEClass_R = addETypeParameter(abstractFunctionEClass, "R");
		ETypeParameter boundFunctionEClass_CR = addETypeParameter(boundFunctionEClass, "CR");
		ETypeParameter boundFunctionEClass_T = addETypeParameter(boundFunctionEClass, "T");
		ETypeParameter boundFunctionEClass_R = addETypeParameter(boundFunctionEClass, "R");
		ETypeParameter commandFunctionEClass_CR = addETypeParameter(commandFunctionEClass, "CR");
		ETypeParameter commandFunctionEClass_T = addETypeParameter(commandFunctionEClass, "T");
		ETypeParameter commandFunctionEClass_R = addETypeParameter(commandFunctionEClass, "R");
		ETypeParameter javaFunctionEClass_CR = addETypeParameter(javaFunctionEClass, "CR");
		ETypeParameter javaFunctionEClass_T = addETypeParameter(javaFunctionEClass, "T");
		ETypeParameter javaFunctionEClass_R = addETypeParameter(javaFunctionEClass, "R");
		ETypeParameter javaScriptFunctionEClass_CR = addETypeParameter(javaScriptFunctionEClass, "CR");
		ETypeParameter javaScriptFunctionEClass_T = addETypeParameter(javaScriptFunctionEClass, "T");
		ETypeParameter javaScriptFunctionEClass_R = addETypeParameter(javaScriptFunctionEClass, "R");
		ETypeParameter objectMethodFunctionEClass_CR = addETypeParameter(objectMethodFunctionEClass, "CR");
		ETypeParameter objectMethodFunctionEClass_T = addETypeParameter(objectMethodFunctionEClass, "T");
		ETypeParameter objectMethodFunctionEClass_R = addETypeParameter(objectMethodFunctionEClass, "R");
		ETypeParameter serviceMethodFunctionEClass_CR = addETypeParameter(serviceMethodFunctionEClass, "CR");
		ETypeParameter serviceMethodFunctionEClass_T = addETypeParameter(serviceMethodFunctionEClass, "T");
		ETypeParameter serviceMethodFunctionEClass_R = addETypeParameter(serviceMethodFunctionEClass, "R");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getCDOTransactionContextFunction());
		EGenericType g2 = createEGenericType(abstractFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(abstractFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(abstractFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		abstractFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(boundFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(boundFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(boundFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		boundFunctionEClass.getEGenericSuperTypes().add(g1);
		cdoServiceBindingEClass.getESuperTypes().add(this.getServiceBinding());
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(commandFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(commandFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(commandFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		commandFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(javaFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		javaFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(javaScriptFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaScriptFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(javaScriptFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		javaScriptFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(objectMethodFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(objectMethodFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(objectMethodFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		objectMethodFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(serviceMethodFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(serviceMethodFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(serviceMethodFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		serviceMethodFunctionEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cdoTransactionContextFunctionEClass, CDOTransactionContextFunction.class, "CDOTransactionContextFunction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractFunctionEClass, AbstractFunction.class, "AbstractFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractFunction_RunAs(), theSecurityPackage.getPrincipal(), null, "runAs", null, 0, 1, AbstractFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundFunctionEClass, BoundFunction.class, "BoundFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundFunction_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, BoundFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundFunction_Bindings(), this.getArgumentBinding(), null, "bindings", null, 0, -1, BoundFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentBindingEClass, Map.Entry.class, "ArgumentBinding", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgumentBinding_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgumentBinding_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceBindingEClass, ServiceBinding.class, "ServiceBinding", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cdoServiceBindingEClass, CDOServiceBinding.class, "CDOServiceBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCDOServiceBinding_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, CDOServiceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCDOServiceBinding_ServiceType(), ecorePackage.getEString(), "serviceType", null, 0, 1, CDOServiceBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextArgumentEClass, ContextArgument.class, "ContextArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandFunctionEClass, CommandFunction.class, "CommandFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandFunction_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, CommandFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(commandFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getCommandFunction_ParameterTypes(), g1, null, "parameterTypes", null, 0, -1, CommandFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(commandFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		initEReference(getCommandFunction_ReturnType(), g1, null, "returnType", null, 0, 1, CommandFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaFunctionEClass, JavaFunction.class, "JavaFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(javaFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getJavaFunction_ParameterTypes(), g1, null, "parameterTypes", null, 0, -1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(javaFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		initEReference(getJavaFunction_ReturnType(), g1, null, "returnType", null, 0, 1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEReference(getJavaFunction_ThrownExceptions(), g1, null, "thrownExceptions", null, 0, -1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaFunction_ParameterNames(), ecorePackage.getEString(), "parameterNames", null, 0, -1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaFunction_Code(), ecorePackage.getEString(), "code", null, 0, 1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaFunction_CodeURL(), ecorePackage.getEString(), "codeURL", null, 0, 1, JavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptBindingEClass, Map.Entry.class, "ScriptBinding", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptBinding_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptBinding_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaScriptFunctionEClass, JavaScriptFunction.class, "JavaScriptFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaScriptFunction_Code(), ecorePackage.getEString(), "code", null, 0, 1, JavaScriptFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaScriptFunction_CodeURL(), ecorePackage.getEString(), "codeURL", null, 0, 1, JavaScriptFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaScriptFunction_ParameterNames(), ecorePackage.getEString(), "parameterNames", null, 0, -1, JavaScriptFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaScriptFunction_Bindings(), this.getScriptBinding(), null, "bindings", null, 0, -1, JavaScriptFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectMethodFunctionEClass, ObjectMethodFunction.class, "ObjectMethodFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectMethodFunction_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, ObjectMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectMethodFunction_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, ObjectMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(objectMethodFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getObjectMethodFunction_ParameterTypes(), g1, null, "parameterTypes", null, 0, -1, ObjectMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceMethodFunctionEClass, ServiceMethodFunction.class, "ServiceMethodFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceMethodFunction_ServiceType(), ecorePackage.getEString(), "serviceType", null, 0, 1, ServiceMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceMethodFunction_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, ServiceMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceMethodFunction_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, ServiceMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theBoxingPackage.getClassBox());
		g2 = createEGenericType(serviceMethodFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getServiceMethodFunction_ParameterTypes(), g1, null, "parameterTypes", null, 0, -1, ServiceMethodFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FunctionPackageImpl
