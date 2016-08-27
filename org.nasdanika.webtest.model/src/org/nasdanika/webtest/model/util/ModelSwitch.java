/**
 */
package org.nasdanika.webtest.model.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Coverage;
import org.nasdanika.webtest.model.Description;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.InitializationResult;
import org.nasdanika.webtest.model.Link;
import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.MethodResult;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.OperationArgument;
import org.nasdanika.webtest.model.OperationResult;
import org.nasdanika.webtest.model.PageMethodResult;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.ProxyingResult;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.ScreenshotEntry;
import org.nasdanika.webtest.model.StackTraceEntry;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestMethodResult;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSession;
import org.nasdanika.webtest.model.TestSuiteResult;
import org.nasdanika.webtest.model.WebElement;

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
 * @see org.nasdanika.webtest.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.DESCRIPTOR: {
				Descriptor descriptor = (Descriptor)theEObject;
				T result = caseDescriptor(descriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_SESSION: {
				TestSession testSession = (TestSession)theEObject;
				T result = caseTestSession(testSession);
				if (result == null) result = caseDescriptor(testSession);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_RESULT: {
				TestResult testResult = (TestResult)theEObject;
				T result = caseTestResult(testResult);
				if (result == null) result = caseDescriptor(testResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_CLASS_RESULT: {
				TestClassResult testClassResult = (TestClassResult)theEObject;
				T result = caseTestClassResult(testClassResult);
				if (result == null) result = caseTestResult(testClassResult);
				if (result == null) result = caseDescriptor(testClassResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.STATS_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Integer> statsEntry = (Map.Entry<String, Integer>)theEObject;
				T result = caseStatsEntry(statsEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_SUITE_RESULT: {
				TestSuiteResult testSuiteResult = (TestSuiteResult)theEObject;
				T result = caseTestSuiteResult(testSuiteResult);
				if (result == null) result = caseTestResult(testSuiteResult);
				if (result == null) result = caseDescriptor(testSuiteResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAMETERIZED_TEST_RESULT: {
				ParameterizedTestResult parameterizedTestResult = (ParameterizedTestResult)theEObject;
				T result = caseParameterizedTestResult(parameterizedTestResult);
				if (result == null) result = caseTestSuiteResult(parameterizedTestResult);
				if (result == null) result = caseTestResult(parameterizedTestResult);
				if (result == null) result = caseDescriptor(parameterizedTestResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SCREENSHOT: {
				Screenshot screenshot = (Screenshot)theEObject;
				T result = caseScreenshot(screenshot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OPERATION_ARGUMENT: {
				OperationArgument operationArgument = (OperationArgument)theEObject;
				T result = caseOperationArgument(operationArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SCREENSHOT_ENTRY: {
				ScreenshotEntry screenshotEntry = (ScreenshotEntry)theEObject;
				T result = caseScreenshotEntry(screenshotEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OPERATION_RESULT: {
				OperationResult operationResult = (OperationResult)theEObject;
				T result = caseOperationResult(operationResult);
				if (result == null) result = caseDescriptor(operationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.THROWABLE: {
				org.nasdanika.webtest.model.Throwable throwable = (org.nasdanika.webtest.model.Throwable)theEObject;
				T result = caseThrowable(throwable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.STACK_TRACE_ENTRY: {
				StackTraceEntry stackTraceEntry = (StackTraceEntry)theEObject;
				T result = caseStackTraceEntry(stackTraceEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROXYING_RESULT: {
				ProxyingResult proxyingResult = (ProxyingResult)theEObject;
				T result = caseProxyingResult(proxyingResult);
				if (result == null) result = caseOperationResult(proxyingResult);
				if (result == null) result = caseDescriptor(proxyingResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PAGE_METHOD_RESULT: {
				PageMethodResult pageMethodResult = (PageMethodResult)theEObject;
				T result = casePageMethodResult(pageMethodResult);
				if (result == null) result = caseMethodResult(pageMethodResult);
				if (result == null) result = caseOperationResult(pageMethodResult);
				if (result == null) result = caseDescriptor(pageMethodResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.INITIALIZATION_RESULT: {
				InitializationResult initializationResult = (InitializationResult)theEObject;
				T result = caseInitializationResult(initializationResult);
				if (result == null) result = casePageMethodResult(initializationResult);
				if (result == null) result = caseMethodResult(initializationResult);
				if (result == null) result = caseOperationResult(initializationResult);
				if (result == null) result = caseDescriptor(initializationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD_RESULT: {
				MethodResult methodResult = (MethodResult)theEObject;
				T result = caseMethodResult(methodResult);
				if (result == null) result = caseOperationResult(methodResult);
				if (result == null) result = caseDescriptor(methodResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTOR_METHOD_RESULT: {
				ActorMethodResult actorMethodResult = (ActorMethodResult)theEObject;
				T result = caseActorMethodResult(actorMethodResult);
				if (result == null) result = caseMethodResult(actorMethodResult);
				if (result == null) result = caseOperationResult(actorMethodResult);
				if (result == null) result = caseDescriptor(actorMethodResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEST_METHOD_RESULT: {
				TestMethodResult testMethodResult = (TestMethodResult)theEObject;
				T result = caseTestMethodResult(testMethodResult);
				if (result == null) result = caseMethodResult(testMethodResult);
				if (result == null) result = caseOperationResult(testMethodResult);
				if (result == null) result = caseDescriptor(testMethodResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COVERAGE: {
				Coverage coverage = (Coverage)theEObject;
				T result = caseCoverage(coverage);
				if (result == null) result = caseDescriptor(coverage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTOR_RESULT: {
				ActorResult actorResult = (ActorResult)theEObject;
				T result = caseActorResult(actorResult);
				if (result == null) result = caseDescriptor(actorResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PAGE_RESULT: {
				PageResult pageResult = (PageResult)theEObject;
				T result = casePageResult(pageResult);
				if (result == null) result = caseDescriptor(pageResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WEB_ELEMENT: {
				WebElement webElement = (WebElement)theEObject;
				T result = caseWebElement(webElement);
				if (result == null) result = caseDescriptor(webElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LOCATOR: {
				Locator locator = (Locator)theEObject;
				T result = caseLocator(locator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptor(Descriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescription(Description object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Session</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Session</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSession(TestSession object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestResult(TestResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClassResult(TestClassResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stats Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stats Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatsEntry(Map.Entry<String, Integer> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Suite Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Suite Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSuiteResult(TestSuiteResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Test Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Test Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTestResult(ParameterizedTestResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Screenshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Screenshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScreenshot(Screenshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationArgument(OperationArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Screenshot Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Screenshot Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScreenshotEntry(ScreenshotEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationResult(OperationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throwable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throwable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowable(org.nasdanika.webtest.model.Throwable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack Trace Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStackTraceEntry(StackTraceEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxying Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxying Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyingResult(ProxyingResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initialization Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initialization Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitializationResult(InitializationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodResult(MethodResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Method Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Method Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorMethodResult(ActorMethodResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Method Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Method Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageMethodResult(PageMethodResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Method Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Method Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestMethodResult(TestMethodResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Coverage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Coverage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoverage(Coverage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorResult(ActorResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageResult(PageResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebElement(WebElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocator(Locator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
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

} //ModelSwitch
