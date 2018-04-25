package com.qa.service.business;

public interface AccountService {
	
		String findAllAccounts();

		String addAccount(String account);

		String updateAccount(int accountNumber, String account);

		String deleteAccount(int accountNumber);

}
