package org.nasdanika.webtest;

/**
 * Abstraction of a storage used by directory publishers - a file system, a zip file, an FTP directory, etc.
 * @author Pavel Vlasov
 *
 */
public interface Directory {
	
	/**
	 * Stores content under the specified path in the directory.
	 * @param content Content to store. It can be a char sequence, a byte array, a Reader, an InputStream, JSONObject, JSONArray, File, or a URL. 
	 * @param path Path to store content under.
	 */
	void store(Object content, String path);

}
