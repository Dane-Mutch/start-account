package com.qa.service.business;

import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.service.repository.AccountRepository;

public class AccountServiceImplementation implements AccountService {

	@Inject
	private AccountRepository repo;
	
	@Override
	public String findAllAccounts() {
		return repo.findAllAccounts();
	}

	@Override
	public String addAccount(String accountToAdd) {
		return repo.addAccount(accountToAdd);
	}
	@Override
	public String updateAccount(int accountNumber, String account) {
		return repo.updateAccount(accountNumber, account);
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return repo.removeAccount(accountNumber);

	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
