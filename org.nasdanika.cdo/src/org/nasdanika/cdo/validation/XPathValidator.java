package org.nasdanika.cdo.validation;

import java.util.Map;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.xpath.EMFFunctions;

/**
 * Validator which uses XPath expression.
 * @author Pavel Vlasov
 *
 */
public class XPathValidator implements Validator<EObject> {
	
	private String condition;
	private String severity;
	private String message;
	private String feature;
	
	/**
	 * XPath expression which should evaluate to true for successful validation.
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Validation severity - 'WARNING' or 'ERROR', defaults to 'ERROR'
	 * @param severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	/**
	 * Validation message, defaults to 'Constraint violation: '+<code>condition</code>.
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Optional name of the structural feature (attribute or reference) being validated.
	 * @param feature
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * Evaluates condition with 'this', 'root', and 'context' variables.
	 */
	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		try {
			JXPathContext jxPathContext = JXPathContext.newContext(eObject);
			jxPathContext.setLenient(true);
			Variables variables = jxPathContext.getVariables();
			if (context != null) {
				variables.declareVariable("context", context);
			}
			
			variables.declareVariable("this", eObject);
			EObject root = eObject;
			while (root.eContainer() instanceof EObject) {
				root = (EObject) root.eContainer();
			}
			variables.declareVariable("root", root);
			
			jxPathContext.setFunctions(new ClassFunctions(EMFFunctions.class, "ecore"));
			
			if (!Boolean.TRUE.equals(jxPathContext.getValue(condition, Boolean.TYPE))) {			 
				Object[] data = feature == null ? new Object[] { eObject } : new Object[] { eObject, eObject.eClass().getEStructuralFeature(feature) };
				diagnostics.add(new BasicDiagnostic(
						"WARNING".equals(severity) ? Diagnostic.WARNING : Diagnostic.ERROR, 
						getClass().getName(), 
						0, 
						message == null ? "Constraint violation: "+condition : message,
						data));
				return false;
			}						
			
			return true;
		} catch (Exception e) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, getClass().getName(), 0, "Exception evaluating '"+condition+"': "+e, new Object[] { eObject, e, condition }));
			return false;			
		}
	}

}
