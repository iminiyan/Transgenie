package com.vedha.tech.common.controller;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.dto.BasicDTO;
import com.vedha.tech.common.dto.ValidationErrorDTO;
import com.vedha.tech.common.variable.AppDate;
import com.vedha.tgservice.constants.AppConstants;
import com.vedha.tgservice.exception.ValidationException;

public abstract class BasicController {
	
private static final String RESOURCE_BUNDLE = "errorMessages";
	
	protected abstract void initBinder(WebDataBinder binder);
	
	protected abstract BasicDTO createNewModel();
	
	
	@ExceptionHandler(ValidationException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorDTO processValidationError(ValidationException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        return processFieldErrors(fieldErrors);
    }
 
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
          //  dto.addFieldError(fieldError.getField(), getMessageByCode(fieldError.getCode()));
        	dto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
 
        return dto;
    }
 
    private String getMessageByCode(String code) {
		String rst = null;

		try {
			
			rst = ResourceBundle.getBundle(RESOURCE_BUNDLE, Locale.US).getString(code);
			
		} catch (MissingResourceException e) {
			
			rst = null;
			
		}
		
		return rst;
	}
    

	public void fillDefaultValue(BasicDTO dto, ActionMode action) {
		
		switch (action) {
		case CREATE:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setCreationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("A");
			dto.setReasonCode("NONE");
			dto.setVersionNum(AppConstants.VERSION_ONE);
			break;

		case MODIFY:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setModificationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("A");
			dto.setReasonCode("NONE");
			dto.setVersionNum(dto.getVersionNum() + AppConstants.VERSION_ONE);
			break;

		case DELETE:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setModificationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("D");
			dto.setReasonCode("NONE");
			dto.setVersionNum(dto.getVersionNum() + AppConstants.VERSION_ONE);
			break;

		case VALIDATE:
			break;

		default:
			break;
		}
	}
	
	private HttpSession getSession(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		return session;
	}

}

