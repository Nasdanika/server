package org.nasdanika.webtest;

import java.net.URL;
import java.util.Map;

/**
 * Implementations of this interface publish themselves to a report server.
 * @author Pavel
 *
 */
interface HttpPublisher {
	
	interface PublishMonitor {
		
		void onPublishing(String source, URL target);
		
	}
	
	void publish(
			URL url, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception;
	
	/**
	 * @return Total number of times PublishMonitor.onPublishing() is going to be invoked by this publisher during publish().
	 */
	int publishSize();

}
