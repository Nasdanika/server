package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleLazyReferenceFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleLazyReferenceFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleLazyReferenceFacadeDefinitionGenerator result = new CDOObjectModuleLazyReferenceFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Lazy reference load strategy - returns a promise for an array of functions returning promises for objects" + NL + "get ";
  protected final String TEXT_2 = "() {" + NL + "\tif (!data.";
  protected final String TEXT_3 = ".hasOwnProperty('value')) {" + NL + "\t\tdata.";
  protected final String TEXT_4 = ".value = Q.Promise(function(vResolve, vReject, vNotify) {" + NL + "\t\t\tjquery.ajax(" + NL + "\t\t\t\t\"";
  protected final String TEXT_5 = "/feature/";
  protected final String TEXT_6 = ".json\"," + NL + "\t\t\t    {" + NL + "\t\t\t        success: function(refData) {" + NL + "\t\t\t        \tdata.";
  protected final String TEXT_7 = ".initialValue = refData;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\tvar result = [];" + NL + "\t\t\t\t\t\t\tfor (var ref in refData) { " + NL + "\t\t\t\t\t\t\t\tvar f = function(modName) {" + NL + "\t\t\t\t\t\t\t\t\treturn Q.Promise(function(resolve,reject,notify) {" + NL + "\t\t\t\t\t\t\t\t\t\trequire([modName], function(mod) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\t\t\t\t});\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}.bind(this, refData[ref]+\".js\");" + NL + "\t\t\t\t\t\t\t\tf.$path = refData[ref];" + NL + "\t\t\t\t\t\t\t\tresult.push(f);\t\t\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tvResolve(result);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\tvResolve(function() {" + NL + "\t\t\t\t\t\t\t\treturn Q.Promise(function(resolve,reject,notify) {" + NL + "\t\t\t\t\t\t\t\t\trequire([refData+\".js\"], function(mod) {" + NL + "\t\t\t\t\t\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\t\t\t});\t\t\t\t" + NL + "\t\t\t\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t        }," + NL + "\t\t\t        error: function(jqXHR, textStatus, errorThrown) {" + NL + "\t\t\t        \tvReject({ status: textStatus, error: errorThrown });" + NL + "\t\t\t        }" + NL + "\t\t\t    });\t\t\t\t" + NL + "\t\t});" + NL + "\t}" + NL + "\treturn data.";
  protected final String TEXT_11 = ".value;" + NL + "}";
  protected final String TEXT_12 = "," + NL + "set ";
  protected final String TEXT_13 = "(newValue) {" + NL + "\tdata.";
  protected final String TEXT_14 = ".value = newValue;" + NL + "}";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.HttpServletRequestContext context = (org.nasdanika.web.HttpServletRequestContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EReference ref = (org.eclipse.emf.ecore.EReference) args[2]; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(context.getObjectPath(cdoObject));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_7);
     if (ref.isMany()) { 
    stringBuffer.append(TEXT_8);
     } else { 
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_11);
     if (ref.isChangeable() && context.authorize(cdoObject, "write", ref.getName(), null)) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}