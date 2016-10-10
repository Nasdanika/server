package org.nasdanika.workspace.wizard;

public class ModelBuildPropertiesRenderer {


  protected static String nl;
  public static synchronized ModelBuildPropertiesRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelBuildPropertiesRenderer result = new ModelBuildPropertiesRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "bin.includes = .,\\" + NL + "               model/,\\" + NL + "               META-INF/" + NL + "jars.compile.order = ." + NL + "source.. = src/";
  protected final String TEXT_2 = NL;

public String generate(org.nasdanika.workspace.wizard.ModelingWorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}