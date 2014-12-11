package org.nasdanika.workspace.wizard;

public class ActorFactoryComponentRenderer {


  protected static String nl;
  public static synchronized ActorFactoryComponentRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorFactoryComponentRenderer result = new ActorFactoryComponentRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" activate=\"activate\" immediate=\"true\" name=\"";
  protected final String TEXT_2 = " factory\">" + NL + "   <implementation class=\"";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "ActorFactoryImpl\"/>" + NL + "   <reference " + NL + "   \t\tbind=\"setPageFactory\" " + NL + "   \t\tcardinality=\"1..1\" " + NL + "   \t\tinterface=\"";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "PageFactory\" " + NL + "   \t\tname=\"";
  protected final String TEXT_7 = "PageFactory\" " + NL + "   \t\tpolicy=\"static\"/>" + NL + "   \t\t" + NL + "   <service>" + NL + "      <provide interface=\"";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "ActorFactory\"/>" + NL + "   </service>" + NL + "</scr:component>";
  protected final String TEXT_10 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getActorSpecArtifactId());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}