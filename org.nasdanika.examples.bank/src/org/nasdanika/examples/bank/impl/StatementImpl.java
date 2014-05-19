/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Statement;
import org.nasdanika.examples.bank.Transaction;
import org.nasdanika.examples.bank.TransactionType;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.ActionMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.StatementImpl#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.StatementImpl#getOpeningBalance <em>Opening Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.StatementImpl#getOpeningDate <em>Opening Date</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.StatementImpl#getClosingBalance <em>Closing Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.StatementImpl#getClosingDate <em>Closing Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatementImpl extends CDOObjectImpl implements Statement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Transaction> getTransactions() {
		return (EList<Transaction>)eGet(BankPackage.Literals.STATEMENT__TRANSACTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getOpeningBalance() {
		return (BigDecimal)eGet(BankPackage.Literals.STATEMENT__OPENING_BALANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpeningBalance(BigDecimal newOpeningBalance) {
		eSet(BankPackage.Literals.STATEMENT__OPENING_BALANCE, newOpeningBalance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getOpeningDate() {
		return (Date)eGet(BankPackage.Literals.STATEMENT__OPENING_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpeningDate(Date newOpeningDate) {
		eSet(BankPackage.Literals.STATEMENT__OPENING_DATE, newOpeningDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getClosingBalance() {
		return (BigDecimal)eGet(BankPackage.Literals.STATEMENT__CLOSING_BALANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClosingBalance(BigDecimal newClosingBalance) {
		eSet(BankPackage.Literals.STATEMENT__CLOSING_BALANCE, newClosingBalance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getClosingDate() {
		return (Date)eGet(BankPackage.Literals.STATEMENT__CLOSING_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClosingDate(Date newClosingDate) {
		eSet(BankPackage.Literals.STATEMENT__CLOSING_DATE, newClosingDate);
	}
	
	@ActionMethod(pattern="[^/]+/transactions\\.html")
	public String transactionsTable(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.getHTMLFactory();
		Table tTable = htmlFactory.table().striped().id("transactions");
		Row hRow = tTable.row().style(Style.INFO);
		hRow.header(htmlFactory.glyphicon(Glyphicon.calendar), " Date");
		hRow.header(htmlFactory.glyphicon(Glyphicon.pencil), " Description");
		hRow.header(htmlFactory.glyphicon(Glyphicon.usd), " Amount")
		.style("text-align", "right");
		List<Transaction> transactions = new ArrayList<>(getTransactions());
		Collections.reverse(transactions);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Transaction tr: transactions) {
			Row tRow = tTable.row();
			tRow.cell(dateFormat.format(tr.getDate()));
			tRow.cell(StringEscapeUtils.escapeHtml4(tr.getComment()));
			if (TransactionType.CREDIT.equals(tr.getType())) {
				tRow.cell(tr.getAmount().negate())
				.attribute("align", "right")
				.style("color", "blue");				
			} else { 
				tRow.cell(tr.getAmount()).attribute("align", "right");
			}
		}
		return tTable.toString();
	}	

} //StatementImpl
