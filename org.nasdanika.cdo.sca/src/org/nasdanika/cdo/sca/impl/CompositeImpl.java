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
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.Composite;
import org.nasdanika.cdo.sca.ScaPackage;
import org.nasdanika.cdo.sca.ServiceProvider;
import org.nasdanika.cdo.sca.ServiceProviderContext;
import org.nasdanika.cdo.sca.Wire;

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
		final List<AutoCloseable> toClose = new ArrayList<>();
				
		class ServiceProviderFacade implements AutoCloseable {
			
			private Component component;
			private Map<Component, ServiceProviderFacade> facaded;

			ServiceProviderFacade(Component component, Map<Component, ServiceProviderFacade> facades) {
				this.component = component;
				this.facaded = facades;
			}

			<T> T getService(Class<T> serviceType, String name, Map<String, Object> properties, Set<Component> requestors) {
				return getServiceProvider(requestors).getService(serviceType, name, properties);
			}
			
			ServiceProvider getServiceProvider(Set<Component> requestors) {
				return null; // TODO
			}

			@Override
			public void close() throws Exception {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		final Map<Component, ServiceProviderFacade> facades = new HashMap<>();
		
		for (Component cmp: getComponents()) {
			facades.put(cmp, new ServiceProviderFacade(cmp, facades));
		}
		
		for (Entry<Component, ServiceProviderFacade> fe: facades.entrySet()) {
			if (fe.getKey().isImmediatelyActivated()) {
				fe.getValue().getServiceProvider(new HashSet<Component>());
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
			public <T> T getService(Class<T> serviceType, String name,	Map<String, Object> properties) {
				// Take from service exports.
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

} //CompositeImpl
