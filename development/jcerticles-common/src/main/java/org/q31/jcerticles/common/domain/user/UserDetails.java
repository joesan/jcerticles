package org.q31.jcerticles.common.domain.user;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * TODO write javadoc...
 * User: Harshini
 * Date: 08.11.2009
 * Time: 22:47:24
 * To change this template use File | Settings | File Templates.
 */
public class UserDetails {

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;
    
    private String gender;
    
    private String occupation;

    private String mobile;

    public String getFirstName() {
        return firstName;
    }    
    
    public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public String toString() {
    	return ReflectionToStringBuilder.toString(this);
    }
}
