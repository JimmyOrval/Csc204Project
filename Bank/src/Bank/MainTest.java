package Bank;
import java.util.LinkedList;
import java.util.Scanner;
public class MainTest {
    public static void main(String[] args) throws InputChoiceException {
        Scanner sc=new Scanner(System.in);
        LinkedList<Bank_Account> Account=new LinkedList<>();
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

            case 3:

            case 4:
        }
    }
}
