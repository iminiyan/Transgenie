package com.vedha.tgservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.vedha.tech.common.dto.BasicDTO;

import lombok.Getter;
import lombok.Setter;


public class PermitDTO extends BasicDTO {

	
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Long permitTypeID;
	
	@Setter @Getter
	private String permitTypeName;
	
	@Setter @Getter
	private String permitTypeDesc;
	
	@Setter @Getter
	private Date permitValidDate;
	
}
