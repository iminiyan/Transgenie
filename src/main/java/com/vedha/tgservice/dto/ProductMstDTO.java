package com.vedha.tgservice.dto;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.dto.BasicDTO;


public class ProductMstDTO  extends BasicDTO{
	
	private static final long serialVersionUID = 1L;

	@Getter @Setter
    private Long productID;
	
	@Getter @Setter
	private String productName;
	
	@Getter @Setter
	private String productCategory;
	
	@Getter @Setter
	private String productDetails;
	
	@Getter @Setter
	private String productAdditonalInfo;

}
