import java.util.Scanner;
class BankAccount {
    
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ATM {
    private BankAccount bankAcc;

    public ATM(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }
    
    public void withdraw(double amount) {
        
        if (amount > bankAcc.getBalance()) {
            System.out.println("Insufficient funds!! Remainder: Sufficient amount of balance to be maintained is 1000 Rupees!");
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount!");
        }
        else {
            bankAcc.setBalance(bankAcc.getBalance() - amount);
            System.out.println( amount +" Rupees has been withdrawn successfully. New balance: " + bankAcc.getBalance()+" Rupees");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else {
            bankAcc.setBalance(bankAcc.getBalance() + amount);
            System.out.println( amount +" Rupees has been deposited successfully. New balance: " + bankAcc.getBalance()+" Rupees");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAcc.getBalance()+" Rupees");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount bankAcc = new BankAccount(1000.0);
        ATM atm = new ATM(bankAcc);
        Scanner sc = new Scanner(System.in);
        System.out.println("\033c");
        int option = 0;
        
        System.out.println("----------WELCOME TO THE ATM----------");
        System.out.println("Please insert your card!");
        System.out.println("Hi,Please do not Remove your Chip Card. Leave your Card Inserted during the Entire Transaction.");
        System.out.println();
        System.out.print("ENTER YOUR 4-digit PIN HERE: ");
        int PIN=sc.nextInt();
        
        while (option != 4) {
            System.out.println();
            System.out.println("DEAR CUSTOMER, PLEASE SELECT AN OPTION ");
            System.out.println("Press 1 to Withdraw your money");
            System.out.println("Press 2 to Deposit your money");
            System.out.println("Press 3 to Check your Account Balance");
            System.out.println("Press 4 to Exit");
            System.out.print("Your option: ");
            option=sc.nextInt();
            System.out.println();
            
            switch (option) {
                case 1:
                    System.out.print("ENTER THE AMOUNT YOU WANT TO WITHDRAW: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("ENTER THE AMOUNT YOU WANT TO DEPOSIT: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("THANK YOU FOR USING THE ATM, VISIT AGAIN!");
                    break;
                default:
                    System.out.println("Invalid option. Please Try Again.");
                    break;
            }
        }
        sc.close();
    }
}
