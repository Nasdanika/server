package org.nasdanika.cdo.web.doc;

public class SearchModuleGenerator
{
  protected static String nl;
  public static synchronized SearchModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SearchModuleGenerator result = new SearchModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "require(['jquery', 'knockout', '";
  protected final String TEXT_2 = "/toc.js', '";
  protected final String TEXT_3 = "/resources/jstree/jstree.js', 'domReady!'], function(jQuery, ko, toc, jstree, doc) {" + NL + "\tjQuery('#toc').jstree({" + NL + "\t\t'core': { " + NL + "\t\t\t'data': toc.tree " + NL + "\t\t\t}" + NL + "\t}).bind(\"select_node.jstree\", function (e, data) {" + NL + "\t\twindow.location = toc.idMap[data.node.id];" + NL + "\t});" + NL + "" + NL + "\tvar leftOverlay = jQuery(\"#left-overlay\");" + NL + "\t\t" + NL + "\tko.applyBindings({" + NL + "\t\t" + NL + "\t\tquery: ko.observable()," + NL + "\t\terror: ko.observable()," + NL + "\t\tsearch: function() {" + NL + "\t\t\tleftOverlay.height(leftOverlay.parent().height());" + NL + "\t\t\tleftOverlay.css(\"display\", \"block\");" + NL + "\t\t\tthis.error(undefined);" + NL + "\t\t\tthis.results(undefined);" + NL + "\t\t\tjQuery.ajax(\"doc/search\", {" + NL + "\t\t\t\tdata: {" + NL + "\t\t\t\t\tquery: this.query" + NL + "\t\t\t\t}," + NL + "\t\t\t\tdataType: \"json\"," + NL + "\t\t\t\tsuccess: function(data, textStatus, jqXHR) {" + NL + "\t\t\t\t\tif (data.length>0) {" + NL + "\t\t\t\t\t\tthis.results(data);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tthis.error(\"No results\");" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t}.bind(this)," + NL + "\t\t\t\terror: function(jqXHR, textStatus, errorThrown) {" + NL + "\t\t\t\t\tthis.error(\"Search error: \"+errorThrown);\t\t\t\t" + NL + "\t\t\t\t}.bind(this)," + NL + "\t\t\t\tcomplete: function() {" + NL + "\t\t\t\t\tleftOverlay.css(\"display\", \"none\");\t\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}," + NL + "\t\t" + NL + "\t\tresults: ko.observable()" + NL + "\t\t" + NL + "\t}, doc.getElementById('searchContainer'));" + NL + "\t\t" + NL + "});";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(argument);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(argument);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
