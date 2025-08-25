
import java.util.ArrayList;

public class Bank {
    ArrayList<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }


    public void addAccount(Account acc){
        accounts.add(acc);
    }

    public void showAccounts() {
        for (Account acc : accounts) {
            System.out.println(
                "Account Number: " + acc.getAccountNumber() +
                ", Owner: " + acc.getOwner() +
                ", Balance: " + acc.getBalance() +
                ", Type: " + acc.accountType()
            );
        }
    }

    public Account findAccountByNumber(int num) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == num) {
                return acc;
            }
        }
        return null;
    }



}
