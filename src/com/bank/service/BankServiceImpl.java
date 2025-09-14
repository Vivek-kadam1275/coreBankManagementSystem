package com.bank.service;

import static com.bank.service.ValidateAccountDetails.*;
import static com.bank.service.ValidateAccountDetails.searchAccountDetails;
import static com.bank.service.ValidateAccountDetails.validateAllDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bank.core.AccountType;
import com.bank.core.BankAccount;
import com.bank.core.CurrentAccount;
import com.bank.core.SavingAccount;
import com.bank.custom_exceptions.BankCustomException;

public class BankServiceImpl implements BankService {

//	private BankAccount[] accounts;

	// create accountsList
	private List<BankAccount> accountList;

	public BankServiceImpl() {
//		this.accounts=new BankAccount[size];

		// initialize arraylist
		this.accountList = new ArrayList<>();
	}

	@Override
	public String openAccount(int accountNumber, String AccountType, String customerName, double balance,
			String phoneNo, String dob, double rateOrLimit) throws BankCustomException {

		System.out.println("Into account opening process");
		// validate account details:
		BankAccount account = validateAllDetails(accountNumber, AccountType, customerName, balance, phoneNo, dob,
				rateOrLimit, accountList);

		// add bank account to array list
		accountList.add(account);
//		accounts[counter++]=account;

		return "Account opened successfully!!!";
	}

	@Override
	public void withdraw(int accountNuber, double amount) throws BankCustomException {
		BankAccount account = searchAccountDetails(accountNuber, accountList);
		if (account.getAccountType().equals(AccountType.SAVING_ACCOUNT)) {
			validateWithdrawSavingBalance(amount, account.getBalance());
			account.withdraw(amount);
		} else {
			validateWithdrawCurrentBalance(amount, account.getBalance(),
					((CurrentAccount) account).getOverDraftLimit());
			account.withdraw(amount);
		}

	}

	@Override
	public void deposit(int accountNumber, double amount) throws BankCustomException {
		BankAccount temp = searchAccountDetails(accountNumber, accountList);
		temp.deposit(amount);
	}

	@Override
	public BankAccount getSummary(int accountNumber) throws BankCustomException {

		BankAccount temp = searchAccountDetails(accountNumber, accountList);

		return temp;

	}

	@Override
	public void displayAll() throws BankCustomException {
		System.out.println("All Bank Accounts: ");
		for (BankAccount b : accountList) {
			System.out.println(b);
		}
	}

	@Override
	public String closeAccount(int accountNumber) throws BankCustomException {

		BankAccount temp = new BankAccount(accountNumber);
		if (!accountList.remove(temp)) {
			throw new BankCustomException("Account does not exists!!");
		}
		return "Account deleted successfully!!";
	}

	@Override
	public String applyInerestToSaving() throws BankCustomException {

		for (BankAccount b : accountList) {
			if (b.getAccountType().equals(AccountType.valueOf("SAVING_ACCOUNT"))) {
				((SavingAccount) b).applyInerest();
			}

		}

		return "Interest applied to all saving accounts successfully!!";

	}

	@Override
	public void displayPhoneNumbers(String accountType, double specificAmount) throws BankCustomException {

		for (BankAccount b : accountList) {
			if (b.getAccountType().equals(AccountType.valueOf(accountType.toUpperCase())) && b.getBalance() > specificAmount) {
				System.out.println(b);
			}
		}

	}
	
	// update later
	@Override
	public String deleteAllCurrentAccount() throws BankCustomException{
		
//		Iterator<BankAccount> itr = accountList.iterator();
//	    while (itr.hasNext()) {
//	        BankAccount b = itr.next();
//	        if (b.getAccountType().equals(AccountType.CURRENT_ACCOUNT)) {
//	            itr.remove();  // safe removal
//	        }
//	    }
		for (int i=0;i<accountList.size();i++) {
			BankAccount b = accountList.get(i);
			if (b.getAccountType().equals(AccountType.valueOf("CURRENT_ACCOUNT"))) {
			
				accountList.remove(b);
			}
		

		}
		
		return "All current accounts are closed";

	}
	
	@Override
	public String sortAccountList() throws BankCustomException{
		Collections.sort(accountList);
		return "Accounts sorted successfully";
	}
		
	public String transferFunds(int sourceAccount, double amount, int destAccount) throws BankCustomException
	{
 
		// calling withdraw function
		withdraw(sourceAccount, amount);
		
		// calling deposit function
		deposit(destAccount,amount);
		
	   
		return null;
	}


}
