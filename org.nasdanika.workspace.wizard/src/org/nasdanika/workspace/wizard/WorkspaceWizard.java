package org.nasdanika.workspace.wizard;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.feature.FeatureChild;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.pde.internal.ui.wizards.feature.CreateFeatureProjectOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.nasdanika.workspace.wizard.render.app.ApplicationPluginRenderer;
import org.nasdanika.workspace.wizard.render.app.ApplicationPomRenderer;
import org.nasdanika.workspace.wizard.render.app.CDOTransactionContextProviderComponentRenderer;
import org.nasdanika.workspace.wizard.render.app.CDOTransactionContextProviderRenderer;
import org.nasdanika.workspace.wizard.render.app.DocAppRouteRenderer;
import org.nasdanika.workspace.wizard.render.app.DocRouteRenderer;
import org.nasdanika.workspace.wizard.render.app.IndexRenderer;
import org.nasdanika.workspace.wizard.render.app.RepositoryRenderer;
import org.nasdanika.workspace.wizard.render.app.RequireConfigRenderer;
import org.nasdanika.workspace.wizard.render.app.RouteRenderer;
import org.nasdanika.workspace.wizard.render.app.SecurityPolicyRenderer;
import org.nasdanika.workspace.wizard.render.app.ServerRenderer;
import org.nasdanika.workspace.wizard.render.app.SessionInitializerComponentRenderer;
import org.nasdanika.workspace.wizard.render.app.SessionInitializerRenderer;
import org.nasdanika.workspace.wizard.render.app.SetDimensionsScriptRenderer;
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
		generateTestsFeatureProject(progressMonitor);
		generateParentProject(progressMonitor);
		generateRepositoryProject(progressMonitor);
		generateAggregatorProject(progressMonitor);
		generateActorSpecProject(progressMonitor);
		generateActorImplProject(progressMonitor);
		generatePageSpecProject(progressMonitor);
		generatePageImplProject(progressMonitor);
		generateTargetProject(progressMonitor);
	}

	private void generateActorSpecProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnActorSpec.getSelection()) {
			IJavaProject project = createPluginProject(
					getActorSpecArtifactId(), 
					Collections.singletonList((projectsPage.btnPageSpec.getSelection() ? getPageSpecArtifactId() : "org.nasdanika.webtest")+";visibility:=reexport"), 
					Collections.<String>emptyList(), 
					Collections.singletonList(getActorSpecArtifactId()), 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					false,
					progressMonitor);
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new ActorSpecPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getActorSpecArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"ActorFactory.java", new ActorFactorySpecRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"Actor.java", new ActorSpecRenderer().generate(this), false, progressMonitor);			
		}
	}

	private void generatePageSpecProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnPageSpec.getSelection()) {
			IJavaProject project = createPluginProject(
					getPageSpecArtifactId(), 
					Collections.singletonList("org.nasdanika.webtest;visibility:=reexport"), 
					Collections.<String>emptyList(), 
					Collections.singletonList(getPageSpecArtifactId()), 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					false,
					progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new PageSpecPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getPageSpecArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"PageFactory.java", new PageFactorySpecRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"Page.java", new PageSpecRenderer().generate(this), false, progressMonitor);			
		}
	}

	private void generateActorImplProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnActorImpl.getSelection()) {
			Set<String> requiredBundles = new HashSet<>();
			requiredBundles.add("org.eclipse.osgi.services");
			requiredBundles.add((projectsPage.btnActorSpec.getSelection() ? getActorSpecArtifactId() : "org.nasdanika.webtest")+";visibility:=reexport");
			IJavaProject project = createPluginProject(
					getActorImplArtifactId(), 
					requiredBundles, 
					Collections.<String>emptyList(), 
					Collections.singleton(getActorImplArtifactId()), 
					Collections.singleton("OSGI-INF/"+getDashedName()+"-actor-factory.xml"), 
					Collections.singleton("OSGI-INF/"+getDashedName()+"-actor-factory.xml"), 
					false,
					progressMonitor);
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new ActorImplPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getActorImplArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"ActorFactoryImpl.java", new ActorFactoryImplRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"ActorImpl.java", new ActorImplRenderer().generate(this), false, progressMonitor);			
				
			IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
			if (!osgiInfFolder.exists()) {
				osgiInfFolder.create(false, true, progressMonitor);
			}
			osgiInfFolder.getFile(getDashedName()+"-actor-factory.xml").create(new ByteArrayInputStream(new ActorFactoryComponentRenderer().generate(this).getBytes()), false, progressMonitor);										
		}
	}

	private void generatePageImplProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnPageImpl.getSelection()) {
			Set<String> requiredBundles = new HashSet<>();
			requiredBundles.add("org.eclipse.osgi.services");
			requiredBundles.add((projectsPage.btnPageSpec.getSelection() ? getPageSpecArtifactId() : "org.nasdanika.webtest")+";visibility:=reexport");
			IJavaProject project = createPluginProject(
					getPageImplArtifactId(), 
					requiredBundles, 
					Collections.<String>emptyList(), 
					Collections.singleton(getPageImplArtifactId()), 
					Collections.singleton("OSGI-INF/"+getDashedName()+"-page-factory.xml"), 
					Collections.singleton("OSGI-INF/"+getDashedName()+"-page-factory.xml"), 
					false,
					progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new PageImplPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getPageImplArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"PageFactoryImpl.java", new PageFactoryImplRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"PageImpl.java", new PageImplRenderer().generate(this), false, progressMonitor);			
				
			IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
			if (!osgiInfFolder.exists()) {
				osgiInfFolder.create(false, true, progressMonitor);
			}
			osgiInfFolder.getFile(getDashedName()+"-page-factory.xml").create(new ByteArrayInputStream(new PageFactoryComponentRenderer().generate(this).getBytes()), false, progressMonitor);										
		}
	}

	private void generateApplicationProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnApplication.getSelection()) {
			Collection<String> requiredBundles = new HashSet<>();
			
			if (projectsPage.btnModel.getSelection()) {
				requiredBundles.add(getModelArtifactId());
			}
			if (applicationConfigurationPage.btnRepository.getSelection()) {
				requiredBundles.add("org.nasdanika.cdo.h2");
			}
			if (applicationConfigurationPage.btnServer.getSelection()) {
				requiredBundles.add("org.nasdanika.cdo");
			}
			if (applicationConfigurationPage.btnRoutingServlet.getSelection()
					|| applicationConfigurationPage.btnWebContent.getSelection()) {
				// requiredBundles.add("org.nasdanika.web"); - cdo.web re-exports web.				
				requiredBundles.add("org.nasdanika.cdo.web");				
				requiredBundles.add("org.eclipse.equinox.http.registry");				
			}
			if (applicationConfigurationPage.btnSessionInitializer.getSelection()) {
				requiredBundles.add("org.nasdanika.cdo");								
				requiredBundles.add("org.eclipse.emf.cdo");								
				requiredBundles.add("org.eclipse.emf.ecore");								
			}
			if (applicationConfigurationPage.btnDocumentationApplicationRoute.getSelection() || applicationConfigurationPage.btnDocumentationRoute.getSelection()) {
				requiredBundles.add("org.nasdanika.cdo.web.doc");	
				requiredBundles.add("org.apache.commons.lang3;bundle-version=\"3.3.2\"");
			}
			
//			Require-Bundle: org.eclipse.core.runtime;visibility:=reexport,
//					 org.eclipse.emf.ecore.change;bundle-version="2.10.0";visibility:=reexport,
//					 org.eclipse.emf.ecore.xmi;bundle-version="2.10.1";visibility:=reexport,
//					 org.eclipse.net4j;bundle-version="4.3.0";visibility:=reexport,
//					 org.eclipse.emf.cdo.net4j;bundle-version="4.1.200";visibility:=reexport,
//					 org.eclipse.net4j.tcp;bundle-version="4.1.200";visibility:=reexport,
//					 org.eclipse.osgi;bundle-version="3.10.0",
//					 org.eclipse.jetty.util;bundle-version="8.1.14",
//					 org.json;bundle-version="1.0.0",

			Collection<String> binIncludes = new HashSet<String>();
			Collection<String> components = new ArrayList<>();
			if (applicationConfigurationPage.btnSessionInitializer.getSelection()) {
				components.add("OSGI-INF/"+getDashedName()+"-session-initializer.xml");
				binIncludes.add("OSGI-INF/");
			}
			if (applicationConfigurationPage.btnRepository.getSelection()) {
				components.add("OSGI-INF/"+getDashedName()+"-repository.xml");
				binIncludes.add("OSGI-INF/");
			}
			if (applicationConfigurationPage.btnServer.getSelection()) {				
				components.add("OSGI-INF/"+getDashedName()+(applicationConfigurationPage.btnRepository.getSelection() ? "-server.xml" : "-session-provider.xml"));
				binIncludes.add("OSGI-INF/");
			}
			if (applicationConfigurationPage.btnTransactionContextProvider.getSelection()) {
				components.add("OSGI-INF/"+getDashedName()+"-cdo-transaction-context-provider.xml");
				binIncludes.add("OSGI-INF/");
			}
			if (applicationConfigurationPage.btnDocumentationRoute.getSelection()) {
				components.add("OSGI-INF/"+getDashedName()+"-doc-route.xml");
				binIncludes.add("OSGI-INF/");
			}
			if (applicationConfigurationPage.btnWebContent.getSelection()) {
				String webContentBaseName = applicationConfigurationPage.webContentBaseName.getText().trim();
				binIncludes.add(webContentBaseName+"/");
			}
			binIncludes.add("plugin.xml");
			binIncludes.add(getDashedName()+".nasdanika_cdo_security");
			
			String appSuffix = projectsPage.applicationSuffix.getText();
			IJavaProject project = createPluginProject(
					getGroupId()+(appSuffix==null || appSuffix.trim().length()==0 ? "" : "."+appSuffix), 
					requiredBundles, 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					components, 
					binIncludes,
					false,
					progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			if (applicationConfigurationPage.btnSessionInitializer.getSelection()) {
				IFolder sourceFolder = project.getProject().getFolder("src");
				IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getApplicationArtifactId(), false, progressMonitor);
				pkg.createCompilationUnit(getJavaName()+"SessionInitializerComponent.java", new SessionInitializerRenderer().generate(this), false, progressMonitor);
				
				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
				if (!osgiInfFolder.exists()) {
					osgiInfFolder.create(false, true, progressMonitor);
				}
				osgiInfFolder.getFile(getDashedName()+"-session-initializer.xml").create(new ByteArrayInputStream(new SessionInitializerComponentRenderer().generate(this).getBytes()), false, progressMonitor);		
			}
			
			if (applicationConfigurationPage.btnWebContent.getSelection()) {
				try (InputStream resourcesZipStream = new BufferedInputStream(this.getClass().getResourceAsStream("WebContent.zip"))) {
					if (resourcesZipStream!=null) {
						try (ZipInputStream resourceStream = new ZipInputStream(resourcesZipStream)) {
							ZipEntry entry;
							while ((entry = resourceStream.getNextEntry())!=null) {
								String entryPath = applicationConfigurationPage.webContentBaseName.getText().trim();
								if (entryPath.length()==0) {
									entryPath = entry.getName();
								} else {
									entryPath += "/" + entry.getName();
								}
								if (entry.isDirectory()) {
									createResource(project.getProject(), entryPath, null, progressMonitor);
								} else {
									createResource(
											project.getProject(), 
											entryPath, 
											new FilterInputStream(resourceStream) {
												
												@Override
												public void close()	throws IOException {
													// NOP.
												}
												
											}, 
											progressMonitor);
								}
							}
						}
					}
				}
				
				if (applicationConfigurationPage.btnRoutingServlet.getSelection()) {
					IFile target = project.getProject().getFile(applicationConfigurationPage.webContentBaseName.getText().trim()+"/index.html");	
					target.create(new ByteArrayInputStream(new IndexRenderer().generate(this).getBytes()), false, progressMonitor);		
				}	
				if (applicationConfigurationPage.btnDocumentationApplicationRoute.getSelection() || applicationConfigurationPage.btnDocumentationRoute.getSelection()) {
					IFile target = project.getProject().getFile(applicationConfigurationPage.webContentBaseName.getText().trim()+"/js/domReady.js");	
					target.create(getClass().getResourceAsStream("resources/domReady.js"), false, progressMonitor);		
				}	
								
				IFile target = project.getProject().getFile(applicationConfigurationPage.webContentBaseName.getText().trim()+"/js/require-config.js");	
				target.create(new ByteArrayInputStream(new RequireConfigRenderer().generate(this).getBytes()), false, progressMonitor);						
			}
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new ApplicationPomRenderer().generate(this).getBytes()), false, progressMonitor);		
			project.getProject().getFile("plugin.xml").create(new ByteArrayInputStream(new ApplicationPluginRenderer().generate(this).getBytes()), false, progressMonitor);		
			project.getProject().getFile(getDashedName()+".nasdanika_cdo_security").create(new ByteArrayInputStream(new SecurityPolicyRenderer().generate(this).getBytes()), false, progressMonitor);		

			if (applicationConfigurationPage.btnRepository.getSelection()) {
				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
				if (!osgiInfFolder.exists()) {
					osgiInfFolder.create(false, true, progressMonitor);
				}
				osgiInfFolder.getFile(getDashedName()+"-repository.xml").create(new ByteArrayInputStream(new RepositoryRenderer().generate(this).getBytes()), false, progressMonitor);						
			}
			if (applicationConfigurationPage.btnServer.getSelection()) {
				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
				if (!osgiInfFolder.exists()) {
					osgiInfFolder.create(false, true, progressMonitor);
				}
				osgiInfFolder.getFile(getDashedName()+(applicationConfigurationPage.btnRepository.getSelection() ? "-server.xml" : "-session-provider.xml")).create(new ByteArrayInputStream(new ServerRenderer().generate(this).getBytes()), false, progressMonitor);						
			}
			if (applicationConfigurationPage.btnRoutingServlet.getSelection()) {
				IFolder sourceFolder = project.getProject().getFolder("src");
				IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getApplicationArtifactId(), false, progressMonitor);
				pkg.createCompilationUnit(getJavaName()+"Route.java", new RouteRenderer().generate(this), false, progressMonitor);
			}
			if (applicationConfigurationPage.btnDocumentationApplicationRoute.getSelection()) {
				IFolder sourceFolder = project.getProject().getFolder("src");
				IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getApplicationArtifactId(), false, progressMonitor);
				pkg.createCompilationUnit(getJavaName()+"DocAppRoute.java", new DocAppRouteRenderer().generate(this), false, progressMonitor);
				IFolder iFolder = (IFolder) pkg.getResource();
				iFolder.getFile("Splitter.js").create(getClass().getResourceAsStream("resources/Splitter.js"), false, progressMonitor);
				iFolder.getFile("Scroller.js").create(getClass().getResourceAsStream("resources/Scroller.js"), false, progressMonitor);
				iFolder.getFile("SetDimensions.js").create(new ByteArrayInputStream(new SetDimensionsScriptRenderer().generate(this).getBytes()), false, progressMonitor);
			}	

			if (applicationConfigurationPage.btnTransactionContextProvider.getSelection()) {
				IFolder sourceFolder = project.getProject().getFolder("src");
				IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getApplicationArtifactId(), false, progressMonitor);
				pkg.createCompilationUnit(getJavaName()+"CDOTransactionContextProviderComponent.java", new CDOTransactionContextProviderRenderer().generate(this), false, progressMonitor);
				
				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
				if (!osgiInfFolder.exists()) {
					osgiInfFolder.create(false, true, progressMonitor);
				}
				osgiInfFolder.getFile(getDashedName()+"-cdo-transaction-context-provider.xml").create(new ByteArrayInputStream(new CDOTransactionContextProviderComponentRenderer().generate(this).getBytes()), false, progressMonitor);										
			}
//			if (applicationConfigurationPage.btnTransactionRoute.getSelection()) {
//				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
//				if (!osgiInfFolder.exists()) {
//					osgiInfFolder.create(false, true, progressMonitor);
//				}
//				osgiInfFolder.getFile(getDashedName()+"-cdo-transaction-context-route.xml").create(new ByteArrayInputStream(new CDOTransactionContextRouteRenderer().generate(this).getBytes()), false, progressMonitor);														
//			}
			if (applicationConfigurationPage.btnDocumentationRoute.getSelection()) {
				IFolder osgiInfFolder = project.getProject().getFolder("OSGI-INF");
				if (!osgiInfFolder.exists()) {
					osgiInfFolder.create(false, true, progressMonitor);
				}
				osgiInfFolder.getFile(getDashedName()+"-doc-route.xml").create(new ByteArrayInputStream(new DocRouteRenderer().generate(this).getBytes()), false, progressMonitor);														
			}
			
		}
	}
	
	public boolean isRepositoryComponent() {
		return applicationConfigurationPage.btnRepository.getSelection();
	}
	
	private IResource createResource(IProject project, String path, InputStream content, IProgressMonitor progressMonitor) throws CoreException {
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

	private void generateTestsProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnTests.getSelection()) {
			Collection<String> requiredBundles = new HashSet<>();
			
			if (projectsPage.btnActorSpec.getSelection()) {
				requiredBundles.add(getActorSpecArtifactId());
			} else if (projectsPage.btnPageSpec.getSelection()) {
				requiredBundles.add(getPageSpecArtifactId());
			}
			
			if (projectsPage.btnActorImpl.getSelection()) {
				requiredBundles.add(getActorImplArtifactId());
			} 
			if (projectsPage.btnPageImpl.getSelection()) {
				requiredBundles.add(getPageImplArtifactId());
			}

			Collection<String> binIncludes = new HashSet<String>();
			if (projectsPage.btnApplication.getSelection()) {
				binIncludes.add("fragment.xml");
			} else {
				binIncludes.add("plugin.xml");
				requiredBundles.add("org.eclipse.equinox.app");
				requiredBundles.add("org.nasdanika.html");
			}
			
			IJavaProject project = createPluginProject(
					getTestsArtifactId(), 
					requiredBundles, 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					binIncludes,
					projectsPage.btnApplication.getSelection(),
					progressMonitor);
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getTestsArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"TestRunner.java", new TestRunnerRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"Test.java", new TestRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"RouteTest.java", new RouteTestRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"Tests.java", new TestSuiteRenderer().generate(this), false, progressMonitor);
			
			if (projectsPage.btnApplication.getSelection()) {
				project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new TestFragmentPomRenderer().generate(this).getBytes()), false, progressMonitor);
				project.getProject().getFile("fragment.xml").create(new ByteArrayInputStream(new TestFragmentRenderer().generate(this).getBytes()), false, progressMonitor);
			} else {
				project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new TestAppPomRenderer().generate(this).getBytes()), false, progressMonitor);
				project.getProject().getFile("plugin.xml").create(new ByteArrayInputStream(new TestPluginRenderer().generate(this).getBytes()), false, progressMonitor);
			}
		}
	}

	private void generateFeatureProject(IProgressMonitor progressMonitor) throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(getGroupId()+".feature");
		
		IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}
		
		IPath location = generalInformationPage.getLocationPath();
		if (!Platform.getLocation().equals(location)) {
			location = location.append(getGroupId()+".feature");
		}
		FeatureData featureData = new FeatureData();
		featureData.id = getGroupId()+".feature";
		featureData.name = generalInformationPage.nameField.getText()+" feature";
		featureData.version = getVersion()+".qualifier";
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
				
				if (!shallGenerateTestsFeature()) {
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
				
				if (!shallGenerateTestsFeature() && isIncludeWebTest()) {
					FeatureChild fChild = (FeatureChild) model.getFactory().createChild();
					fChild.setVersion("0.0.0");
					fChild.setId("org.nasdanika.webtest.feature");
					includedFeatures.add(fChild);
				}
				
				feature.addIncludedFeatures(includedFeatures.toArray(new FeatureChild[includedFeatures.size()]));
			};
			
		}.execute(progressMonitor);				
	}

	private void generateTestsFeatureProject(IProgressMonitor progressMonitor) throws Exception {
		if (shallGenerateTestsFeature()) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(getTestsArtifactId()+".feature");
			IPath location = generalInformationPage.getLocationPath();
			if (!Platform.getLocation().equals(location)) {
				location = location.append(getTestsArtifactId()+".feature");
			}
			
			IWorkingSet[] workingSets = generalInformationPage.getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
			}
			
			FeatureData featureData = new FeatureData();
			featureData.id = getTestsArtifactId()+".feature";
			featureData.name = generalInformationPage.nameField.getText()+" tests feature";
			featureData.version = getVersion()+".qualifier";
			new CreateFeatureProjectOperation(project, location, featureData, null, getShell()) {
				
				@Override
				protected void execute(IProgressMonitor monitor) throws CoreException ,InvocationTargetException ,InterruptedException {
					super.execute(monitor);
					addMaven2NatureAndBuilder(monitor, fProject);
	
					try {
						fProject.getFile("pom.xml").create(new ByteArrayInputStream(new TestFeaturePomRenderer().generate(WorkspaceWizard.this).getBytes()), false, monitor);
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
					
					if (projectsPage.btnTests.getSelection()) {
						FeaturePlugin fplugin = (FeaturePlugin) model.getFactory().createPlugin();
						fplugin.setId(getTestsArtifactId());
						fplugin.setVersion("0.0.0");
						if (projectsPage.btnApplication.getSelection()) {
							fplugin.setFragment(true);
						}
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
					
					FeatureChild mainFeature = (FeatureChild) model.getFactory().createChild();
					mainFeature.setVersion("0.0.0");
					mainFeature.setId(getGroupId()+".feature");
					includedFeatures.add(mainFeature);
					
					FeatureChild webTestFeature = (FeatureChild) model.getFactory().createChild();
					webTestFeature.setVersion("0.0.0");
					webTestFeature.setId("org.nasdanika.webtest.feature");
					includedFeatures.add(webTestFeature);
					
					feature.addIncludedFeatures(includedFeatures.toArray(new FeatureChild[includedFeatures.size()]));
				};
				
			}.execute(progressMonitor);
		}
	}

	private boolean shallGenerateTestsFeature() {
		return projectsPage.btnTests.getSelection() && projectsPage.btnApplication.getSelection();
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

		project.getFile("pom.xml").create(new ByteArrayInputStream(new RepositoryPomRenderer().generate(this).getBytes()), false, progressMonitor);
		project.getFile("category.xml").create(new ByteArrayInputStream(new CategoryRenderer().generate(this).getBytes()), false, progressMonitor);
		project.getFile(getGroupId()+".product").create(new ByteArrayInputStream(new ProductRenderer().generate(this).getBytes()), false, progressMonitor);
		if (shallGenerateTestsFeature()) {
			project.getFile(getTestsArtifactId()+".product").create(new ByteArrayInputStream(new TestsProductRenderer().generate(this).getBytes()), false, progressMonitor);			
		}
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
		
		IFile targetFile = project.getFile(getGroupId()+".target.target");	
//		target.create(new ByteArrayInputStream(new TargetRenderer().generate(this).getBytes()), false, progressMonitor);
		
		org.eclipse.pde.core.target.ITargetPlatformService service = (ITargetPlatformService) PDECore.getDefault().acquireService(ITargetPlatformService.class.getName());
		
		List<String> versions = new ArrayList<>();
		List<String> unitIds = new ArrayList<>();
		String version = FrameworkUtil.getBundle(this.getClass()).getVersion().toString();
		if (isIncludeJetty()) { 
			unitIds.add("org.nasdanika.server.jetty.feature.feature.group");
			versions.add(version);
		}
		if (isIncludeNasdanika()) { 
			unitIds.add("org.nasdanika.feature.feature.group");
			versions.add(version);
		}
		if (isIncludeEquinox()) { 
			unitIds.add("org.nasdanika.equinox.feature.feature.group");
			versions.add(version);
		}
		if (isIncludeWebTest()) { 
			unitIds.add("org.nasdanika.webtest.feature.feature.group");
			versions.add(version);
		}
		if (isIncludeCdo()) { 
			unitIds.add("org.nasdanika.cdo.feature.feature.group");
			versions.add(version);
		}
		
		java.net.URI[] repositories = { new java.net.URI("http://www.nasdanika.org/server/repository") };
		int resolutionFlags = IUBundleContainer.INCLUDE_SOURCE; // | IUBundleContainer.INCLUDE_REQUIRED;		
		
		ITargetLocation targetLocation = service.newIULocation(unitIds.toArray(new String[unitIds.size()]), versions.toArray(new String[versions.size()]), repositories, resolutionFlags);			

		ITargetDefinition targetDefinition = service.getTarget(targetFile).getTargetDefinition();
		targetDefinition.setTargetLocations(new ITargetLocation[] { targetLocation });
		targetDefinition.setName(getGroupId()+".target");
		
		service.saveTargetDefinition(targetDefinition);
		//org.eclipse.pde.core.target.ITargetDefinition targetDefinition = service.getTarget(target).getTargetDefinition();
//		for (ITargetLocation tl: targetDefinition.getTargetLocations()) {
//			tl.resolve(targetDefinition, progressMonitor);
//		}
		IStatus rs = targetDefinition.resolve(progressMonitor);
		System.out.println(rs);
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
			manifest.print(CodeGenUtil.validPluginID(genModelContainerPath.segment(0)));
			manifest.println("; singleton:=true");
			manifest.println("Bundle-Version: "+getVersion()+".qualifier");
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
			
			project.getFile("build.properties").create(new ByteArrayInputStream(new ModelBuildPropertiesRenderer().generate(this).getBytes()), false, progressMonitor);
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
	
	public boolean isApplication() {
		return projectsPage.btnApplication.getSelection() || projectsPage.btnModel.getSelection();
	}
	
	public boolean isCdoTransactionContextProvider() {
		return applicationConfigurationPage.btnTransactionContextProvider.getSelection();
	}

	public String getTestsArtifactId() {		
		return projectsPage.testsSuffix.getText().trim().length()==0 ? 
				generalInformationPage.groupIdField.getText() 
				: generalInformationPage.groupIdField.getText()+"."+projectsPage.testsSuffix.getText();
	}
	
	public boolean isTests() {
		return projectsPage.btnTests.getSelection();
	}

	public String getActorSpecArtifactId() {
		if (!projectsPage.btnActorSpec.getSelection()) {
			return null;
		}
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
		if (!projectsPage.btnPageSpec.getSelection()) {
			return null;
		}
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
		if (!projectsPage.btnActorImpl.getSelection()) {
			return null;
		}
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
		if (!projectsPage.btnPageImpl.getSelection()) {
			return null;
		}
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

		if (projectsPage.btnModel.getSelection()) {
			ret.add(getModelArtifactId());
		}
				
		if (projectsPage.btnApplication.getSelection()) {
			ret.add(getApplicationArtifactId());
		}
		
		if (projectsPage.btnTests.getSelection()) {
			ret.add(getTestsArtifactId());
		}
		
		if (shallGenerateTestsFeature()) {
			ret.add(getTestsArtifactId()+".feature");			
		}
		
		//ret.add(getGroupId()+".target");
		ret.add(getGroupId()+".feature");
		ret.add(getGroupId()+".repository");								
		return ret;
	}
	
	private IJavaProject createPluginProject(
			final String name,
			Iterable<String> requiredBundles,
			Collection<String> importedPackages, 
			Collection<String> exportedPackages, 
			Collection<String> serviceComponents,
			Collection<String> binIncludes,
			boolean fragment,
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
				fragment,
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

	private void createManifest(
			String projectName, 
			Iterable<String> requiredBundles,
			Collection<String> importedPackages,
			Collection<String> exportedPackages, 
			Collection<String> serviceComponents,
			boolean fragment,
			IProgressMonitor progressMonitor, 
			IProject project) throws Exception {
		StringBuilder manifestBuilder = new StringBuilder("Manifest-Version: 1.0").append(System.lineSeparator());
		manifestBuilder.append("Bundle-ManifestVersion: 2").append(System.lineSeparator());
		manifestBuilder.append("Bundle-Name: " + projectName).append(System.lineSeparator());
		manifestBuilder.append("Bundle-SymbolicName: " + projectName + "; singleton:=true").append(System.lineSeparator()); // TODO - Singleton?
		manifestBuilder.append("Bundle-Version: ").append(getVersion()).append(".qualifier").append(System.lineSeparator());
		if (fragment) {
			manifestBuilder.append("Fragment-Host: ")
				.append(getApplicationArtifactId())
				.append(";bundle-version=\"")
				.append(getVersion())
				.append("\"")
				.append(System.lineSeparator());
		}
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
		return isApplication();
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
						|| applicationConfigurationPage.btnTransactionContextProvider.getSelection());
	}

	public String getName() {		
		return generalInformationPage.nameField.getText();
	}

	public Object getApplicationPlugin() {
		if (projectsPage.btnApplication.getSelection()) {
			return getApplicationArtifactId();
		}
		if (projectsPage.btnTests.getSelection()) {
			return getTestsArtifactId();
		}
		return null;
	}

	public String getRoutingServletAlias() {
		return applicationConfigurationPage.btnRoutingServlet.getSelection() ? applicationConfigurationPage.routingServletAlias.getText() : null;
	}

	public String getWebContentAlias() {
		String ret = applicationConfigurationPage.btnWebContent.getSelection() ? applicationConfigurationPage.webContentAlias.getText() : null;
		return ret==null || ret.endsWith("/") ? ret : ret+"/";
	}

	public String getWebContentBaseName() {
		return applicationConfigurationPage.btnWebContent.getSelection() ? applicationConfigurationPage.webContentBaseName.getText() : null;
	}

	public String getSessionServletAlias() {		
		return applicationConfigurationPage.btnWebsocketSessionServlet.getSelection() ? applicationConfigurationPage.sessionServletAlias.getText() : null;
	}
	
	public String getContextPath() {
		String text = applicationConfigurationPage.contextPathText.getText();
		return text==null || text.trim().length()==0 ? null : text;		
	}
	
	public String getHttpContextId() {
		String text = applicationConfigurationPage.httpContextIdText.getText();
		return text==null || text.trim().length()==0 ? null : text;
	}
	
	public String getDocRoutePath() {
		return applicationConfigurationPage.btnDocumentationRoute.getSelection() ? applicationConfigurationPage.documentationRoutePathText.getText() : null;
	}
	
	public String getDocAppRoutePattern() {
		return applicationConfigurationPage.btnDocumentationApplicationRoute.getSelection() ? applicationConfigurationPage.docAppRoutePatternText.getText() : null;
	}

	public String getDocAppRoutePath() {
		String pattern = getDocAppRoutePattern();
		return pattern==null ? pattern : pattern.replace("\\.", ".");
	}
	
	@Override
	public boolean canFinish() {		
		// Got to go to the end of the wizard.
		return !getContainer().getCurrentPage().canFlipToNextPage();
	}
	
}