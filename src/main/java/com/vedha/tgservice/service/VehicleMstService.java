package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.VehicleMstDTO;
import com.vedha.tgservice.entity.VehicleMstEntity;
import com.vedha.tgservice.repository.VehicleMstRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;
@Service
public class VehicleMstService {
	
	@Autowired
	VehicleMstRepository vehicleRepository;

	@Transactional
	public VehicleMstDTO saveVehicle(VehicleMstDTO vehicledto) {
		VehicleMstEntity vehicleEntity = (VehicleMstEntity) ModelEntityMapper.converModelToEntity(vehicledto, VehicleMstEntity.class);
		vehicleEntity = vehicleRepository.saveAndFlush(vehicleEntity);
		return (VehicleMstDTO) ModelEntityMapper.converEntityToModel(vehicleEntity, VehicleMstDTO.class);
	}
    
	
	@Transactional
	public VehicleMstDTO updateVehicle(VehicleMstDTO vehicledto) {
	
		VehicleMstEntity vehicleEntity = (VehicleMstEntity) ModelEntityMapper.converModelToEntity(vehicledto, VehicleMstEntity.class);
		vehicleEntity = vehicleRepository.saveAndFlush(vehicleEntity);
		return (VehicleMstDTO) ModelEntityMapper.converEntityToModel(vehicleEntity, VehicleMstDTO.class);
	}
   
	
	@Transactional
	public void deleteVehicle(long id) {
		vehicleRepository.delete(id);
		
	}
    
	
	@Transactional
	public List<VehicleMstDTO> getAllVehicles() {
		List<VehicleMstDTO> vehicleList = new ArrayList<VehicleMstDTO>();
		for (VehicleMstEntity vehicleEntity : vehicleRepository.findAll()) {
			VehicleMstDTO vehicleDTO = (VehicleMstDTO) ModelEntityMapper.converEntityToModel(vehicleEntity, VehicleMstDTO.class);
			vehicleList.add(vehicleDTO);
		}
		return vehicleList;
	}
    
	
	@Transactional
	public VehicleMstDTO getVehicleById(long id) {
		
		VehicleMstEntity vehicleEntity = vehicleRepository.findOne(id);
		if (vehicleEntity != null) {
			VehicleMstDTO vehicleDTO = (VehicleMstDTO) ModelEntityMapper.converEntityToModel(vehicleEntity, VehicleMstDTO.class);
			return vehicleDTO;
		}
		return null;
	}

}
