package org.nasdanika.workspace.wizard;

public class CategoryRenderer {


  protected static String nl;
  public static synchronized CategoryRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CategoryRenderer result = new CategoryRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<site>" + NL + "   <feature url=\"features/";
  protected final String TEXT_2 = ".feature_";
  protected final String TEXT_3 = ".qualifier.jar\" id=\"";
  protected final String TEXT_4 = ".feature\" version=\"";
  protected final String TEXT_5 = ".qualifier\">" + NL + "      <category name=\"";
  protected final String TEXT_6 = ".category\"/>" + NL + "   </feature>" + NL + "   <category-def name=\"";
  protected final String TEXT_7 = ".category\" label=\"";
  protected final String TEXT_8 = "\">" + NL + "      <description>";
  protected final String TEXT_9 = NL + "         ";
  protected final String TEXT_10 = "." + NL + "      </description>" + NL + "   </category-def>" + NL + "</site>";
  protected final String TEXT_11 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}