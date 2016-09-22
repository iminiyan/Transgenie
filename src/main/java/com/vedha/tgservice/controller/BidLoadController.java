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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.controller.BasicController;
import com.vedha.tgservice.dto.BidLoadDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.service.BidLoadService;
import com.vedha.tgservice.validator.BidLoadValidator;

import lombok.extern.log4j.Log4j;


@Log4j
@RestController
@RequestMapping("/bidload")
public class BidLoadController extends BasicController {

	@Autowired
	BidLoadService bidloadService;
	
	@Autowired
	@Qualifier("bidloadValidator")
	private BidLoadValidator blvalidator;
	
	@InitBinder("bidloadDTO")
	@Override
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(blvalidator);	
	}
	
	@Override
	@ModelAttribute("bidloadDTO")
	protected BidLoadDTO createNewModel() {
		return new BidLoadDTO();
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public BidLoadDTO addBid(@RequestBody BidLoadDTO dto, BindingResult bindingResult) throws ApplicationException {
		log.info("Create New Customer");
		fillDefaultValue(dto, ActionMode.CREATE);
		return bidloadService.saveBid(dto);
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public BidLoadDTO modifyBid(@RequestBody BidLoadDTO dto) throws ApplicationException {
		log.info("Modify Customer");
		//fillDefaultValue(dto, ActionMode.MODIFY);
		return bidloadService.updateBid(dto);
	}
	
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public BidLoadDTO getUserByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get User By ID");
		return bidloadService.getBidBybidLoadID(id);
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<BidLoadDTO> getAllBid() throws ApplicationException {
		log.info("Get All Registered Users");
		return bidloadService.getAllBid();
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteBid(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Customer");
		bidloadService.deleteBid(id);
	}
	
}
