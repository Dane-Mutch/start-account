package com.qa.application;

import com.qa.domain.Account;
import com.qa.service.repository.AccountMapImplementation;
import com.qa.util.JSONUtil;

public class App {

	public static void main(String[] args) {
		AccountMapImplementation service = new AccountMapImplementation();
		Account joeBloggs = new Account("Joe", "Bloggs", 1336);
		service.addAccount(joeBloggs);
		System.out.println(service.getAccountMap().toString());

	}

}
