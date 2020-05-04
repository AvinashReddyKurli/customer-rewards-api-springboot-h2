package com.customer.rewards.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.customer.rewards.model.TransactionInfo;
import com.customer.rewards.service.CustomerRewardsServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = CustomerRewardsServiceImpl.class)})
public class TransactionRepositoryTest {
	
	@Autowired
    TransactionRepository transactionRepository;
	
	 @Test
	 public void testCustomerInfoRepositoryGetByIdRepo() {

		 List<TransactionInfo> transaction = transactionRepository.findCustomersByCustomerId(101L);
	        assertNotNull(transaction);
	       
	    }

	 @Test
	 public void testCustomerInfoRepositoryGetAllRepo() {

		 List<Long> customers = transactionRepository.findCustomers();
	        assertNotNull(customers);
	       
	    }
}
