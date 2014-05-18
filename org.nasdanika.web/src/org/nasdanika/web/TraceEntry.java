package org.nasdanika.web;

/**
 * Entry for keeping trace of path hierarchy and building breadcrumbs.
 * @author Pavel
 *
 */
public interface TraceEntry {
	
	String getPath();
	
	String getDisplayName();

}
