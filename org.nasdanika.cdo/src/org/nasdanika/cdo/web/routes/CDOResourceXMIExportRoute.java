package org.nasdanika.cdo.web.routes;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOResourceXMIExportRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
	
		if (RequestMethod.GET.equals(context.getMethod())) {
			if (!context.authorize(context.getTarget(), "read", null, null)) {
				return Action.FORBIDDEN;
			}
			
			CDOResource target = (CDOResource) context.getTarget();
			StringBuilder nameBuilder = new StringBuilder(target.getName());
			nameBuilder.append("-");
			nameBuilder.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
			String name = URLEncoder.encode(nameBuilder.toString().replace('/', '-'), context.getCharacterEncoding());
			
			HttpServletResponse response = ((HttpContext) context).getResponse();
			response.setContentType("text/xml");
			response.setHeader("Content-Disposition", "attachment; filename="+name+".xml");
			try (ServletOutputStream out = response.getOutputStream()) {
				target.save(out, null);
			}

			return Action.NOP;
		}
		
		return Action.NOT_FOUND;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
