package com.customer.rewards.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MonthlyReward {

	private String month;
	private Integer year;
	private Long rewards;

	private BigDecimal monthlyAmount;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getRewards() {
		return rewards;
	}

	public void setRewards(Long rewards) {
		this.rewards = rewards;
	}

	public BigDecimal getMonthlyAmount() {
		return monthlyAmount;
	}

	public void setMonthlyAmount(BigDecimal monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((monthlyAmount == null) ? 0 : monthlyAmount.hashCode());
		result = prime * result + ((rewards == null) ? 0 : rewards.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		MonthlyReward other = (MonthlyReward) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (monthlyAmount == null) {
			if (other.monthlyAmount != null)
				return false;
		} else if (!monthlyAmount.equals(other.monthlyAmount))
			return false;
		if (rewards == null) {
			if (other.rewards != null)
				return false;
		} else if (!rewards.equals(other.rewards))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonthlyReward [month=" + month + ", year=" + year + ", rewards=" + rewards + ", monthlyAmount="
				+ monthlyAmount + "]";
	}

}
