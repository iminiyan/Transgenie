package com.vedha.tgservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.vedha.tech.common.constants.Permit;
import com.vedha.tech.common.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="vehicle_mst")
public class VehicleMstEntity extends BasicEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long vehicleID;
	
	@Setter @Getter 
	private Long vehicleRegNum;
	
	@Setter @Getter
	private Character isCovered;
	
	@Setter @Getter
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
	
	@JoinColumn(name="transID")
	@Getter @Setter
	private Long transID;

}
