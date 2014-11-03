package org.nasdanika.workspace.wizard;

public class ActorImplPomRenderer {


  protected static String nl;
  public static synchronized ActorImplPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ActorImplPomRenderer result = new ActorImplPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<artifactId>";
  protected final String TEXT_2 = "</artifactId>" + NL + "\t<packaging>eclipse-plugin</packaging>" + NL + "\t<parent>" + NL + "\t\t<groupId>";
  protected final String TEXT_3 = "</groupId>" + NL + "\t\t<artifactId>";
  protected final String TEXT_4 = "</artifactId>" + NL + "\t\t<version>";
  protected final String TEXT_5 = "-SNAPSHOT</version>" + NL + "\t\t<relativePath>../";
  protected final String TEXT_6 = "</relativePath>" + NL + "\t</parent>" + NL + "</project>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}