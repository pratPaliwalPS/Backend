package com.obs.entity;

import java.util.Date;

public class AccrualRuleFPC implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String product;
	private Boolean bookable;
	private Boolean commisionable;
	private String updatedBy;
    private Date updatedDate;
	private long accrualRuleFPCSeqNumber;
	private AccrualRule accrualRule ;
	private Boolean isdeleted;
	
	
	public AccrualRuleFPC() {
		// TODO Auto-generated constructor stub
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public Boolean getBookable() {
		return bookable;
	}


	public void setBookable(Boolean bookable) {
		this.bookable = bookable;
	}


	public Boolean getCommisionable() {
		return commisionable;
	}


	public void setCommisionable(Boolean commisionable) {
		this.commisionable = commisionable;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public long getAccrualRuleFPCSeqNumber() {
		return accrualRuleFPCSeqNumber;
	}


	public void setAccrualRuleFPCSeqNumber(long accrualRuleFPCSeqNumber) {
		this.accrualRuleFPCSeqNumber = accrualRuleFPCSeqNumber;
	}


	public AccrualRule getAccrualRule() {
		return accrualRule;
	}


	public void setAccrualRule(AccrualRule accrualRule) {
		this.accrualRule = accrualRule;
	}


	public Boolean getIsdeleted() {
		return isdeleted;
	}


	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}


	public AccrualRuleFPC(String product, Boolean bookable, Boolean commisionable, String updatedBy, Date updatedDate,
			AccrualRule accrualRule, Boolean isdeleted) {
		super();
		this.product = product;
		this.bookable = bookable;
		this.commisionable = commisionable;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.accrualRule = accrualRule;
		this.isdeleted = isdeleted;
	}

}
