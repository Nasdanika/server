package org.nasdanika.workspace.wizard;

public class ParentPomRenderer {


  protected static String nl;
  public static synchronized ParentPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ParentPomRenderer result = new ParentPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<project" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\"" + NL + "\txmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<groupId>";
  protected final String TEXT_2 = "</groupId>" + NL + "\t<artifactId>";
  protected final String TEXT_3 = "</artifactId>" + NL + "\t<version>";
  protected final String TEXT_4 = "-SNAPSHOT</version>" + NL + "\t<packaging>pom</packaging>" + NL + "" + NL + "\t<!-- tycho requires maven >= 3.0 -->" + NL + "\t<prerequisites>" + NL + "\t\t<maven>3.0</maven>" + NL + "\t</prerequisites>" + NL + "" + NL + "\t<properties>" + NL + "\t\t<tycho-version>0.23.0</tycho-version>" + NL + "\t\t<luna-repo.url>http://download.eclipse.org/releases/luna</luna-repo.url>" + NL + "\t</properties>" + NL + "\t " + NL + "\t<repositories>" + NL + "\t\t<repository>" + NL + "\t\t\t<id>luna</id>" + NL + "\t\t\t<url>${luna-repo.url}</url>" + NL + "\t\t\t<layout>p2</layout>" + NL + "\t\t</repository>" + NL + "\t\t<repository>" + NL + "\t\t\t<id>orbit</id>" + NL + "\t\t\t<url>http://download.eclipse.org/tools/orbit/downloads/drops/R20150124073747/repository</url>" + NL + "\t\t\t<layout>p2</layout>" + NL + "\t\t</repository>" + NL + "\t\t<repository>" + NL + "\t\t\t<id>jetty</id>" + NL + "\t\t\t<url>http://download.eclipse.org/jetty/updates/jetty-bundles-8.x</url>" + NL + "\t\t\t<layout>p2</layout>" + NL + "\t\t</repository>" + NL + "\t\t<repository>" + NL + "\t\t\t<id>maven-osgi</id>" + NL + "\t\t\t<url>http://www.nasdanika.org/maven-osgi</url>" + NL + "\t\t\t<layout>p2</layout>" + NL + "\t\t</repository>" + NL + "\t\t<repository>" + NL + "\t\t\t<id>nasdanika-server</id>" + NL + "\t\t\t<url>http://www.nasdanika.org/server/repository</url>" + NL + "\t\t\t<layout>p2</layout>" + NL + "\t\t</repository>" + NL + "\t</repositories>" + NL + " \t" + NL + " \t<build>" + NL + "\t\t<sourceDirectory>src</sourceDirectory>" + NL + "\t\t<plugins>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.apache.maven.plugins</groupId>" + NL + "\t\t\t\t<artifactId>maven-javadoc-plugin</artifactId>" + NL + "\t\t\t\t<version>2.9.1</version>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<!-- enable tycho build extension -->" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-maven-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<extensions>true</extensions>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>target-platform-configuration</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<!--" + NL + "\t\t\t\t\t<target>" + NL + "\t\t\t\t\t\t<artifact>" + NL + "\t\t\t\t\t\t\t<groupId>";
  protected final String TEXT_5 = "</groupId>" + NL + "\t\t\t\t\t\t\t<artifactId>";
  protected final String TEXT_6 = ".target</artifactId>" + NL + "\t\t\t\t\t\t\t<version>";
  protected final String TEXT_7 = "-SNAPSHOT</version>" + NL + "\t\t\t\t\t\t</artifact>" + NL + "\t\t\t\t\t</target>" + NL + "\t\t\t\t\t-->" + NL + "\t\t\t\t\t<pomDependencies>consider</pomDependencies>" + NL + "\t\t\t\t\t<!-- configure the p2 target environments for multi-platform build -->" + NL + "\t\t\t\t\t<environments>" + NL + "\t\t\t\t\t\t<environment>" + NL + "\t\t\t\t\t\t\t<os>linux</os>" + NL + "\t\t\t\t\t\t\t<ws>gtk</ws>" + NL + "\t\t\t\t\t\t\t<arch>x86_64</arch>" + NL + "\t\t\t\t\t\t</environment>" + NL + "\t\t\t\t\t\t<environment>" + NL + "\t\t\t\t\t\t\t<os>win32</os>" + NL + "\t\t\t\t\t\t\t<ws>win32</ws>" + NL + "\t\t\t\t\t\t\t<arch>x86_64</arch>" + NL + "\t\t\t\t\t\t</environment>" + NL + "\t\t\t\t\t</environments>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<!-- enable source bundle generation -->" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-source-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<executions>" + NL + "\t\t\t\t\t<execution>" + NL + "\t\t\t\t\t\t<id>plugin-source</id>" + NL + "\t\t\t\t\t\t<goals>" + NL + "\t\t\t\t\t\t\t<goal>plugin-source</goal>" + NL + "\t\t\t\t\t\t</goals>" + NL + "\t\t\t\t\t</execution>" + NL + "\t\t\t\t</executions>" + NL + "\t\t\t</plugin>" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "\t<modules>" + NL + "\t";
  protected final String TEXT_8 = NL + "\t\t<module>../";
  protected final String TEXT_9 = "</module>" + NL + "\t";
  protected final String TEXT_10 = NL + "\t</modules>" + NL + "</project>";
  protected final String TEXT_11 = NL;

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_7);
     for (String module: wizard.getModules()) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}