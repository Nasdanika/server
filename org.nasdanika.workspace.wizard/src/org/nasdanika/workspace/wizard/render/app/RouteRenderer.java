package org.nasdanika.workspace.wizard.render.app;

public class RouteRenderer {


  protected static String nl;
  public static synchronized RouteRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    RouteRenderer result = new RouteRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.nasdanika.web.HttpServletRequestContext;" + NL + "import org.nasdanika.web.ValueAction;" + NL + "import org.nasdanika.web.Route;" + NL + "" + NL + "/**" + NL + " * Route to demonstrate/test HTMLFactory capabilities" + NL + " *" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = "Route implements Route {" + NL + "" + NL + "\t@Override" + NL + "\tpublic Action execute(HttpServletRequestContext context, Object... args) throws Exception {" + NL + "\t\treturn new ValueAction(\"";
  protected final String TEXT_4 = " Works!!!\");" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean canExecute() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void close() throws Exception {" + NL + "\t\t// NOP" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}