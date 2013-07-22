package org.q31.jcerticles.core.business.util.notification.impl;

import org.q31.jcerticles.common.domain.user.UserDetails;
import org.q31.jcerticles.core.business.util.notification.IUserNotification;
import org.q31.jcerticles.mail.IEmailSender;

public class UserNotificationImpl implements IUserNotification {
	
	private IEmailSender emailSender;
	
	public void setEmailSender(IEmailSender emailSender) {
		this.emailSender = emailSender;
	}
    
    public void notifyNewUser(final UserDetails userDetails) {
    	emailSender.sendEmail(userDetails);    	
    }	

}
