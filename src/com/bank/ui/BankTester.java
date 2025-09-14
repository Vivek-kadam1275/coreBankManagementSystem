package com.bank.ui;

import java.util.Scanner;

import com.bank.service.BankServiceImpl;

public class BankTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter number of accounts to create...");
			BankServiceImpl bsi = new BankServiceImpl();
			boolean exit = false;
			String status;
			while (!exit) {

				try {

					System.out.println(
							"1. open account   \n2. Withdraw \n3. Deposit \n4. Transfer \n5. Close Account \n6. Apply Interest(Saving)\n 7. Display Phone numbers(type & balance) \n8. Sort accounts\n9. Delete all Current account\n10. Display account\n11. Display All accounts  0.Exit");
					System.out.println("Enter your choice........");
					switch (sc.nextInt()) {
					case 1: {
						// open account
						System.out.println("Enter saving account details..(AccountNo, type, name,balance,phoneno,dob,rate or limit)");
						status = bsi.openAccount(sc.nextInt(), sc.next().toUpperCase(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(),sc.nextDouble());
						
						System.out.println(status);

						break;
					}
					 
					case 2: {
						// withdraw balance.
						System.out.println("Enter Account number & amount");
						 bsi.withdraw(sc.nextInt(), sc.nextDouble());
 
						break;
					}

					case 3: {
						// deposit amount
						System.out.println("Enter Account number & amount");
						  bsi.deposit(sc.nextInt(), sc.nextDouble());
						 
						break;
					}
					case 4: {
						// transfer
						System.out.println("Enter Source Account number , amount, destination account");
						bsi.transferFunds(sc.nextInt(), sc.nextDouble(), sc.nextInt());
						break;
					}
					case 5:{
						//Delete account
						System.out.println("Enter account number to delete");
						status=bsi.closeAccount(sc.nextInt());
						System.out.println(status);
						break;
					}
					case 6:{
						// apply interest on saving account:
						status=bsi.applyInerestToSaving();
						System.out.println(status);
						break;
					}
					case 7:{
						//display phone numbers based on account type and balance greater than specific value:
						System.out.println("Enter account type and specific balance..");
						bsi.displayPhoneNumbers(sc.next(), sc.nextDouble());
						break;
					}
					case 8:{
						// sort on account numbers
						status = bsi.sortAccountList();
						
						break;
					}
					case 9:
					{
						//Delete all current account
						status = bsi.deleteAllCurrentAccount();
						System.out.println(status);
						break;
					}
					case 10: {
						// display account
						System.out.println("Enter Account number ");
						System.out.println(bsi.getSummary(sc.nextInt()));;
						break;
					}
					case 11:{
						// display all accounts:
						bsi.displayAll();
						break;
					}
					case 0: {
						exit = true;
						System.out.println("Exited!!!");
						break;

					}
					default: {
						System.out.println("INVALID CHOICE");
						break;
					}

					}

				} catch (Exception e) {
					// TODO: handle exception
					sc.nextLine();
					e.printStackTrace();
				}

			}

		}

	}
}
