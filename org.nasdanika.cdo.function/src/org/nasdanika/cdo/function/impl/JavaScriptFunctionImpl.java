/**
 */
package org.nasdanika.cdo.function.impl;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.function.ContextArgument;
import org.nasdanika.cdo.function.FunctionPackage;
import org.nasdanika.cdo.function.JavaScriptFunction;
import org.nasdanika.core.Context;
import org.nasdanika.function.ServiceBinding;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Script Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl#getCodeURL <em>Code URL</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl#getParameterNames <em>Parameter Names</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.impl.JavaScriptFunctionImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaScriptFunctionImpl<CR, MC extends Context, T, R> extends AbstractFunctionImpl<CR, MC, T, R> implements JavaScriptFunction<CR, MC, T, R> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaScriptFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return (String)eGet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		eSet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__CODE, newCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodeURL() {
		return (String)eGet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__CODE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeURL(String newCodeURL) {
		eSet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__CODE_URL, newCodeURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getParameterNames() {
		return (EList<String>)eGet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__PARAMETER_NAMES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, EObject> getBindings() {
		return (EMap<String, EObject>)eGet(FunctionPackage.Literals.JAVA_SCRIPT_FUNCTION__BINDINGS, true);
	}
	
	@Override
	public Class<?>[] getParameterTypes(CDOTransactionContext<CR, MC> context) {
		Class<?>[] ret = new Class<?>[getParameterNames().size()];
		Arrays.fill(ret, Object.class);
		return ret;
	}
	
	@Override
	public Class<?> getReturnType(CDOTransactionContext<CR, MC> context) {
		return Object.class;
	}
	
	private String resolveCode() throws Exception {
		if (getCodeURL()==null) {
			return getCode();
		}
		URL codeURL = new URL(getCodeURL());
		StringWriter sw = new StringWriter();
		try (Reader r = new InputStreamReader(codeURL.openStream())) {
			for (int ch = r.read(); ch!=-1; ch = r.read()) {
				sw.write(ch);
			}
		}
		sw.close();
		return sw.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected R invoke(CDOTransactionContext<CR, MC> context, Object[] args) throws Exception {
		StringBuilder scriptBuilder = new StringBuilder();
		scriptBuilder.append("(function(");
		int pIdx = 0;
		for (String pn: getParameterNames()) {
			if (pIdx++ > 0) {
				scriptBuilder.append(",");
			}
			scriptBuilder.append(pn);
		}
		scriptBuilder.append("){").append(resolveCode()).append("});");
		org.mozilla.javascript.Context scriptContext = org.mozilla.javascript.Context.enter();
		List<ServiceReference<?>> toUnget = new ArrayList<>();
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		try {
			Scriptable scope = scriptContext.initStandardObjects();
			for (Entry<String, EObject> b: getBindings()) {
				Object value = BoxUtil.unbox(b.getValue(), context);
				if (value instanceof ServiceBinding) {
					ServiceBinding sb = (ServiceBinding) value;
					ServiceReference<?>[] refs = bundleContext.getServiceReferences(sb.getServiceType(), sb.getFilter());
					if (refs!=null) {
						for (ServiceReference<?> ref: refs) {
							Object service = bundleContext.getService(ref);
							if (service!=null) {
								value = service;
								toUnget.add(ref);
								break;
							}
						}
					}				
				}				
				ScriptableObject.putProperty(scope, b.getKey(), org.mozilla.javascript.Context.javaToJS(value, scope));				
			}
			ScriptableObject.putProperty(scope, "context", org.mozilla.javascript.Context.javaToJS(context, scope));
			Function function = (Function) scriptContext.evaluateString(scope, scriptBuilder.toString(), "JavaScriptFunction", 1, null);
			return (R) function.call(scriptContext, scope, scope, args);
		} finally {
			org.mozilla.javascript.Context.exit();
			for (ServiceReference<?> sr: toUnget) {
				bundleContext.ungetService(sr);
			}
		}
	}

} //JavaScriptFunctionImpl
