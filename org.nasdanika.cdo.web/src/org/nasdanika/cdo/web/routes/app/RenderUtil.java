package org.nasdanika.cdo.web.routes.app;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.xpath.CDOObjectPointerFactory;

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
	 * Creates a new {@link JXPathContext} with the object as context object and context as ``context`` variable and
	 * root object as ``root`` variable.
	 * @param context
	 * @param obj
	 * @return
	 */
	public static JXPathContext newJXPathContext(Object context, CDOObject obj) {
		JXPathContext jxPathContext = JXPathContext.newContext(obj);
		jxPathContext.setLenient(true);
		if (context != null) {
			jxPathContext.getVariables().declareVariable("context", context);
		}
		CDOObject root = obj;
		while (root.eContainer() instanceof CDOObject) {
			root = (CDOObject) root.eContainer();
		}
		jxPathContext.getVariables().declareVariable("root", root);
		
		// Functions, e.g. eClassName()?
		return jxPathContext;
	}

}
