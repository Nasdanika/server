# WebSockets

## Route Level
The [[javadoc>org.nasdanika.web.AbstractRoutingServlet]] and its subclasses handles web socket creation in the following way:

* An instance of [[javadoc>org.nasdanika.web.HttpServletRequestContext]] is created and dispatched to a matching route as for any other request.
* The context's ``getMethod()`` returns ``CREATE_WEB_SOCKET`` pseudo-method.
* The context's ``getResponse()`` method returns null.
* The context can be adapted to [[javadoc>org.nasdanika.web.WebSocketUpgradeInfo]] to get access the upgrade request, upgrade response, and web socket context provider.

## CDO Routing Servlets
[[javadoc>org.nasdanika.cdo.web.CDOViewRoutingServlet]] creates an instance of [[javadoc>org.nasdanika.cdo.web.CDOViewWebSocketContext]] and
[[javadoc>org.nasdanika.cdo.web.CDOTransactionRoutingServlet]] creates an instance of [[javadoc>org.nasdanika.cdo.web.CDOTransactionWebSocketContext]]. These contexts inherit the principal and target object from the original context. The framework takes take care of attaching them to the web context CDOView and CDOTransaction respectively.

## @RouteMethod annotation, DispatchingRoute, and WebSocket creation methods
@[[javadoc>org.nasdanika.web.RouteMethod]] annotation can be used to annotate WebSocket creator methods. In this case ``consume`` attribute of the annotation is used to specify sub-protocol(s) handled by the method. 

As with other request methods, the method name and method path are implied from the method name if not set explicitly. For example method ``createWebSocketText()`` method would match ``CREATE_WEB_SOCKET`` request pseudo-method and ``test`` path. 

A WebSocket creation method shall return either an instance of ``org.eclipse.jetty.websocket.api.WebSocketListener`` or
an instance of [[javadoc>org.nasdanika.web.ContextWebSocketListener]]. In the latter case the framework takes care of obtaining and closing 
a web socket context. If ``keepWebSocketContext`` @RouteMethod annotation attribute is set to true then a context is kept open for the
whole life of the WebSocket. Otherwise (default) a new web socket context is created for each invocation and is closed after the invocation finishes.   

WebSocket creator methods can use all the parameter annotations available for other route methods, e.g. [[javadoc>org.nasdanika.core.ServiceParameter]] annotation, so web socket listeners can have access to OSGi services.   

Sample ContextWebSocketListener creator method in a dispatch route for a CDOObject:

```java
@RouteMethod
public ContextWebSocketListener<?> createWebSocketTest() {
	return new ContextWebSocketListener<CDOTransactionWebSocketContext<?>>() {

		@Override
		public void onWebSocketClose(CDOTransactionWebSocketContext<?> context, int statusCode, String reason) {
			// TODO 			
		}

		@Override
		public void onWebSocketConnect(CDOTransactionWebSocketContext<?> context, Session session) {
			// TODO
		}

		@Override
		public void onWebSocketError(CDOTransactionWebSocketContext<?> context, Throwable cause) {
			// TODO			
		}

		@Override
		public void onWebSocketBinary(CDOTransactionWebSocketContext<?> context, byte[] payload, int offset, int len) {
			// TODO			
		}

		@Override
		public void onWebSocketText(CDOTransactionWebSocketContext<?> context, String message) {
			// TODO			
		}
	};
}
``` 