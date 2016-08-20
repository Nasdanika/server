package org.nasdanika.cdo.web.doc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Collects inbound dependencies from EReferences of objects in the same resource set.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public class EObjectInDependencyTracer extends DependencyTracer<EObject> {

	@SuppressWarnings("unchecked")
	@Override
	protected Iterable<EObject> getDependencies(EObject obj) {
		Set<EObject> ret = new HashSet<>();
		if (obj!=null) {
			TreeIterator<Notifier> tit = obj.eResource().getResourceSet().getAllContents();
			while (tit.hasNext()) {
				Notifier next = tit.next();
				if (next instanceof EObject) {
					EObject nextEObject = (EObject) next;
					for (EReference ref: nextEObject.eClass().getEAllReferences()) {
						if (trace(ref)) {
							Object rv = nextEObject.eGet(ref);
							if (rv != null) {
								if (ref.isMany()) {
									if (((Collection<EObject>) rv).contains(obj)) {
										onDependency(nextEObject, obj, ref);
										ret.add(nextEObject);
									}
								} else if (rv == obj) {
									onDependency(nextEObject, obj, ref);
									ret.add(nextEObject);
								}
							}
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
