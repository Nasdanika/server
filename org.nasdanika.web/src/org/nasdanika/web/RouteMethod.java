package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * This annotation tells router to wrap object method into a route.
 * ActionMethod may take HttpServletRequestContext parameter. If method returns value, this value is written to response. 
 * @author Pavel
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RouteMethod {
	
	/**
	 * Supported HTTP methods. 
	 * @return
	 */
	RequestMethod[] value() default {};
	
	/**
	 * Pattern to match path. If not set then method
	 * is matched if path's second elements equals to method name.
	 * @return
	 */
	String pattern() default "";
	
	/**
	 * Route method path. Takes precedence over pattern. May contain path parameter specs, e.g. <code>{something}</code>
	 * When neither path nor pattern nor request method is specified then method name is split by camel-case and the first element
	 * is treated as request method and remaining lowercased elements as path with the last path element treated as extension for the GET method, if there is more than one path element. E.g. <code>getTransactions</code> would be treated as GET for <code>transactions</code> path,
	 * <code>getTransactionsListHtml</code> would be treated as GET for <code>transactions/list.html</code> path.
	 * If the first element does not correspond to an HTTP request method or a request method is specified, then method name is treated as path. If request method is not specified, then any method matches.  
	 * @return
	 */
	String path() default "";
	
	/**
	 * Priority in matching, use it for overlapping patterns. Defaults to 0.
	 * @return
	 */
	int priority() default 0;
	
	/**
	 * Response content type produced by the method. Used for route matching and for setting response content type if not set by the method.
	 * If this attribute is not set then it is implied from the path's extension.
	 * @return
	 */
	String produces() default "";
	
	/**
	 * Content types which this method can consume. Used for matching the method to request. Empty array matches any content type.
	 * for <code>CREATE_WEB_SOCKET</code> {@link RequestMethod} this attribute matches sub-protocols.
	 * @return
	 */
	String[] consumes() default {};
	
	/**
	 * Applicable only to web socket creation methods. 
	 * @return If true, web socket context is created before invocation of {@link ContextWebSocketListener}.<code>onWebSocketConnect()</code> method and is
	 * kept open until after invocation of <code>onWebSocketClose()</code> method. Otherwise a new context is created before each onXXX method invocation
	 * and closed after the invocation. 
	 */
	boolean keepWebSocketContext() default false;
	
	/**
	 * Authorization action. If not set, the request method name is used, e.g. GET.
	 * @return
	 */
	String action() default "";
	
	/**
	 * Authorization qualifier. If not set, the route method name is used.
	 * @return
	 */
	String qualifier() default "";
		
	/**
	 * Comment to be shown in the dynamically generated API documentation.
	 * @return
	 */
	String comment() default "";	

	/**
	 * Defines locking to apply when executing route method.
	 * @author Pavel Vlasov
	 *
	 */
	@interface Lock {
		
		/**
		 * Lock to apply to the context object of the route method before executing the method.
		 * @author Pavel Vlasov
		 *
		 */
		enum Type { 
			/**
			 * No locking.
			 */
			NONE, 
			/**
			 * Read lock.
			 */
			READ, 
			/**
			 * Write lock.
			 */
			WRITE,
			
			/**
			 * Lock type is implied from the request method. WRITE for PUT, POST, PATCH, and DELETE, READ otherwise.
			 */
			IMPLY_FROM_HTTP_METHOD
		}
		
		/**
		 * Lock to apply to the context object of the route method before executing the route method.
		 * @return
		 */
		Type type() default Type.IMPLY_FROM_HTTP_METHOD;
		
		/**
		 * Lock timeout in milliseconds, 0 means infinite.
		 * @return
		 */
		long timeout() default 1;
		
		TimeUnit timeUnit() default TimeUnit.MINUTES; 
		
		/**
		 * [JXPath](https://commons.apache.org/proper/commons-jxpath/) path
		 * of the object to apply the lock to.
		 * @return
		 */
		String path() default "";
		
	}
	
	Lock lock() default @Lock();

}
