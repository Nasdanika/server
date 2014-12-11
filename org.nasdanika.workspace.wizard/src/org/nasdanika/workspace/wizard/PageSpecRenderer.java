package org.nasdanika.workspace.wizard;

public class PageSpecRenderer {


  protected static String nl;
  public static synchronized PageSpecRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    PageSpecRenderer result = new PageSpecRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.nasdanika.webtest.Description;" + NL + "import org.nasdanika.webtest.Page;" + NL + "import org.nasdanika.webtest.Title;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "@Title(\"";
  protected final String TEXT_3 = " Page\")" + NL + "@Description(\"Page class for testing ";
  protected final String TEXT_4 = "\")" + NL + "public interface ";
  protected final String TEXT_5 = "Page extends Page<WebDriver> {" + NL + "\t" + NL + "" + NL + "\t" + NL + "}";
  protected final String TEXT_6 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}