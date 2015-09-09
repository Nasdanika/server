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
  protected final String TEXT_2 = " Documentation route\">" + NL + "   <implementation class=\"org.nasdanika.cdo.web.doc.DocRoute\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.nasdanika.web.Route\"/>" + NL + "   </service>" + NL + "   <property name=\"pattern\" type=\"String\" value=\"";
  protected final String TEXT_3 = "/.+\"/>" + NL + "   ";
  protected final String TEXT_4 = NL + "   \t\t<reference bind=\"setCdoSessionProvider\" cardinality=\"1..1\" interface=\"org.eclipse.emf.cdo.session.CDOSessionProvider\" name=\"CDOSessionProvider\" policy=\"static\"/>";
  protected final String TEXT_5 = NL + "   " + NL + "</scr:component>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_3);
     if (wizard.isCdoTransactionContextProvider()) { 
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}