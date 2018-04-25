package com.qa.service.repository;

import com.qa.domain.Account;

public interface AccountRepository {
	
	public String addAccount(Account accountToAdd);
	
	public String removeAccount(int accountNumber);
	
	public String findAllAccounts();
	
	public Account findAccountByAccountNumber(int accountNumber);
	
	public String editAccountLastName(int accountNumber);


}
