package com.qa.service.repository;

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
public class AccountDBImplementation implements AccountRepository {

@PersistenceContext	(unitName = "primary")
private EntityManager em;

@Inject
private JSONUtil util;


	

	public String findAllAccounts() {
	TypedQuery<Account> query = em.createQuery("SELECT a FROM Account ORDER BY a.firstName DESC", Account.class);
	List <Account> resultsList = query.getResultList();
	return util.getJSONForObject(resultsList);
	}
	
	public Account findAccountByAccountNumber(int accountNumber) {
		return (em.find(Account.class, accountNumber));
	}
	
	@Transactional(REQUIRED)
	public String addAccount(String accountToAdd) {
		Account persistingAccount = util.getObjectForJSON(accountToAdd, Account.class);
		em.persist(persistingAccount);
		return "{\"message\": \"account successfully created\"}";
	}
	
	@Transactional(REQUIRED)
	public String removeAccount(int accountNumber) {
		Account anAccount = util.getObjectForJSON(findAccountByAccountNumber(accountNumber), Account.class);
		if (anAccount != null) { 
			em.remove(anAccount);
		}
		return "{\"message\": \"account successfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber, String account) {
		Account anAccount = util.getObjectForJSON(findAccountByAccountNumber(accountNumber), Account.class);
		if (anAccount != null ) {
		anAccount.setSecondName("File");
			em.merge(anAccount);
		}
		return "{\"message\": \"account successfully updated\"}";
		
	}
		
	


}
