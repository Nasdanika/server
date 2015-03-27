package org.nasdanika.cdo.boxing;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

public class BoxUtil {

	private BoxUtil() {
		// Singleton
	}

	public static <T> CDOObject box(T obj, Context context) {
		if (obj instanceof CDOObject) {
			CDOObject cdoObj = (CDOObject) obj;
			if (cdoObj.eContainer()==null) {
				return cdoObj;
			}
			
			ReferenceBox rBox = BoxingFactory.eINSTANCE.createReferenceBox();
			rBox.setTarget(cdoObj);
			return rBox;		
		} 
		
		if (obj==null) {
			return BoxingFactory.eINSTANCE.createNullBox();
		}
		
		try {
			CDOObject cdoObj = context.adapt(ConverterContext.class).convert(obj, CDOObject.class);
			if (cdoObj==null) {
				throw new BoxingException("Cannot convert "+obj+" to CDOObject");
			}
			return cdoObj;
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
