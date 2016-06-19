package org.nasdanika.workspace.wizard.render;

public class TestResultsPluginRenderer {


  protected static String nl;
  public static synchronized TestResultsPluginRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestResultsPluginRenderer result = new TestResultsPluginRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<plugin>" + NL + "   <extension" + NL + "         point=\"org.nasdanika.webtest.model.results\">" + NL + "      <result" + NL + "            model=\"model/";
  protected final String TEXT_2 = "Tests.xml\">" + NL + "      </result>" + NL + "   </extension>" + NL + "" + NL + "</plugin>";
  protected final String TEXT_3 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}