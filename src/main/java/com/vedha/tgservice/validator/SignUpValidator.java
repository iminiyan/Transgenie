package com.vedha.tgservice.validator;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.vedha.tech.common.validator.BasicValidator;
import com.vedha.tgservice.dto.SignUpDTO;

@Component("signupValidator")
@Log4j
public class SignUpValidator extends BasicValidator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		//return false;
		return SignUpDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		SignUpDTO signupDto = (SignUpDTO) target;
	     
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custType", "required.custType","custType is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "required.companyName","companyname is required.");
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email","Enter Email ID");
		  if ((!signupDto.getEmail().equals("")) && (FormValidation.validateemail(signupDto.getEmail())))
	      {		  
			  log.info("check validation side");
			   errors.rejectValue("email", "email.incorrect","Enter a correct email");
			   
	       }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password","password is required.");
		//FirstName Validation
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "firstname is required");
		 if ((!signupDto.getFirstName().equals("")) && (FormValidation.validateAlphabet(signupDto.getFirstName()))){
			
			       
		            errors.rejectValue("firstName", "firstName.incorrect","Enter a Valid FirstName");	
		            log.error("Invalid firstName value");
			}
		
		//Numeric Validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "required.countryCode","country code is required");
		if ((signupDto.getCountryCode() !=null)  && (FormValidation.validateID( String.valueOf(signupDto.getCountryCode()) ))) {
			       
	    	       errors.rejectValue("countryCode", "countryCode.incorrect","Enter a numeric value");
			       log.error("Invalid countryCode Value");
		  }
		 
		//Phone Number Validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNum", "required.phoneNum","phoneNum is required");
		if ((signupDto.getPhoneNum() != null) && (FormValidation.validatePhoneno(String.valueOf( signupDto.getPhoneNum())) )  ) {
		          
			          errors.rejectValue("phoneNum", "phoneNum.incorrect","Enter a Valid phone number");
		              log.error("Invalid PhoneNumber");
		 }
	       
	}
	

}
