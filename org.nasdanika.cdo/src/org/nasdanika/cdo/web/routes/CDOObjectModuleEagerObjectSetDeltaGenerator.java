package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleEagerObjectSetDeltaGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleEagerObjectSetDeltaGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleEagerObjectSetDeltaGenerator result = new CDOObjectModuleEagerObjectSetDeltaGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Eager object load strategy - returns an array of functions returning objects" + NL + "if (delta.hasOwnProperty('";
  protected final String TEXT_2 = "')) { " + NL + "\tdata.";
  protected final String TEXT_3 = " = delta.";
  protected final String TEXT_4 = ";" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tfor (ref in data.";
  protected final String TEXT_6 = ".initialValue) {" + NL + "\t\t\tdeltaPromises.push(Q.Promise(function(modName,resolve,reject,notify) {" + NL + "\t\t\t\t\trequire([modName], function(mod) {" + NL + "\t\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t\t}.bind(this, data.";
  protected final String TEXT_7 = ".initialValue[ref]+'.js')));" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_8 = NL + "\t\tdeltaPromises.push(Q.Promise(function(modName,resolve,reject,notify) {" + NL + "\t\t\t\trequire([modName], function(mod) {" + NL + "\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t}.bind(this, data.";
  protected final String TEXT_9 = ".initialValue+'.js')));" + NL + "\t";
  protected final String TEXT_10 = "\t " + NL + "}";
  protected final String TEXT_11 = NL;

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
     if (ref.isMany()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_7);
     } else { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}