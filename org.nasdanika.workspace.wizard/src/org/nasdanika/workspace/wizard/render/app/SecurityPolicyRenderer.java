package org.nasdanika.workspace.wizard.render.app;

public class SecurityPolicyRenderer {


  protected static String nl;
  public static synchronized SecurityPolicyRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    SecurityPolicyRenderer result = new SecurityPolicyRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<org.nasdanika.cdo.security:SecurityPolicyContainer xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:org.nasdanika.cdo.security=\"urn:org.nasdanika.cdo.security\">" + NL + "  <actions name=\"*\" targetNamespaceURI=\"urn:org.nasdanika.cdo.security\" targetClass=\"User\" grantable=\"true\">" + NL + "    <pathPatterns>.+</pathPatterns>" + NL + "  </actions>" + NL + "  <actions name=\"read\" targetNamespaceURI=\"urn:";
  protected final String TEXT_2 = "\" targetClass=\"";
  protected final String TEXT_3 = "\"/>" + NL + "  <actions name=\"invoke\" targetNamespaceURI=\"java://";
  protected final String TEXT_4 = "\" targetClass=\"";
  protected final String TEXT_5 = "Service\">" + NL + "    <pathPatterns>.+</pathPatterns>" + NL + "  </actions>" + NL + "</org.nasdanika.cdo.security:SecurityPolicyContainer>";
  protected final String TEXT_6 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}