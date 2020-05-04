package com.customer.rewards.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.rewards.model.TransactionInfo;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<TransactionInfo, Long> {

	@Query("Select a " + " from TransactionInfo a "
            + " where a.customerRewards.customerId =:customerId order by transactionDate desc ")
	List<TransactionInfo> findCustomersByCustomerId(@Param("customerId") Long customerId);
	
	@Query("Select distinct a.customerRewards.customerId " + " from TransactionInfo a " + " join CustomerRewards b"
            + " on a.customerRewards.customerId =b.customerId ")
	List<Long> findCustomers();
}
