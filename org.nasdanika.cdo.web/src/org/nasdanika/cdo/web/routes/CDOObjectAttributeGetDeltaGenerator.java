package org.nasdanika.cdo.web.routes;

public class CDOObjectAttributeGetDeltaGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectAttributeGetDeltaGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectAttributeGetDeltaGenerator result = new CDOObjectAttributeGetDeltaGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (data.";
  protected final String TEXT_2 = ".hasOwnProperty(\"value\")) {" + NL + "\tdelta.";
  protected final String TEXT_3 = " = { " + NL + "\t\tvalue: data.";
  protected final String TEXT_4 = ".value" + NL + "\t};" + NL + "\tif (data.";
  protected final String TEXT_5 = ".hasOwnProperty(\"initialValue\")) {" + NL + "\t\tdelta.";
  protected final String TEXT_6 = ".initialValue = data.";
  protected final String TEXT_7 = ".initialValue;" + NL + "\t}" + NL + "}";
  protected final String TEXT_8 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.HttpServletRequestContext context = (org.nasdanika.web.HttpServletRequestContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EAttribute attr = (org.eclipse.emf.ecore.EAttribute) args[2]; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}