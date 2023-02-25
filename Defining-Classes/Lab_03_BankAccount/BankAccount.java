package Lab_03_BankAccount;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private int id;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int countAccounts = 0;

    public BankAccount() {
        countAccounts++;
        this.id = countAccounts;
        this.balance = 0;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }
    public void deposit(double balance) {
        this.balance += balance;
    }
    public double getInterest(int years) {
        return this.interestRate * years * this.balance;
    }
    public int getId() {
        return this.id;
    }
}
