package com.obs.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.obs.entity.AccrualRule;
import com.obs.repository.AccrualRuleRepository;

@Service
public class AccrualRuleService {

	@Autowired
	private AccrualRuleRepository arRepo ;
	private AccrualRule acrule;
	
	public Page<AccrualRule> getAccrualRule(int value1,int value2) {
		return arRepo.findAll(new PageRequest(value1,value2));
		
	}
	public AccrualRule getAccrualByRule(Long accrualRuleSeqNumber) {
	
	return 	arRepo.findOne(accrualRuleSeqNumber);
	
	}
	public AccrualRule getAddedAccuralRule(AccrualRule acrule) {
		return 	arRepo.save(acrule);
	}
	public void deleteAccuralRule(Long accrualRuleSeqNumber) {
			arRepo.delete(accrualRuleSeqNumber);
	}
	public AccrualRule updateAccuralRule(AccrualRule accrualRule,Long accrualRuleSeqNumber) {
		
		AccrualRule accrualRuleSer = arRepo.findOne(accrualRuleSeqNumber);
		
		accrualRuleSer.setContractingparty(accrualRule.getContractingparty());
		accrualRuleSer.setContract(accrualRule.getContract());
		accrualRuleSer.setEndUser(accrualRule.getEndUser());
		accrualRuleSer.setStatus(accrualRule.getStatus());
		accrualRuleSer.setIsdeleted(accrualRule.getIsdeleted());
		accrualRuleSer.setUpdatedDate(accrualRule.getUpdatedDate());
		return arRepo.save(accrualRuleSer);
}


	



	
	

}
