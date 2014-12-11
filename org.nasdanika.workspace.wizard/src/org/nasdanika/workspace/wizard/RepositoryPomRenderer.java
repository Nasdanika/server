package org.nasdanika.workspace.wizard;

public class RepositoryPomRenderer {


  protected static String nl;
  public static synchronized RepositoryPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    RepositoryPomRenderer result = new RepositoryPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<artifactId>";
  protected final String TEXT_2 = ".repository</artifactId>" + NL + "\t<name>";
  protected final String TEXT_3 = " Repository</name>" + NL + "\t<packaging>eclipse-repository</packaging>" + NL + "\t<parent>" + NL + "\t\t<groupId>";
  protected final String TEXT_4 = "</groupId>" + NL + "\t\t<artifactId>";
  protected final String TEXT_5 = ".parent</artifactId>" + NL + "\t\t<version>";
  protected final String TEXT_6 = "-SNAPSHOT</version>" + NL + "\t\t<relativePath>../";
  protected final String TEXT_7 = ".parent</relativePath>" + NL + "\t</parent>" + NL + "\t<build>" + NL + "\t\t<plugins>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-p2-repository-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<includeAllDependencies>true</includeAllDependencies>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-p2-director-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<executions> " + NL + "\t\t\t\t\t<execution>" + NL + "\t\t\t\t\t\t<id>build-distributions</id>" + NL + "\t\t\t\t\t\t<goals>" + NL + "\t\t\t\t\t\t\t<!-- install the product using the p2 director -->" + NL + "\t\t\t\t\t\t\t<goal>materialize-products</goal>" + NL + "\t\t\t\t\t\t\t<!-- create zip file with the installed product -->" + NL + "\t\t\t\t\t\t\t<goal>archive-products</goal>" + NL + "\t\t\t\t\t\t</goals>" + NL + "\t\t\t\t\t</execution>" + NL + "\t\t\t\t</executions>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<products>" + NL + "\t\t\t\t\t\t<product>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_8 = ".product</id>" + NL + "\t\t\t\t\t\t</product>" + NL + "\t\t\t\t\t</products>" + NL + "\t\t\t\t\t<!-- global optional parameters (with default values) -->" + NL + "\t\t\t\t\t<installFeatures>true</installFeatures>" + NL + "\t\t\t\t\t<profile>DefaultProfile</profile>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "</project>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}