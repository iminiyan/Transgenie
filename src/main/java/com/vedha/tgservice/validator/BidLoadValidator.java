package com.vedha.tgservice.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.vedha.tech.common.validator.BasicValidator;
import com.vedha.tgservice.dto.BidLoadDTO;

import lombok.extern.log4j.Log4j;

@Component("bidloadValidator")
@Log4j
public class BidLoadValidator extends BasicValidator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		//return false;
		return BidLoadDTO.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		
		BidLoadDTO bidloadDto = (BidLoadDTO) target;
	     
		//boolean check=true;
		
		//log.info("Enter Validation :::");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromDate", "required.fromDate","fromDate is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toDate", "required.toDate","toDate is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bidPrice", "required.bidPrice","bidPrice is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tollCharges", "required.tollCharges","tollCharges is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deliveryDays", "required.deliveryDays","deliveryDays is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "applicationCharges", "required.applicationCharges","applicationCharges is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "chargesHalt", "required.chargesHalt","chargesHalt is required.");
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "otherCharges", "required.otherCharges","otherCharges is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalCharges", "required.totalCharges","totalCharges is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radius", "required.radius","radius is required.");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "distance", "required.distance","distance is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bidLoadDesc", "required.bidLoadDesc","bidLoadDesc is required.");
	
	}
	
		
}
