/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.JsonArrayBox;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Json Array Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.JsonArrayBoxImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JsonArrayBoxImpl extends CDOObjectImpl implements JsonArrayBox {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JsonArrayBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoxingPackage.Literals.JSON_ARRAY_BOX;
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
		return (EList<EObject>)eGet(BoxingPackage.Literals.JSON_ARRAY_BOX__ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public JSONArray get(ConverterContext context) {
		JSONArray ret = new JSONArray();
		for (Object el: getElements()) {
			if (el instanceof Box) {
				el = ((Box<Object,Context>) el).get(context);
			}
			ret.put(el);
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(JSONArray value, ConverterContext context) {
		getElements().clear();
		for (int i=0; i<value.length(); ++i) {
			try {
				getElements().add(MapBoxImpl.box(value.get(i), context));
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
			case BoxingPackage.JSON_ARRAY_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.JSON_ARRAY_BOX___SET__OBJECT_CONTEXT:
				set((JSONArray)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //JsonArrayBoxImpl
