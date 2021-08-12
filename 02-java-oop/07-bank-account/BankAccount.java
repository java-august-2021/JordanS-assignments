import java.util.Random;

public class BankAccount {

    private String accountNumber;
    private double savingsBalance;
    private double checkingBalance;
    private static int totalAccounts;
    private static double sumAccountBalance;

    public BankAccount(double deposit, String accountType){
        createAccNum();
        if(accountType == "checking"){
            this.checkingBalance += deposit;
            sumAccountBalance += deposit;
        } else {
            this.savingsBalance += deposit;
            sumAccountBalance += deposit;
        }
        totalAccounts += 1;
        System.out.println("Account #" + this.accountNumber + " has been created!");
    }

    public static int getTotalAccounts(){
        return totalAccounts;
    }

    public static double getTotalBalance(){
        return sumAccountBalance;
    }

    private String createAccNum(){
        String nums = "0123456789";
        String accountNum = "";
    
        Random rNum = new Random();
        for (int x = 0; x < 5; x++){
            int num = nums.charAt(rNum.nextInt(10));
            accountNum += num;
        }
        this.accountNumber = accountNum;
        return accountNum;
    }


    public void deposit(double amount, String accountType){
        if(accountType == "checking"){
            this.checkingBalance += amount;
            sumAccountBalance += amount;
        } else {
            this.savingsBalance += amount;
            sumAccountBalance += amount;
        }
        System.out.println("Account #" + this.accountNumber + " deposited $" + Double.toString(amount) + " into their account.");
    }

    public void getChecking(){
        System.out.println("The Checking balance for Account #" + this.accountNumber + " is currently: $" + this.checkingBalance);
        // return Double.toString(this.checkingBalance);
    }
    public void getSavings(){
        System.out.println("The Savings balance is: $" + this.savingsBalance);
    }

    //withdraw money

    public String displayBalances(){
        return "\n Account Number: " + this.accountNumber + "\n" + "Savings Account: $" + Double.toString(this.savingsBalance) + "\n" + "Checking Account: $" + Double.toString(this.checkingBalance) + "\n";
    }
}
