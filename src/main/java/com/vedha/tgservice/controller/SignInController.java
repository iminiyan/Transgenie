package com.vedha.tgservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedha.tgservice.dto.SignUpDTO;
import com.vedha.tgservice.service.SignInService;


@RestController
@RequestMapping("/signin")
public class SignInController {
	
	@Autowired
	SignInService signInService;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	List<SignUpDTO> findByEmail(@RequestBody SignUpDTO loginDTO ){
		return signInService.findByEmail(loginDTO);
			
	}
	

}
