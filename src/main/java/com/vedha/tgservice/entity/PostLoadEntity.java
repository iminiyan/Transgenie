package com.vedha.tgservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vedha.tech.common.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name="post_load_mst")
public class PostLoadEntity extends BasicEntity{

	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(unique=true, nullable=false)
	@Getter @Setter
	private Long loadID;
	
	@Getter @Setter
	private Long custID;
    
	@OneToOne
	@JoinColumn(name="pickupPoint")
	@Getter @Setter
	private AddressEntity pickupPoint;
	
	@OneToOne
	@JoinColumn(name="deliveryPoint")
	@Getter @Setter
	private AddressEntity deliveryPoint;

	@Getter @Setter
	private String loadType;
	
	@Getter @Setter
	private Integer loadLength;
	
	@Getter @Setter
	private Integer loadWidth;
	
	@Getter @Setter
	private Integer loadHeight;
	
	@Getter @Setter
	private Integer loadWeight;

	@Getter @Setter
	private String loadDesc;
	
	@Getter @Setter
	private Character isCovered;
	
	@Getter @Setter
	private Integer distance;
	
	@Getter @Setter
	private String additionalInfo;
	
	@Getter @Setter
	private String contactName;
	
	@Getter @Setter
	private Long contactNum;
		
	@Getter @Setter
	private String contactEmail;
	
	@Getter @Setter
	private Character loadStatus;
	
	@Setter @Getter
	private Character overLoadStack;
	
	@Setter @Getter 
	private Long delayCharges;
	
	@Setter @Getter 
	private Date pickupDate;
	
	@Setter @Getter 
	private Date deliveryDate;
	
	
}
