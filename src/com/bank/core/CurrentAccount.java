package com.bank.core;

import java.time.LocalDate;

import com.bank.custom_exceptions.*;
 
public class CurrentAccount extends BankAccount {
	private double overDraftLimit;
	private double currentBalance;
	private double maxWithdraw;

	public CurrentAccount(int accountNumber,AccountType accountType,String customerName,double balance,  String phoneNo, LocalDate dob,double overDraftLimit) {
		super(accountNumber,accountType,customerName, balance,  phoneNo,dob);
		this.overDraftLimit = (overDraftLimit);
	 
	}

	@Override
	public void withdraw(double amount) throws BankCustomException {
		
		
		// Regular condition
		if (amount <= super.getBalance()) {
			 super.withdraw(amount);
		}
		if(amount<=(super.getBalance()+overDraftLimit)) {
			double overDraftUsed=amount-super.getBalance();
			overDraftLimit=overDraftLimit-overDraftUsed;
			super.setBalance(0);
//			overDraftLimit = super.getBalance() + overDraftLimit - amount;
//			super.setBalance(0);
			System.out.println("Withdrawn successfully!!");
		}
		
//		throw error for 
//		if(amount>(super.getAccountNumber()+overDraftLimit)) {
//			throw new BankCustomException("Insufficient fund!!!");
//		}

		 

 
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return super.toString() + " OverDraftLimit:" + overDraftLimit;
	}
}
