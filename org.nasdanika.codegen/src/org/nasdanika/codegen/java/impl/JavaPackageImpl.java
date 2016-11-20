/**
 */
package org.nasdanika.codegen.java.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;

import org.nasdanika.codegen.CodegenPackage;

import org.nasdanika.codegen.impl.CodegenPackageImpl;

import org.nasdanika.codegen.java.CompilationUnit;
import org.nasdanika.codegen.java.JavaFactory;
import org.nasdanika.codegen.java.JavaNature;
import org.nasdanika.codegen.java.JavaPackage;
import org.nasdanika.codegen.java.PackageFragment;
import org.nasdanika.codegen.java.PackageFragmentRoot;

import org.nasdanika.codegen.java.StructuredCompilationUnit;
import org.nasdanika.codegen.java.TextCompilationUnit;
import org.nasdanika.codegen.maven.MavenPackage;

import org.nasdanika.codegen.maven.impl.MavenPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaPackageImpl extends EPackageImpl implements JavaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaNatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageFragmentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageFragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textCompilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredCompilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iJavaProjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iPackageFragmentRootEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iPackageFragmentEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iCompilationUnitEDataType = null;

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
	 * @see org.nasdanika.codegen.java.JavaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavaPackageImpl() {
		super(eNS_URI, JavaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JavaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavaPackage init() {
		if (isInited) return (JavaPackage)EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI);

		// Obtain or create and register package
		JavaPackageImpl theJavaPackage = (JavaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		MavenPackageImpl theMavenPackage = (MavenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI) instanceof MavenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI) : MavenPackage.eINSTANCE);

		// Create package meta-data objects
		theJavaPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theMavenPackage.createPackageContents();

		// Initialize created meta-data
		theJavaPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theMavenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, theJavaPackage);
		return theJavaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaNature() {
		return javaNatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaNature_Packagefragmentroots() {
		return (EReference)javaNatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageFragmentRoot() {
		return packageFragmentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageFragmentRoot_Name() {
		return (EAttribute)packageFragmentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageFragmentRoot_Packagefragments() {
		return (EReference)packageFragmentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageFragment() {
		return packageFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageFragment_Name() {
		return (EAttribute)packageFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageFragment_Compilationunits() {
		return (EReference)packageFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilationUnit() {
		return compilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationUnit_Name() {
		return (EAttribute)compilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationUnit_Merge() {
		return (EAttribute)compilationUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationUnit_Format() {
		return (EAttribute)compilationUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextCompilationUnit() {
		return textCompilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextCompilationUnit_Generator() {
		return (EReference)textCompilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredCompilationUnit() {
		return structuredCompilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIJavaProject() {
		return iJavaProjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIPackageFragmentRoot() {
		return iPackageFragmentRootEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIPackageFragment() {
		return iPackageFragmentEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getICompilationUnit() {
		return iCompilationUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactory getJavaFactory() {
		return (JavaFactory)getEFactoryInstance();
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
		javaNatureEClass = createEClass(JAVA_NATURE);
		createEReference(javaNatureEClass, JAVA_NATURE__PACKAGEFRAGMENTROOTS);

		packageFragmentRootEClass = createEClass(PACKAGE_FRAGMENT_ROOT);
		createEAttribute(packageFragmentRootEClass, PACKAGE_FRAGMENT_ROOT__NAME);
		createEReference(packageFragmentRootEClass, PACKAGE_FRAGMENT_ROOT__PACKAGEFRAGMENTS);

		packageFragmentEClass = createEClass(PACKAGE_FRAGMENT);
		createEAttribute(packageFragmentEClass, PACKAGE_FRAGMENT__NAME);
		createEReference(packageFragmentEClass, PACKAGE_FRAGMENT__COMPILATIONUNITS);

		compilationUnitEClass = createEClass(COMPILATION_UNIT);
		createEAttribute(compilationUnitEClass, COMPILATION_UNIT__NAME);
		createEAttribute(compilationUnitEClass, COMPILATION_UNIT__MERGE);
		createEAttribute(compilationUnitEClass, COMPILATION_UNIT__FORMAT);

		textCompilationUnitEClass = createEClass(TEXT_COMPILATION_UNIT);
		createEReference(textCompilationUnitEClass, TEXT_COMPILATION_UNIT__GENERATOR);

		structuredCompilationUnitEClass = createEClass(STRUCTURED_COMPILATION_UNIT);

		// Create data types
		iJavaProjectEDataType = createEDataType(IJAVA_PROJECT);
		iPackageFragmentRootEDataType = createEDataType(IPACKAGE_FRAGMENT_ROOT);
		iPackageFragmentEDataType = createEDataType(IPACKAGE_FRAGMENT);
		iCompilationUnitEDataType = createEDataType(ICOMPILATION_UNIT);
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
		CodegenPackage theCodegenPackage = (CodegenPackage)EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		javaNatureEClass.getESuperTypes().add(theCodegenPackage.getNature());
		EGenericType g1 = createEGenericType(theCodegenPackage.getGenerator());
		EGenericType g2 = createEGenericType(this.getIPackageFragmentRoot());
		g1.getETypeArguments().add(g2);
		packageFragmentRootEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCodegenPackage.getGenerator());
		g2 = createEGenericType(this.getIPackageFragment());
		g1.getETypeArguments().add(g2);
		packageFragmentEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theCodegenPackage.getGenerator());
		g2 = createEGenericType(this.getICompilationUnit());
		g1.getETypeArguments().add(g2);
		compilationUnitEClass.getEGenericSuperTypes().add(g1);
		textCompilationUnitEClass.getESuperTypes().add(this.getCompilationUnit());
		structuredCompilationUnitEClass.getESuperTypes().add(this.getCompilationUnit());

		// Initialize classes, features, and operations; add parameters
		initEClass(javaNatureEClass, JavaNature.class, "JavaNature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaNature_Packagefragmentroots(), this.getPackageFragmentRoot(), null, "packagefragmentroots", null, 0, -1, JavaNature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageFragmentRootEClass, PackageFragmentRoot.class, "PackageFragmentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageFragmentRoot_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageFragmentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageFragmentRoot_Packagefragments(), this.getPackageFragment(), null, "packagefragments", null, 0, -1, PackageFragmentRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageFragmentEClass, PackageFragment.class, "PackageFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageFragment_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageFragment_Compilationunits(), this.getCompilationUnit(), null, "compilationunits", null, 0, -1, PackageFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compilationUnitEClass, CompilationUnit.class, "CompilationUnit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompilationUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, CompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilationUnit_Merge(), ecorePackage.getEBoolean(), "merge", "true", 0, 1, CompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilationUnit_Format(), ecorePackage.getEBoolean(), "format", "true", 0, 1, CompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textCompilationUnitEClass, TextCompilationUnit.class, "TextCompilationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theCodegenPackage.getGenerator());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEReference(getTextCompilationUnit_Generator(), g1, null, "generator", null, 0, 1, TextCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredCompilationUnitEClass, StructuredCompilationUnit.class, "StructuredCompilationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(iJavaProjectEDataType, IJavaProject.class, "IJavaProject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iPackageFragmentRootEDataType, IPackageFragmentRoot.class, "IPackageFragmentRoot", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iPackageFragmentEDataType, IPackageFragment.class, "IPackageFragment", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iCompilationUnitEDataType, ICompilationUnit.class, "ICompilationUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //JavaPackageImpl
