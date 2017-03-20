package org.nasdanika.cdo.web.doc.story;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DependencyTracer;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;

class StateHierarchyDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public StateHierarchyDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
		this.storyDocumentationGenerator = storyDocumentationGenerator;
	}

	@Override
	public boolean hasDiagram(EObject obj) {
		if (isDiagramElement(obj)) {
			return true;
		}
		
		TreeIterator<EObject> tit = obj.eAllContents();
		while (tit.hasNext()) {
			if (isDiagramElement(tit.next())) {
				return true;
			}
		}
		
		return false;		
	}
		
	private static DependencyTracer<EObject> IN_DEPENDENCY_TRACER = new DependencyTracer<EObject>() {

		@Override
		protected Iterable<EObject> getDependencies(EObject obj) {
			Set<EObject> ret = new HashSet<>();
			TreeIterator<Notifier> tit = obj.eResource().getResourceSet().getAllContents();
			while (tit.hasNext()) {
				Notifier next = tit.next();
				if (next instanceof State && ((State) next).getSuperStates().contains(obj)) {
					ret.add((State) next);
				}
			}
			return ret;
		}
		
	}; 		
	
	private static DependencyTracer<EObject> OUT_DEPENDENCY_TRACER = new DependencyTracer<EObject>() {

		@Override
		protected Iterable<EObject> getDependencies(EObject obj) {			
			return obj instanceof State ? new ArrayList<EObject>(((State) obj).getSuperStates()) : Collections.emptySet();
		}
		
	};
		
	private static DependencyTracer<EObject> BOTH_DEPENDENCY_TRACER = new DependencyTracer<EObject>() {

		@Override
		protected Iterable<EObject> getDependencies(EObject obj) {			
			Set<EObject> ret = new HashSet<>();
			// In
			TreeIterator<Notifier> tit = obj.eResource().getResourceSet().getAllContents();
			while (tit.hasNext()) {
				Notifier next = tit.next();
				if (next instanceof State && ((State) next).getSuperStates().contains(obj)) {
					ret.add((State) next);
				}
			}
			// Out
			if (obj instanceof State) {
				ret.addAll(((State) obj).getSuperStates());
			}
			return ret;
		}
		
	}; 		
	
	
	private static boolean isDiagramElement(EObject obj) {
		return obj instanceof State;
	}	
	
	private static class StateEntry {
		
		public StateEntry(int id) {
			this.id = id;
		}
		
		int id;
		List<Scenario> outboundScenarios = new ArrayList<>();
	}		

	@Override
	public void diagramSpec(EObject obj, int depth, Direction direction, StringBuilder specBuilder) {
		Set<EObject> diagramElements = new HashSet<EObject>();
		if (isDiagramElement(obj)) {
			diagramElements.add(obj);			
		}
		
		TreeIterator<EObject> tit = obj.eAllContents();
		while (tit.hasNext()) {
			EObject next = tit.next();
			if (isDiagramElement(next)) {
				diagramElements.add(next);
			}
		}
		
		switch (direction) {
		case both:
			diagramElements = BOTH_DEPENDENCY_TRACER.trace(diagramElements, depth);
			break;
		case in:
			diagramElements = IN_DEPENDENCY_TRACER.trace(diagramElements, depth);
			break;
		case out:
			diagramElements = OUT_DEPENDENCY_TRACER.trace(diagramElements, depth);
			break;
		default:
			break;
		
		}
		
		int counter = 0;		
				
		Map<State, StateEntry> deMap = new HashMap<>();
		for (EObject de: diagramElements) {
			if (de instanceof State) {
				deMap.put((State) de, new StateEntry(counter++));
			}
		}		
		
		TreeIterator<Notifier> rstit = obj.eResource().getResourceSet().getAllContents();
		while (rstit.hasNext()) {
			Notifier next = rstit.next();
			if (next instanceof Scenario) {
				for (Entry<State, StateEntry> e: deMap.entrySet()) {
					if (((Scenario) next).getContextStates().contains(e.getKey())) {
						e.getValue().outboundScenarios.add((Scenario) next);
					}
				}
			}
		}
		
		for (StateEntry ev: deMap.values()) {
			Collections.sort(ev.outboundScenarios, CatalogDocumentationGenerator.CATALOG_ELEMENT_NAME_COMPARATOR);			
		}
		

		for (EObject de: diagramElements) {
			if (de instanceof State) {
				diagramElementDefinition((State) de, deMap, specBuilder);
			}
		}		
		for (EObject de: diagramElements) {
			if (de instanceof State) {
				diagramElementRelations((State) de, deMap, specBuilder);
			}
		}		
	}
	
	protected void diagramElementDefinition(State diagramElement, Map<State, StateEntry> deMap, StringBuilder specBuilder) {
		specBuilder
			.append("object \"")
			.append(diagramElement.getName())
			.append("\" as DE")
			.append(deMap.get(diagramElement).id)
			.append(" {")
			.append(System.lineSeparator());
		
		for (Scenario os: deMap.get(diagramElement).outboundScenarios) {
			specBuilder
				.append("\t+ ")
				.append(os.getName())
				.append(System.lineSeparator());
		}
		
		specBuilder.append("}").append(System.lineSeparator());		
	}

	protected void diagramElementRelations(State diagramElement, Map<State, StateEntry> deMap, StringBuilder specBuilder) {
		for (State ss: diagramElement.getSuperStates()) {
			if (deMap.containsKey(ss)) {
				specBuilder
					.append("DE")
					.append(deMap.get(diagramElement).id)
					.append(" -u-|> DE")
					.append(deMap.get(ss).id)
					.append(System.lineSeparator());
			}
		}						
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
