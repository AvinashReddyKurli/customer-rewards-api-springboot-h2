package com.customer.rewards.service;

import java.util.List;

import com.customer.rewards.model.CustomerRewards;
import com.customer.rewards.model.CustomerRewardsResponse;
import com.customer.rewards.model.TransactionInfo;

public interface CustomerRewardsService {
	
	CustomerRewardsResponse calculateRewardsforaCustomer(Long customerId);
	List<CustomerRewardsResponse> calculateRewardsforAllCustomers();

}
