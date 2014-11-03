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
  protected final String TEXT_2 = "</artifactId>" + NL + "\t<packaging>eclipse-test-plugin</packaging>" + NL + "\t<parent>" + NL + "\t\t<groupId>";
  protected final String TEXT_3 = "</groupId>" + NL + "\t\t<artifactId>";
  protected final String TEXT_4 = "</artifactId>" + NL + "\t\t<version>";
  protected final String TEXT_5 = "-SNAPSHOT</version>" + NL + "\t\t<relativePath>../";
  protected final String TEXT_6 = "</relativePath>" + NL + "\t</parent>" + NL + "\t<build>" + NL + "\t\t<plugins>" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-surefire-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<dependencies>\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t<dependency>" + NL + "\t\t\t\t\t\t\t<type>eclipse-feature</type>" + NL + "\t\t\t\t\t\t\t<artifactId>";
  protected final String TEXT_7 = ".feature</artifactId>" + NL + "\t\t\t\t\t\t\t<version>0.0.0</version>" + NL + "\t\t\t\t\t\t</dependency>\t\t\t\t\t\t" + NL + "\t\t\t\t\t</dependencies>" + NL + "\t\t\t\t\t<bundleStartLevel>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.core.runtime</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.common</id>" + NL + "\t\t\t\t\t\t\t<level>2</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.ds</id>" + NL + "\t\t\t\t\t\t\t<level>1</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.http.jetty</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>org.eclipse.equinox.http.registry</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_8 = "</id>" + NL + "\t\t\t\t\t\t\t<level>3</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_9 = "</id>" + NL + "\t\t\t\t\t\t\t<level>3</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t\t<bundle>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_10 = "</id>" + NL + "\t\t\t\t\t\t\t<level>4</level>" + NL + "\t\t\t\t\t\t\t<autoStart>true</autoStart>" + NL + "\t\t\t\t\t\t</bundle>" + NL + "\t\t\t\t\t</bundleStartLevel>" + NL + "                    <includes>" + NL + "\t                    <include>**/";
  protected final String TEXT_11 = "Tests.java</include>" + NL + "                    </includes>" + NL + "\t\t\t\t\t<argLine>-Xmx512m -Dorg.osgi.service.http.port=8080</argLine>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "</project>";

public String generate(org.nasdanika.workspace.wizard.WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getTestsArtifactId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(wizard.getParentArtifactId());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(wizard.getPageImplArtifactId());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(wizard.getActorImplArtifactId());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(wizard.getApplicationArtifactId());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(wizard.getJavaName());
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}