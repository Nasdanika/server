package org.nasdanika.webtest;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.Boxer;
import org.nasdanika.core.Context;

/**
 * Default boxer uses {@link BoxUtil}.box() method
 * @author Pavel Vlasov
 *
 */
public class DefaultArgumentBoxer implements Boxer {

	@Override
	public EObject box(Object obj, Context context) {
		return BoxUtil.box(obj, context);
	}

}
