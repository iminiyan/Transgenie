package com.vedha.tgservice.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.controller.BasicController;
import com.vedha.tgservice.dto.CustTransporterDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.exception.ValidationException;
import com.vedha.tgservice.service.SignupTransportService;
import com.vedha.tgservice.validator.SignUpTransportValidator;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/transporter")
@Log4j
public class SignupTransportController extends BasicController{
	
	@Autowired
	SignupTransportService  transportService;
	
	@Autowired
	@Qualifier("signupTransportValidator")
	private SignUpTransportValidator validator;
	
	@InitBinder("signupTransportDTO")
	@Override
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);	
	}
	
	@Override
	@ModelAttribute("signupTransportDTO")
	protected CustTransporterDTO createNewModel() {
		return new CustTransporterDTO();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public CustTransporterDTO add(@RequestBody CustTransporterDTO customerDto,BindingResult bindingResult) throws ValidationException {
		log.info("add Transporter Details");
		validator.validate(customerDto, bindingResult);
		fillDefaultValue(customerDto, ActionMode.CREATE);
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
		else{
			return transportService.add(customerDto);
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public CustTransporterDTO modify(@RequestBody CustTransporterDTO customerdto) throws ApplicationException {
		log.info("Modify Transport Details");
		//fillDefaultValue(customerdto, ActionMode.MODIFY);
		return transportService.update(customerdto);
	}
    
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Transporter Details");
		transportService.delete(id);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<CustTransporterDTO> getAll() throws ApplicationException {
		log.info("Get All Transporter Details");
		return transportService.getAll();
	}
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody CustTransporterDTO getByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get Transporter By ID");
		return transportService.getByID(id);
	}
}
