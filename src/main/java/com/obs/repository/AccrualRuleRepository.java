package com.obs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.obs.entity.AccrualRule;

public interface AccrualRuleRepository extends PagingAndSortingRepository<AccrualRule, Long>,CrudRepository<AccrualRule, Long>   {

}
