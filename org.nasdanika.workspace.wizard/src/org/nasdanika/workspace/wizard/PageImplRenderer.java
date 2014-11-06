package org.nasdanika.workspace.wizard;

public class PageImplRenderer {


  protected static String nl;
  public static synchronized PageImplRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    PageImplRenderer result = new PageImplRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "Page;" + NL + "import org.nasdanika.webtest.Wait;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "@Wait(id=\"button-groups\")" + NL + "public class ";
  protected final String TEXT_5 = "PageImpl implements ";
  protected final String TEXT_6 = "Page {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_7 = "PageFactoryImpl factory;" + NL + "\tprivate WebDriver webDriver;\t" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_8 = "PageImpl(WebDriver webDriver) {" + NL + "\t\tthis.webDriver = webDriver;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setFactory(";
  protected final String TEXT_9 = "PageFactoryImpl factory) {" + NL + "\t\tthis.factory = factory;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic WebDriver getWebDriver() {" + NL + "\t\treturn webDriver;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_10 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}