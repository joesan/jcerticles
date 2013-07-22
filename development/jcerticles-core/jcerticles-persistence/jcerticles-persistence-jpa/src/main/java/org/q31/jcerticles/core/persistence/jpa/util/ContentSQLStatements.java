/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.persistence.jpa.util;

/**
 * TODO... Write javadoc...
 * @author jothi
 * @since  1.6
 */
public final class ContentSQLStatements {
	
	// Named Query Definitions
	
	/* Fetch all questions for given technologyid */
	public static final String GET_ALL_QUESTIONS_FOR_TECHNOLOGY_ID = "content.questions.questionsForTechnologyId";
	
	/* Fetch all Answers for a given questionId */
	public static final String GET_ALL_ANSWERS_FOR_QUESTION_ID = "content.questions.answersForQuestionId";
	
	/* Fetch the pass score for a given examId */
	public static final String GET_PASS_SCORE_FOR_EXAM = "content.exam.passScoreForExamId";
	
	/* Fetch all exams for a given technologyId */
	public static final String GET_ALL_EXAMS_FOR_TECHNOLOGY_ID = "content.exam.examsForTechnologyId";
	
	/* Fetch all Questions for a given examId */
	public static final String GET_ALL_QUESTIONS_FOR_EXAM_ID = "content.questions.questionsForExamId";
}
