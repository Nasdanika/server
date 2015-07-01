package org.nasdanika.cdo.web.routes;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.json.JSONArray;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;

public class EReferenceClosureJsonExtensionRoute implements Route {

	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
		@SuppressWarnings("unchecked")
		EReferenceClosure<CDOObject> refClosure = (EReferenceClosure<CDOObject>) context.getTarget();
		
		CDOLock readLock = refClosure.getObject().cdoReadLock();
		if (readLock.tryLock(15, TimeUnit.SECONDS)) {
			try {
				if (refClosure.getFeature().isMany()) {
					final JSONArray ret = new JSONArray();
					for (Object e: (Collection<?>) refClosure.getValue()) {
						ret.put(e==null ? null : context.getObjectPath(e));
					}
					
					return new Action() {
	
						@Override
						public Object execute() throws Exception {
							((HttpServletRequestContext) context).getResponse().setContentType("text/json");
							return ret.toString();
						}
	
						@Override
						public void close() throws Exception {
							// NOP.					
						}
						
					};
				} else {
					Object val = refClosure.getValue();
					final String valPath = val==null ? "undefined" : "\""+context.getObjectPath(val)+"\"";
					return new Action() {
						
						@Override
						public Object execute() throws Exception {
							((HttpServletRequestContext) context).getResponse().setContentType("text/json");
							return valPath;
						}
	
						@Override
						public void close() throws Exception {
							// NOP.					
						}
						
					};					
				}
			} finally {
				readLock.unlock();
			}
		} else {			
			return Action.INTERNAL_SERVER_ERROR; // Server overloaded
		}			
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
