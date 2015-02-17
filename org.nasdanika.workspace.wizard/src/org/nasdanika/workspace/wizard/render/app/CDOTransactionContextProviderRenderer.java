package org.nasdanika.workspace.wizard.render.app;

public class CDOTransactionContextProviderRenderer {


  protected static String nl;
  public static synchronized CDOTransactionContextProviderRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOTransactionContextProviderRenderer result = new CDOTransactionContextProviderRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.emf.cdo.eresource.CDOResource;" + NL + "import org.eclipse.emf.cdo.transaction.CDOTransaction;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.nasdanika.cdo.CDOTransactionContextProviderComponent;" + NL + "import org.nasdanika.cdo.security.ProtectionDomain;" + NL + "import org.nasdanika.cdo.security.LoginPasswordCredentials;" + NL + "import org.nasdanika.web.HttpContext;" + NL + "" + NL + "public class ";
  protected final String TEXT_3 = "CDOTransactionContextProviderComponent extends CDOTransactionContextProviderComponent<LoginPasswordCredentials, HttpContext> {" + NL + "" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\t@Override" + NL + "\tprotected ProtectionDomain<LoginPasswordCredentials> getProtectionDomain(CDOTransaction view) {" + NL + "\t\tCDOResource res = view.getResource(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\tif (res!=null) {" + NL + "\t\t\tfor (EObject e: res.getContents()) {" + NL + "\t\t\t\tif (e instanceof ProtectionDomain) {" + NL + "\t\t\t\t\treturn (ProtectionDomain<LoginPasswordCredentials>) e;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_5 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}