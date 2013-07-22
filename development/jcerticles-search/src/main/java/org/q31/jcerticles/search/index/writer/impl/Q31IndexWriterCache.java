/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index.writer.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.q31.jcerticles.search.index.writer.Q31IndexWriter;

/**
 * TODO... Javadoc...
 * @author jothi
 * @since  1.6
 */
public final class Q31IndexWriterCache {
	
	/* Thread safe cache containing all Q31IndexWriterTypes */
	private static final Map < Q31IndexWriterType, Q31IndexWriter > indexWriterCache = new ConcurrentHashMap < Q31IndexWriterType, Q31IndexWriter > ();
		
	/* No instantiation from outside */
	private Q31IndexWriterCache() {}
	
	/**
	 * Fetch an IndexWriter for the given IndexWriterType. The fetched
	 * IndexWriter is then cached and later calls for the IndexWriter is
	 * thus returned from the cache.
	 * @param indexWriterType
	 * @return
	 */
	public static Q31IndexWriter getIndexWriter(final Q31IndexWriterType indexWriterType) {
		if (indexWriterCache.containsKey(indexWriterType)) {
			System.out.println("In if...");
			return indexWriterCache.get(indexWriterType);								
		}
		else {
			Q31IndexWriter indexWriter = Q31IndexWriterType.getIndexWriterInstance(indexWriterType);
			indexWriterCache.put(indexWriterType, indexWriter);
			System.out.println("In else...");
			return indexWriter; 				
		}			
	}
}