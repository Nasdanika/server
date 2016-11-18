/**
 */
package org.nasdanika.codegen.maven.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nasdanika.codegen.CodegenPackage;

import org.nasdanika.codegen.impl.CodegenPackageImpl;

import org.nasdanika.codegen.java.JavaPackage;

import org.nasdanika.codegen.java.impl.JavaPackageImpl;

import org.nasdanika.codegen.maven.MavenFactory;
import org.nasdanika.codegen.maven.MavenNature;
import org.nasdanika.codegen.maven.MavenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MavenPackageImpl extends EPackageImpl implements MavenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavenNatureEClass = null;

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
	 * @see org.nasdanika.codegen.maven.MavenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MavenPackageImpl() {
		super(eNS_URI, MavenFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MavenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MavenPackage init() {
		if (isInited) return (MavenPackage)EPackage.Registry.INSTANCE.getEPackage(MavenPackage.eNS_URI);

		// Obtain or create and register package
		MavenPackageImpl theMavenPackage = (MavenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MavenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MavenPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CodegenPackageImpl theCodegenPackage = (CodegenPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) instanceof CodegenPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CodegenPackage.eNS_URI) : CodegenPackage.eINSTANCE);
		JavaPackageImpl theJavaPackage = (JavaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI) instanceof JavaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JavaPackage.eNS_URI) : JavaPackage.eINSTANCE);

		// Create package meta-data objects
		theMavenPackage.createPackageContents();
		theCodegenPackage.createPackageContents();
		theJavaPackage.createPackageContents();

		// Initialize created meta-data
		theMavenPackage.initializePackageContents();
		theCodegenPackage.initializePackageContents();
		theJavaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMavenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MavenPackage.eNS_URI, theMavenPackage);
		return theMavenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMavenNature() {
		return mavenNatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MavenFactory getMavenFactory() {
		return (MavenFactory)getEFactoryInstance();
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
		mavenNatureEClass = createEClass(MAVEN_NATURE);
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
		mavenNatureEClass.getESuperTypes().add(theCodegenPackage.getNature());

		// Initialize classes, features, and operations; add parameters
		initEClass(mavenNatureEClass, MavenNature.class, "MavenNature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //MavenPackageImpl
