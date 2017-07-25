/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.util.concurrent.TimeUnit;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.RunEntry;
import org.nasdanika.cdo.scheduler.SchedulerFactory;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.StackTraceEntry;
import org.nasdanika.cdo.scheduler.Status;
import org.nasdanika.cdo.scheduler.Throwable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerFactoryImpl extends EFactoryImpl implements SchedulerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulerFactory init() {
		try {
			SchedulerFactory theSchedulerFactory = (SchedulerFactory)EPackage.Registry.INSTANCE.getEFactory(SchedulerPackage.eNS_URI);
			if (theSchedulerFactory != null) {
				return theSchedulerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactoryImpl() {
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
			case SchedulerPackage.DIAGNOSTIC: return (EObject)createDiagnostic();
			case SchedulerPackage.RUN_ENTRY: return (EObject)createRunEntry();
			case SchedulerPackage.THROWABLE: return (EObject)createThrowable();
			case SchedulerPackage.STACK_TRACE_ENTRY: return (EObject)createStackTraceEntry();
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
			case SchedulerPackage.STATUS:
				return createStatusFromString(eDataType, initialValue);
			case SchedulerPackage.SCHEDULER_CONTEXT:
				return createSchedulerContextFromString(eDataType, initialValue);
			case SchedulerPackage.TIME_UNIT:
				return createTimeUnitFromString(eDataType, initialValue);
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
			case SchedulerPackage.STATUS:
				return convertStatusToString(eDataType, instanceValue);
			case SchedulerPackage.SCHEDULER_CONTEXT:
				return convertSchedulerContextToString(eDataType, instanceValue);
			case SchedulerPackage.TIME_UNIT:
				return convertTimeUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic createDiagnostic() {
		DiagnosticImpl diagnostic = new DiagnosticImpl();
		return diagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunEntry createRunEntry() {
		RunEntryImpl runEntry = new RunEntryImpl();
		return runEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.scheduler.Throwable createThrowable() {
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
	public Status createStatusFromString(EDataType eDataType, String initialValue) {
		Status result = Status.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerContext<?> createSchedulerContextFromString(EDataType eDataType, String initialValue) {
		return (SchedulerContext<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedulerContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue) {
		return (TimeUnit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerPackage getSchedulerPackage() {
		return (SchedulerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulerPackage getPackage() {
		return SchedulerPackage.eINSTANCE;
	}

	@Override
	public Throwable createThrowable(java.lang.Throwable throwable) {
		Throwable ret = createThrowable();
		ret.setType(throwable.getClass().getName());
		if (throwable.getMessage()!=null) {
			ret.setMessage(throwable.getMessage());
		}
		for (StackTraceElement ste: throwable.getStackTrace()) {
			StackTraceEntry stackTraceEntry = createStackTraceEntry();
			ret.getStackTrace().add(stackTraceEntry);
			stackTraceEntry.setClassName(ste.getClassName());
			if (ste.getFileName()!=null) {
				stackTraceEntry.setFileName(ste.getFileName());
			}
			if (ste.getLineNumber()>=0) {
				stackTraceEntry.setLineNumber(ste.getLineNumber());
			}
			stackTraceEntry.setMethodName(ste.getMethodName());
			stackTraceEntry.setNative(ste.isNativeMethod());
		}
		if (throwable.getCause() != null) {
			ret.setCause(createThrowable(throwable.getCause()));
		}
		for (java.lang.Throwable s: throwable.getSuppressed()) {
			ret.getSuppressed().add(createThrowable(s));
		}
		return ret;
	}

} //SchedulerFactoryImpl
