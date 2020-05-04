package com.customer.rewards.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.model.CustomerRewardsResponse;
import com.customer.rewards.model.MonthlyReward;
import com.customer.rewards.model.TransactionInfo;
import com.customer.rewards.repository.CustomerInfoRepository;
import com.customer.rewards.repository.TransactionRepository;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {
	      private static final Long FIFTY = 50L;
		
		private static final Long HUNDRED = 100L;
		

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerInfoRepository customerInfoRepository;

	@Override
	public CustomerRewardsResponse calculateRewardsforaCustomer(Long customerId) {


		List<TransactionInfo> transaction = transactionRepository.findCustomersByCustomerId(customerId);
		CustomerRewardsResponse customerRewards = new CustomerRewardsResponse();
		customerRewards.setCustomerId(customerId);
		customerRewards.setCustomerName(customerInfoRepository.findCustomerNameByCustomerId(customerId));
		
		MonthlyReward monthlyReward = new MonthlyReward();
		customerRewards.setMonthlyReward(new ArrayList<>());

		String currentMonth = "";
		Long rewards = 0L;
		Long monthlyTotalRewards = 0L;
		

		for (TransactionInfo transactionInfo : transaction) {
			String monthName = transactionInfo.getTransactionDate().getMonth().name();
			
			if(customerRewards.getTotalTransactionAmount()!=null) {
				customerRewards.setTotalTransactionAmount(customerRewards.getTotalTransactionAmount().add(transactionInfo.getAmount()));
				
			} else {
				customerRewards.setTotalTransactionAmount(transactionInfo.getAmount());
			}


			if (StringUtils.isBlank(currentMonth)) {
				
				monthlyReward.setMonth(monthName);
				monthlyReward.setYear(transactionInfo.getTransactionDate().getYear());
				monthlyReward.setMonthlyAmount(transactionInfo.getAmount());
				rewards = RewardsCalculator(rewards, monthlyReward);
				currentMonth = monthName;
				monthlyTotalRewards = rewards;
				monthlyReward.setRewards(rewards);
				
				
			} else if (currentMonth.equals(monthName)) {
				monthlyReward.setMonthlyAmount(monthlyReward.getMonthlyAmount().add(transactionInfo.getAmount()));
				rewards = 0L;
				rewards = RewardsCalculator(rewards, monthlyReward);
				monthlyTotalRewards += rewards;
				monthlyReward.setRewards(rewards);
				
			} else {
				customerRewards.getMonthlyReward().add(monthlyReward);
				monthlyReward = new MonthlyReward();
				monthlyReward.setMonth(monthName);
				monthlyReward.setYear(transactionInfo.getTransactionDate().getYear());
				monthlyReward.setMonthlyAmount(transactionInfo.getAmount());
				rewards = 0L;
				rewards = RewardsCalculator(rewards, monthlyReward);
				monthlyTotalRewards += rewards;
				monthlyReward.setRewards(rewards);
				currentMonth = monthName;
				

			}

		}
		customerRewards.setTotalRewards(monthlyTotalRewards);
		customerRewards.getMonthlyReward().add(monthlyReward);
		return customerRewards;
	}

	private Long RewardsCalculator(Long rewards, MonthlyReward monthlyReward) {
		if(monthlyReward.getMonthlyAmount().longValue() > HUNDRED) {
			rewards += (monthlyReward.getMonthlyAmount().longValue() - HUNDRED) * 2;
			
		} else if(monthlyReward.getMonthlyAmount().longValue()> FIFTY && monthlyReward.getMonthlyAmount().longValue()<= HUNDRED) {
			rewards += (monthlyReward.getMonthlyAmount().longValue() - FIFTY) * 1;
		}
		return rewards;
	}
	
	@Override
	public List<CustomerRewardsResponse> calculateRewardsforAllCustomers() {
		
		List<Long> transaction = transactionRepository.findCustomers();
		List<CustomerRewardsResponse> custRew = new ArrayList<CustomerRewardsResponse>();
		List<CustomerRewardsResponse> response = new ArrayList<CustomerRewardsResponse>();
		CustomerRewardsResponse customerRewards = new CustomerRewardsResponse();
		for(Long trans : transaction) {
			customerRewards =calculateRewardsforaCustomer(trans);
			custRew.add(customerRewards);
		}
		response.addAll(custRew);
	
		
		return response;
	}
}
