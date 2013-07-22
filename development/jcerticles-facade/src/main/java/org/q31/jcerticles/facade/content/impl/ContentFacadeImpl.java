/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.facade.content.impl;

import java.util.List;

import javax.annotation.Resource;

import org.q31.jcerticles.domain.content.ContentSearchResultsVO;
import org.q31.jcerticles.domain.content.Exam;
import org.q31.jcerticles.domain.content.Question;
import org.q31.jcerticles.core.business.content.service.IContentService;
import org.q31.jcerticles.core.business.content.util.ExamObject;
import org.q31.jcerticles.domain.content.Content;
import org.q31.jcerticles.domain.content.SubTechnology;
import org.q31.jcerticles.facade.content.IContentFacade;

/**
 * TODO... Write javadoc...
 * @author jothi
 * @since  1.6
 */
public final class ContentFacadeImpl implements IContentFacade {
	
	/**
	 * Set the ContentServiceImpl instance
	 * @param contentService
	 */
    public void setContentService(IContentService contentService) {
        this.contentService = contentService;
    }

    @Resource(name = "contentService")
    private IContentService contentService;


    public List < ContentSearchResultsVO > getFileSearchResultList(String searchQuery, int skipRecords, int takeRecords) {
        return contentService.getFileSearchResultList(searchQuery, skipRecords, takeRecords);
    }

    public Content getRandomQuestion(long technologyId, long subTechnologyId) {
        return contentService.getRandomQuestion(technologyId, subTechnologyId);
    }

    public List < SubTechnology > getAllSubTechnologiesForTechnology(long technologyId) {
        return contentService.getAllSubTechnologiesForTechnology(technologyId);
    }

    public List < Exam > getAllExamsForSubTechnology(long subTechnologyId) {
        return contentService.getAllExamsForSubTechnology(subTechnologyId);
    }

    public List < Exam > getAllExamsForTechnology(long technologyId) {
        return contentService.getAllExamsForTechnology(technologyId);
    }

    public ExamObject startExam(Long examId) {
        return contentService.startExam(examId);
    }

    public ExamObject finishAndEvaluateExam(ExamObject examObject) {
        return contentService.finishAndEvaluateExam(examObject);
    }
}