/**
 */
package org.nasdanika.webtest.model.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Coverage;
import org.nasdanika.webtest.model.Description;
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.InitializationResult;
import org.nasdanika.webtest.model.Link;
import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.MethodResult;
import org.nasdanika.webtest.model.ModelFactory;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.OperationArgument;
import org.nasdanika.webtest.model.OperationResult;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.PageMethodResult;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.ParameterizedTestResult;
import org.nasdanika.webtest.model.ProxyingResult;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.ScreenshotEntry;
import org.nasdanika.webtest.model.ScreenshotType;
import org.nasdanika.webtest.model.StackTraceEntry;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestMethodResult;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSession;
import org.nasdanika.webtest.model.TestSuiteResult;
import org.nasdanika.webtest.model.WebElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
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
			case ModelPackage.DESCRIPTOR: return createDescriptor();
			case ModelPackage.DESCRIPTION: return createDescription();
			case ModelPackage.TEST_SESSION: return createTestSession();
			case ModelPackage.TEST_RESULT: return createTestResult();
			case ModelPackage.TEST_CLASS_RESULT: return createTestClassResult();
			case ModelPackage.STATS_ENTRY: return (EObject)createStatsEntry();
			case ModelPackage.TEST_SUITE_RESULT: return createTestSuiteResult();
			case ModelPackage.PARAMETERIZED_TEST_RESULT: return createParameterizedTestResult();
			case ModelPackage.SCREENSHOT: return createScreenshot();
			case ModelPackage.OPERATION_ARGUMENT: return createOperationArgument();
			case ModelPackage.SCREENSHOT_ENTRY: return createScreenshotEntry();
			case ModelPackage.OPERATION_RESULT: return createOperationResult();
			case ModelPackage.THROWABLE: return createThrowable();
			case ModelPackage.STACK_TRACE_ENTRY: return createStackTraceEntry();
			case ModelPackage.PROXYING_RESULT: return createProxyingResult();
			case ModelPackage.PAGE_METHOD_RESULT: return createPageMethodResult();
			case ModelPackage.INITIALIZATION_RESULT: return createInitializationResult();
			case ModelPackage.METHOD_RESULT: return createMethodResult();
			case ModelPackage.ACTOR_METHOD_RESULT: return createActorMethodResult();
			case ModelPackage.TEST_METHOD_RESULT: return createTestMethodResult();
			case ModelPackage.COVERAGE: return createCoverage();
			case ModelPackage.ACTOR_RESULT: return createActorResult();
			case ModelPackage.PAGE_RESULT: return createPageResult();
			case ModelPackage.WEB_ELEMENT: return createWebElement();
			case ModelPackage.LOCATOR: return createLocator();
			case ModelPackage.LINK: return createLink();
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
			case ModelPackage.OPERATION_STATUS:
				return createOperationStatusFromString(eDataType, initialValue);
			case ModelPackage.SCREENSHOT_TYPE:
				return createScreenshotTypeFromString(eDataType, initialValue);
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
			case ModelPackage.OPERATION_STATUS:
				return convertOperationStatusToString(eDataType, instanceValue);
			case ModelPackage.SCREENSHOT_TYPE:
				return convertScreenshotTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Descriptor createDescriptor() {
		DescriptorImpl descriptor = new DescriptorImpl();
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description createDescription() {
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSession createTestSession() {
		TestSessionImpl testSession = new TestSessionImpl();
		return testSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestResult createTestResult() {
		TestResultImpl testResult = new TestResultImpl();
		return testResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClassResult createTestClassResult() {
		TestClassResultImpl testClassResult = new TestClassResultImpl();
		return testClassResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Integer> createStatsEntry() {
		StatsEntryImpl statsEntry = new StatsEntryImpl();
		return statsEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSuiteResult createTestSuiteResult() {
		TestSuiteResultImpl testSuiteResult = new TestSuiteResultImpl();
		return testSuiteResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedTestResult createParameterizedTestResult() {
		ParameterizedTestResultImpl parameterizedTestResult = new ParameterizedTestResultImpl();
		return parameterizedTestResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Screenshot createScreenshot() {
		ScreenshotImpl screenshot = new ScreenshotImpl();
		return screenshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationArgument createOperationArgument() {
		OperationArgumentImpl operationArgument = new OperationArgumentImpl();
		return operationArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenshotEntry createScreenshotEntry() {
		ScreenshotEntryImpl screenshotEntry = new ScreenshotEntryImpl();
		return screenshotEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationResult createOperationResult() {
		OperationResultImpl operationResult = new OperationResultImpl();
		return operationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.webtest.model.Throwable createThrowable() {
		ThrowableImpl throwable = new ThrowableImpl();
		return throwable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackTraceEntry createStackTraceEntry() {
		StackTraceEntryImpl stackTraceEntry = new StackTraceEntryImpl();
		return stackTraceEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyingResult createProxyingResult() {
		ProxyingResultImpl proxyingResult = new ProxyingResultImpl();
		return proxyingResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializationResult createInitializationResult() {
		InitializationResultImpl initializationResult = new InitializationResultImpl();
		return initializationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodResult createMethodResult() {
		MethodResultImpl methodResult = new MethodResultImpl();
		return methodResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorMethodResult createActorMethodResult() {
		ActorMethodResultImpl actorMethodResult = new ActorMethodResultImpl();
		return actorMethodResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMethodResult createPageMethodResult() {
		PageMethodResultImpl pageMethodResult = new PageMethodResultImpl();
		return pageMethodResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestMethodResult createTestMethodResult() {
		TestMethodResultImpl testMethodResult = new TestMethodResultImpl();
		return testMethodResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Coverage createCoverage() {
		CoverageImpl coverage = new CoverageImpl();
		return coverage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorResult createActorResult() {
		ActorResultImpl actorResult = new ActorResultImpl();
		return actorResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageResult createPageResult() {
		PageResultImpl pageResult = new PageResultImpl();
		return pageResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebElement createWebElement() {
		WebElementImpl webElement = new WebElementImpl();
		return webElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locator createLocator() {
		LocatorImpl locator = new LocatorImpl();
		return locator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationStatus createOperationStatusFromString(EDataType eDataType, String initialValue) {
		OperationStatus result = OperationStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenshotType createScreenshotTypeFromString(EDataType eDataType, String initialValue) {
		ScreenshotType result = ScreenshotType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScreenshotTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
