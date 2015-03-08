/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.boxing.MapBox;
import org.nasdanika.cdo.boxing.MapEntry;
import org.nasdanika.cdo.boxing.ReferenceBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.MapBoxImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.MapBoxImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapBoxImpl<K, V> extends CDOObjectImpl implements MapBox<K, V> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.MAP_BOX;
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
	public EList<MapEntry> getEntries() {
		return (EList<MapEntry>)eGet(BoxingPackage.Literals.MAP_BOX__ENTRIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBox<Map<K, V>> getType() {
		return (ClassBox<Map<K, V>>)eGet(BoxingPackage.Literals.MAP_BOX__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ClassBox<Map<K, V>> newType) {
		eSet(BoxingPackage.Literals.MAP_BOX__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Map<K, V> get(ConverterContext context) {
		try {
			Map<K, V> ret = getType().get(context).newInstance();
			for (MapEntry e: getEntries()) {
				Object key = e.getKey();
				if (key instanceof Box) {
					key = ((Box<Object,Context>) key).get(context);
				}
				Object value = e.getValue();
				if (value instanceof Box) {
					value = ((Box<Object,Context>) value).get(context);
				}
				ret.put((K) key, (V) value);
			}
			return ret;
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new BoxingException(ex);
		}
	}
	
	static <T> CDOObject box(T obj, ConverterContext context) {
		if (obj instanceof CDOObject) {
			CDOObject cdoObj = (CDOObject) obj;
			if (cdoObj.eContainer()==null) {
				return cdoObj;
			}
			
			ReferenceBox rBox = BoxingFactory.eINSTANCE.createReferenceBox();
			rBox.setTarget(cdoObj);
			return rBox;		
		} 
		
		if (obj==null) {
			return BoxingFactory.eINSTANCE.createNullBox();
		}
		
		try {
			CDOObject cdoObj = context.convert(obj, CDOObject.class);
			if (cdoObj==null) {
				throw new BoxingException("Cannot convert "+obj+" to CDOObject");
			}
			return cdoObj;
		} catch (BoxingException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new BoxingException(ex);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void set(Map<K, V> value, ConverterContext context) {
		getEntries().clear();
		ClassBox<Map<K,V>> classBox = BoxingFactory.eINSTANCE.createClassBox();
		classBox.set((Class<Map<K, V>>) value.getClass(), context);
		setType(classBox);
		for (Entry<K, V> e: value.entrySet()) {
			MapEntry me = BoxingFactory.eINSTANCE.createMapEntry();
			me.setKey(box(e.getKey(), context));
			me.setValue(box(e.getValue(), context));
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
			case BoxingPackage.MAP_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.MAP_BOX___SET__OBJECT_CONTEXT:
				set((Map<K, V>)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //MapBoxImpl
