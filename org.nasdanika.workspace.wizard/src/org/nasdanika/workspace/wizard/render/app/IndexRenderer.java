package org.nasdanika.workspace.wizard.render.app;

public class IndexRenderer {


  protected static String nl;
  public static synchronized IndexRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    IndexRenderer result = new IndexRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<html>" + NL + "\t<head>" + NL + "\t\t<title>";
  protected final String TEXT_2 = "</title>" + NL + "\t\t<META http-equiv=\"refresh\" content=\"0;URL=";
  protected final String TEXT_3 = "/transaction/elements/";
  protected final String TEXT_4 = "/0.html\">" + NL + "\t</head>" + NL + "\t<body>" + NL + "\t\tRedirecting to the home page." + NL + "\t</body>" + NL + "</html>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}