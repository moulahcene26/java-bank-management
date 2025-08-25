public abstract class Account {
    protected int accountNumber;
    protected String owner;
    protected double balance;


    public Account(int accountNumber, String owner, double initialBalance){
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    };


    public void deposit(double amount){
        balance+= amount;
    }

    public double getBalance(){
        return balance;
    }

    public String getOwner(){
        return owner;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public abstract String accountType();

    public abstract void withdraw(double amount);
}
