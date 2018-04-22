package com.obs.entity;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PG_ACCRUAL_RULE_MASTER")
//Define a sequence - might also be in another class:
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@JsonIgnoreProperties(value = {"updatedDate"})
public class AccrualRule{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="AR_SEQ_NUMBER")
	private Long accrualRuleSeqNumber;
	
	@Column(name="AR_CONTRACTING_PARTY_FK")
	private String contractingparty;	
	
	@Column(name="AR_CONTRACT_NUMBER_FK")
	private long contract;
	
	@Column(name="AR_END_USER_FK")
	private String endUser;
	
	@Column(name="AR_ACTIVE")
	private Boolean status;
	
	@Column(name="AR_IS_DELETED")
	private Boolean isdeleted;
	
	@Column(name="AR_UPDATED_BY")
	private String updatedBy;
	
	@Column(name="AR_LAST_UPDATED")
	private Date updatedDate;
	
	//private Set<AccrualRuleFPC> fpcs = new HashSet<>(0);
	
	public AccrualRule(){}

	public AccrualRule(String contractingparty, long contract, String endUser, Boolean status, Boolean isdeleted,
			String updatedBy,Date updatedDate ) {
	
		super();
		this.contractingparty = contractingparty;
		this.contract = contract;
		this.endUser = endUser;
		this.status = status;
		this.isdeleted = isdeleted;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public long getAccrualRuleSeqNumber() {
		return accrualRuleSeqNumber;
	}

	public void setAccrualRuleSeqNumber(long accrualRuleSeqNumber) {
		this.accrualRuleSeqNumber = accrualRuleSeqNumber;
	}

	public String getContractingparty() {
		return contractingparty;
	}

	public void setContractingparty(String contractingparty) {
		this.contractingparty = contractingparty;
	}

	public long getContract() {
		return contract;
	}

	public void setContract(long contract) {
		this.contract = contract;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
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
	
	/** minimal constructor */
	public AccrualRule(long accrualRuleSeqNumber) {
	   this.accrualRuleSeqNumber = accrualRuleSeqNumber;
	}
	
	@Override
    public String toString() {
        return "content{" +
                "accrualRuleSeqNumber=" + accrualRuleSeqNumber +
                ", contractingparty='" + contractingparty + '\'' +
                ", contract='" + contract + '\'' +
                  ", endUser='" + endUser + '\'' +
                    ", status='" + status + '\'' +
                      ", isdeleted='" + isdeleted + '\'' +
                        ", updatedBy='" + updatedBy + '\'' +
                        ", updatedDate='" +updatedDate+'\''+
                         
                '}';
    }
	
}
