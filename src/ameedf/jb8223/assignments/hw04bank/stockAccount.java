package ameedf.jb8223.assignments.hw04bank;

import java.util.Random;

public class stockAccount extends AbstractAccount {

	public stockAccount(String clientId, double balance, double permittedOverdraft) {
		super(clientId, balance, permittedOverdraft, 0, 0);
	}

	@Override
	public void deposit(double sum) {
		changeCommisions();
		lastOperationDescription = "\t amount = " + sum + ", commissionOnDeposit=" + commissionOnDeposit + " ";
		super.deposit(sum + commissionOnDeposit + getBonus());
	}

	@Override
	public boolean withdraw(double sum) {
		changeCommisions();
		lastOperationDescription = "\t amount = " + sum + ", commissionOnWithdrawal=" + commissionOnWithdrawal + " ";
		return super.withdraw(sum + commissionOnWithdrawal + (getBonus() *(-1)) );
	}

	
	private void changeCommisions() {
		Random rn = new Random();
		commissionOnDeposit = rn.nextInt(6);
		commissionOnWithdrawal = rn.nextInt(6);
		//lastOperationDescription += " changeCommisions> CommissionOnDeposit:" + commissionOnDeposit + " commissionOnWithdrawal:" + commissionOnWithdrawal + "\n";
	}

	public double getBonus() {
		double bonus = (commissionOnDeposit - commissionOnWithdrawal);
		lastOperationDescription += " --> BONUS " + bonus + " ";
		return bonus ;
	}
	
	@Override
	public String toString() {
		return "TYPE: stockAccount: " + super.toString();
	}
}
