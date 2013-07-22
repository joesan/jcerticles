/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.web.content.action.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.q31.jcerticles.domain.content.ContentSearchResultsVO;
import org.q31.jcerticles.web.content.action.IArticleContentAction;
import org.q31.jcerticles.web.content.model.ArticleContentModel;
import org.q31.jcerticles.web.content.model.ContentModel;

/**
 * TODO... Write javadoc
 * @author jothi
 * @since  1.6
 */
public class ArticleContentAction extends ContentAction implements IArticleContentAction {
	
	/* The unique serial version identifier */
	private static final long serialVersionUID = 1L;

	/* The Logger instance */
	private static final Logger LOG = Logger.getLogger(ArticleContentAction.class);
	
	/* The model to be instantiated for all Content related actions */
	private ContentModel articleContentModel;
	
	@Override
	public Object getModel() {
		return articleContentModel;
	}

	@Override
	public void prepare() throws Exception {
        if (articleContentModel == null) {
        	articleContentModel = new ArticleContentModel();
        }		
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	

	public String getLatestArticles() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String getFileSearchResultList() {
		LOG.info("search query obtained is *** " + articleContentModel.getSearchQuery());
		LOG.info("Take Records obtained is *** " + articleContentModel.getTakeRecords());
		LOG.info("Skip Records obtained is *** " + articleContentModel.getSkipRecords());
		List < ContentSearchResultsVO > fileList = contentFacade.getFileSearchResultList(articleContentModel.getSearchQuery(), 
				articleContentModel.getSkipRecords(), articleContentModel.getTakeRecords());
		
		/* If nothing is found in the search result, set nothing is found */
		if (fileList.size() == 0) {
			articleContentModel.setSearchResultFlag(0);
		}
		else {LOG.info("Getting total search hits ******************** " + fileList.get(0).getTotalHits());
			articleContentModel.setTotalSearchHits(getPaginationDisplayRange(fileList.get(0).getTotalHits()));
		}
		
		/* Let us set the search query back */
		articleContentModel.setSearchQuery(articleContentModel.getSearchQuery());		
		articleContentModel.setFileList(fileList);		
		return SUCCESS;
	}
	
	private int getPaginationDisplayRange(final int totalHitCount) {

		if (totalHitCount <= 5) {
			return 1;			
		}
		else if (totalHitCount <= 10) {
			return 2;			
		}
		else if (totalHitCount <= 15) {
			return 3;
		}
		else if (totalHitCount <= 20) {
			return 4;
		}
		else {
			return 5;
		}		
	}	

}
