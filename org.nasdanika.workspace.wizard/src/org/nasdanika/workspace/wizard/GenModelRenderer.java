package org.nasdanika.workspace.wizard;

public class GenModelRenderer {


  protected static String nl;
  public static synchronized GenModelRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    GenModelRenderer result = new GenModelRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<genmodel:GenModel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:genmodel=\"http://www.eclipse.org/emf/2002/GenModel\"" + NL + "    modelDirectory=\"/";
  protected final String TEXT_2 = "/src\" modelPluginID=\"";
  protected final String TEXT_3 = "\"" + NL + "    modelName=\"";
  protected final String TEXT_4 = "\" rootExtendsInterface=\"org.eclipse.emf.cdo.CDOObject\"" + NL + "    rootExtendsClass=\"org.eclipse.emf.internal.cdo.CDOObjectImpl\" reflectiveDelegation=\"true\"" + NL + "    importerID=\"org.eclipse.emf.importer.cdo\" featureDelegation=\"Reflective\" complianceLevel=\"8.0\"" + NL + "    suppressGenModelAnnotations=\"false\" copyrightFields=\"false\" providerRootExtendsClass=\"org.eclipse.emf.cdo.edit.CDOItemProviderAdapter\"" + NL + "    operationReflection=\"true\" importOrganizing=\"true\">" + NL + "  <foreignModel>";
  protected final String TEXT_5 = ".ecore</foreignModel>" + NL + "  <modelPluginVariables>CDO=org.eclipse.emf.cdo</modelPluginVariables>" + NL + "  <genPackages prefix=\"";
  protected final String TEXT_6 = "\" basePackage=\"";
  protected final String TEXT_7 = "\" disposableProviderFactory=\"true\" ecorePackage=\"";
  protected final String TEXT_8 = ".ecore#/\">" + NL + "    <genClasses ecoreClass=\"";
  protected final String TEXT_9 = ".ecore#//";
  protected final String TEXT_10 = "\"/>" + NL + "  </genPackages>" + NL + "</genmodel:GenModel>";
  protected final String TEXT_11 = NL;

public String generate(org.nasdanika.workspace.wizard.ModelingWorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getGenModelPackagePrefix());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getGenModelBasePackageName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}