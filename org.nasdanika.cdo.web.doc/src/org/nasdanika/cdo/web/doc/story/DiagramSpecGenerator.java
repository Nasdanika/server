package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.ecore.EObject;

public interface DiagramSpecGenerator {
	
	boolean hasDiagram(EObject obj);
	
	void diagramSpec(EObject obj, StringBuilder specBuilder);
	
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
