package org.nasdanika.cdo.web.doc.story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.doc.DependencyTracer;
import org.nasdanika.cdo.web.doc.EObjectInDependencyTracer;
import org.nasdanika.cdo.web.doc.EObjectOutDependencyTracer;
import org.nasdanika.story.Actor;
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
		
	private static boolean isDiagramElement(EObject obj) {
		return obj instanceof Protagonist || obj instanceof Story;
	}
	
	private static DependencyTracer<EObject> IN_DEPENDENCY_TRACER = new EObjectInDependencyTracer(); {
		
//		protected void onDependency(EObject source, EObject target, org.eclipse.emf.ecore.EReference ref) {
//			System.out.print("[IN] "+ref.getEContainingClass().getName()+"."+ref.getName()+" ");
//			if (source instanceof CatalogElement) {
//				System.out.print(source.eClass().getName()+" "+((CatalogElement) source).getName()+" -> ");				
//			} else {
//				System.out.print(source.eClass().getName()+" "+source +" -> ");				
//			}
//			
//			if (target instanceof CatalogElement) {
//				System.out.println(target.eClass().getName()+" "+((CatalogElement) target).getName());				
//			} else {
//				System.out.println(target.eClass().getName()+" "+target);				
//			}
//			
//		}
		
	};
		
	
	private static DependencyTracer<EObject> OUT_DEPENDENCY_TRACER = new EObjectOutDependencyTracer() {
		
//		protected void onDependency(EObject source, EObject target, org.eclipse.emf.ecore.EReference ref) {
//			System.out.print("[OUT] "+ref.getEContainingClass().getName()+"."+ref.getName()+" ");
//			if (source instanceof CatalogElement) {
//				System.out.print(source.eClass().getName()+" "+((CatalogElement) source).getName()+" -> ");				
//			} else {
//				System.out.print(source.eClass().getName()+" "+source +" -> ");				
//			}
//			
//			if (target instanceof CatalogElement) {
//				System.out.println(target.eClass().getName()+" "+((CatalogElement) target).getName());				
//			} else {
//				System.out.println(target.eClass().getName()+" "+target);				
//			}
//			
//		}
		
	};

	@SuppressWarnings("unchecked")
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
		Map<EObject, Integer> idMap = new HashMap<>();
		for (EObject de: diagramElements) {
			if (isDiagramElement(de)) {
				idMap.put(de, counter++);
				diagramElementDefinition(de, idMap, specBuilder);
			}
		}		
		for (EObject de: diagramElements) {
			if (isDiagramElement(de)) {
				diagramElementRelations(de, idMap, specBuilder);
			}
		}		
	}
	
	protected void diagramElementDefinition(EObject diagramElement, Map<EObject, Integer> idMap, StringBuilder specBuilder) {
		// Story
		if (diagramElement instanceof Story) {
			specBuilder
				.append("usecase DE")
				.append(idMap.get(diagramElement))
				.append(" as \"")
				.append(((Story) diagramElement).getName())
				.append("\"")
				.append(System.lineSeparator());
		}
		
		// Role
		if (diagramElement instanceof Role) {
			specBuilder
				.append("actor DE")
				.append(idMap.get(diagramElement))
				.append(" as \"")
				.append(((Role) diagramElement).getName())
				.append("\" #DDDDDD")
				.append(System.lineSeparator());			
		}
		
		// Actor
		if (diagramElement instanceof Actor) {
			specBuilder
				.append("actor DE")
				.append(idMap.get(diagramElement))
				.append(" as \"")
				.append(((Actor) diagramElement).getName())
				.append("\"")
				.append(System.lineSeparator());			
		}
		
	}

	protected void diagramElementRelations(EObject diagramElement, Map<EObject, Integer> idMap, StringBuilder specBuilder) {
		// Story
		if (diagramElement instanceof Story) {
			for (Story dep: ((Story) diagramElement).getDepends()) {
				if (idMap.containsKey(dep)) {
					specBuilder
						.append("(DE")
						.append(idMap.get(diagramElement))
						.append(") .d.> (DE")
						.append(idMap.get(dep))
						.append(")")
						.append(System.lineSeparator());
				}
			}
			List<Protagonist> protagonists = new ArrayList<>();
			for (EObject container = diagramElement.eContainer(); container!=null; container = container.eContainer()) {
				if (container instanceof Protagonist) {
					protagonists.add((Protagonist) container);
					break;
				}
			}
			protagonists.addAll(((Story) diagramElement).getProtagonists());
			
			for (Protagonist pt: protagonists) {
				if (idMap.containsKey(pt)) {
					specBuilder
						.append("(DE")
						.append(idMap.get(pt))
						.append(") -r-> DE")
						.append(idMap.get(diagramElement))
						.append(System.lineSeparator());
				}
			}
		}
				
		// Role
		if (diagramElement instanceof Role) {
			for (Role sr: ((Role) diagramElement).getSuperRoles()) {
				if (idMap.containsKey(sr)) {
					specBuilder
						.append("DE")
						.append(idMap.get(diagramElement))
						.append(" -u-|> DE")
						.append(idMap.get(sr))
						.append(System.lineSeparator());
				}
			}
			for (Role sr: ((Role) diagramElement).getSubRoles()) {
				if (idMap.containsKey(sr)) {
					specBuilder
						.append("DE")
						.append(idMap.get(sr))
						.append(" -u-|> DE")
						.append(idMap.get(diagramElement))
						.append(System.lineSeparator());
				}
			}
		}
		
		// Actor
		if (diagramElement instanceof Actor) {
			for (Role sr: ((Actor) diagramElement).getRoles()) {
				if (idMap.containsKey(sr)) {
					specBuilder
						.append("DE")
						.append(idMap.get(diagramElement))
						.append(" .u.|> DE")
						.append(idMap.get(sr))
						.append(System.lineSeparator());
				}
			}
			for (Actor sa: ((Actor) diagramElement).getSubActors()) {
				if (idMap.containsKey(sa)) {
					specBuilder
						.append("DE")
						.append(idMap.get(sa))
						.append(" -u-|> DE")
						.append(idMap.get(diagramElement))
						.append(System.lineSeparator());
				}
			}
			for (Actor sa: ((Actor) diagramElement).getSuperActors()) {
				if (idMap.containsKey(sa)) {
					specBuilder
						.append("DE")
						.append(idMap.get(diagramElement))
						.append(" -u-|> DE")
						.append(idMap.get(sa))
						.append(System.lineSeparator());
				}
			}
		}						
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
