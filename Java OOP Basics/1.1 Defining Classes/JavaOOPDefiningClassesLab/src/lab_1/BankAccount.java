package lab_1;

public class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public BankAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(double amount){
        if(this.getBalance() >= amount){
            this.setBalance(this.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.getId(), this.getBalance());
    }
}
