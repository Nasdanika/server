package org.nasdanika.cdo.web.routes;

public class CDOViewSessionRenderer
{
  protected static String nl;
  public static synchronized CDOViewSessionRenderer create(String lineSeparator)
  {
    nl = lineSeparator;
    CDOViewSessionRenderer result = new CDOViewSessionRenderer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "define({" + NL + "" + NL + "\ta: ";
  protected final String TEXT_2 = NL + NL + "});";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(argument);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
