package org.nasdanika.workspace.wizard;

public class ProductPomRenderer {


  protected static String nl;
  public static synchronized ProductPomRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    ProductPomRenderer result = new ProductPomRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + NL + "\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">" + NL + "\t<modelVersion>4.0.0</modelVersion>" + NL + "\t<artifactId>";
  protected final String TEXT_2 = ".product</artifactId>" + NL + "\t<name>";
  protected final String TEXT_3 = " Product</name>" + NL + "\t<packaging>eclipse-repository</packaging>" + NL + "\t<parent>" + NL + "\t\t<groupId>";
  protected final String TEXT_4 = "</groupId>" + NL + "\t\t<artifactId>";
  protected final String TEXT_5 = ".product.parent</artifactId>" + NL + "\t\t<version>";
  protected final String TEXT_6 = "-SNAPSHOT</version>" + NL + "\t\t<relativePath>../";
  protected final String TEXT_7 = ".product.parent</relativePath>" + NL + "\t</parent>" + NL + "\t<build>" + NL + "\t\t<plugins>" + NL + "\t\t\t<!--" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-p2-repository-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t-->" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<groupId>org.eclipse.tycho</groupId>" + NL + "\t\t\t\t<artifactId>tycho-p2-director-plugin</artifactId>" + NL + "\t\t\t\t<version>${tycho-version}</version>" + NL + "\t\t\t\t<executions> " + NL + "\t\t\t\t\t<execution>" + NL + "\t\t\t\t\t\t<id>build-distributions</id>" + NL + "\t\t\t\t\t\t<goals>" + NL + "\t\t\t\t\t\t\t<!-- install the product using the p2 director -->" + NL + "\t\t\t\t\t\t\t<goal>materialize-products</goal>" + NL + "\t\t\t\t\t\t\t<!-- create zip file with the installed product -->" + NL + "\t\t\t\t\t\t\t<goal>archive-products</goal>" + NL + "\t\t\t\t\t\t</goals>" + NL + "\t\t\t\t\t</execution>" + NL + "\t\t\t\t</executions>" + NL + "\t\t\t\t<configuration>" + NL + "\t\t\t\t\t<products>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t<product>" + NL + "\t\t\t\t\t\t\t<id>";
  protected final String TEXT_10 = "</id>" + NL + "\t\t\t\t\t\t</product>" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t</products>" + NL + "\t\t\t\t\t<!-- global optional parameters (with default values) -->" + NL + "\t\t\t\t\t<installFeatures>true</installFeatures>" + NL + "\t\t\t\t\t<profile>DefaultProfile</profile>" + NL + "\t\t\t\t</configuration>" + NL + "\t\t\t</plugin>" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_12 = "\t\t\t" + NL + "\t\t\t<plugin>" + NL + "\t\t\t\t<artifactId>maven-resources-plugin</artifactId>" + NL + "\t\t\t\t<version>3.0.1</version>" + NL + "\t\t\t\t<executions>" + NL + "\t\t\t\t\t<execution>" + NL + "\t\t\t\t\t\t<id>copy-resources</id>" + NL + "\t\t\t\t\t\t<!-- here the phase you need -->" + NL + "\t\t\t\t\t\t<phase>package</phase>" + NL + "\t\t\t\t\t\t<goals>" + NL + "\t\t\t\t\t\t\t<goal>copy-resources</goal>" + NL + "\t\t\t\t\t\t</goals>" + NL + "\t\t\t\t\t\t<configuration>" + NL + "\t\t\t\t\t\t\t<outputDirectory>${basedir}/target/products/";
  protected final String TEXT_13 = "/linux/gtk</outputDirectory>" + NL + "\t\t\t\t\t\t\t<resources>" + NL + "\t\t\t\t\t\t\t\t<resource>" + NL + "\t\t\t\t\t\t\t\t\t<directory>.</directory>" + NL + "\t\t\t\t\t\t\t\t\t<include>Dockerfile</include>" + NL + "\t\t\t\t\t\t\t\t\t<filtering>false</filtering>" + NL + "\t\t\t\t\t\t\t\t</resource>" + NL + "\t\t\t\t\t\t\t</resources>" + NL + "\t\t\t\t\t\t</configuration>" + NL + "\t\t\t\t\t</execution>" + NL + "\t\t\t\t</executions>" + NL + "\t\t\t</plugin>" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_15 = "\t\t\t" + NL + "\t\t</plugins>" + NL + "\t</build>" + NL + "</project>";

public String generate(org.nasdanika.workspace.wizard.AbstractWorkspaceWizard wizard) throws Exception
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
     if (!wizard.getProductsToMaterialize().isEmpty()) { 
    stringBuffer.append(TEXT_8);
     for (String productId: wizard.getProductsToMaterialize()) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(productId);
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
     for (String productId: wizard.getProductsToMaterialize()) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(productId);
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}