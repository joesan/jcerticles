/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import org.q31.jcerticles.domain.content.ContentSearchResultsVO;

/**
 * TODO... Write javadoc...
 * @author Jothi
 * @since  1.6
 */
public final class SearchContent {	
	
	private static final Logger LOG = Logger.getLogger(SearchContent.class);
	
	private static final int SEARCH_LIMIT = 25;
	
	/**
	 * 
	 * @param searchQuery
	 * @param skipRecords
	 * @param takeRecords
	 * @return
	 */
	public static List < ContentSearchResultsVO > searchContent(final String searchQuery, final int skipRecords, final int takeRecords) {
		final List < ContentSearchResultsVO > fileList = new ArrayList < ContentSearchResultsVO > ();		
		
		IndexReader reader = null;
		IndexSearcher searcher = null;
        try {
        	/* only searching, so read-only=true */
            reader = IndexReader.open(FSDirectory.open(new File("/opt/lucene/index")), true);
            searcher = new IndexSearcher(reader);
            
            /* parse the searchQuery */
            QueryParser qp = new QueryParser(Version.LUCENE_30, "contents", new StandardAnalyzer(Version.LUCENE_30));
            Query query = qp.parse(searchQuery);   
            
            TopDocs hits = searcher.search(query, null, SEARCH_LIMIT);
            final int totalHits = hits.totalHits;
            
            /* page the results */
            hits = searcher.search(query, null, skipRecords + takeRecords);
            ScoreDoc[] scoreDocs = hits.scoreDocs;
            
            for (int i = skipRecords; i < hits.totalHits; i++) {
                 if (i > (skipRecords + takeRecords) - 1) {
                      break;
                 }
             	Document doc = searcher.doc(scoreDocs[i].doc);
            	LOG.info("Printing the Search Results **************");
                //LOG.info("The document summary is ***** = " + doc.get("summary"));
                LOG.info("The document path is ***** = " + doc.get("path"));
                LOG.info("The document filename is ***** = " + doc.get("filename"));
                LOG.info("The document title is ***** = " + doc.get("title"));
                ContentSearchResultsVO obj = new ContentSearchResultsVO();
                obj.setFilePath(extractFilePath(doc.get("path")));
                obj.setFileSummary(doc.get("summary"));
                obj.setFileTitle(doc.get("title"));
                obj.setTotalHits(totalHits);
                fileList.add(obj);                 

            }            
//            for (ScoreDoc scoreDoc : hits.scoreDocs) {
//            	Document doc = searcher.doc(scoreDoc.doc);
//            	LOG.info("Printing the Search Results **************");
//                //LOG.info("The document summary is ***** = " + doc.get("summary"));
//                LOG.info("The document path is ***** = " + doc.get("path"));
//                LOG.info("The document filename is ***** = " + doc.get("filename"));
//                LOG.info("The document title is ***** = " + doc.get("title"));
//                ContentSearchResultsVO obj = new ContentSearchResultsVO();
//                obj.setFilePath(extractFilePath(doc.get("path")));
//                obj.setFileSummary(doc.get("summary"));
//                obj.setFileTitle(doc.get("title"));
//                fileList.add(obj);
//            }
        } 
        catch (Exception ee) {
            LOG.error("Exception Occurred during search", ee);
        }
        finally {
        	try {
				searcher.close();
			} 
        	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return fileList;
		
	}
	
	/**
	 * 
	 * @param originalPath
	 * @return
	 */
	private static String extractFilePath(String originalPath) {
		
		final String rootPath = "http://localhost:1979/";
		String actualPath = null;
		// /opt/apache-tomcat-6.0.24/webapps/Quintilis31Web/articles/test3.html
		
		final String contextPath = originalPath.substring(originalPath.indexOf("Quintilis31Web"));
		
		actualPath = rootPath + contextPath;
		
		return actualPath;
		
	}
	
	public static void main (String args[]) {
		System.out.println(extractFilePath("/opt/apache-tomcat-6.0.24/webapps/Quintilis31Web/articles/test3.html"));
	}
}