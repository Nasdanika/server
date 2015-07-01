package org.nasdanika.cdo.web.routes;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;

public class EObjectXMIExportRoute implements Route {

	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
	
		if (RequestMethod.GET.equals(context.getMethod())) {
			if (!context.authorize(context.getTarget(), "read", null, null)) {
				return Action.FORBIDDEN;
			}
			
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			EObject target = (EObject) context.getTarget();
			StringBuilder nameBuilder = new StringBuilder(target.eClass().getName());
			if (target.eResource()!=null) {
				String fragment = target.eResource().getURIFragment(target);
				if (fragment!=null) {
					nameBuilder.append("-").append(fragment);
				}
			}
			nameBuilder.append("-");
			nameBuilder.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
			String name = URLEncoder.encode(nameBuilder.toString().replace('/', '-'), context.getCharacterEncoding());
			
			URI sourceURI = URI.createFileURI(File.createTempFile(name+"-export-", ".xml").getAbsolutePath());
			Resource resource = resourceSet.createResource(sourceURI);
			resource.getContents().add(EcoreUtil.copy(target));	
			HttpServletResponse response = ((HttpServletRequestContext) context).getResponse();
			response.setContentType("text/xml");
			response.setHeader("Content-Disposition", "attachment; filename="+name+".xml");
			resource.save(response.getOutputStream(), null);

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
