package org.nasdanika.workspace.wizard;

public class TestRunnerRenderer {


  protected static String nl;
  public static synchronized TestRunnerRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestRunnerRenderer result = new TestRunnerRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.equinox.app.IApplication;" + NL + "import org.eclipse.equinox.app.IApplicationContext;" + NL + "import org.junit.internal.TextListener;" + NL + "import org.junit.runner.Computer;" + NL + "import org.junit.runner.JUnitCore;" + NL + "import org.junit.runner.Result;" + NL + "import org.junit.runner.notification.RunListener;" + NL + "" + NL + "public class ";
  protected final String TEXT_3 = "TestRunner implements IApplication {" + NL + "" + NL + "\t@Override" + NL + "\tpublic Object start(IApplicationContext context) throws Exception {" + NL + "        JUnitCore jUnitCore = new JUnitCore();" + NL + "        RunListener runListener = new TextListener(System.out);" + NL + "        jUnitCore.addListener(runListener);" + NL + "" + NL + "        Result result = jUnitCore.run(Computer.serial(), ";
  protected final String TEXT_4 = "Tests.class);" + NL + "        " + NL + "        java.awt.Toolkit.getDefaultToolkit().beep();" + NL + "        " + NL + "        //System.out.println(result);" + NL + "        " + NL + "        return result.getFailureCount()==0 ? 0 : 1;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void stop() {" + NL + "\t\t// NOP" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}