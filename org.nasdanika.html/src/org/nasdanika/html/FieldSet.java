package org.nasdanika.html;


public interface FieldSet extends UIElement<FieldSet>, FieldContainer<FieldSet> {
	
	FieldSet disabled(boolean disabled);
	
	FieldSet disabled();
}