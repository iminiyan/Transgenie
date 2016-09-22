package com.vedha.tech.common.validator;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Validator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class BasicValidator implements Validator{
	
	protected HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
		.getRequest();
		return request;
	}
	
	private HashMap<String,String> mapError;
	
//	protected boolean checkURLForDuplicateValid(){
//		String URL = getRequest().getRequestURL().toString();
//		return (StringUtils.endsWithIgnoreCase(URL, AppConstants.URL_ADD) || StringUtils.endsWith(URL, AppConstants.URL_RPT_DWLN));
//	}
}
