package org.nasdanika.workspace.wizard;

public class TestsProductRenderer {


  protected static String nl;
  public static synchronized TestsProductRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestsProductRenderer result = new TestsProductRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?pde version=\"3.5\"?>" + NL + "" + NL + "<product name=\"";
  protected final String TEXT_2 = " Tests\" uid=\"";
  protected final String TEXT_3 = ".product\" application=\"";
  protected final String TEXT_4 = ".TestRunner\" version=\"";
  protected final String TEXT_5 = ".qualifier\" useFeatures=\"true\" includeLaunchers=\"true\">" + NL + "" + NL + "   <configIni use=\"default\">" + NL + "   </configIni>" + NL + "" + NL + "   <launcherArgs>" + NL + "      <programArgs>-consoleLog" + NL + "      </programArgs>" + NL + "      <vmArgs>-Dorg.osgi.service.http.port=8080" + NL + "      </vmArgs>" + NL + "      <vmArgsMac>-XstartOnFirstThread -Dorg.eclipse.swt.internal.carbon.smallFonts" + NL + "      </vmArgsMac>" + NL + "   </launcherArgs>" + NL + "" + NL + "   <launcher>" + NL + "      <solaris/>" + NL + "      <win useIco=\"false\">" + NL + "         <bmp/>" + NL + "      </win>" + NL + "   </launcher>" + NL + "" + NL + "   <vm>" + NL + "      <windows include=\"false\">org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7</windows>" + NL + "   </vm>" + NL + "" + NL + "   <features>" + NL + "      <feature id=\"";
  protected final String TEXT_6 = ".feature\" version=\"";
  protected final String TEXT_7 = ".qualifier\"/>" + NL + "   </features>" + NL + "" + NL + "   <configurations>";
  protected final String TEXT_8 = NL + "      <plugin id=\"org.eclipse.core.runtime\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.common\" autoStart=\"true\" startLevel=\"2\" />" + NL + "      <plugin id=\"org.eclipse.equinox.ds\" autoStart=\"true\" startLevel=\"1\" />" + NL + "      <plugin id=\"org.eclipse.osgi\" autoStart=\"true\" startLevel=\"-1\" />";
  protected final String TEXT_9 = NL + "      <plugin id=\"org.eclipse.equinox.http.jetty\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.http.registry\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_10 = NL + "      <plugin id=\"";
  protected final String TEXT_11 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_12 = NL + "      <plugin id=\"";
  protected final String TEXT_13 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_14 = NL + "      <plugin id=\"";
  protected final String TEXT_15 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_16 = NL + "   </configurations>" + NL + "</product>";
  protected final String TEXT_17 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_7);
     if (wizard.isIncludeEquinox()) { 
    stringBuffer.append(TEXT_8);
     } 
     if (wizard.isIncludeJetty()) { 
    stringBuffer.append(TEXT_9);
     } 
     if (wizard.getPageImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_11);
     } 
     if (wizard.getActorImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_13);
     } 
     if (wizard.getApplicationPlugin()!=null) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(wizard.getApplicationPlugin());
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}