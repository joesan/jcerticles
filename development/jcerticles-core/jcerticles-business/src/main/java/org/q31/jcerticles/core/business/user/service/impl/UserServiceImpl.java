/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.core.business.user.service.impl;

import org.apache.log4j.Logger;
import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.common.exception.functional.Q31DuplicateUserException;
import org.q31.jcerticles.common.exception.functional.Q31UserValidationException;
import org.q31.jcerticles.core.business.user.service.IUserService;
import org.q31.jcerticles.core.business.util.notification.IUserNotification;

/**
 * TODO Write javadoc...
 * The rule is all the methods that are called via the IUserServices will throw a Q31untimeException
 * and all those services defined in the IUserService will throw a Q31ServiceException which will
 * in turn be converted or wrapped into a Q31untimeException and given back to the caller to be
 * furthur transmitted to the web layer which actually requested for the service.
 */
public final class UserServiceImpl implements IUserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    
    private IUserNotification userNotificationService;
    
    public void setUserNotificationService(IUserNotification userNotificationService) {
    	this.userNotificationService = userNotificationService;
    }

    /**
     * {@inheritDoc}
     */
    public boolean saveUserDetails(final UserDetails userDetails) {

        LOG.info("Saving UserDetails....");
        LOG.debug("Saving UserDetails....");
        System.out.println("Fuck!!!!");

        /** simply call the persistence layer implementation to save the user */
        //final UserDetails savedUserDetails =   
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    /**
     * {@inheritDoc}
     */    
    public UserDetails createNewUserAndNotify(final UserDetails userDetails) throws Q31DuplicateUserException, Q31UserValidationException {
    	
    	LOG.info("In the servcie..........**************** " + userDetails);
    	
    	/* Validate the fields and throw an exception immediately if any validation fails */
    	this.validateFields(userDetails);
    	
    	/* Check for duplicate user */
    	final boolean isDuplicateUser = this.isDuplicateUser(userDetails.getFirstName(), userDetails.getEmail());    	
    	
    	/* If everything OK, save the new user to the database */
    	if (isDuplicateUser) {
    		/* Throw an exception */
    		// TODO... exception message needs to be changed
    		/* Always LOG just before throwing an exception */
    		LOG.error("SERVICE EXCEPTION OCCURRED");
    		throw new Q31DuplicateUserException("");
    	}
    	else {
    		final UserDetails savedUserDetails = null;//PersistenceFactory.getUserDetailsDAO().saveUserDetails(userDetails);
        	
        	/* Notify the user */
        	userNotificationService.notifyNewUser(savedUserDetails);
        	
        	/* Return the saved User */
        	return savedUserDetails;        	
    	}    	
    }
    
    private void validateFields(final UserDetails userDetails) throws Q31UserValidationException {

    }
    
    /**
     * We do not allow firstname and email combination to be a
     * duplicate.
     */
    private boolean isDuplicateUser(final String firstName, final String email) {
   	
    	/* Check by looking up against the database */
    	final int userCount = 0;//PersistenceFactory.getUserDetailsDAO().findAllUsers(firstName, email);
    	
    	return userCount == 0 ? false : true;
    }
    
    /**
     * {@inheritDoc}
     */     
    public boolean notifyAllUsersForMeetUp() {
    	return false;
    	
    }
}