package org.nasdanika.cdo.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EModelElement;

/**
 * Helper class to reduce amount of diagnostic/validation code.
 * @author Pavel Vlasov
 *
 */
public class DiagnosticHelper {
	
	private String source;
	private int code;
	private DiagnosticChain diagnostics;
	private Object owner;

	public DiagnosticHelper(DiagnosticChain diagnostics, String source, int code, Object owner) {
		this.diagnostics = diagnostics;
		this.source = source;
		this.code = code;
		this.owner = owner;
	}
	
	private boolean success = true;
	
	/**
	 * @return true if there were no error level diagnostics.
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * Adds diagnostic.
	 * @param severity
	 * @param message Diagnostic message.
	 * @param messageKey Message key for localization, can be null.
	 * @param modelElement Feature under diagnostic. Can be null.
	 */
	public void addDiagnostic(int severity, String message, String messageKey, EModelElement modelElement) {
		if (diagnostics != null) {
			List<Object> data = new ArrayList<>();
			data.add(owner);
			if (modelElement != null) {
				data.add(modelElement);
			}
			if (messageKey != null) {
				data.add(messageKey);
			}
			diagnostics.add(new BasicDiagnostic(severity, source, code, message, data.toArray()));
		
			if (Diagnostic.ERROR == severity) {
				success = false;
			}
			
		}
	}
	
	public void error(String message, String messageKey, EModelElement modelElement) {
		addDiagnostic(Diagnostic.ERROR, message, messageKey, modelElement);
	}
	
	public void error(String message, String messageKey) {
		error(message, messageKey, null);
	}
	
	public void error(String message, EModelElement modelElement) {
		error(message, null, modelElement);
	}
	
	public void error(String message) {
		error(message, null, null);
	}
	
	public void warning(String message, String messageKey, EModelElement modelElement) {
		addDiagnostic(Diagnostic.WARNING, message, messageKey, modelElement);
	}
	
	public void warning(String message, String messageKey) {
		warning(message, messageKey, null);
	}
	
	public void warning(String message, EModelElement modelElement) {
		warning(message, null, modelElement);
	}
	
	public void warning(String message) {
		warning(message, null, null);
	}
	
	public void info(String message, String messageKey, EModelElement modelElement) {
		addDiagnostic(Diagnostic.INFO, message, messageKey, modelElement);
	}
	
	public void info(String message, String messageKey) {
		info(message, messageKey, null);
	}
	
	public void info(String message, EModelElement modelElement) {
		info(message, null, modelElement);
	}
	
	public void info(String message) {
		info(message, null, null);
	}
	
}