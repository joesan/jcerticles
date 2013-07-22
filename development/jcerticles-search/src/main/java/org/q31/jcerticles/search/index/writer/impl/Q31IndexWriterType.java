/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index.writer.impl;

import org.q31.jcerticles.search.index.writer.Q31IndexWriter;


/**
 * TODO... Write javadoc...
 * @author jothi
 * @since  1.6
 */
public enum Q31IndexWriterType {	
	
	/* Represents an HTML Index Writer instance */
	HTML(HTMLIndexWriter.class);
	
	/* Represents the IndexWriter instance */
    final Class<? extends Q31IndexWriter> indexWriter;

    /* Set the IndexWriter type */
    Q31IndexWriterType (Class<? extends Q31IndexWriter> indexWriter) {
        this.indexWriter = indexWriter;
    }	
	
    /**
     * Factory method to get the IndexWriter instance based on the
     * IndexWriterType
     * @param typ The type for which a writer is needed
     * @return    An IndexWriter instance
     */
    static Q31IndexWriter getIndexWriterInstance(Q31IndexWriterType typ) {
    	Q31IndexWriter writer = null;
    	try {
    		writer = typ.indexWriter.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return writer;
    }
}