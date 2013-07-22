package org.q31.jcerticles.web.user.model;

import org.q31.jcerticles.common.domain.user.UserDetails;


/**
 * Created by IntelliJ IDEA.
 * @author Jothi Shankar Kumar. S
 * @version 1.0
 *          Date: Mar 21, 2010
 *          Time: 9:49:46 AM CET
 * @since 1.0
 */
public class UserModel {

    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
