package org.nasdanika.workspace.wizard;

public class DockerfileRenderer {


  protected static String nl;
  public static synchronized DockerfileRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    DockerfileRenderer result = new DockerfileRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "FROM centos" + NL + "" + NL + "RUN yum update -y \\" + NL + "\t&& yum install -y \\" + NL + "\t\tjava-1.8.0-openjdk-devel \\" + NL + "\t\tgraphviz \\" + NL + "\t&& yum clean all " + NL + "\t\t" + NL + "" + NL + "COPY x86_64 /opt/";
  protected final String TEXT_2 = NL + NL + "RUN chmod a+x /opt/";
  protected final String TEXT_3 = "/eclipse\t" + NL + "" + NL + "ENTRYPOINT [\"/opt/";
  protected final String TEXT_4 = "/eclipse\"]" + NL + "" + NL + "EXPOSE 8080";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getDashedName());
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}