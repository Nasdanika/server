/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - adjustment to EObject
 ******************************************************************************/
/*
 * This code was copied from //https://github.com/eclipse/eclipse.platform.ui/tree/master/bundles/org.eclipse.e4.emf.xpath/src/org/eclipse/e4/emf/internal/xpath
 * to provide support of parent navigation in CDOObject pointers. 
 * Contributor: Pavel Vlasov <Pavel.Vlasov@nasdanika.org>
 */
package org.nasdanika.cdo.xpath;

import java.util.Locale;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.eclipse.emf.cdo.CDOObject;

/**
 * Implements NodePointerFactory for {@link CDOObject}.
 *
 */
public class CDOObjectPointerFactory implements NodePointerFactory {

	/**
	 * Evaluate before the bean factory.
	 */
	@Override
	public int getOrder() {
		return BeanPointerFactory.BEAN_POINTER_FACTORY_ORDER - 100;
	}

    @Override
	public NodePointer createNodePointer(QName name, Object bean, Locale locale) {
        if (bean instanceof CDOObject) {    	
	        JXPathCDOObjectInfo bi = new JXPathCDOObjectInfo(((CDOObject)bean).eClass());
	        return new EObjectPointer(name, bean, bi, locale);
        }
        return null;
    }

    @Override
	public NodePointer createNodePointer(NodePointer parent, QName name, Object bean) {
        if (bean == null) {
            return new NullPointer(parent, name);
        }

        if (bean instanceof CDOObject) {
	        JXPathCDOObjectInfo bi = new JXPathCDOObjectInfo(((CDOObject)bean).eClass());
	        return new EObjectPointer(parent, name, bean, bi);
        }
        return null;
    }
}

