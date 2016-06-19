package org.nasdanika.workspace.wizard;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.nasdanika.workspace.wizard.render.DocPomRenderer;

/**
 * Base class for wizards generating Tycho-built workspaces.
 * @author Pavel Vlasov
 *
 */
public abstract class AbstractWorkspaceWizard extends Wizard implements INewWizard {
	protected static final String MAVEN_2_BUILDER = "org.eclipse.m2e.core.maven2Builder";
	protected static final String MAVEN_2_NATURE_ID = "org.eclipse.m2e.core.maven2Nature";
	private GeneralInformationPage generalInformationPage;
	
	protected IWorkbench workbench;
	protected IStructuredSelection selection;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	@Override
	public void addPages() {
		generalInformationPage = new GeneralInformationPage(selection, "GeneralInformation");

		generalInformationPage.setTitle("General information");
		generalInformationPage.setDescription("Group Id (umbrella name), version, working set");
		addPage(generalInformationPage);			
	}

	@Override
	public boolean performFinish() {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					modifyWorkspace(progressMonitor);
				} catch (CoreException exception) {
					ErrorDialog.openError(getShell(), "Error generating workspace", exception.toString(), exception.getStatus());
					GenModelEditPlugin.INSTANCE.log(exception);
				} catch (Exception exception) {
					MessageDialog.openError(getShell(), "Error generating workspace", exception.toString());
					GenModelEditPlugin.INSTANCE.log(exception);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (Exception exception) {
			MessageDialog.openError(getShell(), "Error generating workspace", exception.toString());
			GenModelEditPlugin.INSTANCE.log(exception);
			return false;
		}

		return true;
	}
	
	protected void modifyWorkspace(IProgressMonitor progressMonitor) throws Exception {
		generateParentProject(progressMonitor);
		generateRepositoryProject(progressMonitor);
		generateAggregatorProject(progressMonitor);
		generateTargetProject(progressMonitor);
	}
	
	public IResource createResource(IProject project, String path, InputStream content, IProgressMonitor progressMonitor) throws CoreException {
		while (path.endsWith("/")) {
			path = path.substring(0, path.length()-1);
		}
		int idx = path.lastIndexOf('/');
		IContainer container = idx==-1 ? project : (IContainer) createResource(project, path.substring(0, idx), null, progressMonitor);
		if (content==null) {
			IFolder ret = container.getFolder(new Path(path.substring(idx+1)));
			if (!ret.exists()) {
				ret.create(false, true, progressMonitor);
			}
			return ret;
		}
		IFile ret = container.getFile(new Path(path.substring(idx+1)));
		ret.create(content, true, progressMonitor);
		return ret;
	}

	public String getJavaName() {
		String[] tokens = generalInformationPage.nameField.getText().split(" ");
		for (int i=0; i<tokens.length; ++i) {
			tokens[i] = StringUtils.capitalize(tokens[i]);
		}
		return StringUtils.join(tokens);
	}

	public String getDashedName() {
		return generalInformationPage.nameField.getText().toLowerCase().replace(' ', '-');
	}

	protected void generateParentProject(IProgressMonitor progressMonitor) throws Exception {
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

	protected void generateAggregatorProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(getParentArtifactId());
		IPath locationPath = generalInformationPage.getLocationPath();
		description.setLocationURI(Platform.getLocation().equals(locationPath) ? null : locationPath.append(getAggregatorArtifactId()).toFile().toURI());
		description.setNatureIds(new String[] { MAVEN_2_NATURE_ID });
		
		final ICommand m2 = description.newCommand();
        m2.setBuilderName(MAVEN_2_BUILDER);
        description.setBuildSpec(new ICommand[] { m2 });

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getAggregatorArtifactId());
		project.create(description, progressMonitor);
		project.open(progressMonitor);
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}

		IFile pom = project.getFile("pom.xml");	
		pom.create(new ByteArrayInputStream(new AggregatorPomRenderer().generate(this).getBytes()), false, progressMonitor);
	}

	public String getAggregatorArtifactId() {
		return getGroupId()+".aggregator";
	}
	
	/**
	 * @return Collection of feature ID's to be included into the category file.
	 */
	public abstract Collection<String> getCategorizedFeatures();
	
	/**
	 * @return Collection of products to be materialized.
	 */
	public abstract Collection<String> getProductsToMaterialize();

	protected IProject generateRepositoryProject(IProgressMonitor progressMonitor) throws Exception {
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

		project.getFile("pom.xml").create(new ByteArrayInputStream(new RepositoryPomRenderer().generate(this).getBytes()), false, progressMonitor);
		if (!getCategorizedFeatures().isEmpty()) {
			project.getFile("category.xml").create(new ByteArrayInputStream(new CategoryRenderer().generate(this).getBytes()), false, progressMonitor);
		}
		return project;
	}
	
	/**
	 * @return A collection of two-element arrays with Unit ID at index 0, and version at index 1.
	 */
	protected abstract Collection<String[]> getTargetUnits();
	
	/**
	 * 
	 * @return List of p2 repositories to add to target and parent pom.
	 */
	public abstract Map<String, String> getRepositories();
	
	protected void generateTargetProject(IProgressMonitor progressMonitor) throws Exception {
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
		
		IFile targetFile = project.getFile(getGroupId()+".target");	
//		target.create(new ByteArrayInputStream(new TargetRenderer().generate(this).getBytes()), false, progressMonitor);
		
		org.eclipse.pde.core.target.ITargetPlatformService service = (ITargetPlatformService) PDECore.getDefault().acquireService(ITargetPlatformService.class.getName());
		
		ITargetDefinition targetDefinition = service.getTarget(targetFile).getTargetDefinition();
		targetDefinition.setTargetLocations(new ITargetLocation[] { 
				createNasdanikaServerTargetLocation(service),
				createMavenOsgiTargetLocation(service) });
		targetDefinition.setName(getGroupId()+".target");
		
		service.saveTargetDefinition(targetDefinition);
		//org.eclipse.pde.core.target.ITargetDefinition targetDefinition = service.getTarget(target).getTargetDefinition();
//		for (ITargetLocation tl: targetDefinition.getTargetLocations()) {
//			tl.resolve(targetDefinition, progressMonitor);
//		}
		IStatus rs = targetDefinition.resolve(progressMonitor);
		System.out.println(rs);
	}

	private ITargetLocation createNasdanikaServerTargetLocation(org.eclipse.pde.core.target.ITargetPlatformService service) throws URISyntaxException {
		List<String> versions = new ArrayList<>();
		List<String> unitIds = new ArrayList<>();
		for (String[] unitEntry: getTargetUnits()) {
			unitIds.add(unitEntry[0]);
			versions.add(unitEntry[1]);			
		}
		
		int resolutionFlags = IUBundleContainer.INCLUDE_SOURCE; // | IUBundleContainer.INCLUDE_REQUIRED;		
		return service.newIULocation(
				unitIds.toArray(new String[unitIds.size()]), 
				versions.toArray(new String[versions.size()]), 
				new java.net.URI[] { new java.net.URI("http://www.nasdanika.org/server/repository") }, 
				resolutionFlags);
	}
	
	private ITargetLocation createMavenOsgiTargetLocation(org.eclipse.pde.core.target.ITargetPlatformService service) throws URISyntaxException {
		
//		repoMap.put("mars", "http://download.eclipse.org/releases/mars");
//		repoMap.put("orbit", "http://download.eclipse.org/tools/orbit/downloads/drops/R20160221192158/repository");
//		repoMap.put("jetty", "http://download.eclipse.org/jetty/updates/jetty-bundles-9.x/9.3.9.v20160517");
		
		List<String> repos = new ArrayList<>(getRepositories().values());
		java.net.URI[] repositories = new java.net.URI[repos.size()];
		for (int i=0; i<repos.size(); ++i){
			repositories[i] = new java.net.URI(repos.get(i));
		}
		int resolutionFlags = IUBundleContainer.INCLUDE_SOURCE; // | IUBundleContainer.INCLUDE_REQUIRED;		
		
		return service.newIULocation(
				new String[] { "json" }, 
				new String[] { "20160212.0.0" }, 
				new java.net.URI[] { new java.net.URI("http://www.nasdanika.org/maven-osgi") }, 
				resolutionFlags);
	}
	
	
	
	public static void addMaven2NatureAndBuilder(IProgressMonitor progressMonitor, IProject project) throws CoreException {
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

	public String getGroupId() {
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
		
		//ret.add(getGroupId()+".target");
		ret.add(getGroupId()+".feature");
		ret.add(getGroupId()+".repository");										
		//ret.add(getDocArtifactId());
		
		return ret;
	}
	
	public String getDocArtifactId() {
		return getGroupId()+".doc";
	}
	
	
	protected IJavaProject createPluginProject(
			final String name,
			Collection<String> requiredBundles,
			Collection<String> importedPackages, 
			Collection<String> exportedPackages, 
			Collection<String> serviceComponents,
			Collection<String> binIncludes,
			String fragmentHost,
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
		createManifest(
				name, 
				requiredBundles, 
				importedPackages, 
				exportedPackages, 
				serviceComponents,
				fragmentHost,
				progressMonitor, 
				project);
		createBuildProps(progressMonitor, binIncludes, project);
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

	private static void createBuildProps(
			IProgressMonitor progressMonitor, 
			Collection<String> binIncludes, 
			IProject project) throws Exception {
		StringBuilder bpContent = new StringBuilder("source.. = src")
			.append(System.lineSeparator())
			.append("bin.includes = ");
		
		if (binIncludes != null) {
			for (String bi: binIncludes) {
				bpContent.append(bi).append(",");
			}
		}

		bpContent.append("META-INF/,.").append(System.lineSeparator());
		createFile("build.properties", project, bpContent.toString(), progressMonitor);
	}

	protected void createManifest(
			String projectName, 
			Collection<String> requiredBundles,
			Collection<String> importedPackages,
			Collection<String> exportedPackages, 
			Collection<String> serviceComponents,
			String fragmentHost,
			IProgressMonitor progressMonitor, 
			IProject project) throws Exception {
		StringBuilder manifestBuilder = new StringBuilder("Manifest-Version: 1.0").append(System.lineSeparator());
		manifestBuilder.append("Bundle-ManifestVersion: 2").append(System.lineSeparator());
		manifestBuilder.append("Bundle-Name: " + projectName).append(System.lineSeparator());
		manifestBuilder.append("Bundle-SymbolicName: " + projectName + "; singleton:=true").append(System.lineSeparator()); // TODO - Singleton?
		manifestBuilder.append("Bundle-Version: ").append(getVersion()).append(".qualifier").append(System.lineSeparator());
		if (fragmentHost!=null) {
			manifestBuilder.append("Fragment-Host: ")
				.append(fragmentHost)
				.append(";bundle-version=\"")
				.append(getVersion())
				.append("\"")
				.append(System.lineSeparator());
		}
		manifestBuilder.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.8").append(System.lineSeparator());
		if (!requiredBundles.isEmpty()) {
			manifestBuilder.append("Require-Bundle:");
			Iterator<String> rit = requiredBundles.iterator();
			while (rit.hasNext()) {
				manifestBuilder.append(" ").append(rit.next());
				if (rit.hasNext()) {
					manifestBuilder.append(",");				
				}
				manifestBuilder.append(System.lineSeparator());
			}
		}

		if (serviceComponents != null && !serviceComponents.isEmpty()) {
			manifestBuilder.append("Service-Component:");
			Iterator<String> scit = serviceComponents.iterator();
			while (scit.hasNext()) {
				manifestBuilder.append(" ").append(scit.next());
				if (scit.hasNext()) {
					manifestBuilder.append(",");				
				}
				manifestBuilder.append(System.lineSeparator());
			}
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

	public String getName() {		
		return generalInformationPage.nameField.getText();
	}
		
	@Override
	public boolean canFinish() {		
		// Got to go to the end of the wizard.
		return super.canFinish() && !getContainer().getCurrentPage().canFlipToNextPage();
	}
	
	protected IWorkingSet[] getSelectedWorkingSets() {
		return generalInformationPage.getSelectedWorkingSets();
	}

	protected IPath getLocationPath() {
		return generalInformationPage.getLocationPath();
	}

}
