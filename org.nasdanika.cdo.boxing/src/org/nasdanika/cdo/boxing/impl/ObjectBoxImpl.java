/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.boxing.FieldEntry;
import org.nasdanika.cdo.boxing.ObjectBox;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ObjectBoxImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.ObjectBoxImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectBoxImpl<T> extends CDOObjectImpl implements ObjectBox<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.OBJECT_BOX;
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
	public EList<FieldEntry> getFields() {
		return (EList<FieldEntry>)eGet(BoxingPackage.Literals.OBJECT_BOX__FIELDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBox<T> getType() {
		return (ClassBox<T>)eGet(BoxingPackage.Literals.OBJECT_BOX__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ClassBox<T> newType) {
		eSet(BoxingPackage.Literals.OBJECT_BOX__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T get(Context context) {
		try {
			Class<T> clazz = getType().get(context);
			T ret = clazz.newInstance();
			ClassLoader classLoader = clazz.getClassLoader();
			for (FieldEntry fe: getFields()) {
				Field field = classLoader.loadClass(fe.getDeclaringClass()).getField(fe.getName());
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				EObject fieldValue = fe.getValue();
				if (fieldValue instanceof Box) {
					field.set(ret, ((Box) fieldValue).get(context));
				} else {
					field.set(ret, fieldValue);
				}
			}
			return ret;
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | ClassNotFoundException e) {
			throw new BoxingException(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void set(T value, Context context) {
		getFields().clear();
		ClassBox<T> type = BoxingFactory.eINSTANCE.createClassBox();
		type.set((Class<T>) value.getClass(), context);
		setType(type);
		storeFields(value, value.getClass(), context);
	}
	
	private void storeFields(T value, Class<?> clazz, Context context) {
		if (!Object.class.equals(clazz)) {
			for (Field field: clazz.getDeclaredFields()) {
				if (!Modifier.isStatic(field.getModifiers())) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					try {
						Object fieldVal = field.get(value);
						FieldEntry fe = BoxingFactory.eINSTANCE.createFieldEntry();
						fe.setName(field.getName());
						fe.setDeclaringClass(clazz.getName());
						if (fieldVal==null) {
							fe.setValue(BoxingFactory.eINSTANCE.createNullBox());
						} else {
							fe.setValue(BoxUtil.box(fieldVal, context));
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						throw new BoxingException(e);
					}
				}
			}
			storeFields(value, clazz.getSuperclass(), context);
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
			case BoxingPackage.OBJECT_BOX___GET__CONTEXT:
				return get((Context)arguments.get(0));
			case BoxingPackage.OBJECT_BOX___SET__OBJECT_CONTEXT:
				set((T)arguments.get(0), (Context)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ObjectBoxImpl
