package org.nasdanika.cdo.web.routes;

public class CDOObjectEagerObjectGetDeltaGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized CDOObjectEagerObjectGetDeltaGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOObjectEagerObjectGetDeltaGenerator result = new CDOObjectEagerObjectGetDeltaGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (data.hasOwnProperty(\"";
  protected final String TEXT_2 = "\") && data.";
  protected final String TEXT_3 = ".hasOwnProperty(\"value\")) { // Was accessed and possibly changed" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tvar dirty = false;" + NL + "\t\tvar deltaEntry = [];" + NL + "\t\tfor (i = 0; i < data.";
  protected final String TEXT_5 = ".initialValue.length; ++i) {" + NL + "\t\t\tif (data.";
  protected final String TEXT_6 = ".value.length>i) {" + NL + "\t\t\t\tif (data.";
  protected final String TEXT_7 = ".value[i].hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\t\tif (data.";
  protected final String TEXT_8 = ".value[i].$path === data.";
  protected final String TEXT_9 = ".initialValue[i]) {" + NL + "\t\t\t\t\t\tdeltaEntry.push(data.";
  protected final String TEXT_10 = ".initialValue[i]);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\t\tdeltaEntry.push({ " + NL + "\t\t\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_11 = ".initialValue[i]," + NL + "\t\t\t\t\t\t\tvalue: data.";
  protected final String TEXT_12 = ".value[i].$path\t\t\t\t\t" + NL + "\t\t\t\t\t\t});\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdirty = true;" + NL + "\t\t\t\t\tdeltaEntry.push({ " + NL + "\t\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_13 = ".initialValue[i]," + NL + "\t\t\t\t\t\tvalue: data.";
  protected final String TEXT_14 = ".value[i]\t\t\t\t\t" + NL + "\t\t\t\t\t});\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdirty = true;" + NL + "\t\t\t\tdeltaEntry.push({ initialValue : data.";
  protected final String TEXT_15 = ".initialValue[i] });" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}" + NL + "\t\tfor (i = data.";
  protected final String TEXT_16 = ".initialValue.length; i < data.";
  protected final String TEXT_17 = ".value.length; ++i) {" + NL + "\t\t\tdirty = true;" + NL + "\t\t\tif (data.";
  protected final String TEXT_18 = ".value[i].hasOwnProperty(\"$path\")) {" + NL + "\t\t\t\tdeltaEntry.push({ value : data.";
  protected final String TEXT_19 = ".value[i].$path });\t\t\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdeltaEntry.push({ value : data.";
  protected final String TEXT_20 = ".value[i] });\t\t\t\t\t" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}" + NL + "\t\tif (dirty) {" + NL + "\t\t\tdelta.";
  protected final String TEXT_21 = " = deltaEntry;" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\tif (data.";
  protected final String TEXT_23 = ".value.hasOwnProperty(\"$path\")) {" + NL + "\t\t\tif (data.";
  protected final String TEXT_24 = ".value.$path !== data.";
  protected final String TEXT_25 = ".initialValue) {" + NL + "\t\t\t\tdelta.";
  protected final String TEXT_26 = " = { " + NL + "\t\t\t\t\tinitialValue: data.";
  protected final String TEXT_27 = ".initialValue," + NL + "\t\t\t\t\tvalue: data.";
  protected final String TEXT_28 = ".value.$path\t\t\t\t\t" + NL + "\t\t\t\t};\t\t\t" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tdelta.";
  protected final String TEXT_29 = " = { " + NL + "\t\t\t\tinitialValue: data.";
  protected final String TEXT_30 = ".initialValue," + NL + "\t\t\t\tvalue: data.";
  protected final String TEXT_31 = ".value\t\t\t\t\t" + NL + "\t\t\t};\t\t\t\t\t" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_32 = NL + "}";
  protected final String TEXT_33 = NL;

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
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ref.getName());
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
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_21);
     } else { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ref.getName());
    stringBuffer.append(TEXT_31);
     } 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}