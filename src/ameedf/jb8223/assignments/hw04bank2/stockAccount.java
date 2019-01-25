package ameedf.jb8223.assignments.hw04bank2;

import java.util.Random;

public class stockAccount extends regularAccount {

	public stockAccount(String clientId, double balance, double permittedOverdraft) {
		super(clientId, balance, permittedOverdraft);
		this.commissionOnWithdrawal = 0;
		this.commissionOnDeposit = 0;
	}

	@Override
	public void deposit(double sum) {
		changeCommisions();
		lastOperationDescription += "\t amount = " + sum + ", commissionOnDeposit=" + commissionOnDeposit + " ";
		super.deposit(sum + getBonus());
	}

	@Override
	public boolean withdraw(double sum) {
		changeCommisions();
		lastOperationDescription += "\t amount = " + sum + ", commissionOnWithdrawal=" + commissionOnWithdrawal + " ";
		return super.withdraw(sum + (getBonus() *(-1)));
	}
	
	private void changeCommisions() {
		Random rn = new Random();
		commissionOnDeposit = rn.nextInt(6);
		commissionOnWithdrawal = rn.nextInt(6);
		lastOperationDescription += " changeCommisions> CommissionOnDeposit:" + commissionOnDeposit + " commissionOnWithdrawal:" + commissionOnWithdrawal + "\n";
	}
	
	@Override
	protected double getBonus() {
		double bonus = (commissionOnDeposit - commissionOnWithdrawal);
		lastOperationDescription += " --> BONUS " + bonus + " <--";
		return bonus ;
	}
	
	@Override
	public String toString() {
		String message = super.toString(); 
		message += " \n SubType: stockAccount";
		return message;
	}
}
