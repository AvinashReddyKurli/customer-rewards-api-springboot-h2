package com.customer.rewards.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TRANSACTION_INFO")
public class TransactionInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_Id")
	private Long transactionId;

	@Column(name = "Amount")
	private BigDecimal amount;

	@Column(name = "Transaction_Date")
	private LocalDate transactionDate;

	@ManyToOne(optional = false)
	@JoinColumn(name = "Customer_Id", nullable = false)
	private CustomerRewards customerRewards;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public CustomerRewards getCustomerRewards() {
		return customerRewards;
	}

	public void setCustomerRewards(CustomerRewards customerRewards) {
		this.customerRewards = customerRewards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((customerRewards == null) ? 0 : customerRewards.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		TransactionInfo other = (TransactionInfo) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (customerRewards == null) {
			if (other.customerRewards != null)
				return false;
		} else if (!customerRewards.equals(other.customerRewards))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionInfo [transactionId=" + transactionId + ", amount=" + amount + ", transactionDate="
				+ transactionDate + ", customerRewards=" + customerRewards + "]";
	}

}
