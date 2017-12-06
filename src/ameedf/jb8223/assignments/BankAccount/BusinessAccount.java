package src.ameedf.jb8223.assignments.BankAccount;

public class BusinessAccount extends RegularAccount {

    BusinessAccount() {
        super();
        commissionOnWithdrawal = 1;
        commissionOnDeposit = 1;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        if (numOfDeposits % 10 == 0) {
            if (this.commissionOnDeposit == 7)
                this.commissionOnDeposit = 1;
            else
                this.commissionOnDeposit++;
        }
    }

    @Override
    protected double getBonus() {
        if (commissionOnDeposit == 7)
            return (commissionOnDeposit * 20);
        return 0;
    }
}
