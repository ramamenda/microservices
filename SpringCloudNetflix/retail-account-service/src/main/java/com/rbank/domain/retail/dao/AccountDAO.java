package com.rbank.domain.retail.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rbank.domain.retail.model.Account;

@Component
public class AccountDAO {
	
	private static Map<String , Account> custMap = new HashMap<String, Account>();
	
	static {
		loadAccounts() ;
	}
	public Account getAccount(long accountId) {
		return custMap.get(String.valueOf(accountId));
	}
	
	 

	public static void loadAccounts() {
		Account acct1 = new Account();
		acct1.setAccountId(1234001);
		acct1.setAccontType("Savings");
		acct1.setAccontName("Abdul Savings Account");
		acct1.setAvailableBalance(50500.50);
		acct1.setCurrentBalance(50600.50);
		
		Account acct2 = new Account();
		acct2.setAccountId(1234003);
		acct2.setAccontType("Checking");
		acct2.setAccontName("Abdul Checking Account");
		acct2.setAvailableBalance(3500.50);
		acct2.setCurrentBalance(3550.50);
		
		Account acct3 = new Account();
		acct3.setAccountId(1234002);
		acct3.setAccontType("Savings");
		acct3.setAccontName("John's Savings Account");
		acct3.setAvailableBalance(40500.50);
		acct3.setCurrentBalance(40600.50);
		
		Account acct4 = new Account();
		acct4.setAccountId(1234002);
		acct4.setAccontType("Checking");
		acct4.setAccontName("John's Checking Account");
		acct4.setAvailableBalance(4500.50);
		acct4.setCurrentBalance(4600.50);
		
		custMap.put(String.valueOf(acct1.getAccountId()), acct1);
		custMap.put(String.valueOf(acct2.getAccountId()), acct2);
		custMap.put(String.valueOf(acct3.getAccountId()), acct3);
		custMap.put(String.valueOf(acct4.getAccountId()), acct4);
	}

}