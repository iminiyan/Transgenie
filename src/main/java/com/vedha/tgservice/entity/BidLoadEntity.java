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


@Entity
@Table(name="bid_load_mst")
public class BidLoadEntity extends BasicEntity{
	
	private static final long serialVersionUID = 1L;
    
	
	@javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Long bidLoadID;
	
	@Getter @Setter
	private Long postLoadID;
	
	@Getter @Setter
	private Long transportID;
	
	@Getter @Setter
	private Long vehicleID;
	
	@OneToOne
	@JoinColumn(name="pickupPoint")
	@Getter @Setter
	private AddressEntity pickupPoint;
	
	@OneToOne
	@JoinColumn(name="deliveryPoint")
	@Getter @Setter
	private AddressEntity deliveryPoint;
	
	
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
