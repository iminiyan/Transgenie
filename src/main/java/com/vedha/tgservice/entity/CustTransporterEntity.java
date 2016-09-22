package com.vedha.tgservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.vedha.tech.common.entity.BasicEntity;

@Entity
@Table(name="cust_transporter")
public class CustTransporterEntity extends BasicEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long transID;
	
	
	@Getter @Setter
	private Long custID;
	
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
	
	@OneToMany
	@JoinColumn(name="transID")
	@Getter @Setter
	private List<VehicleMstEntity> vehicleList;

}
