/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.JsonObjectBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json Object Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.JsonObjectBoxImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JsonObjectBoxImpl extends CDOObjectImpl implements JsonObjectBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JsonObjectBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.JSON_OBJECT_BOX;
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
	public EMap<String, EObject> getElements() {
		return (EMap<String, EObject>)eGet(BoxingPackage.Literals.JSON_OBJECT_BOX__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public JSONObject get(ConverterContext context) {
		JSONObject ret = new JSONObject();
		for (Entry<String, EObject> e: getElements()) {
			Object value = e.getValue();
			if (value instanceof Box) {
				value = ((Box<Object,Context>) value).get(context);
			}
			try {
				ret.put(e.getKey(), value);
			} catch (JSONException ex) {
				throw new BoxingException(ex);
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set(JSONObject value, ConverterContext context) {
		getElements().clear();
		@SuppressWarnings("unchecked")
		Iterator<String> kit = value.keys();
		while (kit.hasNext()) {
			String key = kit.next();
			try {
				getElements().put(key, MapBoxImpl.box(value.get(key), context));
			} catch (JSONException e) {
				throw new BoxingException(e);
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
			case BoxingPackage.JSON_OBJECT_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.JSON_OBJECT_BOX___SET__OBJECT_CONTEXT:
				set((JSONObject)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //JsonObjectBoxImpl
