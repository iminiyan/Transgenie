package com.vedha.tgservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.vedha.tech.common.entity.BasicEntity;
@ToString
@Entity
@Table(name="product_mst")
public class ProductMstEntity extends BasicEntity{

	private static final long serialVersionUID = 1L;
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	@Column(unique=true, nullable=false)
	private Long productID;
	
	@Getter @Setter
	private String productName;
	
	@Getter @Setter
	private String productCategory;
	
	@Getter @Setter
	private String productDetails;
	
	@Getter @Setter
	private String productAdditonalInfo;
	
	
	@JoinColumn(name="shipID")
	@Getter @Setter
	private Long shipID;
	
}
