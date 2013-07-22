/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index.writer.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.q31.jcerticles.search.exception.Q31IndexWriterException;
import org.q31.jcerticles.search.index.writer.Q31IndexWriter;

/**
 * IndexWriter specific to index HTML file types.
 * @author jothi
 * @since  1.6
 */
public final class HTMLIndexWriter extends Q31IndexWriter {
	
	/**
	 * Default constructor
	 */
	protected HTMLIndexWriter() throws IOException {
		init();
	    File index = new File(luceneProp.getProperty(""));		
		Directory dir = FSDirectory.open(index);
		indexWriter = new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_30), true, IndexWriter.MaxFieldLength.UNLIMITED);
	}
	
	/**
	 * 
	 * @param docsDir
	 * @throws IOException 
	 * @throws Exception
	 */
	public void startIndexing(final String docsDir) throws Q31IndexWriterException {
		try {
			File f = new File(docsDir);
			
		    if (f.isDirectory()) {			          // if a directory
		        String[] files = f.list();	          // list its files
		        Arrays.sort(files);			              // sort the files
		        for (int i = 0; i < files.length; i++)	  // recursively index them
		          indexFile(new File(f, files[i]));
		    }
		    else {
		    	indexFile(f);
		    }
		}
		catch (IOException iox) {
			
		}
		finally {
			try {
				finishIndexing();				
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				/* We do not want to get blocked by this shit */
				
			}
		}
	}
	
	@Override
	public void addToIndex() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void refreshIndex() {
		// TODO Auto-generated method stub		
	}
}