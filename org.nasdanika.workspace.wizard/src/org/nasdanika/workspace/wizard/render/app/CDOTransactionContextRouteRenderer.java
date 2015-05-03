package org.nasdanika.workspace.wizard.render.app;

public class CDOTransactionContextRouteRenderer {


  protected static String nl;
  public static synchronized CDOTransactionContextRouteRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOTransactionContextRouteRenderer result = new CDOTransactionContextRouteRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" name=\"";
  protected final String TEXT_2 = " Transaction Context Route\">" + NL + "   <implementation class=\"org.nasdanika.cdo.web.CDOTransactionContextAutocloseRouteComponent\"/>" + NL + "   <property name=\"pattern\" type=\"String\" value=\"transaction(\\..+)?(/.+)?\"/>" + NL + "   <property name=\"method\" type=\"String\" value=\"*\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.nasdanika.web.Route\"/>" + NL + "   </service>" + NL + "   <reference bind=\"setFacadeContextProvider\" cardinality=\"1..1\" interface=\"org.nasdanika.cdo.CDOTransactionContextProvider\" name=\"CDOTransactionContextProvider\" policy=\"static\" unbind=\"clearFacadeContextProvider\"/>" + NL + "   <property name=\"type\" type=\"String\" value=\"root\"/>" + NL + "</scr:component>";
  protected final String TEXT_3 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}