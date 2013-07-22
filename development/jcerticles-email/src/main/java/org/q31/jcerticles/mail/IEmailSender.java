package org.q31.jcerticles.mail;

import org.q31.jcerticles.common.domain.user.UserDetails;


public interface IEmailSender {
	
	void sendEmail(final UserDetails user);

}
