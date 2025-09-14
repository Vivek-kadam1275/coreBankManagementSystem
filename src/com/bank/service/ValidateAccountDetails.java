package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.bank.custom_exceptions.BankCustomException;

public class ValidateAccountDetails {

	private static final double SAVING_MIN_BALANCE = 3000;

	// VALIDATE ALL Account DETAILS:
	public static BankAccount validateAllDetails(int accountNumber, String accountType, String customerName,
			double balance, String phoneNo,String dob, double rateOrLimit, List<BankAccount> accountList) throws BankCustomException {

		// CHECK DUPLICATE:
		checkDuplicateAccount(accountNumber, accountList);
		
		// validate account type
		AccountType accType=validateAccountType(accountType);
		
		// parse date
		LocalDate date=LocalDate.parse(dob);
	
	    // check if 	
		if(accType.equals(AccountType.SAVING_ACCOUNT)) {
			validateSavingBalance(balance);
			return new SavingAccount(accountNumber, accType, customerName, balance, phoneNo,date,rateOrLimit);
			
		}
		else {
			return new CurrentAccount(accountNumber, accType, customerName, balance, phoneNo,date, rateOrLimit);
		}
		
 
	}


	
		
	// CHECK ACCOUNT DUPLICATION:
			public static void checkDuplicateAccount(int accountNumber,List<BankAccount> accountList) throws BankCustomException {
				BankAccount temp = new BankAccount(accountNumber);
		 
				if(accountList.contains(temp)) {
					throw new BankCustomException("Errror: Duplicate account number detected");
				}
				
				
			}
			// VALIDATE ACCOUNT TYPE:
			public static AccountType validateAccountType(String accountType) throws IllegalArgumentException {
				
				return AccountType.valueOf(accountType.toUpperCase());
			}
			
			public static void validateSavingBalance(double balance) throws BankCustomException {
				if(balance<SAVING_MIN_BALANCE) {
					throw new BankCustomException("You have entered wrong balance");
				}
			}
		 
		
// SEARCH ACCOUNT
	public static BankAccount searchAccountDetails(int accountNumber, List<BankAccount> accountList) throws BankCustomException {
		BankAccount temp = new BankAccount(accountNumber);
	 
		if(!accountList.contains(temp)) {
			throw new BankCustomException("Account not found!!!");
		}
		for(BankAccount b:accountList) {
			if(b.equals(temp)) {
				return b;
			}
		}
		return null;
		
		 
	}
	
	public static void validateWithdrawSavingBalance(double amount,double balance) throws BankCustomException {
		if(amount>(balance-SAVING_MIN_BALANCE)) {
			throw new BankCustomException("Withdraw Failed - SavingAccount:insufficient balance !");
		}
	}
	
	public static void validateWithdrawCurrentBalance(double amount,double balance,double overDraftLimit) throws BankCustomException {
		if(amount>(balance+overDraftLimit)) {
			throw new BankCustomException("Withdraw Failed - Current Account:insufficient balance !");
		}
	}
 
	
	public static void checkMinCurrentBalance(double balance,double amount,double overDraftLimit) throws BankCustomException{
		double currentBalance=balance+overDraftLimit;
		if(amount>currentBalance) {
			throw new BankCustomException("Insufficient Balance!!!");
		}
	}
	
	 
	

}
