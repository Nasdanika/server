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
  protected final String TEXT_2 = NL + NL + "require(['";
  protected final String TEXT_3 = "/resources/js/left-panel.js'], function(tocTreePromise) {" + NL + "\ttocTreePromise.then(function(tocTree) {" + NL + "\t\tif (!tocTree.jstree(\"is_selected\", \"#";
  protected final String TEXT_4 = "\")) {\t" + NL + "\t\t\ttocTree.jstree(\"deselect_all\");  " + NL + "\t\t\ttocTree.jstree(\"select_node\", \"#";
  protected final String TEXT_5 = "\", true, false);" + NL + "\t\t}" + NL + "\t}); " + NL + "});";
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
