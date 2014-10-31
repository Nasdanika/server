package org.nasdanika.workspace.wizard.render.app;

public class ApplicationPluginRenderer {


  protected static String nl;
  public static synchronized ApplicationPluginRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ApplicationPluginRenderer result = new ApplicationPluginRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.4\"?>" + NL + "<plugin>";
  protected final String TEXT_2 = NL + "   <extension" + NL + "         point=\"org.eclipse.equinox.http.registry.servlets\">" + NL + "      <servlet" + NL + "            alias=\"";
  protected final String TEXT_3 = "\"" + NL + "            class=\"org.nasdanika.web.RoutingServlet\">" + NL + "         <init-param" + NL + "               name=\"json-pretty-print\"" + NL + "               value=\"true\">" + NL + "         </init-param>" + NL + "         <init-param" + NL + "               name=\"default-access-decision\"" + NL + "               value=\"deny\">" + NL + "         </init-param>" + NL + "      </servlet>" + NL + "   </extension>";
  protected final String TEXT_4 = NL + "   <extension" + NL + "         point=\"org.eclipse.equinox.http.registry.resources\">" + NL + "      <resource" + NL + "            alias=\"";
  protected final String TEXT_5 = "\"" + NL + "            base-name=\"";
  protected final String TEXT_6 = "\">" + NL + "      </resource>" + NL + "   </extension>";
  protected final String TEXT_7 = NL + "   <extension point=\"org.nasdanika.web.route\">" + NL + "      <object_route" + NL + "            class=\"org.nasdanika.web.routes.ServiceRoute\"" + NL + "            method=\"*\"" + NL + "            pattern=\"[^/]+/services/.+\"" + NL + "            target=\"org.eclipse.emf.cdo.view.CDOView\">" + NL + "         <property" + NL + "               name=\"offset\"" + NL + "               value=\"2\">" + NL + "         </property>" + NL + "      </object_route>" + NL + "   </extension>";
  protected final String TEXT_8 = NL + "   <extension point=\"org.nasdanika.web.html_factory\">" + NL + "      <default_html_factory" + NL + "            bootstrapCssContainer=\"/bootstrap/css\">" + NL + "            <script>" + NL + "               /js/jquery-1.11.1.min.js" + NL + "            </script>" + NL + "            <script>" + NL + "               /js/underscore-min.js" + NL + "            </script>" + NL + "            <script>/js/backbone-min.js</script>" + NL + "            <script>/bootstrap/js/bootstrap.min.js</script>" + NL + "            <script>" + NL + "               /js/require.js" + NL + "            </script>" + NL + "      </default_html_factory>" + NL + "   </extension>";
  protected final String TEXT_9 = NL + "   <extension point=\"org.nasdanika.cdo.security.security_policy\">" + NL + "      <policy_resource" + NL + "            resource=\"";
  protected final String TEXT_10 = ".nasdanika_cdo_security\">" + NL + "      </policy_resource>" + NL + "   </extension>" + NL + "</plugin>";
  protected final String TEXT_11 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     if (wizard.getRoutingServletAlias()!=null) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_3);
     } 
     if (wizard.getWebContentAlias()!=null) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getWebContentBaseName());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
     if (wizard.getWebContentAlias()!=null) { 
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}