package com.vedha.tgservice.service;

import java.util.List;

import com.vedha.tgservice.dto.SignUpDTO;

public interface SignUpService {

	SignUpDTO add(SignUpDTO customerDto);

	SignUpDTO update(SignUpDTO customerdto);

	void delete(long id);

	List<SignUpDTO> getAll();

	SignUpDTO getByID(long id);

}
