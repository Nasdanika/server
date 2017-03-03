package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.web.routes.app.Renderer.ValidationResult;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormGroup.Status;

/**
 * Converts consumed diagnostics to validation results and groups them by structural features, if any.
 * @author Pavel Vlasov
 *
 */
public abstract class ValidationResultsDiagnostiConsumer implements Consumer<Diagnostic> {
	
	private List<ValidationResult> validationResults = new ArrayList<>();
	private Map<EStructuralFeature, List<ValidationResult>> featureValidationResults = new LinkedHashMap<>();
	
	/**
	 * 
	 * @return Feature validation results.
	 */
	public Map<EStructuralFeature, List<ValidationResult>> getFeatureValidationResults() {
		return featureValidationResults;
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
		EStructuralFeature esf = null;
		// Second element, if present.
		if (dData.size() > 1 && dData.get(1) instanceof EStructuralFeature) {
			esf = (EStructuralFeature) dData.get(1);
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
				message = getResourceString(esf, messageKey);
			} catch (Exception ex) {
				ex.printStackTrace();
			}			
		}
		String escapedMessage = CoreUtil.isBlank(message) ? status.name() : StringEscapeUtils.escapeHtml4(message);
		ValidationResult validationResult = new ValidationResult(status, escapedMessage);
		if (esf == null) {
			validationResults.add(validationResult);
		} else {
			List<ValidationResult> fvrl = featureValidationResults.get(esf);
			if (fvrl == null) {
				fvrl = new ArrayList<>();
				featureValidationResults.put(esf, fvrl);
			}
			fvrl.add(validationResult);
		}
	}

	/**
	 * Retrieves resource string for error message for {@link EStructuralFeature}. 
	 * @param feature Feature. If null, the message is retrieved from/for the diagnostic target {@link EClass}.
	 * @param key
	 * @return
	 * @throws Exception
	 */
	protected abstract String getResourceString(EStructuralFeature feature, String key) throws Exception;
	
}
