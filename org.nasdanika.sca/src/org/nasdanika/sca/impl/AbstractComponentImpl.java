/**
 */
package org.nasdanika.sca.impl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.cdo.sca.Component;
import org.nasdanika.core.Context;
import org.nasdanika.sca.AbstractComponent;
import org.nasdanika.sca.Activator;
import org.nasdanika.sca.Operation;
import org.nasdanika.sca.Property;
import org.nasdanika.sca.Reference;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.nasdanika.sca.impl.AbstractComponentImpl#getActivators <em>Activators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractComponentImpl extends CDOObjectImpl implements AbstractComponent {
	private static final String BUNDLE_URL_SCHEME = "bundle://";
	private static final String RESOURCE_URL_SCHEME = "resource://";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScaPackage.Literals.ABSTRACT_COMPONENT;
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
	public String getName() {
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfiguration() {
		return (String)eGet(ScaPackage.Literals.MODEL_ELEMENT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(String newConfiguration) {
		eSet(ScaPackage.Literals.MODEL_ELEMENT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Reference> getReferences() {
		return (EList<Reference>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Operation> getOperations() {
		return (EList<Operation>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__OPERATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Activator> getActivators() {
		return (EList<Activator>)eGet(ScaPackage.Literals.ABSTRACT_COMPONENT__ACTIVATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createRuntimeComponent(BundleContext bundleContext, Context context) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScaPackage.ABSTRACT_COMPONENT___CREATE_RUNTIME_COMPONENT__BUNDLECONTEXT_CONTEXT:
				try {
					return createRuntimeComponent((BundleContext)arguments.get(0), (Context)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}
	
	protected JSONObject loadConfiguration(BundleContext bundleContext) throws Exception {
		return loadConfiguration(bundleContext, getConfiguration());
	}
	
	protected static JSONObject loadConfiguration(BundleContext bundleContext, String config) throws Exception {
		if (config == null || config.trim().length()==0) {
			return null;
		}
		config = config.trim();
		if (config.startsWith("{") && config.endsWith("}")) {
			return new JSONObject(config);
		}
		
		URL configURL;
		if (config.startsWith(RESOURCE_URL_SCHEME)) {
			configURL = bundleContext.getBundle().getResource(config.substring(RESOURCE_URL_SCHEME.length()));
		} else if (config.startsWith(BUNDLE_URL_SCHEME)) {
			int idx = config.indexOf("/", BUNDLE_URL_SCHEME.length());
			if (idx==-1) {
				throw new MalformedURLException("Malformed bundle resource URL: "+config);
			}
			String bundleSymbolicName = config.substring(BUNDLE_URL_SCHEME.length(), idx);
			configURL = null;
			for (Bundle bundle: bundleContext.getBundles()) {
				if (bundleSymbolicName.equals(bundle.getSymbolicName())) {
					configURL = bundle.getResource(config.substring(idx+1));
				}
			}
		} else {
			configURL = new URL(config);
		}
		if (configURL == null) {
			return null;
		}
		try (Reader reader = new InputStreamReader(configURL.openStream())) {
			return new JSONObject(new JSONTokener(reader));				
		}
	}
	
	static String blankToNull(String str) {
		return str==null || str.trim().length()==0 ? null : str;
	}

} //AbstractComponentImpl
