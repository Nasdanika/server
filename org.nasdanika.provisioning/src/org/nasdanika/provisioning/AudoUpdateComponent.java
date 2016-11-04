package org.nasdanika.provisioning;

import java.io.IOException;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.equinox.internal.provisional.configurator.Configurator;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.engine.IEngine;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.operations.ProvisioningJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.Update;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.equinox.p2.planner.IPlanner;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.service.component.ComponentContext;


public class AudoUpdateComponent {
	
	private IProvisioningAgentProvider provisioningAgentProvider;
	private Configurator configurator;
	private IProvisioningAgent agent;
	private IProfileRegistry registry;
	private IMetadataRepositoryManager metadataManager;
	private IArtifactRepositoryManager artifactManager;
	private IPlanner planner;
	private IEngine engine;
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
		agent = provisioningAgentProvider.createAgent(null);
		registry = (IProfileRegistry) agent.getService(IProfileRegistry.SERVICE_NAME);
		metadataManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
		artifactManager = (IArtifactRepositoryManager) agent.getService(IArtifactRepositoryManager.SERVICE_NAME);
		planner = (IPlanner) agent.getService(IPlanner.SERVICE_NAME);
		engine = (IEngine) agent.getService(IEngine.SERVICE_NAME);
		
		Long updateInterval = (Long) context.getProperties().get("update-interval")*1000;
		timer = new Timer();
		
		Object locations = context.getProperties().get("locations");
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				scheduleUpdates(updateInterval, locations);				
			}
			
		}, updateInterval);		
		
	}

	public void scheduleUpdates(Long updateInterval, Object locations) {
		if (locations instanceof String) {
			try {
				addRepository((String) locations);
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
					addRepository(loc);
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
		agent.stop();
	}
	
	private IMetadataRepository addRepository(String locationStr) throws Exception  {
		URI location = new URI(locationStr.trim());
//		metadataManager.loadRepository(location, loggerMonitor);
		IMetadataRepository ret = metadataManager.loadRepository(location, monitor);
		artifactManager.addRepository(location);
		return ret;
	}
	
	private IStatus checkForUpdates(String location) throws Exception {

		/* 1. configure update operation */
		final ProvisioningSession session = new ProvisioningSession(agent);		
		final UpdateOperation operation = new UpdateOperation(session);
				
		URI uri = new URI(location); 
		System.out.println("[Provisioning] Checking for updates at "+uri);
		metadataManager.refreshRepository(uri, monitor);
		
		operation.getProvisioningContext().setArtifactRepositories(	new URI[] { uri });
		operation.getProvisioningContext().setMetadataRepositories(	new URI[] { uri });

		/* 2. Check for updates */

		// run check if updates are available (causing I/O)
		final IStatus status = operation.resolveModal(monitor);
		
		System.out.println("[Provisioning] Possible updates:");
		for (Update u: operation.getPossibleUpdates()) {
			System.out.println("[Provisioning] \t"+u);
		}

		System.out.println("[Provisioning] Status: "+status);
		
		// Failed to find updates (inform user and exit)
		if (status.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE) {
			System.out.println("[Provisioning] Nothing to update");
			return Status.CANCEL_STATUS;
		}

		/* 3. run installation */
		final ProvisioningJob provisioningJob = operation.getProvisioningJob(monitor);

		// updates cannot run from within Eclipse IDE!!!
		if (provisioningJob == null) {
			System.out.println("[Provisioning] Maybe you are trying to update from the Eclipse IDE? This won't work!!!");
			return Status.CANCEL_STATUS;
		}
		configureProvisioningJob(provisioningJob);

		provisioningJob.schedule();
		return Status.OK_STATUS;

	}

	private void configureProvisioningJob(ProvisioningJob provisioningJob) {

		// Register a job change listener to track
		// installation progress and notify user upon success
		provisioningJob.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				System.out.println("[Provisioning] Event: "+event);
				System.out.println("[Provisioning] Applying configuration ");
				try {
					configurator.applyConfiguration();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				super.done(event);
			}
		});

	}
	

}


