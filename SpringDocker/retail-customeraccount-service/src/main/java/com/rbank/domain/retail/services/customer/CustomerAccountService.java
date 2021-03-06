package com.rbank.domain.retail.services.customer;

 

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbank.domain.retail.dao.CustomerAccountDAO;
import com.rbank.domain.retail.model.Account;

@Service
@RestController
@RequestMapping("/retailcustomers")
public class CustomerAccountService {
	
	private static final Logger LOG = Logger.getLogger(CustomerAccountService.class.getName());
	
	//@Autowired
	private CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
	
	public void setCustomerAccountDAO(CustomerAccountDAO customerAccountDAO) {
		
		this.customerAccountDAO = customerAccountDAO;
	}
	
	//Retrieve matching accounts for the given custId
	@RequestMapping("/{custId}/accounts")
	public List<Account> getAccounts(@PathVariable(value="custId" ) String custId) {
		LOG.info("********** getAccounts *********** begin/end ");
		return  customerAccountDAO.getAccounts(custId); 
	}

}


