package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.nasdanika.cdo.web.doc.SearchableContentProvider.ContentEntry;
import org.nasdanika.core.CoreUtil;

public class Indexer {
	
//	private static final String INTERNAL_LINK_PREFIX = "#router/doc-content/";
	private Set<String> processedPaths = new HashSet<>();
	private Set<String> missingPaths = new TreeSet<>();
	private Map<String, List<String>> linkMap = new HashMap<>();
	private IndexWriter indexWriter;
	private SearchableContentProvider searchableContentProvider;
	private String baseURL;

	/**
	 * 
	 * @param searchableContentProvider Provides searchable content.
	 * @param indexWriter Search index writer
	 * @param baseURL Base URL for resolving links in HTML content, e.g. <code>http://localhost:8080/router/doc/</code>
	 * @param internalLinkPrefix
	 */
	public Indexer(
			SearchableContentProvider searchableContentProvider, 
			IndexWriter indexWriter, 
			String baseURL) {
		this.searchableContentProvider = searchableContentProvider;
		this.indexWriter = indexWriter;
		this.baseURL = baseURL;
	}
	
	/**
	 * Override to detect internal links.
	 * @param href
	 * @return
	 */
	protected boolean isInternalLink(String href) {
		return false; //href.startsWith(INTERNAL_LINK_PREFIX);
	}
	
	/**
	 * Override to extract relative path from internal link URL.
	 * @param href
	 * @return
	 */
	protected String internalLinkPath(String href) {
		return null; //href.substring(INTERNAL_LINK_PREFIX.length());
	}
			
	public void index(String path) {
		if (processedPaths.add(path)) {
			ContentEntry indexableContent = searchableContentProvider.get(path);
			if (indexableContent==null) {
				missingPaths.add(path);
			} else {
				String content = indexableContent.getContent();
				if (content == null) {
					System.err.println("[WARNING] No content for "+path);
				} else {
					if (indexableContent.isHTML()) {
						List<String> links = new ArrayList<>();
						Document document = Jsoup.parse(content, baseURL);
						for (Element link: document.body().getElementsByTag("a")) {
							String href = link.absUrl("href");
							if (!CoreUtil.isBlank(href)) {
								if (isInternalLink(href)) {
									// Internal link
									String relativePath = internalLinkPath(href);
									index(relativePath);
									links.add(relativePath);
								}
							}
						}
						if (!links.isEmpty()) {
							linkMap.put(path, links);
						}
						org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
				        doc.add(new Field("path", path, TextField.TYPE_STORED));
				        doc.add(new Field("text", document.body().text(), TextField.TYPE_STORED));
				        try {
							indexWriter.addDocument(doc);
						} catch (IOException e) {
							// TODO proper logging
							e.printStackTrace();
						}
					} else {
						// Plain text
						org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
				        doc.add(new Field("path", path, TextField.TYPE_STORED));
				        doc.add(new Field("text", content, TextField.TYPE_STORED));
				        try {
							indexWriter.addDocument(doc);
						} catch (IOException e) {
							// TODO proper logging
							e.printStackTrace();
						}					
					}
				}
			}
		}
	}
	
	public Set<String> getMissingPaths() {
		return missingPaths;
	}

	public Map<String, List<String>> getLinkMap() {
		return linkMap;
	}
}
