package com.bank.core;
import java.time.LocalDate;

import com.bank.custom_exceptions.BankCustomException;
 public class SavingAccount extends BankAccount {
	private double interestRate;
	private double savingBalance;
    private final double MIN_BALANCE=3000; 
	
	
	// create parameterized constructor to intialize saving account:
	public SavingAccount(int accountNumber,AccountType accountType,String customerName,double balance,String phoneNo,LocalDate dob,double rate) {
		super(accountNumber,accountType,customerName,balance,phoneNo,dob);
		this.interestRate=rate;
 
	}
	// override withdraw method:
	@Override
	public void withdraw(double amount) throws BankCustomException{
 
		if(amount<=(super.getBalance()-MIN_BALANCE)) {
			super.setBalance(super.getBalance()-amount);
			System.out.println("Withdrawn successfully!!");
		}
		// throw exception
//		else {
//			throw new BankCustomException("Insufficient fund");
//		}
		
	}
	// apply interest
	public void applyInerest() {
		savingBalance=super.getBalance()+(super.getBalance()*interestRate);
		super.setBalance(savingBalance);
 		
			
	}
	
	public String toString() {
		
		
		return super.toString()+" InterestRate:"+interestRate;
	}
	
}
