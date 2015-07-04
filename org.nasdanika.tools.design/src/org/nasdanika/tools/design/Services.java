package org.nasdanika.tools.design;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Services {
	
    public EObject getRootContainer(EObject eObject) {
        return EcoreUtil.getRootContainer(eObject);
    }
	

}