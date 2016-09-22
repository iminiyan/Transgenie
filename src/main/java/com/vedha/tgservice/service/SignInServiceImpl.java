package com.vedha.tgservice.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedha.tgservice.dto.SignUpDTO;
import com.vedha.tgservice.entity.SignUpEntity;
import com.vedha.tgservice.repository.SignInRepository;
import com.vedha.tgservice.utils.ModelEntityMapper;

@Service
public class SignInServiceImpl implements SignInService{

	@Autowired
	SignInRepository signInRespository;
	
	@Override
	@Transactional
	public List<SignUpDTO> findByEmail(SignUpDTO loginDTO) {
		
		List<SignUpEntity> commonEntity = signInRespository.findByEmail(loginDTO.getEmail().trim(),loginDTO.getPassword().trim());
		List<SignUpDTO> signUpDTO = new ArrayList<SignUpDTO>();
		if( !commonEntity.isEmpty()){
			for(SignUpEntity signupEntity : commonEntity){
			SignUpDTO commonDTO = (SignUpDTO) ModelEntityMapper.converEntityToModel(signupEntity, SignUpDTO.class);
			signUpDTO.add(commonDTO);
			}
		}
		return signUpDTO;
	
	}

}
