/**
 */
package org.nasdanika.cdo.sca.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.ComponentContext;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.ServiceReference;
import org.nasdanika.cdo.sca.Wire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends CDOObjectImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Wire> getWires() {
		return (EList<Wire>)eGet(ScaPackage.Literals.COMPONENT__WIRES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, EObject> getProperties() {
		return (EMap<String, EObject>)eGet(ScaPackage.Literals.COMPONENT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediatelyActivated() {
		return (Boolean)eGet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediatelyActivated(boolean newImmediatelyActivated) {
		eSet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, newImmediatelyActivated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ServiceReference<T> getServiceReference(Class<T> serviceType, ComponentContext context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceReference<?> getServiceReference(String serviceName, ComponentContext context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScaPackage.COMPONENT___GET_SERVICE_REFERENCE__CLASS_COMPONENTCONTEXT:
				return getServiceReference((Class)arguments.get(0), (ComponentContext)arguments.get(1));
			case ScaPackage.COMPONENT___GET_SERVICE_REFERENCE__STRING_COMPONENTCONTEXT:
				return getServiceReference((String)arguments.get(0), (ComponentContext)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComponentImpl
