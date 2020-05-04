package com.customer.rewards.repository;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rewards.service.CustomerRewardsServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = CustomerRewardsServiceImpl.class)})
public class CustomerInfoRepositoryTest {
	

	    @Autowired
	    CustomerInfoRepository customerInfoRepository;

	
	    @Test
	    public void testCustomerInfoRepositoryRepo() {

	    	String customerName = customerInfoRepository.findCustomerNameByCustomerId(101L);
	        assertNotNull(customerName);
	       
	    }

}
