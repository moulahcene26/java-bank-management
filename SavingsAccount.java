

public class SavingsAccount extends Account {
    
    private double interestRate;

    public SavingsAccount(int accountNumber, String owner, double initialBalance, double interestRate){
        super(accountNumber, owner, initialBalance);
        this.interestRate=interestRate;
    }


    public void addInterest(){
        balance += balance * interestRate;
    } 

    @Override
    public void withdraw(double amount){
        if(amount > 0 && balance>=amount){
            balance -= amount;
        }
    }

    @Override
    public String accountType(){
        return "Savings";
    }


}
