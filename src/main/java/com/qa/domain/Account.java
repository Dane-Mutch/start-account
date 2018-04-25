package com.qa.domain;

import javax.persistence.*;

@Entity
@Table (name="Account")
public class Account {
	
	
	@Column(length=50)
	private String firstName;
	@Column(length=50)
	private String secondName;
	@Id
	private int accountNumber;
	
	
	
	public Account(String firstName, String secondName, int accountNumber) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
