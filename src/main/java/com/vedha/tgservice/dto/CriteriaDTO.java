package com.vedha.tgservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Basic Criteria bean for all the form search
 * @author MdAli
 *
 */

public class CriteriaDTO{
	
	@Getter @Setter
	private String vehicleType;
	
	@Getter @Setter
	private String owner;
	
}
