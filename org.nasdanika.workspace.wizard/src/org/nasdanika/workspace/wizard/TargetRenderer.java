package org.nasdanika.workspace.wizard;

public class TargetRenderer {


  protected static String nl;
  public static synchronized TargetRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TargetRenderer result = new TargetRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + NL + "<?pde version=\"3.8\"?>" + NL + "<target includeMode=\"feature\" name=\"";
  protected final String TEXT_2 = ".target\" sequenceNumber=\"3\">" + NL + "\t<locations>" + NL + "\t\t<location includeAllPlatforms=\"false\" includeConfigurePhase=\"true\" includeMode=\"planner\" includeSource=\"true\" type=\"InstallableUnit\">" + NL + "\t\t\t";
  protected final String TEXT_3 = "<unit id=\"org.nasdanika.server.jetty.feature.feature.group\"/>";
  protected final String TEXT_4 = NL + "\t\t\t";
  protected final String TEXT_5 = "<unit id=\"org.nasdanika.feature.feature.group\"/>";
  protected final String TEXT_6 = NL + "\t\t\t";
  protected final String TEXT_7 = "<unit id=\"org.nasdanika.equinox.feature.feature.group\"/>";
  protected final String TEXT_8 = NL + "\t\t\t";
  protected final String TEXT_9 = "<unit id=\"org.nasdanika.webtest.feature.feature.group\"/>";
  protected final String TEXT_10 = NL + "\t\t\t";
  protected final String TEXT_11 = "<unit id=\"org.nasdanika.cdo.feature.feature.group\"/>";
  protected final String TEXT_12 = NL + "\t\t\t<repository location=\"http://www.nasdanika.org/server/repository\"/>" + NL + "\t\t</location>" + NL + "\t</locations>" + NL + "</target>";
  protected final String TEXT_13 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
     if (wizard.isIncludeJetty()) { 
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
     if (wizard.isIncludeNasdanika()) { 
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
     if (wizard.isIncludeEquinox()) { 
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
     if (wizard.isIncludeWebTest()) { 
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
     if (wizard.isIncludeCdo()) { 
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}