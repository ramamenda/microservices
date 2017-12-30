package com.rbank.olb.retail.services.accountsummary;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rbank.domain.retail.model.Account;
import com.rbank.domain.retail.model.Customer;

@Service
public class AccountSummaryUtil {

	private static final Logger LOG = Logger.getLogger(AccountSummaryUtil.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	/*public AccountSummaryUtil(RestTemplate rest , LoadBalancerClient loadBalancerClient) {
		this.restTemplate = rest;
		this.loadBalancerClient=loadBalancerClient;
	}*/

	@HystrixCommand(fallbackMethod = "getCustomerFallbackMethod")
	public Customer getCustomer(String custId) {
		LOG.info("********** getCustomer *********** begin ");
		if("0".equals(custId)) {
			throw new RuntimeException("No Record found");
		}
			
		String customerDomainServiceName = "retail-customer";
		ServiceInstance serviceInstance = loadBalancerClient.choose(customerDomainServiceName);
		String baseUrl = serviceInstance.getUri().toString();
		String url = baseUrl + "/retailcustomers/" + custId;
		URI uri = URI.create(url);
		LOG.info("********** getCustomer *********** end ");
		return this.restTemplate.getForObject(uri, Customer.class);
	}

	@HystrixCommand(fallbackMethod = "getAccountsFallbackMethod")
	public List<Account> getAccounts(String custId) {
		LOG.info(" ----------- in AccountSummaryUtil.getAccounts() ---------------------");
		if("0".equals(custId)) {
			throw new RuntimeException("No Record found");
		}
		String customerAccountsDomainServiceName = "retail-customeraccount";
		ServiceInstance serviceInstance = loadBalancerClient.choose(customerAccountsDomainServiceName);
		String baseUrl = serviceInstance.getUri().toString();
		String url = baseUrl + "/retailcustomers/" + custId + "/accounts";
		LOG.info("URL : " + url);
		URI uri = URI.create(url);
		LOG.info(" ----------- in AccountSummaryUtil.getAccounts() ---------------------");
		return this.restTemplate.getForObject(uri, List.class);
	}

	public Customer getCustomerFallbackMethod(String custId) {
		LOG.info(" ----------- in AccountSummaryUtil.getCustomerFallbackMethod() ---------------------");
		return new Customer();
	}

	public List<Account> getAccountsFallbackMethod(String custId) {
		LOG.info(" ----------- in AccountSummaryUtil.getAccountsFallbackMethod() ---------------------");
		return new ArrayList<Account>();
	}
}
