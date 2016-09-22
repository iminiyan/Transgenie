package com.vedha.tgservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.vedha.tech.common.constants.CustomerStatus;
import com.vedha.tech.common.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cust_signup")
public class SignUpEntity extends BasicEntity {
	
	
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	@Getter @Setter
	private Long custID;
	
	@Setter @Getter
	private Character custType;
	
	@Setter @Getter
	private String companyName;
	
	@Setter @Getter
	private String email;
	
	@Setter @Getter
	private String password;
	
	@Setter @Getter
	private String firstName;
	
	@Setter @Getter
	private String lastName;
	
	@Setter @Getter
	private Integer countryCode;
	
	@Setter @Getter
	private Long phoneNum;
	
	@Setter @Getter
	private CustomerStatus status;
	
	
}
