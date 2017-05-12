package org.nasdanika.cdo.web.routes.app;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.nasdanika.core.Context;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.html.RowContainer.Row;

/**
 * Filtering listener.
 * @author Pavel Vlasov
 *
 */
public class TypedElementTableRenderListenerFilter<C extends Context, T extends EObject> extends TypedElementTableRenderListener<C,T> {
	
	private TypedElementTableRenderListener<C, T> chain;
	
	@Override
	public void onTable(C context, T obj, ETypedElement typedElement, Object typedElementValue, Table table) throws Exception {
		this.chain.onTable(context, obj, typedElement, typedElementValue, table);
	}

	public TypedElementTableRenderListenerFilter(TypedElementTableRenderListener<C,T> chain) {
		this.chain = chain;
	}
	
	public void onFeatureHeader(C context, T obj, ETypedElement typedElement, Object typedElementValue, EStructuralFeature tableFeature, Object featureSpec, Cell featureHeader) throws Exception {		
		chain.onFeatureHeader(context, obj, typedElement, typedElementValue, tableFeature, featureSpec, featureHeader);
	}
	
	public void onElementRow(C context, T obj, ETypedElement typedElement, Object typedElementValue, EObject elementValue, int rowNumber, Row row) throws Exception {		
		chain.onElementRow(context, obj, typedElement, typedElementValue, elementValue, rowNumber, row);
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
			Cell vCell) throws Exception {
		
		chain.onElementFeatureCell(context, obj, typedElement, typedElementValue, elementValue, tableFeature, featureSpec, featureValue, vCell);
	}
	
}
