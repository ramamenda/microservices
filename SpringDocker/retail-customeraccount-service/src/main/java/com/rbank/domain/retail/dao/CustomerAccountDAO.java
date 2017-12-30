package com.rbank.domain.retail.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rbank.domain.retail.model.Account;

@Component
public class CustomerAccountDAO {
	
	private static Map<String , List<Account>> custAccountsMap = new HashMap<String, List<Account> >();
	
	static {
		loadCustomerAccountsMap() ;
	}
	public List<Account> getAccounts(String custId) {
		return custAccountsMap.get(custId);
	}
	
	 

	public static void loadCustomerAccountsMap() {
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
		
		
		List<Account> abdulAccountList = new ArrayList<Account>();
		abdulAccountList.add(acct1);
		abdulAccountList.add(acct2);
		
		List<Account> johnsAccountList = new ArrayList<Account>();
		johnsAccountList.add(acct3);
		johnsAccountList.add(acct4);
		
		//Abduls customer id : 1000 
		//Johns customer id : 2000 
		custAccountsMap.put("1000", abdulAccountList);
		custAccountsMap.put("2000", johnsAccountList);
		 
	}

}