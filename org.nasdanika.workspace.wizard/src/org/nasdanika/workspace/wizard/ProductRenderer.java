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
  protected final String TEXT_5 = ".TestRunner\"";
  protected final String TEXT_6 = " version=\"";
  protected final String TEXT_7 = ".qualifier\" useFeatures=\"true\" includeLaunchers=\"true\">" + NL + "" + NL + "   <configIni use=\"default\">" + NL + "   </configIni>" + NL + "" + NL + "   <launcherArgs>" + NL + "      <programArgs>-consoleLog";
  protected final String TEXT_8 = " -console";
  protected final String TEXT_9 = NL + "      </programArgs>";
  protected final String TEXT_10 = "<vmArgs>-Declipse.ignoreApp=true -Dosgi.noShutdown=true -Dorg.osgi.service.http.port=8080 ";
  protected final String TEXT_11 = "-Dorg.eclipse.equinox.http.jetty.context.path=";
  protected final String TEXT_12 = NL + "      </vmArgs>";
  protected final String TEXT_13 = NL + "      <vmArgsMac>-XstartOnFirstThread -Dorg.eclipse.swt.internal.carbon.smallFonts" + NL + "      </vmArgsMac>" + NL + "   </launcherArgs>" + NL + "" + NL + "   <launcher>" + NL + "      <solaris/>" + NL + "      <win useIco=\"false\">" + NL + "         <bmp/>" + NL + "      </win>" + NL + "   </launcher>" + NL + "" + NL + "   <vm>" + NL + "      <windows include=\"false\">org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7</windows>" + NL + "   </vm>" + NL + "" + NL + "   <features>" + NL + "      <feature id=\"";
  protected final String TEXT_14 = ".feature\" version=\"";
  protected final String TEXT_15 = ".qualifier\"/>" + NL + "   </features>" + NL + "" + NL + "   <configurations>";
  protected final String TEXT_16 = NL + "      <plugin id=\"org.eclipse.core.runtime\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.common\" autoStart=\"true\" startLevel=\"2\" />" + NL + "      <plugin id=\"org.eclipse.equinox.ds\" autoStart=\"true\" startLevel=\"1\" />" + NL + "      <plugin id=\"org.eclipse.osgi\" autoStart=\"true\" startLevel=\"-1\" />";
  protected final String TEXT_17 = NL + "      <plugin id=\"org.eclipse.equinox.http.jetty\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"org.eclipse.equinox.http.registry\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_18 = NL + "      <plugin id=\"org.nasdanika.cdo.web\" autoStart=\"true\" startLevel=\"0\" />" + NL + "      <plugin id=\"";
  protected final String TEXT_19 = "\" autoStart=\"true\" startLevel=\"0\" />";
  protected final String TEXT_20 = NL + "   </configurations>" + NL + "</product>";
  protected final String TEXT_21 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_3);
     if (!wizard.isApplication() && wizard.isTests()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_7);
     if (wizard.getApplicationArtifactId()!=null) { 
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
     if (wizard.isApplication()) { 
    stringBuffer.append(TEXT_10);
     if (wizard.getContextPath()!=null) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(wizard.getContextPath());
     } 
    stringBuffer.append(TEXT_12);
     } 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_15);
     if (wizard.isIncludeEquinox()) { 
    stringBuffer.append(TEXT_16);
     } 
     if (wizard.isIncludeJetty()) { 
    stringBuffer.append(TEXT_17);
     } 
     if (wizard.getApplicationPlugin()!=null) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(wizard.getApplicationPlugin());
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}