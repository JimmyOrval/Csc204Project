package Bank;
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
            case 1: while(true) {
                        System.out.println("Pick a number, or type 'E' to exit.");
                        String pick=sc.next();
                        if(pick.equals("E")) {
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
                                System.out.println("You are not in the queue. People before you are: "+(queue.size()-1));
                                while(true) {
                                    System.out.println("Press one of the following options:");
                                    System.out.println("1. Continue.");
                                    System.out.println("2. Exit.");
                                    try {
                                        int cont=sc.nextInt();
                                        if(cont==1) {
                                            break;
                                        }
                                        else if(cont==2) {
                                            System.out.println("Have a nice day!");
                                            System.exit(0);
                                        }
                                        else {
                                            throw new InputChoiceException();
                                        }
                                    }
                                    catch (InputChoiceException e) {}
                                }
                                break;
                            }

                        }
                        catch(NumberFormatException e) {
                            System.out.println("Input invalid. Please enter a number or 'E'.");
                        }
                        break;
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

                                    System.out.println("Please enter ");
                                    
                                }
                                if(choice.equals("S") || choice.equals("D") || choice.equals("W") || choice.equals("Dep") || choice.equals("E")) {
                                    
                                }
                                else {
                                    throw new InputChoiceException();
                                }
                            }
                            catch(InputChoiceException e) {

                            }
                        }
                    }

            case 3: while(true) {
            			System.out.println();
                        System.out.println("Please enter account number:");
                        boolean accFound=false;
                        try {
                            int accNum=sc.nextInt();
                            try (FileInputStream inFile=new FileInputStream("Account.ser"); ObjectInputStream inObj=new ObjectInputStream(inFile)) {
                                LinkedList<Bank_Account> inputList;
                                try {
                                    inputList=(LinkedList<Bank_Account>) inObj.readObject();
                                }
                                catch(ClassNotFoundException e) {
                                    inputList=new LinkedList<>();
                                }
                                if(inputList.isEmpty()) {
                                    inputList=new LinkedList<>();
                                }

                                for(Bank_Account BA : inputList) {
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

                                                case 'W': System.out.println("Enter amount to withdraw:");
                                                        int withATM=sc.nextInt();
                                                        BA.Withdraw(withATM);
                                                        continue;
                                                                 

                                                case 'D': System.out.println("Enter amount to deposit:");
                                                        int dep=sc.nextInt();
                                                        BA.Deposit(dep);
                                                        continue;    

                                                case 'S': System.out.println(BA.Show(BA));
                                                 		continue;
                                                            

                                                case 'E': System.out.println("Have a nice day!");
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
                            }
                            catch(IOException e) {
                                System.err.println("IO Error: "+e.getMessage());
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
