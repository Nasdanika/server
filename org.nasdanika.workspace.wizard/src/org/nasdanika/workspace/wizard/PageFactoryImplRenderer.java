package org.nasdanika.workspace.wizard;

public class PageFactoryImplRenderer {


  protected static String nl;
  public static synchronized PageFactoryImplRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    PageFactoryImplRenderer result = new PageFactoryImplRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "PageFactory;" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "Page;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "import org.nasdanika.webtest.WebTestUtil;" + NL + "import org.osgi.service.component.ComponentContext;" + NL + "" + NL + "public class ";
  protected final String TEXT_7 = "PageFactoryImpl implements ";
  protected final String TEXT_8 = "PageFactory {" + NL + "" + NL + "\tprivate String baseURL;" + NL + "\t" + NL + "\tpublic void activate(ComponentContext context) {" + NL + "\t\tbaseURL = (String) context.getProperties().get(\"base-url\");" + NL + "\t\tSystem.out.println(\"Page factory component activated with base URL '\"+baseURL+\"'\");" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setBaseURL(String baseURL) {" + NL + "\t\tthis.baseURL = baseURL;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic ";
  protected final String TEXT_9 = "Page create";
  protected final String TEXT_10 = "Page(WebDriver webDriver) {" + NL + "\t\t";
  protected final String TEXT_11 = "PageImpl ret = WebTestUtil.initElements(webDriver, ";
  protected final String TEXT_12 = "PageImpl.class);" + NL + "\t\tret.setFactory(this);" + NL + "\t\treturn ret;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getBaseURL() {" + NL + "\t\treturn baseURL;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_13 = NL;

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
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}