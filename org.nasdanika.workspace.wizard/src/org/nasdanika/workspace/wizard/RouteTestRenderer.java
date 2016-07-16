package org.nasdanika.workspace.wizard;

public class RouteTestRenderer {


  protected static String nl;
  public static synchronized RouteTestRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    RouteTestRenderer result = new RouteTestRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.awt.GraphicsEnvironment;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collection;" + NL + "import java.util.List;" + NL + "import java.util.concurrent.TimeUnit;" + NL + "" + NL + "import org.junit.After;" + NL + "import org.junit.Before;" + NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.fail;" + NL + "import org.junit.runner.RunWith;" + NL + "import org.junit.runners.Parameterized.Parameter;" + NL + "import org.junit.runners.Parameterized.Parameters;" + NL + "import org.nasdanika.webtest.Description;" + NL + "import org.nasdanika.webtest.NasdanikaParameterizedWebTestRunner;" + NL + "import org.nasdanika.webtest.Screenshot;" + NL + "import org.nasdanika.webtest.WebTest;" + NL + "import org.openqa.selenium.WebDriver;" + NL + "import org.openqa.selenium.firefox.FirefoxDriver;" + NL + "import org.openqa.selenium.phantomjs.PhantomJSDriver;" + NL + "" + NL + "@RunWith(NasdanikaParameterizedWebTestRunner.class)" + NL + "@Description(\"Tests ";
  protected final String TEXT_3 = "Route\")" + NL + "public class ";
  protected final String TEXT_4 = "RouteTest implements WebTest<WebDriver> {" + NL + "\t" + NL + "\tpublic enum DriverType { firefox, chrome, ie, phantomjs } " + NL + "\t" + NL + "\tprivate WebDriver driver;" + NL + "\t\t" + NL + "\t@Parameters(name=\"{index}: {0}\")" + NL + "\tpublic static Collection<Object[]> registrationData() {" + NL + "\t\tList<Object[]> ret = new ArrayList<>();" + NL + "\t\tret.add(new Object[] { GraphicsEnvironment.isHeadless() ? DriverType.phantomjs : DriverType.firefox }); // TODO Add other browsers" + NL + "\t\treturn ret;" + NL + "\t}" + NL + "\t" + NL + "\t@Parameter(0)" + NL + "\tpublic DriverType driverType;" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic WebDriver getWebDriver() {" + NL + "\t\treturn driver;" + NL + "\t}" + NL + "" + NL + "\t@Before" + NL + "\tpublic void setUp() throws Exception {" + NL + "\t\tswitch (driverType) {" + NL + "\t\tcase firefox:" + NL + "\t        driver = new FirefoxDriver();" + NL + "\t        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);" + NL + "\t\t\tbreak;" + NL + "\t\tcase phantomjs:" + NL + "\t        driver = new PhantomJSDriver();" + NL + "\t        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);" + NL + "\t\t\tbreak;" + NL + "\t\tdefault:" + NL + "\t\t\tfail(\"Unsupported driver type: \");\t\t" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t@Test" + NL + "\t@Description(\"";
  protected final String TEXT_5 = " Route\")" + NL + "\t@Screenshot({Screenshot.When.AFTER, Screenshot.When.EXCEPTION})" + NL + "\tpublic void appRoute() throws Exception {" + NL + "\t\tgetWebDriver().get(\"http://localhost:8080";
  protected final String TEXT_6 = "/";
  protected final String TEXT_7 = ".html\");" + NL + "\t\t//new WebDriverWait(getWebDriver(), 20).until(ExpectedConditions.visibilityOfElementLocated(By.id(\"button-groups\")));\t\t" + NL + "\t}" + NL + "\t" + NL + "\t@After" + NL + "\tpublic void quitDriver() throws Exception {" + NL + "\t\tif (driver!=null) {" + NL + "\t        driver.quit();" + NL + "\t        driver = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic long getScreenshotDelay() {" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_8 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getContextPath());
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}