/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.nasdanika.webtest.performance.DocumentTiming;
import org.nasdanika.webtest.performance.NavigationTiming;
import org.nasdanika.webtest.performance.PerformanceFactory;
import org.nasdanika.webtest.performance.PerformancePackage;
import org.nasdanika.webtest.performance.ResourceTiming;
import org.nasdanika.webtest.performance.TimingBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerformancePackageImpl extends EPackageImpl implements PerformancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timingBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTimingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationTimingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentTimingEClass = null;

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
	 * @see org.nasdanika.webtest.performance.PerformancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PerformancePackageImpl() {
		super(eNS_URI, PerformanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PerformancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PerformancePackage init() {
		if (isInited) return (PerformancePackage)EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI);

		// Obtain or create and register package
		PerformancePackageImpl thePerformancePackage = (PerformancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PerformancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PerformancePackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePerformancePackage.createPackageContents();

		// Initialize created meta-data
		thePerformancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePerformancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PerformancePackage.eNS_URI, thePerformancePackage);
		return thePerformancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimingBase() {
		return timingBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_ConnectEnd() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_ConnectStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_DomainLookupEnd() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_DomainLookupStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_FetchStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_RedirectEnd() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_RedirectStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_RequestStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_ResponseEnd() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_ResponseStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_SecureConnectionStart() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_Name() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimingBase_RedirectCount() {
		return (EAttribute)timingBaseEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceTiming() {
		return resourceTimingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTiming_Duration() {
		return (EAttribute)resourceTimingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTiming_StartTime() {
		return (EAttribute)resourceTimingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTiming_EntryType() {
		return (EAttribute)resourceTimingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTiming_InitiatorType() {
		return (EAttribute)resourceTimingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigationTiming() {
		return navigationTimingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_DomComplete() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_DomContentLoadedEventEnd() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_DomContentLoadedEventStart() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_DomInteractive() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_DomLoading() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_LoadEventEnd() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_LoadEventStart() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_NavigationStart() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_UnloadEventEnd() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNavigationTiming_UnloadEventStart() {
		return (EAttribute)navigationTimingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNavigationTiming_Entries() {
		return (EReference)navigationTimingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentTiming() {
		return documentTimingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceFactory getPerformanceFactory() {
		return (PerformanceFactory)getEFactoryInstance();
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
		timingBaseEClass = createEClass(TIMING_BASE);
		createEAttribute(timingBaseEClass, TIMING_BASE__CONNECT_END);
		createEAttribute(timingBaseEClass, TIMING_BASE__CONNECT_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__DOMAIN_LOOKUP_END);
		createEAttribute(timingBaseEClass, TIMING_BASE__DOMAIN_LOOKUP_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__FETCH_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__REDIRECT_END);
		createEAttribute(timingBaseEClass, TIMING_BASE__REDIRECT_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__REQUEST_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__RESPONSE_END);
		createEAttribute(timingBaseEClass, TIMING_BASE__RESPONSE_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__SECURE_CONNECTION_START);
		createEAttribute(timingBaseEClass, TIMING_BASE__NAME);
		createEAttribute(timingBaseEClass, TIMING_BASE__REDIRECT_COUNT);

		resourceTimingEClass = createEClass(RESOURCE_TIMING);
		createEAttribute(resourceTimingEClass, RESOURCE_TIMING__DURATION);
		createEAttribute(resourceTimingEClass, RESOURCE_TIMING__START_TIME);
		createEAttribute(resourceTimingEClass, RESOURCE_TIMING__ENTRY_TYPE);
		createEAttribute(resourceTimingEClass, RESOURCE_TIMING__INITIATOR_TYPE);

		navigationTimingEClass = createEClass(NAVIGATION_TIMING);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__DOM_COMPLETE);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__DOM_INTERACTIVE);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__DOM_LOADING);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__LOAD_EVENT_END);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__LOAD_EVENT_START);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__NAVIGATION_START);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__UNLOAD_EVENT_END);
		createEAttribute(navigationTimingEClass, NAVIGATION_TIMING__UNLOAD_EVENT_START);
		createEReference(navigationTimingEClass, NAVIGATION_TIMING__ENTRIES);

		documentTimingEClass = createEClass(DOCUMENT_TIMING);
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
		resourceTimingEClass.getESuperTypes().add(this.getTimingBase());
		navigationTimingEClass.getESuperTypes().add(this.getTimingBase());
		documentTimingEClass.getESuperTypes().add(this.getNavigationTiming());
		documentTimingEClass.getESuperTypes().add(this.getResourceTiming());

		// Initialize classes, features, and operations; add parameters
		initEClass(timingBaseEClass, TimingBase.class, "TimingBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimingBase_ConnectEnd(), ecorePackage.getELong(), "connectEnd", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_ConnectStart(), ecorePackage.getELong(), "connectStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_DomainLookupEnd(), ecorePackage.getELong(), "domainLookupEnd", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_DomainLookupStart(), ecorePackage.getELong(), "domainLookupStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_FetchStart(), ecorePackage.getELong(), "fetchStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_RedirectEnd(), ecorePackage.getELong(), "redirectEnd", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_RedirectStart(), ecorePackage.getELong(), "redirectStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_RequestStart(), ecorePackage.getELong(), "requestStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_ResponseEnd(), ecorePackage.getELong(), "responseEnd", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_ResponseStart(), ecorePackage.getELong(), "responseStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_SecureConnectionStart(), ecorePackage.getELong(), "secureConnectionStart", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_Name(), ecorePackage.getEString(), "name", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimingBase_RedirectCount(), ecorePackage.getEInt(), "redirectCount", null, 0, 1, TimingBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTimingEClass, ResourceTiming.class, "ResourceTiming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceTiming_Duration(), ecorePackage.getEDouble(), "duration", null, 0, 1, ResourceTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTiming_StartTime(), ecorePackage.getEDouble(), "startTime", null, 0, 1, ResourceTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTiming_EntryType(), ecorePackage.getEString(), "entryType", null, 0, 1, ResourceTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTiming_InitiatorType(), ecorePackage.getEString(), "initiatorType", null, 0, 1, ResourceTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationTimingEClass, NavigationTiming.class, "NavigationTiming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNavigationTiming_DomComplete(), ecorePackage.getELong(), "domComplete", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_DomContentLoadedEventEnd(), ecorePackage.getELong(), "domContentLoadedEventEnd", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_DomContentLoadedEventStart(), ecorePackage.getELong(), "domContentLoadedEventStart", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_DomInteractive(), ecorePackage.getELong(), "domInteractive", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_DomLoading(), ecorePackage.getELong(), "domLoading", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_LoadEventEnd(), ecorePackage.getELong(), "loadEventEnd", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_LoadEventStart(), ecorePackage.getELong(), "loadEventStart", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_NavigationStart(), ecorePackage.getELong(), "navigationStart", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_UnloadEventEnd(), ecorePackage.getELong(), "unloadEventEnd", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigationTiming_UnloadEventStart(), ecorePackage.getELong(), "unloadEventStart", null, 0, 1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigationTiming_Entries(), this.getTimingBase(), null, "entries", null, 0, -1, NavigationTiming.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentTimingEClass, DocumentTiming.class, "DocumentTiming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PerformancePackageImpl
