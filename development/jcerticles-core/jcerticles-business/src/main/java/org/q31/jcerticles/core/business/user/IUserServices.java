package org.q31.jcerticles.core.business.user;

import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.common.exception.Q31RuntimeException;
import org.q31.jcerticles.common.exception.functional.Q31DuplicateUserException;
import org.q31.jcerticles.common.exception.functional.Q31UserValidationException;


/**
 * TODO write javadoc... 
 */
public interface IUserServices {

    /**
     * This method saves the user details
     * @param userDetails   The User that needs to be saved
     * @return              true if the save was successful, else false
     */
    boolean saveUserDetails(final UserDetails userDetails) throws Q31RuntimeException;
    
    UserDetails createNewUserAndNotify(final UserDetails userDetails) throws Q31DuplicateUserException, Q31UserValidationException;

}