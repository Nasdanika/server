package org.nasdanika.workspace.wizard;

public class ActorImplRenderer {


  protected static String nl;
  public static synchronized ActorImplRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorImplRenderer result = new ActorImplRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "Actor;" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "ActorFactory;" + NL + "import ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "Page;" + NL + "import org.nasdanika.webtest.Description;" + NL + "import org.nasdanika.webtest.Page;" + NL + "import org.nasdanika.webtest.Screenshot;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "" + NL + "class ";
  protected final String TEXT_9 = "ActorImpl implements ";
  protected final String TEXT_10 = "Actor {" + NL + "" + NL + "\tprivate ";
  protected final String TEXT_11 = "ActorFactory factory;" + NL + "\tprivate Page<WebDriver> currentPage;" + NL + "\tprivate WebDriver webDriver;" + NL + "" + NL + "\t";
  protected final String TEXT_12 = "ActorImpl(";
  protected final String TEXT_13 = "ActorFactory factory, WebDriver webDriver) {" + NL + "\t\tthis.factory = factory;" + NL + "\t\tthis.webDriver = webDriver;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic Page<WebDriver> getCurrentPage() {" + NL + "\t\treturn currentPage;" + NL + "\t}" + NL + "\t" + NL + "\t@Override\t\t" + NL + "\t@Description(\"Navigates to ";
  protected final String TEXT_14 = "Page\")" + NL + "\t@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})" + NL + "\tpublic ";
  protected final String TEXT_15 = "Page navigateTo";
  protected final String TEXT_16 = "Page() {" + NL + "\t\twebDriver.get(\"http://localhost:8080";
  protected final String TEXT_17 = "/";
  protected final String TEXT_18 = ".html\");" + NL + "\t\t";
  protected final String TEXT_19 = "Page ret = factory.getPageFactory().create";
  protected final String TEXT_20 = "Page(webDriver);" + NL + "\t\t" + NL + "\t\treturn ret;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_21 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getActorSpecArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getActorSpecArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getPageSpecArtifactId());
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
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(wizard.getContextPath());
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}