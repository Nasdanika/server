package org.nasdanika.web;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.nasdanika.core.ContextProvider;

/**
 * This interface provides context information
 * for web socket creation. Routes creating web sockets shall adapt {@link HttpServletRequestContext} to this interface
 * in order to get access to {@link ServletUpgradeRequest}, {@link ServletUpgradeResponse}, and {@link ContextProvider}. 
 * @author Pavel Vlasov
 *
 */
public interface WebSocketUpgradeInfo {
	
	ServletUpgradeRequest getUpgradeRequest();
	
	ServletUpgradeResponse getUpgradeResponse();
	
	ContextProvider<?> getContextProvider(HttpServletRequestContext context) throws Exception;

}
