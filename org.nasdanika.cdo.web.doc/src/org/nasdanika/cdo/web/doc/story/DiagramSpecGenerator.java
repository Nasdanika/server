package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.ecore.EObject;

public interface DiagramSpecGenerator {
	
	enum Direction { in, out, both }
			
	boolean hasDiagram(EObject obj);
	
	void diagramSpec(EObject obj, int depth, Direction direction, StringBuilder specBuilder);
	
	/**
	 * Generator label to display in the drop-down
	 * @return
	 */
	String getLabel();
	
	/**
	 * Generator name
	 * @return
	 */
	String getName();
	

}
