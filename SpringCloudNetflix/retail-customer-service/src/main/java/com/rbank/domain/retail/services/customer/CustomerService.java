package com.rbank.domain.retail.services.customer;

 

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbank.domain.retail.dao.CustomerDAO;
import com.rbank.domain.retail.model.Account;
import com.rbank.domain.retail.model.Customer;

@Service
@RestController
@RequestMapping("/retailcustomers")
public class CustomerService {
	private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());
	
	//@Autowired
	private CustomerDAO customerDAO = new CustomerDAO();
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	//Retrieve all Customers
	@RequestMapping(method=RequestMethod.GET )
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers() ;
	}
	
	//Retrieve Customer for given custId
	@RequestMapping(value="/{custId}" , method=RequestMethod.GET )
	public Customer getCustomer(@PathVariable(value="custId" ) String custId) {
		LOG.info("********** getCustomer *********** begin/end ");
		return customerDAO.getCustomer(custId);
	}
	
	//Retrieve matching accounts for the given custId
	@RequestMapping("/{custId}/accounts")
	public List<Account> getAccounts(@PathVariable(value="custId" ) String custId) {
		LOG.info("********** getAccounts *********** begin/end ");
		Customer cust = customerDAO.getCustomer(custId);
		if(cust != null) {
			return cust.getAccounts();
		}
		return null ;
	}

}


