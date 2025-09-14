package com.bank.core;

import com.bank.custom_exceptions.*;
import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount>{
	private int accountNumber;
	private double balance;
	private String customerName;
	private String phoneNo;
	private LocalDate dob;
	private AccountType accountType;

	public BankAccount(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	// add date for dob
	public BankAccount(int accountNumber, AccountType accountType, String customerName, double balance,
			String phoneNo,LocalDate dob) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customerName = customerName;
		this.balance = balance;

		this.phoneNo = phoneNo;
		this.dob = dob;
	}

	public void deposit(double amount) throws BankCustomException {
		// deposit code
		// if amount less than  0 throw error:
//		if(amount<0) {
//			throw new BankCustomException("deposit fail!!");
//		}
		this.balance += amount;
		System.out.println("Deposited successfully!!");

	}

	public void withdraw(double amount) throws BankCustomException {
		// withdraw amount: apply condition for negative balance
		// throw exception for negative balance
//		if (amount <= balance) {
//			this.balance -= amount;
//			System.out.println("Withdraw successfully!!");
//		} else {
//			// throw
//			System.out.println("Insufficient balance to withdraw!!");
//		}
		this.balance -= amount;
		System.out.println("Withdraw successfully!!");

	}

	public String toString() {
		return  "Account summary: \n Account Number:"+accountNumber+" Account type"+accountType+" customerName:"+customerName+" Balance:"+balance+" PhoneNo.:"+phoneNo+" dob:"+ dob;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof BankAccount) {
			if(this.accountNumber==((BankAccount)obj).accountNumber) {
				

				return true;
			}
		}
		return false;
	}
	@Override
	public int compareTo(BankAccount b) {
		
		
		return ((Integer)this.accountNumber).compareTo(b.accountNumber);
	}
		

	

}
