public class BankAccountTest {

    public static void main(String[] args) {

        //create some accounts
        BankAccount mikeyT = new BankAccount(832, "checking");
        BankAccount jordanS = new BankAccount(764, "savings");

        //print users' accounts & balances
        System.out.println(mikeyT.displayBalances());

        //retrieve this.checkBalance
        mikeyT.getChecking();

        System.out.println(jordanS.displayBalances());

        //retrieve this.savingsBalance
        jordanS.getSavings();

        //deposit amount into accountType
        mikeyT.deposit(200, "checking");

        //retrieve this.checkBalance
        mikeyT.getChecking();

        // get Total Accounts & Balance
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total Balance: $" + BankAccount.getTotalBalance());
    }

    
}
