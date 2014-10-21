package org.nasdanika.workspace.wizard;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.internal.core.feature.FeatureChild;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.ui.wizards.feature.CreateFeatureProjectOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "mpe". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 */

public class WorkspaceWizard extends Wizard implements INewWizard {
	private static final String MAVEN_2_BUILDER = "org.eclipse.m2e.core.maven2Builder";
	private static final String MAVEN_2_NATURE_ID = "org.eclipse.m2e.core.maven2Nature";
	protected GeneralInformationPage generalInformationPage;
	private ProjectsPage projectsPage;
	private ApplicationConfigurationPage applicationConfigurationPage;
	
	protected IWorkbench workbench;
//	protected IPath genProjectsLocation;
//	protected IPath genModelContainerPath;
//	protected IProject project;
	protected String initialProjectName;
	protected IStructuredSelection selection;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(GenModelEditPlugin.INSTANCE.getImage("full/wizban/NewEmptyEMFProject")));
		setWindowTitle("New Nasdanika Application Workspace");
	}

	@Override
	public void addPages() {
		generalInformationPage = new GeneralInformationPage(selection, "GeneralInformation");

		generalInformationPage.setInitialProjectName(initialProjectName);
		generalInformationPage.setTitle("General information");
		generalInformationPage.setDescription("Group Id (umbrella name), version, working set");
		addPage(generalInformationPage);	
		
		projectsPage = new ProjectsPage();
		addPage(projectsPage);
		
		applicationConfigurationPage = new ApplicationConfigurationPage();
		addPage(applicationConfigurationPage);
	}

	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					modifyWorkspace(progressMonitor);
				} catch (Exception exception) {
					GenModelEditPlugin.INSTANCE.log(exception);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (Exception exception) {
			GenModelEditPlugin.INSTANCE.log(exception);
			return false;
		}

//		if (project != null) {
//			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
//			final IWorkbenchPart activePart = page.getActivePart();
//			if (activePart instanceof ISetSelectionTarget) {
//				final ISelection targetSelection = new StructuredSelection(project);
//				getShell().getDisplay().asyncExec(new Runnable() {
//					public void run() {
//						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
//					}
//				});
//			}
//		}

		return true;
	}
	public void modifyWorkspace(IProgressMonitor progressMonitor) throws Exception {
		generateModelProject(progressMonitor);
//		generateApplicationProject(progressMonitor);
//		generateTestsProject(progressMonitor);
		generateFeatureProject(progressMonitor);
		generateParentProject(progressMonitor);
//		generateRepositoryProject(progressMonitor);
//		generateTargetProject(progressMonitor);
		generateAggregatorProject(progressMonitor);
//		generateActorSpecProject(progressMonitor);
//		generateActorImplProject(progressMonitor);
//		generatePageSpecProject(progressMonitor);
//		generatePageImplProject(progressMonitor);
	}

	private void generateFeatureProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getGroupId()+".feature");
		IPath location = generalInformationPage.getLocationPath();
		if (!Platform.getLocation().equals(location)) {
			location = location.append(getGroupId()+".feature");
		}
		FeatureData featureData = new FeatureData();
		featureData.id = getGroupId()+".feature";
		featureData.name = generalInformationPage.nameField.getText()+" feature";
		featureData.version = getVersion();
		new CreateFeatureProjectOperation(project, location, featureData, null, getShell()) {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException ,InvocationTargetException ,InterruptedException {
				super.execute(monitor);
				addMaven2NatureAndBuilder(monitor, fProject);

				try {
					fProject.getFile("pom.xml").create(new ByteArrayInputStream(new FeaturePomRenderer().generate(WorkspaceWizard.this).getBytes()), false, monitor);
				} catch (CoreException | InvocationTargetException | InterruptedException e) {
					throw e;					
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				}				
			}
			
			@Override
			protected void configureFeature(IFeature feature, WorkspaceFeatureModel model) throws CoreException {
				super.configureFeature(feature, model);
				List<IFeaturePlugin> plugins = new ArrayList<>();
				FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
				fplugin.setId("a.b.c");
				fplugin.setVersion("0.0.0");
				plugins.add(fplugin);
				feature.addPlugins(plugins.toArray(new IFeaturePlugin[plugins.size()]));
				
				List<FeatureChild> includedFeatures = new ArrayList<>();
				FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
				fChild.setVersion("1.0.1");
				fChild.setId("x.y.z");
				includedFeatures.add(fChild);
				feature.addIncludedFeatures(includedFeatures.toArray(new FeatureChild[includedFeatures.size()]));
			};
			
		}.execute(progressMonitor);				
	}

	private void generateParentProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(getParentArtifactId());
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(getParentArtifactId()).toFile().toURI());
		description.setNatureIds(new String[] { MAVEN_2_NATURE_ID });
		
		final ICommand m2 = description.newCommand();
        m2.setBuilderName(MAVEN_2_BUILDER);
        description.setBuildSpec(new ICommand[] { m2 });

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getParentArtifactId());
		project.create(description, progressMonitor);
		project.open(progressMonitor);
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}

		project.getFile("pom.xml").create(new ByteArrayInputStream(new ParentPomRenderer().generate(this).getBytes()), false, progressMonitor);
	}

	private void generateAggregatorProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(getParentArtifactId());
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(getGroupId()+".aggregator").toFile().toURI());
		description.setNatureIds(new String[] { MAVEN_2_NATURE_ID });
		
		final ICommand m2 = description.newCommand();
        m2.setBuilderName(MAVEN_2_BUILDER);
        description.setBuildSpec(new ICommand[] { m2 });

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getGroupId()+".aggregator");
		project.create(description, progressMonitor);
		project.open(progressMonitor);
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}

		IFile pom = project.getFile("pom.xml");	
		pom.create(new ByteArrayInputStream(new AggregatorPomRenderer().generate(this).getBytes()), false, progressMonitor);
	}

	private void generateModelProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnModel.getSelection()) {
			IPath genModelContainerPath = ResourcesPlugin.getWorkspace().getRoot().getProject(getModelArtifactId()).getFullPath().append("src");
			IPath locationPath = generalInformationPage.getLocationPath();
			IPath genModelProjectLocation = Platform.getLocation().equals(locationPath) ? null : locationPath.append(getModelArtifactId());
			IProject project = Generator.createEMFProject(
					new Path(genModelContainerPath.toString()),
					genModelProjectLocation, Collections.<IProject> emptyList(),
					progressMonitor, Generator.EMF_MODEL_PROJECT_STYLE| Generator.EMF_PLUGIN_PROJECT_STYLE);
	
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
			}
	
			CodeGenUtil.EclipseUtil.findOrCreateContainer(
					new Path("/" + genModelContainerPath.segment(0) + "/model"), 
					true,
					genModelProjectLocation, 
					progressMonitor);
	
			PrintStream manifest = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(
							URI.createPlatformResourceURI("/"
									+ genModelContainerPath.segment(0)
									+ "/META-INF/MANIFEST.MF", true), null), false,
					"UTF-8");
			manifest.println("Manifest-Version: 1.0");
			manifest.println("Bundle-ManifestVersion: 2");
			manifest.print("Bundle-Name: ");
			manifest.println(genModelContainerPath.segment(0));
			manifest.print("Bundle-SymbolicName: ");
			manifest.print(CodeGenUtil.validPluginID(genModelContainerPath
					.segment(0)));
			manifest.println("; singleton:=true");
			manifest.println("Bundle-Version: 0.1.0.qualifier");
			manifest.print("Require-Bundle: ");
			String[] requiredBundles = getRequiredBundles();
			for (int i = 0, size = requiredBundles.length; i < size;) {
				manifest.print(requiredBundles[i]);
				if (++i == size) {
					manifest.println();
					break;
				} else {
					manifest.println(",");
					manifest.print(" ");
				}
			}
			manifest.close();
			
			addMaven2NatureAndBuilder(progressMonitor, project);
			
			PrintStream pom = new PrintStream(
					URIConverter.INSTANCE.createOutputStream(
							URI.createPlatformResourceURI("/"
									+ genModelContainerPath.segment(0)
									+ "/pom.xml", true), null), false,
					"UTF-8");
			
			pom.print(new ModelPomRenderer().generate(this));
			pom.close();
		}		
	}

	private void addMaven2NatureAndBuilder(IProgressMonitor progressMonitor, IProject project) throws CoreException {
		IProjectDescription desc = project.getDescription();
		String[] prevNatures = desc.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = MAVEN_2_NATURE_ID;
		desc.setNatureIds(newNatures);

        ICommand [] oldBuilders = desc.getBuildSpec();
        ICommand[] builders = new ICommand [oldBuilders.length + 1];
        System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
        builders[oldBuilders.length] = desc.newCommand();
        builders[oldBuilders.length].setBuilderName(MAVEN_2_BUILDER);
		
		project.setDescription(desc, progressMonitor);		
	}

	public void setInitialProjectName(String value) {
		initialProjectName = value;
	}

	protected String[] getRequiredBundles() {
		return new String[] { "org.eclipse.emf.ecore" };
	}

	public String getModelArtifactId() {		
		return projectsPage.modelSuffix.getText().trim().length()==0 ? 
				generalInformationPage.groupIdField.getText() 
				: generalInformationPage.groupIdField.getText()+"."+projectsPage.modelSuffix.getText();
	}

	public String getGroupId() {
		// TODO - variations depending on selections
		return generalInformationPage.groupIdField.getText();
	}

	public String getParentArtifactId() {
		return getGroupId()+".parent";
	}

	public String getVersion() {
		return generalInformationPage.versionField.getText();
	}

	public List<String> getModules() {
		List<String> ret = new ArrayList<>();
		if (projectsPage.btnModel.getSelection()) {
			ret.add(getModelArtifactId());
		}
		return ret;
	}
}