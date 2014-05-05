package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Wrapper for structural feature and object for associating routes with features.
 * @author Pavel
 *
 * @param <O>
 * @param <F>
 */
public interface EStructuralFeatureClosure<O extends EObject, F extends EStructuralFeature> {
	
	O getObject();
	
	F getFeature();

}
