package org.nasdanika.html;

public interface Table extends UIElement<Table> {
	
	interface Row extends UIElement<Row> {
		
		interface Cell extends UIElement<Cell>, Container<Cell> {
			
			Cell colspan(int colspan);
			
			Cell rowspan(int rowspan);
			
		}				
		
		Cell cell(Object... content);
		
		Cell header(Object... content);
		
		Row style(Style style);
		
		int length();
		
	}
	
	Row row();
	
	Table bordered(boolean bordered);
	
	Table hover(boolean hover);
	
	Table striped(boolean striped);
	
	Table condensed(boolean condensed);
	
	Table responsive(boolean responsive);

	Table bordered();
	
	Table hover();
	
	Table striped();
	
	Table condensed();
	
	Table responsive();
	
	int length();
	
	boolean isEmpty();

}
