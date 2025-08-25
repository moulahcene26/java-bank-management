
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do { 
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Add Interest (Savings)");
            System.out.println("5. Show Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Account Type: (Savings: 1, Checking: 2)");
                    int type = scanner.nextInt();
                    System.out.println("Enter Owner Name: ");
                    scanner.nextLine();
                    String owner = scanner.nextLine();
                    System.out.println("Initial Deposit: ");
                    double initialB = scanner.nextDouble();
                    System.out.println("Account Number: (DDMMYY)");
                    int accNumber = scanner.nextInt();
                    if(type == 1){
                        System.out.println("Enter Interest Rate (eg 3% = 0.03): ");
                        double rate = scanner.nextDouble();
                        bank.addAccount(new SavingsAccount(accNumber, owner, initialB, rate));
                    } else if (type == 2){
                        System.out.println("Enter Overdraft Limit (eg -100, -300): ");
                        double oLimit = scanner.nextDouble();
                        bank.addAccount(new CheckingAccount(accNumber, owner, initialB, oLimit));
                    } else {
                        System.out.println("Invalid account type.");
                    }
                    break;

                case 2:
                    System.out.println("Enter Account Number: ");
                    int depNum = scanner.nextInt();
                    System.out.println("Enter Deposit Amount: ");
                    double depAmm = scanner.nextDouble();
                    Account depAcc = bank.findAccountByNumber(depNum);
                    if(depAcc != null){
                        depAcc.deposit(depAmm);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    int wNum = scanner.nextInt();
                    System.out.println("Enter Withdrawal Amount: ");
                    double wAmm = scanner.nextDouble();
                    Account wAcc = bank.findAccountByNumber(wNum);
                    if(wAcc != null){
                        wAcc.withdraw(wAmm);
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Account Number: ");
                    int iNum = scanner.nextInt();
                    Account iAcc = bank.findAccountByNumber(iNum);
                    if(iAcc instanceof SavingsAccount){
                        ((SavingsAccount) iAcc).addInterest();
                        System.out.println("Interest added.");
                    } else {
                        System.out.println("Not a savings account or account not found.");
                    }
                    break;

                case 5:
                    bank.showAccounts();
                    break;
                
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }






        } while (choice != 0);

        scanner.close();



    }
}
