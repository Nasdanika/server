package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.List;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.xpath.CDOObjectPointerFactory;
import org.nasdanika.cdo.xpath.EMFFunctions;

/**
 * Utility class for the {@link Renderer}
 * @author Pavel
 *
 */
public class RenderUtil {
	
	static {
		JXPathContextReferenceImpl.addNodePointerFactory(new CDOObjectPointerFactory());
	}	
		
	// Utility class, no instances.
	private RenderUtil() {
		throw new UnsupportedOperationException();
	}
	
	public static String getRenderAnnotation(String renderAnnotationSource, EClass eClass, String key) {		
		EAnnotation ra = eClass.getEAnnotation(renderAnnotationSource);
		if (ra != null) {
			String value = ra.getDetails().get(key);
			if (value != null) {
				return value;
			}
		}
		for (EClass st: eClass.getESuperTypes()) {
			String raStr = getRenderAnnotation(renderAnnotationSource, st, key);
			if (raStr != null) {
				return raStr;
			}
		}
		return null;
	}
		
	/**
	 * Creates a new {@link JXPathContext} with the object as context object and context as ``context`` variable, 
	 * root object as ``root`` variable, the context node as ``this`` variable, and {@link EMFFunctions} as functions.
	 * @param context
	 * @param obj
	 * @return
	 */
	public static JXPathContext newJXPathContext(Object context, CDOObject obj) {
		JXPathContext jxPathContext = JXPathContext.newContext(obj);
		jxPathContext.setLenient(true);
		Variables variables = jxPathContext.getVariables();
		if (context != null) {
			variables.declareVariable("context", context);
		}
		
		variables.declareVariable("this", obj);
		CDOObject root = obj;
		while (root.eContainer() instanceof CDOObject) {
			root = (CDOObject) root.eContainer();
		}
		variables.declareVariable("root", root);
		
		jxPathContext.setFunctions(new ClassFunctions(EMFFunctions.class, "ecore"));
		return jxPathContext;
	}

}
