package org.nasdanika.workspace.wizard;

public class ProductCategoryRenderer {


  protected static String nl;
  public static synchronized ProductCategoryRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ProductCategoryRenderer result = new ProductCategoryRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<site>" + NL + "\t";
  protected final String TEXT_2 = NL + "\t   <feature url=\"features/";
  protected final String TEXT_3 = "_";
  protected final String TEXT_4 = ".qualifier.jar\" id=\"";
  protected final String TEXT_5 = "\" version=\"";
  protected final String TEXT_6 = ".qualifier\">" + NL + "\t      <category name=\"";
  protected final String TEXT_7 = ".product.category\"/>" + NL + "\t   </feature>";
  protected final String TEXT_8 = NL + "   <category-def name=\"";
  protected final String TEXT_9 = ".product.category\" label=\"";
  protected final String TEXT_10 = " Product\">" + NL + "      <description>";
  protected final String TEXT_11 = NL + "         ";
  protected final String TEXT_12 = " Product." + NL + "      </description>" + NL + "   </category-def>" + NL + "</site>";
  protected final String TEXT_13 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     for (String featureId: wizard.getProductCategorizedFeatures()) { 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(featureId);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(featureId);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}