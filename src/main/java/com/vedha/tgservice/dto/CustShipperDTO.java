package com.vedha.tgservice.dto;

import java.util.Date;
import java.util.List;

import com.vedha.tech.common.dto.BasicDTO;

import lombok.Getter;
import lombok.Setter;

public class CustShipperDTO extends BasicDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Long shipID;
	
	@Getter @Setter
	private Long  custID;
	
	@Setter @Getter
	private String website;
	
	@Setter @Getter
	private Date estdOnDate;
	
	@Setter @Getter
	private String addressLine1;
	
	@Setter @Getter
	private String addressLine2;
	
	@Setter @Getter
	private String area;
	
	@Setter @Getter
	private Long stateID;
	
	@Setter @Getter
	private String city;
	
	@Setter @Getter
	private String district;
	
	@Setter @Getter
	private Integer pincode;
	
	@Setter @Getter
	private Character serviceTaxType;
	
	@Setter @Getter
	private Integer serviceTaxValue;
	
	@Setter @Getter
	private String panNum;
	
	@Setter @Getter
	private String tinNum;
	
	@Getter @Setter
	private String companyName;
	
	@Getter @Setter
	private List<ProductMstDTO> productList;
	
}
