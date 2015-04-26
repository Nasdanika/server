/**
 */
package org.nasdanika.cdo.sca.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.Composite;
import org.nasdanika.cdo.sca.PropertySetting;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.ServiceKey;
import org.nasdanika.cdo.sca.ServiceProvider;
import org.nasdanika.cdo.sca.ServiceProviderContext;
import org.nasdanika.cdo.sca.ServiceReference;
import org.nasdanika.cdo.sca.Wire;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.sca.impl.CompositeImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.cdo.sca.impl.CompositeImpl#getExports <em>Exports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeImpl extends ComponentImpl implements Composite {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getComponents() {
		return (EList<Component>)eGet(ScaPackage.Literals.COMPOSITE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Wire> getExports() {
		return (EList<Wire>)eGet(ScaPackage.Literals.COMPOSITE__EXPORTS, true);
	}

	@Override
	public ServiceProvider createServiceProvider(final ServiceProviderContext context) {
		return createServiceProvider(context, null);
	}
				
	private static class ServiceProviderFacade {

		private Component component;
		private ServiceProviderContext parentContext;
		private Map<Component, ServiceProviderFacade> facades;
		private List<AutoCloseable> toClose;

		ServiceProviderFacade(
				ServiceProviderContext parentContext, 
				Component component, 
				Map<Component, ServiceProviderFacade> facades,
				List<AutoCloseable> toClose) {
			this.parentContext = parentContext;
			this.component = component;
			this.facades = facades;
			this.toClose = toClose; 
		}

		private ServiceProviderContext createServiceProviderContext(final Set<Component> requestors) {
			return new ServiceProviderContext() {
				
				@Override
				public <T> T adapt(Class<T> targetType) throws Exception {
					return parentContext.adapt(targetType);
				}
				
				private Map<ServiceKey, ServiceReference<Object>> serviceReferences = new HashMap<>();
				
				@Override
				public void close() throws Exception {
					for (ServiceReference<Object> sr: serviceReferences.values()) {
						sr.close();
					}
				}
				
				@Override
				public <T> T convert(Object source, Class<T> targetType) throws Exception {
					return parentContext.convert(source, targetType);
				}
				
				@Override
				public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
					return parentContext.authorize(target, action, qualifier, environment);
				}
				
				@SuppressWarnings("unchecked")
				@Override
				public synchronized <T> ServiceReference<T> getServiceReference(Class<T> serviceType, String serviceName) {
					ServiceKey sKey = new ServiceKey(serviceType, serviceName);
					ServiceReference<T> ret = (ServiceReference<T>) serviceReferences.get(sKey);
					if (ret==null) {
						for (Wire w : component.getWires()) {
							ServiceKey wKey = new ServiceKey(w.getTypeName(), w.getName());
							if (sKey.equals(wKey)) {
								ServiceProviderFacade facade = facades.get(w.getTarget());
								if (facade!=null) {
									Map<String, Object> properties = new HashMap<>();									
									for (Entry<String, EObject> p: w.getProperties()) {
										properties.put(p.getKey(), BoxUtil.unbox(p.getValue(), this));
									}
									ServiceProvider sp = facade.getServiceProvider(requestors);
									if (sp!=null) {
										ret = sp.getServiceReference(serviceType, w.getTargetName(), properties);
										if (ret!=null) {
											serviceReferences.put(sKey, (ServiceReference<Object>) ret);
										}
									}									
									break;
								}
							}
						}
					}

					return ret;
				}
				
				@Override
				public Object getProperty(String propertyName) {
					EObject prop = component.getProperties().get(propertyName);
					if (prop instanceof PropertySetting) {
						return parentContext.getProperty(((PropertySetting) prop).getTargetName());
					}
					return BoxUtil.unbox(prop, parentContext);
				}
			};
		}

		private ServiceProvider serviceProvider;

		ServiceProvider getServiceProvider(final Set<Component> requestors) {
			synchronized (toClose) {
				if (serviceProvider == null) {
					if (requestors.add(component)) {
						serviceProvider = component.createServiceProvider(createServiceProviderContext(requestors));
						if (serviceProvider!=null) {
							toClose.add(serviceProvider);
						}
					}
				}
				return serviceProvider;
			}
		}

		<T> ServiceReference<T> getServiceReference(
				Class<T> serviceType, String name,
				Map<String, Object> properties, 
				Set<Component> requestors) {
			ServiceProvider sp = getServiceProvider(requestors);
			return sp == null ? null : sp.getServiceReference(serviceType, name, properties);
		}

	}
	
	private static class WireEntry {
		ServiceProviderFacade facade;
		String targetName;
		Map<String, Object> properties = new HashMap<>();
		
		WireEntry(Context context, Wire wire, ServiceProviderFacade facade) {
			this.facade = facade;
			this.targetName = wire.getTargetName();
			for (Entry<String, EObject> p: wire.getProperties()) {
				properties.put(p.getKey(), BoxUtil.unbox(p.getValue(), context));
			}
		}
	}			
	
	protected ServiceProvider createServiceProvider(final ServiceProviderContext context, ServiceProviderContextRequest contextRequest) {
		final List<AutoCloseable> toClose = new ArrayList<>();				
		Map<Component, ServiceProviderFacade> facades = new HashMap<>();
		
		for (Component cmp: getComponents()) {
			facades.put(cmp, new ServiceProviderFacade(context, cmp, facades, toClose));
		}
		
		for (Entry<Component, ServiceProviderFacade> fe: facades.entrySet()) {
			if (fe.getKey().isImmediatelyActivated()) {
				toClose.add(fe.getValue().getServiceProvider(new HashSet<Component>()));
			}
		}
		
		for (Entry<Component, ServiceProviderFacade> fe: facades.entrySet()) {
			if (contextRequest!=null && fe.getKey()==contextRequest.getRequestor()) {
				contextRequest.setContext(fe.getValue().createServiceProviderContext(new HashSet<Component>()));
			}
		}
		
		final Map<ServiceKey, WireEntry> exports = new HashMap<>();
		
		for (Wire se: getExports()) {
			ServiceProviderFacade facade = facades.get(se.getTarget());
			if (facade!=null) {
				exports.put(new ServiceKey(se.getName(), se.getTypeName()), new WireEntry(context, se, facade));
			}
		}

		return new ServiceProvider() {

			@Override
			public void close() throws Exception {
				synchronized (toClose) {
					Collections.reverse(toClose);
					for (AutoCloseable tc: toClose) {
						tc.close();
					}
					toClose.clear();
				}
			}

			@Override
			public <T> ServiceReference<T> getServiceReference(Class<T> serviceType, String name, Map<String, Object> properties) {
				WireEntry ee = exports.get(new ServiceKey(serviceType, name));
				if (ee==null) {
					return null;
				}
				Map<String, Object> props = new HashMap<>(ee.properties);
				if (properties!=null) {
					props.putAll(properties);
				}
				return ee.facade.getServiceReference(serviceType, ee.targetName, props, new HashSet<Component>());
			}
			
		};
	}

} //CompositeImpl
