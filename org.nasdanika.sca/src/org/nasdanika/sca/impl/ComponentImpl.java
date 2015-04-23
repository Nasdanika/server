/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.json.JSONObject;
import org.nasdanika.cdo.sca.ComponentFactory;
import org.nasdanika.core.Context;
import org.nasdanika.sca.Component;
import org.nasdanika.sca.ScaPackage;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getImplementationClass <em>Implementation Class</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#isImmediatelyActivated <em>Immediately Activated</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#getFactoryFilter <em>Factory Filter</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.ComponentImpl#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends AbstractComponentImpl implements Component {
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
	public org.nasdanika.cdo.sca.Component getImplementation() {
		return (org.nasdanika.cdo.sca.Component)eGet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(org.nasdanika.cdo.sca.Component newImplementation) {
		eSet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationClass() {
		return (EClass)eGet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClass(EClass newImplementationClass) {
		eSet(ScaPackage.Literals.COMPONENT__IMPLEMENTATION_CLASS, newImplementationClass);
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
	 * @generated
	 */
	public String getId() {
		return (String)eGet(ScaPackage.Literals.COMPONENT__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(ScaPackage.Literals.COMPONENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactoryFilter() {
		return (String)eGet(ScaPackage.Literals.COMPONENT__FACTORY_FILTER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactoryFilter(String newFactoryFilter) {
		eSet(ScaPackage.Literals.COMPONENT__FACTORY_FILTER, newFactoryFilter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return (Boolean)eGet(ScaPackage.Literals.COMPONENT__OPTIONAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		eSet(ScaPackage.Literals.COMPONENT__OPTIONAL, newOptional);
	}

	@Override
	public org.nasdanika.cdo.sca.Component createRuntimeComponent(BundleContext bundleContext, Context context) throws Exception {
		EClass implementationClass = getImplementationClass();
		org.nasdanika.cdo.sca.Component implementation = getImplementation();
		org.nasdanika.cdo.sca.Component ret;
		if (getId()!=null && getId().trim().length()>0) {
			if (implementation!=null) {
				throw new IllegalStateException("Both id and implementation are set");
			}
			if (implementationClass!=null) {
				throw new IllegalStateException("Both id and implementation class are set");
			}

			String filter = getFactoryFilter();
			if (filter!=null && filter.trim().length()==0) {
				filter = null;
			}
			ret = null;
			for (ServiceReference<ComponentFactory> sr: bundleContext.getServiceReferences(ComponentFactory.class, filter)) {
				ComponentFactory cf = bundleContext.getService(sr);
				try {
					if (cf!=null) {
						ret = cf.createComponent(context, getId());
					}
				} finally {
					bundleContext.ungetService(sr);
				}				
				if (ret!=null) {
					break;
				}
			}
		} else if (implementation!=null) {
			if (implementationClass!=null) {
				throw new IllegalStateException("Both implementation and implementation class are set");
			}
			ret = EcoreUtil.copy(implementation);
		} else if (implementationClass!=null) {
			ret = (org.nasdanika.cdo.sca.Component) implementationClass.getEPackage().getEFactoryInstance().create(implementationClass);
		} else {
			throw new IllegalStateException("Neither id, nor implementation, nor implementation class are set");			
		}
		JSONObject config = loadConfiguration(bundleContext);
		if (config!=null) {
			ret.loadJSON(config, context);
		}
		ret.setImmediatelyActivated(isImmediatelyActivated());
		return ret;
	}

} //ComponentImpl
