package org.nasdanika.cdo.web.html;

public class KnockoutJsModelGenerator implements org.nasdanika.cdo.web.routes.Generator {


  protected static String nl;
  public static synchronized KnockoutJsModelGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    KnockoutJsModelGenerator result = new KnockoutJsModelGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "function(inputData, applyTarget) {" + NL + "    " + NL + "    this.observableData = {" + NL + "    \t";
  protected final String TEXT_2 = NL + "        \t";
  protected final String TEXT_3 = ": ko.observable()";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = NL + "    };" + NL + "    " + NL + "    this.observableValidationResults = {" + NL + "    \t";
  protected final String TEXT_6 = NL + "    }" + NL + "    " + NL + "    this.clear = function() {" + NL + "    \t";
  protected final String TEXT_7 = NL + "\t\t\t";
  protected final String TEXT_8 = "this.observableData.";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = "    \t" + NL + "        \tthis.observableValidationResults.";
  protected final String TEXT_12 = "(undefined);";
  protected final String TEXT_13 = NL + "    }" + NL + "    " + NL + "    this.clear();" + NL + "    " + NL + "    var data = {};" + NL + "    " + NL + "   \t";
  protected final String TEXT_14 = NL + "    \tObject.defineProperty(data, \"";
  protected final String TEXT_15 = "\", { " + NL + "    \t\tget: this.observableData.";
  protected final String TEXT_16 = "," + NL + "    \t\tset: this.observableData.";
  protected final String TEXT_17 = NL + "\t    });";
  protected final String TEXT_18 = "                 " + NL + "    " + NL + "    var validationResults = {};" + NL + "    " + NL + "   \t";
  protected final String TEXT_19 = NL + "    \tObject.defineProperty(validationResults, \"";
  protected final String TEXT_20 = "\", { " + NL + "    \t\tget: this.observableValidationResults.";
  protected final String TEXT_21 = "," + NL + "    \t\tset: this.observableValidationResults.";
  protected final String TEXT_22 = NL + "    " + NL + "    Object.defineProperty(this, \"data\", {" + NL + "        get: function() { " + NL + "            return data; " + NL + "        }," + NL + "        set: function(newData) {" + NL + "            for (k in newData) {" + NL + "                if (ko.isObservable(this.observableData[k])) {" + NL + "                    this.observableData[k](newData[k]);" + NL + "                } else {" + NL + "                    this.observableData[k] = newData[k];" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    });" + NL + "    " + NL + "    Object.defineProperty(this, \"validationResults\", {" + NL + "        get: function() { " + NL + "            return validationResults; " + NL + "        }," + NL + "        set: function(newValidationResults) {" + NL + "            for (k in this.observableValidationResults) {" + NL + "            \tif (newValidationResults.hasOwnProperty(k)) {" + NL + "\t                if (ko.isObservable(this.observableValidationResults[k])) {" + NL + "\t                    this.observableValidationResults[k](newValidationResults[k]);" + NL + "\t                } else {" + NL + "\t                    this.observableValidationResults[k] = newValidationResults[k];" + NL + "\t                }" + NL + "            \t} else {" + NL + "\t                if (ko.isObservable(this.observableValidationResults[k])) {" + NL + "\t                    this.observableValidationResults[k](\"\");" + NL + "\t                }            \t\t" + NL + "            \t}  " + NL + "            }" + NL + "        }" + NL + "    });" + NL + "    ";
  protected final String TEXT_23 = NL + "    \tthis.loadModel = function(source) {" + NL + "    \t\t";
  protected final String TEXT_24 = NL + "    \t};";
  protected final String TEXT_25 = "    " + NL + "    " + NL + "    this.validate = function() {    " + NL + "\t\treturn Q.all([" + NL + "\t\t   \t";
  protected final String TEXT_26 = NL + "\t\t            Q.when(this.observableData.";
  protected final String TEXT_27 = "()).then(function(value) {" + NL + "\t\t                ";
  protected final String TEXT_28 = " " + NL + "\t\t            }.bind(this)).then(function(validationResult) {" + NL + "\t\t                this.observableValidationResults.";
  protected final String TEXT_29 = "(validationResult); " + NL + "\t\t                return !validationResult; " + NL + "\t\t            }.bind(this))\t\t   \t\t\t   \t" + NL + "\t\t   \t";
  protected final String TEXT_30 = NL + "        ]).then(function(vResults) { " + NL + "            return vResults.reduce(function(r1, r2) { " + NL + "                return r1 && r2; " + NL + "            }, true); " + NL + "        });" + NL + "    };" + NL + "    " + NL + "    this._apply = function() {";
  protected final String TEXT_31 = NL + "        ";
  protected final String TEXT_32 = NL + "    }" + NL + "    " + NL + "    this.apply = function() {" + NL + "    \tvar ret = this._apply();" + NL + "    \tret.then(function() { this.isDirty(false); }.bind(this));" + NL + "    \treturn ret;" + NL + "    }" + NL + "    " + NL + "    this.validateAndApply = function(applyTarget) {" + NL + "\t    return this.validate().then(function(isValid) {" + NL + "\t        if (isValid) {" + NL + "                return this.apply().then(undefined, function(reason) {" + NL + "                    if (reason.validationFailed) {" + NL + "\t\t\t\t        if (reason.validationResults && reason.validationResults.operation) {" + NL + "                            this.validationResults = reason.validationResults.operation;" + NL + "                        } " + NL + "\t\t\t\t        throw reason;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t    throw { " + NL + "                        targetInvocationError: reason " + NL + "                    };" + NL + "                }.bind(this));" + NL + "            }" + NL + "            throw { " + NL + "                validationFailed: true " + NL + "            };" + NL + "        }.bind(this));        " + NL + "    }" + NL + "    " + NL + "    if (inputData) {" + NL + "    \tthis.data = inputData;" + NL + "    }" + NL + "    " + NL + "    // Notifications" + NL + "    this.isDirty = ko.observable(false);" + NL + "" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\tthis.observableData.";
  protected final String TEXT_34 = ".subscribe(function(newValue) {" + NL + "\t\t\tthis.isDirty(true);" + NL + "\t\t\tif (typeof this.notify === 'function') {" + NL + "\t\t\t\tthis.notify(\"";
  protected final String TEXT_35 = "\", newValue);" + NL + "\t\t\t}" + NL + "\t\t}.bind(this));" + NL + "\t";
  protected final String TEXT_36 = NL + "    " + NL + "    // Custom declarations";
  protected final String TEXT_37 = NL + "    ";
  protected final String TEXT_38 = NL + "    " + NL + "}";
  protected final String TEXT_39 = NL;

public String generate(Object... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	// { name, defaultValueLiteral, validator }
	java.util.List<String[]> dataMap = (java.util.List<String[]>) args[0];

    stringBuffer.append(TEXT_1);
     for (int i=1; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_3);
     if (i<dataMap.size()-1) { 
    stringBuffer.append(TEXT_4);
     } 
     } 
    stringBuffer.append(TEXT_5);
     for (int i=0; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_3);
     if (i<dataMap.size()-1) { 
    stringBuffer.append(TEXT_4);
     } 
     } 
    stringBuffer.append(TEXT_6);
     for (int i=0; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_7);
     if (i>0) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( dataMap.get(i)[1]==null ? "undefined" : dataMap.get(i)[1] );
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_12);
     } 
    stringBuffer.append(TEXT_13);
     for (int i=1; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_18);
     for (int i=0; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_17);
     } 
    stringBuffer.append(TEXT_22);
     if (args[1]!=null) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(args[1]);
    stringBuffer.append(TEXT_24);
     } 
    stringBuffer.append(TEXT_25);
     
		   		boolean hasValidatorEntries = false;
		   		for (int i=0; i<dataMap.size(); ++i) {
		   			if (dataMap.get(i)[2]!=null) {
		   				if (hasValidatorEntries) { 
		   					stringBuffer.append(",");
		   				}		   				
		   				hasValidatorEntries = true;
		   	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dataMap.get(i)[2]);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_29);
     
		   			}
		   		} 
		   	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(args[2]);
    stringBuffer.append(TEXT_32);
     for (int i=1; i<dataMap.size(); ++i) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dataMap.get(i)[0]);
    stringBuffer.append(TEXT_35);
     } 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(args[3]);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}