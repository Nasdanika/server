/**
 */
package org.nasdanika.osgi.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.osgi.util.ManifestElement;
import org.nasdanika.osgi.model.Bundle;
import org.nasdanika.osgi.model.Component;
import org.nasdanika.osgi.model.ModelFactory;
import org.nasdanika.osgi.model.ModelPackage;
import org.nasdanika.osgi.model.ServiceReference;
import org.osgi.framework.BundleException;
import org.osgi.framework.VersionRange;
import org.osgi.framework.dto.ServiceReferenceDTO;
import org.osgi.service.component.runtime.ServiceComponentRuntime;
import org.osgi.service.component.runtime.dto.ComponentConfigurationDTO;
import org.osgi.service.component.runtime.dto.ComponentDescriptionDTO;
import org.osgi.service.component.runtime.dto.SatisfiedReferenceDTO;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.osgi.model.impl.RuntimeImpl#getBundles <em>Bundles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuntimeImpl extends CDOObjectImpl implements org.nasdanika.osgi.model.Runtime {
	private static final String BUNDLE_VERSION = "bundle-version";
	private static final String REQUIRE_BUNDLE = "Require-Bundle";
	private static final String OBJECT_CLASS = "objectClass";
	private static final String COMPONENT_ID = "component.id";
	private static final String SERVICE_ID = "service.id";
	private static final String SERVICE_BUNDLE_ID = "service.bundleid";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuntimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.RUNTIME;
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
	public EList<Bundle> getBundles() {
		return (EList<Bundle>)eGet(ModelPackage.Literals.RUNTIME__BUNDLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void load(EList<org.osgi.framework.Bundle> bundles, ServiceComponentRuntime serviceComponentRuntime) throws BundleException {
		// Pass 1 - loading elements
		getBundles().clear();
		Map<Long, Bundle> bundleMap = new HashMap<>();
		Map<Long, Component> componentMap = new HashMap<>();
		Map<Long, ComponentConfigurationDTO> componentConfigurationMap = new HashMap<>();
		for (org.osgi.framework.Bundle frameworkBundle: bundles) {
			Bundle bundle = ModelFactory.eINSTANCE.createBundle();
			getBundles().add(bundle);
			bundle.setId(frameworkBundle.getBundleId());
			bundle.setSymbolicName(frameworkBundle.getSymbolicName());
			bundle.setVersion(frameworkBundle.getVersion().toString());
			bundleMap.put(bundle.getId(), bundle);
			if (serviceComponentRuntime != null) {
				for (ComponentDescriptionDTO componentDescription: serviceComponentRuntime.getComponentDescriptionDTOs(frameworkBundle)) {
					for (ComponentConfigurationDTO componentConfiguration: serviceComponentRuntime.getComponentConfigurationDTOs(componentDescription)) {
						Component component = ModelFactory.eINSTANCE.createComponent();
						bundle.getComponents().add(component);
						component.setClassName(componentDescription.implementationClass);
						component.setName(componentDescription.name);
						component.setId(componentConfiguration.id);
						componentMap.put(component.getId(), component);
						componentConfigurationMap.put(componentConfiguration.id, componentConfiguration);
						for (String svc: componentDescription.serviceInterfaces) {
							component.getServices().add(svc);
						}	
					}
				}
			}
		}
		
		// Pass 2 - resolving references
		for (org.osgi.framework.Bundle frameworkBundle: bundles) {
			Bundle bundle = bundleMap.get(frameworkBundle.getBundleId());
			// Required bundles
			String requireBundleHeader = frameworkBundle.getHeaders().get(REQUIRE_BUNDLE);
			if (requireBundleHeader != null) {
				ManifestElement[] manifestElements = ManifestElement.parseHeader(REQUIRE_BUNDLE, requireBundleHeader);
				if (manifestElements != null) {
					for (ManifestElement me: manifestElements) {
						String symbolicName = me.getValue();
						String versionRange = me.getAttribute(BUNDLE_VERSION);
						VersionRange vr = versionRange == null ? null : new VersionRange(versionRange);
						org.osgi.framework.Bundle targetBundle = null;
						for (org.osgi.framework.Bundle rb: bundles) {
							if (rb.getSymbolicName().equals(symbolicName) && (vr == null || vr.includes(rb.getVersion()))) {
								if (targetBundle == null || targetBundle.getVersion().compareTo(rb.getVersion()) < 0) {
									targetBundle = rb;
								}
							}
						}
						if (targetBundle != null) {
							bundle.getRequires().add(bundleMap.get(targetBundle.getBundleId()));
						}
					}
				}
			}
			
			// Service references			

			List<org.osgi.framework.ServiceReference<?>> bundleReferencesInUse = new ArrayList<>();
			org.osgi.framework.ServiceReference<?>[] siu = frameworkBundle.getServicesInUse();
			if (siu != null) {
				for (org.osgi.framework.ServiceReference<?> sr: siu) {
					bundleReferencesInUse.add(sr);
				}
			}
			
			for (Component component: bundle.getComponents()) {
				ComponentConfigurationDTO componentConfiguration = componentConfigurationMap.get(component.getId());
				SatisfiedReferenceDTO[] satisfiedReferences = componentConfiguration.satisfiedReferences;
				if (satisfiedReferences != null) {
					for (SatisfiedReferenceDTO satisfiedReference: satisfiedReferences) {
						ServiceReferenceDTO[] boundServices = satisfiedReference.boundServices;
						if (boundServices != null) {
							for (ServiceReferenceDTO boundServiceReference: boundServices) {
								// Removing bundle reference.
								Iterator<org.osgi.framework.ServiceReference<?>> briuIt = bundleReferencesInUse.iterator();
								while (briuIt.hasNext()) {
									org.osgi.framework.ServiceReference<?> briu = briuIt.next();
									Object serviceId = briu.getProperty(SERVICE_ID);
									if (serviceId instanceof Number && ((Number) serviceId).longValue() == boundServiceReference.id) {
										briuIt.remove();
									}
								}
								
								ServiceReference serviceReference = ModelFactory.eINSTANCE.createServiceReference();
								serviceReference.setName(satisfiedReference.name);
								component.getOutboundReferences().add(serviceReference);
								Object oca = boundServiceReference.properties.get(OBJECT_CLASS);
								if (oca instanceof String[]) {
									for (String oc: (String[]) oca) {
										serviceReference.getObjectClass().add(oc);
									}
								}
								serviceReference.setReferenceTarget(componentMap.get(boundServiceReference.properties.get(COMPONENT_ID)));
								if (serviceReference.getReferenceTarget() == null) {
									serviceReference.setReferenceTarget(bundleMap.get(boundServiceReference.bundle));
								}								
							}
						}
					}
				}
				// TODO - unsatisfied references.
			}
			
			for (org.osgi.framework.ServiceReference<?> bsr: bundleReferencesInUse) {
				ServiceReference serviceReference = ModelFactory.eINSTANCE.createServiceReference();
				bundle.getOutboundReferences().add(serviceReference);
				Object oca = bsr.getProperty(OBJECT_CLASS);
				if (oca instanceof String[]) {
					for (String oc: (String[]) oca) {
						serviceReference.getObjectClass().add(oc);
					}
				}
				Object componentId = bsr.getProperty(COMPONENT_ID);
				if (componentId instanceof Long) {
					serviceReference.setReferenceTarget(componentMap.get((Long) componentId));								
				} else {
					serviceReference.setReferenceTarget(bundleMap.get(bsr.getBundle().getBundleId()));
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
			case ModelPackage.RUNTIME___LOAD__ELIST_SERVICECOMPONENTRUNTIME:
				try {
					load((EList<org.osgi.framework.Bundle>)arguments.get(0), (ServiceComponentRuntime)arguments.get(1));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //RuntimeImpl
