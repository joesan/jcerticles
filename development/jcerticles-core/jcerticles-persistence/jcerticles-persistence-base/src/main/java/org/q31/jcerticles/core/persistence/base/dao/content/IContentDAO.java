/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.persistence.base.dao.content;

import java.util.List;

import org.q31.jcerticles.domain.content.*;

/**
 * TODO... Write Javadoc...
 * @author Jothi
 * @since  1.6
 */
public interface IContentDAO {

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
    List < SubTechnology > getAllSubTechnologiesForTechnology(final long technologyId);

    /**
     *
     * @param subTechnologyId
     * @return
     */
    List < Exam > getAllExamsForSubTechnology(final long subTechnologyId);
	
    /**
     * Fetch all the Exams for a given technology
     * @param technologyId
     * @return
     */
	List < Exam > getAllExamsForTechnology(final long technologyId);

    /**
     * Fetch all the Questions for a given technology and sub technology Id
     * @param examId
     * @param technologyId
     * @return
     */
    List < Question > getAllQuestionsForExamAndTechnology(final long examId, final long technologyId);
	
    /**
     * Fetch all the Questions for a given technology and sub technology Id
     * @param examId
     * @return
     */
	List < Question > getAllQuestionsForExam(final long examId);
	
	/**
	 * Fetch all the Answers for a given questionIdgetAllExamsForTechnology
	 * @param questionId
	 * @return
	 */
	List < Answer > getAllAnswersForQuestionId(final String questionId);

    /**
     *
     * @return
     */
    Question getQuestionForQuestionId(final String questionId);
	
	/**
	 * Fetch the passing score for a given examId
	 * @param examId
	 * @return
	 */
	int getPassScoreForExamId(final long examId);
}