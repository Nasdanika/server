package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleRenderer {


  protected static String nl;
  public static synchronized CDOObjectModuleRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleRenderer result = new CDOObjectModuleRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "define(\"";
  protected final String TEXT_3 = ".js\", [\"";
  protected final String TEXT_4 = "/session.js\", \"q\"], function(session, Q) {" + NL + "    var dirty = false;" + NL + "    var data = {" + NL + "    \t";
  protected final String TEXT_5 = NL + "\t    \t";
  protected final String TEXT_6 = "," + NL + "\t    \t";
  protected final String TEXT_7 = NL + "    \t";
  protected final String TEXT_8 = NL + "    };  " + NL + "" + NL + "    session.";
  protected final String TEXT_9 = " = {" + NL + "" + NL + "        get delta() {" + NL + "        \t";
  protected final String TEXT_10 = NL + "        \t\t";
  protected final String TEXT_11 = NL + "        \t";
  protected final String TEXT_12 = NL + "       }," + NL + "       " + NL + "        set delta(delta) {" + NL + "        \t";
  protected final String TEXT_13 = NL + "        \t\t";
  protected final String TEXT_14 = NL + "        \t";
  protected final String TEXT_15 = NL + "        \t" + NL + "            dirty = false;" + NL + "        }," + NL + "" + NL + "        reset: function() {" + NL + "            delete data.someAttr.value;" + NL + "            dirty = false;" + NL + "        }   " + NL + "    };" + NL + "" + NL + "    return {" + NL + "    " + NL + "    \t";
  protected final String TEXT_16 = NL + "\t    \t";
  protected final String TEXT_17 = "," + NL + "    \t";
  protected final String TEXT_18 = NL + NL + "\t\tget $session() {" + NL + "\t\t\treturn session; " + NL + "\t\t}, " + NL + "       " + NL + "        $store: function() {" + NL + "            // return a promise of this." + NL + "        }," + NL + "" + NL + "        $load: function() {" + NL + "            // return promise of this." + NL + "        }" + NL + "" + NL + "    };" + NL + "});";

public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	org.nasdanika.cdo.web.routes.CDOObjectJsExtensionRoute.ModuleGeneratorConfig config = (org.nasdanika.cdo.web.routes.CDOObjectJsExtensionRoute.ModuleGeneratorConfig) argument;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(config.getObjectPath());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(config.getSessionPath());
    stringBuffer.append(TEXT_4);
     
    		java.util.Iterator<String> dit = config.getDataDefinitions().iterator();
    		while (dit.hasNext()) {
    	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dit.next());
     if (dit.hasNext()) { 
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(config.getId());
    stringBuffer.append(TEXT_9);
     for (String getDeltaEntry: config.getGetDeltaEntries()) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(getDeltaEntry);
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
     for (String setDeltaEntry: config.getSetDeltaEntries()) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(setDeltaEntry);
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     
    		java.util.Iterator<String> fit = config.getFacadeDefinitions().iterator();
    		while (fit.hasNext()) {
    	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fit.next());
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}