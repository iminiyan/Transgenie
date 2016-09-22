package com.vedha.tgservice.exception;

public class ViewException extends RuntimeException{

	
	    /** The Constant serialVersionUID. */
	    private static final long serialVersionUID = 5621993860252119284L;

	   
	    /** The message. */
	    private String message;

	    /**
	     * Instantiates a new rest exception.
	     */
	    public ViewException() {

	    }


	    /**
	     * Instantiates a new rest exception.
	     *
	     * @param message the message
	     */
	    public ViewException(String message) {
	        super(message);
	    }

	    /**
	     * Instantiates a new rest exception.
	     *
	     * @param exceptionCode the exception code
	     * @param message the message
	     * @return 
	     */
	    public void ViewException(String message) {
	        
	        this.message = message;
	    }
	    
	   

	    /* (non-Javadoc)
	     * @see java.lang.Throwable#getMessage()
	     */
	    public String getMessage() {
	        return message;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Throwable#toString()
	     */
	    @Override
	    public String toString() {
	        return "ViewException [message=" + message + "]";
	    }

	}


