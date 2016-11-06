package org.nasdanika.provisioning;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.engine.IProfile;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.engine.IProvisioningPlan;
import org.eclipse.equinox.p2.engine.ProvisioningContext;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.operations.ProfileModificationJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.equinox.p2.planner.IPlanner;
import org.eclipse.equinox.p2.planner.IProfileChangeRequest;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.IRepositoryManager;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

/**
 * Checks for new features/updates in the provided repositories. Installs/updates features found and applies changes to the running
 * OSGi environment. New bundles get installed and started. Existing bundles get updated and re-started only if the were started before. 
 * 
 * 
 * <h3>Properties</h3>
 * <UL>
 *   <LI><code>locations</code> - required, shall be a single or multi-value string and contain a list of repository URL's to
 * check for new/updated features.</LI> 
 * 
 *   <LI><code>update-interval</code> - required, long, single value - interval to check for updates in seconds.
 *  
 *   <LI><code>features</code> - optional, single or multi-value string. This property shall contain a list of feature ID's to consider for installation/update. If this property is not set then all 
 * features are considered.</LI>

 * </UL>
 * 
 * <h3>References</h3>
 * The component shall be configured with {@link IProvisioningAgentProvider} reference.    
 * @author Pavel Vlasov
 *
 */
public class AutoUpdateComponent {
	
	private IProvisioningAgentProvider provisioningAgentProvider;
	private Set<String> features = new HashSet<>();
	
	private IProgressMonitor monitor = new NullProgressMonitor() {
		public void beginTask(String name, int totalWork) {
			if (name!=null && name.trim().length()>0) {
				System.out.println("[Provisioning] "+name+" "+totalWork);
			}
		};
		
		@Override
		public void setTaskName(String name) {
			if (name!=null && name.trim().length()>0) {
				System.out.println("[Provisioning] "+name);
			}
		}
		
		public void subTask(String name) {
			if (name!=null && name.trim().length()>0) {
				System.out.println("[Provisioning] \t"+name);
			}
		};
		
	};
	private Timer timer;
	private BundleContext bundleContext;
	
	public void setProvisioningAgentProvider(IProvisioningAgentProvider provisioningAgentProvider) {
		this.provisioningAgentProvider = provisioningAgentProvider;
	}
	
	public void activate(ComponentContext context) throws Exception {
		System.out.println("[Provisioning] Activating auto-update component");
		this.bundleContext = context.getBundleContext();
		
		Long updateInterval = (Long) context.getProperties().get("update-interval")*1000;
		timer = new Timer();
		
		Object locations = context.getProperties().get("locations");
		
		Object fs =  context.getProperties().get("features");
		if (fs instanceof String) {
			features.add((String) fs);
		} else if (fs instanceof String[]) {
			for (String iu: (String[]) fs) {
				features.add(iu);				
			}
		}
				
		scheduleUpdates(updateInterval, locations);
	}

	public void scheduleUpdates(Long updateInterval, Object locations) {
		if (locations instanceof String) {
			try {
				TimerTask checkForUpdatesTask = new TimerTask() {
					
					@Override
					public void run() {
						try {
							checkForUpdates((String) locations);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
					}
					
				};
				timer.schedule(checkForUpdatesTask, updateInterval, updateInterval);
			} catch (Exception e) {
				System.out.println("[Provisioning] Failed to load repository from location "+locations+": "+e);
				e.printStackTrace();
			}
		} else if (locations instanceof String[]) {
			String[] la = (String[]) locations;
			long offset = updateInterval/la.length;
			for (int i=0; i< la.length; ++i) {
				String loc = la[i];
				try {
					TimerTask checkForUpdatesTask = new TimerTask() {
						
						@Override
						public void run() {
							try {
								checkForUpdates(loc);
							} catch (Exception e) {
								// TODO Better reporting
								e.printStackTrace();
							}					
						}
						
					};
					timer.schedule(checkForUpdatesTask, updateInterval + offset*i, updateInterval);
				} catch (Exception e) {
					System.out.println("[Provisioning] Failed to load repository from location "+loc+": "+e);
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deactivate() {
		timer.cancel();
	}
	
	private class InstallableUnitInfo {
		
		IInstallableUnit installableUnit;
		
		private class ArtifactInfo {
			public ArtifactInfo(IArtifactKey ak) {
				this.artifactKey = ak;
			}
			IArtifactKey artifactKey;
			Bundle bundle;
			boolean active;
		}
		
		List<ArtifactInfo> toUpdate = new ArrayList<>();
		
		InstallableUnitInfo(IMetadataRepositoryManager metadataManager, IInstallableUnit iu) {
			this.installableUnit = iu;
			collectToUpdate(metadataManager, iu, new HashSet<>());
			Collections.reverse(toUpdate);
		}
		
		private void collectToUpdate(IMetadataRepositoryManager metadataManager, IInstallableUnit iu, Set<String> inspected) {
			if (inspected.add(iu.getId())) {
				String groupProperty = iu.getProperty(QueryUtil.PROP_TYPE_GROUP);
				String localizationProperty = iu.getProperty("org.eclipse.equinox.p2.bundle.localization");
				if (!"true".equals(groupProperty) && "plugin".equals(localizationProperty)) { // Plugin bundles only
					Z: for (IArtifactKey ak: iu.getArtifacts()) {
						if ("osgi.bundle".equals(ak.getClassifier())) {
							for (ArtifactInfo eai: toUpdate) {
								// No duplicate artifact ID's. Assuming singletons.
								if (eai.artifactKey.getId().equals(ak.getId())) {
									continue Z;
								}
 							}
							ArtifactInfo ai = new ArtifactInfo(ak);
							for (Bundle bundle: bundleContext.getBundles()) {
								if (bundle != null && bundle.getSymbolicName() != null && bundle.getSymbolicName().equals(ak.getId())) {
									Version bundleVersion = Version.createOSGi(
											bundle.getVersion().getMajor(),
											bundle.getVersion().getMinor(),
											bundle.getVersion().getMicro(),
											bundle.getVersion().getQualifier());
									if (bundleVersion.compareTo(ak.getVersion()) >= 0) {
										continue Z; // Already installed 
									}
									ai.bundle = bundle;
									ai.active = bundle.getState() == Bundle.ACTIVE;
								}
							}	
							toUpdate.add(ai);
						}
					}
				}
				for (IRequirement req: iu.getRequirements()) {
					for (IInstallableUnit reqiu: metadataManager.query(QueryUtil.createMatchQuery(req.getMatches()), monitor)) {
						collectToUpdate(metadataManager, reqiu, inspected);
					}			
				}			
			}
		}				
				
	}
	
	private void checkForUpdates(String location) throws Exception {		
		IProvisioningAgent agent = provisioningAgentProvider.createAgent(null);
		try {			
			IProfileRegistry registry = (IProfileRegistry) agent.getService(IProfileRegistry.SERVICE_NAME);
			IPlanner planner = (IPlanner) agent.getService(IPlanner.SERVICE_NAME);
//			IEngine engine = (IEngine) agent.getService(IEngine.SERVICE_NAME);

			System.out.println();
			System.out.println();
			System.out.println("[Provisioning] --- Checking for updates ---");
			IMetadataRepositoryManager metadataManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
			IArtifactRepositoryManager artifactManager = (IArtifactRepositoryManager) agent.getService(IArtifactRepositoryManager.SERVICE_NAME);
			
			URI location1 = new URI(location.trim());
			metadataManager.loadRepository(location1, monitor);
			artifactManager.addRepository(location1);
			
			URI uri = new URI(location); 
			System.out.println("[Provisioning] Checking for updates at "+uri);
			metadataManager.refreshRepository(uri, monitor);
			
			java.util.Collection<IInstallableUnit> af = metadataManager.query(QueryUtil.createIUGroupQuery(), monitor).toSet();
			
			Map<String, InstallableUnitInfo> sortedAvailableFeatures = new TreeMap<>();
			for (IInstallableUnit iu: af) {
				if (features.isEmpty() || features.contains(iu.getId())) {
					sortedAvailableFeatures.put(iu.getId(), new InstallableUnitInfo(metadataManager, iu));
				}
			}						
						
			for (IProfile profile: registry.getProfiles()) {
				System.out.println("[Provisioning] Profile: "+profile.getProfileId());
				
				Collection<IInstallableUnit> installed = profile.query(QueryUtil.createIUAnyQuery(), monitor).toUnmodifiableSet();
				Map<String, IInstallableUnit> sortedInstalledFeatures = new TreeMap<>();
				for (IInstallableUnit iu: installed) {
					sortedInstalledFeatures.put(iu.getId(), iu);
				}										
				
				final ProvisioningSession session = new ProvisioningSession(agent);		
				final UpdateOperation operation = new UpdateOperation(session);
				operation.setProfileId(profile.getProfileId());
				
				
				System.out.println("[Provisioning] Available/Installed features:");
				for (Entry<String, InstallableUnitInfo> afe: sortedAvailableFeatures.entrySet()) {
					IInstallableUnit installedFeature = sortedInstalledFeatures.get(afe.getKey());
					System.out.println(
							"[Provisioning] \t" + 
							afe.getKey() + " " + 
							afe.getValue().installableUnit.getVersion() + "/" +
							(installedFeature == null ? "N/A" : installedFeature.getVersion()) +" - " +
							afe.getValue().installableUnit.getProperty(IInstallableUnit.PROP_NAME));
					
					if (installedFeature == null || installedFeature.getVersion().compareTo(afe.getValue().installableUnit.getVersion()) < 0) {
						System.out.println("[Provisioning] \t\tUpdating...");
						IProfileChangeRequest request = planner.createChangeRequest(profile);
						request.add(afe.getValue().installableUnit);
						if (installedFeature != null) {
							request.remove(installedFeature);
						}
						request.setInstallableUnitProfileProperty(afe.getValue().installableUnit, "auto-update", new Date().toString());
						ProvisioningContext context = new ProvisioningContext(agent);
						IProvisioningPlan plan = planner.getProvisioningPlan(request, context, monitor);
						IStatus planStatus = plan.getStatus();
						if (planStatus.isOK()) {
							ProfileModificationJob job = new ProfileModificationJob("Install", session, profile.getProfileId(), plan, context);
							IStatus jobStatus = job.runModal(monitor);
							System.out.println("[Provisioning] Profile modification completed");
							printStatus(jobStatus, 1);
							if (jobStatus.isOK()) {
								System.out.println("[Provisioning] Applying configuration ");
								for (URI repositoryUri: artifactManager.getKnownRepositories(IRepositoryManager.REPOSITORIES_SYSTEM)) {
									System.out.println("[Provisioning] \t Artifact repository "+repositoryUri);
									IArtifactRepository artifactRepository = artifactManager.loadRepository(repositoryUri, monitor);									
									if (artifactRepository instanceof IFileArtifactRepository) {
										IFileArtifactRepository fileArtifactRepository = (IFileArtifactRepository) artifactRepository;	
										for (InstallableUnitInfo.ArtifactInfo artifactInfo: afe.getValue().toUpdate) {
											if (fileArtifactRepository.contains(artifactInfo.artifactKey)) {
												File artifactFile = fileArtifactRepository.getArtifactFile(artifactInfo.artifactKey);
												if (artifactInfo.bundle == null) {
													System.out.println("[Provisioning] \t\tInstalling "+artifactInfo.artifactKey.getId()+" "+artifactInfo.artifactKey.getVersion());				
													URI artifactFileUri = artifactFile.toURI();
													bundleContext.installBundle(artifactFileUri.toString()).start();
												} else {
													System.out.println("[Provisioning] \t\tUpdating bundle "+artifactInfo.bundle.getSymbolicName()+" from "+artifactInfo.bundle.getVersion()+" to "+artifactInfo.artifactKey.getVersion());
													if (artifactInfo.bundle.getState() == Bundle.ACTIVE) {
														artifactInfo.bundle.stop();
													}
													try (InputStream artifactStream = new FileInputStream(artifactFile)) {
														artifactInfo.bundle.update(artifactStream);
													}
													if (artifactInfo.active) {
														artifactInfo.bundle.start();
													}
												}													
											}													
										}
										System.out.println("[Provisioning] Done applying configuration");
									} else {
										System.out.println("[Provisioning] Cannot apply configuration - artifact repository is not a file artifact repository.");										
									}
								}
							}							
						} else { 
							System.out.println("[Provisioning] \t\tUnable to update: ");
							printStatus(planStatus, 2);
						}
					}
				}				
			}
		} finally {
			agent.stop();
		}
	}

	private void printStatus(IStatus status, int indent) {
		System.out.print("[Provisioning]");
		for (int i = 0; i < indent; ++i) {
			System.out.print("\t");
		}
		System.out.println(status.getMessage());
		if (status.isMultiStatus()) {
			for (IStatus child: status.getChildren()) {
				printStatus(child, indent+1);
			}
		}							
		
	}

}

