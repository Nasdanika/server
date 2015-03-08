/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.boxing.ObjectArrayBox;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Array Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ObjectArrayBoxImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectArrayBoxImpl<T> extends CDOObjectImpl implements ObjectArrayBox<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectArrayBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.OBJECT_ARRAY_BOX;
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
	public ClassBox<T> getElementType() {
		return (ClassBox<T>)eGet(BoxingPackage.Literals.OBJECT_ARRAY_BOX__ELEMENT_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(ClassBox<T> newElementType) {
		eSet(BoxingPackage.Literals.OBJECT_ARRAY_BOX__ELEMENT_TYPE, newElementType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> getElements() {
		return (EList<EObject>)eGet(BoxingPackage.Literals.OBJECT_ARRAY_BOX__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Object get(ConverterContext context) {
		EList<EObject> elements = getElements();
		Object ret = Array.newInstance(getElementType().get(context), elements.size());
		for (int i=0; i<elements.size(); ++i) {
			EObject el = elements.get(i);
			Array.set(ret, i, el instanceof Box ? ((Box) el).get(context) : el);
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(Object value, ConverterContext context) {		
		for (int i=0, l=Array.getLength(value); i<l; ++i) {
			getElements().add(MapBoxImpl.box(Array.get(value, i), context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BoxingPackage.OBJECT_ARRAY_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.OBJECT_ARRAY_BOX___SET__OBJECT_CONTEXT:
				set(arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ObjectArrayBoxImpl
