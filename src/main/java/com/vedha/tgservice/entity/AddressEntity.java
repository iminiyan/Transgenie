package com.vedha.tgservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.vedha.tech.common.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name="address")
public class AddressEntity extends BasicEntity{
	

	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long addressID;
	
	@Getter @Setter
	private String doorNum;
	
	@Getter @Setter
	private String plotNum;
	
	@Getter @Setter
	private String streetName;
	
	@Getter @Setter
	private String landMark;
	
	@Getter @Setter
	private String areaName;
	
	@Getter @Setter
	private String districtName;
	
	@Getter @Setter
	private String stateName;
	
	@Getter @Setter
	private Long pincode;
	
	/*@OneToOne
	@JoinColumn(name="loadID")
	@Getter @Setter
	private PostLoadEntity loadID;*/
	
}
