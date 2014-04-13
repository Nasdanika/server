package org.nasdanika.examples.bank.app;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Random;

import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.nasdanika.cdo.CDOSessionInitializer;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.CreditCard;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.PaymentProcessor;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.examples.bank.TransactionType;

public class CreditCardsSessionInitializerComponent implements CDOSessionInitializer {
	
	private Random random = new Random(System.currentTimeMillis()+hashCode());
	
	@Override
	public void init(CDOSession session) {
		CDOPackageRegistry packageRegistry = session.getPackageRegistry();
		packageRegistry.putEPackage(BankPackage.eINSTANCE);
		
		// Populate with sample data if empty.
		CDOTransaction transaction = session.openTransaction();
				
		try {
			CDOResource cRes = transaction.getOrCreateResource("/bank");
			if (cRes.getContents().isEmpty()) {
				SystemOfRecords sor = BankFactory.eINSTANCE.createSystemOfRecords();
				sor.setId("cdo-repo");
				sor.setName("Nasdanika Bank");
				sor.setDescription("CDO repository is a system of records for Nasdanika Bank");
				cRes.getContents().add(sor);
				
				// Products
				Product simplicity = BankFactory.eINSTANCE.createProduct();
				simplicity.setName("Serenity");
				sor.getProducts().add(simplicity);
				
				Product thankYou = BankFactory.eINSTANCE.createProduct();
				thankYou.setName("Serendipity");
				sor.getProducts().add(thankYou);
								
				Product diamond = BankFactory.eINSTANCE.createProduct();
				sor.getProducts().add(diamond);
				
				PaymentProcessor visa = new PaymentProcessor() {
					
					@Override
					public void close() throws Exception {
						// NOP
						
					}
					
					private long counter;
					
					@Override
					public String transfer(
							TransactionType type, 
							String internalAccount,
							String externalAccount, 
							BigDecimal amount, 
							String id, 
							String comment) {
						
						return getId()+"/"+Long.toString(System.currentTimeMillis(), Character.MAX_RADIX)+"-"+Long.toString(++counter, Character.MAX_RADIX);
					}
					
					@Override
					public String getId() {
						return "Visa";
					}
				};
				
				PaymentProcessor ach = new PaymentProcessor() {
					
					@Override
					public void close() throws Exception {
						// NOP
						
					}
					
					private long counter;
					
					@Override
					public String transfer(
							TransactionType type, 
							String internalAccount,
							String externalAccount, 
							BigDecimal amount, 
							String id, 
							String comment) {
						
						return getId()+"/"+Long.toString(System.currentTimeMillis(), Character.MAX_RADIX)+"-"+Long.toString(++counter, Character.MAX_RADIX);
					}
					
					@Override
					public String getId() {
						return "ACH";
					}
				};
				// Customers				
				createCustomer(sor, "John Doe", "johnDoe", visa, ach, simplicity, thankYou);
				createCustomer(sor, "Jane Doe", "janeDoe", visa, ach, thankYou, diamond);
				
				System.out.println("Bank model generated");
			}
			
			transaction.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}

	private void createCustomer(SystemOfRecords sor, String name, String login, PaymentProcessor paymentProcessor, PaymentProcessor ach, Product... products) {
		Customer customer = BankFactory.eINSTANCE.createCustomer();
		customer.setName(name);
		customer.setLogin(login);
		sor.getCustomers().add(customer);
		
		for (Product p: products) {
			CreditCard account = BankFactory.eINSTANCE.createCreditCard();
			account.setCreditLimit(new BigDecimal("15000.00"));
			account.setRate(new BigDecimal("0.072"));
			account.setGracePeriod(30);
			account.setBalance(BigDecimal.ZERO);
			account.setProduct(p);
			account.setPeriodStart(random.nextInt(28)+1);
			customer.getAccounts().add(account);
			fillAccount(account, paymentProcessor, ach);
		}
	}
	
	private MessageFormat mf = new MessageFormat("{0,number,#.00}");
	
	private BigDecimal randomAmount(double from, double to) {
		double ram = from + random.nextDouble()*(to-from);		
		return new BigDecimal(mf.format(new Object[] {ram}));
	}

	private void fillAccount(Account account, PaymentProcessor cardProcessor, PaymentProcessor ach) {
		Calendar calendar = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		
		calendar.add(Calendar.MONTH, -4);
		
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		BigDecimal balance = BigDecimal.ZERO;
		for (; calendar.before(now); calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(3)+1)) {
			switch (random.nextInt(5)) {
			case 0:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"WalMart", 
						calendar.getTime(), 
						randomAmount(23.8, 75.6), 
						"General merchandize").getAmount());
				break;
			case 1:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"McDonalds", 
						calendar.getTime(), 
						randomAmount(7.5, 14.9), 
						"Dining out").getAmount());
				break;
			case 2:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"DSW", 
						calendar.getTime(), 
						randomAmount(35, 120), 
						"Clothing and shoes").getAmount());
				break;
			case 3:
				balance = balance.add(account.transfer(
						TransactionType.DEBIT, 
						cardProcessor, 
						"Shell", 
						calendar.getTime(), 
						randomAmount(25, 56), 
						"Gasoline").getAmount());
				break;
			case 4:
				if (BigDecimal.ZERO.compareTo(balance)<0) {
					account.transfer(
							TransactionType.CREDIT, 
							ach, 
							"Automated transfer", 
							calendar.getTime(), 
							balance, 
							"Payment, thank you");
					balance = BigDecimal.ZERO;
				}
				break;
				
			}
		}				
	}

}
