package org.nasdanika.workspace.wizard;

public class TestFragmentPomRenderer {


  protected static String nl;
  public static synchronized TestFragmentPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    TestFragmentPomRenderer result = new TestFragmentPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<artifactId>";
  protected final String TEXT_2 = "</artifactId>" + NL + "\t<packaging>eclipse-test-plugin</packaging>" + NL + "    <name>";
  protected final String TEXT_3 = " Tests Fragment</name>" + NL + "\t<parent>" + NL + "\t\t<groupId>";
  protected final String TEXT_4 = "</groupId>" + NL + "\t\t<artifactId>";
  protected final String TEXT_5 = "</artifactId>" + NL + "\t\t<version>";
  protected final String TEXT_6 = "-SNAPSHOT</version>" + NL + "\t\t<relativePath>../";
  protected final String TEXT_7 = "</relativePath>" + NL + "\t</parent>" + NL + "\t<build>" + NL + "\t\t<plugins>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-surefire-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<dependencies>\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>org.nasdanika.cdo.feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>org.nasdanika.equinox.feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>org.nasdanika.feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>org.nasdanika.server.jetty.feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>org.nasdanika.webtest.feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-plugin</type>" + NL + "\t\t\t\t\t\t\t<artifactId>";
  protected final String TEXT_19 = "</artifactId>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-plugin</type>" + NL + "\t\t\t\t\t\t\t<artifactId>";
  protected final String TEXT_22 = "</artifactId>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t</dependencies>" + NL + "\t\t\t\t\t<bundleStartLevel>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.core.runtime</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.common</id>" + NL + "\t\t\t\t\t\t\t<level>2</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.ds</id>" + NL + "\t\t\t\t\t\t\t<level>1</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.http.jetty</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.http.registry</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_24 = "</id>" + NL + "\t\t\t\t\t\t\t<level>3</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_25 = "</id>" + NL + "\t\t\t\t\t\t\t<level>3</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_26 = "</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t</bundleStartLevel>" + NL + "                    <includes>" + NL + "\t                    <include>**/";
  protected final String TEXT_27 = "Tests.java</include>" + NL + "                    </includes>" + NL + "\t\t\t\t\t<argLine>-Xmx512m -Dorg.osgi.service.http.port=8080 ";
  protected final String TEXT_28 = "-Dorg.eclipse.equinox.http.jetty.context.path=";
  protected final String TEXT_29 = "</argLine>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "</project>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_7);
     if (wizard.isIncludeCdo()) { 
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
     if (wizard.isIncludeEquinox()) { 
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
     if (wizard.isIncludeNasdanika()) { 
    stringBuffer.append(TEXT_12);
     } 
    stringBuffer.append(TEXT_13);
     if (wizard.isIncludeJetty()) { 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     if (wizard.isIncludeWebTest()) { 
    stringBuffer.append(TEXT_16);
     } 
    stringBuffer.append(TEXT_17);
     if (wizard.getPageImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     if (wizard.getActorImplArtifactId()!=null) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_27);
     if (wizard.getContextPath()!=null) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(wizard.getContextPath());
     } 
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}