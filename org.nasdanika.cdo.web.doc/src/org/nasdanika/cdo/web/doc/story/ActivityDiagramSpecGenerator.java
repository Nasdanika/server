package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.Scenario;

class ActivityDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public ActivityDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public boolean hasDiagram(EObject obj) {
		return obj instanceof Scenario && !((Scenario) obj).getSteps().isEmpty();
	}

	@Override
	public void diagramSpec(EObject obj, int depth, Direction direction, StringBuilder specBuilder) {
		specBuilder.append("note \"TODO: "+getLabel()+"\" as TODO_NOTE").append(System.lineSeparator());		
	}

	@Override
	public String getLabel() {
		return "Activity";
	}

	@Override
	public String getName() {
		return "activity";
	}

}
