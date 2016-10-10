package org.nasdanika.workspace.wizard;

public class ModelRenderer {


  protected static String nl;
  public static synchronized ModelRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelRenderer result = new ModelRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\"" + NL + "    name=\"";
  protected final String TEXT_2 = "\" nsURI=\"urn:";
  protected final String TEXT_3 = "\" nsPrefix=\"";
  protected final String TEXT_4 = "\">" + NL + "  <eClassifiers xsi:type=\"ecore:EClass\" name=\"";
  protected final String TEXT_5 = "\"/>" + NL + "</ecore:EPackage>";
  protected final String TEXT_6 = NL;

public String generate(org.nasdanika.workspace.wizard.ModelingWorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getModelPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}