package org.nasdanika.cdo.web.doc.extensions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.felix.scr.Component;
import org.apache.felix.scr.ScrService;
import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;
import org.pegdown.LinkRenderer.Rendering;

public class ComponentInfoResolver implements WikiLinkResolver, Renderer {
	
	// Hack to get to the spec and docRoutePath
	private static ThreadLocal<String> specTL = new ThreadLocal<>();
	private static ThreadLocal<String> docRoutePathTL = new ThreadLocal<>();

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
		ScrService scrService = docRoute.getScrService();
		if (scrService == null) {
			return null;
		}
		
		String[] sa = spec.split("/");
		if (sa.length != 2 && sa.length != 3) {
			return null;
		}
		
		String bundleSymbolicName = sa[0];
		Version version = sa.length == 2 ? null : new Version(sa[1]);
		List<Bundle> availableBundles = new ArrayList<>();		
		for (Bundle bundle: docRoute.getBundleContext().getBundles()) {
			if (bundleSymbolicName.equals(bundle.getSymbolicName())) {
				availableBundles.add(bundle);
			}
		}
		if (availableBundles.isEmpty()) {
			return null;
		}
		Collections.sort(availableBundles, new Comparator<Bundle>() {

			@Override
			public int compare(Bundle o1, Bundle o2) {
				return o2.getVersion().compareTo(o1.getVersion());
			}
			
		});
		
		Bundle matchedBundle;
		if (version == null) {
			// Latest version
			matchedBundle = availableBundles.get(0);
		} else {
			// Lowest lesser version
			matchedBundle = availableBundles.get(availableBundles.size()-1);
			for (Bundle availableBundle: availableBundles) {
				if (availableBundle.getVersion().compareTo(version) <= 0) {
					matchedBundle = availableBundle;
					break;
				}
			}
		}
		
		Component[] components = scrService.getComponents(matchedBundle);
		if (components == null) {
			return null;
		}
		
		String componentName = sa[sa.length == 2 ?  1 : 2];
		for (Component component: components) {
			if (component.getName().equals(componentName)) {
				specTL.set(spec);
				docRoutePathTL.set(docRoutePath);
				return docRoutePath+DocRoute.COMPONENT_INFO_PATH+component.getId()+"/index.html";				
			}
		}

		return null;
	}

	@Override
	public Rendering render(String href, String content, String config, boolean isMissing) {
		String spec = specTL.get();
		String docRoutePath = docRoutePathTL.get();
		StringBuilder renderingContent = new StringBuilder();
		if (spec != null && docRoutePath != null) {
			renderingContent
				.append("<img src='")
				.append(docRoutePath)
				.append("/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/cog.png'/> ");
			
			String[] sa = spec.split("/");
			if (sa.length == 2) {
				renderingContent.append(sa[1]+" ("+sa[0]+")");
			} else if (sa.length ==3) {
				renderingContent.append(sa[2]+" ("+sa[0]+")");
			} else {
				renderingContent.append(content);
			}
		} else {
			renderingContent.append(content);
		}
		Rendering ret = new Rendering(href, renderingContent.toString());
		if (isMissing) {
			ret.withAttribute("style", "color:red;border-bottom:1px dashed");
		}
		specTL.set(null);
		docRoutePathTL.set(null);
		return ret;
	}

}
