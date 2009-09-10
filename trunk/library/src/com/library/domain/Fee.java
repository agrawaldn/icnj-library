/**
 * Created by: dagrawal on Sep 9, 2009
 * Email: dagrawal@research.att.com
 */
package com.library.domain;

public class Fee extends DomainVO {
	
	private static final long serialVersionUID = 1L;
	private double amount;
	private String feeType;
	private char paid;
	private String paymentMethod;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public char getPaid() {
		return paid;
	}
	public void setPaid(char paid) {
		this.paid = paid;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
}
