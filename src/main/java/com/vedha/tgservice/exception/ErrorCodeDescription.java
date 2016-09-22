package com.vedha.tgservice.exception;


/**
 * The Enum ErrorCodeDescription.
 */
public enum ErrorCodeDescription {
	//Unauthorized access
	/** The unauthorized user. */
	UNAUTHORIZED_USER(1000,"Access Denied"),
	
	/** The password mismatch. */
	PASSWORD_MISMATCH(1001,"Password mismatch"),
	
	/** The login validte. */
	LOGIN_VALIDTE(1002,"Incorrect UserName or Password"),
	//Cusine Exception Error Codes -11XX
	/** The cusine is empty. */
	
	/** sms service is empty */
	ERROR_SERVICE_UNAVAILABLE(5000,"Requested service unavilable. Please try again"),
	
	// invalid parameter error codes - 3XXX
    /** The invalid parameter. */
	INVALID_PARAMETER(3001, "invalid parameter"),
    
    /** The invalid parameter format. */
    INVALID_PARAMETER_FORMAT(3002, "invalid parameter format"), 

    // db exception error codes - 4XXX
    /** The db error. */
    DB_ERROR(4000,"Generic database error"), 
    // misc error codes - 9XXX
    /** The missing parameter. */
    MISSING_PARAMETER(9001, "MISSING_PARAMETER"),
    
    MISSING_PARAMETER_ERROR(2001,"Input error"),
	
	ERROR_NOT_Null(301,"NOT Null. Id cannot be null"), 
 
	// QRTransaction related errors
	/** DB Error*/
	ERROR_DB(501,"Unable to connect to database"),
	
		
	ERROR_IN_SMS_SENDING(701,"Error in sms sending"),
	
	SMS_REQ_ERROR(702, "SMS request cannot be processed;"),
	
	SMS_TYPE_NULL(703,"SMS type is null"),
	
	SMS_TEXT_EMPTY(704,"SMS text cannot be null or empty"),
	
	NO_SMS_PROVIDER(705,"SMS provider is not enabled"),
	
	SENDER_NAME_EMPTY(706,"Sender name cannot be null or empty"),
	
	SMS_MAX_LENGTH_EXCEEDED(707,"SMS text length is greater than max length"),
	
	SMS_CALLBACK_SAVE_ERROR(708,"Error in SMS calback saving"),
	
	NO_SMS_PROVIDER_LIST(700,"SMS provider list is not in the request"),


	ERROR_EMAIL_SUBJECT_EMPTY(804,"Email subject cannot be null or empty"),	
	
	ERROR_EMAIL_SERVICE_NOT_AVAILABLE(850,"Email subject cannot be null or empty");
	
	
    /** The error code. */
    private int errorCode; 
    
    /** The error description. */
    private String errorDescription;

    /**
     * Instantiates a new error code description.
     *
     * @param code the code
     * @param description the description
     */
    private ErrorCodeDescription(int code, String description) {
    	
        this.errorCode = code;
        this.errorDescription = description;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Gets the error description.
     *
     * @return the error description
     */
    public String getErrorDescription() {
        return errorDescription;
    }

}
