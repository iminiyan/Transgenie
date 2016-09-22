package com.vedha.tgservice.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.constants.Permit;
import com.vedha.tech.common.dto.BasicDTO;
import com.vedha.tgservice.entity.CustTransporterEntity;


public class VehicleMstDTO extends BasicDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Setter @Getter
	private Long vehicleID;
	
	@Setter @Getter 
	private Long vehicleRegNum;
	
	@Setter @Getter
	private Character isCovered;
	
	@Getter @Setter
	private Permit permitStateName;

	@Setter @Getter
	private String vehicleTypeName;
	
	@Setter @Getter
	private String vehicleTypeDesc;
	
	@Setter @Getter
	private Integer vehicleHeight;
	
	@Setter @Getter
	private Integer vehicleLength;
	
	@Setter @Getter
	private Integer vehicleWidth;
	
	@Setter @Getter
	private Integer vehicleCapacity;
	
	@Setter @Getter
	private Integer wheelLength;
	
	@Setter @Getter
	private Date vehicleInsurDate;
	
	@Setter @Getter
	private Date vehicleFCDate;
	
}
