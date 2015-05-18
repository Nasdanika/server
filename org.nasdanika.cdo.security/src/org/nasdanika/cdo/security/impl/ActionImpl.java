/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.ActionContainer;
import org.nasdanika.cdo.security.Property;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.NasdanikaException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#isGrantable <em>Grantable</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImplies <em>Implies</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getImpliedBy <em>Implied By</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getPathPatterns <em>Path Patterns</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.ActionImpl#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends ActionKeyImpl implements Action {
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
	@SuppressWarnings("unchecked")
	public EList<Action> getActions() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION_CONTAINER__ACTIONS, true);
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
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getCategory() {
		return (EList<String>)eGet(SecurityPackage.Literals.ACTION__CATEGORY, true);
	}
	
	/**
	 * Inherits path patterns.
	 * @return
	 */
	private EList<String> getEffectivePathPatterns() {
		for (Action a = this; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			EList<String> pathPatterns = a.getPathPatterns();
			if (!pathPatterns.isEmpty()) {
				return pathPatterns;
			}
		}
		return getPathPatterns();
	}

	/**
	 * Inherits condition.
	 * @return
	 */
	private String getEffectiveCondition() {
		for (Action a = this; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			String condition = a.getCondition();
			if (!CoreUtil.isBlank(condition)) {
				return condition;
			}
		}
		return getCondition();
	}
	
	/**
	 * Inherits name.
	 * @return
	 */
	private String getEffectiveName() {
		for (Action a = this; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			String name = a.getName();
			if (!CoreUtil.isBlank(name)) {
				return name;
			}
		}
		return getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean match(Context context, String action, String path, Map<String, Object> environment) {
//		System.out.println(action+" "+path);
		String name = getEffectiveName();
		if ("*".equals(name) || name.equals(action)) {
			EList<String> pathPatterns = getEffectivePathPatterns();
			if (pathPatterns.isEmpty()) {
				if ("/".equals(path)) {
					return eval(context, environment);
				}
			} else {
				for (String p: pathPatterns) {
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
			for (Action a: getActions()) {
				if (a.match(context, action, path, environment)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ActionContainer.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.ACTION__ACTIONS: return SecurityPackage.ACTION_CONTAINER__ACTIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ActionContainer.class) {
			switch (baseFeatureID) {
				case SecurityPackage.ACTION_CONTAINER__ACTIONS: return SecurityPackage.ACTION__ACTIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	private Boolean eval(Context context, Map<String, Object> environment) {
		try {
			String condition = getEffectiveCondition();
			if (CoreUtil.isBlank(condition)) {
				return true;
			}
			org.mozilla.javascript.Context scriptContext = org.mozilla.javascript.Context.enter();
			try {
				Scriptable scope = scriptContext.initStandardObjects();
				ScriptableObject.putProperty(scope, "context", org.mozilla.javascript.Context.javaToJS(context, scope));
				for (Entry<String, Object> ee: environment.entrySet()) {
					ScriptableObject.putProperty(scope, ee.getKey(), org.mozilla.javascript.Context.javaToJS(ee.getValue(), scope));					
				}
				ScriptableObject.putProperty(scope, "actionProperties", org.mozilla.javascript.Context.javaToJS(effectiveActionProperties(context), scope));					

				return Boolean.TRUE.equals(scriptContext.evaluateString(scope, condition, "actionCondition", 1, null));
			} finally {
				org.mozilla.javascript.Context.exit();
			}			
		} catch (Exception e) {
			throw new NasdanikaException("Action condition evaluation error", e);
		}
	}

	/**
	 * Collects properties from self and parent actions.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> effectiveActionProperties(Context context) throws Exception {
		Map<String, Object> actionProperties = new HashMap<>();
		for (Action a = this; a.eContainer() instanceof Action; a = (Action) a.eContainer()) {
			for (Property p: a.getProperties()) {
				if (!actionProperties.containsKey(p.getName())) {
					if (CoreUtil.isBlank(p.getType())|| String.class.getName().equals(p.getType())) {
						actionProperties.put(p.getName(), p.getValue());
					} else {
						Class<?> propertyType = ((ClassLoadingContext) context).loadClass(p.getType());
						Object propertyValue = ((Context) context).convert(p.getValue(), propertyType);
						if (propertyValue==null) {
							throw new NasdanikaException("Cannot convert '"+p.getValue()+"' to "+p.getType());
						}
						actionProperties.put(p.getName(), propertyValue);
					}
				}
			}
		}
		return actionProperties;
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
