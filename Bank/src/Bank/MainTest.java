package Bank;
import java.util.LinkedList;
import java.util.Scanner;
public class MainTest {
    public static void main(String[] args) throws InputChoiceException {
        Scanner sc=new Scanner(System.in);
        LinkedList<Bank_Account> Account=new LinkedList<>();
        Address add1=new Address("Beirut", "Lebanon");
        Customer cst1=new Customer("Mahdi", "Male", 23, add1);
        Bank_Account bnkAcc1=new Bank_Account(123, cst1, 500);
        Account.add(bnkAcc1);
        System.out.println("Welcome to Haigazian Bank.");
        int choice1=0;
        while(true) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Pick a number.");
            System.out.println("2. See a bank teller.");
            System.out.println("3. Use the ATM.");
            System.out.println("4. Exit.");
            try {
                choice1=sc.nextInt();
                if(choice1==1 || choice1==2 || choice1==3 || choice1==4) {
                    break;
                }
                else {
                    throw new InputChoiceException();
                }
            }
            catch(InputChoiceException e) {}
        }
        
        switch(choice1) {
            case 1:

            case 2:

            case 3: while(true) {
            			System.out.println();
                        System.out.println("Please enter account number:");
                        boolean accFound=false;
                        try {
                            int accNum=sc.nextInt();
                            for(Bank_Account BA : Account) {
                                if(accNum==BA.getAccountNumber()) {
                                    int choice2=0;
                                    while(true) {
                                        try {
                                        	System.out.println();
                                        	System.out.println("Please select one of the following options:");
                                            System.out.println("1. Check balance.");
                                            System.out.println("2. Withdraw.");
                                            System.out.println("3. Deposit.");
                                            System.out.println("4. Show account information.");
                                            System.out.println("5. Exit.");
                                            choice2=sc.nextInt();
                                            if(choice2==1 || choice2==2 || choice2==3 || choice2==4 || choice2==5) {
                                            	switch(choice2) {
                                                case 1: System.out.println("Balance = "+BA.balance);
                                                        continue;    

                                                case 2: System.out.println("Enter amount to withdraw:");
                                                        int withATM=sc.nextInt();
                                                        BA.Withdraw(withATM);
                                                        continue;
                                                                 

                                                case 3: System.out.println("Enter amount to deposit:");
                                                        int dep=sc.nextInt();
                                                        BA.Deposit(dep);
                                                        continue;    

                                                case 4: System.out.println(BA.Show(BA));
                                                 		continue;
                                                            

                                                case 5: System.out.println("Have a nice day!");
                                                		System.exit(0);
                                                		continue;
                                            }
                                            }
                                            else {
                                                throw new InputChoiceException();
                                            }
                                        }
                                        catch(InputChoiceException e) {}
                                    }
                                    
                                }
                                else {
                                    System.out.println("Account doesn't exist. Please create one with the teller's help.");
                                }
                                    accFound=true;
                                    break;
                                }
                            
                        
                        if(accFound) {
                            break;
                        }
                        else {
                            throw new InvalidAccountNumber();
                        }
                    }
                        catch(InvalidAccountNumber an) {
                            System.exit(0);
                        }
                    
                    
                    }

            case 4: System.out.println("Have a nice day!");
            		System.exit(0);
        }
    }
}
