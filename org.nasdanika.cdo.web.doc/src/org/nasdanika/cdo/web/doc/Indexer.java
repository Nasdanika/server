package org.nasdanika.cdo.web.doc;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.nasdanika.cdo.web.doc.SearchableContentProvider.ContentEntry;
import org.nasdanika.core.CoreUtil;

public class Indexer {
	
	private Set<String> processedPaths = new HashSet<>();
	private Set<String> missingPaths = new HashSet<>();
	private IndexWriter indexWriter;
	private SearchableContentProvider searchableContentProvider;
	private String baseURL;
	private String internalLinkPrefix;

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
			String baseURL,
			String internalLinkPrefix) {
		this.searchableContentProvider = searchableContentProvider;
		this.indexWriter = indexWriter;
		this.baseURL = baseURL;
		this.internalLinkPrefix = internalLinkPrefix;
	}
			
	public void index(String path) {
		if (processedPaths.add(path)) {
			ContentEntry indexableContent = searchableContentProvider.get(path);
			if (indexableContent==null) {
				missingPaths.add(path);
			} else {
				if (indexableContent.isHTML()) {
					Document document = Jsoup.parse(indexableContent.getContent(), baseURL);
					StringBuilder internalLinks = new StringBuilder();
					for (Element link: document.body().getElementsByTag("a")) {
						String href = link.absUrl("href");
						if (!CoreUtil.isBlank(href)) {
							if (href.startsWith(internalLinkPrefix)) {
								// Internal link
								String relativePath = href.substring(internalLinkPrefix.length());
								index(relativePath);
								internalLinks.append(relativePath).append(System.lineSeparator());
							}
						}
					}
					org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
			        doc.add(new Field("path", path, TextField.TYPE_STORED));
			        doc.add(new Field("html", indexableContent.getContent(), TextField.TYPE_STORED));
			        doc.add(new Field("text", document.body().text(), TextField.TYPE_STORED));
			        doc.add(new Field("internalLinks", internalLinks.toString(), TextField.TYPE_STORED));
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
			        doc.add(new Field("text", indexableContent.getContent(), TextField.TYPE_STORED));
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
	
	public Set<String> getMissingPaths() {
		return missingPaths;
	}

}
