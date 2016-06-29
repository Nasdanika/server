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
  protected final String TEXT_4 = "-SNAPSHOT</version>" + NL + "\t<packaging>pom</packaging>" + NL + "" + NL + "\t<!-- tycho requires maven >= 3.0 -->" + NL + "\t<prerequisites>" + NL + "\t\t<maven>3.0</maven>" + NL + "\t</prerequisites>" + NL + "\t" + NL + "\t<properties>" + NL + "\t\t<tycho-version>0.25.0</tycho-version>" + NL + "\t</properties>" + NL + "" + NL + "\t<repositories>" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\t\t<repository>" + NL + "\t\t\t\t<id>";
  protected final String TEXT_6 = "</id>" + NL + "\t\t\t\t<url>";
  protected final String TEXT_7 = "</url>" + NL + "\t\t\t\t<layout>p2</layout>" + NL + "\t\t\t</repository>\t\t" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t</repositories>" + NL + " \t" + NL + " \t<build>" + NL + "\t\t<sourceDirectory>src</sourceDirectory>" + NL + "\t\t<plugins>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.apache.maven.plugins</groupId>" + NL + "\t\t\t\t<artifactId>maven-javadoc-plugin</artifactId>" + NL + "\t\t\t\t<version>2.10.4</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t  \t        \t<reportOutputDirectory>${project.build.directory}/../";
  protected final String TEXT_9 = "/apidocs</reportOutputDirectory>" + NL + "\t\t\t\t\t<linksource>true</linksource>" + NL + "\t\t\t\t\t<failOnError>false</failOnError>" + NL + "\t\t            <links>" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.boxing/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.function/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.h2/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.promise/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.sca/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.sca.edit/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.scheduler/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security.edit/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security.editor/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web.doc/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.core/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.function.cdo/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.function/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.html/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.sca.design/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.sca.edit/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.sca.editor/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.sca/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.tools.design/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.web/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.webtest.performance/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.webtest/apidocs</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://www.nasdanika.org/server/apidocs/org.nasdanika.workspace.wizard/apidocs</link>" + NL + "\t\t\t\t\t\t<link>http://download.eclipse.org/modeling/emf/emf/javadoc/2.11</link>" + NL + "\t\t\t\t\t\t<link>http://help.eclipse.org/neon/topic/org.eclipse.emf.cdo.doc/javadoc</link>" + NL + "\t\t\t\t\t\t<link>http://stleary.github.io/JSON-java</link>\t\t\t" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<!--\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<link>http://docs.oracle.com/javase/8/docs/api</link>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t-->" + NL + "\t\t            </links>" + NL + "\t\t\t\t\t<detectLinks>true</detectLinks>\t\t\t\t\t" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<!-- enable tycho build extension -->" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-maven-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<extensions>true</extensions>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>target-platform-configuration</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<!--" + NL + "\t\t\t\t\t<target>" + NL + "\t\t\t\t\t\t<artifact>" + NL + "\t\t\t\t\t\t\t<groupId>";
  protected final String TEXT_10 = "</groupId>" + NL + "\t\t\t\t\t\t\t<artifactId>";
  protected final String TEXT_11 = ".target</artifactId>" + NL + "\t\t\t\t\t\t\t<version>";
  protected final String TEXT_12 = "-SNAPSHOT</version>" + NL + "\t\t\t\t\t\t</artifact>" + NL + "\t\t\t\t\t</target>" + NL + "\t\t\t\t\t-->" + NL + "\t\t\t\t\t<pomDependencies>consider</pomDependencies>" + NL + "\t\t\t\t\t<!-- configure the p2 target environments for multi-platform build -->" + NL + "\t\t\t\t\t<environments>" + NL + "\t\t\t\t\t\t<environment>" + NL + "\t\t\t\t\t\t\t<os>linux</os>" + NL + "\t\t\t\t\t\t\t<ws>gtk</ws>" + NL + "\t\t\t\t\t\t\t<arch>x86_64</arch>" + NL + "\t\t\t\t\t\t</environment>" + NL + "\t\t\t\t\t\t<environment>" + NL + "\t\t\t\t\t\t\t<os>win32</os>" + NL + "\t\t\t\t\t\t\t<ws>win32</ws>" + NL + "\t\t\t\t\t\t\t<arch>x86_64</arch>" + NL + "\t\t\t\t\t\t</environment>" + NL + "\t\t\t\t\t</environments>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t<!-- enable source bundle generation -->" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-source-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<executions>" + NL + "\t\t\t\t\t<execution>" + NL + "\t\t\t\t\t\t<id>plugin-source</id>" + NL + "\t\t\t\t\t\t<goals>" + NL + "\t\t\t\t\t\t\t<goal>plugin-source</goal>" + NL + "\t\t\t\t\t\t</goals>" + NL + "\t\t\t\t\t</execution>" + NL + "\t\t\t\t</executions>" + NL + "\t\t\t</plugin>" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "\t<modules>" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t<module>../";
  protected final String TEXT_14 = "</module>" + NL + "\t";
  protected final String TEXT_15 = NL + "\t</modules>" + NL + "</project>";
  protected final String TEXT_16 = NL;

public String generate(org.nasdanika.workspace.wizard.AbstractWorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_4);
     for (java.util.Map.Entry<String,String> repoEntry: wizard.getRepositories().entrySet()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(repoEntry.getKey());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(repoEntry.getValue());
    stringBuffer.append(TEXT_7);
     } 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getDocArtifactId());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_12);
     for (String module: wizard.getModules()) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}