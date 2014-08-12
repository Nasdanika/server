package org.nasdanika.webtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.osgi.framework.Bundle;

/**
 * Loads test classes from org.nasdanika.webtest.test:test extension point in addition to {@link Suite} annotation.
 * @author Pavel Vlasov
 *
 */
public class NasdanikaWhiteBoardWebTestSuite extends NasdanikaWebTestSuite {

	public NasdanikaWhiteBoardWebTestSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
	}

	public NasdanikaWhiteBoardWebTestSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
	}

	public NasdanikaWhiteBoardWebTestSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
	}

	public NasdanikaWhiteBoardWebTestSuite(Class<?> klass, List<Runner> runners) throws InitializationError {
		super(klass, runners);
	}

	public NasdanikaWhiteBoardWebTestSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, loadTestsFromExtensions(suiteClasses));
	}
	
	@SuppressWarnings("unchecked")
	private static Class<?>[] loadTestsFromExtensions(Class<?>[] suiteClasses) throws InitializationError {
		List<Class<?>> ret = new ArrayList<Class<?>>(Arrays.asList(suiteClasses));
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor("org.nasdanika.webtest.test")) {
			if ("test".equals(ce.getName())) {				
				IContributor contributor = ce.getContributor();		
				Bundle bundle = Platform.getBundle(contributor.getName());
				try {
					ret.add((Class<Object>) bundle.loadClass(ce.getAttribute("class").trim()));
				} catch (Exception e) {
					throw new InitializationError(e);
				}
			}					
		}	
		return ret.toArray(new Class<?>[ret.size()]);
	}
	
}
