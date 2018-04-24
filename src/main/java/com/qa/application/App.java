package com.qa.application;

import com.qa.domain.Account;
import com.qa.service.AccountMapImp;
import com.qa.util.JSONUtil;

public class App {

	public static void main(String[] args) {
		AccountMapImp service = new AccountMapImp();
		JSONUtil util = new JSONUtil();
		Account joeBloggs = new Account("Joe", "Bloggs", "1336");
		Account janeBloggs = new Account("Jane", "Bloggs", "1337");
		service.addAccountFromMap(joeBloggs);
		service.addAccountFromMap(janeBloggs);
		String mapAsJSON = util.getJSONForObject(service.getAccountMap());
		System.out.println("This is the account map as JSON " + mapAsJSON);

	}

}
