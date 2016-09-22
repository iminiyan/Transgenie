package com.vedha.tgservice.validator;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.vedha.tech.common.validator.BasicValidator;
import com.vedha.tgservice.dto.CustShipperDTO;

@Component("signupShipperValidator")
@Log4j
public class SignUpShipperValidator extends BasicValidator {@Override
	public boolean supports(Class<?> clazz) {
	return CustShipperDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustShipperDTO shipperDto = (CustShipperDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "required.addressLine","Enter your addressLine");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area", "required.area","Enter your area");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateID", "required.stateID","Enter your stateID");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "required.city","Enter your City");
		 if ((!shipperDto.getCity().equals("")) && (FormValidation.validateAlphabet(shipperDto.getCity()))){
		     errors.rejectValue("city", "city.incorrect","Enter a Valid City Name");	
		     log.error("Invalid City Name");
		}
		
	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "district", "required.district","Enter your district"); 
	    if ((!shipperDto.getDistrict().equals("")) && (FormValidation.validateAlphabet(shipperDto.getDistrict()))){
		
		     errors.rejectValue("district", "district.incorrect","Enter a Valid District Name");	
		     log.error("Invalid District Name");
		}
		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pincode", "required.pincode","Enter your pincode");
		if(NullValidate.validateInteger( shipperDto.getPincode() )){ 
			FormValidation.validateID( String.valueOf(shipperDto.getPincode()) );
	    	 errors.rejectValue("pincode", "pincode.incorrect","Enter a numeric value");
			 log.error("Invalid pincode Value");
		
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serviceTaxType", "required.serviceTaxType","Enter your Service Tax Type");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serviceTaxValue", "required.serviceTaxValue","Enter your Service Tax Value");
		if ((shipperDto.getServiceTaxValue() !=null)  && (FormValidation.validateID( String.valueOf(shipperDto.getServiceTaxValue()) ))) {
	    	 errors.rejectValue("serviceTaxValue", "serviceTaxValue.incorrect","Enter a numeric value");
			 log.error("Invalid Service Tax Value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "panNum", "required.panNum","Enter your Pan Number");
		if ((!shipperDto.getPanNum().equals("")) && (FormValidation.validatePanNum(shipperDto.getPanNum()))){
	    	 errors.rejectValue("panNum", "panNum.incorrect","Enter a valid Pan Card Number");
			 log.error("Invalid PanCard Number Value");
		
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tinNum", "required.tinNum","Enter your Tin Number");
	}

}
