package com.vedha.tgservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.vedha.tech.common.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="permit_type_mst")
public class PermitEntity extends BasicEntity {
	
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long permitTypeId;
	
	@Setter @Getter
	private String permitTypeName;
	
	@Setter @Getter
	private String permitTypeDesc;
	
	@Setter @Getter
	private Date permitValidDate;
	
	
}
