package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleEagerReferenceFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleEagerReferenceFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleEagerReferenceFacadeDefinitionGenerator result = new CDOObjectModuleEagerReferenceFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Eager reference load strategy - returns an array of functions returning promises" + NL + "get ";
  protected final String TEXT_2 = "() {" + NL + "\tvar dataEntry = data.";
  protected final String TEXT_3 = ";" + NL + "\tif (!dataEntry.hasOwnProperty('value')) {" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\tdataEntry.value = [];" + NL + "\t\t\tfor (ref in dataEntry.initialValue) {" + NL + "\t\t\t\tvar f = function(modName) {" + NL + "\t\t\t\t\treturn Q.Promise(function(resolve, reject, notify) {" + NL + "\t\t\t\t\t\trequire([modName], function(mod) {" + NL + "\t\t\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t\t\t});" + NL + "\t\t\t\t}.bind(this, dataEntry.initialValue[ref]+\".js\");" + NL + "\t\t\t\tf.$path = dataEntry.initialValue[ref];" + NL + "\t\t\t\tdataEntry.value.push(f);\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\tdataEntry.value = Q.Promise(function(resolve, reject, nofity) {" + NL + "\t\t\t\trequire([dataEntry.initialValue+\".js\"], function(mod) {" + NL + "\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t//dataEntry.value = mod; " + NL + "\t\t\t\t});\t\t\t\t\t\t\t" + NL + "\t\t\t});" + NL + "\t\t\tdataEntry.value.$path = dataEntry.initialValue;" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t}" + NL + "\treturn dataEntry.value;" + NL + "}";
  protected final String TEXT_7 = "," + NL + "set ";
  protected final String TEXT_8 = "(newValue) {" + NL + "\tdata.";
  protected final String TEXT_9 = ".value = newValue;" + NL + "}";
  protected final String TEXT_10 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.WebContext context = (org.nasdanika.web.WebContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EReference ref = (org.eclipse.emf.ecore.EReference) args[2]; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_3);
     if (ref.isMany()) { 
    stringBuffer.append(TEXT_4);
     } else { 
    stringBuffer.append(TEXT_5);
     } 
    stringBuffer.append(TEXT_6);
     if (ref.isChangeable() && context.authorize(cdoObject, "write", ref.getName(), null)) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}