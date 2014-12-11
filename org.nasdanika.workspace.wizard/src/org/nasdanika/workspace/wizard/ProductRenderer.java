package org.nasdanika.workspace.wizard;

public class ProductRenderer {


  protected static String nl;
  public static synchronized ProductRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ProductRenderer result = new ProductRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?pde version=\"3.5\"?>" + NL + "" + NL + "<product name=\"";
  protected final String TEXT_2 = "\" uid=\"";
  protected final String TEXT_3 = ".product\"";
  protected final String TEXT_4 = " application=\"";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "TestRunner\"";
  protected final String TEXT_7 = " version=\"";
  protected final String TEXT_8 = ".qualifier\" useFeatures=\"true\" includeLaunchers=\"true\">" + NL + "" + NL + "   <configIni use=\"default\">" + NL + "   </configIni>" + NL + "" + NL + "   <launcherArgs>" + NL + "      <programArgs>-consoleLog";
  protected final String TEXT_9 = " -console";
  protected final String TEXT_10 = NL + "      </programArgs>";
  protected final String TEXT_11 = "<vmArgs>-Declipse.ignoreApp=true -Dosgi.noShutdown=true -Dorg.osgi.service.http.port=8080" + NL + "      </vmArgs>";
  protected final String TEXT_12 = NL + "      <vmArgsMac>-XstartOnFirstThread -Dorg.eclipse.swt.internal.carbon.smallFonts" + NL + "      </vmArgsMac>" + NL + "   </launcherArgs>" + NL + "" + NL + "   <launcher>" + NL + "      <solaris/>" + NL + "      <win useIco=\"false\">" + NL + "         <bmp/>" + NL + "      </win>" + NL + "   </launcher>" + NL + "" + NL + "   <vm>" + NL + "      <windows include=\"false\">org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7</windows>" + NL + "   </vm>" + NL + "" + NL + "   <features>" + NL + "      <feature id=\"";
  protected final String TEXT_13 = ".feature\" version=\"";
  protected final String TEXT_14 = ".qualifier\"/>" + NL + "   </features>" + NL + "" + NL + "   <configurations>";
  protected final String TEXT_15 = NL + "      <plugin id=\"org.eclipse.core.runtime\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.common\" autoStart=\"true\" startLevel=\"2\" />" + NL + "      <plugin id=\"org.eclipse.equinox.ds\" autoStart=\"true\" startLevel=\"1\" />" + NL + "      <plugin id=\"org.eclipse.osgi\" autoStart=\"true\" startLevel=\"-1\" />";
  protected final String TEXT_16 = NL + "      <plugin id=\"org.eclipse.equinox.http.jetty\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.http.registry\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_17 = NL + "      <plugin id=\"";
  protected final String TEXT_18 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_19 = NL + "      <plugin id=\"";
  protected final String TEXT_20 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_21 = NL + "      <plugin id=\"";
  protected final String TEXT_22 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_23 = NL + "   </configurations>" + NL + "</product>";
  protected final String TEXT_24 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_3);
     if (wizard.getApplicationArtifactId()==null && wizard.getTestsArtifactId()!=null) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_8);
     if (wizard.getApplicationArtifactId()!=null) { 
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
     if (wizard.getApplicationArtifactId()!=null) { 
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_14);
     if (wizard.isIncludeEquinox()) { 
    stringBuffer.append(TEXT_15);
     } 
     if (wizard.isIncludeJetty()) { 
    stringBuffer.append(TEXT_16);
     } 
     if (wizard.getPageImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_18);
     } 
     if (wizard.getActorImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_20);
     } 
     if (wizard.getApplicationPlugin()!=null) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(wizard.getApplicationPlugin());
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}