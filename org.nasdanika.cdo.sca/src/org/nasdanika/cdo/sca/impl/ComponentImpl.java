/**
 */
package org.nasdanika.cdo.sca.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.ServiceProvider;
import org.nasdanika.cdo.sca.ServiceProviderContext;
import org.nasdanika.cdo.sca.ServiceReference;
import org.nasdanika.cdo.sca.Wire;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.ComponentImpl#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends CDOObjectImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPONENT;
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
	public EList<Wire> getWires() {
		return (EList<Wire>)eGet(ScaPackage.Literals.COMPONENT__WIRES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, EObject> getProperties() {
		return (EMap<String, EObject>)eGet(ScaPackage.Literals.COMPONENT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediatelyActivated() {
		return (Boolean)eGet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediatelyActivated(boolean newImmediatelyActivated) {
		eSet(ScaPackage.Literals.COMPONENT__IMMEDIATELY_ACTIVATED, newImmediatelyActivated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract ServiceProvider createServiceProvider(ServiceProviderContext context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScaPackage.COMPONENT___CREATE_SERVICE_PROVIDER__SERVICEPROVIDERCONTEXT:
				return createServiceProvider((ServiceProviderContext)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}
	
	@Override
	public void loadJSON(JSONObject json, Context context) throws Exception {
		for (Entry<String, Object> e: asMap(json).entrySet()) {
			getProperties().put(e.getKey(), BoxUtil.box(e.getValue(), context));
		}		
	}
	
	static List<Object> asList(JSONArray jsonArray) throws JSONException {
		List<Object> ret = new ArrayList<>();
		for (int i=0; i<jsonArray.length(); ++i) {
			Object e = jsonArray.get(i);
			if (e instanceof JSONArray) {
				ret.add(asList((JSONArray) e));
			} else if (e instanceof JSONObject) {
				ret.add(asMap((JSONObject) e));
			} else {
				ret.add(e);
			}
		}
		return ret;
	}
	
	static Map<String, Object> asMap(JSONObject jsonObject) throws JSONException {
		Map<String, Object> ret = new LinkedHashMap<>();
		@SuppressWarnings("unchecked")
		Iterator<String> kit = jsonObject.keys();
		while (kit.hasNext()) {
			String key = kit.next();
			Object val = jsonObject.get(key);
			if (val instanceof JSONArray) {
				ret.put(key, asList((JSONArray) val));
			} else if (val instanceof JSONObject) {
				ret.put(key, asMap((JSONObject) val));
			} else {
				ret.put(key, val);
			}
		}
		return ret;
	}
	
	protected static class ServiceProviderContextRequest {
		private Component requestor;
		private ServiceProviderContext context;
		
		public ServiceProviderContextRequest(Component requestor) {
			this.requestor = requestor;
		}
		
		public Component getRequestor() {
			return requestor;
		}
		
		public void setContext(ServiceProviderContext context) {
			this.context = context;
		}
		
		public ServiceProviderContext getContext() {
			return context;
		}
		
	}
	
	/**
	 * This method shall be used by components which are invoked outside of the composite context and need 
	 * wiring to be established to perform operation. This method finds the root composite, invokes its 
	 * <code>createServiceProvider(rootContext)</code> and then returns a context for this component, which
	 * <code>close()</code> method routed to the root composite's service provider. 
	 * @param rootContext
	 * @return
	 */
	protected ServiceProviderContext getServiceProviderContext(ServiceProviderContext rootContext) {
		EObject root = this;
		while (root.eContainer() instanceof CompositeImpl) {
			root = root.eContainer();
		}
		if (root==this) {
			return rootContext;
		}
		
		final ServiceProviderContextRequest spcr = new ServiceProviderContextRequest(this);
		final ServiceProvider rootProvider = ((CompositeImpl) root).createServiceProvider(rootContext, spcr);
		return new ServiceProviderContext() {
			
			@Override
			public <T> T adapt(Class<T> targetType) throws Exception {
				return spcr.getContext().adapt(targetType);
			}
			
			@Override
			public void close() throws Exception {
				rootProvider.close();				
			}
			
			@Override
			public <T> T convert(Object source, Class<T> targetType) throws Exception {
				return spcr.getContext().convert(source, targetType);
			}
			
			@Override
			public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
				return spcr.getContext().authorize(target, action, qualifier, environment);
			}
			
			@Override
			public <T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName) {
				return spcr.getContext().getServiceReference(serviceType, serviceName);
			}
			
			@Override
			public Object getProperty(String propertyName) {
				return spcr.getContext().getProperty(propertyName);
			}

			@Override
			public Object invoke(String activatorName, Object... args) throws Exception {
				return spcr.getContext().invoke(activatorName, args);
			}

			@Override
			public Promise<?, Object, Exception, Object> submit(String activatorName, Object... args) {
				return spcr.getContext().submit(activatorName, args);
			}
		};
	}

} //ComponentImpl
