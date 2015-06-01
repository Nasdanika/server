package org.nasdanika.cdo.web.html;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;

/**
 * Generates Bootstrap HTML form invoking EOperation through JavaScript API. Uses EOperation and EParameters metadata and annotations.
 * @author Pavel
 *
 */
public class EOperationFormGenerator extends FormGeneratorBase<EParameter> {

	private EOperation eOperation;

	public EOperationFormGenerator(EOperation eOperation) {
		this.eOperation = eOperation;
	}
	
	@Override
	protected EAnnotation getFormAnnotation() {
		return eOperation.getEAnnotation(FORM_ANNOTATION_SOURCE);
	}

	/**
	 * 
	 * @param htmlFactory
	 * @param form
	 * @throws Exception
	 */
	protected void populateForm(HTMLFactory htmlFactory, Form form) throws Exception {
		for (EParameter param: sortParameters(eOperation.getEParameters())) {
			generateGroup(htmlFactory, form, param);
		}		
	}

	/**
	 * Subclasses can override this method to sort parameters. This implementation just returns <code>parameters</code> argument.
	 * @param parameters
	 * @return
	 */
	protected List<EParameter> sortParameters(List<EParameter> parameters) {
		return parameters;
	}
	
}
