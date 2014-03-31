package org.nasdanika.examples.bank;

public interface PaymentProcessorProvider {
	
	PaymentProcessor getPaymentProcessor() throws Exception;

}
