/*******************************************************************************
 * Copyright (c) 2010, 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 ******************************************************************************/
/*
 * This code was copied from //https://github.com/eclipse/eclipse.platform.ui/tree/master/bundles/org.eclipse.e4.emf.xpath/src/org/eclipse/e4/emf/internal/xpath
 * to provide support of parent navigation in CDOObject pointers. 
 * Contributor: Pavel Vlasov <Pavel.Vlasov@nasdanika.org>
 */
package org.nasdanika.cdo.xpath;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class JXPathCDOObjectInfo {
	private final EClass eClass;

	public JXPathCDOObjectInfo(EClass eClass) {
		this.eClass = eClass;
	}

	public EStructuralFeature[] getPropertyDescriptors() {
		return eClass.getEAllStructuralFeatures().toArray(new EStructuralFeature[0]);
	}

	public EStructuralFeature getPropertyDescriptor(String propertyName) {
		return eClass.getEStructuralFeature(propertyName);
	}

	public boolean isAtomic() {
		return false;
	}
}
