package org.nasdanika.cdo.web.routes;

public class CDOObjectReferenceGetDeltaGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectReferenceGetDeltaGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectReferenceGetDeltaGenerator result = new CDOObjectReferenceGetDeltaGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (data.hasOwnProperty(\"";
  protected final String TEXT_2 = "\") && data.";
  protected final String TEXT_3 = ".hasOwnProperty(\"value\")) { // Was accessed and possibly changed" + NL + "\tvar value = data.";
  protected final String TEXT_4 = ".value;" + NL + "\t" + NL + "\tvar maybeDirty = false;" + NL + "\tif (Q.isPromise(value)) {" + NL + "\t\tif (value.isFulfilled()) {" + NL + "\t\t\tvalue = value.inspect().value;" + NL + "\t\t\tmaybeDirty = true;" + NL + "\t\t}" + NL + "\t} else {" + NL + "\t\tmaybeDirty = true;" + NL + "\t}" + NL + "\t" + NL + "\tif (maybeDirty) {" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tvar deltaEntry = session.arrayDelta(data.";
  protected final String TEXT_7 = ".initialValue, value.map(function(v) {" + NL + "\t\t\t\t\tif (v.hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\t\t\treturn v.$path;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn typeof v === \"function\" ? v() : v;" + NL + "\t\t\t\t}));" + NL + "\t\t\t\tif (deltaEntry.length>0) {" + NL + "\t\t\t\t\tdelta.";
  protected final String TEXT_8 = " = deltaEntry;" + NL + "\t\t\t\t}\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tvar dirty = false;" + NL + "\t\t\t\tvar deltaEntry = [];" + NL + "\t\t\t\tfor (var i = 0; i < data.";
  protected final String TEXT_10 = ".initialValue.length; ++i) {" + NL + "\t\t\t\t\tif (value.length>i) {" + NL + "\t\t\t\t\t\tif (value[i].hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\t\t\t\tif (value[i].$path === data.";
  protected final String TEXT_11 = ".initialValue[i]) {" + NL + "\t\t\t\t\t\t\t\tdeltaEntry.push(data.";
  protected final String TEXT_12 = ".initialValue[i]);" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\t\t\t\tdeltaEntry.push({ " + NL + "\t\t\t\t\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_13 = ".initialValue[i]," + NL + "\t\t\t\t\t\t\t\t\tvalue: value[i].$path\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t});\t\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\t\t\tdeltaEntry.push({ " + NL + "\t\t\t\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_14 = ".initialValue[i]," + NL + "\t\t\t\t\t\t\t\tvalue: typeof value[i] === \"function\" ? value[i]() : value[i]\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\t\tdeltaEntry.push({ initialValue : data.";
  protected final String TEXT_15 = ".initialValue[i] });" + NL + "\t\t\t\t\t}\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfor (var i = data.";
  protected final String TEXT_16 = ".initialValue.length; i < value.length; ++i) {" + NL + "\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\tif (value[i].hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\t\t\tdeltaEntry.push({ value : value[i].$path });\t\t\t\t\t" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tdeltaEntry.push({ value : typeof value[i] === \"function\" ? value[i]() : value[i] });\t\t\t\t\t" + NL + "\t\t\t\t\t}\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (dirty) {" + NL + "\t\t\t\t\tdelta.";
  protected final String TEXT_17 = " = deltaEntry;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tif (value.hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\tif (value.$path !== data.";
  protected final String TEXT_20 = ".initialValue) {" + NL + "\t\t\t\t\tdelta.";
  protected final String TEXT_21 = " = { " + NL + "\t\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_22 = ".initialValue," + NL + "\t\t\t\t\t\tvalue: value.$path\t\t\t\t\t" + NL + "\t\t\t\t\t};\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdelta.";
  protected final String TEXT_23 = " = { " + NL + "\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_24 = ".initialValue," + NL + "\t\t\t\t\tvalue: typeof value === \"function\" ? value() : value\t\t\t\t\t" + NL + "\t\t\t\t};\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t}" + NL + "}";
  protected final String TEXT_26 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	org.nasdanika.web.HttpServletRequestContext context = (org.nasdanika.web.HttpServletRequestContext) args[0];
	org.eclipse.emf.cdo.CDOObject cdoObject = (org.eclipse.emf.cdo.CDOObject) args[1]; 
	org.eclipse.emf.ecore.EReference ref = (org.eclipse.emf.ecore.EReference) args[2]; 
	boolean isLenient = (boolean) args[3];

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_4);
     if (ref.isMany()) { 
    stringBuffer.append(TEXT_5);
     if (isLenient) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_8);
     } else { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
     } else { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_24);
     } 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}