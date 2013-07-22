/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 */
package org.q31.jcerticles.core.business.content.service.impl;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.q31.jcerticles.core.persistence.mongodb.MongoUtil;
import org.q31.jcerticles.core.persistence.mongodb.dao.content.impl.ContentDAOImpl;
import org.q31.jcerticles.domain.content.*;
import org.q31.jcerticles.core.business.content.service.IContentService;
import org.q31.jcerticles.core.business.content.util.ExamObject;
import org.q31.jcerticles.core.business.content.util.ExamResult;
import org.q31.jcerticles.core.persistence.base.dao.content.IContentDAO;
import org.q31.jcerticles.search.SearchContent;
import org.q31.util.CodeFormatter;

/**
 * All Content related business logic implementations are concentrated here.
 * The following are some of the Content types:
 * (1) Exam Content
 * (2) Searchable Article Content
 * (3) Blog Content
 * 
 * @author Jothi
 * @since  1.6
 */
public final class ContentServiceImpl implements IContentService {

	//@Resource(name="contentDAO")
	//private IContentDAO contentDAO;

	/**
	 * {@inheritDoc}
	 */
	public List < ContentSearchResultsVO > getFileSearchResultList(String searchQuery, final int skipRecords, final int takeRecords) {		 
		return SearchContent.searchContent(searchQuery, skipRecords, takeRecords);
	}

    /**
     * @param technologyId
     * @param subTechnologyId
     * @return
     */
    public Content getRandomQuestion(long technologyId, long subTechnologyId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * {@inheritDoc}
     */
    public Content getRandomQuestion(final long technologyId) {
        return null; //PersistenceFactory.getContentDAO().getRandomQuestion(technologyId);
    }

    /**
     * {@inheritDoc}
     */
    public List < SubTechnology > getAllSubTechnologiesForTechnology(long technologyId) {
        return MongoUtil.getContentDAO(SubTechnology.class).getAllSubTechnologiesForTechnology(technologyId);
    }

    /**
     * {@inheritDoc}
     */
    public List < Exam > getAllExamsForSubTechnology(long subTechnologyId) {
        return MongoUtil.getContentDAO(Exam.class).getAllExamsForSubTechnology(subTechnologyId);
    }

    public List < Exam > getAllExamsForTechnology(long technologyId) {
        return MongoUtil.getContentDAO(Exam.class).getAllExamsForTechnology(technologyId);
    }

    /**
	 * {@inheritDoc}
	 */
	private List < Question > getAllQuestionsForExam(final long examId) {
		return MongoUtil.getContentDAO(Question.class).getAllQuestionsForExam(examId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ExamObject startExam(final Long examId) {
		ExamObject examObject = ExamObject.getInstance();

        /* Fetch all the questions for the examId and initialize an ExamObject */
		List < Question > questionBank = this.getAllQuestionsForExam(examId);
        examObject.setQuestionBank(questionBank);

		return examObject;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Question getQuestionForQuestionId(final String questionId) {
		return MongoUtil.getContentDAO(Question.class).getQuestionForQuestionId(questionId);
	}	
	
	/**
	 * {@inheritDoc}
	 */
/*	public ExamObject updateExamObjectwithNextQuestion(final ExamObject exam, final List < Long > answers, final long mappedQuestionId) {

		*//* Get the actual questionId *//*
		final long actualQuestionId = exam.getAllQuestionIds().get(mappedQuestionId);
		exam.setMappedQuestionId(mappedQuestionId);

		*//* Update the question with the answers *//*
		exam.getAnsweredQuestionsWithAnswers().put(actualQuestionId, answers);

		*//**
		 * If the currentQuestionId exists in the unansweredQuestionMap, remove it.
		 * Do this only if the user has answered.
		 *//*
		if (answers != null && answers.size() > 0) {
			if (exam.getUnansweredQuestionIdMap().containsKey(actualQuestionId)) {
				exam.getUnansweredQuestionIdMap().remove(actualQuestionId);
			}
			*//* Set the selected by the user in the Answer objects isAnswerSelectedByUser *//*
			for (Map.Entry < Question, List < Answer > > entry : exam.getQuestionBank().entrySet()) {
				Question ques = entry.getKey();
				if (ques.getQuestionId() == "") {
					List < Answer > ans = entry.getValue();
					for (Answer answer : ans) {
						if (answers.contains(answer.getAnswerId())) {
							answer.setIsAnswerSelectedByUser(true);
						}
					}
				}
			}
		}*/
/*
		*//* Fetch the next question and answer and set the ExamObject accordingly *//*
		if (exam.getUnansweredQuestionIdMap().size() > 0) {
			final Long nextQuestionId = exam.getUnansweredQuestionIdMap().get(mappedQuestionId+1);
			for (Map.Entry < Question, List < Answer > > entry : exam.getQuestionBank().entrySet()) {
			    Question ques = entry.getKey();
			    if (ques.getQuestionId() == "") {
			    	List < Answer > ans = entry.getValue();
			    	*//* If not, fetch it from the database *//*
			    	if (ans == null) {
			    		ans = this.getAllAnswersForQuestionId("");
			    		exam.getQuestionBank().put(ques, ans);
			    	}
		    		*//* update the ExamObject for the current question and answer *//*
					exam.setCurrentQuestion(ques);
					exam.setCurrentAnswers(ans);
			    }
			}
		}
		else {
			*//* Indicate end of exam *//*
			exam.setEndOfExam(true);
		}

		return exam;
	}*/

	/**
	 * {@inheritDoc}
	 */
/*	public ExamObject updateExamObjectForQuestionId(final ExamObject exam, final long mappedQuestionId) {

		*//* Get the actual questionId *//*
		final long actualQuestionId = exam.getAllQuestionIds().get(mappedQuestionId);
		exam.setMappedQuestionId(mappedQuestionId);

		*//* Check in the ExamObject if this selectedQuestionId is already answered *//*
		if (exam.getAnsweredQuestionsWithAnswers().containsKey(actualQuestionId)) {
			*//* Set the flag in ExamObject for UI manipulation *//*
			exam.setCurrentQuestionAnswered(true);
		}
		else {
			*//* Set the flag in ExamObject for UI manipulation *//*
			exam.setCurrentQuestionAnswered(false);
		}

		*//* Check if we have already fetched the Answer for this questionId *//*
		for (Map.Entry < Question, List < Answer > > entry : exam.getQuestionBank().entrySet()) {
		    Question ques = entry.getKey();
		    if (ques.getQuestionId() == "") {
		    	List < Answer > ans = entry.getValue();
		    	*//* If not, fetch it from the database *//*
		    	if (ans == null) {
		    		ans = this.getAllAnswersForQuestionId("");
		    		exam.getQuestionBank().put(ques, ans);
		    	}
		    	*//* update the ExamObject for the current question and answer *//*
				exam.setCurrentQuestion(ques);
				exam.setCurrentAnswers(ans);
		    }
		}

		return exam;
	}*/
	
	/**
	 * {@inheritDoc}
	 */
	public ExamObject finishAndEvaluateExam(final ExamObject exam) {
		// TODO...Transfer the following data to the QuestionBank for showing a detailed report to the user
		// isAnswered, Answers entered by user for the question,
		
//		// Logic for showing exam review...
//		SortedMap < Long, Long > unansweredQuestionsMap = null; //new SortedMap < Long, Long >();
//		Map < String, List < Long > > answeredQuestionsMap = exam.getAnsweredQuestionsWithAnswers();
//
//		for (Map.Entry < Question, List < Answer > > entry : exam.getQuestionBank().entrySet()) {
//		    Question ques = entry.getKey();
//
//		    if(!unansweredQuestionsMap.containsKey(ques.getQuestionId())) {
//		    	ques.setIsAnswered(true);
//		    	ques.setAnswersGivenByUser(exam.getAnsweredQuestionsWithAnswers().get(ques.getQuestionId()));
//		    }
//		}
//
//		// TODO... Evaluation for exam
//		ExamResult examResult = new ExamResult();
//		examResult.setPass(hasUserPassedTheExam(answeredQuestionsMap, exam.getAllQuestionIds().size(), getPassScoreForExamId(0L)));
		
		return exam;		
	}
	
	/**
	 * 
	 * @return
	 */
	private final boolean hasUserPassedTheExam(Map < String, List < Long > > answeredQuestionsMap, int totalQuestions, int examPassScore) {
		return false;
	}
	
	/**
	 * Fetch the passing score for the given examId
	 * @return
	 */
	private final int getPassScoreForExamId(final long examId) {
		/* Call the respective DAO and fetch the pass score for the exam */
		//return contentDAO.getPassScoreForExamId(examId);
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map < Long, String > getAllAvailableTechnologies() {
		return null;
	}
}