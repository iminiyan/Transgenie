package com.vedha.tgservice.dto;

import java.io.Serializable;
import java.util.Date;

import com.vedha.tech.common.dto.BasicDTO;

import lombok.Getter;
import lombok.Setter;


public class PostLoadDTO extends BasicDTO{
	
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long LoadID;
	
	@Getter @Setter
	private Long custID;

	@Getter @Setter
	private AddressDTO pickupPoint;
	
	@Getter @Setter
	private AddressDTO deliveryPoint;

	@Getter @Setter
	private String loadType;
	
	@Getter @Setter
	private Integer loadLength;
	
	@Getter @Setter
	private Integer loadWidth;
	
	@Getter @Setter
	private Integer loadHeight;
	
	@Getter @Setter
	private Integer loadWeight;

	@Getter @Setter
	private String loadDesc;
	
	@Getter @Setter
	private Character isCovered;
	
	@Getter @Setter
	private Integer distance;
	
	@Getter @Setter
	private String additionalInfo;
	
	@Getter @Setter
	private String contactName;
	
	@Getter @Setter
	private Long contactNum;
		
	@Getter @Setter
	private String contactEmail;
	
	@Getter @Setter
	private Character loadStatus;
	
	@Setter @Getter
	private Character overLoadStack;
	
	@Setter @Getter 
	private Long delayCharges;
	
	@Setter @Getter 
	private Date pickupDate;
	
	@Setter @Getter 
	private Date deliveryDate;
	
}



