package org.nasdanika.cdo.web.doc.story;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Role;
import org.nasdanika.story.Story;

class UseCaseDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public UseCaseDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public boolean hasDiagram(EObject obj) {
		if (obj instanceof Role) {
			return true;
		}
		
		if (obj instanceof Protagonist) {
			return true;
		}
		
		if (obj instanceof Story) {
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
		return "Use Case";
	}

	@Override
	public String getName() {
		return "use-case";
	}

}
