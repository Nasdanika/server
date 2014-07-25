package org.nasdanika.html.impl;

public class ApplicationPanelRenderer
{
  protected static String nl;
  public static synchronized ApplicationPanelRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ApplicationPanelRenderer result = new ApplicationPanelRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "<div class=\"panel panel-";
  protected final String TEXT_3 = "\"";
  protected final String TEXT_4 = " style=\"width: ";
  protected final String TEXT_5 = "px; margin: 0 auto; margin-top: 10px\"";
  protected final String TEXT_6 = ">" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\t<div class=\"panel-heading\">" + NL + "\t\t\t<h3 class=\"panel-title\">" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t<a href=\"";
  protected final String TEXT_11 = "\">";
  protected final String TEXT_12 = "</a>" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t</h3>" + NL + "\t\t</div>" + NL + "\t";
  protected final String TEXT_14 = NL + NL + "\t<div class=\"panel-body\" ";
  protected final String TEXT_15 = "style=\"min-height: ";
  protected final String TEXT_16 = "px\"";
  protected final String TEXT_17 = ">" + NL + "" + NL + "\t\t";
  protected final String TEXT_18 = NL + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = "\t\t" + NL + "\t\t\t<div class=\"row\">" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t";
  protected final String TEXT_24 = "\t\t\t" + NL + "\t\t\t</div>" + NL + "\t\t";
  protected final String TEXT_25 = "\t\t\t\t\t\t" + NL + "\t</div>" + NL + "\t" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\t<div class=\"panel-footer\">" + NL + "\t\t\t<div style=\"display: table; margin: 0 auto\">";
  protected final String TEXT_27 = "</div>" + NL + "\t\t</div>" + NL + "\t";
  protected final String TEXT_28 = NL + "</div>";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	ApplicationPanelConfig config = (ApplicationPanelConfig) argument;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(config.getStyle());
    stringBuffer.append(TEXT_3);
     if (config.getWidth()>0) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(config.getWidth());
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
     if (config.getHeader()!=null) { 
    stringBuffer.append(TEXT_7);
     if (config.getHeaderLink()==null) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(config.getHeader());
    stringBuffer.append(TEXT_9);
     } else { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(config.getHeaderLink());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(config.getHeader());
    stringBuffer.append(TEXT_12);
     } 
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     if (config.getMinHeight()>0) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(config.getMinHeight());
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(config.getNavigation());
    stringBuffer.append(TEXT_18);
     if (config.getContentPanels().size()==1) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(config.getContentPanels().get(0));
    stringBuffer.append(TEXT_20);
     } else { 
    stringBuffer.append(TEXT_21);
     for (Object contentPanel: config.getContentPanels()) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(contentPanel);
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(TEXT_24);
     } 
    stringBuffer.append(TEXT_25);
     if (config.getFooter()!=null) { 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(config.getFooter());
    stringBuffer.append(TEXT_27);
     } 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
