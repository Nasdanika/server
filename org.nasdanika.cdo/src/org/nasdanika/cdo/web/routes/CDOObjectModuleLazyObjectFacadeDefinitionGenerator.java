package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleLazyObjectFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleLazyObjectFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleLazyObjectFacadeDefinitionGenerator result = new CDOObjectModuleLazyObjectFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Lazy object load strategy - returns an array of functions returning objects" + NL + "get ";
  protected final String TEXT_2 = "() {" + NL + "\tif (!data.hasOwnProperty('";
  protected final String TEXT_3 = "')) {" + NL + "\t\tdata.";
  protected final String TEXT_4 = " = {" + NL + "\t\t\tvalue: Q.Promise(function(vResolve, vReject, vNotify) {" + NL + "\t\t\t\tjquery.ajax(" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_5 = "/feature/";
  protected final String TEXT_6 = ".json\"," + NL + "\t\t\t\t    {" + NL + "\t\t\t\t        success: function(refData) {" + NL + "\t\t\t\t        \tdata.";
  protected final String TEXT_7 = ".initialValue = refData;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\t\tvar promises = [];" + NL + "\t\t\t\t\t\t\t\tfor (ref in refData) {" + NL + "\t\t\t\t\t\t\t\t\tpromises.push(Q.Promise(function(idx, resolve, reject, notify) {" + NL + "\t\t\t\t\t\t\t\t\t\trequire([refData[idx]+\".js\"], function(mod) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t\t\t\t\t\t});\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t}.bind(this, ref)));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tQ.all(promises).then(function(res) { vResolve(res); });" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\t\trequire([refData+\".js\"], function(mod) {" + NL + "\t\t\t\t\t\t\t\t\tvResolve(mod);" + NL + "\t\t\t\t\t\t\t\t});\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t        }," + NL + "\t\t\t\t        error: function(jqXHR, textStatus, errorThrown) {" + NL + "\t\t\t\t        \tvReject({ status: textStatus, error: errorThrown });" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t    });\t\t\t\t" + NL + "\t\t\t})" + NL + "\t\t};" + NL + "\t}" + NL + "\treturn data.";
  protected final String TEXT_11 = ".value;" + NL + "}";
  protected final String TEXT_12 = "," + NL + "set ";
  protected final String TEXT_13 = "(newValue) {" + NL + "\tif (!data.hasOwnProperty('";
  protected final String TEXT_14 = "')) {" + NL + "\t\tdata.";
  protected final String TEXT_15 = " = {};" + NL + "\t}" + NL + "\tdata.";
  protected final String TEXT_16 = " = newValue;" + NL + "}";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;

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
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}