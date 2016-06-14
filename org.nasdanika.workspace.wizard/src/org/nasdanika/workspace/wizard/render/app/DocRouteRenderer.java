package org.nasdanika.workspace.wizard.render.app;

public class DocRouteRenderer {


  protected static String nl;
  public static synchronized DocRouteRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    DocRouteRenderer result = new DocRouteRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" activate=\"activate\" immediate=\"true\" name=\"";
  protected final String TEXT_2 = " Documentation route\">" + NL + "   <implementation class=\"org.nasdanika.cdo.web.doc.DocRoute\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.nasdanika.web.Route\"/>" + NL + "   </service>" + NL + "   <property name=\"path\" type=\"String\" value=\"";
  protected final String TEXT_3 = "/\"/>" + NL + "   <property name=\"doc-route-path\" type=\"String\" value=\"";
  protected final String TEXT_4 = "/";
  protected final String TEXT_5 = "\"/>" + NL + "   <property name=\"doc-app-path\" type=\"String\" value=\"";
  protected final String TEXT_6 = "/";
  protected final String TEXT_7 = "\"/>" + NL + "   ";
  protected final String TEXT_8 = NL + "   \t\t<reference bind=\"setCdoSessionProvider\" cardinality=\"1..1\" interface=\"org.eclipse.emf.cdo.session.CDOSessionProvider\" name=\"CDOSessionProvider\" policy=\"static\"/>";
  protected final String TEXT_9 = NL + " " + NL + "   <reference bind=\"setScrService\" cardinality=\"0..1\" interface=\"org.apache.felix.scr.ScrService\" name=\"ScrService\" policy=\"static\"/>" + NL + "   " + NL + "</scr:component>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getDocAppRoutePath());
    stringBuffer.append(TEXT_7);
     if (wizard.isCdoTransactionContextProvider()) { 
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}