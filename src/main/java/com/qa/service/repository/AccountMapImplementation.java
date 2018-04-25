package com.qa.service.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

	public class AccountMapImplementation implements AccountRepository {

		private Map<Integer, Account> accountMap;

		private int count = 0;
		
		private Account account;
		
		@Inject
		private JSONUtil util; 

		
		public void AccountMapImp() {
			accountMap = new HashMap<Integer, Account>();
		}
		
		public String addAccount(String accountToAdd) {
			accountMap.put(account.getAccountNumber(), userAccount);
			count++;
			return "{\"message\": \"account successfully created\"}";
		}
		
		public String removeAccount(int accountNumber) {
			boolean countExists = accountMap.containsKey(accountNumber);
			if (countExists) {
				accountMap.remove(accountNumber);
				return "{\"message\": \"account successfully deleted\"}";
			} else { 
				return "{\"message\": \"account not found\"}";
			}
		}
		
		public int getCountOfAccounts() {
			return accountMap.size();
			
		}
		
		public String returnAllAccountsAsJSON() {
			Collection <Account> accountsCollection = accountMap.values();
			return util.getJSONForObject(accountsCollection);
		}
		
		public String updateAccount (int accountNumber) {
			boolean countExists = accountMap.containsKey(accountNumber);
			if (countExists) {
				accountMap.get(accountNumber).setSecondName("Jeff"); 
				return "{\"message\": \"account last name successfully edited\"}";
			} else {
				return "{\"message\": \"account not found\"}";
			}
			
		}
		
		public Account findAccountByAccountNumber(int accountNumber) {
			return accountMap.get(accountNumber);
			
		}

		public Map<Integer, Account> getAccountMap() {
			return accountMap;
		}
		
		
			
}


