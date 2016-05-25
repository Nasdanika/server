package org.nasdanika.cdo.web.doc.extensions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This code is based on net.sourceforge.plantuml.text.AbstractDiagramTextProvider and 
 * net.sourceforge.plantuml.ecore.AbstractEcoreDiagramTextProvider from 
 * https://github.com/hallvard/plantuml
 * @author Pavel Vlasov
 *
 */
public class PlantUmlTextGenerator {
	
	// TODO - support of packages and fully qualified names -> get rid of Logical name?
	
	private Appendable collector;

	public PlantUmlTextGenerator(Appendable collector) {
		this.collector = collector;
	}
	
	private static final String RELATION_LINE = "--";
	private static final String ASSOCIATION_RELATION = RELATION_LINE + ">";
	private static final String EXTENDS_RELATION = "<|" + RELATION_LINE, IMPLEMENTS_RELATION = "<|..";

	protected void appendClassStart(String modifiers, String classType, String name) throws IOException {
		if (modifiers != null) {
			collector.append(modifiers);
			collector.append(" ");
		}
		collector
			.append(classType)
			.append(" ")
			.append(name)
			.append(" {\n");
	}

	protected void appendClassEnd() throws IOException {
		collector.append("}\n");
	}

	private static String getSimpleName(String name) {
		return name==null ? null : name.substring(name.lastIndexOf('.') + 1);
	}

	protected void appendMember(String modifiers, String visibility, String type, String name, Iterable<String> parameters) throws IOException {
		collector.append("\t");
		if (visibility != null) {
			collector.append(visibility);
		}
		if (modifiers != null) {
			collector.append(modifiers);
			collector.append(" ");
		}
		if (type != null) {
			collector.append(type);
			collector.append(" ");
		}
		if (name != null) {
			collector.append(name);
		}
		if (parameters != null) {
			collector.append("(");
			Iterator<String> it = parameters.iterator();
			while (it.hasNext()) {
				collector.append(it.next());
				if (it.hasNext()) {
					collector.append(", ");
				}
			}
			collector.append(")");
		}
		collector.append("\n");
	}
	
	protected void appendAttribute(String modifiers, String visibility, String type, String name) throws IOException {
		appendMember(modifiers, visibility, type, name, null);
	}

	protected void appendOperation(String modifiers, String visibility, String type, String name, Iterable<String> parameters) throws IOException {
		appendMember(modifiers, visibility, type, name, parameters);
	}
		
	public void appendGeneralization(EClass subClass, EClass superClass) throws IOException {
		collector
			.append(qualifiedName(superClass))
			.append(" ")
			.append(superClass.isInterface() && !subClass.isInterface() ? IMPLEMENTS_RELATION : EXTENDS_RELATION)
			.append(" ")
			.append(qualifiedName(subClass))
			.append("\n");
	}
		
	// --- ECore ---
	
	/**
	 * Appends core classifiers, their related classifiers, and relationships
	 * @param coreClassifiers
	 * @throws IOException 
	 */
	public void appendWithRelationships(EClassifier... coreClassifiers) throws IOException {
		appendWithRelationships(Arrays.asList(coreClassifiers));
	}
	
	/**
	 * Appends core classifiers, their related classifiers, and relationships
	 * @param coreClassifiers
	 * @throws IOException 
	 */
	public void appendWithRelationships(Iterable<EClassifier> coreClassifiers) throws IOException {
		Set<EClassifier> coreSet = new HashSet<>();
		for (EClassifier cc: coreClassifiers) {
			if (coreSet.add(cc)) {
				append(cc);
			}
		}

		Set<EClassifier> relatedSet = new HashSet<>();
		for (EClassifier cc: coreSet) {
			if (cc instanceof EClass) {
				for (EClass st: ((EClass) cc).getESuperTypes()) {
					if (!coreSet.contains(st) && relatedSet.add(st)) {
						append(st, "#DDDDDD");
					}
				}
				for (EClass st: getSubTypes((EClass) cc)) {
					if (!coreSet.contains(st) && relatedSet.add(st)) {
						append(st, "#DDDDDD");
					}
				}
				for (EReference ref: ((EClass) cc).getEReferences()) {
					EClass refType = ref.getEReferenceType();
					if (!coreSet.contains(refType) && relatedSet.add(refType)) {
						append(refType, "#DDDDDD");
					}
				}
			}			
		}
		
		Set<EClassifier> allClassifiers = new HashSet<>(coreSet);
		allClassifiers.addAll(relatedSet);
		for (EClassifier c: allClassifiers) {
			if (c instanceof EClass) {
				for (EClass sc: ((EClass) c).getESuperTypes()) {
					if (allClassifiers.contains(sc)) {
						appendGeneralization((EClass) c, sc);
					}
				}
			}
		}
		
		Set<EReference> processedOpposites = new HashSet<>();
		for (EClassifier c: allClassifiers) {
			if (c instanceof EClass) {
				for (EReference ref: ((EClass) c).getEReferences()) {
					if (!processedOpposites.contains(ref) && allClassifiers.contains(ref.getEReferenceType())) {
						append(ref);
						EReference opposite = ref.getEOpposite();
						if (opposite!=null) {
							processedOpposites.add(opposite);
						}
					} 
				}
			}
		}
		
		
	}
	
	protected static String getMultiplicity(EStructuralFeature feature) {
		if (feature.isMany()) {
			int lowerBound = feature.getLowerBound();
			int upperBound = feature.getUpperBound();
			if (lowerBound == upperBound) {
				return String.valueOf(lowerBound);
			}
			if (lowerBound==0 && upperBound==-1) {
				return "*";
			}
			return String.valueOf(lowerBound)+".."+upperBound;
		}
		
		return "";
	}	
	
	protected void append(EReference ref) throws IOException {
		collector.append(qualifiedName(ref.getEContainingClass()));
		collector.append(" ");
		EReference opposite = ref.getEOpposite();
		if (ref.isContainment()) {
			collector.append("*");
		} else if (opposite!=null) {
			collector.append("\"");
			collector.append(opposite.getName());			
			String multiplicity = getMultiplicity(opposite);
			if (!multiplicity.isEmpty()) {
				collector.append("["+multiplicity+"]");
			}
			collector.append("\" ");
		}
		
		if (opposite == null) {
			collector.append(ASSOCIATION_RELATION);
		} else {
			collector.append(RELATION_LINE);
			if (opposite.isContainment()) {
				collector.append("*");
			}
		}		
		collector.append(" ");
		
		String multiplicity = getMultiplicity(ref);
		if (opposite == null) {
			if (!multiplicity.isEmpty()) {
				collector
					.append("\"")
					.append(multiplicity)
					.append("\" ");						
			}
		} else {
			collector.append("\"");
			collector.append(ref.getName());			
			if (!multiplicity.isEmpty()) {
				collector.append("["+multiplicity+"]");
			}
			collector.append("\" ");			
		}		
		
		collector.append(qualifiedName(ref.getEReferenceType()));		
		
		if (opposite == null) {
			collector
				.append(" : ")
				.append(ref.getName());
		}
		
		collector.append(System.lineSeparator());
	}
	
	/**
	 * In situations where subtypes of a given type are know this method can be overridden. 
	 * @return
	 */
	protected Iterable<EClass> getSubTypes(EClass eClass) {
		return Collections.emptySet();
	}
	
	public void append(EClassifier eClassifier) throws IOException {
		append(eClassifier, null);
	}
	
	public void append(EClassifier eClassifier, String background) throws IOException {
		if (eClassifier instanceof EClass) {
			append((EClass) eClassifier, background);
		} else if (eClassifier instanceof EEnum) {
			append((EEnum) eClassifier, background);			
		} else if (eClassifier instanceof EDataType) {
			append((EDataType) eClassifier, background);
		}
	}
	
	protected static String qualifiedName(EClassifier eClassifier) {
		EPackage ePackage = eClassifier.getEPackage();
		return "\""+ePackage.getName()+" ("+ePackage.getNsURI()+")."+eClassifier.getName()+"\"";
	}
	
	public void append(EClass eClass) throws IOException {
		append(eClass, null);
	}
	
	public void append(EClass eClass, String background) throws IOException {
		// TODO - Generics
		String modifiers = eClass.isAbstract() && !eClass.isInterface() ? "abstract" : null;
		appendClassStart(modifiers, eClass.isInterface() ? "interface" : "class", qualifiedName(eClass)+(background==null ? "" : " "+background));
		for (EAttribute attribute: eClass.getEAttributes()) {			
			EClassifier eType = attribute.getEType();
			if (eType != null) {
				appendAttribute(null, null, getTypeName(eType), attribute.getName());
			}						
		}
		for (EOperation op : eClass.getEOperations()) {
			Collection<String> parameters = new ArrayList<String>();
			for (EParameter parameter : op.getEParameters()) {
				String paramString = parameter.getName();
				if (parameter.getEType() != null) {
					paramString = parameter.getEType().getName() + " " + paramString;
				}
				parameters.add(paramString);
			}
			appendOperation(null, null, getTypeName(op.getEType()), op.getName(), parameters);
		}
		appendClassEnd();
	}

	public void append(EDataType dataType) throws IOException {
		append(dataType, null);
	}	
	
	public void append(EDataType dataType, String background) throws IOException {
		appendClassStart(null, "class", qualifiedName(dataType)+" << (D,orchid) >>"+(background==null ? "" : " "+background));
		if (dataType.getInstanceClassName() != null) {
			appendAttribute(null, null, null, dataType.getInstanceClassName());
		}
		appendClassEnd();
	}

	public void append(EEnum eEnum) throws IOException {
		append(eEnum, null);
	}
	
	public void append(EEnum eEnum, String background) throws IOException {
		appendClassStart(null, "enum", qualifiedName(eEnum)+(background==null ? "" : " "+background));
		for (EEnumLiteral literal : eEnum.getELiterals()) {
			appendAttribute(null, null, literal.getName(), literal.getLiteral());
		}
		appendClassEnd();
	}

	protected String getTypeName(EClassifier type) {
		String typeName = null;
		if (type != null) {
			if (type instanceof EDataType) {
				typeName = type.getInstanceClassName();
			}
			if (typeName == null) {
				typeName = type.getName();
			}
		}
		return getSimpleName(typeName);
	}
	
	public void appendStartUml() throws IOException {
		collector.append("@startuml").append(System.lineSeparator());
	}
	
	public void appendEndUml() throws IOException {
		collector.append("@enduml").append(System.lineSeparator());
	}
	
}
