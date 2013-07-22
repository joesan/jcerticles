/*
 * ====================================================================
 * Copyright (c) 2009-2010 Quintilis31 Private Limited, Chennai, India
 * All rights reserved
 * ====================================================================
 */
package org.q31.jcerticles.common.exception;

/**
 * TODO write javadoc...
 */
public class Q31RuntimeException extends RuntimeException {
	
	public Q31RuntimeException(final String msg, final Throwable ex) {
		super(msg, ex);		
	}
	
	public Q31RuntimeException(final String msg) {
		super(msg);
	}
}
