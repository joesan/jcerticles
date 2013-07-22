/**
 * 
 */
package org.q31.jcerticles.common.domain.content;

import java.util.Date;

/**
 * Represents a Technology. For example.,
 * Java, JPA, JDBC etc.,
 * @author Jothi
 * @since 1.6
 */
public class Technology {
	
	/* Uniquely identifies this technology */
	private long technologyId;
	
	/* The name of the technology. For example., Java*/
	private String technologyName;
	
	/* The technology version. For example., 1.6 */
	private String version;
	
	/* The date on which it is added to the database */
	private Date createDate;
	
	/* The date on which it is updated */
	private Date updateDate;

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
	 * @return the type
	 */
	public String getTechnologyName() {
		return technologyName;
	}

	/**
	 * @param type the type to set
	 */
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
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
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}	
}