package org.nasdanika.cdo.web.routes.app;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
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

}
