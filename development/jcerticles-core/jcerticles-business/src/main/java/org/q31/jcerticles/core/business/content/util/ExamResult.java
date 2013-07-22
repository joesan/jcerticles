/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.content.util;

import org.q31.jcerticles.domain.content.Question;

import java.io.Serializable;
import java.util.List;

/**
 * TODO... Write javadoc...
 * @author jothi
 * @since  1.6
 */
public class ExamResult implements Serializable {

	/* The unique serial version identifier */
	private static final long serialVersionUID = 1L;
	
	/* The score earned by the exam taker */
	private int yourScore;
	
	/* The passing score for an exam */
	private int passScore;
	
	/* Pass or fail in the exam */
	private boolean isPass;

    /* The QuestionBank that contains the user answered answers */
    private List < Question > questionBank;

    public List < Question > getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(List < Question > questionBank) {
        this.questionBank = questionBank;
    }

    /**
	 * @return the yourScore
	 */
	public int getYourScore() {
		return yourScore;
	}

	/**
	 * @param yourScore the yourScore to set
	 */
	public void setYourScore(int yourScore) {
		this.yourScore = yourScore;
	}

	/**
	 * @return the passScore
	 */
	public int getPassScore() {
		return passScore;
	}

	/**
	 * @param passScore the passScore to set
	 */
	public void setPassScore(int passScore) {
		this.passScore = passScore;
	}

	/**
	 * @return the isPass
	 */
	public boolean isPass() {
		return isPass;
	}

	/**
	 * @param isPass the isPass to set
	 */
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}		
}