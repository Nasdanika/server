package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleGenerator result = new CDOObjectModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "define([\"";
  protected final String TEXT_3 = "/session.js\", \"q\" ";
  protected final String TEXT_4 = ", \"";
  protected final String TEXT_5 = "\"";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = ", \"";
  protected final String TEXT_8 = ".js\"";
  protected final String TEXT_9 = "], function(session, Q ";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ") {" + NL + "\t//console.log(\"Defining ";
  protected final String TEXT_12 = ".js\");" + NL + "    var data = ";
  protected final String TEXT_13 = ";" + NL + "" + NL + "    session.sessionObjects[\"";
  protected final String TEXT_14 = "\"] = {" + NL + "" + NL + "        get delta() {" + NL + "        \tvar delta = {};" + NL + "        \t";
  protected final String TEXT_15 = NL + "        \t\t";
  protected final String TEXT_16 = NL + "        \t";
  protected final String TEXT_17 = NL + "        \treturn delta;" + NL + "       }," + NL + "       " + NL + "       applyDelta: function(delta) {" + NL + "       \t\tif (delta === 'detached') {" + NL + "       \t\t\tdelete facade.$store;" + NL + "       \t\t\tdelete facade.$delete;" + NL + "       \t\t\tdelete facade.$refresh;" + NL + "       \t\t} else {" + NL + "\t        \tvar deltaPromises = [];" + NL + "\t        \t";
  protected final String TEXT_18 = NL + "\t        \t\t";
  protected final String TEXT_19 = NL + "\t        \t";
  protected final String TEXT_20 = NL + "\t        \tif (deltaPromises.length > 0) {" + NL + "\t        \t\treturn Q.all(deltaPromises);" + NL + "\t        \t}" + NL + "\t        }" + NL + "        }," + NL + "" + NL + "        reset: function() {" + NL + "        \t";
  protected final String TEXT_21 = NL + "        \t\t";
  protected final String TEXT_22 = NL + "        \t";
  protected final String TEXT_23 = NL + "        }   " + NL + "    };" + NL + "" + NL + "    var facade = {" + NL + "    " + NL + "    \t";
  protected final String TEXT_24 = NL + "\t    \t";
  protected final String TEXT_25 = "," + NL + "    \t";
  protected final String TEXT_26 = NL + NL + "\t\tget $session() {" + NL + "\t\t\treturn session; " + NL + "\t\t}, " + NL + "\t\t" + NL + "        $refresh: function() {" + NL + "            return session.refresh().thenResolve(this); " + NL + "        }," + NL + "" + NL + "        $path: \"";
  protected final String TEXT_27 = "\"" + NL + "" + NL + "    };" + NL + "        " + NL + "\t";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = NL + "\t";
  protected final String TEXT_30 = "    " + NL + "    " + NL + "    return facade;" + NL + "});";

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	org.nasdanika.cdo.web.routes.CDOObjectJsExtensionRoute.ModuleGeneratorConfig config = (org.nasdanika.cdo.web.routes.CDOObjectJsExtensionRoute.ModuleGeneratorConfig) args[0];

    stringBuffer.append(TEXT_2);
    stringBuffer.append(config.getSessionPath());
    stringBuffer.append(TEXT_3);
     for (String dependency: config.getDependencies()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dependency);
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
     for (Object eager: config.getEager()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(config.getContext().getObjectPath(eager));
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
     for (String dependencyName: config.getDependencyNames()) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dependencyName);
     } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(config.getObjectPath());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(config.getDataDefinitions());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(config.getObjectPath());
    stringBuffer.append(TEXT_14);
     for (String getDeltaEntry: config.getGetDeltaEntries()) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(getDeltaEntry);
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
     for (String setDeltaEntry: config.getSetDeltaEntries()) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(setDeltaEntry);
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     for (String resetEntry: config.getResetEntries()) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(resetEntry);
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
     
    		java.util.Iterator<String> fit = config.getFacadeDefinitions().iterator();
    		while (fit.hasNext()) {
    	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(fit.next());
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(config.getObjectPath());
    stringBuffer.append(TEXT_27);
     for (String preloadAction: config.getPreloadActions()) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(preloadAction);
    stringBuffer.append(TEXT_29);
     } 
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}