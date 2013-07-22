package org.q31.jcerticles.domain.content;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

/**
 * @author jothi
 *
 */
@Entity
public class Exam extends Content implements java.io.Serializable, Comparable < Exam > {

    @Id @Property("_id")
	private long examId;

    @Property("examName")
	private String examName;
	
	private String examDescription;
	
	private int totalQuestions;
	
	private long technologyId;

    private long subTechnologyId;

    public long getSubTechnologyId() {
        return subTechnologyId;
    }

    public void setSubTechnologyId(long subTechnologyId) {
        this.subTechnologyId = subTechnologyId;
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
	 * @return the examTitle
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * @param examName the examTitle to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
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

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName ='" + examName + '\'' +
                ", examDescription='" + examDescription + '\'' +
                ", totalQuestions=" + totalQuestions +
                ", technologyId=" + technologyId +
                '}';
    }

    public int compareTo(Exam exam) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
