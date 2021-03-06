package com.vedha.tgservice.exception;


/**
 * The Class BadRequestException.
 */
public class BadRequestException extends RestException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8263143357588041554L;

    /**
     * Instantiates a new bad request exception.
     *
     * @param errorCode the error code
     */
    public BadRequestException(ErrorCodeDescription errorCode) {
        super(errorCode, errorCode.getErrorDescription());
    }

}
