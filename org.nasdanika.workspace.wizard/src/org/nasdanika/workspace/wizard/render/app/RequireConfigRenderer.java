package org.nasdanika.workspace.wizard.render.app;

public class RequireConfigRenderer {


  protected static String nl;
  public static synchronized RequireConfigRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    RequireConfigRenderer result = new RequireConfigRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "require.config({" + NL + "    baseUrl: '";
  protected final String TEXT_2 = "js'," + NL + "    paths: {" + NL + "        jquery: 'jquery-global', " + NL + "        knockout: 'knockout-3.3.0'" + NL + "    }" + NL + "});";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getContextPath());
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}