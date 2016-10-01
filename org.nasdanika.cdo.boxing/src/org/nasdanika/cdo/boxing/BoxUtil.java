package org.nasdanika.cdo.boxing;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

public class BoxUtil {
	
	public static final Boxer BOXER = (obj, context) -> BoxUtil.box(obj, context); 

	private BoxUtil() {
		// Singleton
	}

	public static EObject box(Object obj, Context context) {
		if (obj instanceof EObject) {
			EObject eObj = (EObject) obj;
			if (eObj.eContainer()==null) {
				return eObj;
			}
			
			ReferenceBox rBox = BoxingFactory.eINSTANCE.createReferenceBox();
			rBox.setTarget(eObj);
			return rBox;		
		} 
		
		if (obj==null) {
			return BoxingFactory.eINSTANCE.createNullBox();
		}
		
		try {
			EObject eObj = context.convert(obj, EObject.class);
			if (eObj==null) {
				throw new BoxingException("Cannot convert "+obj+" to EObject");
			}
			return eObj;
		} catch (BoxingException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new BoxingException(ex);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object unbox(Object obj, Context context) {
		return obj instanceof Box ? ((Box) obj).get(context) : obj;
	}

}
