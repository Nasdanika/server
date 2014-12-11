package org.nasdanika.workspace.wizard;

public class ActorFactorySpecRenderer {


  protected static String nl;
  public static synchronized ActorFactorySpecRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorFactorySpecRenderer result = new ActorFactorySpecRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "PageFactory;";
  protected final String TEXT_6 = NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "public interface ";
  protected final String TEXT_7 = "ActorFactory {" + NL + "\t" + NL + "\t";
  protected final String TEXT_8 = "PageFactory getPageFactory();" + NL + "\t" + NL + "\t";
  protected final String TEXT_9 = "Actor create";
  protected final String TEXT_10 = "Actor(WebDriver webDriver);" + NL + "" + NL + "}";
  protected final String TEXT_11 = NL;

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
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}