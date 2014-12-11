package org.nasdanika.workspace.wizard;

public class PageFactoryComponentRenderer {


  protected static String nl;
  public static synchronized PageFactoryComponentRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    PageFactoryComponentRenderer result = new PageFactoryComponentRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<scr:component xmlns:scr=\"http://www.osgi.org/xmlns/scr/v1.1.0\" activate=\"activate\" immediate=\"true\" name=\"";
  protected final String TEXT_2 = " page factory\">" + NL + "   <implementation class=\"";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "PageFactoryImpl\"/>" + NL + "   <service>" + NL + "      <provide interface=\"";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "PageFactory\"/>" + NL + "   </service>" + NL + "   <property name=\"base-url\" type=\"String\" value=\"http://localhost:8080\"/>" + NL + "</scr:component>";
  protected final String TEXT_7 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}