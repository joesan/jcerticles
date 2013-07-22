/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 */
package org.q31.jcerticles.common.exception.technical;

import org.q31.jcerticles.common.exception.Q31BaseException;

/**
 * TODO Javadoc...
 * @author jothi
 * @since  1.6
 */
public class Q31PersistenceException extends Q31BaseException {

	/* Serialization ID */
	private static final long serialVersionUID = 1L;

	/* Contruct Q31PersistenceException with the exception message */
	public Q31PersistenceException(String message) {
		super(message);
	}

}
