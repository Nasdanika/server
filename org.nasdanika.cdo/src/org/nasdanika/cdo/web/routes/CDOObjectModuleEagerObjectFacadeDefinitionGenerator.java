package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleEagerObjectFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleEagerObjectFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleEagerObjectFacadeDefinitionGenerator result = new CDOObjectModuleEagerObjectFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Eager object load strategy - returns an array of objects" + NL + "get ";
  protected final String TEXT_2 = "() {" + NL + "\tvar dataEntry = data.";
  protected final String TEXT_3 = ";" + NL + "\tif (!dataEntry.hasOwnProperty('value')) {" + NL + "\t\tdataEntry.value = [];" + NL + "\t\tfor (ref in dataEntry.initialValue) {" + NL + "\t\t\tvar modName = dataEntry.initialValue[ref];" + NL + "\t\t\tif (require.defined(modName)) {" + NL + "\t\t\t\tdataEntry.value.push(require(modName));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tconsole.log(\"Eager dependency is not yet defined, probably a circular reference: \"+modName);" + NL + "\t\t\t\tvar deferred = q.defer();" + NL + "\t\t\t\tdataEntry.value.push(deferred.promise);" + NL + "\t\t\t\tvar idx = ref;" + NL + "\t\t\t\trequire(modName, function(mod) {" + NL + "\t\t\t\t\tdeferred.resolve(mod);" + NL + "\t\t\t\t\tdataEntry.value[idx] = mod; " + NL + "\t\t\t\t});\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\treturn dataEntry.value;" + NL + "}";
  protected final String TEXT_4 = "," + NL + "set ";
  protected final String TEXT_5 = "(newValue) {" + NL + "\tdata.";
  protected final String TEXT_6 = ".value = newValue;" + NL + "}";
  protected final String TEXT_7 = NL;

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
     if (ref.isChangeable() && context.authorize(cdoObject, "write", ref.getName(), null)) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}