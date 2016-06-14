package org.nasdanika.workspace.wizard;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.internal.core.feature.FeatureChild;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.ui.wizards.feature.CreateFeatureProjectOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
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
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Wizard to create projects for a Nasdanika Foundation Server based application.
 */

public class WorkspaceWizard extends AbstractWorkspaceWizard {
	private ProjectsPage projectsPage;
	private ApplicationConfigurationPage applicationConfigurationPage;
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(GenModelEditPlugin.INSTANCE.getImage("full/wizban/NewEmptyEMFProject")));
		setWindowTitle("New Nasdanika Application Workspace");
	}

	@Override
	public void addPages() {
		super.addPages();
		
		projectsPage = new ProjectsPage();
		addPage(projectsPage);
		
		applicationConfigurationPage = new ApplicationConfigurationPage();
		addPage(applicationConfigurationPage);
	}
	
	public void modifyWorkspace(IProgressMonitor progressMonitor) throws Exception {
		super.modifyWorkspace(progressMonitor);
		
		generateModelProject(progressMonitor);
		
		generateApplicationProject(progressMonitor);
		
		generateFeatureProject(progressMonitor);
		
		generateTestsProject(progressMonitor);
		generateTestsFeatureProject(progressMonitor);
		
		generateActorSpecProject(progressMonitor);
		generateActorImplProject(progressMonitor);
		
		generatePageSpecProject(progressMonitor);
		generatePageImplProject(progressMonitor);
	}

	protected void generateActorSpecProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnActorSpec.getSelection()) {
			IJavaProject project = createPluginProject(
					getActorSpecArtifactId(), 
					Collections.singletonList((projectsPage.btnPageSpec.getSelection() ? getPageSpecArtifactId() : "org.nasdanika.webtest")+";visibility:=reexport"), 
					Collections.<String>emptyList(), 
					Collections.singletonList(getActorSpecArtifactId()), 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					null,
					progressMonitor);
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new ActorSpecPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project.getProject(), workingSets);
			}
			
			IFolder sourceFolder = project.getProject().getFolder("src");
			IPackageFragment pkg = project.getPackageFragmentRoot(sourceFolder).createPackageFragment(getActorSpecArtifactId(), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"ActorFactory.java", new ActorFactorySpecRenderer().generate(this), false, progressMonitor);
			pkg.createCompilationUnit(getJavaName()+"Actor.java", new ActorSpecRenderer().generate(this), false, progressMonitor);			
		}
	}

	protected void generatePageSpecProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnPageSpec.getSelection()) {
			IJavaProject project = createPluginProject(
					getPageSpecArtifactId(), 
					Collections.singletonList("org.nasdanika.webtest;visibility:=reexport"), 
					Collections.<String>emptyList(), 
					Collections.singletonList(getPageSpecArtifactId()), 
					Collections.<String>emptyList(), 
					Collections.<String>emptyList(), 
					null,
					progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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

	protected void generateActorImplProject(IProgressMonitor progressMonitor) throws Exception {
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
					null,
					progressMonitor);
			
			project.getProject().getFile("pom.xml").create(new ByteArrayInputStream(new ActorImplPomRenderer().generate(this).getBytes()), false, progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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

	protected void generatePageImplProject(IProgressMonitor progressMonitor) throws Exception {
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
					null,
					progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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

	protected void generateApplicationProject(IProgressMonitor progressMonitor) throws Exception {
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
					null,
					progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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
				// TODO - load from the web resources bundle.
				Bundle webResourcesBundle = Platform.getBundle("org.nasdanika.web.resources");
				if (webResourcesBundle != null) {
					for (String path: Collections.list(webResourcesBundle.getEntryPaths("/"))) {
						if (!path.startsWith("META-INF/")) {							
							String resourcePath = applicationConfigurationPage.webContentBaseName.getText().trim();
							if (resourcePath.length()==0) {
								resourcePath = path;
							} else {
								resourcePath += "/" + path;
							}
							createResource(
									project.getProject(), 
									resourcePath,
									webResourcesBundle.getResource(path).openStream(), 
									progressMonitor);
						}
					}
				}
				
				if (applicationConfigurationPage.btnRoutingServlet.getSelection()) {
					IFile target = project.getProject().getFile(applicationConfigurationPage.webContentBaseName.getText().trim()+"/index.html");	
					target.create(new ByteArrayInputStream(new IndexRenderer().generate(this).getBytes()), false, progressMonitor);		
				}	
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
				iFolder.getFile("require-config.js").create(new ByteArrayInputStream(new RequireConfigRenderer().generate(this).getBytes()), false, progressMonitor);
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
					projectsPage.btnApplication.getSelection() ? getActorImplArtifactId() : null,
					progressMonitor);
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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
		
		IWorkingSet[] workingSets = getSelectedWorkingSets();
		if (workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
		}
		
		IPath location = getLocationPath();
		if (!Platform.getLocation().equals(location)) {
			location = location.append(getGroupId()+".feature");
		}
		FeatureData featureData = new FeatureData();
		featureData.id = getGroupId()+".feature";
		featureData.name = getName()+" feature";
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
			IPath location = getLocationPath();
			if (!Platform.getLocation().equals(location)) {
				location = location.append(getTestsArtifactId()+".feature");
			}
			
			IWorkingSet[] workingSets = getSelectedWorkingSets();
			if (workingSets != null) {
				workbench.getWorkingSetManager().addToWorkingSets(project, workingSets);
			}
			
			FeatureData featureData = new FeatureData();
			featureData.id = getTestsArtifactId()+".feature";
			featureData.name = getName()+" tests feature";
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
	
	@Override
	public Map<String, String> getRepositories() {
		return Collections.singletonMap("nasdanika-server", "http://www.nasdanika.org/server/repository");
		
//		Map<String, String> repoMap = new HashMap<>();
		
		// Kinda bad style, load from a properties file?
//		repoMap.put("mars", "http://download.eclipse.org/releases/mars");
//		repoMap.put("orbit", "http://download.eclipse.org/tools/orbit/downloads/drops/R20150821153341/repository");
//		repoMap.put("jetty", "http://download.eclipse.org/jetty/updates/jetty-bundles-9.x/9.3.5.v20151012");
//		repoMap.put("maven-osgi", "http://www.nasdanika.org/maven-osgi");
//		repoMap.put("nasdanika-server", "http://www.nasdanika.org/server/repository");
//		return repoMap;
	}
	
	@Override
	public Collection<String> getCategorizedFeatures() {
		return Collections.singleton(getGroupId()+".feature");
	}
	
	@Override
	public Collection<String> getProductsToMaterialize() {
		return Collections.singleton(getGroupId()+".product");
	}

	protected IProject generateRepositoryProject(IProgressMonitor progressMonitor) throws Exception {
		IProject project = super.generateRepositoryProject(progressMonitor);
		
		project.getFile(getGroupId()+".product").create(new ByteArrayInputStream(new ProductRenderer().generate(this).getBytes()), false, progressMonitor);
		if (shallGenerateTestsFeature()) {
			project.getFile(getTestsArtifactId()+".product").create(new ByteArrayInputStream(new TestsProductRenderer().generate(this).getBytes()), false, progressMonitor);			
		}
		
		return project;
	}
	
	@Override
	protected Collection<String[]> getTargetUnits() {
		Collection<String[]> ret = new ArrayList<String[]>();
		String version = FrameworkUtil.getBundle(this.getClass()).getVersion().toString();
		if (isIncludeJetty()) {
			ret.add(new String[] {"org.nasdanika.server.jetty.feature.feature.group", version});
		}
		if (isIncludeNasdanika()) { 
			ret.add(new String[] {"org.nasdanika.feature.feature.group", version});
		}
		if (isIncludeEquinox()) { 
			ret.add(new String[] {"org.nasdanika.equinox.feature.feature.group", version});
		}
		if (isIncludeWebTest()) { 
			ret.add(new String[] {"org.nasdanika.webtest.feature.feature.group", version});
		}
		if (isIncludeCdo()) { 
			ret.add(new String[] {"org.nasdanika.cdo.feature.feature.group", version});
		}
		
		return ret;
	}	

	private void generateModelProject(IProgressMonitor progressMonitor) throws Exception {
		if (projectsPage.btnModel.getSelection()) {
			IPath genModelContainerPath = ResourcesPlugin.getWorkspace().getRoot().getProject(getModelArtifactId()).getFullPath().append("src");
			IPath locationPath = getLocationPath();
			IPath genModelProjectLocation = Platform.getLocation().equals(locationPath) ? null : locationPath.append(getModelArtifactId());
			IProject project = Generator.createEMFProject(
					new Path(genModelContainerPath.toString()),
					genModelProjectLocation, Collections.<IProject> emptyList(),
					progressMonitor, Generator.EMF_MODEL_PROJECT_STYLE| Generator.EMF_PLUGIN_PROJECT_STYLE);
	
			IWorkingSet[] workingSets = getSelectedWorkingSets();
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

	protected String[] getRequiredBundles() {
		return new String[] { "org.eclipse.emf.ecore" };
	}

	public String getModelArtifactId() {		
		return projectsPage.modelSuffix.getText().trim().length()==0 ? 
				getGroupId() 
				: getGroupId() + "."+projectsPage.modelSuffix.getText();
	}

	public String getApplicationArtifactId() {		
		return projectsPage.applicationSuffix.getText().trim().length()==0 ? 
				getGroupId() 
				: getGroupId()+"."+projectsPage.applicationSuffix.getText();
	}
	
	public boolean isApplication() {
		return projectsPage.btnApplication.getSelection() || projectsPage.btnModel.getSelection();
	}
	
	public boolean isCdoTransactionContextProvider() {
		return applicationConfigurationPage.btnTransactionContextProvider.getSelection();
	}

	public String getTestsArtifactId() {		
		return projectsPage.testsSuffix.getText().trim().length()==0 ? 
				getGroupId() 
				: getGroupId()+"."+projectsPage.testsSuffix.getText();
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

	public List<String> getModules() {
		List<String> ret = super.getModules();
		
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
		
		return ret;
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