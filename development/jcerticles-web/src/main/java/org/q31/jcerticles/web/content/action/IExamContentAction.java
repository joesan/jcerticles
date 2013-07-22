/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.web.content.action;

/**
 * TODO... Write javadoc
 * @author jothi
 * @since  1.6
 */
public interface IExamContentAction {
	
	/**
	 * Fetch all the exams for a given technologyId
	 * @return
	 */
	public String getAllExamsForTechnology();	
	
	/**
	 * TODO... Write javadoc
	 * @return
	 */
	public String getExamQuestion();
	
	/**
	 * Fetch the next Question along with answers for the
	 * given technologyId
	 * @param  technologyId
	 * @param  testId
	 * @return
	 */
	public String getNextQuestion();
	
	/**
	 * 
	 * @return
	 */
	public String getAllQuestionsForExam();
	
	/**
	 * 
	 * @return
	 */
	public String startExam();	
	
	/**
	 * 
	 * @return
	 */
	public String finishAndEvaluateExam();

}
