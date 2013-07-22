/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.domain.content;

import java.util.Date;
import java.util.List;

/**
 * This domain object represents a Question and is mapped
 * to the Question table.
 * @author Jothi
 * @since 1.6
 */
public class Question extends Content implements java.io.Serializable, Comparable<Question> {	
	
	/* The serial version id */
	private static final long serialVersionUID = -8569735226038433642L;

	/* The uuiqueId representing a question */
	private Long questionId;
	
	/* The exam to which this question belongs */
	private long examId;
	
	/* The question text */
	private String questionText;
	
	/* The type of question (Multiple choice or radio button type) */
	private char questionType;
	
	/* Tells if this question is active */
	private char active;
	
	/*
	 * The technology to which this question belongs. 
	 * Not necessarily needed as this information is also
	 * available in the Exam domain object. 
	 */
	private long technologyId;
	
	/* The sub technology to which this Question belongs */
	private long subTechnologyId;
	
	/* The difficulty level of this Question */
	private long difficultyLevel;
	
	/* The create date */
	private Date createDate;
	
	/* The author who created this question */
	private String author;
	
	/*The total number of answers for this question */
	private long answerCount;
	
	/* List of all the answers for this question */
	private List < Answer > answers;
	
	/* User for GUI navigation */
	private long mappedQuestionId;
	
	/* Flag to indicate if this question was answered by the user during a test */
	private boolean isAnswered;
	
	/* Indicates the answers selected for this question by the user */
	private List < Long > answersGivenByUser;
	
	/* Indicates if the answered this question correctly */
	private boolean isAnswerCorrect;
				
	/**
	 * @return the isAnswerCorrect
	 */
	public boolean getIsAnswerCorrect() {
		return isAnswerCorrect;
	}

	/**
	 * @param isAnswerCorrect the isAnswerCorrect to set
	 */
	public void setIsAnswerCorrect(boolean isAnswerCorrect) {
		this.isAnswerCorrect = isAnswerCorrect;
	}

	/**
	 * @return the answersGivenByUser
	 */
	public List < Long > getAnswersGivenByUser() {
		return answersGivenByUser;
	}

	/**
	 * @param answersGivenByUser the answersGivenByUser to set
	 */
	public void setAnswersGivenByUser(List < Long > answersGivenByUser) {
		this.answersGivenByUser = answersGivenByUser;
	}

	/**
	 * @return the isAnswered
	 */
	public boolean getIsAnswered() {
		return isAnswered;
	}

	/**
	 * @param isAnswered the isAnswered to set
	 */
	public void setIsAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	/**
	 * @return the mappedQuestionId
	 */
	public long getMappedQuestionId() {
		return mappedQuestionId;
	}

	/**
	 * @param mappedQuestionId the mappedQuestionId to set
	 */
	public void setMappedQuestionId(long mappedQuestionId) {
		this.mappedQuestionId = mappedQuestionId;
	}

	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the examId
	 */
	public long getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(long examId) {
		this.examId = examId;
	}

	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * @return the questionType
	 */
	public char getQuestionType() {
		return questionType;
	}

	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(char questionType) {
		this.questionType = questionType;
	}
//	/**
//	 * @return the active
//	 */
//	public Character getActive() {
//		return active;
//	}
//
//	/**
//	 * @param active the active to set
//	 */
//	public void setActive(Character active) {
//		this.active = active;
//	}
	
	/**
	 * @return the active
	 */
	public boolean getActive() {
		return active == 'Y' ? true : false;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active == true ? 'Y' : 'N';
	}

	/**
	 * @return the technologyId
	 */
	public long getTechnologyId() {
		return technologyId;
	}

	/**
	 * @param technologyId the technologyId to set
	 */
	public void setTechnologyId(long technologyId) {
		this.technologyId = technologyId;
	}

	/**
	 * @return the difficultyLevel
	 */
	public long getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(long difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the answerCount
	 */
	public long getAnswerCount() {
		return answerCount;
	}

	/**
	 * @param answerCount the answerCount to set
	 */
	public void setAnswerCount(long answerCount) {
		this.answerCount = answerCount;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * @return the subTechnologyId
	 */
	public long getSubTechnologyId() {
		return subTechnologyId;
	}

	/**
	 * @param subTechnologyId the subTechnologyId to set
	 */
	public void setSubTechnologyId(long subTechnologyId) {
		this.subTechnologyId = subTechnologyId;
	}

	public int compareTo(Question o) {
		Long quesId = Long.valueOf(this.questionId);
		Long otherQues = Long.valueOf(o.getQuestionId());
		return quesId.intValue() - otherQues.intValue();
	}	
}
