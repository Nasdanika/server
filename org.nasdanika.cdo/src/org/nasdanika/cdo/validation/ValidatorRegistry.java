package org.nasdanika.cdo.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.CoreUtil;
import org.osgi.framework.Bundle;

public class ValidatorRegistry {
	
	// TODO - service tracker too.
	
	public static final ValidatorRegistry INSTANCE = new ValidatorRegistry();
	
	public Collection<Validator<EObject>> getValidators(EClass eClass) {
		ArrayList<Validator<EObject>> accumulator = new ArrayList<>();
		synchronized (validators) {
			match(eClass, accumulator, new HashSet<EClass>());
		}
		return accumulator; 
	}
		
	private ExtensionTracker validatorExtensionTracker;
	
	private static final String NAMESPACE_URI_ATTRIBUTE  = "namespace-uri";
	private static final String ECLASS_NAME_ATTRIBUTE  = "eclass-name";
	
	private class ValidatorEntry {
		private Validator<EObject> validator;
		private String namespaceURI;
		private String eClassName;
		
		ValidatorEntry(Validator<EObject> validator, String namespaceURI,	String eClassName) {			
			super();
			this.validator = validator;
			this.namespaceURI = namespaceURI;
			this.eClassName = eClassName;
		}
		
		boolean match(EClass eClass) {
			if (CoreUtil.isBlank(eClassName) || eClass.getName().contentEquals(eClassName)) {
				return eClass.getEPackage().getNsURI().equals(namespaceURI);
			}
			return false;
		}
						
	}
	
	private List<ValidatorEntry> validators = new ArrayList<>();
	
	private ValidatorRegistry() {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		validatorExtensionTracker = new ExtensionTracker(extensionRegistry);
    	IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint("org.nasdanika.cdo.validator");   
    	
    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

    		@Override
    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
    				try {
	    				if ("validator".equals(ce.getName())) {
	    					IContributor contributor = ce.getContributor();
	    					Bundle bundle = Platform.getBundle(contributor.getName());
	    					Class<?> rc = (Class<?>) bundle.loadClass(ce.getAttribute("validator").trim());
	    					// If validator class is interface, then it must have INSTANCE field.
    						@SuppressWarnings("unchecked")
							Validator<EObject> validator = rc.isInterface() ? (Validator<EObject>) rc.getField("INSTANCE").get(null) : (Validator<EObject>) CoreUtil.injectProperties(ce, ce.createExecutableExtension("validator"));
							ValidatorEntry validatorEntry = new ValidatorEntry(
    								validator,
    								ce.getAttribute(NAMESPACE_URI_ATTRIBUTE),
    								ce.getAttribute(ECLASS_NAME_ATTRIBUTE));
    						
	    					synchronized (validators) {
								validators.add(validatorEntry);
	    					}

	    					tracker.registerObject(extension, validatorEntry, IExtensionTracker.REF_WEAK);
	    				}
    				} catch (Exception e) {    					
    					// TODO - proper logging
    					System.err.println("Error adding validator extension");
    					e.printStackTrace();
    				}
    			}
    		}
    		
 			@Override
    		public void removeExtension(IExtension extension, Object[] objects) {
    			synchronized (validators) {
	    			for (Object obj: objects) {
	    				validators.remove(obj);
	    			}
    			}
			}
    		
    	};    	
    	
		validatorExtensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
		for (IExtension ex: extensionPoint.getExtensions()) {
			extensionChangeHandler.addExtension(validatorExtensionTracker, ex);
		}
	}
	
	private void match(EClass eClass, Collection<Validator<EObject>> accumulator, HashSet<EClass> traversed) {
		if (traversed.add(eClass)) {
			for (ValidatorEntry validatorEntry: validators) {
				if (validatorEntry.match(eClass)) {
					accumulator.add(validatorEntry.validator);
				}				
			}
			for (EClass st: eClass.getESuperTypes()) {
				match(st, accumulator, traversed); 
			}
		}		
	}	

}
