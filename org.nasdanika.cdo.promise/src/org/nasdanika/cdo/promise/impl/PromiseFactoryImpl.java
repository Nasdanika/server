/**
 */
package org.nasdanika.cdo.promise.impl;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.cdo.promise.PromiseFactory;
import org.nasdanika.cdo.promise.PromisePackage;
import org.nasdanika.cdo.promise.PromiseState;
import org.nasdanika.cdo.scheduler.Scheduler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PromiseFactoryImpl extends EFactoryImpl implements PromiseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PromiseFactory init() {
		try {
			PromiseFactory thePromiseFactory = (PromiseFactory)EPackage.Registry.INSTANCE.getEFactory(PromisePackage.eNS_URI);
			if (thePromiseFactory != null) {
				return thePromiseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PromiseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseFactoryImpl() {
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
			case PromisePackage.PROMISE: return (EObject)createPromise();
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
			case PromisePackage.PROMISE_STATE:
				return createPromiseStateFromString(eDataType, initialValue);
			case PromisePackage.TIME_UNIT:
				return createTimeUnitFromString(eDataType, initialValue);
			case PromisePackage.CDO_TRANSACTION_CONTEXT_COMMAND:
				return createCDOTransactionContextCommandFromString(eDataType, initialValue);
			case PromisePackage.SCHEDULER:
				return createSchedulerFromString(eDataType, initialValue);
			case PromisePackage.CDO_OBJECT:
				return createCDOObjectFromString(eDataType, initialValue);
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
			case PromisePackage.PROMISE_STATE:
				return convertPromiseStateToString(eDataType, instanceValue);
			case PromisePackage.TIME_UNIT:
				return convertTimeUnitToString(eDataType, instanceValue);
			case PromisePackage.CDO_TRANSACTION_CONTEXT_COMMAND:
				return convertCDOTransactionContextCommandToString(eDataType, instanceValue);
			case PromisePackage.SCHEDULER:
				return convertSchedulerToString(eDataType, instanceValue);
			case PromisePackage.CDO_OBJECT:
				return convertCDOObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <CR, F, R, N> Promise<CR, F, R, N> createPromise() {
		PromiseImpl<CR, F, R, N> promise = new PromiseImpl<CR, F, R, N>();
		return promise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseState createPromiseStateFromString(EDataType eDataType, String initialValue) {
		PromiseState result = PromiseState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPromiseStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public CDOTransactionContextCommand<?, ?, ?> createCDOTransactionContextCommandFromString(EDataType eDataType, String initialValue) {
		return (CDOTransactionContextCommand<?, ?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCDOTransactionContextCommandToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler<?, ?> createSchedulerFromString(EDataType eDataType, String initialValue) {
		return (Scheduler<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedulerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDOObject createCDOObjectFromString(EDataType eDataType, String initialValue) {
		return (CDOObject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCDOObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromisePackage getPromisePackage() {
		return (PromisePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PromisePackage getPackage() {
		return PromisePackage.eINSTANCE;
	}

} //PromiseFactoryImpl
