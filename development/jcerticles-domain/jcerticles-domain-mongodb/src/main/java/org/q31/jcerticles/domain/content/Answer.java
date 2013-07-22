/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.domain.content;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Id;

import java.io.Serializable;

/**
 * Represents an Answer
 * @author Jothi
 * @since 1.6
 */
@Embedded
public class Answer extends Content implements Serializable, Comparable < Answer > {
	
	/**
	 * The unique serial version identifier
	 */
	private static final long serialVersionUID = 3909533174199874105L;

	/* The unique Answer identifier */
	private long answerId;
	
	/* The question to which this answer belongs */
	private Question question;
	
	/* The answer text */
	private String answerText;
	
	/* Tells if this question is active */
	private char correctAnswer;
	
	/* If this answer is correct, gives the reason as to why it is correct */
	private String answerDescription;
	
	/* Checks if the Answer is selected by the user */
	private boolean isAnswerSelectedByUser;
	
	/**
	 * @return the isAnswerSelectedByUser
	 */
	public boolean getIsAnswerSelectedByUser() {
		return isAnswerSelectedByUser;
	}

	/**
	 * @param isAnswerSelectedByUser the isAnswerSelectedByUser to set
	 */
	public void setIsAnswerSelectedByUser(boolean isAnswerSelectedByUser) {
		this.isAnswerSelectedByUser = isAnswerSelectedByUser;
	}

	/**
	 * @return the answerId
	 */
	public long getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the questionId
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the questionId to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answerText
	 */
	public String getAnswerText() {
		return answerText;
	}

	/**
	 * @param answerText the answerText to set
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	/**
	 * @return the active
	 */
	public boolean getCorrectAnswer() {
		return this.correctAnswer == 'Y' ? true : false;
	}

	/**
	 * @param correctAnswer the active to set
	 */
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer == true ? 'Y' : 'N';
	}
	
	/**
	 * @return the answerDescription
	 */
	public String getAnswerDescription() {
		return answerDescription;
	}

	/**
	 * @param answerDescription the answerDescription to set
	 */
	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}

	public int compareTo(Answer o) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public String toString() {
        return "Answer{" +
                "answerId='" + answerId + '\'' +
                ", question=" + question +
                ", answerText='" + answerText + '\'' +
                ", correctAnswer=" + correctAnswer +
                ", answerDescription='" + answerDescription + '\'' +
                ", isAnswerSelectedByUser=" + isAnswerSelectedByUser +
                '}';
    }
}
