package com.rbank.olb.retail.services.accountsummary;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbank.olb.retail.model.AccountSummary;

@RestController
@Service
@Configuration
public class AccountSummaryService {
	
	private static final Logger LOG = Logger.getLogger(AccountSummaryService.class.getName());
	
	@Autowired
	AccountSummaryUtil accountSummaryUtil;

	@RequestMapping("/accountsummary")
	public AccountSummary getAccountSummary(@RequestParam(value="custId" , defaultValue="100") String custId) {
		LOG.info("******************  In AccountService.getAccountSummary() presentation tier begin *******");
		AccountSummary accountSummary = new AccountSummary();
		//AccountSummaryUtil accountSummaryUtil =  new AccountSummaryUtil(restTemplate, loadBalancerClient);
		accountSummary.setCustomer(accountSummaryUtil.getCustomer(custId));
		accountSummary.setAccounts(accountSummaryUtil.getAccounts(custId));
		LOG.info("******************  In AccountService.getAccountSummary() presentation tier end *******");
		return accountSummary;
	}
}
