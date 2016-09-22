package com.vedha.tgservice.exception;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ApplicationException extends Exception{

	/** Resource bundle file name. */
	private static final String RESOURCE_BUNDLE = "errorMessages";
	
	
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	/** Exception code. */
	private String exceptionCode = null;
	
	/** Exception context. */
	private String exceptionContext = null;

	public void setExceptionCode(final String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	private String exceptionSource;

	public void setExceptionContext(final String exceptionContext) {
		this.exceptionContext = exceptionContext;
	}

	public ApplicationException(final Throwable cause) {
		super();
		this.initCause(cause);
		logger.error(cause.getMessage(), cause);
		
	}
	
	public ApplicationException(final String exceptionCode, final String exceptionContext) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionContext = exceptionContext;
	}

	
	public ApplicationException(final String exceptionCode, final String exceptionContext, final Throwable cause) {
		this(exceptionCode, exceptionContext);

		this.initCause(cause);
		
		logger.error(cause.getMessage(), cause);
		
	}

	
	public String getExceptionCode() {
		return this.exceptionCode;
	}

	
	public String getExceptionContext() {
		return this.exceptionContext;
	}
	
	
	@Override
	public String getMessage() {
		return exceptionContext == null ? String.format("[%1$s]", exceptionCode) : String.format("[%1$s] %2$s",
				exceptionCode, exceptionContext);
	}
	
	@Override
	public String getLocalizedMessage() {
		
		String retMsg = "";
		
		if (getMessageByCode().length() == 0) {
			
			retMsg = exceptionContext == null ? String.format("%1$s", getMessageByCode()) : String.format("%1$s",
					exceptionContext);
			
		} else {
			
			retMsg = exceptionContext == null ? String.format("%1$s", getMessageByCode()) : String.format("[%1$s], %2$s",
					exceptionCode, getMessageByCode());
			
		}
		
		return retMsg;
	}
	
	private String getMessageByCode() {
		String rst = null;

		try {
			
			rst = ResourceBundle.getBundle(RESOURCE_BUNDLE, Locale.US).getString(exceptionCode);
			
		} catch (MissingResourceException e) {
			
			rst = exceptionCode;
			
		}
		
		return rst;
	}
	
	public String getExceptionSource() {
		return exceptionSource;
	}
	public void setExceptionSource(String exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

}
