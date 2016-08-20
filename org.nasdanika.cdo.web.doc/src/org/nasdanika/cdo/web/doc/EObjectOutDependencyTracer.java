package org.nasdanika.cdo.web.doc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Collects outbound dependencies from EReferences.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public class EObjectOutDependencyTracer extends DependencyTracer<EObject> {

	@SuppressWarnings("unchecked")
	@Override
	protected Iterable<EObject> getDependencies(EObject obj) {
		Set<EObject> ret = new HashSet<>();
		if (obj!=null) {
			for (EReference ref: obj.eClass().getEAllReferences()) {
				if (trace(ref)) {
					Object rv = obj.eGet(ref);
					if (rv != null) {
						if (ref.isMany()) {
							for (EObject rve: (Collection<EObject>) rv) {
								onDependency(obj, rve, ref);
								ret.add(rve);
							}
						} else {
							onDependency(obj, (EObject) rv, ref);
							ret.add((EObject) rv);
						}
					}
				}
			}
		}
		return ret;
	}
	
	/**
	 * @param source
	 * @param target
	 * @param ref
	 */
	protected void onDependency(EObject source, EObject target, EReference ref) {
		
	}
	
	/**
	 * Subclasses can override this method to selectively 
	 * trace references. This implementation returns true.
	 * @param ref
	 * @return true if a given reference shall be traced. 
	 */
	protected boolean trace(EReference ref) {
		return true;
	}

}
