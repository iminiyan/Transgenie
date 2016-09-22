package com.vedha.tgservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedha.tgservice.dto.SignUpDTO;
import com.vedha.tgservice.entity.SignUpEntity;
import com.vedha.tgservice.repository.SignUpRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class SignUpServiceImpl implements SignUpService{

	
	@Autowired
	SignUpRepository commonRepository;
	
	//Add Details
	@Transactional
	public SignUpDTO add(SignUpDTO customerDto) {
		SignUpEntity commonEntity = (SignUpEntity) ModelEntityMapper.converModelToEntity(customerDto, SignUpEntity.class);
		commonEntity = commonRepository.saveAndFlush(commonEntity);
		log.info("Transporter Data Inserted Sucessfully");
		return (SignUpDTO) ModelEntityMapper.converEntityToModel(commonEntity, SignUpDTO.class);
		
	}
	
	
   //Modify Details
	@Transactional
	public SignUpDTO update(SignUpDTO customerDto) {
		SignUpEntity commonEntity = (SignUpEntity) ModelEntityMapper.converModelToEntity(customerDto, SignUpEntity.class);
		commonEntity = commonRepository.save(commonEntity);
		log.info("Transporter Data Updated Sucessfully");
		return (SignUpDTO) ModelEntityMapper.converEntityToModel(commonEntity, SignUpDTO.class);
	}
    
	
	//Delete Details
	@Transactional
	public void delete(long id) {
		
		commonRepository.delete(id);
	}
	

	//Get All Info
	@Transactional
	public List<SignUpDTO> getAll() {
		List<SignUpDTO> commonList = new ArrayList<SignUpDTO>();
		for (SignUpEntity commonEntity : commonRepository.findAll()) {
			SignUpDTO commonDTO = (SignUpDTO) ModelEntityMapper.converEntityToModel(commonEntity, SignUpDTO.class);
			commonList.add(commonDTO);
		}
		return commonList;
	}
	

	//Get Details Based on ID
	@Transactional
	public SignUpDTO getByID(long id) {
		SignUpEntity commonEntity = commonRepository.findOne(id);
		if (commonEntity != null) {
			SignUpDTO commonDTO = (SignUpDTO) ModelEntityMapper.converEntityToModel(commonEntity, SignUpDTO.class);
			return commonDTO;
		}
		return null;
	}
	

}
