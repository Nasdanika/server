package org.nasdanika.cdo.web.routes;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EOperationClosureRoute implements Route {
	
	private static Map<String, Class<?>> primitivesToBoxesMap = new HashMap<>();
	
	static {
		primitivesToBoxesMap.put("byte", Byte.class);
		primitivesToBoxesMap.put("short", Short.class);
		primitivesToBoxesMap.put("int", Integer.class);
		primitivesToBoxesMap.put("long", Long.class);
		primitivesToBoxesMap.put("float", Float.class);
		primitivesToBoxesMap.put("double", Double.class);
		primitivesToBoxesMap.put("boolean", Boolean.class);
		primitivesToBoxesMap.put("char", char.class);
	}	

	@Override
	public Action execute(final WebContext context) throws Exception {
		final EOperationClosure<?> eOperationClosure = (EOperationClosure<?>) context.getTarget();		
		EOperation op = eOperationClosure.getOperation();
		// TODO - if path length is 1, method is POST and request content type is json -> unmarshal/invoke/marshal 
		if (context.getPath().length-1<op.getEParameters().size()) {
			return Action.NOT_FOUND; // Path is shorter than a number of parameters.
		}
		if (!context.authorize(eOperationClosure, "invoke", null, null)) {
			return Action.FORBIDDEN;
		}
		EList<Object> args = ECollections.newBasicEList();
		int idx = 1;		
		for (EParameter p: op.getEParameters()) {
			String icn = p.getEType().getInstanceClassName();
			if (icn==null || "java.lang.String".equals(icn)) {
				args.add(context.getPath()[idx++]);
			} else {
				Class<?> pType = primitivesToBoxesMap.get(icn);
				if (pType==null) {
					pType = context.loadClass(icn);
				}
				args.add(context.convert(context.getPath()[idx++], pType));
			}
		}
		final Object result = eOperationClosure.invoke(args);
		if (idx<context.getPath().length) {
			if (result==null) {
				return Action.NOT_FOUND;
			}
			return context.getAction(result, idx);
		}
		
		return new Action() {

			@Override
			public void close() throws Exception {
				// NOP				
			}

			@Override
			public Object execute() throws Exception {
				return result;
			}
		};
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
		
	}

}
