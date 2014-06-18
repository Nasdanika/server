/**
 */
package org.nasdanika.examples.bank.impl;

import java.security.MessageDigest;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.AuthorizationHelper;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.ApplicationPanel.ContentPanel;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getAccounts <em>Accounts</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getLogin <em>Login</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CustomerImpl#getPasswordHash <em>Password Hash</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomerImpl extends CDOObjectImpl implements Customer {
	private static final String UTF_8 = "UTF_8";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.CUSTOMER;
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
	public EList<Group> getMemberOf() {
		return (EList<Group>)eGet(SecurityPackage.Literals.PRINCIPAL__MEMBER_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Permission> getPermissions() {
		return (EList<Permission>)eGet(SecurityPackage.Literals.PRINCIPAL__PERMISSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Account> getAccounts() {
		return (EList<Account>)eGet(BankPackage.Literals.CUSTOMER__ACCOUNTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(BankPackage.Literals.CUSTOMER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BankPackage.Literals.CUSTOMER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogin() {
		return (String)eGet(BankPackage.Literals.CUSTOMER__LOGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogin(String newLogin) {
		eSet(BankPackage.Literals.CUSTOMER__LOGIN, newLogin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getPasswordHash() {
		return (byte[])eGet(BankPackage.Literals.CUSTOMER__PASSWORD_HASH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordHash(byte[] newPasswordHash) {
		eSet(BankPackage.Literals.CUSTOMER__PASSWORD_HASH, newPasswordHash);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, String bodyMimeType, Object body) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, Map<String, Object> bodyMap) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendMessage(Principal from, String subject, String body) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	private AuthorizationHelper authorizationHelper = new AuthorizationHelper() {
		
		@Override
		protected Principal getPrincipal() {
			return CustomerImpl.this;
		}
		
		@Override
		protected ProtectionDomain<?> getProtectionDomain() {
			return (ProtectionDomain<?>) CustomerImpl.this.eContainer();
		}
		
	};
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
		return authorizationHelper.authorize(context, target, action, qualifier, environment);
	}

	@RouteMethod(pattern="[^/]+\\.html")
	public String home(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.getHTMLFactory();
		ApplicationPanel appPanel = htmlFactory
				.applicationPanel()
				.width(800)
				.minHeight(600)
				.style(Style.PRIMARY)
				.header("Nasdanika Bank");
		
		ContentPanel mainPanel = appPanel.contentPanel("Loading accounts panel...").id("main");
		
		if (context.authorize(this, "something", null, null)) {
			System.out.println("ah");
		}
		
		Fragment rightPanelContent = htmlFactory.fragment();
		context.buildUICategory("right-panel", rightPanelContent, null);
		if (!rightPanelContent.isEmpty()) {
			mainPanel.width(DeviceSize.LARGE, 9);
			appPanel.contentPanel(rightPanelContent).width(DeviceSize.LARGE, 3);
		}
		
		appPanel.footer(htmlFactory.link("#", "Contact Us"));
		return htmlFactory.routerApplication(
				"Nasdanika Bank", 
				"main"+context.getObjectPath(this)+"/accounts.html", 
				null, 
				appPanel).toString();
	}
	
	@RouteMethod(pattern="[^/]+/accounts\\.html")
	public String accountsPanel(HttpContext context) throws Exception {
		HTMLFactory htmlFactory = context.getHTMLFactory();
		Table accountsTable = htmlFactory.table();
		Row hRow = accountsTable.row().style(Style.INFO);
		hRow.header("Account");
		hRow.header("Balance").style("text-align", "right");
		for (Account a: getAccounts()) {
			Row aRow = accountsTable.row();
			aRow.cell(htmlFactory.routeLink(
					"main", 
					context.getObjectPath(a)+".html", 
					StringEscapeUtils.escapeHtml4(a.getProduct().getName()+"-"+a.cdoID())));
			aRow.cell(a.getBalance().negate()).attribute("align", "right");
		}
		return htmlFactory.panel(
				Style.INFO, 
				"Accounts", 
				accountsTable, 
				null).toString()+htmlFactory.title("Accounts");
	}

	@Override
	public void setPassword(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(getLogin().getBytes(UTF_8));
		md.update((byte) 0); // Separator
		md.update(password.getBytes(UTF_8));
		setPasswordHash(md.digest());
	}

} //CustomerImpl
