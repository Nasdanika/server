package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.Context;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.web.RequestMethod;

/**
 * Base class for {@link EOperationTarget} also providing information about the target to the renderer.
 * @author Pavel
 *
 */
public class EOperationTargetInfo {
	
	enum Role {
		
		/**
		 * Default role, web operation is rendered as a button.
		 */
		operation, 
		
		/**
		 * Builder operations are used to construct elements of containment features and contribute to the "Create" button items.
		 */
		builder, 
		
		/**
		 * Editor operations are used to edit objects, they replace the "Edit" button default wiring.
		 */
		editor 
	}
		
	private EOperation eOperation;
	protected Map<String, Object> spec;
	protected Map<EParameter, Object> parameterBindings;
	private String path;
	private String feature;
	private String featureValue;
	private Role role;	
	
	@SuppressWarnings("unchecked")
	public <C extends Context, T extends EObject> EOperationTargetInfo(C context, Renderer<C,T> renderer, EOperation eOperation) throws Exception {
		this(context, renderer, eOperation, (Map<String, Object>) renderer.getYamlRenderAnnotation((C) context, eOperation, RenderAnnotation.WEB_OPERATION));
	}

	public <C extends Context, T extends EObject> EOperationTargetInfo(
			C context, 
			Renderer<C,T> renderer, 
			EOperation eOperation, 
			Map<String, Object> spec) throws Exception {
		
		this.eOperation = eOperation;
		this.spec = spec;
		parameterBindings = new HashMap<>();
		for (EParameter eParameter: eOperation.getEParameters()) {
			Object bindingAnnotation = renderer.getYamlRenderAnnotation(context, eParameter, RenderAnnotation.BIND);
			if (bindingAnnotation != null) {
				parameterBindings.put(eParameter, bindingAnnotation);
			}
		}
		feature = (String) spec.get("feature");
		featureValue = (String) spec.get("feature-value");
		
		String path = (String) spec.get("path");
		if (path == null) {
			path = eOperation.getName();
//			for (EParameter eParameter: eOperation.getEParameters()) {
//				path += "-" + eParameter.getEType().getInstanceTypeName();
//			}
		}
		
		String roleStr = (String) spec.get("role");
		role = CoreUtil.isBlank(roleStr) ? Role.operation : Role.valueOf(roleStr);
		
		this.path = path;
	}
	
	public String getFeature() {
		return feature;
	}
	
	public String getFeatureValue() {
		return featureValue;
	}
	
	public Role getRole() {
		return role;
	}
	
	public boolean hasFormParameters() {
		for (EParameter eParameter: eOperation.getEParameters()) {
			if (isFormParameter(eParameter)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPartParameters() {
		for (Object binding: parameterBindings.values()) {
			if ("part".equals(binding)) {
				return true;
			}
			if (binding instanceof Map) {
				for (Object key: ((Map<?,?>) binding).keySet()) {
					if ("part".equals(key)) {
						return true;
					}					
				}
			}
		}
		return false;
	}
			
	public boolean isFormParameter(EParameter eParameter) {
		Object binding = parameterBindings.get(eParameter);
		if (binding == null) {
			return true; // default
		}
		
		if ("form".equals(binding) || "part".equals(binding)) {
			return true;
		}
		if (binding instanceof Map && (((Map<?,?>) binding).containsKey("form") || ((Map<?,?>) binding).containsKey("part"))) {
			return true;
		}
		return false;
	}
	
	public String getQueryParameterName(EParameter eParameter) {
		Object binding = parameterBindings.get(eParameter);

		if ("query".equals(binding)) {
			return eParameter.getName();
		}
		
		if (binding instanceof Map) {
			Object val = ((Map<?, ?>) binding).get("query");
			if (val instanceof String) {
				return (String) val;
			}
		}
		
		return null;
	}	
	
	public Map<String, Object> getSpec() {
		return spec;
	}
	
	public EOperation getEOperation() {
		return eOperation;
	}

	public RequestMethod[] getRequestMethods() {
		String method = (String) spec.get("method");
		return method == null ? new RequestMethod[] { RequestMethod.GET, RequestMethod.POST } : new RequestMethod[] { RequestMethod.valueOf(method) }; 
	}

	public Pattern getPattern() {
		return null;
	}

	public String getPath() {
		return path;
	}

	public String getProduces() {
		return (String) spec.get("produces");
	}

	@SuppressWarnings("unchecked")
	public String[] getConsumes() {
		Object consumes = spec.get("consumes");
		if (consumes instanceof String) {
			return new String[] { (String) consumes };
		}
		if (consumes instanceof Collection) {
			return ((Collection<Object>) consumes).stream().filter(e -> e instanceof String).collect(Collectors.toList()).toArray(new String[0]);			
		}
		return null;
	}

	public String getAction() {
		String action = (String) spec.get("action");
		if (action != null) {
			return action;
		}
		switch (getRole()) {
		case builder:
			return AuthorizationProvider.StandardAction.create.name();
		case editor:
			return AuthorizationProvider.StandardAction.update.name();
		case operation:
		default:
			return AuthorizationProvider.StandardAction.execute.name();
		}
	}

	public String getQualifier() {
		String qualifier = (String) spec.get("qualifier");
		return qualifier == null ? eOperation.getName() : qualifier;
	}

	public String getComment() {
		return "Invokes "+eOperation;
	}
	
}
