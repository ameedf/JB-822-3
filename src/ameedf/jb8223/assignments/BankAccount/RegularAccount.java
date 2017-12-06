package src.ameedf.jb8223.assignments.BankAccount;

import java.util.Random;

public class RegularAccount {

    private final String clientId;
    private double balance;
    private String accountAction = "[Current status]";
    byte numOfDeposits;
    int commissionOnWithdrawal;
    int commissionOnDeposit;

    RegularAccount() {
        Random newRandomNum = new Random();
        clientId = "ACC/" + newRandomNum.nextInt(100_000_000);
        numOfDeposits = 0;
        commissionOnWithdrawal = 3;
        commissionOnDeposit = 1;
        System.out.println("Account " + getClientId() + " created successfully!");
    }

    private String getClientId() {
        return clientId;
    }

    private double getBalance() {
        return balance;
    }

    //adds “sum” to the balance + COD + bonus
    public void deposit(double sum) {
        accountAction = "[Deposit of " + sum + "]";
        balance += (sum + commissionOnDeposit + getBonus());
        numOfDeposits++;
    }

    //adds “sum” to the balance – COW
    public void withdraw(double sum) {
        accountAction = "[Withdrawal of " + sum + "]";
        if (balance - (sum + commissionOnWithdrawal) < 0)
            System.out.println("Not enough balance for withdrawal, please try a smaller amount");
        else {
            balance -= (sum + commissionOnWithdrawal + getBonus());
            balance = Math.round(balance * 100.0) / 100.0;
        }
    }

    //calculates the bonus according to the terms
    double getBonus() {
        return 0;
    }

    //prints the account details
    public String toString() {
        return "Account " + getClientId() + ": action= " + accountAction + " [balance=" + getBalance() + ", commissionOnWithdrawal="
                + commissionOnWithdrawal + ", commissionOnDeposit="
                + commissionOnDeposit + ", bonus=" + getBonus() + "]";
    }
}
