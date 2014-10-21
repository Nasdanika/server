package org.nasdanika.workspace.wizard;

public class AggregatorPomRenderer {


  protected static String nl;
  public static synchronized AggregatorPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    AggregatorPomRenderer result = new AggregatorPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<project" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\"" + NL + "\txmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<groupId>";
  protected final String TEXT_2 = "</groupId>" + NL + "\t<artifactId>";
  protected final String TEXT_3 = ".aggregator</artifactId>" + NL + "\t<version>";
  protected final String TEXT_4 = "-SNAPSHOT</version>" + NL + "\t<name>Aggregator</name>" + NL + "\t<packaging>pom</packaging>" + NL + "\t<modules>" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\t<module>../";
  protected final String TEXT_6 = "</module>" + NL + "\t";
  protected final String TEXT_7 = NL + "\t</modules>" + NL + "</project>";
  protected final String TEXT_8 = NL;

public String generate(WorkspaceWizard wizard) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(wizard.getGroupId());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(wizard.getVersion());
    stringBuffer.append(TEXT_4);
     for (String module: wizard.getModules()) { 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_6);
     } 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}