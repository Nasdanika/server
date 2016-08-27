package org.nasdanika.cdo.boxing;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

public interface Boxer {
	
	EObject box(Object obj, Context context);	

}
