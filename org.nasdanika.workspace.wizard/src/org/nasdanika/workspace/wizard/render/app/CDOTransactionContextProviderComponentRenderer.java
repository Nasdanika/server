package org.nasdanika.workspace.wizard.render.app;

public class CDOTransactionContextProviderComponentRenderer {


  protected static String nl;
  public static synchronized CDOTransactionContextProviderComponentRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOTransactionContextProviderComponentRenderer result = new CDOTransactionContextProviderComponentRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" immediate=\"false\" name=\"";
  protected final String TEXT_2 = " Transaction Context Provider\">" + NL + "   <implementation class=\"";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "CDOTransactionContextProviderComponent\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.nasdanika.cdo.CDOTransactionContextProvider\"/>" + NL + "   </service>" + NL + "   <reference bind=\"setSessionProvider\" cardinality=\"1..1\" interface=\"org.eclipse.emf.cdo.session.CDOSessionProvider\" name=\"CDOSessionProvider\" policy=\"static\" unbind=\"clearSessionProvider\"/>" + NL + "</scr:component>";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}