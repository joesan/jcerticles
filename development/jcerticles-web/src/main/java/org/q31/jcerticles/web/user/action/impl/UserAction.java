package org.q31.jcerticles.web.user.action.impl;

import javax.annotation.Resource;

import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.common.exception.Q31RuntimeException;
import org.q31.jcerticles.common.exception.functional.Q31DuplicateUserException;
import org.q31.jcerticles.common.exception.functional.Q31UserValidationException;
import org.q31.jcerticles.facade.user.IUserFacade;
import org.q31.jcerticles.web.common.action.BaseAction;
import org.q31.jcerticles.web.user.action.IUserAction;
import org.q31.jcerticles.web.user.model.UserModel;


/**
 * <p> </p>
 * @author Jothi Shankar Kumar. S
 * Date: Nov 22, 2009
 * Time: 11:25:33 AM
 */
public class UserAction extends BaseAction implements IUserAction {

    /**
	 * The unique serial version identifier
	 */
	private static final long serialVersionUID = 1L;

	/** The UserModel object */
    private UserModel userModel;
    
    /* The UserFacade reference */
    @Resource(name = "userFacade")
    private IUserFacade userFacade;

    /**
     * Prepare the data transfer object
     * @throws Exception
     */    
    public void prepare() throws Exception {
        if (userModel == null) {
            userModel = new UserModel();
        }
    }

    /**
     * <p> Get hold of the UserModel </p>
     * @return userModel
     */
    public Object getModel() {
        return userModel;
    }

    public String execute() {
    	UserDetails userDetails = new UserDetails();
    	userDetails.setFirstName("Jothi Shankar Kumar");
    	userDetails.setLastName("Sankarraj");
    	userDetails.setEmail("jothi@jothi.com");
    	userDetails.setMobile("0177123656");
    	
    	/* Call the Facade */
    	userFacade.saveUserDetails(userDetails);
        return SUCCESS;
    }

    public String getModeratorsList() {
        return SUCCESS;
    }

    public String contactUs() {
        return SUCCESS;
    }
    
    public void setUserFacade() {
    	this.userFacade = userFacade;
    }
    
    public IUserFacade getUserFacade() {
    	return this.userFacade;
    }
    
    private boolean validateCaptcha() {
    	final boolean isCaptchaValid = false; //JCaptchaValidator.validate();
        if (!isCaptchaValid) {
            //addFieldError(PluginConstants.J_CAPTCHA_RESPONSE, getValidationErrorMessage());
        }
        return isCaptchaValid;
    }
    
    /**
     * Returns the error message text to be displayed if captcha validation fails.
     * <p>
     * Developers may override this method to provide custom messages.
     * 
     * @return error message to be displayed if captcha validation fails.
     */
    protected String getValidationErrorMessage() {
        return "Entered string does not match with image";
    }    


	public String registerNewUser() {
		try {
	    	/* First check if the captcha is valid. Only then proceed with service call */
	    	if (!this.validateCaptcha()) {
	    		return INPUT;    		    		
	    	}
		}
		catch (Exception csex) {
			/* LOG the exception */
			
			return INPUT;			
		}
    	
		
		LOG.info("In the action class...");
		try {
			LOG.info("In the action class...UserDetails is " + userModel.getUserDetails());
			final UserDetails userDetails = userFacade.createNewUserAndNotify(userModel.getUserDetails());
		} 
		catch (Q31DuplicateUserException duex) {
			/* Log the exception */
			
			return ERROR;
		} 
		catch (Q31UserValidationException uvesx) {
			/* Log the exception */
			
			return ERROR;
		}
		catch (Q31RuntimeException rex) {
			// TODO... Throw a different error String
			
			return ERROR;
			
		}
		return SUCCESS;
	}

}
