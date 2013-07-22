/**
 * 
 */
package org.q31.jcerticles.domain.content;

/**
 * @author jothi
 *
 */
public class Exam {
	
	private long examId;
	
	private String examTitle;
	
	private String examDescription;
	
	private int totalQuestions;
	
	private long technologyId;
	
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
	 * @return the examTitle
	 */
	public String getExamTitle() {
		return examTitle;
	}

	/**
	 * @param examTitle the examTitle to set
	 */
	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public String getExamDescription() {
		return examDescription;
	}

	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
}
