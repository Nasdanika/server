package org.nasdanika.workspace.wizard.render.app;

public class RepositoryRenderer {


  protected static String nl;
  public static synchronized RepositoryRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    RepositoryRenderer result = new RepositoryRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" immediate=\"false\" name=\"";
  protected final String TEXT_2 = "-repository\">" + NL + "   <implementation class=\"org.nasdanika.cdo.h2.H2RepositoryProvider\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.nasdanika.cdo.RepositoryProvider\"/>" + NL + "   </service>" + NL + "   <!-- <property name=\".h2.url\" type=\"String\" value=\"_data/";
  protected final String TEXT_3 = "\"/> -->" + NL + "   <property name=\".repositoryName\" type=\"String\" value=\"";
  protected final String TEXT_4 = "\"/>" + NL + "</scr:component>";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}