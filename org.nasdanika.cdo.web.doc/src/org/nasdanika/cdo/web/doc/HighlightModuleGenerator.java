package org.nasdanika.cdo.web.doc;

public class HighlightModuleGenerator
{
  protected static String nl;
  public static synchronized HighlightModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    HighlightModuleGenerator result = new HighlightModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "require(['jquery', 'domReady!'], function(jQuery, doc) {" + NL + "\t$('pre code').each(function(i, block) {" + NL + "\t\thljs.highlightBlock(block);" + NL + "\t});\t\t" + NL + "});" + NL + "\t" + NL + "\t";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
