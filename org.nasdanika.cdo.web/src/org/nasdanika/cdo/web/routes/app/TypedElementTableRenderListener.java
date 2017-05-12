package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.core.Context;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;

/**
 * Passed as a parameter to ``renderTypedElementView`` to customize table rendering.
 * This implementation uses render annotation specs for adjusting table rendering.
 * @author Pavel Vlasov
 *
 */
public class TypedElementTableRenderListener<C extends Context, T extends EObject> {

	public void onTable(C context, T obj, ETypedElement typedElement, Object typedElementValue, Table table) throws Exception {		
		
	}	
	
	public void onFeatureHeader(C context, T obj, ETypedElement typedElement, Object typedElementValue, EStructuralFeature tableFeature, Object featureSpec, Cell featureHeader) throws Exception {		
		
	}
	
	public void onElementRow(C context, T obj, ETypedElement typedElement, Object typedElementValue, EObject elementValue, int rowNumber, Row row) throws Exception {		
		
	}

	public void onElementFeatureCell(
			C context, 
			T obj, 
			ETypedElement typedElement, 
			Object typedElementValue, 
			EObject elementValue,
			EStructuralFeature tableFeature, 
			Object featureSpec, 
			Object featureValue, 
			Cell cell) throws Exception {
		
		if (featureSpec instanceof Map) {
			Object attributes = ((Map<?,?>) featureSpec).get("attributes");
			if (attributes instanceof Map) {
				for (Map.Entry<?, ?> e: ((Map<?,?>) attributes).entrySet()) {
					if (e.getKey() instanceof String) {
						cell.attribute((String) e.getKey(), e.getValue()); 
					}
				}
			}
			Object classes = ((Map<?,?>) featureSpec).get("classes");
			if (classes instanceof Collection) {
				for (Object cls: (Collection<?>) classes) {
					cell.addClass(cls); 
				}
			} else if (classes != null) {
				cell.attribute("class", classes);
			}
			Object style = ((Map<?,?>) featureSpec).get("style");
			if (style instanceof Map) {
				for (Map.Entry<?, ?> e: ((Map<?,?>) style).entrySet()) {
					if (e.getKey() instanceof String) {
						cell.style((String) e.getKey(), e.getValue()); 
					}
				}
			} else if (style != null) {
				cell.attribute("style", style);
			}
		} else {
			// Default alignments
			if (featureValue instanceof Boolean || featureValue instanceof Date) {
				cell.style().text().align().center();
			} else if (featureValue instanceof Number) {
				cell.style().text().align().right();				
			}
		}		
	}
	
}
