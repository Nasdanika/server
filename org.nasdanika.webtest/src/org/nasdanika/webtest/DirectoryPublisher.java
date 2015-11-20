package org.nasdanika.webtest;

import java.util.Map;

/**
 * Implementations of this interface publish themselves to a directory.
 * @author Pavel
 *
 */
interface DirectoryPublisher {
	
	interface DirectoryPublishMonitor {
		
		void onPublishing(String source, String path);
		
	}
	
	/**
	 * Publishes to a directory.
	 * @param directory
	 * @param publishPerformance
	 * @param idMap
	 * @param monitor
	 * @return Publish path.
	 * @throws Exception
	 */
	String publish(
			Directory directory, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			DirectoryPublishMonitor monitor) throws Exception;
	
	/**
	 * @return Total number of times PublishMonitor.onPublishing() is going to be invoked by this publisher during publish().
	 */
	int publishSize();

}
