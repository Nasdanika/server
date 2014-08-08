package org.nasdanika.webtest;

/**
 * This interface shall be implemented and exposed by 
 * collector service components.
 * @author Pavel Vlasov
 *
 */
public interface CollectorFactory {

	Collector createCollector();
	
}
