package com.rbank.domain.retail.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rbank.domain.retail.model.Address;
import com.rbank.domain.retail.model.Customer;

@Component
public class CustomerDAO {
	
	private static Map<String , Customer> custMap = new HashMap<String, Customer>();
	static {
		loadCustomers() ;
	}
	public Customer getCustomer(String custId) {
		return custMap.get(custId);
	}
	
	public List<Customer> getCustomers() {
		return new ArrayList<Customer> (custMap.values());
	}

	public static void loadCustomers() {
		Customer cust1 = new Customer();
		cust1.setCustomerId("1000");
		cust1.setFirstName("Abdul");
		cust1.setLastName("Kalam");
		Address cust1Address = new Address();
		cust1Address.setHouseNumber("100");
		cust1Address.setStreetAddress("Magnolia Woods Ln");
		cust1Address.setCity("Charlotte");
		cust1.setAddress(cust1Address);
		
		Customer cust2 = new Customer();
		cust2.setCustomerId("2000");
		cust2.setFirstName("John");
		cust2.setLastName("Doe");
		Address cust2Address = new Address();
		cust2Address.setHouseNumber("100");
		cust2Address.setStreetAddress("Northbend Dr");
		cust2Address.setCity("Charlotte");
		cust2.setAddress(cust2Address);
		
		custMap.put(cust1.getCustomerId(), cust1);
		custMap.put(cust2.getCustomerId(), cust2);
	}

}