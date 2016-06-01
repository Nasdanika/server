package org.nasdanika.workspace.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ApplicationConfigurationPage extends WizardPage {
	Text routingServletAlias;
	Text webContentAlias;
	Text webContentBaseName;
	Button btnRoutingServlet;
	Button btnWebContent;
	Button btnRepository;
	Button btnServer;
	Button btnTransactionContextProvider;
	Button btnDocumentationRoute;
	Button btnSessionInitializer;
	private Label docRoutePathLabel;
	Text documentationRoutePathText;
	Text httpContextIdText;
	Text contextPathText;
	private Label lblContextPath;
	private Label lblHttpContextId;
	Button btnWebsocketSessionServlet;
	Text sessionServletAlias;
	Button btnDocumentationApplicationRoute;
	private Label docAppRoutePatternLabel;
	Text docAppRoutePatternText;

	/**
	 * Create the wizard.
	 */
	public ApplicationConfigurationPage() {
		super("ApplicationConfigurationPage");
		setTitle("Application configuration");
		setDescription("Application components and their configuration");
	}
	
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			WorkspaceWizard wizard = (WorkspaceWizard) getWizard();
			httpContextIdText.setText(wizard.getGroupId());
			contextPathText.setText("/"+wizard.getDashedName());
		}
		super.setVisible(visible);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Group grpWebApplication = new Group(container, SWT.NONE);
		grpWebApplication.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpWebApplication.setText("Web Application");
		grpWebApplication.setLayout(new GridLayout(2, false));
		
		lblContextPath = new Label(grpWebApplication, SWT.NONE);
		lblContextPath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblContextPath.setText("Context path");
		
		contextPathText = new Text(grpWebApplication, SWT.BORDER);
		contextPathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblHttpContextId = new Label(grpWebApplication, SWT.NONE);
		lblHttpContextId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHttpContextId.setText("HTTP Context ID");
		
		httpContextIdText = new Text(grpWebApplication, SWT.BORDER);
		httpContextIdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Context path
		
		// context id
		
		btnRoutingServlet = new Button(grpWebApplication, SWT.CHECK);
		btnRoutingServlet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				routingServletAlias.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnRoutingServlet.setSelection(true);
		btnRoutingServlet.setText("Routing Servlet");
		
		routingServletAlias = new Text(grpWebApplication, SWT.BORDER);
		routingServletAlias.setText("/router");
		routingServletAlias.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnWebsocketSessionServlet = new Button(grpWebApplication, SWT.CHECK);
		btnWebsocketSessionServlet.setSelection(true);
		btnWebsocketSessionServlet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnWebsocketSessionServlet.setText("Session Servlet");
		
		sessionServletAlias = new Text(grpWebApplication, SWT.BORDER);
		sessionServletAlias.setText("/session");
		sessionServletAlias.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnWebContent = new Button(grpWebApplication, SWT.CHECK);
		btnWebContent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				webContentAlias.setEnabled(((Button) e.getSource()).getSelection());
				webContentBaseName.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnWebContent.setSelection(false);
		btnWebContent.setText("Web Content");
		new Label(grpWebApplication, SWT.NONE);
		
		Label lblAlias = new Label(grpWebApplication, SWT.NONE);
		lblAlias.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAlias.setText("Alias");
		
		webContentAlias = new Text(grpWebApplication, SWT.BORDER);
		webContentAlias.setText("/");
		webContentAlias.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBaseName = new Label(grpWebApplication, SWT.NONE);
		lblBaseName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBaseName.setText("Base Name");
		
		webContentBaseName = new Text(grpWebApplication, SWT.BORDER);
		webContentBaseName.setText("WebContent");
		webContentBaseName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpOsgiComponents = new Group(container, SWT.NONE);
		grpOsgiComponents.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpOsgiComponents.setText("OSGi Components");
		grpOsgiComponents.setLayout(new GridLayout(3, false));
		
		btnRepository = new Button(grpOsgiComponents, SWT.CHECK);
		btnRepository.setSelection(true);
		btnRepository.setText("H2 Repository");
		new Label(grpOsgiComponents, SWT.NONE);
		new Label(grpOsgiComponents, SWT.NONE);
		
		btnServer = new Button(grpOsgiComponents, SWT.CHECK);
		btnServer.setSelection(true);
		btnServer.setText("Server");
		new Label(grpOsgiComponents, SWT.NONE);
		new Label(grpOsgiComponents, SWT.NONE);
		
		btnTransactionContextProvider = new Button(grpOsgiComponents, SWT.CHECK);
		btnTransactionContextProvider.setSelection(true);
		btnTransactionContextProvider.setText("Transaction Context Provider");
		new Label(grpOsgiComponents, SWT.NONE);
		new Label(grpOsgiComponents, SWT.NONE);
		
		btnDocumentationRoute = new Button(grpOsgiComponents, SWT.CHECK);
		btnDocumentationRoute.setSelection(true);
		btnDocumentationRoute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				documentationRoutePathText.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnDocumentationRoute.setText("Documentation Route");
		
		docRoutePathLabel = new Label(grpOsgiComponents, SWT.NONE);
		docRoutePathLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		docRoutePathLabel.setText("Path:");
		
		documentationRoutePathText = new Text(grpOsgiComponents, SWT.BORDER);
		documentationRoutePathText.setText("doc");
		documentationRoutePathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnDocumentationApplicationRoute = new Button(grpOsgiComponents, SWT.CHECK);
		btnDocumentationApplicationRoute.setSelection(true);
		btnDocumentationApplicationRoute.setText("Documentation Application Route");
		
		docAppRoutePatternLabel = new Label(grpOsgiComponents, SWT.NONE);
		docAppRoutePatternLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		docAppRoutePatternLabel.setText("Pattern:");
		
		docAppRoutePatternText = new Text(grpOsgiComponents, SWT.BORDER);
		docAppRoutePatternText.setText("doc\\.html");
		docAppRoutePatternText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnSessionInitializer = new Button(grpOsgiComponents, SWT.CHECK);
		btnSessionInitializer.setSelection(true);
		btnSessionInitializer.setText("Session Initializer");
		new Label(grpOsgiComponents, SWT.NONE);
		new Label(grpOsgiComponents, SWT.NONE);
	}

}
