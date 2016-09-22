package com.vedha.tgservice.exception;
/*package com.transgenie.rest.exceptions;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


*//**
 * The Class Validate.
 *//*
*//**
 * @author user1
 *
 *//*

public class Validate {
    *//**
     * Not null.
     *
     * @param <E> the element type
     * @param object the object
     * @param parameterName the parameter name
     * @return the e
     * @throws RestException the rest exception
     *//*
    public static <E> E notNull(E object, String parameterName) throws RestException {
        return notNull(object, parameterName, false);
    }

    *//**
     * Assert true.
     *
     * @param flag the flag
     * @param errorCode the error code
     * @throws RestException the rest exception
     *//* 
 
    	

    
    public static void assertTrue(boolean flag, ErrorCodeDescription errorCode) throws RestException {
        if (!flag)
            throw new BadRequestException(errorCode);
    }

    *//**
     * Assert false.
     *
     * @param flag the flag
     * @param errorCode the error code
     * @throws RestException the rest exception
     *//*
    public static void assertFalse(boolean flag, ErrorCodeDescription errorCode) throws RestException {
        if (flag)
            throw new BadRequestException(errorCode);
    }

    *//**
     * Not null.
     *
     * @param <E> the element type
     * @param object the object
     * @param parameterName the parameter name
     * @param checkPattern the check pattern
     * @return the e
     * @throws RestException the rest exception
     *//*
    public static <E> E notNull(E object, String parameterName, boolean checkPattern) throws RestException {
        if (object == null) {
            throw new MissingParameterException("Parameter '" + parameterName + "' can not be null.");
        }
        if (checkPattern) {
            checkPattern(object, parameterName);
        }
        return object;
    }

    *//**
     * Not null.
     *
     * @param object the object
     * @param errorCode the error code
     * @throws RestException the rest exception
     *//*
    public static void notNull(Object object, ErrorCodeDescription errorCode) throws RestException {
        if (object == null)
            throw new BadRequestException(errorCode);
    }

    *//**
     * Check pattern.
     *
     * @param <E> the element type
     * @param object the object
     * @param parameterName the parameter name
     * @return the e
     * @throws RestException the rest exception
     *//*
    public static <E> E checkPattern(E object,String parameterName) throws RestException {
        if (object == null)
            return null;
        String[] patternAndErrorMessage = ParameterFormat.getPatternAndErrorMessage(parameterName);
        if (patternAndErrorMessage== null)
            return object;
        String parameterPattern = patternAndErrorMessage[0];
        String errorMessage = patternAndErrorMessage[1];
        Pattern pattern = Pattern.compile(parameterPattern);
        Matcher matcher = pattern.matcher(object.toString());
        boolean matchFound = matcher.matches();
        if (!matchFound) {
            // String message = "Parameter '" + parameterName + "' is in invalid format";
            InvalidParameterFormatException ex = new InvalidParameterFormatException(errorMessage + " : the regex is : " + parameterPattern);
            throw ex;
        }
        return object;
    }
    
    *//**
     * Not empty.
     *
     * @param list the list
     * @param errorCode the error code
     * @throws RestException the rest exception
     *//*
    public static void notEmpty(@SuppressWarnings("rawtypes") Collection list,
    		ErrorCodeDescription errorCode) throws RestException {
		if (list == null || list.size() == 0)
			throw new RestException(errorCode);
	}
    
    *//**
     * notNullOrEmptyString
     *
     * @param object the object
     * @param errorCode the error code
     * @throws RestException the rest exception
     *//*
    public static void notNullOrEmptyString(String string, ErrorCodeDescription errorCode) throws RestException {
        if (string == null || string.trim().length() == 0)
            throw new BadRequestException(errorCode);
    }
    
    *//**
     * @param object
     * @param errorCode
     * @throws RestException
     *//*
    public static void validateString(String inputString) throws RestException {
        if (inputString == null ||inputString.equals(""))
            throw new BadRequestException(ErrorCodeDescription.MISSING_PARAMETER);        
        
    }
}
*/