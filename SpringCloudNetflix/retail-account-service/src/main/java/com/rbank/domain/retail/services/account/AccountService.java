package com.rbank.domain.retail.services.account;

 

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbank.domain.retail.dao.AccountDAO;
import com.rbank.domain.retail.model.Account;



@RestController
@Service
@RequestMapping("/retailaccounts")

public class AccountService {
	
	private static final Logger LOG = Logger.getLogger(AccountService.class.getName());

	//@Autowired
	private AccountDAO accountDAO = new AccountDAO();
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	//Retrieve Account for given accountId
	@RequestMapping(method=RequestMethod.GET )
	public Account getAccount(@RequestParam("accountId" ) long accountId) {
		LOG.info("********** getAccount *********** begin/end ");
		return accountDAO.getAccount(accountId);
	}
	
}


