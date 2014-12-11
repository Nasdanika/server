package org.nasdanika.workspace.wizard;

public class TestRenderer {


  protected static String nl;
  public static synchronized TestRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestRenderer result = new TestRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.concurrent.TimeUnit;" + NL + "" + NL + "import org.junit.After;" + NL + "import org.junit.Assert;" + NL + "import org.junit.Before;" + NL + "import org.junit.FixMethodOrder;" + NL + "import org.junit.Test;" + NL + "import org.junit.runner.RunWith;" + NL + "import org.junit.runners.MethodSorters;" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "ActorFactory;" + NL + "import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "Actor;" + NL + "import ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "Page;" + NL + "import org.nasdanika.webtest.Actor;" + NL + "import org.nasdanika.webtest.ActorFactory;" + NL + "import org.nasdanika.webtest.Description;" + NL + "import org.nasdanika.webtest.NasdanikaWebTestRunner;" + NL + "import org.nasdanika.webtest.Screenshot;" + NL + "import org.nasdanika.webtest.WebTest;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "import org.openqa.selenium.firefox.FirefoxDriver;" + NL + "" + NL + "@RunWith(NasdanikaWebTestRunner.class)" + NL + "@FixMethodOrder(MethodSorters.NAME_ASCENDING)" + NL + "@Description(\"Tests of ";
  protected final String TEXT_9 = "\")" + NL + "public class ";
  protected final String TEXT_10 = "Test implements WebTest<WebDriver> {" + NL + "\tprivate WebDriver driver;" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic WebDriver getWebDriver() {" + NL + "\t\treturn driver;" + NL + "\t}" + NL + "\t\t" + NL + "\t@ActorFactory" + NL + "\tpublic ";
  protected final String TEXT_11 = "ActorFactory actorFactory;" + NL + "" + NL + "\t@Before" + NL + "\tpublic void setUp() throws Exception {" + NL + "        driver = new FirefoxDriver(); // new ChromeDriver();" + NL + "        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);" + NL + "\t}" + NL + "\t" + NL + "\t@Test" + NL + "\t@Description(\"Test 1\")" + NL + "\t@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})" + NL + "\tpublic void testOne() throws Exception {" + NL + "\t\t";
  protected final String TEXT_12 = "Actor actor = actorFactory.create";
  protected final String TEXT_13 = "Actor(getWebDriver());" + NL + "\t\t";
  protected final String TEXT_14 = "Page page = actor.navigateTo";
  protected final String TEXT_15 = "Page();" + NL + "\t\tAssert.assertNotNull(page); // TODO - implement assertions" + NL + "\t}" + NL + "\t" + NL + "\t@After" + NL + "\tpublic void quitDriver() throws Exception {" + NL + "\t\tif (driver!=null) {" + NL + "\t        driver.quit();" + NL + "\t        driver = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic long getScreenshotDelay() {" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_16 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
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
    stringBuffer.append(wizard.getName());
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
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}