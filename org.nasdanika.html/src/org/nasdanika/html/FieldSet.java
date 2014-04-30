package org.nasdanika.html;


public interface FieldSet extends UIElement<FieldSet>, FieldWriter<FieldSet> {
	
	FieldSet disabled(boolean disabled);
	
	FieldSet disabled();
}