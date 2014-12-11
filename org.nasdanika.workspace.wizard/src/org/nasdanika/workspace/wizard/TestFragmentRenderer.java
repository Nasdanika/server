package org.nasdanika.workspace.wizard;

public class TestFragmentRenderer {


  protected static String nl;
  public static synchronized TestFragmentRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestFragmentRenderer result = new TestFragmentRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.4\"?>" + NL + "<fragment>" + NL + "   <extension" + NL + "         id=\"";
  protected final String TEXT_2 = "TestRunner\"" + NL + "         point=\"org.eclipse.core.runtime.applications\">" + NL + "      <application" + NL + "            cardinality=\"singleton-global\"" + NL + "            thread=\"main\"" + NL + "            visible=\"true\">" + NL + "         <run" + NL + "               class=\"";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "TestRunner\">" + NL + "         </run>" + NL + "      </application>" + NL + "   </extension>" + NL + "</fragment>";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}