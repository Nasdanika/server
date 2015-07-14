package org.nasdanika.cdo.web.doc;

public class SelectTocNodeModuleGenerator
{
  protected static String nl;
  public static synchronized SelectTocNodeModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SelectTocNodeModuleGenerator result = new SelectTocNodeModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "require(['jquery', '";
  protected final String TEXT_3 = "/resources/jstree/jstree.js', 'domReady!'], function(jQuery, jstree, doc) {" + NL + "\t// A little trick to give jstree time to load without going into complexities of listening for load event. " + NL + "\tsetTimeout(" + NL + "\t\tfunction() {" + NL + "\t\t\tvar toc = jQuery('#toc');" + NL + "\t\t\tif (!toc.jstree(\"is_selected\", \"#";
  protected final String TEXT_4 = "\")) {\t" + NL + "\t\t\t\ttoc.jstree(\"deselect_all\");  " + NL + "\t\t\t\ttoc.jstree(\"select_node\", \"#";
  protected final String TEXT_5 = "\", true, false);" + NL + "\t\t\t}" + NL + "\t\t}, 200); " + NL + "});";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	Object path = ((Object[]) argument)[0];
	Object nodeID = ((Object[]) argument)[1];

    stringBuffer.append(TEXT_2);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(nodeID);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(nodeID);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
