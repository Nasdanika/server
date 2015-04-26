package org.nasdanika.cdo.sca;


public interface ServiceReference<T> extends AutoCloseable {
	T getService();
}
