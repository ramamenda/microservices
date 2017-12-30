package com.rbank.olb.retail.model;

import java.util.List;

import com.rbank.domain.retail.model.Account;
import com.rbank.domain.retail.model.Customer;

public class AccountSummary {
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	private Customer customer;
	
	private List<Account> accounts;
}
