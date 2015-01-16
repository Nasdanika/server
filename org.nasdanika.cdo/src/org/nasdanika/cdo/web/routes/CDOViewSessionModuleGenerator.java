package org.nasdanika.cdo.web.routes;

public class CDOViewSessionModuleGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOViewSessionModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOViewSessionModuleGenerator result = new CDOViewSessionModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "define([\"q\", \"jquery\"], function(Q, jquery) {" + NL + "" + NL + "\t// prepares object for sending to the server side by replacing model objects with paths" + NL + "\tfunction marshal(obj) {" + NL + "\t\tif (obj instanceof Array) {" + NL + "\t\t\tvar ret = [];" + NL + "\t\t\tfor (i in obj) {" + NL + "\t\t\t\tret.push(marshal(obj[i]));" + NL + "\t\t\t}\t" + NL + "\t\t\treturn ret;\t\t" + NL + "\t\t} " + NL + "\t\t" + NL + "\t\tif (typeof obj === \"object\") {" + NL + "\t\t\tif (obj.hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\treturn { $path : obj.$path };" + NL + "\t\t\t}" + NL + "\t\t\tvar ret = {};" + NL + "\t\t\tfor (k in obj) {" + NL + "\t\t\t\tret[k] = marshal(obj[k]);" + NL + "\t\t\t}\t" + NL + "\t\t\treturn ret;\t\t" + NL + "\t\t}\t" + NL + "\t\t" + NL + "\t\treturn { value : obj };\t\t\t" + NL + "\t}" + NL + "\t" + NL + "\t// unmarshals by resolving paths to promises" + NL + "\tfunction unmarshal(obj, isValue) {" + NL + "\t\tif (obj instanceof Array) {" + NL + "\t\t\tvar ret = [];" + NL + "\t\t\tvar hasPromises = false;" + NL + "\t\t\tfor (i in obj) {" + NL + "\t\t\t\tvar e = unmarshal(obj[i], false);" + NL + "\t\t\t\tif (Q.isPromise(e)) {" + NL + "\t\t\t\t\thasPromises = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tret.push(e);" + NL + "\t\t\t}\t" + NL + "\t\t\treturn hasPromises ? Q.all(ret) : ret;\t\t" + NL + "\t\t} " + NL + "\t\t" + NL + "\t\tif (isValue) {" + NL + "\t\t\tif (typeof obj === \"object\") {" + NL + "\t\t\t\tvar pending = [];" + NL + "\t\t\t\tvar ret = {};" + NL + "\t\t\t\tfor (k in obj) {" + NL + "\t\t\t\t\tvar e = unmarshal(obj[k], false);" + NL + "\t\t\t\t\tif (Q.isPromise(e)) {" + NL + "\t\t\t\t\t\tpending.push(e.then(function(k, v) { ret[k] = v; }.bind(this, k)));" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tret[k] = e;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}\t" + NL + "\t\t\t\treturn pending.length==0 ? ret : Q.all(pending).thenResolve(ret);\t\t" + NL + "\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\treturn obj;\t\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t\tif (obj.hasOwnProperty(\"$path\")) {" + NL + "\t\t\treturn Q.promise(function(resolve, reject, notify) {" + NL + "\t\t\t\trequire([obj.$path+\".js\"], function(mod) {" + NL + "\t\t\t\t\tresolve(mod);" + NL + "\t\t\t\t});\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        \t\t\t\t\t" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn unmarshal(obj.value, true);\t" + NL + "\t}" + NL + "" + NL + "\tvar session = {" + NL + "\t\tsessionObjects : {}," + NL + "\t\t" + NL + "\t\t// TODO - resources and resource folders - promise of resource content (lazy-ref)" + NL + "\t" + NL + "\t\t// Posts local changes to the server, including operation target, name, and arguments, if specified." + NL + "\t\t// Applies returned server-side changes to the model" + NL + "\t\t// Returns a promise which is fulfilled with the operation result or undefined when store operation completes." + NL + "\t\tapply : function(target, operation, opArgs) {" + NL + "\t\t\treturn Q.Promise(function(resolve, reject, notify) {" + NL + "\t\t\t\tvar applyData = {};" + NL + "\t\t\t\tif (target) {" + NL + "\t\t\t\t\tapplyData.target = target;" + NL + "\t\t\t\t\tapplyData.operation = operation;" + NL + "\t\t\t\t\tapplyData.args = marshal(opArgs);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tapplyData.deltas = {};" + NL + "\t\t\t\tfor (k in session.sessionObjects) {" + NL + "\t\t\t\t\tapplyData.deltas[k] = session.sessionObjects[k].delta;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjquery.ajax(" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_2 = "/session\"," + NL + "\t\t\t\t    {" + NL + "\t\t\t\t    \ttype: \"PUT\"," + NL + "\t\t\t\t    \tdata: JSON.stringify(applyData)," + NL + "\t\t\t\t    \tcontentType: \"text/json\"," + NL + "\t\t\t\t        success: function(response) {" + NL + "\t\t\t\t        \tif (response.hasOwnProperty('deltas')) {" + NL + "\t\t\t\t        \t\tfor (k in response.deltas) {" + NL + "\t\t\t\t        \t\t\tif (session.sessionObjects.hasOwnProperty(k)) {" + NL + "\t\t\t\t        \t\t\t\tsession.sessionObjects[k].delta = response.deltas[k];" + NL + "\t\t\t\t        \t\t\t}" + NL + "\t\t\t\t        \t\t}" + NL + "\t\t\t\t        \t}" + NL + "\t\t\t        \t\tresolve(unmarshal(response.result, false));" + NL + "\t\t\t\t        }," + NL + "\t\t\t\t        error: function(jqXHR, textStatus, errorThrown) {" + NL + "\t\t\t\t        \treject(errorThrown);" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t    });\t\t\t\t" + NL + "\t\t\t})\t\t\t" + NL + "\t\t}" + NL + "\t};\t" + NL + "\t" + NL + "\treturn session;" + NL + "});";

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.WebContext context = (org.nasdanika.web.WebContext) args[0];
	org.eclipse.emf.cdo.view.CDOView cdoView = (org.eclipse.emf.cdo.view.CDOView) args[1]; 

    stringBuffer.append(TEXT_1);
    stringBuffer.append(context.getObjectPath(cdoView));
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}