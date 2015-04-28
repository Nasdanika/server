/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.json.JSONObject;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.core.Context;
import org.nasdanika.sca.Composite;
import org.nasdanika.sca.CompositeReference;
import org.nasdanika.sca.ScaPackage;
import org.osgi.framework.BundleContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.CompositeReferenceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeReferenceImpl extends AbstractComponentImpl implements CompositeReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite getTarget() {
		return (Composite)eGet(ScaPackage.Literals.COMPOSITE_REFERENCE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Composite newTarget) {
		eSet(ScaPackage.Literals.COMPOSITE_REFERENCE__TARGET, newTarget);
	}
	
	@Override
	public Component createRuntimeComponent(BundleContext bundleContext, Context context) throws Exception {
		Component ret = getTarget().createRuntimeComponent(bundleContext, context);
		JSONObject config = loadConfiguration(bundleContext);
		if (config!=null) {
			ret.loadJSON(config, context);
		}
		return ret;
	}

} //CompositeReferenceImpl
