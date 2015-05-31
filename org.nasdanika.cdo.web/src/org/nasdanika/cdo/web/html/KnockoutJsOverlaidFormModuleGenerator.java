package org.nasdanika.cdo.web.html;

public class KnockoutJsOverlaidFormModuleGenerator<C extends org.nasdanika.core.Context, T> extends org.nasdanika.core.AbstractCommand<C,T,String> {

  protected static String nl;
  public static synchronized KnockoutJsOverlaidFormModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    KnockoutJsOverlaidFormModuleGenerator result = new KnockoutJsOverlaidFormModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "require([\"";
  protected final String TEXT_3 = ".js\", 'q', 'jquery', 'knockout', 'domReady!'], function(guest, Q, jQuery, ko, doc) {" + NL + "\tvar formContainer = doc.getElementById('";
  protected final String TEXT_4 = "');" + NL + "\tvar overlay = formContainer.children[0];" + NL + "\tko.applyBindings({" + NL + "\t\tmodel: new ";
  protected final String TEXT_5 = "(undefined, guest)," + NL + "\t\tsubmitHandler: function(form) {" + NL + "\t\t\toverlay.style.width = form.offsetWidth+\"px\";" + NL + "\t\t\toverlay.style.height = form.offsetHeight+\"px\";" + NL + "\t\t\toverlay.style.display = \"block\";\t\t" + NL + "" + NL + "\t\t\tthis.model.validateAndApply().then(function(value) {" + NL + "\t\t\t\toverlay.style.display = \"none\";\t\t" + NL + "\t\t\t\tif (value.validationResults) {" + NL + "\t\t\t\t\tthis.validationResults = value.validationResults;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t}" + NL + "\t\t\t}.bind(this.model)," + NL + "\t\t\tfunction(reason) {" + NL + "\t\t\t\toverlay.style.display = \"none\";\t\t" + NL + "\t\t\t\tif (reason.targetInvocationError) {" + NL + "\t\t\t\t\tthis.validationResults['$this'] = reason.targetInvocationError;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t//this.validationResults['$this'] = JSON.stringify(reason);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t}.bind(this.model)).done();" + NL + "\t\t}," + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tcancelHandler: function() {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t}, formContainer);" + NL + "" + NL + "});";
  protected final String TEXT_10 = NL;

@Override
public String execute(C context, T... args) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	T moduleName = args[0];
	T formHandler = args[1];
	T formContainerId = args[2];
	T onSubmitted = args[3];
	T onCancel = args[4];

    stringBuffer.append(TEXT_2);
    stringBuffer.append(moduleName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(formContainerId);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(formHandler);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(onSubmitted);
    stringBuffer.append(TEXT_6);
     if (onCancel!=null) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(onCancel);
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}