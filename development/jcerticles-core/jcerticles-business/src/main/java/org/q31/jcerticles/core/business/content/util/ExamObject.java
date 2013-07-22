/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.content.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.q31.jcerticles.domain.content.Answer;
import org.q31.jcerticles.domain.content.Question;

/**
 * TODO... Write javadoc...
 * @author jothi
 * @since  1.6
 */
public class ExamObject implements Serializable {

    /* The Map that holds the String QuestionId and a Long mappingId for all UnAnswered Questions */
    private SortedMap < String, Long > unAnsweredQuestionIdMap;

    /* The Map that holds the String QuestionId and a Long mappingId that will be used as display in the UI */
    private SortedMap < String, Long > allQuestionIdMap;

    /* The current Question that will be displayed to the user */
    private Question currentQuestion;

    /* The current List of Answers that belongs to the Question */
    private List < Answer > currentAnswers;

    /* Contains all the Questions and Answers for this examId or for this ExamObject */
    private List < Question > questionBank;

    /* The current Long mappingId that will be used for navigating to the next question by the server */
    private Long currentQuestionIdForNavigation;

    /* This flag tells if this is the end of the exam or not */
    private boolean isEndOfExam;

    private int passScore;

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public SortedMap < String, Long > getAllQuestionIdMap() {
        return allQuestionIdMap;
    }

    public void setAllQuestionIdMap(SortedMap < String, Long > allQuestionIdMap) {
        this.allQuestionIdMap = allQuestionIdMap;
    }

    public boolean getIsEndOfExam() {
        return isEndOfExam;
    }

    public void setEndOfExam(boolean endOfExam) {
        isEndOfExam = endOfExam;
    }

    public SortedMap < String, Long > getUnAnsweredQuestionIdMap() {
        return unAnsweredQuestionIdMap;
    }

    public void setUnAnsweredQuestionIdMap(SortedMap < String, Long > unAnsweredQuestionIdMap) {
        this.unAnsweredQuestionIdMap = unAnsweredQuestionIdMap;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List < Answer > getCurrentAnswers() {
        return currentAnswers;
    }

    public void setCurrentAnswers(List < Answer > currentAnswers) {
        this.currentAnswers = currentAnswers;
    }

    public List < Question > getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(List < Question > questionBank) {
        this.questionBank = questionBank;
    }

    public Long getCurrentQuestionIdForNavigation() {
        return currentQuestionIdForNavigation;
    }

    public void setCurrentQuestionIdForNavigation(Long currentQuestionIdForNavigation) {
        this.currentQuestionIdForNavigation = currentQuestionIdForNavigation;
    }

    public ExamObject() {}

    /**
     * Fetch a new instance... TODO.. Later do some
     * basic initialization stuff... like create date, time
     * for logging purposes...
     * @return
     */
	public static ExamObject getInstance() {
		return new ExamObject();
	}

    @Override
    public String toString() {
        return "ExamObject{" +
                "unAnsweredQuestionIdMap=" + unAnsweredQuestionIdMap +
                ", allQuestionIdMap=" + allQuestionIdMap +
                ", currentQuestion=" + currentQuestion +
                ", currentAnswers=" + currentAnswers +
                ", questionBank=" + questionBank +
                ", currentQuestionIdForNavigation=" + currentQuestionIdForNavigation +
                ", isEndOfExam=" + isEndOfExam +
                '}';
    }
/*
     *//* Initialize an ExamObject through the getInstance method *//*
	public ExamObject() {}

	*//* The unique serial version identifier *//*
	private static final long serialVersionUID = 1L;

	*//* All the questions for a given Exam *//*
	private SortedMap < Question, List < Answer > > questionBank;

	*//* The List of all the questions answered by the user *//*
	private Map < String, List < Long > > answeredQuestionsWithAnswers;

	*//* The current question that is being shown to the user *//*
	private Question currentQuestion;

	*//* The Answers for the current question *//*
	private List < Answer > currentAnswers;

	*//* Flag to tell if the current question is already answered by the user *//*
	private boolean isCurrentQuestionAnswered;

	*//* Flag to indicate that the user has scrolled through all the questions *//*
	private boolean isEndOfExam;

	*//* Map to hold the questionId's of all the unanswered questions *//*
	private SortedMap < String, Long > unansweredQuestionIdMap;

	*//* Map to hold all the questionId's *//*
	private SortedMap < String, Long > allQuestionIds;

	*//* The current mapped questionId for navigation *//*
	private Long mappedQuestionId;

	*//* The ExamResult *//*
	private ExamResult examResult;

    *//* Contains all Questions and Answers *//*
    List < Question > allQuestions;

    public List < Question > getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(List < Question > allQuestions) {
        this.allQuestions = allQuestions;
    }

    *//**
	 * @return the examResult
	 *//*
	public ExamResult getExamResult() {
		return examResult;
	}

	*//**
	 * @param examResult the examResult to set
	 *//*
	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
	}

	*//**
	 * @return the mappedQuestionId
	 *//*
	public Long getMappedQuestionId() {
		return mappedQuestionId;
	}

	*//**
	 * @param mappedQuestionId the mappedQuestionId to set
	 *//*
	public void setMappedQuestionId(Long mappedQuestionId) {
		this.mappedQuestionId = mappedQuestionId;
	}

	*//**
	 * @return the allQuestionIds
	 *//*
	public SortedMap < String, Long > getAllQuestionIds() {
		return allQuestionIds;
	}

	*//**
	 * @param allQuestionIds the allQuestionIds to set
	 *//*
	public void setAllQuestionIds(SortedMap < String, Long > allQuestionIds) {
		this.allQuestionIds = allQuestionIds;
	}

	*//**
	 * @return the unansweredQuestionIdMap
	 *//*
	public SortedMap < String, Long > getUnansweredQuestionIdMap() {
		return unansweredQuestionIdMap;
	}

	*//**
	 * @param unansweredQuestionIdMap the unansweredQuestionIdMap to set
	 *//*
	public void setUnansweredQuestionIdMap(
			SortedMap < String, Long > unansweredQuestionIdMap) {
		this.unansweredQuestionIdMap = unansweredQuestionIdMap;
	}

	*//**
	 * @return the isEndOfExam
	 *//*
	public boolean isEndOfExam() {
		return isEndOfExam;
	}

	*//**
	 * @param isEndOfExam the isEndOfExam to set
	 *//*
	public void setEndOfExam(boolean isEndOfExam) {
		this.isEndOfExam = isEndOfExam;
	}

	*//**
	 * @return the isCurrentQuestionAnswered
	 *//*
	public boolean isCurrentQuestionAnswered() {
		return isCurrentQuestionAnswered;
	}

	*//**
	 * @param isCurrentQuestionAnswered the isCurrentQuestionAnswered to set
	 *//*
	public void setCurrentQuestionAnswered(boolean isCurrentQuestionAnswered) {
		this.isCurrentQuestionAnswered = isCurrentQuestionAnswered;
	}

	*//**
	 * @return the currentQuestion
	 *//*
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	*//**
	 * @param currentQuestion the currentQuestion to set
	 *//*
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	*//**
	 * @return the currentAnswers
	 *//*
	public List<Answer> getCurrentAnswers() {
		return currentAnswers;
	}

	*//**
	 * @param currentAnswers the currentAnswers to set
	 *//*
	public void setCurrentAnswers(List < Answer > currentAnswers) {
		this.currentAnswers = currentAnswers;
	}

	*//**
	 * @return the questionBank
	 *//*
	public SortedMap < Question, List < Answer > > getQuestionBank() {
		return questionBank;
	}

	*//**
	 * @param questionBank the questionBank to set
	 *//*
	public void setQuestionBank(SortedMap < Question, List < Answer > > questionBank) {
		this.questionBank = questionBank;
	}

	*//**
	 * @return the answeredQuestionsWithAnswers
	 *//*
	public Map < String, List < Long > > getAnsweredQuestionsWithAnswers() {
		return answeredQuestionsWithAnswers;
	}

	*//**
	 * @param answeredQuestionsWithAnswers the answeredQuestionsWithAnswers to set
	 *//*
	public void setAnsweredQuestionsWithAnswers(
			Map < String, List < Long > > answeredQuestionsWithAnswers) {
		this.answeredQuestionsWithAnswers = answeredQuestionsWithAnswers;
	}

	*//**
	 * Fetch a new instance... TODO.. Later do some
	 * basic initialization stuff... like create date, time
	 * for logging purposes...
	 * @return
	 *//*
	public static ExamObject getInstance() {
		return new ExamObject();
	}

    @Override
    public String toString() {
        return "ExamObject{" +
                "questionBank=" + questionBank +
                ", answeredQuestionsWithAnswers=" + answeredQuestionsWithAnswers +
                ", currentQuestion=" + currentQuestion +
                ", currentAnswers=" + currentAnswers +
                ", isCurrentQuestionAnswered=" + isCurrentQuestionAnswered +
                ", isEndOfExam=" + isEndOfExam +
                ", unansweredQuestionIdMap=" + unansweredQuestionIdMap +
                ", allQuestionIds=" + allQuestionIds +
                ", mappedQuestionId=" + mappedQuestionId +
                ", examResult=" + examResult +
                '}';
    }*/
}