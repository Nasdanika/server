package org.nasdanika.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.json.JSONObject;

// --- Not functional yet - more like a skeleton for further implementation ---

/**
 * Exposes routing logic through web socket.
 * @author Pavel Vlasov
 * 
 */
@SuppressWarnings("serial")
public class WebSocketRoutingServlet extends WebSocketServlet {

	private ExtensionManager extensionManager = new ExtensionManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		getServletContext().getNamedDispatcher("default").forward(request,response);    
	}

    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
    	try {
			return new RoutingWebSocket(request, protocol);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
	
	private class RoutingWebSocket implements WebSocket.OnTextMessage {
		
		private Connection connection;
		private WebSocketContext context;

		public RoutingWebSocket(HttpServletRequest request, String protocol) {
			// TODO - use request and protocol to create context.
		}

		@Override
		public void onOpen(Connection connection) {
			this.connection = connection;
		}

		@Override
		public void onClose(int closeCode, String message) {
			// TODO - close context
		}
		
		private static final String DATA_KEY = "Data";
		private static final String METHOD_KEY = "Method";
		private static final String MESSAGE_ID_KEY = "MessageID";
		private static final String ERROR_KEY = "Error";		
		private static final String COMMAND_KEY = "Command";

		@Override
		public void onMessage(String message) {
			try {
				JSONObject reply = new JSONObject();
				try {
					JSONObject request = new JSONObject(message);
					if (request.has(MESSAGE_ID_KEY)) {
						reply.put("CorrelationID", request.get(MESSAGE_ID_KEY));
					}
					if (request.has(METHOD_KEY)) {
						RequestMethod method = RequestMethod.valueOf(request.getString(METHOD_KEY));
						if (request.has(COMMAND_KEY)) {
							String[] command = request.getString(COMMAND_KEY).split("/");
							Object data = request.has(DATA_KEY) ? request.get(DATA_KEY) : null; 
							// TODO - message context based on connection context.
							boolean found = false;
							for (Route route: extensionManager.getRouteRegistry().matchRootRoutes(method, command)) {
								try (Action action = route.navigate(context)) {
									if (action!=null) {
										
										Object replyData = action.execute();
										if (replyData!=null) {
											reply.put(DATA_KEY, replyData);									
										}
										found = true;								
									}
								}
							} 
							if (!found) {
								reply.put(ERROR_KEY, "Invalid method/command");							
							}
						} else {
							reply.put(ERROR_KEY, "Command not defined");
						}
					} else {
						reply.put(ERROR_KEY, "Method not defined");
					}
				} catch (Exception e) {
					reply.put(ERROR_KEY, e.toString());
					// TODO - context handles error, e.g. rolls back transaction.
				}
				connection.sendMessage(reply.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
