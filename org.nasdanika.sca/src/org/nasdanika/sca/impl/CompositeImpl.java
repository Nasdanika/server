/**
 */
package org.nasdanika.sca.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.json.JSONObject;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.cdo.sca.PropertySetting;
import org.nasdanika.cdo.sca.ScaFactory;
import org.nasdanika.cdo.sca.Wire;
import org.nasdanika.core.Context;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.sca.AbstractComponent;
import org.nasdanika.sca.ActivatorImport;
import org.nasdanika.sca.Composite;
import org.nasdanika.sca.OperationExport;
import org.nasdanika.sca.Property;
import org.nasdanika.sca.PropertyImport;
import org.nasdanika.sca.Reference;
import org.nasdanika.sca.ReferenceImport;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.ServiceExport;
import org.nasdanika.sca.WireTarget;
import org.osgi.framework.BundleContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getExportedServices <em>Exported Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImportedReferences <em>Imported References</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImportedProperties <em>Imported Properties</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getExportedOperations <em>Exported Operations</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImportedActivators <em>Imported Activators</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.CompositeImpl#getImplementationClass <em>Implementation Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeImpl extends AbstractComponentImpl implements Composite {
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
	public EList<AbstractComponent> getComponents() {
		return (EList<AbstractComponent>)eGet(ScaPackage.Literals.COMPOSITE__COMPONENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceExport> getExportedServices() {
		return (EList<ServiceExport>)eGet(ScaPackage.Literals.COMPOSITE__EXPORTED_SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ReferenceImport> getImportedReferences() {
		return (EList<ReferenceImport>)eGet(ScaPackage.Literals.COMPOSITE__IMPORTED_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<PropertyImport> getImportedProperties() {
		return (EList<PropertyImport>)eGet(ScaPackage.Literals.COMPOSITE__IMPORTED_PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<OperationExport> getExportedOperations() {
		return (EList<OperationExport>)eGet(ScaPackage.Literals.COMPOSITE__EXPORTED_OPERATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ActivatorImport> getImportedActivators() {
		return (EList<ActivatorImport>)eGet(ScaPackage.Literals.COMPOSITE__IMPORTED_ACTIVATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.cdo.sca.Composite getImplementation() {
		return (org.nasdanika.cdo.sca.Composite)eGet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(org.nasdanika.cdo.sca.Composite newImplementation) {
		eSet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationClass() {
		return (EClass)eGet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(EClass newImplementationClass) {
		eSet(ScaPackage.Literals.COMPOSITE__IMPLEMENTATION_CLASS, newImplementationClass);
	}
	
	@Override
	public org.nasdanika.cdo.sca.Component createRuntimeComponent(BundleContext bundleContext, Context context) throws Exception {
		EClass implementationClass = getImplementationClass();
		org.nasdanika.cdo.sca.Component implementation = getImplementation();
		org.nasdanika.cdo.sca.Composite ret;
		if (implementation!=null) {
			if (implementationClass!=null) {
				throw new IllegalStateException("Both implementation and implementation class are set");
			}
			ret = (org.nasdanika.cdo.sca.Composite) EcoreUtil.copy(implementation);
		} else if (implementationClass!=null) {
			ret = (org.nasdanika.cdo.sca.Composite) implementationClass.getEPackage().getEFactoryInstance().create(implementationClass);
		} else {
			ret = ScaFactory.eINSTANCE.createComposite();
		}
		JSONObject config = loadConfiguration(bundleContext);
		if (config!=null) {
			ret.loadJSON(config, context);
		}
		
		//ret.setImmediatelyActivated(getServices().isEmpty());
		
		// Create components
		Map<AbstractComponent, org.nasdanika.cdo.sca.Component> runtimeComponentsMap = new HashMap<>();
		for (AbstractComponent c: getComponents()) {
			Component rc = c.createRuntimeComponent(bundleContext, context);
			if (rc==null) {
				if (!(c instanceof org.nasdanika.sca.Component) && ((org.nasdanika.sca.Component) c).isOptional()) {
					throw new NasdanikaException("Could not create a required runtime component");
				}
			} else {
				runtimeComponentsMap.put(c, rc);
				if (rc.isImmediatelyActivated()) {
					ret.setImmediatelyActivated(true);
				}
			}
		}
		// Create exports
		for (ServiceExport s: getExportedServices()) {
			Wire wire = ScaFactory.eINSTANCE.createWire();
			WireTarget wt = s.getWireTarget();
			wire.setName(blankToNull(s.getName()));
			wire.setTargetName(blankToNull(wt.getName()));
			wire.setTypeName(wt.getType().getInstanceClassName());
			if (wt instanceof ReferenceImport) {
				wire.setTarget(ret);
			} else {
				// Service
				Component rc = runtimeComponentsMap.get(wt.eContainer());
				if (rc==null) {
					continue; // Optional component which is not present.
				}
				wire.setTarget(rc);
			}
			JSONObject targetConfig = loadConfiguration(bundleContext, wt.getConfiguration());
			if (targetConfig!=null) {
				wire.loadJSON(targetConfig, context);
			}
			JSONObject sourceConfig = loadConfiguration(bundleContext, s.getConfiguration());
			if (sourceConfig!=null) {
				wire.loadJSON(sourceConfig, context);
			}
			ret.getExports().add(wire);
		}
		
		// Wire components
		for (Entry<AbstractComponent, Component> ce: runtimeComponentsMap.entrySet()) {
			AbstractComponent mc = ce.getKey();
			Component rc = ce.getValue();
			for (Property prop: mc.getProperties()) {
				PropertySetting ps = ScaFactory.eINSTANCE.createPropertySetting();
				ps.setTargetName(prop.getBinding().getName());
				rc.getProperties().put(prop.getName(), ps);
			}
			for (Reference ref: mc.getReferences()) {
				Wire wire = ScaFactory.eINSTANCE.createWire();
				wire.setName(blankToNull(ref.getName()));
				WireTarget wt = ref.getWireTarget();
				wire.setTargetName(blankToNull(wt.getName()));
				wire.setTypeName(wt.getType().getInstanceClassName());
				if (wt instanceof ReferenceImport) {
					wire.setTarget(ret);
				} else {
					// Service
					Component trc = runtimeComponentsMap.get(wt.eContainer());
					if (trc==null) {
						continue; // Optional component which is not present.
					}
					wire.setTarget(trc);
				}				
				JSONObject targetConfig = loadConfiguration(bundleContext, wt.getConfiguration());
				if (targetConfig!=null) {
					wire.loadJSON(targetConfig, context);
				}
				JSONObject sourceConfig = loadConfiguration(bundleContext, ref.getConfiguration());
				if (sourceConfig!=null) {
					wire.loadJSON(sourceConfig, context);
				}
				rc.getWires().add(wire);				
			}
		}		
		
		return ret;
	}
	

} //CompositeImpl
