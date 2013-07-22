/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.content.service;

import org.q31.jcerticles.core.business.content.IContentServices;

/**
 * TODO... Javadoc...
 * @author jothi
 * @since  1.6
 */
public interface ISearchContentService extends IContentServices {
	
	public enum FileType { HTML, PDF, DOC };
	
	/**
	 * 
	 * @return
	 */
	public int checkIndexStatus();
	
	/**
	 * Index all the files irrespective of the file type.
	 */
	public void startIndexingAsynchronous(final FileType fileType);
	
	/**
	 * 
	 */
	public void updateIndex();
	
	/**
	 * 
	 */
	public void removeFromIndex();
	
	/**
	 * 
	 */
	public void discardIndex();
}
