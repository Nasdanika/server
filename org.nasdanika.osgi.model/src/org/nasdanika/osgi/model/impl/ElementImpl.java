/**
 */
package org.nasdanika.osgi.model.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.osgi.model.Element;
import org.nasdanika.osgi.model.ModelPackage;
import org.nasdanika.osgi.model.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.impl.ElementImpl#getOutboundReferences <em>Outbound References</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ElementImpl#getInboundReferences <em>Inbound References</em>}</li>
 *   <li>{@link org.nasdanika.osgi.model.impl.ElementImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends CDOObjectImpl implements Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ELEMENT;
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
	public EList<ServiceReference> getOutboundReferences() {
		return (EList<ServiceReference>)eGet(ModelPackage.Literals.ELEMENT__OUTBOUND_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceReference> getInboundReferences() {
		return (EList<ServiceReference>)eGet(ModelPackage.Literals.ELEMENT__INBOUND_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return (Long)eGet(ModelPackage.Literals.ELEMENT__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		eSet(ModelPackage.Literals.ELEMENT__ID, newId);
	}

} //ElementImpl
