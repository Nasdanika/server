package org.nasdanika.workspace.wizard;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.internal.core.feature.FeaturePlugin;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.pde.internal.ui.wizards.feature.CreateFeatureProjectOperation;
import org.eclipse.pde.internal.ui.wizards.feature.FeatureData;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.osgi.framework.FrameworkUtil;

/**
 * A wizard to generate modeling, feature, repository, parent, and aggregator projects.
 * Functionality of this wizard is identical to the application workspace wizard ({@link WorkspaceWizard})
 * with only the modeling project selected and its name equal to the group/umbrella name.
 */

public class ModelingWorkspaceWizard extends AbstractWorkspaceWizard {
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(GenModelEditPlugin.INSTANCE.getImage("full/wizban/NewEmptyEMFProject")));
		setWindowTitle("New Nasdanika Application Workspace");
	}
			
	public void modifyWorkspace(IProgressMonitor progressMonitor) throws Exception {
        SubMonitor progress = SubMonitor.convert(progressMonitor, 60);

        SubMonitor superProgress = progress.newChild(40);
		super.modifyWorkspace(superProgress);

		executeProgressTask(
				progress.newChild(10), 
				"Generating model project", 
				10, 
				(monitor)->generateModelProject(monitor));
		
		executeProgressTask(
				progress.newChild(10), 
				"Generating feature project", 
				10, 
				(monitor)->generateFeatureProject(monitor));				
		
	}
	
	protected void generateFeatureProject(IProgressMonitor progressMonitor) throws Exception {
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
					fProject.getFile("pom.xml").create(new ByteArrayInputStream(new FeaturePomRenderer().generate(ModelingWorkspaceWizard.this).getBytes()), false, monitor);
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
				fplugin.setId(getModelArtifactId());
				fplugin.setVersion("0.0.0");
				fplugin.setUnpack(false);
				plugins.add(fplugin);
				
				feature.addPlugins(plugins.toArray(new IFeaturePlugin[plugins.size()]));				
			};
			
		}.execute(progressMonitor);			
	}
	
	@Override
	public Map<String, String> getRepositories() {
//		return Collections.singletonMap("nasdanika-server", "http://www.nasdanika.org/server/repository");
		
		Map<String, String> repoMap = new LinkedHashMap<>();
		
		// Kinda bad style, load from a properties file?
		repoMap.put("neon", "http://download.eclipse.org/releases/neon");
		repoMap.put("orbit", "http://download.eclipse.org/tools/orbit/downloads/drops/R20160520211859/repository");
		return repoMap;
	}
	
	@Override
	public Collection<String> getCategorizedFeatures() {
		return Collections.singleton(getGroupId()+".feature");
	}
	
	@Override
	public Collection<String> getProductsToMaterialize() {
		return Collections.singleton(getGroupId()+".product");
	}

	@Override
	protected Collection<String[]> getTargetUnits() {
		return Collections.emptyList();
	}	
	
	protected boolean shallGenerateModelProject() {
		return true;
	}
	
	protected void generateModelProject(IProgressMonitor progressMonitor) throws Exception {
		if (shallGenerateModelProject()) {
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
			manifest.println(BUNDLE_REQUIRED_EXECUTION_ENVIRONMENT);;
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
			
			project.getFile("model/"+getDashedName()+".ecore").create(new ByteArrayInputStream(new ModelRenderer().generate(this).getBytes()), false, progressMonitor);
			project.getFile("model/"+getDashedName()+".genmodel").create(new ByteArrayInputStream(new GenModelRenderer().generate(this).getBytes()), false, progressMonitor);
			
			project.getFile("build.properties").create(new ByteArrayInputStream(new ModelBuildPropertiesRenderer().generate(this).getBytes()), false, progressMonitor);
		}
	}

	protected String[] getRequiredBundles() {
		return new String[] { "org.eclipse.emf.ecore" };
	}

	public String getModelArtifactId() {
		return getGroupId();
	}

	public List<String> getModules() {
		List<String> ret = super.getModules();
		
		if (shallGenerateModelProject()) {
			ret.add(getModelArtifactId());
		}
		
		return ret;
	}

	public Object getTargetVersion() {		
		return FrameworkUtil.getBundle(this.getClass()).getVersion().toString();
	}
	
	public String getModelPackageName() {
		String modelID = getModelArtifactId();
		int idx = modelID.lastIndexOf('.');
		return idx == -1 ? modelID : modelID.substring(idx+1);
	}

	public String getGenModelPackagePrefix() {
		return StringUtils.capitalize(getModelPackageName());
	}	
	
	public String getGenModelBasePackageName() {
		String modelID = getModelArtifactId();
		int idx = modelID.lastIndexOf('.');
		return idx == -1 ? "" : modelID.substring(0, idx);
	}
		
}