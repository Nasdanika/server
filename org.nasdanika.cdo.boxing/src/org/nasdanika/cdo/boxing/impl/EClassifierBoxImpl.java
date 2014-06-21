/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.EClassifierBox;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EClassifier Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.EClassifierBoxImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EClassifierBoxImpl extends CDOObjectImpl implements EClassifierBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClassifierBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.ECLASSIFIER_BOX;
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
	public String getNsURI() {
		return (String)eGet(BoxingPackage.Literals.ECLASSIFIER_BOX__NS_URI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		eSet(BoxingPackage.Literals.ECLASSIFIER_BOX__NS_URI, newNsURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(BoxingPackage.Literals.ECLASSIFIER_BOX__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BoxingPackage.Literals.ECLASSIFIER_BOX__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier get(@SuppressWarnings("rawtypes") CDOViewContext context) {
		return context.getView().getSession().getPackageRegistry().getEPackage(getNsURI()).getEClassifier(getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(EClassifier value, @SuppressWarnings("rawtypes") CDOViewContext context) {
		setName(value.getName());
		setNsURI(value.getEPackage().getNsURI());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BoxingPackage.ECLASSIFIER_BOX___GET__CONTEXT:
				return get((CDOViewContext)arguments.get(0));
			case BoxingPackage.ECLASSIFIER_BOX___SET__OBJECT_CONTEXT:
				set((EClassifier)arguments.get(0), (CDOViewContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //EClassifierBoxImpl
