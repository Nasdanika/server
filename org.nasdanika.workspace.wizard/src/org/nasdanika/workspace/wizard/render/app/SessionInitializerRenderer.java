package org.nasdanika.workspace.wizard.render.app;

public class SessionInitializerRenderer {


  protected static String nl;
  public static synchronized SessionInitializerRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    SessionInitializerRenderer result = new SessionInitializerRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;" + NL + "import org.eclipse.emf.cdo.eresource.CDOResource;" + NL + "import org.eclipse.emf.cdo.session.CDOSession;" + NL + "import org.eclipse.emf.cdo.transaction.CDOTransaction;" + NL + "import org.eclipse.emf.cdo.util.CommitException;" + NL + "import org.nasdanika.cdo.CDOSessionInitializer;" + NL + "" + NL + "//import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "Factory;" + NL + "//import ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "Package;" + NL + "//import ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";" + NL + "" + NL + "public class ";
  protected final String TEXT_9 = "SessionInitializerComponent implements CDOSessionInitializer {" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic void init(CDOSession session) {" + NL + "\t\tSystem.out.println(\"Initializing session\");" + NL + "\t\t" + NL + "\t\t// Register packages" + NL + "\t\tCDOPackageRegistry packageRegistry = session.getPackageRegistry();" + NL + "\t\t// TODO - packageRegistry.putEPackage(";
  protected final String TEXT_10 = "Package.eINSTANCE);" + NL + "\t\t" + NL + "\t\t// Populate with initial data if empty." + NL + "\t\tCDOTransaction transaction = session.openTransaction();\t\t\t\t" + NL + "\t\ttry {" + NL + "\t\t\tCDOResource cRes = transaction.getOrCreateResource(\"/";
  protected final String TEXT_11 = "\");" + NL + "\t\t\tif (cRes.getContents().isEmpty()) {" + NL + "\t\t\t\t// Create initial content" + NL + "\t\t\t\t// TODO - ";
  protected final String TEXT_12 = " rootElement = ";
  protected final String TEXT_13 = "Factory.eINSTANCE.create";
  protected final String TEXT_14 = "();" + NL + "\t\t\t\t// TODO - configure root and add sub-elements" + NL + "\t\t\t\t// TODO - cRes.getContents().add(rootElement);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\ttransaction.commit();" + NL + "\t\t} catch (CommitException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_15 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getModelArtifactId());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}