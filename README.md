This is Bank Management System using core Java.
Followed by project development blocks ( Tester > Service Layer > Validations > Custom Exceptions > Core Classes ) 

1.It allows you to Open Bank Account (SAVING OR CURRENT TYPE)
Based on type you are requeste to enter credentials.
  Validations are applied , will check before account creation.(duplicate Accounts, Account type)
  
  BankAccount b=new SavingAccount(credentials);
  BankAccount b=new SavingAccount(credentials);

  This account will be added to data structure: ArrayList 
  i.e for storing different accounts together.

2. Withdraw Balance: Enter account number and amount to withdraw.
     Validations are applied based on Type(SAVING and CURRENT)
     saving : you can remove amount less than your balance
     current: you can remove amount less than (balance + overDraftLimit)

3. Deposit Balance: Enter account number and amount to deposit.
      check account number exists if yes: deposit amount to account
                                   else throw account don't exists
4. Transfer balance: Enter source account number, amount & Destination account number
          check account number exists if yes : check min balance condition > if satisfies :  withdraw > depsoit to destination acount:
                                                                               else throw exception(not sufficient balance)
                                       else throw Account don't exists
                                           
          

5. Close Account: Enter account number.
       check Account exists: if yes then close
                              else throw exeption 

6. Apply Interest(to all saving accounts ): Enter account number;
      check valid account number.
      check type : if SAVING_ACCOUNT then apply interest
                   else skip that account

7. Display phone numbers based on account type and balance greater than specific value
   

    
