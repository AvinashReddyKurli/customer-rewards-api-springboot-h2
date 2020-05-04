package com.customer.rewards.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerRewardsResponse {

	private Long customerId;
	private String customerName;
	private Long totalRewards;
	private List<MonthlyReward> monthlyReward;

	private BigDecimal totalTransactionAmount;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(Long totalRewards) {
		this.totalRewards = totalRewards;
	}

	public List<MonthlyReward> getMonthlyReward() {
		return monthlyReward;
	}

	public void setMonthlyReward(List<MonthlyReward> monthlyReward) {
		this.monthlyReward = monthlyReward;
	}

	public BigDecimal getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(BigDecimal totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((monthlyReward == null) ? 0 : monthlyReward.hashCode());
		result = prime * result + ((totalRewards == null) ? 0 : totalRewards.hashCode());
		result = prime * result + ((totalTransactionAmount == null) ? 0 : totalTransactionAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRewardsResponse other = (CustomerRewardsResponse) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (monthlyReward == null) {
			if (other.monthlyReward != null)
				return false;
		} else if (!monthlyReward.equals(other.monthlyReward))
			return false;
		if (totalRewards == null) {
			if (other.totalRewards != null)
				return false;
		} else if (!totalRewards.equals(other.totalRewards))
			return false;
		if (totalTransactionAmount == null) {
			if (other.totalTransactionAmount != null)
				return false;
		} else if (!totalTransactionAmount.equals(other.totalTransactionAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerRewardsResponse [customerId=" + customerId + ", customerName=" + customerName
				+ ", totalRewards=" + totalRewards + ", monthlyReward=" + monthlyReward + ", totalTransactionAmount="
				+ totalTransactionAmount + "]";
	}

}
