/**
 * 
 */
package org.q31.jcerticles.domain.content;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

import java.util.Date;

/**
 * Represents a Technology. For example.,
 * Java, JPA, JDBC etc.,
 * @author Jothi
 * @since 1.6
 */
@Entity
public class Technology extends Content implements java.io.Serializable, Comparable < Technology > {
	
	/* Uniquely identifies this technology */
	@Id @Property ("_id")
    private long technologyId;
	
	/* The name of the technology. For example., Java*/
	private String technology;

    private String technologyDescription;
	
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
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the type to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
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

    public String getTechnologyDescription() {
        return technologyDescription;
    }

    public void setTechnologyDescription(String technologyDescription) {
        this.technologyDescription = technologyDescription;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "technologyId=" + technologyId +
                ", technologyName='" + technology + '\'' +
                ", technologyDescription='" + technologyDescription + '\'' +
                ", version='" + version + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int compareTo(Technology technology) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
