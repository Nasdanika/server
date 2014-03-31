package org.nasdanika.examples.bank;

import java.math.BigDecimal;

public interface PaymentProcessor extends AutoCloseable {
	
	/**
	 * @return Unique ID of the payment processor.
	 */
	String getId();
	
	/**
	 * Records funds transfer with the external
	 * payment processor.
	 * @param type Debit - external account is debited, Credit - external account
	 * is credited.
	 * @param internalAccount ID of internal account. 
	 * @param externalAccount ID of external account.
	 * @param amount Transfer amount.
	 * @param id ID of internal transaction.
	 * @param comment Comment 
	 * @return ID of external transaction.
	 */
	String transfer(
			TransactionType type, 
			String internalAccount, 
			String externalAccount,
			BigDecimal amount,
			String id, 
			String comment);
	
}
