package org.nasdanika.cdo.web.doc.extensions;

import java.net.URI;
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

		private static final String END_TOKEN = "}}";
		private static final String START_TOKEN = "{{include>";
		private final String content;
		private int start;
		private int end;

		public RegionImpl(String content, int start, int end) {
			this.content = content.substring(START_TOKEN.length(), content.length()-END_TOKEN.length());
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
		public String process(URI baseURI, String urlPrefix, Chain chain, DocRoute docRoute) {
			if (content == null || content.trim().length()==0) {
				return null;
			}
						
			int idx = content.indexOf(':');
			String theContent = content;
			if (idx!=-1) {
				Resolver resolver = docRoute.getResolverRegistry(baseURI, urlPrefix).getResolver(content.substring(0, idx));
				if (resolver!=null) {
					String href = resolver.resolve(content.substring(idx+1));
					if (href!=null) {
						theContent = href;
					}
				}
			}
					
			try {
				URI contentURI = baseURI.resolve(theContent);
				String contentURLStr = contentURI.toString();
				String absDocRoutePath = urlPrefix+docRoute.getDocRoutePath();
				String contentToInclude = CoreUtil.stringify(contentURLStr.startsWith(absDocRoutePath) ? docRoute.getContent(null, contentURI, urlPrefix, contentURLStr.substring(absDocRoutePath.length())) : contentURI);
				return contentToInclude==null ? null : chain.process(contentToInclude);
			} catch (Exception e) {
				System.err.println("Include exception in "+baseURI+": "+e);
				return START_TOKEN+content+END_TOKEN;
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
