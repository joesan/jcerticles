/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.content.service.impl;

import org.q31.jcerticles.core.business.content.service.ISearchContentService;
import org.q31.jcerticles.search.index.writer.Q31IndexWriter;
import org.q31.jcerticles.search.index.writer.impl.Q31IndexWriterCache;
import org.q31.jcerticles.search.index.writer.impl.Q31IndexWriterType;

/**
 * TODO... Javadoc...
 * @author jothi
 * @since  1.6
 */
public class SearchContentServiceImpl implements ISearchContentService {

	@Override
	public int checkIndexStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startIndexingAsynchronous(final FileType fileType) {
		// Read all the properties where the files to be indexed are present
		// Create a new thread and give it the job to index files
		final Q31IndexWriter indexWriter = Q31IndexWriterCache.getIndexWriter(getQ31IndexWriterType(fileType));
		//indexWriter.startIndexing
	}

	@Override
	public void updateIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discardIndex() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get the appropriate Q31IndexWriterType based on the FileType
	 * passed.
	 * @return
	 */
	private Q31IndexWriterType getQ31IndexWriterType(final FileType fileType) {
		switch (fileType) {
		case HTML : return Q31IndexWriterType.HTML;
		default : return null;		
		}
	}
}