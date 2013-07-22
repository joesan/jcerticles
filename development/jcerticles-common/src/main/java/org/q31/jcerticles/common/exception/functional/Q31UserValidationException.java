package org.q31.jcerticles.common.exception.functional;

import java.util.List;

import org.q31.jcerticles.common.exception.Q31BaseException;

public class Q31UserValidationException extends Q31BaseException {
	
	//private List<ValidationError> validationErrorList;

	public Q31UserValidationException(String message) {
		super(message);
	}
	
	public Q31UserValidationException(String message, List<String> validationErrorList) {
		this(message);
		//this.validationErrorList = validationErrorList;
	}

}
