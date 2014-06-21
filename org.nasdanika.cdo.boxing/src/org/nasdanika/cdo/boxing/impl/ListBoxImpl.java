/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ListBox;
import org.nasdanika.cdo.boxing.ReferenceBox;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ListBoxImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListBoxImpl<T> extends CDOObjectImpl implements ListBox<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.LIST_BOX;
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
		return (EList<EObject>)eGet(BoxingPackage.Literals.LIST_BOX__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<T> get(ConverterContext context) {
		List<T> ret = new ArrayList<>();
		for (EObject e: getElements()) {
			if (e instanceof Box) {
				ret.add((T) ((Box<?,ConverterContext>) e).get(context));
			} else {
				ret.add((T) e);
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(List<T> value, ConverterContext context) {
		getElements().clear();
		for (T e: value) {
			if (e instanceof CDOObject) {
				CDOObject cdoObj = (CDOObject) e;
				if (cdoObj.eContainer()==null) {
					getElements().add(cdoObj);
				} else {
					ReferenceBox rBox = BoxingFactory.eINSTANCE.createReferenceBox();
					rBox.setTarget(cdoObj);
					getElements().add(rBox);
				}
			} else if (value==null) {
				getElements().add(BoxingFactory.eINSTANCE.createNullBox());
			} else {
				try {
					CDOObject cdoObj = context.convert(e, CDOObject.class);
					if (cdoObj==null) {
						throw new BoxingException("Cannot convert "+e+" to CDOObject");
					}
					getElements().add(cdoObj);
				} catch (BoxingException ex) {
					throw ex;
				} catch (Exception ex) {
					throw new BoxingException(ex);
				}
			}
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
			case BoxingPackage.LIST_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.LIST_BOX___SET__OBJECT_CONTEXT:
				set((List<T>)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ListBoxImpl
