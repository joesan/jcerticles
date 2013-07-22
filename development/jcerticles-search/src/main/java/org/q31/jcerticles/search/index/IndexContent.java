/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @author JCerticles
 * TODO... Add LOG4J....
 */
public final class IndexContent {
	
	private static final String FILE_TYPE_HTML = "html";
	
	private IndexWriter writer;
	
	public IndexContent(final String indexDir) throws IOException {
	    File index = new File(indexDir);		
		Directory dir = FSDirectory.open(index);
		writer = new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_30), true, IndexWriter.MaxFieldLength.UNLIMITED);
	}
	
	public void finishIndexing() throws IOException {
		System.out.println("Total Number of documents indexed is " + writer.numDocs());
		writer.close();
	}	
	
	private static class HTMLFileFilter implements FileFilter {
		@Override
		public boolean accept(final File path) {
			return path.getName().toLowerCase().endsWith(FILE_TYPE_HTML);
		}		
	}
	
	public void startIndexing(String docsDir) throws Exception {
		File f = new File(docsDir);
		
	    if (f.isDirectory()) {			          // if a directory
	        String[] files = f.list();	          // list its files
	        Arrays.sort(files);			              // sort the files
	        for (int i = 0; i < files.length; i++)	  // recursively index them
	          indexFile(new File(f, files[i]), new HTMLFileFilter());
	    }
	    else {
	    	indexFile(f, new HTMLFileFilter());
	    }
	}
	
	private void indexFile(File f, FileFilter filter) throws Exception {
		System.out.println("Indexing " + f.getCanonicalPath());
		
		if (!f.isHidden() && f.exists() &&	f.canRead() &&	(filter == null || filter.accept(f))) {
			Document doc = getDocument(f);
			writer.addDocument(doc);
			System.out.println("Successfully Indexed " + f.getCanonicalPath());
		}		
	}
	
	private Document getDocument(File f) throws Exception {
		return ContentExtractor.getExtractedDocument(f);
	}
	
	public static void main(String [] args) throws Exception {
		IndexContent content = new IndexContent("/opt/lucene/index");
		try {
			content.startIndexing("/opt/apache-tomcat-6.0.24/webapps/Quintilis31Web/articles");
		}
		finally {
			content.finishIndexing();
		}		
	}
}
