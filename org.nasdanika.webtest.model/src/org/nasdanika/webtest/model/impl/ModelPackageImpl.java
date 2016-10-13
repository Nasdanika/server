/**
 */
package org.nasdanika.webtest.model.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Description;
import org.nasdanika.webtest.model.InitializationResult;
import org.nasdanika.webtest.model.Link;
import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.Method;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testClassResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statsEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testSuiteResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedTestResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass screenshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass screenshotEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackTraceEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass proxyingResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorMethodResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageMethodResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testMethodResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum screenshotTypeEEnum = null;

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
	 * @see org.nasdanika.webtest.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptor() {
		return descriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptor_QualifiedName() {
		return (EAttribute)descriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptor_Title() {
		return (EAttribute)descriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptor_Description() {
		return (EReference)descriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptor_Links() {
		return (EReference)descriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptor_Category() {
		return (EAttribute)descriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Url() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Value() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_ContentType() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestSession() {
		return testSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestSession_TestResults() {
		return (EReference)testSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestSession_PageResults() {
		return (EReference)testSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestSession_ActorResults() {
		return (EReference)testSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestSession_Timestamp() {
		return (EAttribute)testSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestSession_Node() {
		return (EAttribute)testSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestSession_Screenshots() {
		return (EReference)testSessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestResult() {
		return testResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestResult_PageResults() {
		return (EReference)testResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestResult_ActorResults() {
		return (EReference)testResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestClassResult() {
		return testClassResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestClassResult_MethodResults() {
		return (EReference)testClassResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestClassResult_Stats() {
		return (EReference)testClassResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatsEntry() {
		return statsEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatsEntry_Key() {
		return (EAttribute)statsEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatsEntry_Value() {
		return (EAttribute)statsEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestSuiteResult() {
		return testSuiteResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestSuiteResult_Children() {
		return (EReference)testSuiteResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterizedTestResult() {
		return parameterizedTestResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterizedTestResult_ParameterDescriptors() {
		return (EReference)parameterizedTestResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScreenshot() {
		return screenshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshot_Location() {
		return (EAttribute)screenshotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshot_Height() {
		return (EAttribute)screenshotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshot_Width() {
		return (EAttribute)screenshotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshot_ContentType() {
		return (EAttribute)screenshotEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScreenshot_Entries() {
		return (EReference)screenshotEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationArgument() {
		return operationArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationArgument_Value() {
		return (EReference)operationArgumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationArgument_Type() {
		return (EAttribute)operationArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationArgument_Masked() {
		return (EAttribute)operationArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScreenshotEntry() {
		return screenshotEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshotEntry_Type() {
		return (EAttribute)screenshotEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshotEntry_Comment() {
		return (EAttribute)screenshotEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScreenshotEntry_Screenshot() {
		return (EReference)screenshotEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScreenshotEntry_SeqNo() {
		return (EAttribute)screenshotEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationResult() {
		return operationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Screenshots() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Children() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationResult_OperationName() {
		return (EAttribute)operationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Failure() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Error() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationResult_Start() {
		return (EAttribute)operationResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationResult_Finish() {
		return (EAttribute)operationResultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationResult_Status() {
		return (EAttribute)operationResultEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Arguments() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationResult_Result() {
		return (EReference)operationResultEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationResult_InstanceAliasPath() {
		return (EAttribute)operationResultEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationResult__AllScreenshots() {
		return operationResultEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrowable() {
		return throwableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrowable_Type() {
		return (EAttribute)throwableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrowable_Message() {
		return (EAttribute)throwableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_StackTrace() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_Supressed() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_Cause() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackTraceEntry() {
		return stackTraceEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_ClassName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_FileName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_MethodName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_LineNumber() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_Native() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProxyingResult() {
		return proxyingResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializationResult() {
		return initializationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodResult() {
		return methodResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodResult_Method() {
		return (EReference)methodResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorMethodResult() {
		return actorMethodResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageMethodResult() {
		return pageMethodResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestMethodResult() {
		return testMethodResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestMethodResult_Parameters() {
		return (EAttribute)testMethodResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorResult() {
		return actorResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorResult_Proxy() {
		return (EAttribute)actorResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorResult_Delegate() {
		return (EAttribute)actorResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorResult_Methods() {
		return (EReference)actorResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageResult() {
		return pageResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageResult_WebElements() {
		return (EReference)pageResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageResult_Proxy() {
		return (EAttribute)pageResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageResult_Delegate() {
		return (EAttribute)pageResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageResult_Methods() {
		return (EReference)pageResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebElement() {
		return webElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWebElement_Locators() {
		return (EReference)webElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocator() {
		return locatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocator_How() {
		return (EAttribute)locatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocator_Using() {
		return (EAttribute)locatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Value() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Type() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Comment() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Name() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_ParameterTypes() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_ReturnType() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_ExceptionTypes() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Results() {
		return (EReference)methodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperationStatus() {
		return operationStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScreenshotType() {
		return screenshotTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
		descriptorEClass = createEClass(DESCRIPTOR);
		createEAttribute(descriptorEClass, DESCRIPTOR__QUALIFIED_NAME);
		createEAttribute(descriptorEClass, DESCRIPTOR__TITLE);
		createEReference(descriptorEClass, DESCRIPTOR__DESCRIPTION);
		createEReference(descriptorEClass, DESCRIPTOR__LINKS);
		createEAttribute(descriptorEClass, DESCRIPTOR__CATEGORY);

		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__URL);
		createEAttribute(descriptionEClass, DESCRIPTION__VALUE);
		createEAttribute(descriptionEClass, DESCRIPTION__CONTENT_TYPE);

		testSessionEClass = createEClass(TEST_SESSION);
		createEReference(testSessionEClass, TEST_SESSION__TEST_RESULTS);
		createEReference(testSessionEClass, TEST_SESSION__PAGE_RESULTS);
		createEReference(testSessionEClass, TEST_SESSION__ACTOR_RESULTS);
		createEAttribute(testSessionEClass, TEST_SESSION__TIMESTAMP);
		createEAttribute(testSessionEClass, TEST_SESSION__NODE);
		createEReference(testSessionEClass, TEST_SESSION__SCREENSHOTS);

		testResultEClass = createEClass(TEST_RESULT);
		createEReference(testResultEClass, TEST_RESULT__PAGE_RESULTS);
		createEReference(testResultEClass, TEST_RESULT__ACTOR_RESULTS);

		testClassResultEClass = createEClass(TEST_CLASS_RESULT);
		createEReference(testClassResultEClass, TEST_CLASS_RESULT__METHOD_RESULTS);
		createEReference(testClassResultEClass, TEST_CLASS_RESULT__STATS);

		statsEntryEClass = createEClass(STATS_ENTRY);
		createEAttribute(statsEntryEClass, STATS_ENTRY__KEY);
		createEAttribute(statsEntryEClass, STATS_ENTRY__VALUE);

		testSuiteResultEClass = createEClass(TEST_SUITE_RESULT);
		createEReference(testSuiteResultEClass, TEST_SUITE_RESULT__CHILDREN);

		parameterizedTestResultEClass = createEClass(PARAMETERIZED_TEST_RESULT);
		createEReference(parameterizedTestResultEClass, PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS);

		screenshotEClass = createEClass(SCREENSHOT);
		createEAttribute(screenshotEClass, SCREENSHOT__LOCATION);
		createEAttribute(screenshotEClass, SCREENSHOT__HEIGHT);
		createEAttribute(screenshotEClass, SCREENSHOT__WIDTH);
		createEAttribute(screenshotEClass, SCREENSHOT__CONTENT_TYPE);
		createEReference(screenshotEClass, SCREENSHOT__ENTRIES);

		operationArgumentEClass = createEClass(OPERATION_ARGUMENT);
		createEAttribute(operationArgumentEClass, OPERATION_ARGUMENT__TYPE);
		createEAttribute(operationArgumentEClass, OPERATION_ARGUMENT__MASKED);
		createEReference(operationArgumentEClass, OPERATION_ARGUMENT__VALUE);

		screenshotEntryEClass = createEClass(SCREENSHOT_ENTRY);
		createEAttribute(screenshotEntryEClass, SCREENSHOT_ENTRY__TYPE);
		createEAttribute(screenshotEntryEClass, SCREENSHOT_ENTRY__COMMENT);
		createEReference(screenshotEntryEClass, SCREENSHOT_ENTRY__SCREENSHOT);
		createEAttribute(screenshotEntryEClass, SCREENSHOT_ENTRY__SEQ_NO);

		operationResultEClass = createEClass(OPERATION_RESULT);
		createEReference(operationResultEClass, OPERATION_RESULT__SCREENSHOTS);
		createEReference(operationResultEClass, OPERATION_RESULT__CHILDREN);
		createEAttribute(operationResultEClass, OPERATION_RESULT__OPERATION_NAME);
		createEReference(operationResultEClass, OPERATION_RESULT__FAILURE);
		createEReference(operationResultEClass, OPERATION_RESULT__ERROR);
		createEAttribute(operationResultEClass, OPERATION_RESULT__START);
		createEAttribute(operationResultEClass, OPERATION_RESULT__FINISH);
		createEAttribute(operationResultEClass, OPERATION_RESULT__STATUS);
		createEReference(operationResultEClass, OPERATION_RESULT__ARGUMENTS);
		createEReference(operationResultEClass, OPERATION_RESULT__RESULT);
		createEAttribute(operationResultEClass, OPERATION_RESULT__INSTANCE_ALIAS_PATH);
		createEOperation(operationResultEClass, OPERATION_RESULT___ALL_SCREENSHOTS);

		throwableEClass = createEClass(THROWABLE);
		createEAttribute(throwableEClass, THROWABLE__TYPE);
		createEAttribute(throwableEClass, THROWABLE__MESSAGE);
		createEReference(throwableEClass, THROWABLE__STACK_TRACE);
		createEReference(throwableEClass, THROWABLE__SUPRESSED);
		createEReference(throwableEClass, THROWABLE__CAUSE);

		stackTraceEntryEClass = createEClass(STACK_TRACE_ENTRY);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__CLASS_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__FILE_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__METHOD_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__LINE_NUMBER);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__NATIVE);

		proxyingResultEClass = createEClass(PROXYING_RESULT);

		pageMethodResultEClass = createEClass(PAGE_METHOD_RESULT);

		initializationResultEClass = createEClass(INITIALIZATION_RESULT);

		methodResultEClass = createEClass(METHOD_RESULT);
		createEReference(methodResultEClass, METHOD_RESULT__METHOD);

		actorMethodResultEClass = createEClass(ACTOR_METHOD_RESULT);

		testMethodResultEClass = createEClass(TEST_METHOD_RESULT);
		createEAttribute(testMethodResultEClass, TEST_METHOD_RESULT__PARAMETERS);

		actorResultEClass = createEClass(ACTOR_RESULT);
		createEAttribute(actorResultEClass, ACTOR_RESULT__PROXY);
		createEAttribute(actorResultEClass, ACTOR_RESULT__DELEGATE);
		createEReference(actorResultEClass, ACTOR_RESULT__METHODS);

		pageResultEClass = createEClass(PAGE_RESULT);
		createEReference(pageResultEClass, PAGE_RESULT__WEB_ELEMENTS);
		createEAttribute(pageResultEClass, PAGE_RESULT__PROXY);
		createEAttribute(pageResultEClass, PAGE_RESULT__DELEGATE);
		createEReference(pageResultEClass, PAGE_RESULT__METHODS);

		webElementEClass = createEClass(WEB_ELEMENT);
		createEReference(webElementEClass, WEB_ELEMENT__LOCATORS);

		locatorEClass = createEClass(LOCATOR);
		createEAttribute(locatorEClass, LOCATOR__HOW);
		createEAttribute(locatorEClass, LOCATOR__USING);

		linkEClass = createEClass(LINK);
		createEAttribute(linkEClass, LINK__VALUE);
		createEAttribute(linkEClass, LINK__TYPE);
		createEAttribute(linkEClass, LINK__COMMENT);

		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__NAME);
		createEAttribute(methodEClass, METHOD__PARAMETER_TYPES);
		createEAttribute(methodEClass, METHOD__RETURN_TYPE);
		createEAttribute(methodEClass, METHOD__EXCEPTION_TYPES);
		createEReference(methodEClass, METHOD__RESULTS);

		// Create enums
		operationStatusEEnum = createEEnum(OPERATION_STATUS);
		screenshotTypeEEnum = createEEnum(SCREENSHOT_TYPE);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		testSessionEClass.getESuperTypes().add(this.getDescriptor());
		testResultEClass.getESuperTypes().add(this.getDescriptor());
		testClassResultEClass.getESuperTypes().add(this.getTestResult());
		testSuiteResultEClass.getESuperTypes().add(this.getTestResult());
		parameterizedTestResultEClass.getESuperTypes().add(this.getTestSuiteResult());
		operationResultEClass.getESuperTypes().add(this.getDescriptor());
		proxyingResultEClass.getESuperTypes().add(this.getOperationResult());
		pageMethodResultEClass.getESuperTypes().add(this.getMethodResult());
		initializationResultEClass.getESuperTypes().add(this.getPageMethodResult());
		methodResultEClass.getESuperTypes().add(this.getOperationResult());
		actorMethodResultEClass.getESuperTypes().add(this.getMethodResult());
		testMethodResultEClass.getESuperTypes().add(this.getMethodResult());
		actorResultEClass.getESuperTypes().add(this.getDescriptor());
		pageResultEClass.getESuperTypes().add(this.getDescriptor());
		webElementEClass.getESuperTypes().add(this.getDescriptor());

		// Initialize classes, features, and operations; add parameters
		initEClass(descriptorEClass, org.nasdanika.webtest.model.Descriptor.class, "Descriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptor_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, org.nasdanika.webtest.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptor_Title(), ecorePackage.getEString(), "title", null, 0, 1, org.nasdanika.webtest.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptor_Description(), this.getDescription(), null, "description", null, 0, 1, org.nasdanika.webtest.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptor_Links(), this.getLink(), null, "links", null, 0, -1, org.nasdanika.webtest.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptor_Category(), ecorePackage.getEString(), "category", null, 0, -1, org.nasdanika.webtest.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Url(), ecorePackage.getEString(), "url", null, 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescription_Value(), ecorePackage.getEString(), "value", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescription_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testSessionEClass, TestSession.class, "TestSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestSession_TestResults(), this.getTestResult(), null, "testResults", null, 0, -1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSession_PageResults(), this.getPageResult(), null, "pageResults", null, 0, -1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSession_ActorResults(), this.getActorResult(), null, "actorResults", null, 0, -1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSession_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSession_Node(), ecorePackage.getEString(), "node", null, 0, 1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSession_Screenshots(), this.getScreenshot(), null, "screenshots", null, 0, -1, TestSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testResultEClass, TestResult.class, "TestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestResult_PageResults(), this.getPageResult(), null, "pageResults", null, 0, -1, TestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestResult_ActorResults(), this.getActorResult(), null, "actorResults", null, 0, -1, TestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testClassResultEClass, TestClassResult.class, "TestClassResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestClassResult_MethodResults(), this.getTestMethodResult(), null, "methodResults", null, 0, -1, TestClassResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestClassResult_Stats(), this.getStatsEntry(), null, "stats", null, 0, -1, TestClassResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statsEntryEClass, Map.Entry.class, "StatsEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatsEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatsEntry_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testSuiteResultEClass, TestSuiteResult.class, "TestSuiteResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestSuiteResult_Children(), this.getTestResult(), null, "children", null, 0, -1, TestSuiteResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterizedTestResultEClass, ParameterizedTestResult.class, "ParameterizedTestResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterizedTestResult_ParameterDescriptors(), this.getDescriptor(), null, "parameterDescriptors", null, 0, -1, ParameterizedTestResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(screenshotEClass, Screenshot.class, "Screenshot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScreenshot_Location(), ecorePackage.getEString(), "location", null, 0, 1, Screenshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreenshot_Height(), ecorePackage.getEInt(), "height", null, 0, 1, Screenshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreenshot_Width(), ecorePackage.getEInt(), "width", null, 0, 1, Screenshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreenshot_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, Screenshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScreenshot_Entries(), this.getScreenshotEntry(), this.getScreenshotEntry_Screenshot(), "entries", null, 0, -1, Screenshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationArgumentEClass, OperationArgument.class, "OperationArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationArgument_Type(), ecorePackage.getEString(), "type", null, 0, 1, OperationArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationArgument_Masked(), ecorePackage.getEBoolean(), "masked", null, 0, 1, OperationArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationArgument_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, OperationArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(screenshotEntryEClass, ScreenshotEntry.class, "ScreenshotEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScreenshotEntry_Type(), this.getScreenshotType(), "type", null, 0, 1, ScreenshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreenshotEntry_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, ScreenshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScreenshotEntry_Screenshot(), this.getScreenshot(), this.getScreenshot_Entries(), "screenshot", null, 0, 1, ScreenshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScreenshotEntry_SeqNo(), ecorePackage.getEInt(), "seqNo", null, 0, 1, ScreenshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationResultEClass, OperationResult.class, "OperationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationResult_Screenshots(), this.getScreenshotEntry(), null, "screenshots", null, 0, -1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationResult_Children(), this.getOperationResult(), null, "children", null, 0, -1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationResult_OperationName(), ecorePackage.getEString(), "operationName", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationResult_Failure(), this.getThrowable(), null, "failure", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationResult_Error(), this.getThrowable(), null, "error", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationResult_Start(), ecorePackage.getELong(), "start", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationResult_Finish(), ecorePackage.getELong(), "finish", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationResult_Status(), this.getOperationStatus(), "status", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationResult_Arguments(), this.getOperationArgument(), null, "arguments", null, 0, -1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationResult_Result(), this.getOperationArgument(), null, "result", null, 0, 1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationResult_InstanceAliasPath(), ecorePackage.getEString(), "instanceAliasPath", null, 0, -1, OperationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOperationResult__AllScreenshots(), this.getScreenshotEntry(), "allScreenshots", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(throwableEClass, org.nasdanika.webtest.model.Throwable.class, "Throwable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrowable_Type(), ecorePackage.getEString(), "type", null, 0, 1, org.nasdanika.webtest.model.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrowable_Message(), ecorePackage.getEString(), "message", null, 0, 1, org.nasdanika.webtest.model.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_StackTrace(), this.getStackTraceEntry(), null, "stackTrace", null, 0, -1, org.nasdanika.webtest.model.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_Supressed(), this.getThrowable(), null, "supressed", null, 0, -1, org.nasdanika.webtest.model.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_Cause(), this.getThrowable(), null, "cause", null, 0, 1, org.nasdanika.webtest.model.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackTraceEntryEClass, StackTraceEntry.class, "StackTraceEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStackTraceEntry_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proxyingResultEClass, ProxyingResult.class, "ProxyingResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageMethodResultEClass, PageMethodResult.class, "PageMethodResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initializationResultEClass, InitializationResult.class, "InitializationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodResultEClass, MethodResult.class, "MethodResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodResult_Method(), this.getMethod(), this.getMethod_Results(), "method", null, 0, 1, MethodResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorMethodResultEClass, ActorMethodResult.class, "ActorMethodResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(testMethodResultEClass, TestMethodResult.class, "TestMethodResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestMethodResult_Parameters(), ecorePackage.getEString(), "parameters", null, 0, -1, TestMethodResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorResultEClass, ActorResult.class, "ActorResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActorResult_Proxy(), ecorePackage.getEBoolean(), "proxy", null, 0, 1, ActorResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorResult_Delegate(), ecorePackage.getEBoolean(), "delegate", null, 0, 1, ActorResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorResult_Methods(), this.getMethod(), null, "methods", null, 0, -1, ActorResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageResultEClass, PageResult.class, "PageResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageResult_WebElements(), this.getWebElement(), null, "webElements", null, 0, -1, PageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageResult_Proxy(), ecorePackage.getEBoolean(), "proxy", null, 0, 1, PageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageResult_Delegate(), ecorePackage.getEBoolean(), "delegate", null, 0, 1, PageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageResult_Methods(), this.getMethod(), null, "methods", null, 0, -1, PageResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(webElementEClass, WebElement.class, "WebElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWebElement_Locators(), this.getLocator(), null, "locators", null, 0, -1, WebElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(locatorEClass, Locator.class, "Locator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocator_How(), ecorePackage.getEString(), "how", null, 0, 1, Locator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocator_Using(), ecorePackage.getEString(), "using", null, 0, 1, Locator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLink_Value(), ecorePackage.getEString(), "value", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Type(), ecorePackage.getEString(), "type", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_ParameterTypes(), ecorePackage.getEString(), "parameterTypes", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_ReturnType(), ecorePackage.getEString(), "returnType", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_ExceptionTypes(), ecorePackage.getEString(), "exceptionTypes", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Results(), this.getMethodResult(), this.getMethodResult_Method(), "results", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(operationStatusEEnum, OperationStatus.class, "OperationStatus");
		addEEnumLiteral(operationStatusEEnum, OperationStatus.PASS);
		addEEnumLiteral(operationStatusEEnum, OperationStatus.FAIL);
		addEEnumLiteral(operationStatusEEnum, OperationStatus.ERROR);
		addEEnumLiteral(operationStatusEEnum, OperationStatus.PENDING);

		initEEnum(screenshotTypeEEnum, ScreenshotType.class, "ScreenshotType");
		addEEnumLiteral(screenshotTypeEEnum, ScreenshotType.BEFORE);
		addEEnumLiteral(screenshotTypeEEnum, ScreenshotType.DURING);
		addEEnumLiteral(screenshotTypeEEnum, ScreenshotType.AFTER);
		addEEnumLiteral(screenshotTypeEEnum, ScreenshotType.EXCEPTION);

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
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "WebTest model is used to represent WebTest session results."
		   });	
		addAnnotation
		  (descriptorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base class for the majority of model elements."
		   });	
		addAnnotation
		  (getDescriptor_QualifiedName(), 
		   source, 
		   new String[] {
			 "documentation", "Fully qualified name of the element."
		   });	
		addAnnotation
		  (getDescriptor_Title(), 
		   source, 
		   new String[] {
			 "documentation", "Element title."
		   });	
		addAnnotation
		  (getDescriptor_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Element description."
		   });	
		addAnnotation
		  (getDescriptor_Links(), 
		   source, 
		   new String[] {
			 "documentation", "References (links) to external elements, e.g. user stories or acceptance criteria."
		   });	
		addAnnotation
		  (descriptionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Element description."
		   });	
		addAnnotation
		  (getDescription_Url(), 
		   source, 
		   new String[] {
			 "documentation", "Description URL for external descriptions."
		   });	
		addAnnotation
		  (getDescription_Value(), 
		   source, 
		   new String[] {
			 "documentation", "Description content. Each element represents a line for formats where line separators a significant, e.g. plain text."
		   });	
		addAnnotation
		  (getDescription_ContentType(), 
		   source, 
		   new String[] {
			 "documentation", "Content (MIME) type, e.g. text/html, text/plain, text/markdown."
		   });	
		addAnnotation
		  (testSessionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Test session is the root of the test results model."
		   });	
		addAnnotation
		  (getTestSession_TestResults(), 
		   source, 
		   new String[] {
			 "documentation", "Test session may contain one or more test results. Typically it contains one test\r\nresult and multiple tests are aggregated under a test suite."
		   });	
		addAnnotation
		  (getTestSession_PageResults(), 
		   source, 
		   new String[] {
			 "documentation", "Page results, which aggregate page invocation iformation across all tests."
		   });	
		addAnnotation
		  (getTestSession_ActorResults(), 
		   source, 
		   new String[] {
			 "documentation", "Actor results, which aggregate actor invocation information across all tests."
		   });	
		addAnnotation
		  (getTestSession_Timestamp(), 
		   source, 
		   new String[] {
			 "documentation", "Test session creation time."
		   });	
		addAnnotation
		  (getTestSession_Node(), 
		   source, 
		   new String[] {
			 "documentation", "Name of the computer (host name) on which tests were executed."
		   });	
		addAnnotation
		  (getTestSession_Screenshots(), 
		   source, 
		   new String[] {
			 "documentation", "Collection of all screenshots taken during the test session."
		   });	
		addAnnotation
		  (operationStatusEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Indicates successful test."
		   });	
		addAnnotation
		  (operationStatusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Indicates that the test has failed, e.g. assertions were not met or a web element was not found on a page."
		   });	
		addAnnotation
		  (operationStatusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Indicates an unexpected error thrown by a test, which might indicate an error in the test logic."
		   });	
		addAnnotation
		  (operationStatusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Indicates that the test is not implemented yet - either the test body is \r\nconsidered empty - no invocations to actor or page methods, or the method\r\nis annotated with @Pending annotation."
		   });	
		addAnnotation
		  (testResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base class for test results."
		   });	
		addAnnotation
		  (getTestResult_PageResults(), 
		   source, 
		   new String[] {
			 "documentation", "Contains page results, which hold aggregated page invocation information."
		   });	
		addAnnotation
		  (getTestResult_ActorResults(), 
		   source, 
		   new String[] {
			 "documentation", "Contains actor results, which hold aggregated actor invocation information."
		   });	
		addAnnotation
		  (testClassResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Results collected from a JUnit test class."
		   });	
		addAnnotation
		  (getTestClassResult_MethodResults(), 
		   source, 
		   new String[] {
			 "documentation", "Test class result contains test method results."
		   });	
		addAnnotation
		  (getTestClassResult_Stats(), 
		   source, 
		   new String[] {
			 "documentation", "Test statistics."
		   });	
		addAnnotation
		  (statsEntryEClass, 
		   source, 
		   new String[] {
			 "documentation", "Statistics entry, e.g. number of page method invocations."
		   });	
		addAnnotation
		  (getStatsEntry_Key(), 
		   source, 
		   new String[] {
			 "documentation", "Statistics entry name, e.g. \'invocations\'."
		   });	
		addAnnotation
		  (getStatsEntry_Value(), 
		   source, 
		   new String[] {
			 "documentation", "Statistics entry value."
		   });	
		addAnnotation
		  (testSuiteResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Test suite result is a collection of test results which can include other test suite results."
		   });	
		addAnnotation
		  (getTestSuiteResult_Children(), 
		   source, 
		   new String[] {
			 "documentation", "Test suite results."
		   });	
		addAnnotation
		  (parameterizedTestResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Parameterized test result is a collection of test results with different arguments."
		   });	
		addAnnotation
		  (getParameterizedTestResult_ParameterDescriptors(), 
		   source, 
		   new String[] {
			 "documentation", "Descriptors of test parameters."
		   });	
		addAnnotation
		  (screenshotEClass, 
		   source, 
		   new String[] {
			 "documentation", "Screenshot taken during test execution. Screenshots are de-duplicated and one screenshot can be referenced by\r\nmultiple operation results through screenshot entries."
		   });	
		addAnnotation
		  (getScreenshot_Location(), 
		   source, 
		   new String[] {
			 "documentation", "Location of the screenshot file relative to the model resource."
		   });	
		addAnnotation
		  (getScreenshot_Height(), 
		   source, 
		   new String[] {
			 "documentation", "Screenshot height in pixels."
		   });	
		addAnnotation
		  (getScreenshot_Width(), 
		   source, 
		   new String[] {
			 "documentation", "Screenshot width in pixels."
		   });	
		addAnnotation
		  (getScreenshot_ContentType(), 
		   source, 
		   new String[] {
			 "documentation", "Content type, e.g. \"image/png\" for .png files."
		   });	
		addAnnotation
		  (getScreenshot_Entries(), 
		   source, 
		   new String[] {
			 "documentation", "Screenshot entires referencing this screenshot."
		   });	
		addAnnotation
		  (operationArgumentEClass, 
		   source, 
		   new String[] {
			 "documentation", "Captures operation argument value and type."
		   });	
		addAnnotation
		  (getOperationArgument_Type(), 
		   source, 
		   new String[] {
			 "documentation", "Argument type, java.lang.String for masked parameters."
		   });	
		addAnnotation
		  (getOperationArgument_Masked(), 
		   source, 
		   new String[] {
			 "documentation", "True for masked parameters."
		   });	
		addAnnotation
		  (screenshotTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Indicates when a screenshot was taken."
		   });	
		addAnnotation
		  (screenshotTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Before operation (method/constructor) invocation."
		   });	
		addAnnotation
		  (screenshotTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Screenshot was explicitly taken during invocation with WebTestUtil.takeScreenshot() method."
		   });	
		addAnnotation
		  (screenshotTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "After operation invocation."
		   });	
		addAnnotation
		  (screenshotTypeEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "When operation threw an exception."
		   });	
		addAnnotation
		  (screenshotEntryEClass, 
		   source, 
		   new String[] {
			 "documentation", "Screenshot entry is an association class between operation result and a screenshot."
		   });	
		addAnnotation
		  (getScreenshotEntry_Type(), 
		   source, 
		   new String[] {
			 "documentation", "Indicates when screenshot was taken."
		   });	
		addAnnotation
		  (getScreenshotEntry_Comment(), 
		   source, 
		   new String[] {
			 "documentation", "Comment for explicitly taken screenshots."
		   });	
		addAnnotation
		  (getScreenshotEntry_Screenshot(), 
		   source, 
		   new String[] {
			 "documentation", "Reference to a screenshot."
		   });	
		addAnnotation
		  (operationResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base class for operation results where operation is a method or a constructor."
		   });	
		addAnnotation
		  (getOperationResult__AllScreenshots(), 
		   source, 
		   new String[] {
			 "documentation", "Returns a list of all screenshots taken by this operation and its children ordered and without duplicates."
		   });	
		addAnnotation
		  (getOperationResult_Screenshots(), 
		   source, 
		   new String[] {
			 "documentation", "Each operation may contain multiple screenshot entries, e.g. \r\na screenshot taken before operation invocation, screenshots taken explicitly during \r\noperation execution via WebTestUtil.TakeScreenshot(String comment) method,\r\nand screenshots taken after operation invocation or if operation threw an exception."
		   });	
		addAnnotation
		  (getOperationResult_Children(), 
		   source, 
		   new String[] {
			 "documentation", "Other operations invoked by this operation. E.g. test method result may contain\r\nactor method results, which in turn may contain page method results."
		   });	
		addAnnotation
		  (getOperationResult_OperationName(), 
		   source, 
		   new String[] {
			 "documentation", "Operation name. "
		   });	
		addAnnotation
		  (getOperationResult_Failure(), 
		   source, 
		   new String[] {
			 "documentation", "Root cause of the failure thrown by the operation."
		   });	
		addAnnotation
		  (getOperationResult_Error(), 
		   source, 
		   new String[] {
			 "documentation", "Root cause of the error thrown by the operation."
		   });	
		addAnnotation
		  (getOperationResult_Start(), 
		   source, 
		   new String[] {
			 "documentation", "Operation start time."
		   });	
		addAnnotation
		  (getOperationResult_Finish(), 
		   source, 
		   new String[] {
			 "documentation", "Operation finish time."
		   });	
		addAnnotation
		  (getOperationResult_Status(), 
		   source, 
		   new String[] {
			 "documentation", "Status of operation execution."
		   });	
		addAnnotation
		  (getOperationResult_Arguments(), 
		   source, 
		   new String[] {
			 "documentation", "Operation arguments."
		   });	
		addAnnotation
		  (getOperationResult_Result(), 
		   source, 
		   new String[] {
			 "documentation", "Operation return value, if any."
		   });	
		addAnnotation
		  (getOperationResult_InstanceAliasPath(), 
		   source, 
		   new String[] {
			 "documentation", "Instance alias can be used to differentiate between several instances of the same\r\ntype participating in a test.\r\n\r\nAlias path would be a size of 1 for top-level actors/pages and more than one for delegates."
		   });	
		addAnnotation
		  (throwableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Models java.lang.Throwable."
		   });	
		addAnnotation
		  (getThrowable_Type(), 
		   source, 
		   new String[] {
			 "documentation", "Throwable class name."
		   });	
		addAnnotation
		  (getThrowable_Message(), 
		   source, 
		   new String[] {
			 "documentation", "Error message."
		   });	
		addAnnotation
		  (getThrowable_StackTrace(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (getThrowable_Supressed(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (getThrowable_Cause(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (stackTraceEntryEClass, 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (getStackTraceEntry_ClassName(), 
		   source, 
		   new String[] {
			 "documentation", "Class name."
		   });	
		addAnnotation
		  (getStackTraceEntry_FileName(), 
		   source, 
		   new String[] {
			 "documentation", "File name."
		   });	
		addAnnotation
		  (getStackTraceEntry_MethodName(), 
		   source, 
		   new String[] {
			 "documentation", "Method name."
		   });	
		addAnnotation
		  (getStackTraceEntry_LineNumber(), 
		   source, 
		   new String[] {
			 "documentation", "Line number."
		   });	
		addAnnotation
		  (getStackTraceEntry_Native(), 
		   source, 
		   new String[] {
			 "documentation", "\'true\' for native methods."
		   });	
		addAnnotation
		  (proxyingResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of page constructor invocation by WebTestUtil.initElements() methods \r\nwhich take class name as an argument."
		   });	
		addAnnotation
		  (pageMethodResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of page method invocation."
		   });	
		addAnnotation
		  (initializationResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of page constructor invocation by WebTestUtil.initElements() methods \r\nwhich take class name as an argument."
		   });	
		addAnnotation
		  (methodResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of method invocation."
		   });	
		addAnnotation
		  (actorMethodResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of actor method invocation."
		   });	
		addAnnotation
		  (testMethodResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of test method invocation."
		   });	
		addAnnotation
		  (getTestMethodResult_Parameters(), 
		   source, 
		   new String[] {
			 "documentation", "Names of test parameters"
		   });	
		addAnnotation
		  (actorResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Results collected for actor invocations."
		   });	
		addAnnotation
		  (getActorResult_Proxy(), 
		   source, 
		   new String[] {
			 "documentation", "True if actor class is a proxy."
		   });	
		addAnnotation
		  (getActorResult_Delegate(), 
		   source, 
		   new String[] {
			 "documentation", "True if actor class is a proxy."
		   });	
		addAnnotation
		  (pageResultEClass, 
		   source, 
		   new String[] {
			 "documentation", "Result of page class interactions."
		   });	
		addAnnotation
		  (getPageResult_WebElements(), 
		   source, 
		   new String[] {
			 "documentation", "Information about the page web elements."
		   });	
		addAnnotation
		  (getPageResult_Proxy(), 
		   source, 
		   new String[] {
			 "documentation", "\'true\' if page class is a proxy."
		   });	
		addAnnotation
		  (getPageResult_Delegate(), 
		   source, 
		   new String[] {
			 "documentation", "True if actor class is a proxy."
		   });	
		addAnnotation
		  (webElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "Information about an interactive page web element, e.g. a link or a button."
		   });	
		addAnnotation
		  (getWebElement_Locators(), 
		   source, 
		   new String[] {
			 "documentation", "Web element locators."
		   });	
		addAnnotation
		  (locatorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Web element locator."
		   });	
		addAnnotation
		  (getLocator_How(), 
		   source, 
		   new String[] {
			 "documentation", "Indicates how web element should be located, e.g. by ID, by CSS, or by XPATH."
		   });	
		addAnnotation
		  (getLocator_Using(), 
		   source, 
		   new String[] {
			 "documentation", "Locator value, e.g. CSS path if value of \'how\' is \'CSS\'."
		   });	
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "documentation", "A link to an external resource. For example Actor interfaces may link to Story Model\r\nActors, Users, Personas or Roles; test methods may link to acceptance criteria."
		   });	
		addAnnotation
		  (getLink_Value(), 
		   source, 
		   new String[] {
			 "documentation", "Link value, e.g. URL."
		   });	
		addAnnotation
		  (getLink_Type(), 
		   source, 
		   new String[] {
			 "documentation", "Optional link type to differentiate between links if there is more than one."
		   });	
		addAnnotation
		  (getLink_Comment(), 
		   source, 
		   new String[] {
			 "documentation", "Optional link type to differentiate between links if there is more than one."
		   });	
		addAnnotation
		  (methodEClass, 
		   source, 
		   new String[] {
			 "documentation", "Actor or Page method."
		   });
	}

} //ModelPackageImpl
