package com.vedha.tgservice.exception;

/**
 * The Enum ErrorCodeDescription.
 */
public enum ErrorCodes {
	
	/** The unauthorized user. */
	UNAUTHORIZED_USER(1000,"Access Denied"),
	
	/** The password mismatch. */
	PASSWORD_MISMATCH(1001,"Password mismatch"),
	
	/** The login validte. */
	LOGIN_VALIDTE(1002,"Incorrect UserName or Password"),
	
	 /** Generic error */
	ERROR_GENERIC(2000,"Internal Error. Please try again"),

	// invalid parameter error codes - 3XXX
	/** input validation error codes */
    /** The invalid parameter. */
	INVALID_PARAMETER(3001, "invalid parameter"),
    
    /** The invalid parameter format. */
    INVALID_PARAMETER_FORMAT(3002, "invalid parameter format"), 

    /** input validation error codes */
	// db exception error codes - 4XXX
    /** The db error. */
    DB_ERROR(4000,"Generic database error"), 
    
    // misc error codes - 9XXX
    /** The missing parameter. */
    MISSING_PARAMETER(9001, "MISSING_PARAMETER"),
    
    ERROR_NOT_NUll_FPSId(432,"Not Null Fps Id.Fps Id cannot be null"),
    
    ERROR_INVALID_PRODUCTID(405,"Not Null Product Id. Product Id cannot be null"),
    
    ERROR_NOT_Null_GodownStockRequestData(422,"Given Request is Null"),
    
    ERROR_NOT_Null_FpsStockData(425,"Data not found for FPS Stock"),
    
    ERROR_NOT_Null_GodownFPSStoc(423,"FPS Stock is nulll"),
    
    ERROR_INVALID_GODOWNID(401,"Godown Id cannot be null"),
    
    ERROR_GODOWNSTOCK_AVAILABLE(434,"Opening Stock is available"),
    
	ERROR_NO_GODOWN_HISTORY_FOUND(435,"Godown Id not found in History"),
	
	ERROR_INVALID_GODOWNSTOCK(427,"Data not found in GodownStock"),
	
	ERROR_FPSSTORE_NOT_VALID(6036,"The FpsStore store is not valid"),
	
	ERROR_NOTENOUGH_GODOWNSTOCK(433,"Quantity not available in godownStock"),
	/** mobile number is empty */
	ERROR_MOBILENO_INPUT_EMPTY(1007,"Mobile Number input is invalid"),
	
	ERROR_NULL_GodownStockOutward(434,"Godown stock outward not available in godownStock"),
	ERROR_PINCODE_WRONG(8038,"Please provide a PIN code of length 6"),
	ERROR_MOBILENUMBER_VALIDATION(8044,"The mobile number should be 10 numeric digits and should stsarts with 9,8 or 7"),
	ERROR_EMAIL_VALIDATION(8052,"Please provide a valid Email_id"),
	/** for beneficiary application*/
	ERROR_BENE_APP_NAME_EMPTY(8076,"Please enter a valid name"),
	ERROR_BENE_APP_GENDER_INVALID(8077,"Please enter a valid gender for beneficiary"),
	ERROR_BENE_APP_FATHERNAME_OR_HUSBAND_NAME_INVALID(8078,"Please enter a valid Father/husband name"),
	ERROR_BENE_MEMBER_APP_NAME_EMPTY(8079,"Please enter a valid name for member"),
	ERROR_BENE_MEMBER_APP_GENDER_INVALID(8080,"Please enter a valid gender member"),
	ERROR_BENE_MEMBER_APP_NATIONNALITY_INVALID(8081,"Please enter a valid nationnality for member"),
	ERROR_BENEFICIARY_PRESENT_WITH_MOBILE_NO(8082,"Already a beneficiary present with this mobile number"),
	ERROR_BENE_MEMBER_APP_MONTHLY_INCOME_INVALID(8083,"Please enter a valid monthly income for member"),
	ERROR_BENEFICIARY_APPLICATION_WITH_MOBILE_PRESENT(8084,"With the entered mobile number already one application present"),
	ERROR_BENEFICIARY_APPLICATION_WITH_EMAILID_PRESENT(8085,"With the entered emailid one application already present"),
	ERROR_PRODUCT_LOCAL_NAME_DUPLICATED(8086,"Products local name already present"),
	ERROR_BENE_APP_NOT_FOUND(8087,"The Beneficiary applicaion not found"),
	ERROR_BENE_APP_STATUS_NOT_FOUND(8088,"The beneficiary application status not found"),
	ERROR_INVALID_TRANSACTIONTYPE(8089,"Invalid transaction type in request"),
	ERROR_NOCARD_PROOF_FILE_SIZE_TOO_BIG(8089,"The no card proof file size is too long the size must be with in 240KB"),
	ERROR_RESIDENCE_PROOF_FILE_SIZE_TOO_BIG(8090,"The residence proof file size too long the size must be with in 240KB "),
	ERROR_BENEFICIARY_PICTURE_FILE_SIZE_TOO_BIG(8091,"The beneficiary picture file size too long , must be in 240 KB"),
	ERROR_SMSSERVICE_UNAVAILABLE(8092,"Currently sms service is not available"),
	ERROR_SMS_SERVICE_NOT_RUNNING(8093,"The SMS Service is not available currently"),
	ERROR_FPS_GENERATED_CODE_NOT_FOUND(10000,"Please enter a FPS-Code"),
	ERROR_BENE_MEMBER_VOTER_CARD_VALIDATION(10001,"Please enter a valid Election Id Card No"),
	ERROR_BENE_MEMBER_AADHAAR_CARD_VALIDATION(10002,"Please enter a valid Aadhaar Card No"),
	;
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
    private ErrorCodes(int code, String description) {
    	
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
    
    /**
     * This method returns description for the given error code
     * 
     * @param code	- input error code
     * @return	String - description
     */
    public static String getDescription(int code){
    	for(ErrorCodes codes:values()){
    		if(codes.getErrorCode() == code)
    			return codes.getErrorDescription();
    	}    		
    	return null;
    }
}
