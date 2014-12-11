package org.nasdanika.workspace.wizard;

public class PageFactorySpecRenderer {


  protected static String nl;
  public static synchronized PageFactorySpecRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    PageFactorySpecRenderer result = new PageFactorySpecRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "public interface ";
  protected final String TEXT_3 = "PageFactory {" + NL + "\t" + NL + "\t";
  protected final String TEXT_4 = "Page create";
  protected final String TEXT_5 = "Page(WebDriver webDriver);" + NL + "\t" + NL + "}";
  protected final String TEXT_6 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}