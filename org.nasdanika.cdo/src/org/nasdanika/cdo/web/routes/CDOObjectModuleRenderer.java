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
  protected final String TEXT_4 = "/session.js\", \"/js/q.js\"], function(session, Q) {" + NL + "\tconsole.log(\"HERE: \"+Q);" + NL + "    var dirty = false;" + NL + "    var data = {" + NL + "        someAttr: { oldValue: 33 }       " + NL + "    };  " + NL + "" + NL + "    session.";
  protected final String TEXT_5 = " = {" + NL + "" + NL + "        get delta() {" + NL + "" + NL + "            //..." + NL + "" + NL + "        }," + NL + "       " + NL + "        set delta(delta) {" + NL + "            if (delta.hasOwnProperty(\"someAttr\")) {" + NL + "                data.someAttr.oldValue = delta.someAttr;" + NL + "            }        " + NL + "" + NL + "            delete data.someAttr.value;" + NL + "            dirty = false;" + NL + "        }," + NL + "" + NL + "       " + NL + "" + NL + "        reset: function() {" + NL + "            delete data.someAttr.value;" + NL + "            dirty = false;" + NL + "        }   " + NL + "    };" + NL + "" + NL + "    return {" + NL + "" + NL + "        get someAttr() {" + NL + "            if (data.someAttr.hasOwnProperty(\"value\")) {" + NL + "                return data.someAttr.value;" + NL + "            }" + NL + "" + NL + "            if (data.someAttr.hasOwnProperty(\"oldValue\")) {" + NL + "                return data.someAttr.oldValue;" + NL + "            }" + NL + "" + NL + "            return \"defalut value\";" + NL + "" + NL + "        }," + NL + "" + NL + "        set someAttr(newValue) {" + NL + "            // compare to value(?), oldValue if present and to default value." + NL + "            // set and mark dirty" + NL + "        }," + NL + "" + NL + "        // Operations" + NL + "" + NL + "\t\tget $session() {" + NL + "\t\t\treturn session; " + NL + "\t\t}, " + NL + "       " + NL + "        $store: function() {" + NL + "            // return a promise of this." + NL + "        }," + NL + "" + NL + "       " + NL + "" + NL + "        $load: function() {" + NL + "            // return promise of this." + NL + "        }" + NL + "" + NL + "    };" + NL + "});";

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
    stringBuffer.append(config.getId());
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}