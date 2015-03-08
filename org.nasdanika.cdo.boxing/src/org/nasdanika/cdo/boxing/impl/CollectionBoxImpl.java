/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.boxing.CollectionBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.CollectionBoxImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.CollectionBoxImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionBoxImpl<T> extends CDOObjectImpl implements CollectionBox<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.COLLECTION_BOX;
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
	public EList<EObject> getElements() {
		return (EList<EObject>)eGet(BoxingPackage.Literals.COLLECTION_BOX__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBox<Object> getType() {
		return (ClassBox<Object>)eGet(BoxingPackage.Literals.COLLECTION_BOX__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ClassBox<Object> newType) {
		eSet(BoxingPackage.Literals.COLLECTION_BOX__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Collection<T> get(ConverterContext context) {
		try {
			Collection<T> ret = (Collection<T>) getType().get(context).newInstance();
			for (Object el: getElements()) {
				if (el instanceof Box) {
					el = ((Box<Object,Context>) el).get(context);
				}
				ret.add((T) el);
			}
			return ret;
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new BoxingException(ex);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void set(Collection<T> value, ConverterContext context) {
		getElements().clear();
		ClassBox<Object> classBox = BoxingFactory.eINSTANCE.createClassBox();
		classBox.set((Class<Object>) value.getClass(), context);
		setType(classBox);
		for (Object el: value) {
			getElements().add(MapBoxImpl.box(el, context));
		}		
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
			case BoxingPackage.COLLECTION_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.COLLECTION_BOX___SET__OBJECT_CONTEXT:
				set((Collection<T>)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //CollectionBoxImpl
