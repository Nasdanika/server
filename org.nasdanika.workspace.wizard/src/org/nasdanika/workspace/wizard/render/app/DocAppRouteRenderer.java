package org.nasdanika.workspace.wizard.render.app;

public class DocAppRouteRenderer {


  protected static String nl;
  public static synchronized DocAppRouteRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    DocAppRouteRenderer result = new DocAppRouteRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.apache.commons.lang3.StringEscapeUtils;" + NL + "import org.nasdanika.cdo.web.doc.DocumentationPanelFactory;" + NL + "import org.nasdanika.html.ApplicationPanel;" + NL + "import org.nasdanika.html.HTMLFactory;" + NL + "import org.nasdanika.html.Table;" + NL + "import org.nasdanika.html.RowContainer.Row;" + NL + "import org.nasdanika.html.Tag;" + NL + "import org.nasdanika.html.Tag.TagName;" + NL + "import org.nasdanika.html.Theme;" + NL + "import org.nasdanika.html.UIElement.Style;" + NL + "import org.nasdanika.web.Action;" + NL + "import org.nasdanika.web.HttpServletRequestContext;" + NL + "import org.nasdanika.web.Route;" + NL + "" + NL + "public class ";
  protected final String TEXT_3 = "DocAppRoute implements Route {" + NL + "" + NL + "\t@Override" + NL + "\tpublic Action execute(HttpServletRequestContext context, Object... args) throws Exception {" + NL + "\t\tHTMLFactory htmlFactory = context.adapt(HTMLFactory.class);" + NL + "\t\tApplicationPanel appPanel = htmlFactory.applicationPanel()" + NL + "\t\t\t\t.style(Style.INFO) " + NL + "\t\t\t\t.header(\"";
  protected final String TEXT_4 = " Information Center\")" + NL + "\t\t\t\t.headerLink(context.getRequest().getContextPath()+\"";
  protected final String TEXT_5 = "/";
  protected final String TEXT_6 = "\")" + NL + "\t\t\t\t.style(\"margin-bottom\", \"0px\")" + NL + "\t\t\t\t.id(\"docAppPanel\");" + NL + "\t\t" + NL + "\t\tTable table = htmlFactory.table().style(\"margin-bottom\", \"0px\");" + NL + "\t\tRow row = table.row();" + NL + "\t\tDocumentationPanelFactory documentationPanelFactory = new DocumentationPanelFactory(htmlFactory, context.getContextURL()+\"/";
  protected final String TEXT_7 = "\") {" + NL + "" + NL + "\t\t\t@Override" + NL + "\t\t\tprotected Tag tocDiv() {" + NL + "\t\t\t\treturn super.tocDiv().style(\"overflow-y\", \"scroll\");" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\trow.cell(documentationPanelFactory.leftPanel()).id(\"left-panel\").style(\"min-width\", \"17em\");" + NL + "\t\trow.cell(\"\")" + NL + "\t\t\t.id(\"splitter\")" + NL + "\t\t\t.style(\"width\", \"5px\")" + NL + "\t\t\t.style(\"min-width\", \"5px\")" + NL + "\t\t\t.style(\"padding\", \"0px\")" + NL + "\t\t\t.style(\"background\", \"#d9edf7\")" + NL + "\t\t\t.style(\"border\", \"solid 1px #bce8f1\")" + NL + "\t\t\t.style(\"cursor\", \"col-resize\");" + NL + "\t\trow.cell(documentationPanelFactory.rightPanel()).id(\"right-panel\");" + NL + "\t\t\t\t" + NL + "\t\tappPanel.contentPanel(" + NL + "\t\t\t\ttable, " + NL + "\t\t\t\thtmlFactory.tag(TagName.script, getClass().getResource(\"Splitter.js\"))," + NL + "\t\t\t\thtmlFactory.tag(TagName.script, getClass().getResource(\"Scroller.js\"))," + NL + "\t\t\t\thtmlFactory.tag(TagName.script, getClass().getResource(\"SetDimensions.js\")));" + NL + "\t\t" + NL + "\t\tfinal AutoCloseable app = htmlFactory.bootstrapRouterApplication(" + NL + "\t\t\t\tTheme.Default," + NL + "\t\t\t\tStringEscapeUtils.escapeHtml4(\"Documentation\"), " + NL + "\t\t\t\tnull, //\"main/doc/index.html\", " + NL + "\t\t\t\thtmlFactory.fragment(" + NL + "\t\t\t\t\t\thtmlFactory.tag(TagName.link)" + NL + "\t\t\t\t\t\t\t.attribute(\"rel\", \"stylesheet\")" + NL + "\t\t\t\t\t\t\t.attribute(\"href\", context.getContextURL()+\"/";
  protected final String TEXT_8 = "/resources/highlight/styles/github.css\"),\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\thtmlFactory.tag(TagName.link)" + NL + "\t\t\t\t\t\t\t.attribute(\"rel\", \"stylesheet\")" + NL + "\t\t\t\t\t\t\t.attribute(\"href\", context.getContextURL()+\"/";
  protected final String TEXT_9 = "/resources/css/github-markdown.css\"),\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\thtmlFactory.tag(TagName.link)" + NL + "\t\t\t\t\t\t\t.attribute(\"rel\", \"stylesheet\")" + NL + "\t\t\t\t\t\t\t.attribute(\"href\", context.getContextURL()+\"/";
  protected final String TEXT_10 = "/resources/jstree/themes/default/style.min.css\")," + NL + "\t\t\t\t\t\thtmlFactory.tag(TagName.script, \"\")" + NL + "\t\t\t\t\t\t\t.attribute(\"src\", context.getContextURL()+\"/";
  protected final String TEXT_11 = "/resources/highlight/highlight.pack.js\")), " + NL + "\t\t\t\tappPanel);" + NL + "\t\t" + NL + "\t\treturn new Action() {" + NL + "\t\t\t" + NL + "\t\t\t@Override" + NL + "\t\t\tpublic void close() throws Exception {" + NL + "\t\t\t\tapp.close();\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t@Override" + NL + "\t\t\tpublic Object execute() throws Exception {" + NL + "\t\t\t\treturn app.toString();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean canExecute() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void close() throws Exception {" + NL + "\t\t// NOP" + NL + "\t}" + NL + "" + NL + "}";

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
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getDocAppRoutePath());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getDocRoutePath());
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}