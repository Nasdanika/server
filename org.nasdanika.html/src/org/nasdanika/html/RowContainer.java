package org.nasdanika.html;

import java.util.List;

public interface RowContainer<T extends RowContainer<T>> extends Container<T>, UIElement<T> {
	
	interface Row extends UIElement<Row>, Container<Row> {
		
		interface Cell extends UIElement<Cell>, Container<Cell> {
			
			Cell colspan(int colspan);
			
			Cell rowspan(int rowspan);
			
		}				
		
		Cell cell(Object... content);
		
		Cell header(Object... content);
		
		Row style(Bootstrap.Style style);
		
		List<Cell> cells();
		
	}
		
	List<Row> rows();
	
	Row row();	

}
