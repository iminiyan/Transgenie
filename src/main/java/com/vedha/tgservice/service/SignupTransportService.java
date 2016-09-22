package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.CustTransporterDTO;
import com.vedha.tgservice.entity.CustTransporterEntity;
import com.vedha.tgservice.entity.VehicleMstEntity;
import com.vedha.tgservice.repository.CustTransporterRepository;
import com.vedha.tgservice.repository.VehicleMstRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

@Log4j
@Service
public class SignupTransportService {
	@Autowired
	CustTransporterRepository transportRepository;
	
	@Autowired 
	VehicleMstRepository vehicleRepository;
    
	@Transactional
	public CustTransporterDTO add(CustTransporterDTO customerDto) {
		CustTransporterEntity transportEntity = (CustTransporterEntity) ModelEntityMapper.converModelToEntity(customerDto, CustTransporterEntity.class);
		transportEntity = transportRepository.save(transportEntity);
		List<VehicleMstEntity> vehicleEntity= transportEntity.getVehicleList();
        for (VehicleMstEntity vehicleEntityValue : vehicleEntity) {
        	
        	vehicleEntityValue=vehicleRepository.save(vehicleEntityValue);
        	}
		
		log.info("Transporter Data Inserted Sucessfully");
		return (CustTransporterDTO) ModelEntityMapper.converEntityToModel(transportEntity, CustTransporterDTO.class);
	}
	@Transactional
	public CustTransporterDTO update(CustTransporterDTO customerdto) {
		log.info("Transporter update input :: "+customerdto);
		CustTransporterEntity transportEntity = (CustTransporterEntity) ModelEntityMapper.converModelToEntity(customerdto, CustTransporterEntity.class);
		
		List<VehicleMstEntity> vehicleEntity= transportEntity.getVehicleList();
		log.info("Vehicle Entity values captured :: "+vehicleEntity);
        for (VehicleMstEntity vehicleEntityValue : vehicleEntity) {
        	vehicleEntityValue=vehicleRepository.save(vehicleEntityValue);
		}
		
		transportEntity = transportRepository.save(transportEntity);
		
		log.info("Transporter Data Updated Sucessfully");
		return (CustTransporterDTO) ModelEntityMapper.converEntityToModel(transportEntity, CustTransporterDTO.class);
	}
	@Transactional
	public void delete(long id) {
		transportRepository.delete(id);
		
	}
	@Transactional
	public List<CustTransporterDTO> getAll() {
		List<CustTransporterDTO> transportList = new ArrayList<CustTransporterDTO>();
		for (CustTransporterEntity transportEntity : transportRepository.findAll()) {
			CustTransporterDTO transportDTO = (CustTransporterDTO) ModelEntityMapper.converEntityToModel(transportEntity, CustTransporterDTO.class);
			transportList.add(transportDTO);
		}
		return transportList;
	}
	@Transactional
	public CustTransporterDTO getByID(long id) {
		
		log.info("custID value captured :"+id);
		
		CustTransporterDTO transportDTO = null;
		
		CustTransporterEntity transportEntity = transportRepository.findByCustID(id);
		
		//CustTransporterEntity transportEntity = transportRepository.findOne(id);
		
		if (transportEntity != null) {
			transportDTO = (CustTransporterDTO) ModelEntityMapper.converEntityToModel(transportEntity, CustTransporterDTO.class);
			return transportDTO;
		}
		
		 return new CustTransporterDTO();
	}

}
