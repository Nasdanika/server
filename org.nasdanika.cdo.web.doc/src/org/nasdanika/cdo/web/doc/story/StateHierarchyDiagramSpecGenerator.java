package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.State;

class StateHierarchyDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public StateHierarchyDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public boolean hasDiagram(EObject obj) {
		if (obj instanceof State) {
			return true;
		}
		
		TreeIterator<EObject> tit = obj.eAllContents();
		while (tit.hasNext()) {
			if (hasDiagram(tit.next())) {
				return true;
			}
		}
		
		return false;		
	}

	@Override
	public void diagramSpec(EObject obj, StringBuilder specBuilder) {
		specBuilder.append("note \"TODO: "+getLabel()+"\" as TODO_NOTE").append(System.lineSeparator());		
	}

	@Override
	public String getLabel() {
		return "State Hierarchy";
	}

	@Override
	public String getName() {
		return "state-hierarchy";
	}

}
