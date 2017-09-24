package org.nasdanika.cdo.xpath;

import java.util.Collection;
import java.util.List;

import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;

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
public class EMFFunctions {
	
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
	 * This function can be used to tell new objects from existing objects.
	 * In particular, it can be used in 'editable' conditions to make some features editable or not-editable 
	 * depending on whether the object is new (create form) or existing. An example of it would be user login
	 * or some other unique ID which is not supposed change after object creation. 
	 * @param o
	 * @return
	 */
	public static boolean isTemporary(Object o) {
		return o instanceof CDOObject && ((CDOObject) o).cdoID() != null && ((CDOObject) o).cdoID().isTemporary();
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
