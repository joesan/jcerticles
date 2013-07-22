package org.q31.jcerticles.common.exception.functional;

import org.q31.jcerticles.common.exception.Q31BaseException;

public class Q31CreateNewUserExcepion extends Q31BaseException {
	
	public Q31CreateNewUserExcepion(final String message, final Throwable ex) {
		super(message, ex);
	}
	
	public Q31CreateNewUserExcepion(final String message) {
		super(message);
	}
	
	

}