/**
 */
package org.nasdanika.codegen.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;

import org.nasdanika.codegen.java.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavaFactory init() {
		try {
			JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory(JavaPackage.eNS_URI);
			if (theJavaFactory != null) {
				return theJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JavaPackage.JAVA_NATURE: return (EObject)createJavaNature();
			case JavaPackage.PACKAGE_FRAGMENT_ROOT: return (EObject)createPackageFragmentRoot();
			case JavaPackage.PACKAGE_FRAGMENT: return (EObject)createPackageFragment();
			case JavaPackage.COMPILATION_UNIT: return (EObject)createCompilationUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JavaPackage.IJAVA_PROJECT:
				return createIJavaProjectFromString(eDataType, initialValue);
			case JavaPackage.IPACKAGE_FRAGMENT_ROOT:
				return createIPackageFragmentRootFromString(eDataType, initialValue);
			case JavaPackage.IPACKAGE_FRAGMENT:
				return createIPackageFragmentFromString(eDataType, initialValue);
			case JavaPackage.ICOMPILATION_UNIT:
				return createICompilationUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JavaPackage.IJAVA_PROJECT:
				return convertIJavaProjectToString(eDataType, instanceValue);
			case JavaPackage.IPACKAGE_FRAGMENT_ROOT:
				return convertIPackageFragmentRootToString(eDataType, instanceValue);
			case JavaPackage.IPACKAGE_FRAGMENT:
				return convertIPackageFragmentToString(eDataType, instanceValue);
			case JavaPackage.ICOMPILATION_UNIT:
				return convertICompilationUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaNature createJavaNature() {
		JavaNatureImpl javaNature = new JavaNatureImpl();
		return javaNature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageFragmentRoot createPackageFragmentRoot() {
		PackageFragmentRootImpl packageFragmentRoot = new PackageFragmentRootImpl();
		return packageFragmentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageFragment createPackageFragment() {
		PackageFragmentImpl packageFragment = new PackageFragmentImpl();
		return packageFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationUnit createCompilationUnit() {
		CompilationUnitImpl compilationUnit = new CompilationUnitImpl();
		return compilationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IJavaProject createIJavaProjectFromString(EDataType eDataType, String initialValue) {
		return (IJavaProject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIJavaProjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPackageFragmentRoot createIPackageFragmentRootFromString(EDataType eDataType, String initialValue) {
		return (IPackageFragmentRoot)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIPackageFragmentRootToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPackageFragment createIPackageFragmentFromString(EDataType eDataType, String initialValue) {
		return (IPackageFragment)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIPackageFragmentToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ICompilationUnit createICompilationUnitFromString(EDataType eDataType, String initialValue) {
		return (ICompilationUnit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertICompilationUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage getJavaPackage() {
		return (JavaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavaPackage getPackage() {
		return JavaPackage.eINSTANCE;
	}

} //JavaFactoryImpl
