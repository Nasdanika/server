package org.nasdanika.workspace.wizard;

public class TestPluginRenderer {


  protected static String nl;
  public static synchronized TestPluginRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestPluginRenderer result = new TestPluginRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.4\"?>" + NL + "<plugin>" + NL + "   <extension" + NL + "         id=\"TestRunner\"" + NL + "         point=\"org.eclipse.core.runtime.applications\">" + NL + "      <application" + NL + "            cardinality=\"singleton-global\"" + NL + "            thread=\"main\"" + NL + "            visible=\"true\">" + NL + "         <run" + NL + "               class=\"";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = "TestRunner\">" + NL + "         </run>" + NL + "      </application>" + NL + "   </extension>" + NL + "</plugin>";
  protected final String TEXT_4 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}