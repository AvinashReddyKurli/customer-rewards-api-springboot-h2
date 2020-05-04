package com.customer.rewards.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.customer.rewards.model.CustomerRewardsResponse;
import com.customer.rewards.service.CustomerRewardsService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRewardsControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CustomerRewardsService customerRewardsService;

	@Mock
	private ResponseEntity<List<CustomerRewardsResponse>> response;

	@Mock
	private CustomerRewardsResponse customerRewardsResponse;

	@InjectMocks
	CustomerRewardsController customerRewardsController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerRewardsController).build();

	}

	@DisplayName("Test SpringBoot @GetMonthlyTransactionRewardsbyCustomerId")
	@Test
	public void testGetMonthlyTransactionRewardsbyCustomerId(Long customerId) throws Exception {
		CustomerRewardsResponse customerRewardsResponse = new CustomerRewardsResponse();

		when(customerRewardsService.calculateRewardsforaCustomer(customerId)).thenReturn(customerRewardsResponse);
		this.mockMvc.perform(get("/{customerId}/rewards")).andExpect(status().isOk());

	}

	@DisplayName("Test SpringBoot @GetMonthlyTransactionRewardsbyCustomerIdIfResponseNull")
	@Test
	public void testGetMonthlyTransactionRewardsbyCustomerIdIfResponseNull(Long customerId) throws Exception {
		CustomerRewardsResponse rewards = null;
		when(customerRewardsService.calculateRewardsforaCustomer(customerId)).thenReturn(rewards);
		this.mockMvc.perform(get("/{customerId}/rewards")).andExpect(status().isNotFound());
		
	}
	
	@SuppressWarnings("unchecked")
	@DisplayName("Test SpringBoot @GetMonthlyTransactionRewards")
	@Test
	public void testGetMonthlyTransactionRewards() throws Exception {
		CustomerRewardsResponse customerRewardsResponse = new CustomerRewardsResponse();

		when(((OngoingStubbing<CustomerRewardsResponse>) customerRewardsService.calculateRewardsforAllCustomers()).thenReturn(customerRewardsResponse));
		this.mockMvc.perform(get("/rewards")).andExpect(status().isOk());

	}

	@SuppressWarnings("unchecked")
	@DisplayName("Test SpringBoot @GetMonthlyTransactionRewardsbyCustomerIdIfResponseNull")
	@Test
	public void testGetMonthlyTransactionRewardsIfResponseNull(Long customerId) throws Exception {
		CustomerRewardsResponse rewards = null;
		when(((OngoingStubbing<CustomerRewardsResponse>) customerRewardsService.calculateRewardsforAllCustomers()).thenReturn(rewards));
		this.mockMvc.perform(get("/rewards")).andExpect(status().isNotFound());
		
	}
}
