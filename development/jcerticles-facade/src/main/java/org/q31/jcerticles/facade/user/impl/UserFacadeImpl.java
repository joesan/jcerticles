/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.facade.user.impl;

//imports for the referenced files
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.common.exception.functional.Q31DuplicateUserException;
import org.q31.jcerticles.common.exception.functional.Q31UserValidationException;
import org.q31.jcerticles.core.business.user.service.IUserService;
import org.q31.jcerticles.facade.user.IUserFacade;

/**
 * 
 * @author jothi
 * @since  1.6
 */
public final class UserFacadeImpl implements IUserFacade {

    /** The Logger reference for this class. */
    private static final Logger LOG = Logger.getLogger(UserFacadeImpl.class);

  /**
     *  This is a bean initialization callback.
     * @see applicationContext-core.xml
     */
    public void init() {
        LOG.debug("Initializing UserFacadeImpl...");
        LOG.debug("The UserService reference obtained is " + userService);
    }

  /**
     *  This is a bean initialization callback.
     * @see applicationContext-core.xml
     */
    public void cleanUp() {
        LOG.debug("Cleaning Up UserFacadeImpl...");
        userService = null;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Resource(name = "userService")
    private IUserService userService;

    /**
     * {@inheritDoc}
     */
    public boolean saveUserDetails(final UserDetails userDetails) {
        return userService.saveUserDetails(userDetails);
    }

    /**
     * {@inheritDoc}
     */
	public UserDetails createNewUserAndNotify(UserDetails userDetails)
			throws Q31DuplicateUserException, Q31UserValidationException {
		return userService.createNewUserAndNotify(userDetails);
	}
}