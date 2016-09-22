package com.vedha.tgservice.controller;

import java.util.List;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.controller.BasicController;
import com.vedha.tgservice.dto.SignUpDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.exception.ValidationException;
import com.vedha.tgservice.service.SignUpService;
import com.vedha.tgservice.validator.SignUpValidator;

@RestController
@RequestMapping("/signup")
@Log4j
public class SignUpController extends BasicController   {
	
	@Autowired
	SignUpService signupService;
	
	@Autowired
	@Qualifier("signupValidator")
	private SignUpValidator validator;
	
	@InitBinder("signupDTO")
	@Override
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);	
	}
	
	@Override
	@ModelAttribute("signupDTO")
	protected SignUpDTO createNewModel() {
		return new SignUpDTO();
	}
	
	//add Details
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public SignUpDTO add(@RequestBody SignUpDTO customerDto,BindingResult bindingResult) throws ValidationException{
		log.info("add Common Details");
		validator.validate(customerDto, bindingResult);
		fillDefaultValue(customerDto, ActionMode.CREATE);
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
		else{
		       return signupService.add(customerDto);
		}
	}
	
	
    //Modify Details
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public SignUpDTO modify(@RequestBody SignUpDTO customerdto) throws ApplicationException {
		log.info("Modify Common Details");
		fillDefaultValue(customerdto, ActionMode.MODIFY);
		return signupService.update(customerdto);
	}
	
	
	//Delete Details
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Common Details");
		signupService.delete(id);
	}
	
	
	//Get All Details
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<SignUpDTO> getAll() throws ApplicationException {
		log.info("Get All Common Details");
		return signupService.getAll();
	}
	
	
	//Get Details Based on ID
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public SignUpDTO getByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get User By ID");
		return signupService.getByID(id);
	}
	
}
