/**
 */
package org.nasdanika.cdo.boxing.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.boxing.BoxingException;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.BoxingPackage;
import org.nasdanika.cdo.boxing.MapBox;
import org.nasdanika.cdo.boxing.ReferenceBox;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.impl.MapBoxImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapBoxImpl extends CDOObjectImpl implements MapBox {
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
	public EMap<String, EObject> getEntries() {
		return (EMap<String, EObject>)eGet(BoxingPackage.Literals.MAP_BOX__ENTRIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> get(ConverterContext context) {
		Map<String, Object> ret = new HashMap<String, Object>();
		for (Entry<String, EObject> e: getEntries()) {
			if (e.getValue() instanceof Box) {
				ret.put(e.getKey(), ((Box<?, ConverterContext>) e.getValue()).get(context));
			} else {
				ret.put(e.getKey(), e.getValue());
			}
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(Map<String, Object> value, ConverterContext context) {
		getEntries().clear();
		for (Entry<String, Object> e: value.entrySet()) {
			if (e.getValue() instanceof CDOObject) {
				CDOObject cdoObj = (CDOObject) e.getValue();
				if (cdoObj.eContainer()==null) {
					getEntries().put(e.getKey(), cdoObj);
				} else {
					ReferenceBox rBox = BoxingFactory.eINSTANCE.createReferenceBox();
					rBox.setTarget(cdoObj);
					getEntries().put(e.getKey(), rBox);
				}
			} else if (e.getValue()==null) {
				getEntries().put(e.getKey(), BoxingFactory.eINSTANCE.createNullBox());
			} else {
				try {
					CDOObject cdoObj = context.convert(e.getValue(), CDOObject.class);
					if (cdoObj==null) {
						throw new BoxingException("Cannot convert "+e.getValue()+" to CDOObject");
					}
					getEntries().put(e.getKey(), cdoObj);
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
			case BoxingPackage.MAP_BOX___GET__CONTEXT:
				return get((ConverterContext)arguments.get(0));
			case BoxingPackage.MAP_BOX___SET__OBJECT_CONTEXT:
				set((Map<String, Object>)arguments.get(0), (ConverterContext)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //MapBoxImpl
