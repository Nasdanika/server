package org.nasdanika.cdo.scheduler;

import org.nasdanika.core.NasdanikaException;

@SuppressWarnings("serial")
public class SchedulerException extends NasdanikaException {

	public SchedulerException(String message) {
		super(message);
	}

	public SchedulerException(Throwable cause) {
		super(cause);
	}

	public SchedulerException(String message, Throwable cause) {
		super(message, cause);
	}

	public SchedulerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
