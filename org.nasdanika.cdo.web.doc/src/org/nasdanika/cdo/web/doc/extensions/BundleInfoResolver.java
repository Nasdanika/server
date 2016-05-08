package org.nasdanika.cdo.web.doc.extensions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.WikiLinkResolver;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Renderer;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;
import org.pegdown.LinkRenderer.Rendering;

public class BundleInfoResolver implements WikiLinkResolver, Renderer {
	
	// Hack to get to the spec and docRoutePath
	private static ThreadLocal<String> specTL = new ThreadLocal<>();
	private static ThreadLocal<String> docRoutePathTL = new ThreadLocal<>();

	@Override
	public String resolve(String spec, String docRoutePath, Map<Object, Object> environment) {
		int slashIdx = spec.indexOf("/");
		String bundleSymbolicName = slashIdx == -1 ? spec : spec.substring(0, slashIdx);
		Version version = slashIdx == -1 ? null : new Version(spec.substring(slashIdx+1));
		List<Bundle> availableBundles = new ArrayList<>();		
		DocRoute docRoute = (DocRoute) environment.get(DocRoute.class);
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
				return o1.getVersion().compareTo(o2.getVersion());
			}
		});
		
		Bundle matchedBundle;
		if (version == null) {
			// Latest version
			matchedBundle = availableBundles.get(availableBundles.size()-1);
		} else {
			// Lowest lesser version
			matchedBundle = availableBundles.get(0);
			Collections.reverse(availableBundles);
			for (Bundle availableBundle: availableBundles) {
				if (availableBundle.getVersion().compareTo(version) <= 0) {
					matchedBundle = availableBundle;
					break;
				}
			}
		}
		
		specTL.set(spec);
		docRoutePathTL.set(docRoutePath);
		return docRoutePath+DocRoute.BUNDLE_INFO_PATH+matchedBundle.getBundleId()+"/index.html";
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
				.append("/bundle/org.nasdanika.icons/fatcow-hosting-icons/FatCow_Icons16x16/box_closed.png'/> ");
			
			int slashIdx = spec.indexOf("/");
			if (slashIdx == -1) {
				renderingContent.append(spec);
			} else {
				renderingContent.append(spec.substring(0, slashIdx));
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
