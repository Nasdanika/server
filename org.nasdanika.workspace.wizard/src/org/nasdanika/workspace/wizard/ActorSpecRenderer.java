package org.nasdanika.workspace.wizard;

public class ActorSpecRenderer {


  protected static String nl;
  public static synchronized ActorSpecRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorSpecRenderer result = new ActorSpecRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "Page;";
  protected final String TEXT_6 = NL + "import org.nasdanika.webtest.Actor;" + NL + "import org.nasdanika.webtest.Description;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "@Description(\"";
  protected final String TEXT_7 = " Actor\")" + NL + "public interface ";
  protected final String TEXT_8 = "Actor extends Actor<WebDriver> {" + NL + "\t" + NL + "\t@Description(\"Navigates to ";
  protected final String TEXT_9 = "Page\")" + NL + "\t";
  protected final String TEXT_10 = "Page navigateTo";
  protected final String TEXT_11 = "Page();" + NL + "" + NL + "}";
  protected final String TEXT_12 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getActorSpecArtifactId());
    stringBuffer.append(TEXT_2);
     if (wizard.getPageSpecArtifactId()!=null) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}