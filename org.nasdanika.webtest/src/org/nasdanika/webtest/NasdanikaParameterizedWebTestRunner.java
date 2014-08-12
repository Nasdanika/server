package org.nasdanika.webtest;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * Adaptation of {@link Parameterized} runner to execute {@link NasdanikaWebTestRunner} children.
 * @author Pavel Vlasov
 *
 */
public class NasdanikaParameterizedWebTestRunner extends Suite implements TestResultSource, TestResultCollector {

    private class TestClassRunnerForParameters extends NasdanikaWebTestRunner {
        private final Object[] parameters;

        private final String fName;

		private int index;

        TestClassRunnerForParameters(Class<?> type, int index, Object[] parameters, String name) throws InitializationError {
            super(type);
            this.parameters = parameters;
            this.index = index;
            fName = name;
            setTestResultCollector(NasdanikaParameterizedWebTestRunner.this);
        }
        
        @Override
        protected Object[] getParameters() {
        	return parameters;
        }
        
        @Override
        protected int getIndex() {
        	return index;
        }

        @Override
        public Object createTest() throws Exception {
            if (fieldsAreAnnotated()) {
                return createTestUsingFieldInjection();
            } 
            
            return createTestUsingConstructorInjection();
        }

        private Object createTestUsingConstructorInjection() throws Exception {
            return getTestClass().getOnlyConstructor().newInstance(parameters);
        }

        private Object createTestUsingFieldInjection() throws Exception {
            List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
            if (annotatedFieldsByParameter.size() != parameters.length) {
                throw new Exception("Wrong number of parameters and @Parameter fields." +
                        " @Parameter fields counted: " + annotatedFieldsByParameter.size() + ", available parameters: " + parameters.length + ".");
            }
            Object testClassInstance = getTestClass().getJavaClass().newInstance();
            for (FrameworkField each : annotatedFieldsByParameter) {
                Field field = each.getField();
                Parameter annotation = field.getAnnotation(Parameter.class);
                int index = annotation.value();
                try {
                    field.set(testClassInstance, parameters[index]);
                } catch (IllegalArgumentException iare) {
                    throw new Exception(getTestClass().getName() + ": Trying to set " + field.getName() +
                            " with the value " + parameters[index] +
                            " that is not the right type (" + parameters[index].getClass().getSimpleName() + " instead of " +
                            field.getType().getSimpleName() + ").", iare);
                }
            }
            return testClassInstance;
        }

        @Override
        protected String getName() {
            return fName;
        }

        @Override
        protected String testName(FrameworkMethod method) {
            return method.getName() + getName();
        }

        @Override
        protected void validateConstructor(List<Throwable> errors) {
            validateOnlyOneConstructor(errors);
            if (fieldsAreAnnotated()) {
                validateZeroArgConstructor(errors);
            }
        }

        @Override
        protected void validateFields(List<Throwable> errors) {
            super.validateFields(errors);
            if (fieldsAreAnnotated()) {
                List<FrameworkField> annotatedFieldsByParameter = getAnnotatedFieldsByParameter();
                int[] usedIndices = new int[annotatedFieldsByParameter.size()];
                for (FrameworkField each : annotatedFieldsByParameter) {
                    int index = each.getField().getAnnotation(Parameter.class).value();
                    if (index < 0 || index > annotatedFieldsByParameter.size() - 1) {
                        errors.add(
                                new Exception("Invalid @Parameter value: " + index + ". @Parameter fields counted: " +
                                        annotatedFieldsByParameter.size() + ". Please use an index between 0 and " +
                                        (annotatedFieldsByParameter.size() - 1) + ".")
                        );
                    } else {
                        usedIndices[index]++;
                    }
                }
                for (int index = 0; index < usedIndices.length; index++) {
                    int numberOfUse = usedIndices[index];
                    if (numberOfUse == 0) {
                        errors.add(new Exception("@Parameter(" + index + ") is never used."));
                    } else if (numberOfUse > 1) {
                        errors.add(new Exception("@Parameter(" + index + ") is used more than once (" + numberOfUse + ")."));
                    }
                }
            }
        }

        @Override
        protected Statement classBlock(RunNotifier notifier) {
            return childrenInvoker(notifier);
        }

        @Override
        protected Annotation[] getRunnerAnnotations() {
            return new Annotation[0];
        }
    }

    private final ArrayList<Runner> runners = new ArrayList<Runner>();

    /**
     * Only called reflectively. Do not use programmatically.
     */
    public NasdanikaParameterizedWebTestRunner(Class<?> klass) throws Throwable {
        super(klass, Collections.<Runner>emptyList());
        Parameters parameters = getParametersMethod().getAnnotation(Parameters.class);
        createRunnersForParameters(allParameters(), parameters.name());
    }

    @Override
    protected List<Runner> getChildren() {
        return runners;
    }

    @SuppressWarnings("unchecked")
    private Iterable<Object[]> allParameters() throws Throwable {
        Object parameters = getParametersMethod().invokeExplosively(null);
        if (parameters instanceof Iterable) {
            return (Iterable<Object[]>) parameters;
        } 
        
        throw parametersMethodReturnedWrongType();
    }

    private FrameworkMethod getParametersMethod() throws Exception {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(Parameters.class);
        for (FrameworkMethod each : methods) {
            if (each.isStatic() && each.isPublic()) {
                return each;
            }
        }

        throw new Exception("No public static parameters method on class " + getTestClass().getName());
    }

    private void createRunnersForParameters(Iterable<Object[]> allParameters, String namePattern) throws InitializationError, Exception {
        try {
            for (Object[] parametersOfSingleTest : allParameters) {
                String name = nameFor(namePattern, runners.size(), parametersOfSingleTest);
                runners.add(new TestClassRunnerForParameters(
                		getTestClass().getJavaClass(),
                		runners.size(),
                        parametersOfSingleTest,
                        name));
                
            }
        } catch (ClassCastException e) {
            throw parametersMethodReturnedWrongType();
        }
    }

    private String nameFor(String namePattern, int index, Object[] parameters) {
        String finalPattern = namePattern.replaceAll("\\{index\\}", Integer.toString(index));
        String name = MessageFormat.format(finalPattern, parameters);
        return "[" + name + "]";
    }

    private Exception parametersMethodReturnedWrongType() throws Exception {
        String className = getTestClass().getName();
        String methodName = getParametersMethod().getName();
        String message = MessageFormat.format(
                "{0}.{1}() must return an Iterable of arrays.",
                className, 
                methodName);
        return new Exception(message);
    }

    private List<FrameworkField> getAnnotatedFieldsByParameter() {
        return getTestClass().getAnnotatedFields(Parameter.class);
    }

    private boolean fieldsAreAnnotated() {
        return !getAnnotatedFieldsByParameter().isEmpty();
    }
    
	
	private TestResultCollector testResultCollector;
	private AtomicLong counter;
	private Executor screenshotExecutor;

	private List<TestResult> testResults = new ArrayList<>();
	private File outputDir;
	private String id;
		
	private List<TestResultListener> listeners = new ArrayList<>();

	@Override
	public void addListener(TestResultListener testResultListener) {
		if (testResultCollector==null) {
			listeners.add(testResultListener);		
		} else {
			testResultCollector.addListener(testResultListener);
		}
	}
	
	@Override
	public void run(RunNotifier notifier) {
		try {
			outputDir = testResultCollector == null ? NasdanikaWebTestRunner.configOutputDir(getTestClass().getJavaClass()) : testResultCollector.getOutputDir();	
			counter = testResultCollector == null ? new AtomicLong() : testResultCollector.getCounter();
			id = Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
			screenshotExecutor = testResultCollector == null ? Executors.newSingleThreadExecutor() : testResultCollector.getScreenshotExecutor();
			try {
				super.run(notifier);
			} finally {
				if (testResultCollector==null) {
					close();
				} 				
			}			
		} catch (Exception e) {
			System.err.println("Report generation failed: "+e);
			e.printStackTrace();
		}
	}
	
	@Override
	public AtomicLong getCounter() {
		return testResultCollector == null ? counter : testResultCollector.getCounter();
	}
	
	@Override
	public File getOutputDir() {
		return testResultCollector == null ? outputDir : testResultCollector.getOutputDir();
	}
	
	@Override
	public Executor getScreenshotExecutor() {
		return testResultCollector == null ? screenshotExecutor : testResultCollector.getScreenshotExecutor();
	}
	
	@Override
	public void addResult(TestResult testResult) {
		testResults.add(testResult);
	}

	@Override
	public void setTestResultCollector(TestResultCollector testResultCollector) {
		this.testResultCollector = testResultCollector;	
		this.testResultCollector.addResult(new ParameterizedTestResult() {
			
			@Override
			public Class<?> getTestClass() {
				return NasdanikaParameterizedWebTestRunner.this.getTestClass().getJavaClass();
			}
			
			@Override
			public String getId() {
				return id;
			}
			
			@Override
			public List<TestResult> getChildren() {
				return testResults;
			}
						
			@Override
			public Map<TestStatus, Integer> getStats() {
				Map<TestStatus, Integer> ret = new TreeMap<>();
				for (TestStatus ts: TestStatus.values()) {
					ret.put(ts, 0);
				}
				for (TestResult child: testResults) {
					for (Entry<TestStatus, Integer> cs: child.getStats().entrySet()) {
						ret.put(cs.getKey(), ret.get(cs.getKey())+cs.getValue());
					}					
				}
				return ret;
			}
			
		});
	}

	@Override
	public void close() throws Exception {
		((ExecutorService) screenshotExecutor).shutdown();
		((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
		new ReportGenerator(getTestClass().getJavaClass(), outputDir, testResults).generate();
		WebTestUtil.publishTestResults(testResults);		
	}    
    
}
