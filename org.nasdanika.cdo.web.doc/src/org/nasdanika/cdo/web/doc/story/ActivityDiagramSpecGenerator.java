package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.story.Step;

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
		// TODO - conditionals.
		State currentState = null;
		for (Step step: ((Scenario) obj).getSteps()) {
			State stepFromState = step.getFromState();
			if (stepFromState != null) {
				if (currentState == null) {
					specBuilder.append("start").append(System.lineSeparator());
				}
				if (stepFromState != currentState) {
					specBuilder.append(":").append(stepFromState.getName()).append(";").append(System.lineSeparator());
				}
				currentState = stepFromState;
			}
			specBuilder.append("-> ").append(step.getName()).append(";").append(System.lineSeparator());
			State stepToState = step.getToState();
			if (stepToState != null) {
				specBuilder.append(":").append(stepToState.getName()).append(";").append(System.lineSeparator());
				currentState = stepToState;
			}			
		}
		specBuilder.append("end").append(System.lineSeparator());
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
