package com.customer.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.model.CustomerRewardsResponse;
import com.customer.rewards.repository.CustomerInfoRepository;
import com.customer.rewards.service.CustomerRewardsService;

@RestController
@RequestMapping("/customersRewardCalculator")
public class CustomerRewardsController {
	
	@Autowired
	private CustomerRewardsService customerRewardsService;
	
	@Autowired
    private CustomerInfoRepository customerInfoRepository;
	
	
	@GetMapping("/rewards")
	
	public List<CustomerRewardsResponse> GetMonthlyTransactionRewards() {
		
		
		
		return customerRewardsService.calculateRewardsforAllCustomers();
		
	}
	
	@GetMapping("/rewards/{customerId}")
	public CustomerRewardsResponse GetMonthlyTransactionRewardsbyCustomerId(@PathVariable("customerId") Long customerId) {
		
		
		
		return customerRewardsService.calculateRewardsforaCustomer(customerId);
		
	}
}
