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
import org.nasdanika.story.Story;

class StateTransitionDiagramSpecGenerator implements DiagramSpecGenerator {

	private StoryDocumentationGenerator storyDocumentationGenerator;

	public StateTransitionDiagramSpecGenerator(StoryDocumentationGenerator storyDocumentationGenerator) {
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
				if (next instanceof Scenario && ((Scenario) next).getOutcomeState() == obj) {
					ret.addAll(((Scenario) next).getContextStates());
				}
			}
			return ret;
		}
		
	}; 		
	
	private static DependencyTracer<EObject> OUT_DEPENDENCY_TRACER = new DependencyTracer<EObject>() {

		@Override
		protected Iterable<EObject> getDependencies(EObject obj) {			
			Set<EObject> ret = new HashSet<>();
			TreeIterator<Notifier> tit = obj.eResource().getResourceSet().getAllContents();
			while (tit.hasNext()) {
				Notifier next = tit.next();
				if (next instanceof Scenario && ((Scenario) next).getContextStates().contains(obj) && ((Scenario) next).getOutcomeState() != null) {
					ret.add(((Scenario) next).getOutcomeState());
				}
			}
			return ret;
		}
		
	}; 		
	
	private static boolean isDiagramElement(EObject obj) {
		return obj instanceof State || obj instanceof Scenario;
	}	
	
	private static class StateEntry {
		
		public StateEntry(int id) {
			this.id = id;
		}
		
		int id;
		List<Scenario> outboundScenarios = new ArrayList<>();
		List<Scenario> inboundScenarios = new ArrayList<>();
	}		

	@SuppressWarnings("unchecked")
	@Override
	public void diagramSpec(EObject obj, int depth, Direction direction, StringBuilder specBuilder) {
		Set<EObject> diagramElements = new HashSet<EObject>();
		if (isDiagramElement(obj)) {
			diagramElements.add(obj);			
			if (obj instanceof Scenario) {
				diagramElements.addAll(((Scenario) obj).getContextStates());
				State outcomeState = ((Scenario) obj).getOutcomeState();
				if (outcomeState != null) {
					diagramElements.add(outcomeState);
				}
			}
		}
		
		TreeIterator<EObject> tit = obj.eAllContents();
		while (tit.hasNext()) {
			EObject next = tit.next();
			if (isDiagramElement(next)) {
				diagramElements.add(next);
				if (next instanceof Scenario) {
					diagramElements.addAll(((Scenario) next).getContextStates());
					diagramElements.add(((Scenario) next).getOutcomeState());
				}
			}
		}
		
		switch (direction) {
		case both:
			diagramElements = IN_DEPENDENCY_TRACER.trace(diagramElements, depth, OUT_DEPENDENCY_TRACER);
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
					if (((Scenario) next).getOutcomeState() == e.getKey()) {
						e.getValue().inboundScenarios.add((Scenario) next);
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
		if (obj instanceof Story) {
			Z: for (State state: ((Story) obj).getStartStates()) {
				StateEntry se = deMap.get(state);
				if (se != null) {
					for (Scenario is: se.inboundScenarios) {
						if (is.getContextStates().isEmpty()) {
							// There is a scenario transitioning from Start
							// No need in implied transition.
							continue Z; 
						}
					}
					specBuilder
						.append("[*] --> DE")
						.append(deMap.get(state).id)
						.append(System.lineSeparator());
				}
			}
		}
		for (EObject de: diagramElements) {
			if (de instanceof State) {
				diagramElementRelations((State) de, deMap, specBuilder);
			} else if (de instanceof Scenario && ((Scenario) de).getContextStates().isEmpty() && ((Scenario) de).getOutcomeState() == null) {
				specBuilder
					.append("[*] --> [*] : ")
					.append(((Scenario) de).getName())
					.append(System.lineSeparator());								
			}
		}
		if (obj instanceof Story) {
			for (State state: ((Story) obj).getEndStates()) {
				if (state != null && deMap.containsKey(state)) {
					specBuilder
						.append("DE")
						.append(deMap.get(state).id)
						.append(" --> [*]")
						.append(System.lineSeparator());
				}
			}
		}		
	}
	
	protected void diagramElementDefinition(State diagramElement, Map<State, StateEntry> deMap, StringBuilder specBuilder) {
		if (diagramElement.eContainer() instanceof Scenario) {
			// Private state, display only if has inbound/outbound scenarios (which it shall not generally)
			if (deMap.get(diagramElement).inboundScenarios.isEmpty() && deMap.get(diagramElement).outboundScenarios.isEmpty()) {
				return;
			}
		}
		
		specBuilder
			.append("state \"")
			.append(diagramElement.getName())
			.append("\" as DE")
			.append(deMap.get(diagramElement).id)
			.append(System.lineSeparator());
		
	}

	protected void diagramElementRelations(State diagramElement, Map<State, StateEntry> deMap, StringBuilder specBuilder) {
		for (Scenario os: deMap.get(diagramElement).outboundScenarios) {
			if (os.getOutcomeState() == null) {
				specBuilder
					.append("DE")
					.append(deMap.get(diagramElement).id)
					.append(" --> [*] : ")
					.append(os.getName())
					.append(System.lineSeparator());				
			} else if (deMap.containsKey(os.getOutcomeState())) {
				specBuilder
					.append("DE")
					.append(deMap.get(diagramElement).id)
					.append(" --> DE")
					.append(deMap.get(os.getOutcomeState()).id)
					.append(" : ")
					.append(os.getName())
					.append(System.lineSeparator());
			}
		}
		
		for (Scenario os: deMap.get(diagramElement).inboundScenarios) {
			if (os.getContextStates().isEmpty()) {
				specBuilder
					.append("[*] --> DE")
					.append(deMap.get(diagramElement).id)
					.append(" : ")
					.append(os.getName())
					.append(System.lineSeparator());				
			}
		}		
		
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
