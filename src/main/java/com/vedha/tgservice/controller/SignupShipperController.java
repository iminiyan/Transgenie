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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.controller.BasicController;
import com.vedha.tgservice.dto.CustShipperDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.exception.ValidationException;
import com.vedha.tgservice.service.SignupShipperService;
import com.vedha.tgservice.validator.SignUpShipperValidator;


@RestController
@RequestMapping("/shipper")
@Log4j
public class SignupShipperController extends BasicController {
    
	@Autowired
	SignupShipperService shipperService;
	
	@Autowired
	@Qualifier("signupShipperValidator")
	private SignUpShipperValidator validator;
	
	@InitBinder("signupShipperDTO")
	@Override
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);	
	}
	
	@Override
	@ModelAttribute("signupShipperDTO")
	protected CustShipperDTO createNewModel() {
		return new CustShipperDTO();
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public CustShipperDTO add(@RequestBody CustShipperDTO customerDto,BindingResult bindingResult) throws ValidationException{
		log.info("add Shipper Details");
		validator.validate(customerDto, bindingResult);
		fillDefaultValue(customerDto, ActionMode.CREATE);
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
		else{
			return shipperService.add(customerDto);
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public CustShipperDTO modify(@RequestBody CustShipperDTO customerdto) throws ApplicationException {
		log.info("Modify Shipper Details");
		return shipperService.update(customerdto);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Shipper Details");
		shipperService.delete(id);
	}
	

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<CustShipperDTO> getAll() throws ApplicationException {
		log.info("Get All Transporter Details");
		return shipperService.getAll();
	}
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CustShipperDTO> getByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get Shipper By ID");
		return shipperService.getByID(id);
	}
}
