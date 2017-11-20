package src.ameedf.jb8223.assignments.BankAccount;

import java.util.Random;

public class StockAccount extends RegularAccount {

    StockAccount() {
        super();
        commissionOnWithdrawal = 0;
        commissionOnDeposit = 0;
    }

    public void deposit(double num) {
        Random cod = new Random();
        commissionOnDeposit = cod.nextInt(6);
        super.deposit(num);
    }

    public void withdraw(double sum) {
        Random cow = new Random();
        commissionOnWithdrawal = cow.nextInt(6);
        super.withdraw(sum);
    }

    protected double getBonus() {
        return (commissionOnDeposit - commissionOnWithdrawal);
    }
}
