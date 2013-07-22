package org.q31.jcerticles.core.business.util.notification;

import org.q31.jcerticles.common.domain.user.UserDetails;

public interface IUserNotification {
	
	void notifyNewUser(final UserDetails userDetails);

}
