package com.qa.service;

import java.util.List;


import static javax.transaction.Transactional.TxType.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDBImpl {

@PersistenceContext	(unitName = "primary")
private EntityManager em;

@Inject
private JSONUtil util;


	

	public String findAllAccounts() {
	TypedQuery<Account> query = em.createQuery("SELECT a FROM Account ORDER BY a.firstName DESC", Account.class);
	List <Account> resultsList = query.getResultList();
	return util.getJSONForObject(resultsList);
	}
	
	public Account findAccountByAccountNumber(String accountNumber) {
		return em.find(Account.class, accountNumber);
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String accountToAdd) {
		Account persistingAccount = util.getObjectForJSON(accountToAdd, Account.class);
		em.persist(persistingAccount);
		return "{\"message\": \"account successfully created\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(String accountNumber) {
		Account anAccount = findAccountByAccountNumber(accountNumber);
		if (anAccount != null) { 
			em.remove(anAccount);
		}
		return "{\"message\": \"account successfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String editAccountLastName(String accountNumber) {
		Account anAccount = findAccountByAccountNumber(accountNumber);
		if (anAccount != null ) {
		anAccount.setSecondName("File");
			em.merge(anAccount);
		}
		return "{\"message\": \"account successfully updated\"}";
		
	}
		
	


}
