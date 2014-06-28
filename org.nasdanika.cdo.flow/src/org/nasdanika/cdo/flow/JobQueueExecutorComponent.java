package org.nasdanika.cdo.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.CDOViewContext;

public class JobQueueExecutorComponent<C extends CDOViewContext<?,?>> extends ExecutorComponent<C> {
	
	private static final Logger logger = Logger.getLogger(JobQueueExecutorComponent.class.getName());

	/**
	 * Navigates Command's containment hierarchy and stores job in the first JobQueue encountered.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void storeJob(Job<?, C> job) {
		for (EObject c = job.eContainer(); c!=null; c=c.eContainer()) {
			if (c instanceof JobQueue) {
				final JobQueue<C> jobQueue = (JobQueue<C>) c;
				jobQueue.getJobs().add(job);
				((CDOTransaction) jobQueue.cdoView()).addTransactionHandler(new CDOTransactionHandler2() {

					@Override
					public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
						// NOP						
					}

					@Override
					public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
						synchronized (knownQueues) {
							knownQueues.add(jobQueue.cdoID());
						}						
					}

					@Override
					public void rolledBackTransaction(CDOTransaction transaction) {
						// NOP						
					}
				});
				break;
			}
		}
	}

	private Set<CDOID> knownQueues = new HashSet<>();
	
	@Override
	public void activate() throws Exception {
		super.activate();
		// Finds all job queues and puts their ID's to the knownQueues set.
		try (C context = getContextProvider().createContext()) {
			TreeIterator<EObject> cit = context.getView().getRootResource().eAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (next instanceof JobQueue) {
					synchronized (knownQueues) {
						knownQueues.add(((JobQueue<?>) next).cdoID());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<CDOID> poll() {
		Collection<CDOID> ret = new ArrayList<>();
		Collection<CDOID> toPoll;
		synchronized (knownQueues) {
			toPoll = new ArrayList<>(knownQueues);
		}
		try (C context = getContextProvider().createContext()) {
			CDOView view = context.getView();
			for (CDOID jobQueueID: toPoll) {
				CDOObject jobQueue = view.getObject(jobQueueID);
				if (jobQueue instanceof JobQueue) {
					for (Job<?, C> job: ((JobQueue<C>) jobQueue).getJobs()) {
						if (job.canExecute()) {
							ret.add(job.cdoID());
						}
					}
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Job polling failed: "+e, e);
		}		
		return ret.iterator();
	}

}
