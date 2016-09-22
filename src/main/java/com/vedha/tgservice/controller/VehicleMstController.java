package com.vedha.tgservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tgservice.dto.VehicleMstDTO;
import com.vedha.tgservice.exception.ApplicationException;
import com.vedha.tgservice.service.VehicleMstService;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping("/vehicle")
@Log4j
public class VehicleMstController  {
	
	@Autowired
	VehicleMstService vehicleService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public VehicleMstDTO addVehicle(@RequestBody VehicleMstDTO vehicledto) throws ApplicationException {
		log.info("add Vehicle");
		//fillDefaultValue(vehicledto, ActionMode.CREATE);
		return vehicleService.saveVehicle(vehicledto);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public VehicleMstDTO modifyVehicle(@RequestBody VehicleMstDTO vehicledto) throws ApplicationException {
		log.info("Modify Vehicle");
		//fillDefaultValue(vehicledto, ActionMode.MODIFY);
		return vehicleService.updateVehicle(vehicledto);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteVehicle(@PathVariable("id") long id) throws ApplicationException {
		log.info("Delete Vehicle");
		vehicleService.deleteVehicle(id);
	}
		
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<VehicleMstDTO> getAllVehicle() throws ApplicationException {
		log.info("Get All Vehicle");
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping(value = "/getByID/{id}", method = RequestMethod.GET)
	public VehicleMstDTO getVehicleByID(@PathVariable("id") long id) throws ApplicationException {
		log.info("Get Vehicle By ID");
		return vehicleService.getVehicleById(id);
	}

}
