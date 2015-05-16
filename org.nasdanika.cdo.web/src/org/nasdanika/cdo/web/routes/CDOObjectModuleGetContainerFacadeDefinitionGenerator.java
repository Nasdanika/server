package org.nasdanika.cdo.web.routes;

public class CDOObjectModuleGetContainerFacadeDefinitionGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectModuleGetContainerFacadeDefinitionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectModuleGetContainerFacadeDefinitionGenerator result = new CDOObjectModuleGetContainerFacadeDefinitionGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "get $container() {" + NL + "\tvar dataEntry = data.$container;" + NL + "\tif (!dataEntry.hasOwnProperty('value')) {" + NL + "\t\tdataEntry.value = Q.Promise(function(resolve, reject, nofity) {" + NL + "\t\t\trequire([dataEntry.initialValue+\".js\"], function(mod) {" + NL + "\t\t\t\tresolve(mod);" + NL + "\t\t\t});\t\t\t\t\t\t\t" + NL + "\t\t});" + NL + "\t\tdataEntry.value.$path = dataEntry.initialValue;" + NL + "\t}" + NL + "\treturn dataEntry.value;" + NL + "}";

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}