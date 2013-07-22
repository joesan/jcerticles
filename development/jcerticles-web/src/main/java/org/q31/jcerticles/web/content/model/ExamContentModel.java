/**
 * 
 */
package org.q31.jcerticles.web.content.model;

import java.util.List;

import org.q31.jcerticles.domain.content.Exam;

/**
 * @author jothi
 * @since 1.6
 */
public class ExamContentModel extends ContentModel {
	
	private String myName;
	
	private String hiddenTab;
	
	private long technologyId;
	
	private String examId;
	
	private long subTechnologyId;
	
	private long currentQuestionId;
	
	private List < Exam > allExamsForTechnology;
		
	/**
	 * @return the examId
	 */
	public String getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

	public List<Exam> getAllExamsForTechnology() {
		return allExamsForTechnology;
	}

	public void setAllExamsForTechnology(List<Exam> allExamsForTechnology) {
		this.allExamsForTechnology = allExamsForTechnology;
	}

	/**
	 * @return the attr
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * @param attr the attr to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * @return the hiddenTab
	 */
	public String getHiddenTab() {
		return hiddenTab;
	}

	/**
	 * @param hiddenTab the hiddenTab to set
	 */
	public void setHiddenTab(String hiddenTab) {
		this.hiddenTab = hiddenTab;
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

	/**
	 * @return the currentQuestionId
	 */
	public long getCurrentQuestionId() {
		return currentQuestionId;
	}

	/**
	 * @param currentQuestionId the currentQuestionId to set
	 */
	public void setCurrentQuestionId(long currentQuestionId) {
		this.currentQuestionId = currentQuestionId;
	}	
}