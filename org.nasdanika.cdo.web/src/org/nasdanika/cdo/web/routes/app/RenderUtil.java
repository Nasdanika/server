package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
	 * The initial version of this class was copied from https://github.com/eclipse/eclipse.platform.ui/blob/master/bundles/org.eclipse.e4.emf.xpath/src/org/eclipse/e4/emf/internal/xpath/JXPathContextImpl.java,
	 * The original copyright notice is below;
	 */
	/*******************************************************************************
	 * Copyright (c) 2010, 2015 BestSolution.at and others.
	 * All rights reserved. This program and the accompanying materials
	 * are made available under the terms of the Eclipse Public License v1.0
	 * which accompanies this distribution, and is available at
	 * http://www.eclipse.org/legal/epl-v10.html
	 *
	 * Contributors:
	 *     Tom Schindl <tom.schindl@bestsolution.at> - adjustment to EObject
	 ******************************************************************************/
	public static class EMFFunctions {
		
		/**
		 * The original method.
		 * @param o
		 * @return
		 */
		public static String eClassName(Object o) {
			if( o instanceof Collection<?> ) {
				if( ! ((Collection<?>) o).isEmpty() ) {
					return eClassName(((Collection<?>) o).iterator().next());
				}
			} else if( o instanceof EObject ) {
				return ((EObject) o).eClass().getName();
			} else if( o instanceof NodeSet ) {
				List<?> l = ((NodeSet) o).getValues();
				if( l.size() > 0 && l.get(0) instanceof EObject ) {
					return eClassName(l.get(0));
				}
			} else if( o instanceof Pointer ) {
				if( ((Pointer) o).getValue() instanceof EObject ) {
					return eClassName(((Pointer) o).getValue());
				}
			}

			return null;
		}
		
		public static Object iif(boolean condition, Object ifTrue, Object ifFalse) {
			return condition ? ifTrue : ifFalse;
		}
				
		/**
		 * Expression context method.
		 * @param expressionContext
		 * @return
		 */
		public static String eClassName(ExpressionContext expressionContext) {
			Pointer cnp = expressionContext.getContextNodePointer();
			if (cnp != null) {
				Object node = cnp.getNode();
				if (node instanceof EObject) {
					return ((EObject) node).eClass().getName();
				}
			}

			return null;
		}
		
		/**
		 * For checking boolean attributes.  
		 * @return
		 */
		public static boolean isTrue(Object obj) {
			if (obj instanceof Collection) {
				for (Object e: (Collection<?>) obj) {
					if (isFalse(e)) {
						return false;
					}
				}
				return true;
			}
			return Boolean.TRUE.equals(obj);
		}		
		
		/**
		 * For checking boolean attributes.  
		 * @return
		 */
		public static boolean isFalse(Object obj) {
			return !isTrue(obj);
		}		
		
		/**
		 * Expression context method.
		 * @param expressionContext
		 * @return
		 */
		public static String ePackageNsURI(ExpressionContext expressionContext) {
			Pointer cnp = expressionContext.getContextNodePointer();
			if (cnp != null) {
				Object node = cnp.getNode();
				if (node instanceof EObject) {
					return ((EObject) node).eClass().getEPackage().getNsURI();
				}
			}

			return null;
		}		
		
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
