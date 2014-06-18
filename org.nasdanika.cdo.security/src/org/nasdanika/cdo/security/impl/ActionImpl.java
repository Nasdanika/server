/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.Property;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;
import org.nasdanika.core.NasdanikaException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getTargetNamespaceURI <em>Target Namespace URI</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#isGrantable <em>Grantable</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImplies <em>Implies</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImpliedBy <em>Implied By</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getPathPatterns <em>Path Patterns</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends CDOObjectImpl implements Action {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.ACTION;
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
		return (String)eGet(SecurityPackage.Literals.ACTION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SecurityPackage.Literals.ACTION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SecurityPackage.Literals.ACTION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SecurityPackage.Literals.ACTION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetNamespaceURI() {
		return (String)eGet(SecurityPackage.Literals.ACTION__TARGET_NAMESPACE_URI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNamespaceURI(String newTargetNamespaceURI) {
		eSet(SecurityPackage.Literals.ACTION__TARGET_NAMESPACE_URI, newTargetNamespaceURI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetClass() {
		return (String)eGet(SecurityPackage.Literals.ACTION__TARGET_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClass(String newTargetClass) {
		eSet(SecurityPackage.Literals.ACTION__TARGET_CLASS, newTargetClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrantable() {
		return (Boolean)eGet(SecurityPackage.Literals.ACTION__GRANTABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrantable(boolean newGrantable) {
		eSet(SecurityPackage.Literals.ACTION__GRANTABLE, newGrantable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getImplies() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION__IMPLIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Action> getImpliedBy() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION__IMPLIED_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getPathPatterns() {
		return (EList<String>)eGet(SecurityPackage.Literals.ACTION__PATH_PATTERNS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return (String)eGet(SecurityPackage.Literals.ACTION__CONDITION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		eSet(SecurityPackage.Literals.ACTION__CONDITION, newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(SecurityPackage.Literals.ACTION__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean match(Context context, String action, String path, Map<String, Object> environment) {
		if ("*".equals(getName()) || getName().equals(action)) {
			if (getPathPatterns().isEmpty()) {
				if ("/".equals(path)) {
					return eval(context, environment);
				}
			} else {
				for (String p: getPathPatterns()) {
					if (Pattern.matches(p, path)) {
						return true;
					}
				}
			}
		} else {		
			for (Action a: getImplies()) {
				if (a.match(context, action, path, environment)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private Boolean eval(Context context, Map<String, Object> environment) {
		try {
			if (getCondition()==null || getCondition().trim().length()==0) {
				return true;
			}
			ScriptEngineManager sm = new ScriptEngineManager();
			ScriptEngine s = sm.getEngineByMimeType("application/javascript");
			Bindings b = s.createBindings();
			if (environment!=null) {
				b.putAll(environment);
			}
			Map<String, Object> actionProperties = new HashMap<>();
			b.put("actionProperties", actionProperties);
			for (Property p: getProperties()) {
				if (p.getType()==null || p.getType().trim().length()==0 || String.class.getName().equals(p.getType())) {
					actionProperties.put(p.getName(), p.getValue());
				} else {
					Class<?> propertyType = ((ClassLoadingContext) context).loadClass(p.getType());
					Object propertyValue = ((ConverterContext) context).convert(p.getValue(), propertyType);
					if (propertyValue==null) {
						throw new NasdanikaException("Cannot convert '"+p.getValue()+"' to "+p.getType());
					}
					actionProperties.put(p.getName(), propertyValue);
				}
			}
			return Boolean.TRUE.equals(s.eval(getCondition(), b));
		} catch (Exception e) {
			throw new NasdanikaException("Action condition evaluation error", e);
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
			case SecurityPackage.ACTION___MATCH__CONTEXT_STRING_STRING_MAP:
				return match((Context)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Map<String, Object>)arguments.get(3));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ActionImpl
