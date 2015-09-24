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
  protected final String TEXT_2 = NL + "   <extension point=\"org.eclipse.equinox.http.registry.servlets\">" + NL + "   " + NL + "   \t";
  protected final String TEXT_3 = NL + "      <servlet" + NL + "            alias=\"";
  protected final String TEXT_4 = "\"" + NL + "            class=\"org.nasdanika.cdo.web.CDOTransactionRoutingServlet\"";
  protected final String TEXT_5 = " httpcontextId=\"";
  protected final String TEXT_6 = "\"";
  protected final String TEXT_7 = ">" + NL + "         <init-param" + NL + "               name=\"json-pretty-print\"" + NL + "               value=\"true\">" + NL + "         </init-param>" + NL + "         <init-param" + NL + "               name=\"default-access-decision\"" + NL + "               value=\"deny\">" + NL + "         </init-param>" + NL + "         <init-param" + NL + "               name=\"ws-session-path\"" + NL + "               value=\"";
  protected final String TEXT_8 = "\">" + NL + "         </init-param>" + NL + "      </servlet>" + NL + "      <!-- NTLM Authentication " + NL + "      <servlet" + NL + "            alias=\"/ntlm";
  protected final String TEXT_9 = "\"" + NL + "            class=\"org.nasdanika.cdo.web.CDOTransactionRoutingServlet\"";
  protected final String TEXT_10 = " httpcontextId=\"";
  protected final String TEXT_11 = "\"";
  protected final String TEXT_12 = ">" + NL + "         <init-param" + NL + "               name=\"json-pretty-print\"" + NL + "               value=\"true\">" + NL + "         </init-param>" + NL + "         <init-param" + NL + "               name=\"default-access-decision\"" + NL + "               value=\"deny\">" + NL + "         </init-param>" + NL + "         <init-param" + NL + "               name=\"ws-session-path\"" + NL + "               value=\"/ntlm";
  protected final String TEXT_13 = "\">" + NL + "         </init-param>" + NL + "      </servlet>" + NL + "\t   \t";
  protected final String TEXT_14 = NL + "\t      <servlet" + NL + "\t            alias=\"";
  protected final String TEXT_15 = "\"" + NL + "\t            class=\"org.nasdanika.cdo.web.SessionWebSocketServlet\"" + NL + "\t            ";
  protected final String TEXT_16 = " httpcontextId=\"";
  protected final String TEXT_17 = "\"";
  protected final String TEXT_18 = ">" + NL + "\t         <init-param" + NL + "\t               name=\"view-path\"" + NL + "\t               value=\"/ntlm";
  protected final String TEXT_19 = "\">" + NL + "\t         </init-param>" + NL + "\t      </servlet>" + NL + "\t\t";
  protected final String TEXT_20 = "   " + NL + "      -->";
  protected final String TEXT_21 = NL + "   \t";
  protected final String TEXT_22 = NL + "      <servlet" + NL + "            alias=\"";
  protected final String TEXT_23 = "\"" + NL + "            class=\"org.nasdanika.cdo.web.SessionWebSocketServlet\"";
  protected final String TEXT_24 = " httpcontextId=\"";
  protected final String TEXT_25 = "\"";
  protected final String TEXT_26 = ">" + NL + "         <init-param" + NL + "               name=\"view-path\"" + NL + "               value=\"";
  protected final String TEXT_27 = "\">" + NL + "         </init-param>" + NL + "      </servlet>" + NL + "\t";
  protected final String TEXT_28 = "   " + NL + "   </extension>";
  protected final String TEXT_29 = NL + "   " + NL + "\t";
  protected final String TEXT_30 = NL + "   <extension point=\"org.nasdanika.web.route\">" + NL + "      <root_route" + NL + "            class=\"";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = "Route\"" + NL + "            method=\"GET\"" + NL + "            pattern=\"";
  protected final String TEXT_33 = "\\.html\">" + NL + "      </root_route>" + NL + "      ";
  protected final String TEXT_34 = NL + "      <root_route" + NL + "            class=\"";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "DocAppRoute\"" + NL + "            method=\"GET\"" + NL + "            pattern=\"";
  protected final String TEXT_37 = "\">" + NL + "      </root_route>";
  protected final String TEXT_38 = NL + "      " + NL + "      <!--" + NL + "      <object_route" + NL + "            class=\"org.nasdanika.web.routes.ServiceRoute\"" + NL + "            method=\"*\"" + NL + "            pattern=\"[^/]+/services/.+\"" + NL + "            target=\"org.eclipse.emf.cdo.view.CDOView\">" + NL + "         <property" + NL + "               name=\"offset\"" + NL + "               value=\"2\">" + NL + "         </property>" + NL + "      </object_route>" + NL + "      -->" + NL + "   </extension>";
  protected final String TEXT_39 = NL + "   ";
  protected final String TEXT_40 = NL + "   <extension" + NL + "         point=\"org.eclipse.equinox.http.registry.resources\">" + NL + "      <resource" + NL + "            alias=\"";
  protected final String TEXT_41 = "\"" + NL + "            base-name=\"";
  protected final String TEXT_42 = "\">" + NL + "      </resource>" + NL + "   </extension>";
  protected final String TEXT_43 = NL + "      ";
  protected final String TEXT_44 = NL + "   <extension point=\"org.nasdanika.web.html_factory\">" + NL + "      <default_html_factory" + NL + "            bootstrapCssContainer=\"";
  protected final String TEXT_45 = "bootstrap/css\">" + NL + "            <script>";
  protected final String TEXT_46 = NL + "               ";
  protected final String TEXT_47 = "js/jquery-1.11.3.min.js" + NL + "            </script>" + NL + "            <script>";
  protected final String TEXT_48 = NL + "               ";
  protected final String TEXT_49 = "js/underscore-min.js" + NL + "            </script>" + NL + "            <script>";
  protected final String TEXT_50 = "js/backbone-min.js</script>" + NL + "            <script>";
  protected final String TEXT_51 = "bootstrap/js/bootstrap.min.js</script>" + NL + "            <script>";
  protected final String TEXT_52 = "js/knockout-3.3.0.js</script>" + NL + "            <script>";
  protected final String TEXT_53 = NL + "               ";
  protected final String TEXT_54 = "js/require.js" + NL + "            </script>            " + NL + "            <script>";
  protected final String TEXT_55 = NL + "               ";
  protected final String TEXT_56 = "js/require-config.js" + NL + "            </script>" + NL + "            <stylesheet>";
  protected final String TEXT_57 = NL + "               ";
  protected final String TEXT_58 = "font-awesome-4.4.0/css/font-awesome.min.css" + NL + "            </stylesheet>      " + NL + "            <script>";
  protected final String TEXT_59 = NL + "               ";
  protected final String TEXT_60 = "js/lightbox.min.js" + NL + "            </script>" + NL + "            <stylesheet>";
  protected final String TEXT_61 = NL + "               ";
  protected final String TEXT_62 = "css/lightbox.css" + NL + "            </stylesheet>                  " + NL + "      </default_html_factory>" + NL + "   </extension>";
  protected final String TEXT_63 = NL + "   <extension point=\"org.nasdanika.cdo.security.security_policy\">" + NL + "      <policy_resource" + NL + "            resource=\"";
  protected final String TEXT_64 = ".nasdanika_cdo_security\">" + NL + "      </policy_resource>" + NL + "   </extension>";
  protected final String TEXT_65 = " " + NL + "   <extension" + NL + "         point=\"org.eclipse.equinox.http.registry.httpcontexts\">" + NL + "      <httpcontext" + NL + "            id=\"";
  protected final String TEXT_66 = "\">" + NL + "      </httpcontext>" + NL + "   </extension>   ";
  protected final String TEXT_67 = NL + "   <extension" + NL + "         point=\"org.nasdanika.cdo.web.doc.extensions\">" + NL + "       <wiki-link-resolver" + NL + "            class=\"org.nasdanika.cdo.web.doc.JavadocWikiLinkResolver\"" + NL + "            name=\"javadoc\">" + NL + "         <property" + NL + "\t\t        name=\"packageMap.org.nasdanika.*\"" + NL + "                value=\"http://www.nasdanika.org/server/apidocs/\">" + NL + "         </property>" + NL + "         <property" + NL + "               name=\"packageMap.java.*\"" + NL + "               value=\"http://docs.oracle.com/javase/8/docs/api\">" + NL + "         </property>" + NL + "         <property" + NL + "               name=\"packageMap.javax.*\"" + NL + "               value=\"http://docs.oracle.com/javase/8/docs/api\">" + NL + "         </property>" + NL + "         <description>" + NL + "            Resolves JavaDoc URL from the class/package name. Usage: ``[[javadoc&gt;fully qualified class name|text]]``. Text is optional. Examples: " + NL + "" + NL + "* ``[[javadoc&gt;java.lang.String]]`` is rendered as [[javadoc&gt;java.lang.String]]" + NL + "* ``[[javadoc&gt;java.lang.String|java.lang.String]]`` is rendered as [[javadoc&gt;java.lang.String|java.lang.String]]" + NL + "         </description>" + NL + "      </wiki-link-resolver>" + NL + "   </extension>";
  protected final String TEXT_68 = NL + "</plugin>";
  protected final String TEXT_69 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     if (wizard.getRoutingServletAlias()!=null || wizard.getSessionServletAlias()!=null) { 
    stringBuffer.append(TEXT_2);
     if (wizard.getRoutingServletAlias()!=null) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_4);
     if (wizard.getHttpContextId()!=null) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getHttpContextId());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getSessionServletAlias());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_9);
     if (wizard.getHttpContextId()!=null) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getHttpContextId());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(wizard.getSessionServletAlias());
    stringBuffer.append(TEXT_13);
     if (wizard.getSessionServletAlias()!=null) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(wizard.getSessionServletAlias());
    stringBuffer.append(TEXT_15);
     if (wizard.getHttpContextId()!=null) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(wizard.getHttpContextId());
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
     if (wizard.getSessionServletAlias()!=null) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(wizard.getSessionServletAlias());
    stringBuffer.append(TEXT_23);
     if (wizard.getHttpContextId()!=null) { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(wizard.getHttpContextId());
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(wizard.getRoutingServletAlias());
    stringBuffer.append(TEXT_27);
     } 
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
     if (wizard.getRoutingServletAlias()!=null) { 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_33);
     if (wizard.getDocAppRoutePattern()!=null) { 
    stringBuffer.append(TEXT_34);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(wizard.getDocAppRoutePattern());
    stringBuffer.append(TEXT_37);
     } 
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
     if (wizard.getWebContentAlias()!=null) { 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(wizard.getWebContentBaseName());
    stringBuffer.append(TEXT_42);
     } 
    stringBuffer.append(TEXT_43);
     if (wizard.getWebContentAlias()!=null && wizard.getRoutingServletAlias()!=null) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(wizard.getWebContentAlias());
    stringBuffer.append(TEXT_62);
     } 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_64);
     if (wizard.getHttpContextId()!=null) { 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(wizard.getHttpContextId());
    stringBuffer.append(TEXT_66);
     } 
     if (wizard.getDocRoutePath()!=null) { 
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}