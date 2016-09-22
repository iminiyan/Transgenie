package com.vedha.tech.common.variable;

import java.math.BigDecimal;

public class Amount{

	 private String ccy;
	 private BigDecimal amnt;
	public Amount(String ccy, BigDecimal amnt) {
		this.ccy = ccy;
		this.amnt = amnt;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public BigDecimal getAmnt() {
		return amnt;
	}
	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}
	
	public BigDecimal getValue() {
		return amnt;
	}
}
