package lab_2;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int idSequence;
    private int id;
    private double balance;
    private static double interestRate;

    public BankAccount() {
        this.id = ++idSequence;
        interestRate = DEFAULT_INTEREST_RATE;
    }

    public BankAccount(double balance) {
        this.id = ++idSequence;
        this.balance = balance;
        interestRate = DEFAULT_INTEREST_RATE;
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

    public double getInterestRate(int years) {
        return this.getBalance() * interestRate * years;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
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
