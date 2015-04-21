/**
 */
package org.nasdanika.sca.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.sca.Component;
import org.nasdanika.sca.AbstractComponent;
import org.nasdanika.sca.Property;
import org.nasdanika.sca.Reference;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractComponentImpl extends CDOObjectImpl implements AbstractComponent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.ABSTRACT_COMPONENT;
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
	public String getName() {
		return (String)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ScaPackage.Literals.ABSTRACT_COMPONENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(ScaPackage.Literals.ABSTRACT_COMPONENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfiguration() {
		return (String)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(String newConfiguration) {
		eSet(ScaPackage.Literals.ABSTRACT_COMPONENT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Reference> getReferences() {
		return (EList<Reference>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createRuntimeComponent() {
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScaPackage.ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT:
				return createRuntimeComponent();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AbstractComponentImpl
