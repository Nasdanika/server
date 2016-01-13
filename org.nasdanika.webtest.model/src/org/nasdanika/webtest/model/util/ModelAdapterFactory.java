/**
 */
package org.nasdanika.webtest.model.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.webtest.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseDescriptor(Descriptor object) {
				return createDescriptorAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseTestSession(TestSession object) {
				return createTestSessionAdapter();
			}
			@Override
			public Adapter caseTestResult(TestResult object) {
				return createTestResultAdapter();
			}
			@Override
			public Adapter caseTestClassResult(TestClassResult object) {
				return createTestClassResultAdapter();
			}
			@Override
			public Adapter caseStatsEntry(Map.Entry<String, Integer> object) {
				return createStatsEntryAdapter();
			}
			@Override
			public Adapter caseTestSuiteResult(TestSuiteResult object) {
				return createTestSuiteResultAdapter();
			}
			@Override
			public Adapter caseParameterizedTestResult(ParameterizedTestResult object) {
				return createParameterizedTestResultAdapter();
			}
			@Override
			public Adapter caseScreenshot(Screenshot object) {
				return createScreenshotAdapter();
			}
			@Override
			public Adapter caseOperationArgument(OperationArgument object) {
				return createOperationArgumentAdapter();
			}
			@Override
			public Adapter caseScreenshotEntry(ScreenshotEntry object) {
				return createScreenshotEntryAdapter();
			}
			@Override
			public Adapter caseOperationResult(OperationResult object) {
				return createOperationResultAdapter();
			}
			@Override
			public Adapter caseThrowable(org.nasdanika.webtest.model.Throwable object) {
				return createThrowableAdapter();
			}
			@Override
			public Adapter caseStackTraceEntry(StackTraceEntry object) {
				return createStackTraceEntryAdapter();
			}
			@Override
			public Adapter caseInitializationResult(InitializationResult object) {
				return createInitializationResultAdapter();
			}
			@Override
			public Adapter caseMethodResult(MethodResult object) {
				return createMethodResultAdapter();
			}
			@Override
			public Adapter caseActorMethodResult(ActorMethodResult object) {
				return createActorMethodResultAdapter();
			}
			@Override
			public Adapter casePageMethodResult(PageMethodResult object) {
				return createPageMethodResultAdapter();
			}
			@Override
			public Adapter caseTestMethodResult(TestMethodResult object) {
				return createTestMethodResultAdapter();
			}
			@Override
			public Adapter caseCoverage(Coverage object) {
				return createCoverageAdapter();
			}
			@Override
			public Adapter caseActorResult(ActorResult object) {
				return createActorResultAdapter();
			}
			@Override
			public Adapter casePageResult(PageResult object) {
				return createPageResultAdapter();
			}
			@Override
			public Adapter caseWebElement(WebElement object) {
				return createWebElementAdapter();
			}
			@Override
			public Adapter caseLocator(Locator object) {
				return createLocatorAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Descriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Descriptor
	 * @generated
	 */
	public Adapter createDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.TestSession <em>Test Session</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.TestSession
	 * @generated
	 */
	public Adapter createTestSessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.TestResult <em>Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.TestResult
	 * @generated
	 */
	public Adapter createTestResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.TestClassResult <em>Test Class Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.TestClassResult
	 * @generated
	 */
	public Adapter createTestClassResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Stats Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStatsEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.TestSuiteResult <em>Test Suite Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.TestSuiteResult
	 * @generated
	 */
	public Adapter createTestSuiteResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.ParameterizedTestResult <em>Parameterized Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.ParameterizedTestResult
	 * @generated
	 */
	public Adapter createParameterizedTestResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Screenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Screenshot
	 * @generated
	 */
	public Adapter createScreenshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.OperationArgument <em>Operation Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.OperationArgument
	 * @generated
	 */
	public Adapter createOperationArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.ScreenshotEntry <em>Screenshot Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.ScreenshotEntry
	 * @generated
	 */
	public Adapter createScreenshotEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.OperationResult <em>Operation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.OperationResult
	 * @generated
	 */
	public Adapter createOperationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Throwable
	 * @generated
	 */
	public Adapter createThrowableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.StackTraceEntry <em>Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.StackTraceEntry
	 * @generated
	 */
	public Adapter createStackTraceEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.InitializationResult <em>Initialization Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.InitializationResult
	 * @generated
	 */
	public Adapter createInitializationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.MethodResult <em>Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.MethodResult
	 * @generated
	 */
	public Adapter createMethodResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.ActorMethodResult <em>Actor Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.ActorMethodResult
	 * @generated
	 */
	public Adapter createActorMethodResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.PageMethodResult <em>Page Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.PageMethodResult
	 * @generated
	 */
	public Adapter createPageMethodResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.TestMethodResult <em>Test Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.TestMethodResult
	 * @generated
	 */
	public Adapter createTestMethodResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Coverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Coverage
	 * @generated
	 */
	public Adapter createCoverageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.ActorResult <em>Actor Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.ActorResult
	 * @generated
	 */
	public Adapter createActorResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.PageResult <em>Page Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.PageResult
	 * @generated
	 */
	public Adapter createPageResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.WebElement <em>Web Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.WebElement
	 * @generated
	 */
	public Adapter createWebElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Locator <em>Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Locator
	 * @generated
	 */
	public Adapter createLocatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.model.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.model.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
