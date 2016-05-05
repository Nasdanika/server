package org.nasdanika.cdo.web.doc.extensions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nasdanika.cdo.web.doc.DocRoute;
import org.nasdanika.cdo.web.doc.MarkdownPreProcessor;
import org.nasdanika.cdo.web.doc.WikiLinkProcessor.Resolver;
import org.nasdanika.core.CoreUtil;

public class IncludeMarkdownPreProcessor implements MarkdownPreProcessor {

	public static class RegionImpl implements Region {

		private final String content;
		private int start;
		private int end;

		public RegionImpl(String content, int start, int end) {
			this.content = content.substring("{{include>".length(), content.length()-"}}".length());
			this.start = start;
			this.end = end;
		}

		@Override
		public int getStart() {
			return start;
		}

		@Override
		public int getEnd() {
			return end;
		}

		@Override
		public String process(URL baseURL, String urlPrefix, Chain chain, DocRoute docRoute) {
			if (content == null || content.trim().length()==0) {
				return null;
			}
						
			int idx = content.indexOf(':');
			String theContent = content;
			if (idx!=-1) {
				Resolver resolver = docRoute.getResolverRegistry(baseURL, urlPrefix).getResolver(content.substring(0, idx));
				if (resolver!=null) {
					String href = resolver.resolve(content.substring(idx+1));
					if (href!=null) {
						theContent = href;
					}
				}
			}
						
			try {
				URL contentURL = new URL(baseURL, theContent);
				String contentURLStr = contentURL.toString();
				String absDocRoutePath = urlPrefix+docRoute.getDocRoutePath();
				String contentToInclude = CoreUtil.stringify(contentURLStr.startsWith(absDocRoutePath) ? docRoute.getContent(null, contentURL, urlPrefix, contentURLStr.substring(absDocRoutePath.length())) : contentURL);
				return contentToInclude==null ? null : chain.process(contentToInclude);
			} catch (MalformedURLException e) {
				return "(Include exception: "+e+")";
			}
		}
		
	}

	private static final Pattern PATTERN = Pattern.compile("\\{\\{include\\>(.+?)\\}\\}");
	
	@Override
	public List<Region> match(String content) {
		Matcher matcher = PATTERN.matcher(content);
		List<Region> ret = new ArrayList<Region>();
		while (matcher.find()) {
			ret.add(new RegionImpl(matcher.group(), matcher.start(), matcher.end()));
		}
		return ret;
	}

}
