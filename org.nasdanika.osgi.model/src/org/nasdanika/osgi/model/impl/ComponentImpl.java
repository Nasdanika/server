/**
 */
package org.nasdanika.osgi.model.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.osgi.model.Component;
import org.nasdanika.osgi.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ComponentImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ComponentImpl#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImpl extends ElementImpl implements Component {
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
		return ModelPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ModelPackage.Literals.COMPONENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ModelPackage.Literals.COMPONENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(ModelPackage.Literals.COMPONENT__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(ModelPackage.Literals.COMPONENT__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getServices() {
		return (EList<String>)eGet(ModelPackage.Literals.COMPONENT__SERVICES, true);
	}

} //ComponentImpl
