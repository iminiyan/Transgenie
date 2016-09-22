package com.vedha.tgservice.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.vedha.tech.common.validator.BasicValidator;
import com.vedha.tgservice.dto.PostLoadDTO;


import lombok.extern.log4j.Log4j;

@Component("postloadValidator")
@Log4j
public class PostLoadValidator extends BasicValidator {
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		//return false;
		return PostLoadDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		PostLoadDTO postloadDto = (PostLoadDTO) target;
	     
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadType", "required.loadType","loadType is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadLength", "required.loadLength","loadLength is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadWidth", "required.loadWidth","loadWidth is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadHeight", "required.loadHeight","loadHeight is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadWeight", "required.loadWeight","loadWeight is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadDesc", "required.loadDesc","loadDesc is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isCovered", "required.isCovered","isCovered is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "distance", "required.distance","distance is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "additionalInfo", "required.additionalInfo","additionalInfo is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactName", "required.contactName","contactName is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "additionalInfo", "required.additionalInfo","additionalInfo is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactName", "required.contactName","contactName is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNum", "required.contactNum","contactNum is required.");
		
		if((postloadDto.getContactNum() != null) && (FormValidation.validatePhoneno(String.valueOf(postloadDto.getContactNum())))){
			errors.rejectValue("contactNum", "contactNum.incorrect","Enter a Valid contact number");
		    log.error("Invalid contact number");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactEmail", "required.contactEmail","contactEmail is required.");
		
		if ((!postloadDto.getContactEmail().equals("")) && (FormValidation.validateemail(postloadDto.getContactEmail()))){
			//FormValidation.validateemail(postloadDto.getContactEmail().trim());
			errors.rejectValue("contactEmail", "contactEmail.incorrect","Enter a correct contactEmail");
			log.error("Invalid contactEmail Id");
		}
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loadStatus", "required.loadStatus","loadStatus is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "overLoadStack", "required.overLoadStack","overLoadStack is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "delayCharges", "required.delayCharges","delayCharges is required.");
		
		
	}
	
		
    public void modifyValidate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custID", "required.custID","custID is required.");
    }

}