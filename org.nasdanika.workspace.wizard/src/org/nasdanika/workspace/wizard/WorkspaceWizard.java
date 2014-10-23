package org.nasdanika.workspace.wizard;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osgi.framework.FrameworkUtil;

/**
 * Wizard to create projects for a Nasdanika Foundation Server based application.
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
		generateApplicationProject(progressMonitor);
		generateTestsProject(progressMonitor);
		generateFeatureProject(progressMonitor);
		generateParentProject(progressMonitor);
		generateRepositoryProject(progressMonitor);
		generateTargetProject(progressMonitor);
		generateAggregatorProject(progressMonitor);
		generateActorSpecProject(progressMonitor);
		generateActorImplProject(progressMonitor);
		generatePageSpecProject(progressMonitor);
		generatePageImplProject(progressMonitor);
	}

	private void generateActorSpecProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		IJavaProject project = createPluginProject(
				getActorSpecArtifactId(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - factory, Actor
	}

	private void generatePageSpecProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		IJavaProject project = createPluginProject(
				getPageSpecArtifactId(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - factory, Actor
	}

	private void generateActorImplProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		IJavaProject project = createPluginProject(
				getActorImplArtifactId(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - factory, Actor
	}

	private void generatePageImplProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		IJavaProject project = createPluginProject(
				getPageImplArtifactId(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - factory, Actor
	}

	private void generateApplicationProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		createPluginProject(
				getGroupId()+"."+projectsPage.applicationSuffix.getText(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - plugin.xml, components
	}

	private void generateTestsProject(IProgressMonitor progressMonitor) throws Exception {
		// TODO Condition
		createPluginProject(
				getTestsArtifactId(), 
				Collections.singletonList("mybundle"), 
				Collections.<String>emptyList(), 
				Collections.singletonList("my.package"), 
				progressMonitor);
		// TODO - plugin.xml or fragment.xml
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
				
				if (projectsPage.btnModel.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getModelArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnApplication.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getApplicationArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnTests.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getTestsArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnActorSpec.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getActorSpecArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnPageSpec.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getPageSpecArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnActorImpl.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getActorImplArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				if (projectsPage.btnPageImpl.getSelection()) {
					FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
					fplugin.setId(getPageImplArtifactId());
					fplugin.setVersion("0.0.0");
					plugins.add(fplugin);
				}
				
				feature.addPlugins(plugins.toArray(new IFeaturePlugin[plugins.size()]));
				
				List<FeatureChild> includedFeatures = new ArrayList<>();
				
				if (isIncludeCdo()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.cdo.feature");
					includedFeatures.add(fChild);
				}
				
				if (isIncludeEquinox()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.equinox.feature");
					includedFeatures.add(fChild);
				}
				
				if (isIncludeNasdanika()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.feature");
					includedFeatures.add(fChild);
				}
				
				if (isIncludeJetty()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.server.jetty.feature");
					includedFeatures.add(fChild);
				}
				
				if (isIncludeWebTest()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.webtest.feature");
					includedFeatures.add(fChild);
				}
				
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

	private void generateRepositoryProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(getParentArtifactId());
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(getGroupId()+".repository").toFile().toURI());
		description.setNatureIds(new String[] { MAVEN_2_NATURE_ID });
		
		final ICommand m2 = description.newCommand();
        m2.setBuilderName(MAVEN_2_BUILDER);
        description.setBuildSpec(new ICommand[] { m2 });

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getGroupId()+".repository");
		project.create(description, progressMonitor);
		project.open(progressMonitor);
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}

		IFile pom = project.getFile("pom.xml");	
		// TODO - repository renderer
		pom.create(new ByteArrayInputStream(new AggregatorPomRenderer().generate(this).getBytes()), false, progressMonitor);
		// TODO - category, product(s)
	}

	private void generateTargetProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(getParentArtifactId());
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(getGroupId()+".target").toFile().toURI());
		description.setNatureIds(new String[] { MAVEN_2_NATURE_ID });
		
		final ICommand m2 = description.newCommand();
        m2.setBuilderName(MAVEN_2_BUILDER);
        description.setBuildSpec(new ICommand[] { m2 });

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getGroupId()+".target");
		project.create(description, progressMonitor);
		project.open(progressMonitor);
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}

		IFile pom = project.getFile("pom.xml");	
		pom.create(new ByteArrayInputStream(new TargetPomRenderer().generate(this).getBytes()), false, progressMonitor);
		
		IFile target = project.getFile(getGroupId()+".target.target");	
		target.create(new ByteArrayInputStream(new TargetRenderer().generate(this).getBytes()), false, progressMonitor);		
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
        
        // Generate preferences?
		
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

	public String getApplicationArtifactId() {		
		return projectsPage.applicationSuffix.getText().trim().length()==0 ? 
				generalInformationPage.groupIdField.getText() 
				: generalInformationPage.groupIdField.getText()+"."+projectsPage.applicationSuffix.getText();
	}

	public String getTestsArtifactId() {		
		return projectsPage.testsSuffix.getText().trim().length()==0 ? 
				generalInformationPage.groupIdField.getText() 
				: generalInformationPage.groupIdField.getText()+"."+projectsPage.testsSuffix.getText();
	}

	public String getActorSpecArtifactId() {
		String ret = getGroupId();
		if (projectsPage.uiDriverSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.uiDriverSuffix.getText();
		}
		if (projectsPage.actorSpecSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.actorSpecSuffix.getText();
		}
		return ret;
	}

	public String getPageSpecArtifactId() {		
		String ret = getGroupId();
		if (projectsPage.uiDriverSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.uiDriverSuffix.getText();
		}
		if (projectsPage.pageSpecSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.pageSpecSuffix.getText();
		}
		return ret;
	}

	public String getActorImplArtifactId() {		
		String ret = getGroupId();
		if (projectsPage.uiDriverSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.uiDriverSuffix.getText();
		}
		if (projectsPage.actorImplSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.actorImplSuffix.getText();
		}
		return ret;
	}

	public String getPageImplArtifactId() {		
		String ret = getGroupId();
		if (projectsPage.uiDriverSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.uiDriverSuffix.getText();
		}
		if (projectsPage.pageImplSuffix.getText().trim().length()>0) {
			ret+="."+projectsPage.pageImplSuffix.getText();
		}
		return ret;
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
				
		if (projectsPage.btnApplication.getSelection()) {
			ret.add(getApplicationArtifactId());
		}
		
		if (projectsPage.btnTests.getSelection()) {
			ret.add(getTestsArtifactId());
		}
		
		if (projectsPage.btnActorSpec.getSelection()) {
			ret.add(getActorSpecArtifactId());
		}
		
		if (projectsPage.btnPageSpec.getSelection()) {
			ret.add(getPageSpecArtifactId());
		}
		
		if (projectsPage.btnActorImpl.getSelection()) {
			ret.add(getActorImplArtifactId());
		}
		
		if (projectsPage.btnPageImpl.getSelection()) {
			ret.add(getPageImplArtifactId());
		}
		
		ret.add(getGroupId()+".target");
		ret.add(getGroupId()+".feature");
		ret.add(getGroupId()+".repository");								
		return ret;
	}
	
	private IJavaProject createPluginProject(
			final String name,
			Iterable<String> requiredBundles,
			Collection<String> importedPackages, 
			Collection<String> exportedPackages, 
			IProgressMonitor progressMonitor) throws Exception {
		
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(name);

		// Clean up any old project information.
		if (project.exists()) {
			final boolean[] result = new boolean[1];
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					result[0] = MessageDialog.openQuestion(getShell(), "Do you want to overwrite the project "
							+ name, "Note that everything inside the project '" + name
							+ "' will be deleted if you confirm this dialog.");
				}
			});
			if (result[0]) {
				project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));
			} else {
				return null;
			}
		}

		final IJavaProject javaProject = JavaCore.create(project);
		final IProjectDescription description = workspace.newProjectDescription(name);
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(name).toFile().toURI());
		project.create(description, progressMonitor);

		description.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });

		final ICommand java = description.newCommand();
		java.setBuilderName(JavaCore.BUILDER_ID);

		final ICommand manifest = description.newCommand();
		manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

		final ICommand schema = description.newCommand();
		schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

		description.setBuildSpec(new ICommand[] { java, manifest, schema });
				
		project.open(new SubProgressMonitor(progressMonitor, 1));
		project.setDescription(description, new SubProgressMonitor(progressMonitor, 1));

		addMaven2NatureAndBuilder(progressMonitor, project);				

		final IFolder srcContainer = project.getFolder("src");
		if (!srcContainer.exists()) {
			srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		}
		final List<IClasspathEntry> classpathEntries = new ArrayList<>();
		final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
		classpathEntries.add(srcClasspathEntry);

		classpathEntries.add(
				JavaCore.newContainerEntry(
						new Path("org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7")));
		classpathEntries.add(
				JavaCore.newContainerEntry(
						new Path("org.eclipse.pde.core.requiredPlugins")));

		javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),	new SubProgressMonitor(progressMonitor, 1));

		javaProject.setOutputLocation(new Path("/" + name + "/bin"), new SubProgressMonitor(progressMonitor, 1));
		createManifest(name, requiredBundles, importedPackages, exportedPackages, progressMonitor, project);
		createBuildProps(progressMonitor, project);
		return javaProject;
	}

	private static void createFile(
			String name, 
			IContainer container,
			String content,
			IProgressMonitor progressMonitor) throws Exception {
		
		IFile file = container.getFile(new Path(name));
		try (InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()))) {
			if (file.exists()) {
				file.setContents(stream, true, true, progressMonitor);
			} else {
				file.create(stream, true, progressMonitor);
			}
		}
		progressMonitor.worked(1);
	}

	private static void createBuildProps(IProgressMonitor progressMonitor, IProject project) throws Exception {
		StringBuilder bpContent = new StringBuilder("source.. = src")
			.append(System.lineSeparator())
			.append("bin.includes = META-INF/,.")
			.append(System.lineSeparator());
		createFile("build.properties", project, bpContent.toString(), progressMonitor);
	}

	private void createManifest(
			String projectName, 
			Iterable<String> requiredBundles,
			Collection<String> importedPackages,
			Collection<String> exportedPackages, 
			IProgressMonitor progressMonitor, 
			IProject project) throws Exception {
		StringBuilder manifestBuilder = new StringBuilder("Manifest-Version: 1.0").append(System.lineSeparator());
		manifestBuilder.append("Bundle-ManifestVersion: 2").append(System.lineSeparator());
		manifestBuilder.append("Bundle-Name: " + projectName).append(System.lineSeparator());
		manifestBuilder.append("Bundle-SymbolicName: " + projectName + "; singleton:=true").append(System.lineSeparator()); // TODO - Singleton?
		manifestBuilder.append("Bundle-Version: ").append(getVersion()).append(System.lineSeparator());
		manifestBuilder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.7").append(System.lineSeparator());
		manifestBuilder.append("Require-Bundle:");
		Iterator<String> rit = requiredBundles.iterator();
		while (rit.hasNext()) {
			manifestBuilder.append(" ").append(rit.next());
			if (rit.hasNext()) {
				manifestBuilder.append(",");				
			}
			manifestBuilder.append(System.lineSeparator());
		}

		if (exportedPackages != null && !exportedPackages.isEmpty()) {
			manifestBuilder.append("Export-Package:");
			Iterator<String> epit = exportedPackages.iterator();
			while (epit.hasNext()) {
				manifestBuilder.append(" ").append(epit.next());
				if (epit.hasNext()) {
					manifestBuilder.append(",");				
				}
				manifestBuilder.append(System.lineSeparator());
			}
		}

		if (importedPackages != null && !importedPackages.isEmpty()) {
			manifestBuilder.append("Import-Package:");
			Iterator<String> ipit = importedPackages.iterator();
			while (ipit.hasNext()) {
				manifestBuilder.append(" ").append(ipit.next());
				if (ipit.hasNext()) {
					manifestBuilder.append(",");				
				}
				manifestBuilder.append(System.lineSeparator());
			}
		}

		final IFolder metaInf = project.getFolder("META-INF");
		metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		createFile("MANIFEST.MF", metaInf, manifestBuilder.toString(), progressMonitor);
	}

	public boolean isIncludeJetty() {
		return projectsPage.btnApplication.getSelection() &&
				(applicationConfigurationPage.btnRepository.getSelection()
						|| applicationConfigurationPage.btnRoutingServlet.getSelection()
						|| applicationConfigurationPage.btnWebContent.getSelection());
	}

	public Object getTargetVersion() {		
		return FrameworkUtil.getBundle(this.getClass()).getVersion().toString();
	}

	public boolean isIncludeNasdanika() {
		return true;
	}

	public boolean isIncludeEquinox() {
		return true;
	}

	public boolean isIncludeWebTest() {		
		return projectsPage.btnTests.getSelection()
				|| projectsPage.btnActorSpec.getSelection()
				|| projectsPage.btnPageSpec.getSelection()
				|| projectsPage.btnActorImpl.getSelection()
				|| projectsPage.btnPageImpl.getSelection();
	}

	public boolean isIncludeCdo() {
		return projectsPage.btnApplication.getSelection() &&
				(applicationConfigurationPage.btnRepository.getSelection()
						|| applicationConfigurationPage.btnServer.getSelection()
						|| applicationConfigurationPage.btnSessionInitializer.getSelection()
						|| applicationConfigurationPage.btnTransactionContextProvider.getSelection()
						|| applicationConfigurationPage.btnTransactionRoute.getSelection());
	}
	
}