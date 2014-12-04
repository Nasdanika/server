/**
 */
package org.nasdanika.webtest.performance.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.core.JSONLoader;
import org.nasdanika.webtest.performance.DocumentTiming;
import org.nasdanika.webtest.performance.NavigationTiming;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.ResourceTiming;
import org.nasdanika.webtest.performance.TimingBase;

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
 * @see org.nasdanika.webtest.performance.PerformancePackage
 * @generated
 */
public class PerformanceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PerformancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceSwitch() {
		if (modelPackage == null) {
			modelPackage = PerformancePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PerformancePackage.JSON_LOADER: {
				JSONLoader jsonLoader = (JSONLoader)theEObject;
				T result = caseJSONLoader(jsonLoader);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.TIMING_BASE: {
				TimingBase timingBase = (TimingBase)theEObject;
				T result = caseTimingBase(timingBase);
				if (result == null) result = caseJSONLoader(timingBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.RESOURCE_TIMING: {
				ResourceTiming resourceTiming = (ResourceTiming)theEObject;
				T result = caseResourceTiming(resourceTiming);
				if (result == null) result = caseTimingBase(resourceTiming);
				if (result == null) result = caseJSONLoader(resourceTiming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.NAVIGATION_TIMING: {
				NavigationTiming navigationTiming = (NavigationTiming)theEObject;
				T result = caseNavigationTiming(navigationTiming);
				if (result == null) result = caseTimingBase(navigationTiming);
				if (result == null) result = caseJSONLoader(navigationTiming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PerformancePackage.DOCUMENT_TIMING: {
				DocumentTiming documentTiming = (DocumentTiming)theEObject;
				T result = caseDocumentTiming(documentTiming);
				if (result == null) result = caseResourceTiming(documentTiming);
				if (result == null) result = caseNavigationTiming(documentTiming);
				if (result == null) result = caseTimingBase(documentTiming);
				if (result == null) result = caseJSONLoader(documentTiming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JSON Loader</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JSON Loader</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJSONLoader(JSONLoader object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timing Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timing Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimingBase(TimingBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Timing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Timing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceTiming(ResourceTiming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Timing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Timing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationTiming(NavigationTiming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Timing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Timing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentTiming(DocumentTiming object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //PerformanceSwitch
