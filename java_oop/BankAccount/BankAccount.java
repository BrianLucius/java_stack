import java.util.Random;

public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber = getNewAccountNumber();

    private static int totalNumAccounts;
    private static double totalAccountBalance;

    //constructor
    public BankAccount() {
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        this.totalAccountBalance = 0.0;
        this.totalNumAccounts+=1;
    }

    //getter
    private String getNewAccountNumber() {
        Random accountNumber = new Random();
        return String.valueOf(accountNumber.nextInt(99999)) + String.valueOf(accountNumber.nextInt(99999));
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void getAccountBalance() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Checking Balance: " + this.checkingBalance);
        System.out.println("Savings Balance: " + this.savingsBalance);
        System.out.println("Total Account Balance: " + this.totalAccountBalance);
        System.out.println("\n");
    }

    //setter
    public void setAccountDeposit(String acctType, double amount) {
        switch (acctType) {
        case "savings":
            this.savingsBalance+=amount;
            this.totalAccountBalance+=amount;
            break;
        case "checking":
            this.checkingBalance+=amount;
            this.totalAccountBalance+=amount;
            break;
        default:
            System.out.println("That is not a valid account type!");
        }
    }

    public void setAccountWithdraw(String acctType, double amount) {
        switch (acctType) {
        case "savings":
            if (amount > this.savingsBalance) {
                System.out.println("Insufficient funds in your savings account!");
                return;
            } else {
                this.savingsBalance-=amount;
                this.totalAccountBalance-=amount;
                break;
            }
        case "checking":
            if (amount > this.checkingBalance) {
                System.out.println("Insufficient funds in your checking account!");
                return;
            } else {
                this.checkingBalance-=amount;
                this.totalAccountBalance-=amount;
                break;
            }
        default:
            System.out.println("That is not a valid account type!");
        }
    }
}