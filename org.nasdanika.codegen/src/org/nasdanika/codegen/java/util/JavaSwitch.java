/**
 */
package org.nasdanika.codegen.java.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.nasdanika.codegen.Configuration;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.WorkFactory;
import org.nasdanika.codegen.Nature;

import org.nasdanika.codegen.java.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.codegen.java.JavaPackage
 * @generated
 */
public class JavaSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JavaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaSwitch() {
		if (modelPackage == null) {
			modelPackage = JavaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JavaPackage.JAVA_NATURE: {
				JavaNature javaNature = (JavaNature)theEObject;
				T1 result = caseJavaNature(javaNature);
				if (result == null) result = caseNature(javaNature);
				if (result == null) result = caseGenerator(javaNature);
				if (result == null) result = caseWorkFactory(javaNature);
				if (result == null) result = caseConfiguration(javaNature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.PACKAGE_FRAGMENT_ROOT: {
				PackageFragmentRoot packageFragmentRoot = (PackageFragmentRoot)theEObject;
				T1 result = casePackageFragmentRoot(packageFragmentRoot);
				if (result == null) result = caseGenerator(packageFragmentRoot);
				if (result == null) result = caseWorkFactory(packageFragmentRoot);
				if (result == null) result = caseConfiguration(packageFragmentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.PACKAGE_FRAGMENT: {
				PackageFragment packageFragment = (PackageFragment)theEObject;
				T1 result = casePackageFragment(packageFragment);
				if (result == null) result = caseGenerator(packageFragment);
				if (result == null) result = caseWorkFactory(packageFragment);
				if (result == null) result = caseConfiguration(packageFragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.COMPILATION_UNIT: {
				CompilationUnit compilationUnit = (CompilationUnit)theEObject;
				T1 result = caseCompilationUnit(compilationUnit);
				if (result == null) result = caseGenerator(compilationUnit);
				if (result == null) result = caseWorkFactory(compilationUnit);
				if (result == null) result = caseConfiguration(compilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.TEXT_COMPILATION_UNIT: {
				TextCompilationUnit textCompilationUnit = (TextCompilationUnit)theEObject;
				T1 result = caseTextCompilationUnit(textCompilationUnit);
				if (result == null) result = caseCompilationUnit(textCompilationUnit);
				if (result == null) result = caseGenerator(textCompilationUnit);
				if (result == null) result = caseWorkFactory(textCompilationUnit);
				if (result == null) result = caseConfiguration(textCompilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavaPackage.STRUCTURED_COMPILATION_UNIT: {
				StructuredCompilationUnit structuredCompilationUnit = (StructuredCompilationUnit)theEObject;
				T1 result = caseStructuredCompilationUnit(structuredCompilationUnit);
				if (result == null) result = caseCompilationUnit(structuredCompilationUnit);
				if (result == null) result = caseGenerator(structuredCompilationUnit);
				if (result == null) result = caseWorkFactory(structuredCompilationUnit);
				if (result == null) result = caseConfiguration(structuredCompilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseJavaNature(JavaNature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Fragment Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Fragment Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackageFragmentRoot(PackageFragmentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackageFragment(PackageFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompilationUnit(CompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTextCompilationUnit(TextCompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructuredCompilationUnit(StructuredCompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Work Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Work Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseWorkFactory(WorkFactory<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseGenerator(Generator<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNature(Nature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //JavaSwitch
