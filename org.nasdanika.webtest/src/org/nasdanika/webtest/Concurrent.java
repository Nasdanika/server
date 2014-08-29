package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be used with {@link NasdanikaWebTestSuite}, {@link NasdanikaWhiteBoardWebTestSuite}, and {@link NasdanikaParameterizedWebTestRunner}
 * to indicate that tests can be executed concurrently.
 * @author Pavel Vlasov
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Concurrent {
	
	/**
	 * Number of threads to use for execution. By default a thread is created for each test.
	 * In the case of parameterized tests the number of thread might be restricted.
	 * @return
	 */
	int value() default -1;
	
	/**
	 * String with {0}...{n} tokens to compute executor key for a parameterized test.
	 * Each executor is created with <code>value</code> threads. Executor keying can be used in situations where 
	 * depending on parameters tests use different resources and access to each resource shall be throttled or serialized (value=1).
	 * @return
	 */
	String executorKey() default "";

}
