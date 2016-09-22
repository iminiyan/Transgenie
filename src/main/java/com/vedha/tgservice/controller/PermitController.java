package com.vedha.tgservice.controller;

import java.util.List;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.vedha.tgservice.dto.PermitDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.service.PermitService;


@Log4j
@RestController
@RequestMapping("/permit")
public class PermitController {
	
	@Autowired
	PermitService permitService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public PermitDTO addPermit(@RequestBody PermitDTO permitdto) throws ApplicationException {
		log.info("add permit ");
		return permitService.savePermit(permitdto);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public PermitDTO modifyPermit(@RequestBody PermitDTO permitdto) throws ApplicationException {
		log.info("Modify permit");
		return permitService.updatePermit(permitdto);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deletePermit(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete permit");
		permitService.deletePermit(id);
	}
		
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<PermitDTO> getAllPermit() throws ApplicationException {
		log.info("Get All permit");
		return permitService.getAllPermit();
	}
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public PermitDTO getPermitByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get permit By ID");
		return permitService.getPermitByID(id);
	}
	

}
