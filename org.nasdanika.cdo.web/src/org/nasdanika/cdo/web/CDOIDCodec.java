package org.nasdanika.cdo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.nasdanika.core.Context;
import org.nasdanika.web.HttpServletRequestContext;

/**
 * Encodes/decodes CDOID to use it in URL's.
 * The framework looks for a codec instance in the session, then in the application context, and then uses the default instance.
 * Application may inject custom codecs into session or application context to obfuscate or encrypt CDOID's in order to address "Direct Object Reference" vulnerability. 
 * @author Pavel
 *
 */
public interface CDOIDCodec {
	
	/**
	 * This codec tries to adapte the context to {@link CDOIDCodec}, then it looks for attribute under ``org.nasdanika.cdo.web.CDOIDCodec`` key in session, 
	 * then in the application contexts, and then invokes super implementations. 
	 */
	CDOIDCodec INSTANCE = new CDOIDCodec() {
		
		private CDOIDCodec getContextInstance(Context context) throws Exception {
			Object instance = context.adapt(CDOIDCodec.class);
			if (instance instanceof CDOIDCodec) {
				return (CDOIDCodec) instance;
			}
			
			if (context instanceof HttpServletRequestContext) {
				HttpServletRequest request = ((HttpServletRequestContext) context).getRequest();
				HttpSession session = request.getSession(false);
				if (session != null) {
					instance = session.getAttribute(CDOIDCodec.class.getName());
					if (instance instanceof CDOIDCodec) {
						return (CDOIDCodec) instance;
					}
				}
				instance = request.getServletContext().getAttribute(CDOIDCodec.class.getName());
				if (instance instanceof CDOIDCodec) {
					return (CDOIDCodec) instance;
				}
			}
			return null;
		}
		
		@Override
		public CDOID decode(Context context, String idStr) throws Exception {
			Object instance = getContextInstance(context);
			if (instance instanceof CDOIDCodec) {
				return ((CDOIDCodec) instance).decode(context, idStr);
			}
			return CDOIDCodec.super.decode(context, idStr);
		}
		
		@Override
		public String encode(Context context, CDOID cdoID) throws Exception {
			Object instance = getContextInstance(context);
			if (instance instanceof CDOIDCodec) {
				return ((CDOIDCodec) instance).encode(context, cdoID);
			}
			return CDOIDCodec.super.encode(context, cdoID);
		}
		
	};
	
	default String encode(Context context, CDOID cdoID) throws Exception {
		StringBuilder builder = new StringBuilder();
		CDOIDUtil.write(builder, cdoID);
		return builder.toString();
	}
	
	default CDOID decode(Context context, String idStr) throws Exception {
		return CDOIDUtil.read(idStr);
	}

}
