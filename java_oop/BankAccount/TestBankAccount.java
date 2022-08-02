public class TestBankAccount{
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount();
        myAccount.setAccountDeposit("checking", 123.45);
        myAccount.setAccountWithdraw("checking", 100.45);
        myAccount.setAccountDeposit("savings", 984.32);
        myAccount.getAccountBalance();

        BankAccount anotherAccount = new BankAccount();
        anotherAccount.setAccountDeposit("savings", 987654.32);
        anotherAccount.setAccountWithdraw("savings", 1000.32);
        anotherAccount.setAccountDeposit("checking", 567.34);
        anotherAccount.setAccountWithdraw("checking", 10000.00);
        anotherAccount.getAccountBalance();

        System.out.printf("Total bank accounts: %d\n",BankAccount.getNumBankAccounts());
        System.out.printf("Total bank balance: $%.2f\n", BankAccount.getTotalBankBalance());
    }
}