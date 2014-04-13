package org.nasdanika.web;

import org.eclipse.jetty.websocket.WebSocket.Connection;


public interface WebSocketContext extends WebContext {

	Connection getConnection();
	
}
