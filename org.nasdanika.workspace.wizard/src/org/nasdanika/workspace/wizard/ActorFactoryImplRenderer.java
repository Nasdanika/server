package org.nasdanika.workspace.wizard;

public class ActorFactoryImplRenderer {


  protected static String nl;
  public static synchronized ActorFactoryImplRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorFactoryImplRenderer result = new ActorFactoryImplRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "PageFactory;" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "ActorFactory;" + NL + "import ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "Actor;" + NL + "import org.nasdanika.webtest.AbstractNasdanikaWebTestRunner;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "import org.osgi.service.component.ComponentContext;" + NL + "" + NL + "public class ";
  protected final String TEXT_9 = "ActorFactoryImpl implements ";
  protected final String TEXT_10 = "ActorFactory {" + NL + "" + NL + "\tprivate ";
  protected final String TEXT_11 = "PageFactory pageFactory;" + NL + "" + NL + "\tpublic void setPageFactory(";
  protected final String TEXT_12 = "PageFactory pageFactory) {" + NL + "\t\tthis.pageFactory = AbstractNasdanikaWebTestRunner.proxyPageFactory(pageFactory);" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic ";
  protected final String TEXT_13 = "Actor create";
  protected final String TEXT_14 = "Actor(WebDriver webDriver) {" + NL + "\t\treturn new ";
  protected final String TEXT_15 = "ActorImpl(this, webDriver);" + NL + "\t}" + NL + "\t" + NL + "\t// For troubleshooting" + NL + "\tpublic void activate(ComponentContext context) {" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_16 = " Actor Factory Component activated\");" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic ";
  protected final String TEXT_17 = "PageFactory getPageFactory() {" + NL + "\t\treturn pageFactory;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_18 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getPageSpecArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getActorSpecArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getActorSpecArtifactId());
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
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}