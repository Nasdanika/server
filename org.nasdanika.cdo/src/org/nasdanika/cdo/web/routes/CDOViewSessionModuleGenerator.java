package org.nasdanika.cdo.web.routes;

public class CDOViewSessionModuleGenerator
{
  protected static String nl;
  public static synchronized CDOViewSessionModuleGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOViewSessionModuleGenerator result = new CDOViewSessionModuleGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "define({" + NL + "" + NL + "\ta: ";
  protected final String TEXT_2 = NL + "\t" + NL + "\t// TODO - resources and resource folders - promise of resource content (lazy-ref)" + NL + "" + NL + "});";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(argument);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
