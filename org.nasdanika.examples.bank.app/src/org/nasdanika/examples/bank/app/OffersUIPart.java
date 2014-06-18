package org.nasdanika.examples.bank.app;

import java.util.Map;

import org.nasdanika.html.Fragment;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.html.UIPart;

public class OffersUIPart implements UIPart<HttpContext, Fragment> {

	@Override
	public  void create(HttpContext context, Fragment out, Map<String, Object> environment) throws Exception {
		out.content(context.getHTMLFactory().alert(Style.SUCCESS, true, "0% APR on balance transfers for 15 months"));
	}

}
