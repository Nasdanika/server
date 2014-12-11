package org.nasdanika.workspace.wizard;

public class TestSuiteRenderer {


  protected static String nl;
  public static synchronized TestSuiteRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestSuiteRenderer result = new TestSuiteRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.junit.runner.RunWith;" + NL + "import org.junit.runners.Suite.SuiteClasses;" + NL + "import org.nasdanika.webtest.NasdanikaWebTestSuite;" + NL + "import org.nasdanika.webtest.Title;" + NL + "" + NL + "@RunWith(NasdanikaWebTestSuite.class)" + NL + "@Title(\"";
  protected final String TEXT_3 = " test report\")" + NL + "@SuiteClasses({";
  protected final String TEXT_4 = "Test.class, ";
  protected final String TEXT_5 = "RouteTest.class})" + NL + "public class ";
  protected final String TEXT_6 = "Tests {" + NL + "\t" + NL + "}";
  protected final String TEXT_7 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}