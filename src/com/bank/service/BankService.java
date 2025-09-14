package com.bank.service;

 
import com.bank.core.BankAccount;
import com.bank.custom_exceptions.*;
public interface BankService {
		// create account
	String openAccount(int accountNumber, String AccountType,String customerName,double balance,String phoneNo,String dob , double rateOrLimit) throws BankCustomException;
	
	
   
 
	void withdraw(int accountNuber,double amount) throws BankCustomException;

	void deposit(int accountNumber,double amount) throws BankCustomException;
	BankAccount getSummary(int accountNumber) throws BankCustomException;
	
	void displayAll() throws BankCustomException;
	
	String closeAccount(int accountNumber) throws BankCustomException;
	
	String applyInerestToSaving() throws BankCustomException;
	
	void displayPhoneNumbers(String accountType,double specificAmount) throws BankCustomException;
	
	String deleteAllCurrentAccount() throws BankCustomException;
	
	String sortAccountList() throws BankCustomException;
	
	String transferFunds(int sourceAccount, double amount, int destAccount) throws BankCustomException;
}
