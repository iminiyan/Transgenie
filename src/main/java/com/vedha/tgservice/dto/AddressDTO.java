package com.vedha.tgservice.dto;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.dto.BasicDTO;

public class AddressDTO extends BasicDTO{
	

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long addressID;
	
	@Getter @Setter
	private String doorNum;
	
	@Getter @Setter
	private String plotNum;
	
	@Getter @Setter
	private String streetName;
	
	@Getter @Setter
	private String landMark;
	
	@Getter @Setter
	private String areaName;
	
	@Getter @Setter
	private String districtName;
	
	@Getter @Setter
	private String stateName;
	
	@Getter @Setter
	private Long pincode;
	
	
	
	

}
