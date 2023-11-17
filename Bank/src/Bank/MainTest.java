package Bank;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.*;
public class MainTest {
    public static void main(String[] args) throws InputChoiceException {
        Scanner sc=new Scanner(System.in);
        LinkedList<Bank_Account> Account=new LinkedList<>();
        Queue<Integer> queue=new LinkedList<>();
        Address add1=new Address("Beirut", "Lebanon");
        Customer cst1=new Customer("Hani", "Male", 25, add1);
        Bank_Account bnkAcc1=new Bank_Account(123, cst1, 500);
        Account.add(bnkAcc1);
        System.out.println("Welcome to Haigazian Bank.");
        System.out.println();
        int choice1=0;
        boolean leave=false;
        while(true) {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Pick a number.");
            System.out.println("2. See a bank teller.");
            System.out.println("3. Use the ATM.");
            System.out.println("4. Exit.");
            try {
                choice1=sc.nextInt();
                if(choice1==1 || choice1==2 || choice1==3 || choice1==4) {
                    switch(choice1) {
                        case 1: while(true) {
                                System.out.println("Pick a number, or type 'E' to exit.");
                                String pick=sc.next();
                            if(pick.equals("E")) {
                                leave=true;
                                break;
                            }
                            try {
                                int pickn=Integer.parseInt(pick);
                                if(queue.contains(pickn)) {
                                    System.out.println("Number already exists. Pick another.");
                                    System.exit(0);
                                }
                                else {
                                    queue.add(pickn);
                                    System.out.println("You are in the queue. People before you are: "+(queue.size()-1));
                                    break;
                                }

                            }
                            catch(NumberFormatException e) {
                                System.out.println("Input invalid. Please enter a number or 'E'.");
                            }
                            if(leave) {
                                break;
                            }
                        }
                        

                        case 2: System.out.println("Please enter your queue number:");
                                int enter=sc.nextInt();
                                if(queue.isEmpty() || !queue.contains(enter)) {
                                    System.out.println("Number doesn't exist. Please pick a number first.");
                                    System.exit(0);
                                }
                                else if(queue.peek()!=enter && queue.contains(enter)) {
                                    System.out.println("Please wait for your turn.");
                                    System.out.println("People before you are: " + (queue.size()-1));
                                }
                                else if(queue.peek()==enter) {
                                    queue.poll();
                                    while(true) {
                                        System.out.println("Please choose one of the following:");
                                        System.out.println("O. Create a new bank account.");
                                        System.out.println("S. Show account info.");
                                        System.out.println("D. Delete account.");
                                        System.out.println("W. Withdraw.");
                                        System.out.println("Dep. Deposit.");
                                        System.out.println("E. Exit.");
                                        try {
                                            String choice=sc.next();
                                            if(choice.equals("O")) {
                                                int AccNum=0;
                                                System.out.println("Please enter new Account Number:");
                                                    AccNum=sc.nextInt();
                                                    boolean f=true;
                                                    for(Bank_Account BA : Account) {
                                                        if(AccNum==BA.getAccountNumber()) {
                                                            do {
                                                            System.out.println("Account alread Exists. Please enter another number.");
                                                            AccNum=sc.nextInt();
                                                            } while(AccNum==BA.getAccountNumber());
                                                        }
                                                    }
                                                    System.out.println("Please enter city:");
                                                    String city=sc.next();
                                                    System.out.println("Please enter country:");
                                                    String country=sc.next();
                                                    Address address=new Address(city, country);
                                                    System.out.println("Please enter name:");
                                                    String name=sc.next();
                                                    System.out.println("Please enter Gender:");
                                                    String gender=sc.next();
                                                    System.out.println("Please enter age:");
                                                    int age=sc.nextInt();
                                                    Customer customer=new Customer(name, gender, age, address);
                                                    Bank_Account BAcc=new Bank_Account(AccNum, customer, 0);
                                                    Account.add(BAcc);
                                                    System.out.println("Account added successfully.");
                                                
                                                
                                                
                                                
                                            }
                                            else if(choice.equals("S") || choice.equals("D") || choice.equals("W") || choice.equals("Dep") || choice.equals("E")) {
                                                while(true) {
                                                        System.out.println("Please enter account number:");
                                                        boolean AccFound=false;
                                                        try {
                                                            int AccNum=sc.nextInt();
                                                            int index=0;
                                                            boolean exit=false;
                                                            for(Bank_Account BA:Account) {
                                                                if(AccNum==BA.getAccountNumber()) {
                                                                    AccFound=true;
                                                                    switch(choice) {
                                                                        case "S":   BA.Show(BA);
                                                                                    break;
                                                                
                                                                        case "D":   Account.remove(index);
                                                                                    System.out.println("Account removed successfully.");
                                                                                    break;

                                                                        case "W": int amountWit=0;   
                                                                        while(true) {
                                                                            System.out.println("Enter amount to withdraw:");
                                                                            try {
                                                                                amountWit=sc.nextInt();
                                                                                BA.WithdrawT(amountWit);
                                                                                Account.set(index, BA);
                                                                                break;
                                                                            }
                                                                            catch(InputMismatchException e) {
                                                                                System.out.println("Input invalid. Please enter a number.");
                                                                                sc.next();
                                                                            }
                                                                        }
                                                                        break;

                                                                        case "Dep": int amountDep=0;
                                                                                while(true) {
                                                                                    System.out.println("Enter amount to deposit:");
                                                                                    try {
                                                                                        amountDep=sc.nextInt();
                                                                                        BA.Deposit(amountDep);
                                                                                        Account.set(index, BA);
                                                                                        break;
                                                                                    }
                                                                                    catch(InputMismatchException e) {
                                                                                        System.out.println("Input invalid. Please enter a number.");
                                                                                        sc.next();
                                                                                    }
                                                                                }

                                                                        case "E":   exit=true;
                                                                                    break;
                                                                    }
                                                                    
                                                                    if(exit) {
                                                                        break;
                                                                    }
                                                                }
                                                                else {
                                                                    index++;
                                                                }
                                                            }
                                                            if(AccFound) {
                                                                break;
                                                            }
                                                            else {
                                                                throw new InvalidAccountNumber();
                                                            }
                                                        }
                                                        catch(InvalidAccountNumber e) {
                                                            System.out.println("Account not found.");
                                                        }
                                                } 
                                            }
                                            else {
                                                throw new InputChoiceException();
                                            }
                                        }
                                        catch(InputChoiceException e) {}
                                    }
                                }

                        case 3: while(true) {
                                    System.out.println();
                                    System.out.println("Please enter account number:");
                                    boolean accFound=false;
                                    try {
                                        int accNum=sc.nextInt();
                                        int index=0;
                                        for(Bank_Account BA : Account) {
                                            if(accNum==BA.getAccountNumber()) {
                                                char choice2=' ';
                                                while(true) {
                                                    try {
                                                        System.out.println();
                                                        System.out.println("Please select one of the following options:");
                                                        System.out.println("C. Check balance.");
                                                        System.out.println("W. Withdraw.");
                                                        System.out.println("D. Deposit.");
                                                        System.out.println("S. Show account information.");
                                                        System.out.println("E. Exit.");
                                                        choice2=sc.next().charAt(0);
                                                        if(choice2=='C' || choice2=='W' || choice2=='D' || choice2=='S' || choice2=='E') {
                                                            switch(choice2) {
                                                            case 'C': System.out.println("Balance = "+BA.balance);
                                                                    continue;    

                                                            case 'W': int amountWit=0;
                                                                        while(true) {
                                                                            System.out.println("Enter amount to withdraw:");
                                                                            try {
                                                                                amountWit=sc.nextInt();
                                                                                BA.Withdraw(amountWit);
                                                                                Account.set(index, BA);
                                                                                continue;
                                                                            }
                                                                            catch(InputMismatchException e) {
                                                                                System.out.println("Input invalid. Please enter a number.");
                                                                                sc.next();
                                                                            }
                                                                        }       

                                                            case 'D': int amountDep=0;
                                                                        while(true) {
                                                                            System.out.println("Enter amount to deposit:");
                                                                            try {
                                                                                amountDep=sc.nextInt();
                                                                                BA.Deposit(amountDep);
                                                                                Account.set(index, BA);
                                                                                continue;
                                                                            }
                                                                            catch(InputMismatchException e) {
                                                                                System.out.println("Input invalid. Please enter a number.");
                                                                                sc.next();
                                                                            }
                                                                        }  

                                                            case 'S': System.out.println(BA.Show(BA));
                                                                    continue;
                                                                        

                                                            case 'E': break;
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
                                                index++;
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
                                        System.out.println("Account does not exist. Please retry or create new account with teller to continue.");
                                        break;
                                    }
                                
                                }

                        case 4: System.out.println("Have a nice day!");
                                System.exit(0);
                    }
                }
                else {
                    throw new InputChoiceException();
                }
            }
            catch(InputChoiceException e) {}
        }
        
        
    }
}
