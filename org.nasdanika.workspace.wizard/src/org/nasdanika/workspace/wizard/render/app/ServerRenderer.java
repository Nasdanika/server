package org.nasdanika.workspace.wizard.render.app;

public class ServerRenderer {


  protected static String nl;
  public static synchronized ServerRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ServerRenderer result = new ServerRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" immediate=\"true\" name=\"Credit Cards\">" + NL + "   <implementation class=\"org.nasdanika.cdo.CDOSessionProvider";
  protected final String TEXT_2 = "Server";
  protected final String TEXT_3 = "Component\"/>";
  protected final String TEXT_4 = NL + "   <reference " + NL + "   \t\tbind=\"addRepository\" " + NL + "   \t\tcardinality=\"1..1\" " + NL + "   \t\tinterface=\"org.nasdanika.cdo.RepositoryProvider\" " + NL + "   \t\tname=\"RepositoryProvider\" " + NL + "   \t\tpolicy=\"static\" " + NL + "   \t\ttarget=\"(component.name=";
  protected final String TEXT_5 = "-repository)\" " + NL + "   \t\tunbind=\"removeRepository\"/>" + NL + "   <property name=\".acceptors\" type=\"String\" value=\"jvm:";
  protected final String TEXT_6 = "\"/>";
  protected final String TEXT_7 = NL + "   <property name=\".repositoryName\" type=\"String\" value=\"";
  protected final String TEXT_8 = "\"/>" + NL + "   <property name=\".connector\" type=\"String\" value=\"jvm:";
  protected final String TEXT_9 = "\"/>" + NL + "   <service>" + NL + "      <provide interface=\"org.eclipse.emf.cdo.session.CDOSessionProvider\"/>" + NL + "   </service>" + NL + "   <property name=\"alias\" type=\"String\" value=\"";
  protected final String TEXT_10 = "\"/>" + NL + "   <reference " + NL + "   \t\tbind=\"addSessionInitializer\" " + NL + "   \t\tcardinality=\"1..1\" " + NL + "   \t\tinterface=\"org.nasdanika.cdo.CDOSessionInitializer\" " + NL + "   \t\tname=\"CDOSessionInitializer\" " + NL + "   \t\tpolicy=\"static\" " + NL + "   \t\ttarget=\"(component.name=";
  protected final String TEXT_11 = "-session-initializer)\" " + NL + "   \t\tunbind=\"removeSessionInitializer\"/>" + NL + "   \t\t" + NL + "</scr:component>";
  protected final String TEXT_12 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     if (wizard.isRepositoryComponent()) { 
    stringBuffer.append(TEXT_2);
     } 
    stringBuffer.append(TEXT_3);
     if (wizard.isRepositoryComponent()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}