package org.q31.jcerticles.common.exception;

/**
 *
 */
public class Q31BaseException extends Exception {
	
	public Q31BaseException(final String message, final Throwable ex) {
		super(message, ex);
	}
	
	public Q31BaseException(final String message) {
		super(message);
	}
}