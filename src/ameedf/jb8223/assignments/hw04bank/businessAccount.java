package ameedf.jb8223.assignments.hw04bank;

public class businessAccount extends AbstractAccount {
	private int depositCounter;
	private static final int BONUS_COUNT = 2;
	private static final int BONUS_LIMIT = 5;
	private static final double BONUS_FACTOR = 20.0;

	public businessAccount(String clientId, double balance, double permittedOverdraft) {
		super(clientId, balance, permittedOverdraft, 1, 1);
		depositCounter = 0;
	}
	
	@Override
	public boolean withdraw(double sum) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnWithdrawal=" + commissionOnWithdrawal + " ";
		return super.withdraw(sum + commissionOnWithdrawal);
	}

	@Override
	public void deposit(double sum) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnDeposit=" + commissionOnDeposit + " ";
		super.deposit(sum + commissionOnDeposit);
		checkCommissionOnDeposit();
	}

	private void checkCommissionOnDeposit() {
		depositCounter++;
		if ((depositCounter % BONUS_COUNT) == 0 ) {
			commissionOnDeposit++;
			lastOperationDescription += "\n checkCommissionOnDeposit> CommissionOnDeposit changed to:" + commissionOnDeposit;
		}
		if (commissionOnDeposit == BONUS_LIMIT) {
			super.deposit(getBonus());
			commissionOnDeposit = 1;
			lastOperationDescription += "\n checkCommissionOnDeposit> CommissionOnDeposit changed to:" + commissionOnDeposit;
		}
	}

	public double getBonus() {
		if(commissionOnDeposit == BONUS_LIMIT) {
			lastOperationDescription += "\n --> getBonus> BONUS:" + (BONUS_LIMIT * BONUS_FACTOR) + " <-- ";
			return BONUS_LIMIT * BONUS_FACTOR;
		} 
		return 0;
	}

	@Override
	public String toString() {
		String message = super.toString(); 
		message += "businessAccount [depositCounter=" + depositCounter + " ]";
		return message;
	}
}
