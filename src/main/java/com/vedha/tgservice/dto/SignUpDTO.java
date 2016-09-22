package com.vedha.tgservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.vedha.tech.common.dto.BasicDTO;

import lombok.Getter;
import lombok.Setter;

public class SignUpDTO extends BasicDTO {

	
	private static final long serialVersionUID = 1L;
	
	@Setter @Getter
	private Long custID;
	
	@Setter @Getter
	private Character custType;
	
	@Setter @Getter
	private String companyName;
	
	@Setter @Getter
	private String email;
	
	@Setter @Getter
	private String password;
	
	@Setter @Getter
	private String firstName;
	
	@Setter @Getter
	private String lastName;
	
	@Setter @Getter
	private Integer countryCode;
	
	@Setter @Getter
	private Long phoneNum;
	
	
}
