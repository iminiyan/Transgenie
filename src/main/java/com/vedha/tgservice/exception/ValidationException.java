package com.vedha.tgservice.exception;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/** BindingResult. */
	BindingResult bindingResult = null;

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	public ValidationException(final BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}

}
