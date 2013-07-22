/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.content.service;

import java.util.List;

import org.q31.jcerticles.domain.content.*;
import org.q31.jcerticles.core.business.content.IContentServices;
import org.q31.jcerticles.core.business.content.util.ExamObject;

/**
 * TODO... Write Javadoc...
 * @author Jothi
 * @since  1.6
 */
public interface IContentService extends IContentServices {
	
	/**
	 * 
	 * @param searchQuery
	 * @param skipRecords
	 * @param takeRecords
	 * @return
	 */
	List < ContentSearchResultsVO > getFileSearchResultList(final String searchQuery, final int skipRecords, final int takeRecords);
	
	/**
	 * 
	 * @param technologyId
     * @param subTechnologyId
	 * @return
	 */
	Content getRandomQuestion(final long technologyId, final long subTechnologyId);

    /**
     *
     * @param technologyId
     * @return
     */
    List <SubTechnology > getAllSubTechnologiesForTechnology(final long technologyId);

    /**
     *
     * @param subTechnologyId
     * @return
     */
    List < Exam > getAllExamsForSubTechnology(final long subTechnologyId);

    /**
     *
     * @param technologyId
     * @return
     */
    List < Exam > getAllExamsForTechnology(final long technologyId);
	
	/**
	 * 
	 * @param examId
	 * @return
	 */
	ExamObject startExam(final Long examId);

    /**
     *
     * @param examObject
     * @return
     */
    ExamObject finishAndEvaluateExam(final ExamObject examObject);
}