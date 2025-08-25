public class CheckingAccount extends Account{

    private double overdraftLimit;

    public CheckingAccount(int AccountNumber, String owner, double initialBalance, double overdraftLimit){
        super(AccountNumber, owner, initialBalance);
        this.overdraftLimit = overdraftLimit;

    }

    @Override
    public void withdraw(double amount){
        if(amount >0 && (balance - amount)>=overdraftLimit){
            balance -= amount;
        }
    }

    @Override
    public String accountType(){
        return "Checking";
    }

}
