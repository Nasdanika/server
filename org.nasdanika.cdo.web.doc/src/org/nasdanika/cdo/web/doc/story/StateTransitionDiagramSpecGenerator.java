package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.story.Step;

class StateTransitionDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public StateTransitionDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public boolean hasDiagram(EObject obj) {
		if (obj instanceof State) {
			return true;
		}
		
		if (obj instanceof Scenario) {
			return true;
		}
		
		if (obj instanceof Step) {
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
	public void diagramSpec(EObject obj, int depth, Direction direction, StringBuilder specBuilder) {
		specBuilder.append("note \"TODO: "+getLabel()+"\" as TODO_NOTE").append(System.lineSeparator());		
	}

	@Override
	public String getLabel() {
		return "State Transition";
	}

	@Override
	public String getName() {
		return "state-transition";
	}

}
