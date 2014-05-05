package org.nasdanika.html;

public interface Select extends UIElement<Select> {
	
	interface OptionGroup {
		
		OptionGroup disabled(boolean disabled);
		
		OptionGroup disabled();
		
		OptionGroup option(String value, String label, boolean selected, boolean disabled);
		
	}
	
	OptionGroup optionGroup(String label);
	
	Select option(String value, String label, boolean selected, boolean disabled);

}
