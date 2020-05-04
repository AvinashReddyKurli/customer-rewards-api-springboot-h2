package com.customer.rewards.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.rewards.model.CustomerRewards;
import com.customer.rewards.model.TransactionInfo;

@Repository
@Transactional
public interface CustomerInfoRepository extends CrudRepository<CustomerRewards, Long>{

	
	List<CustomerRewards> findByCustomerId(Long customerId);
	
	@Query("Select a.customerName " + "from CustomerRewards a "
            + " where a.customerId =:customerId")
	String findCustomerNameByCustomerId(@Param("customerId") Long customerId);

}