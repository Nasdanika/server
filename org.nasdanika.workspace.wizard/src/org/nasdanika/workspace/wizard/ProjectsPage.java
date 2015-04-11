package org.nasdanika.workspace.wizard;

import org.eclipse.jface.wizard.IWizardPage;
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

public class ProjectsPage extends WizardPage {
	
	Text modelSuffix;
	Text applicationSuffix;
	Text testsSuffix;
	Text actorSpecSuffix;
	Text pageSpecSuffix;
	Text actorImplSuffix;
	Text pageImplSuffix;
	Text uiDriverSuffix;
	Button btnApplication;
	Button btnTests;
	Button btnActorSpec;
	Button btnActorImpl;
	Button btnPageImpl;
	Button btnPageSpec;
	Button btnModel;

	/**
	 * Create the wizard.
	 */
	public ProjectsPage() {
		super("ProjectsPage");
		setTitle("Projects");
		setDescription("Projects to be generated");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout gl_container = new GridLayout();
		gl_container.numColumns = 2;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		setControl(container);
		
		Label lblProject = new Label(container, SWT.NONE);
		lblProject.setText("Project");
		
		Label lblSuffix = new Label(container, SWT.NONE);
		lblSuffix.setText("Suffix");
		
		btnModel = new Button(container, SWT.CHECK);
		btnModel.setSelection(true);
		btnModel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				modelSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnModel.setText("Model");
		
		modelSuffix = new Text(container, SWT.BORDER);
		modelSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnApplication = new Button(container, SWT.CHECK);
		btnApplication.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getWizard().getContainer().updateButtons();
				applicationSuffix.setEnabled(btnApplication.getSelection());
			}
		});
		btnApplication.setSelection(true);
		btnApplication.setText("Application");
		
		applicationSuffix = new Text(container, SWT.BORDER);
		applicationSuffix.setText("app");
		applicationSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnTests = new Button(container, SWT.CHECK);
		btnTests.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				testsSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnTests.setSelection(true);
		btnTests.setText("Tests");
		
		testsSuffix = new Text(container, SWT.BORDER);
		testsSuffix.setText("tests");
		testsSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpUiDriver = new Group(container, SWT.NONE);
		grpUiDriver.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		grpUiDriver.setText("UI Driver");
		grpUiDriver.setLayout(new GridLayout(2, false));
		GridData gd_grpUiDriver = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_grpUiDriver.widthHint = 142;
		grpUiDriver.setLayoutData(gd_grpUiDriver);
		
		Label lblNewLabel = new Label(grpUiDriver, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 74;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText(" ");
		
		uiDriverSuffix = new Text(grpUiDriver, SWT.BORDER);
		uiDriverSuffix.setText("ui.driver");
		uiDriverSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpSpecification = new Group(grpUiDriver, SWT.NONE);
		grpSpecification.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		grpSpecification.setLayout(new GridLayout(2, false));
		GridData gd_grpSpecification = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_grpSpecification.widthHint = 118;
		grpSpecification.setLayoutData(gd_grpSpecification);
		grpSpecification.setText("Specification");
		grpSpecification.setBounds(0, 0, 70, 82);
		
		btnActorSpec = new Button(grpSpecification, SWT.CHECK);
		btnActorSpec.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				actorSpecSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnActorSpec.setSelection(true);
		GridData gd_btnActorSpec = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnActorSpec.widthHint = 65;
		btnActorSpec.setLayoutData(gd_btnActorSpec);
		btnActorSpec.setText("Actors");
		
		actorSpecSuffix = new Text(grpSpecification, SWT.BORDER);
		actorSpecSuffix.setText("actors");
		actorSpecSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnPageSpec = new Button(grpSpecification, SWT.CHECK);
		btnPageSpec.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageSpecSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnPageSpec.setSelection(true);
		btnPageSpec.setText("Pages");
		
		pageSpecSuffix = new Text(grpSpecification, SWT.BORDER);
		pageSpecSuffix.setText("pages");
		pageSpecSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpImplementation = new Group(grpUiDriver, SWT.NONE);
		GridData gd_grpImplementation = new GridData(GridData.FILL_HORIZONTAL);
		gd_grpImplementation.horizontalSpan = 2;
		grpImplementation.setLayoutData(gd_grpImplementation);
		grpImplementation.setText("Implementation");
		grpImplementation.setBounds(0, 0, 70, 82);
		grpImplementation.setLayout(new GridLayout(2, false));
		
		btnActorImpl = new Button(grpImplementation, SWT.CHECK);
		btnActorImpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				actorImplSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnActorImpl.setSelection(true);
		GridData gd_btnActorImpl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnActorImpl.widthHint = 65;
		btnActorImpl.setLayoutData(gd_btnActorImpl);
		btnActorImpl.setText("Actors");
		
		actorImplSuffix = new Text(grpImplementation, SWT.BORDER);
		actorImplSuffix.setText("actors.impl");
		actorImplSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnPageImpl = new Button(grpImplementation, SWT.CHECK);
		btnPageImpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageImplSuffix.setEnabled(((Button) e.getSource()).getSelection());
			}
		});
		btnPageImpl.setSelection(true);
		btnPageImpl.setText("Pages");
		
		pageImplSuffix = new Text(grpImplementation, SWT.BORDER);
		pageImplSuffix.setText("pages.impl");
		pageImplSuffix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}
	
	@Override
	public IWizardPage getNextPage() {
		return btnApplication.getSelection() ? super.getNextPage() : null;
	}
}
