package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleAttributeFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleAttributeFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleAttributeFacadeDefinitionGenerator result = new CDOObjectModuleAttributeFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "get ";
  protected final String TEXT_2 = "() {" + NL + "\tvar dataEntry = data.";
  protected final String TEXT_3 = ";" + NL + "\tif (dataEntry.hasOwnProperty('value')) {" + NL + "\t\treturn dataEntry.value;" + NL + "\t}" + NL + "\tif (dataEntry.hasOwnProperty('initialValue')) {" + NL + "\t\treturn dataEntry.initialValue;" + NL + "\t}" + NL + "\treturn ";
  protected final String TEXT_4 = ";" + NL + "}";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = NL + "set ";
  protected final String TEXT_7 = "(newValue) {" + NL + "\tvar dataEntry = data.";
  protected final String TEXT_8 = ";" + NL + "\tif (dataEntry.hasOwnProperty('value')) {" + NL + "\t\tif (newValue!==dataEntry.value) {" + NL + "\t\t\tif (dataEntry.hasOwnProperty('initialValue') && newValue === dataEntry.initialValue) {" + NL + "\t\t\t\tdelete dataEntry.value;" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdataEntry.value = newValue;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} else if (dataEntry.hasOwnProperty('initialValue')) {" + NL + "\t\tif (newValue!==dataEntry.initialValue) {" + NL + "\t\t\tdataEntry.value = newValue;" + NL + "\t\t}" + NL + "\t} else {" + NL + "\t\tif (newValue!==";
  protected final String TEXT_9 = ") {" + NL + "\t\t\tdataEntry.value = newValue;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.HttpServletRequestContext context = (org.nasdanika.web.HttpServletRequestContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EAttribute attr = (org.eclipse.emf.ecore.EAttribute) args[2]; 
	String defaultValueLiteral = "undefined";
	if (attr.getDefaultValue()!=null) {
		defaultValueLiteral = attr.getDefaultValueLiteral();
		if (String.class.getName().equals(attr.getEType().getInstanceClassName())) {
			defaultValueLiteral = "\"" + org.apache.commons.lang3.StringEscapeUtils.escapeEcmaScript(defaultValueLiteral) + "\"";
		}
	}	
	boolean readable = context.authorize(cdoObject, "read", attr.getName(), null);	

     if (readable) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(defaultValueLiteral);
    stringBuffer.append(TEXT_4);
     } if (attr.isChangeable() && context.authorize(cdoObject, "write", attr.getName(), null)) { 
     if (readable) { 
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(attr.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(defaultValueLiteral);
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}