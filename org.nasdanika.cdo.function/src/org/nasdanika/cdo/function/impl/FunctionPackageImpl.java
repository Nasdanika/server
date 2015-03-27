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

import org.nasdanika.cdo.function.AbstractFunction;
import org.nasdanika.cdo.function.BoundFunction;
import org.nasdanika.cdo.function.FunctionFactory;
import org.nasdanika.cdo.function.FunctionPackage;

import org.nasdanika.core.Context;

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
	private EClass bindingEClass = null;

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
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinding_Key() {
		return (EAttribute)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_Value() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(1);
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

		boundFunctionEClass = createEClass(BOUND_FUNCTION);
		createEReference(boundFunctionEClass, BOUND_FUNCTION__TARGET);
		createEReference(boundFunctionEClass, BOUND_FUNCTION__BINDINGS);

		bindingEClass = createEClass(BINDING);
		createEAttribute(bindingEClass, BINDING__KEY);
		createEReference(bindingEClass, BINDING__VALUE);
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
		addETypeParameter(cdoTransactionContextFunctionEClass, "CR");
		ETypeParameter cdoTransactionContextFunctionEClass_MC = addETypeParameter(cdoTransactionContextFunctionEClass, "MC");
		addETypeParameter(cdoTransactionContextFunctionEClass, "T");
		addETypeParameter(cdoTransactionContextFunctionEClass, "R");
		ETypeParameter abstractFunctionEClass_CR = addETypeParameter(abstractFunctionEClass, "CR");
		ETypeParameter abstractFunctionEClass_MC = addETypeParameter(abstractFunctionEClass, "MC");
		ETypeParameter abstractFunctionEClass_T = addETypeParameter(abstractFunctionEClass, "T");
		ETypeParameter abstractFunctionEClass_R = addETypeParameter(abstractFunctionEClass, "R");
		ETypeParameter boundFunctionEClass_CR = addETypeParameter(boundFunctionEClass, "CR");
		ETypeParameter boundFunctionEClass_MC = addETypeParameter(boundFunctionEClass, "MC");
		ETypeParameter boundFunctionEClass_T = addETypeParameter(boundFunctionEClass, "T");
		ETypeParameter boundFunctionEClass_R = addETypeParameter(boundFunctionEClass, "R");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getContext());
		cdoTransactionContextFunctionEClass_MC.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		abstractFunctionEClass_MC.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		boundFunctionEClass_MC.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(this.getCDOTransactionContextFunction());
		EGenericType g2 = createEGenericType(abstractFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(abstractFunctionEClass_MC);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(abstractFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(abstractFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		abstractFunctionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractFunction());
		g2 = createEGenericType(boundFunctionEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(boundFunctionEClass_MC);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(boundFunctionEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(boundFunctionEClass_R);
		g1.getETypeArguments().add(g2);
		boundFunctionEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cdoTransactionContextFunctionEClass, CDOTransactionContextFunction.class, "CDOTransactionContextFunction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractFunctionEClass, AbstractFunction.class, "AbstractFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundFunctionEClass, BoundFunction.class, "BoundFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundFunction_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, BoundFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoundFunction_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, BoundFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Map.Entry.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinding_Key(), ecorePackage.getEIntegerObject(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FunctionPackageImpl
