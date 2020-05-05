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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customersRewardCalculator")
public class CustomerRewardsController {
	
	@Autowired
	private CustomerRewardsService customerRewardsService;
	
	@Autowired
    private CustomerInfoRepository customerInfoRepository;
	
	@ApiOperation(value = "Customer rewards API GetMonthlyTransactionRewards", notes = "Returns error response.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = CustomerRewardsResponse.class),
			@ApiResponse(code = 400, message = "Invalid request. Request would return too many results. "
					+ "Please provide filter criteria.", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@GetMapping("/rewards")
	public List<CustomerRewardsResponse> GetMonthlyTransactionRewards() {
		
		
		
		return customerRewardsService.calculateRewardsforAllCustomers();
		
	}
	
	@ApiOperation(value = "Customer rewards API GetMonthlyTransactionRewardsbyCustomerId", notes = "Returns error response.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = CustomerRewardsResponse.class),
			@ApiResponse(code = 400, message = "Invalid request. Request would return too many results. "
					+ "Please provide filter criteria.", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") })
	@GetMapping("/rewards/{customerId}")
	public CustomerRewardsResponse GetMonthlyTransactionRewardsbyCustomerId(@PathVariable("customerId") Long customerId) {
		
		
		
		return customerRewardsService.calculateRewardsforaCustomer(customerId);
		
	}
}
