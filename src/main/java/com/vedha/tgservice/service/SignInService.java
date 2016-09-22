package com.vedha.tgservice.service;

import java.util.List;

import com.vedha.tgservice.dto.SignUpDTO;

public interface SignInService {

	List<SignUpDTO> findByEmail(SignUpDTO loginDTO);

	
	
	
}
