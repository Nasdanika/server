package org.nasdanika.provisioning;

import java.io.IOException;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.equinox.internal.provisional.configurator.Configurator;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.engine.IEngine;
import org.eclipse.equinox.p2.engine.IProfile;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.engine.IProvisioningPlan;
import org.eclipse.equinox.p2.engine.ProvisioningContext;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.ProfileModificationJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.equinox.p2.planner.IPlanner;
import org.eclipse.equinox.p2.planner.IProfileChangeRequest;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.service.component.ComponentContext;


public class AutoUpdateComponent {
	
	private IProvisioningAgentProvider provisioningAgentProvider;
	private Configurator configurator;
	private Set<String> installableUnits = new HashSet<>();
	
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
	
	public void setProvisioningAgentProvider(IProvisioningAgentProvider provisioningAgentProvider) {
		this.provisioningAgentProvider = provisioningAgentProvider;
	}
	
	public void setConfigurator(Configurator configurator) {
		this.configurator = configurator;
	}
	
	public void activate(ComponentContext context) throws Exception {
		System.out.println("[Provisioning] Activating auto-update component");
		
		Long updateInterval = (Long) context.getProperties().get("update-interval")*1000;
		timer = new Timer();
		
		Object locations = context.getProperties().get("locations");
		
		Object ius =  context.getProperties().get("installable-units");
		if (ius instanceof String) {
			installableUnits.add((String) ius);
		} else if (ius instanceof String[]) {
			for (String iu: (String[]) ius) {
				installableUnits.add(iu);				
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
			for (int i=0; i< la.length; ++i) {
				String loc = la[i];
				try {
					TimerTask checkForUpdatesTask = new TimerTask() {
						
						@Override
						public void run() {
							try {
								checkForUpdates(loc);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}					
						}
						
					};
					long offset = updateInterval/la.length;
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
	
	private IMetadataRepository addRepository(IMetadataRepositoryManager metadataManager, IArtifactRepositoryManager artifactManager, String locationStr) throws Exception  {
		URI location = new URI(locationStr.trim());
//		metadataManager.loadRepository(location, loggerMonitor);
		IMetadataRepository ret = metadataManager.loadRepository(location, monitor);
		artifactManager.addRepository(location);		
		return ret;
	}
	
	private java.util.Collection<IInstallableUnit> getAvailableFeatures(IMetadataRepositoryManager metadataManager) {
		IQuery<IInstallableUnit> query = QueryUtil.createIUGroupQuery(); 
		IQueryResult<IInstallableUnit> result = metadataManager.query(query, monitor);
		return result.toSet();
	}	
	
	public java.util.Collection<IInstallableUnit> getInstalled(IProfile profile) {
		if (profile == null) {
			return Collections.emptyList();
		}
//		IQuery query = new IUProfilePropertyQuery(PROP_TOAST_ROOT, "true");
		IQueryResult<IInstallableUnit> result = profile.query(QueryUtil.createIUAnyQuery(), monitor);
		return result.toUnmodifiableSet();
	}
	
	private void checkForUpdates(String location) throws Exception {		
		IProvisioningAgent agent = provisioningAgentProvider.createAgent(null);
		try {			
			IProfileRegistry registry = (IProfileRegistry) agent.getService(IProfileRegistry.SERVICE_NAME);
			IPlanner planner = (IPlanner) agent.getService(IPlanner.SERVICE_NAME);
			IEngine engine = (IEngine) agent.getService(IEngine.SERVICE_NAME);

			System.out.println();
			System.out.println();
			System.out.println("[Provisioning] --- Checking for updates ---");
			IMetadataRepositoryManager metadataManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
			IArtifactRepositoryManager artifactManager = (IArtifactRepositoryManager) agent.getService(IArtifactRepositoryManager.SERVICE_NAME);
			
			addRepository(metadataManager, artifactManager, location);
			
			configurator.applyConfiguration();
			
			for (IProfile profile: registry.getProfiles()) {
				System.out.println("[Provisioning] Profile: "+profile.getProfileId());
				
				/* 1. configure update operation */
	//			final UpdateOperation operation = new UpdateOperation(session);
						
				URI uri = new URI(location); 
				System.out.println("[Provisioning] Checking for updates at "+uri);
				metadataManager.refreshRepository(uri, monitor);
				
				java.util.Collection<IInstallableUnit> af = getAvailableFeatures(metadataManager);
				System.out.println("[Provisioning] Available features:");
				
				Map<String, IInstallableUnit> sortedAvailableFeatures = new TreeMap<>();
				for (IInstallableUnit iu: af) {
					sortedAvailableFeatures.put(iu.getId(), iu);
				}	
				
				Collection<IInstallableUnit> installed = getInstalled(profile);
				Map<String, IInstallableUnit> sortedInstalledFeatures = new TreeMap<>();
				for (IInstallableUnit iu: installed) {
					sortedInstalledFeatures.put(iu.getId(), iu);
				}										
				
				ProvisioningSession session = new ProvisioningSession(agent);		
				UpdateOperation operation = new UpdateOperation(session);
				operation.setProfileId(profile.getProfileId());
				
				System.out.println("[Provisioning] Available/Installed features:");
				for (Entry<String, IInstallableUnit> afe: sortedAvailableFeatures.entrySet()) {
					System.out.println("[Provisioning] \t"+afe.getKey());
					System.out.println("[Provisioning] \t\t"+afe.getValue().getProperty(IInstallableUnit.PROP_NAME));
					System.out.println("[Provisioning] \t\tAvailable version: "+afe.getValue().getVersion());
					IInstallableUnit installedFeature = sortedInstalledFeatures.get(afe.getKey());
					System.out.println("[Provisioning] \t\tInstalled version: "+(installedFeature == null ? "N/A" : installedFeature.getVersion()));
					System.out.println();
					
					if (installedFeature == null || installedFeature.getVersion().compareTo(afe.getValue().getVersion()) < 0) {
						System.out.println("[Provisioning] \t\tUpdating...");
						IProfileChangeRequest request = planner.createChangeRequest(profile);
						request.add(afe.getValue());
						if (installedFeature != null) {
							request.remove(installedFeature);
						}
						request.setInstallableUnitProfileProperty(afe.getValue(), "auto-update", new Date().toString());
						ProvisioningContext context = new ProvisioningContext(agent);
						IProvisioningPlan plan = planner.getProvisioningPlan(request, context, monitor);
						IStatus planStatus = plan.getStatus();
						if (planStatus.isOK()) {
							ProfileModificationJob job = new ProfileModificationJob("Install", session, profile.getProfileId(), plan, context);
							IStatus jobStatus = job.runModal(monitor);
							System.out.println("Profile modification completed");
							printStatus(jobStatus, 1);
							if (jobStatus.isOK()) {
								System.out.println("Applying configuration ");
								try {
									// TODO Does not work properly - OSGi runtime is not updated.
									// New configuration gets applied after restart.
									configurator.applyConfiguration(); 
									System.out.println("Done applying configuration");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
//							IStatus status = engine.perform(plan, monitor);
//							System.out.println("[Provisioning] \t\tUpdate status");
//							printStatus(status, 2);
//							if (status.isOK()) {
//								System.out.println("[Provisioning] \t\tApplying configuration...");
//								configurator.applyConfiguration();								
//							}
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

