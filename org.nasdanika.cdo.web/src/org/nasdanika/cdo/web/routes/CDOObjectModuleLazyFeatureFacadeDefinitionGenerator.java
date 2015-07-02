package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleLazyFeatureFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleLazyFeatureFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleLazyFeatureFacadeDefinitionGenerator result = new CDOObjectModuleLazyFeatureFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Lazy object load strategy - returns a promise for an array of objects" + NL + "get ";
  protected final String TEXT_2 = "() {" + NL + "\tif (!data.";
  protected final String TEXT_3 = ".hasOwnProperty('value')) {" + NL + "\t\tdata.";
  protected final String TEXT_4 = ".value = session.apply(\"";
  protected final String TEXT_5 = "\", undefined, undefined, \"";
  protected final String TEXT_6 = "\");" + NL + "\t\tdata.";
  protected final String TEXT_7 = ".value.then(function (val) {" + NL + "\t\t\tvar mf = function(v) {" + NL + "\t\t\t\tif (v.hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\t\treturn v.$path;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn typeof v === \"function\" ? v() : v;" + NL + "\t\t\t};" + NL + "\t\t\t" + NL + "\t\t\tif (Array.isArray(val)) {" + NL + "\t\t\t\tdata.";
  protected final String TEXT_8 = ".initialValue = val.map(mf);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdata.";
  protected final String TEXT_9 = ".initialValue = mf(val);" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "\treturn data.";
  protected final String TEXT_10 = ".value;" + NL + "}";
  protected final String TEXT_11 = "," + NL + "set ";
  protected final String TEXT_12 = "(newValue) {" + NL + "\tdata.";
  protected final String TEXT_13 = ".value = newValue;" + NL + "}";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.HttpServletRequestContext context = (org.nasdanika.web.HttpServletRequestContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EStructuralFeature feature = (org.eclipse.emf.ecore.EStructuralFeature) args[2]; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(context.getObjectPath(cdoObject));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_10);
     if (feature.isChangeable() && context.authorize(cdoObject, "write", feature.getName(), null)) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(feature.getName());
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}