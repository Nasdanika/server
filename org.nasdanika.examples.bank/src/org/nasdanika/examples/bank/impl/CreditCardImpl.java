/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.CreditCard;
import org.nasdanika.examples.bank.Statement;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Select;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.ActionMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Credit Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.CreditCardImpl#getCreditLimit <em>Credit Limit</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CreditCardImpl#getGracePeriod <em>Grace Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreditCardImpl extends LoanAccountImpl implements CreditCard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreditCardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.CREDIT_CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getCreditLimit() {
		return (BigDecimal)eGet(BankPackage.Literals.CREDIT_CARD__CREDIT_LIMIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreditLimit(BigDecimal newCreditLimit) {
		eSet(BankPackage.Literals.CREDIT_CARD__CREDIT_LIMIT, newCreditLimit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGracePeriod() {
		return (Integer)eGet(BankPackage.Literals.CREDIT_CARD__GRACE_PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGracePeriod(int newGracePeriod) {
		eSet(BankPackage.Literals.CREDIT_CARD__GRACE_PERIOD, newGracePeriod);
	}
		
	@ActionMethod(pattern="[^/]+\\.html")
	public String home(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.getHTMLFactory();
		Table summaryTable = htmlFactory.table().striped();

		Row currentBalanceRow = summaryTable.row();
		currentBalanceRow.header("Current balance");
		currentBalanceRow.cell(getBalance().negate());
		
		Row minPaymentRow = summaryTable.row();
		minPaymentRow.header("Minimum payment");
		minPaymentRow.cell(getBalance().negate().divide(new BigDecimal("100")));
		
		Select statementSelect = htmlFactory
				.select("selectStatement", "selectStatement", "Select statement period")
				.style("float", "right")
				.on(Event.change, "nsdLoad($('#transactions'), this.value)");
		
		List<Statement> rs = new ArrayList<>(getStatements());
		Collections.reverse(rs);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Statement st: rs) {
			if (st.getClosingDate()==null) {
				statementSelect.option(
						context.getObjectPath(st)+"/transactions.html", 
						"Current transactions", 
						true, 
						false);
			} else {
				statementSelect.option(
						context.getObjectPath(st)+"/transactions.html", 
						"Statement "+dateFormat.format(st.getClosingDate()), 
						false, 
						false);				
			}
		}
		
		return htmlFactory.fragment(
				htmlFactory.panel(Style.INFO, "Account summary", summaryTable, null), 
				"<p/>", 
				htmlFactory.panel(
						Style.INFO, 
						htmlFactory.fragment("Transactions", statementSelect), 
						htmlFactory.div("Loading transactions...").id("transactions"), 						
						null),						
				htmlFactory.tag("script", "$('#selectStatement')[0].onchange();")).toString();
	}

} //CreditCardImpl
