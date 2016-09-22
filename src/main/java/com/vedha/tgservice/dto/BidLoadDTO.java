package com.vedha.tgservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.dto.BasicDTO;

public class BidLoadDTO extends BasicDTO{

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long bidLoadID;
	
	@Getter @Setter
	private Long postLoadID;
	
	@Getter @Setter
	private Long transportID;
	
	@Getter @Setter
	private Long vehicleID;
	
	@Getter @Setter
	private AddressDTO pickupPoint;
	
	@Getter @Setter
	private AddressDTO deliveryPoint;
	
	@Getter @Setter
	private Date fromDate;
	
	@Getter @Setter
	private Date toDate;
	
	@Getter @Setter
	private Long bidPrice;
	
	@Getter @Setter
	private Long tollCharges;
	
	@Getter @Setter
	private Integer deliveryDays;
	
	@Getter @Setter
	private Integer applicationCharges;
	
	@Getter @Setter
	private Integer chargesHalt;
	
	@Getter @Setter
	private Integer otherCharges;
	
	@Getter @Setter
	private Integer totalCharges;
	
	@Getter @Setter
	private String radius;
	
	@Getter @Setter
	private Integer distance;
	
	@Getter @Setter
	private String bidLoadDesc;
			
}
