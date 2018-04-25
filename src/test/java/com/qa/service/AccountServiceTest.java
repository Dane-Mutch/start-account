package com.qa.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Account;
import com.qa.service.repository.AccountMapImplementation;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapImplementation service;
	private Account joeBloggs;
	private Account janeBloggs;
	private JSONUtil util;

	@Before
	public void init() {
		service = new AccountMapImplementation();
		joeBloggs = new Account("Joe", "Bloggs", 1336);
		janeBloggs = new Account("Jane", "Bloggs", 1337);
		util = new JSONUtil();
	}
	
		

	@Test
	public void addAndRemoveAccountTest() {
		service.addAccount(joeBloggs);
		Assert.assertEquals(service.getCountOfAccounts(), 1);
		service.addAccount(janeBloggs);
		Assert.assertEquals(service.getCountOfAccounts(), 2);
		service.removeAccount(1336);
		Assert.assertEquals(service.getCountOfAccounts(), 1);
		service.removeAccount(1337);
		Assert.assertEquals(service.getCountOfAccounts(), 0);
		service.removeAccount(5);
		Assert.assertEquals(service.getCountOfAccounts(), 0);
	}

	@Test
	public void accountConversionToJSONTest() {
		String emptyMap = util.getJSONForObject(service.getAccountMap().values());
		Assert.assertEquals("{}", emptyMap);
		String accountAsJSON = "{\"0\":{\"firstName\":\"Joe\",\"secondName\":\"Bloggs\",\"accountNumber\":\"1336\"},\"1\":{\"firstName\":\"Jane\",\"secondName\":\"Bloggs\",\"accountNumber\":\"1337\"}}";
		Assert.assertEquals("{}", emptyMap);
		service.addAccount(joeBloggs);
		service.addAccount(janeBloggs);
		String populatedAccountMap = util.getJSONForObject(service.getAccountMap().values());
		Assert.assertEquals(accountAsJSON, populatedAccountMap);
	}

	@Test
	public void editAccountLastNameTest () {
		String expectedValue = "Jeff";
		service.editAccountLastName(1336);
		String actualValue = service.getAccountMap().get(1336).getSecondName();
		Assert.assertEquals(expectedValue, actualValue);
		
		
		
	}

}
