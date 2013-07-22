/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index.writer;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.q31.jcerticles.search.exception.Q31IndexWriterException;
import org.q31.util.PropertyFileReader;

/**
 * The base implementation for all Q31IndexWriterType. An index writer
 * is obtained based on the type of document that needs to be indexed.
 * @author jothi
 * @since  1.6
 */
public abstract class Q31IndexWriter {
	
	/* Lucene Property file */
	public static final String LUCENE_PROPERTIES = "lucene.properties";
	
	public IndexWriter indexWriter;
	
	public Properties luceneProp;
	
	/**
	 * Initialization routine
	 */
	protected void init() {
		// Use the property-file-reader util project and read the index location
		try {
			luceneProp = PropertyFileReader.getAsProperties(LUCENE_PROPERTIES);
		} catch (IOException e) {
			// TODO Signal the caller that the property file does not exist and indexing cannot happen
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param f
	 * @throws IOException 
	 * @throws Exception
	 */
	protected void indexFile(final File f) throws Q31IndexWriterException, IOException {
		System.out.println("Indexing " + f.getCanonicalPath());
		
		if (!f.isHidden() && f.exists() &&	f.canRead()) {
			Document doc = getDocument(f);
			indexWriter.addDocument(doc);
			System.out.println("Successfully Indexed " + f.getCanonicalPath());
		}		
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	protected Document getDocument(File f) throws Q31IndexWriterException {
		//return ContentExtractor.getExtractedDocument(f);
		return null;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void finishIndexing() throws IOException {
		System.out.println("Total Number of documents indexed is " + indexWriter.numDocs());
		indexWriter.close();
	}	
	
	/**
	 * 
	 * @param writer
	 */
	public void setWriter(IndexWriter writer) {
		this.indexWriter = writer;		
	} 
	
	/**
	 * 
	 */
	public abstract void addToIndex();
	
	/**
	 * Start the indexing process of all the documents
	 * located in the docsDir directory location.
	 * TODO... Handle IOException and send a response code back
	 * @param docsDir
	 * @throws
	 */
	public abstract void startIndexing(final String docsDir) throws Q31IndexWriterException, IOException;
	
	/**
	 * 
	 */
	public abstract void refreshIndex();
}