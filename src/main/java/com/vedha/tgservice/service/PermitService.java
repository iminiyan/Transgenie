package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.PermitDTO;
import com.vedha.tgservice.entity.PermitEntity;
import com.vedha.tgservice.repository.PermitRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;



@Service
public class PermitService {
	
	@Autowired
	PermitRepository permitRepository;
    
	@Transactional
	public PermitDTO savePermit(PermitDTO permitdto) {
		
		PermitEntity permitEntity = (PermitEntity) ModelEntityMapper.converModelToEntity(permitdto, PermitEntity.class);
		permitEntity = permitRepository.saveAndFlush(permitEntity);
		return (PermitDTO) ModelEntityMapper.converEntityToModel(permitEntity, PermitDTO.class);
	}
	@Transactional
	public PermitDTO updatePermit(PermitDTO permitdto) {
		PermitEntity permitEntity = (PermitEntity) ModelEntityMapper.converModelToEntity(permitdto, PermitEntity.class);
		permitEntity = permitRepository.saveAndFlush(permitEntity);
		return (PermitDTO) ModelEntityMapper.converEntityToModel(permitEntity, PermitDTO.class);
	}
	@Transactional
	public void deletePermit(long id) {
		permitRepository.delete(id);
		
	}
	@Transactional
	public List<PermitDTO> getAllPermit() {
		List<PermitDTO> permitList = new ArrayList<PermitDTO>();
		for (PermitEntity permitEntity : permitRepository.findAll()) {
			PermitDTO permitDTO = (PermitDTO) ModelEntityMapper.converEntityToModel(permitEntity, PermitDTO.class);
			permitList.add(permitDTO);
		}
		return permitList;
	}
	@Transactional
	public PermitDTO getPermitByID(long id) {
		PermitEntity permitEntity = permitRepository.findOne(id);
		if (permitEntity != null) {
			PermitDTO permitDTO = (PermitDTO) ModelEntityMapper.converEntityToModel(permitEntity, PermitDTO.class);
			return permitDTO;
		}
		return null;
	}
	
	
	
 
 
} 
