package org.nasdanika.web;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.nasdanika.core.Context;

/**
 * Receives WebSocket events in a context.
 * @author Pavel Vlasov
 *
 * @param <C>
 */
public interface ContextWebSocketListener<C extends Context> {

	/**
     * A Close Event was received.
     * <p>
     * The underlying Connection will be considered closed at this point.
     * 
     * @param context invocation context
     * @param statusCode
     *            the close status code. (See {@link StatusCode})
     * @param reason
     *            the optional reason for the close.
     */
    void onWebSocketClose(C context, int statusCode, String reason);

    /**
     * A WebSocket {@link Session} has connected successfully and is ready to be used.
     * <p>
     * Note: It is a good idea to track this session as a field in your object so that you can write messages back via the {@link RemoteEndpoint}
     * 
     * @param context invocation context
     * @param session
     *            the websocket session.
     */
    void onWebSocketConnect(C context, Session session);

    /**
     * A WebSocket exception has occurred.
     * <p>
     * This is a way for the internal implementation to notify of exceptions occured during the processing of websocket.
     * <p>
     * Usually this occurs from bad / malformed incoming packets. (example: bad UTF8 data, frames that are too big, violations of the spec)
     * <p>
     * This will result in the {@link Session} being closed by the implementing side.
     * 
     * @param context invocation context
     * @param cause
     *            the error that occurred.
     */
    void onWebSocketError(C context, Throwable cause);
    
    /**
     * A WebSocket binary frame has been received.
     * 
     * @param context invocation context
     * @param payload
     *            the raw payload array received
     * @param offset
     *            the offset in the payload array where the data starts
     * @param len
     *            the length of bytes in the payload
     */
    void onWebSocketBinary(C context, byte payload[], int offset, int len);

    /**
     * A WebSocket Text frame was received.
     * 
     * @param context invocation context
     * @param message the message
     */
    void onWebSocketText(C context, String message);
    

}
