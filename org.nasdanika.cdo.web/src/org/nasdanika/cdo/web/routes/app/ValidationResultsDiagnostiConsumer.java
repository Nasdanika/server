package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.cdo.web.routes.app.Renderer.ValidationResult;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormGroup.Status;

/**
 * Converts consumed diagnostics to validation results and groups them by structural features or {@link EParameter}'s, if any.
 * @author Pavel Vlasov
 *
 */
public abstract class ValidationResultsDiagnostiConsumer implements Consumer<Diagnostic> {
	
	private List<ValidationResult> validationResults = new ArrayList<>();
	private Map<ENamedElement, List<ValidationResult>> namedElementValidationResults = new LinkedHashMap<>();
	
	/**
	 * 
	 * @return Feature validation results.
	 */
	public Map<ENamedElement, List<ValidationResult>> getNamedElementValidationResults() {
		return namedElementValidationResults;
	}
	
	/**
	 * 
	 * @return EClass level validation results.
	 */
	public List<ValidationResult> getValidationResults() {
		return validationResults;
	}	

	@Override
	public void accept(Diagnostic diagnostic) {
		List<?> dData = diagnostic.getData();
		ENamedElement ene = null;
		// Second element, if present.
		if (dData.size() > 1 && dData.get(1) instanceof ENamedElement) {
			ene = (ENamedElement) dData.get(1);
		}
		String messageKey = null; 
		// Last element, if present.
		if (dData.size() > 1 && dData.get(dData.size()-1) instanceof String) {
			messageKey = (String) dData.get(dData.size()-1);
		}
		FormGroup.Status status;
		switch (diagnostic.getSeverity()) {
		case Diagnostic.ERROR:
			status = Status.ERROR;
			break;
		case Diagnostic.WARNING:
			status = Status.WARNING;
			break;
		default:
			status = Status.SUCCESS;
		}
		String message = diagnostic.getMessage();
		if (messageKey != null) {
			try {
				message = getResourceString(ene, messageKey);
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
		String escapedMessage = CoreUtil.isBlank(message) ? status.name() : StringEscapeUtils.escapeHtml4(message);
		ValidationResult validationResult = new ValidationResult(status, escapedMessage);
		if (ene == null) {
			validationResults.add(validationResult);
		} else {
			List<ValidationResult> fvrl = namedElementValidationResults.get(ene);
			if (fvrl == null) {
				fvrl = new ArrayList<>();
				namedElementValidationResults.put(ene, fvrl);
			}
			fvrl.add(validationResult);
		}
	}

	/**
	 * Retrieves resource string for error message for {@link ETypedElement}. 
	 * @param typedElement typedElement. If null, the message is retrieved from/for the diagnostic target {@link EClass}.
	 * @param key
	 * @return
	 * @throws Exception
	 */
	protected abstract String getResourceString(ENamedElement namedElement, String key) throws Exception;

	public JSONObject toJSON() {
		JSONObject ret = new JSONObject();
		JSONArray jvr = new JSONArray();
		ret.put("results", jvr);
		for (ValidationResult vr: getValidationResults()) {
			jvr.put(vr.toJSON());
		}
		JSONObject nejvr = new JSONObject();
		ret.put("namedElementValidationResults", nejvr);
		for (Entry<ENamedElement, List<ValidationResult>> nevr: getNamedElementValidationResults().entrySet()) {
			JSONArray vra = new JSONArray();
			nejvr.put(nevr.getKey().getName(), vra);
			for (ValidationResult vr: nevr.getValue()) {
				vra.put(vr.toJSON());
			}			
		}
		return ret;
	}
	
}
