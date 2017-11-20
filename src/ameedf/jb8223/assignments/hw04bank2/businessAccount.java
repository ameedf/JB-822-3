package ameedf.jb8223.assignments.hw04bank2;

public class businessAccount extends regularAccount {
	private int depositCounter;
	private static final int BONUS_COUNT = 2;
	private static final int BONUS_LIMIT = 5;
	private static final double BONUS_FACTOR = 20.0;
	
	public businessAccount(String clientId, double balance, double permittedOverdraft) {
		super(clientId, balance, permittedOverdraft);
		this.commissionOnWithdrawal = 1;
		this.commissionOnDeposit = 1;
		depositCounter = 0;
	}
	
	@Override
	public boolean withdraw(double sum) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnWithdrawal=" + commissionOnWithdrawal + " ";
		return super.withdraw(sum);
	}

	@Override
	public void deposit(double sum) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnDeposit=" + commissionOnDeposit + " ";
		super.deposit(sum);
		checkCommissionOnDeposit();
	}

	private void checkCommissionOnDeposit() {
		depositCounter++;
		if ((depositCounter % BONUS_COUNT) == 0 ) {
			commissionOnDeposit++;
			lastOperationDescription += "\n checkCommissionOnDeposit> CommissionOnDeposit changed to:" + commissionOnDeposit;
		}
		if (commissionOnDeposit == BONUS_LIMIT) {
			//add clear bonus without commissionOnDeposit
			double bonus = getBonus();
			commissionOnDeposit = 0;
			super.deposit(bonus);
			commissionOnDeposit = 1;
			lastOperationDescription += "\n checkCommissionOnDeposit> CommissionOnDeposit changed to:" + commissionOnDeposit;
		}
	}
	
	@Override
	protected double getBonus() {
		if(commissionOnDeposit == BONUS_LIMIT) {
			lastOperationDescription += "\n --> getBonus> BONUS:" + (BONUS_LIMIT * BONUS_FACTOR) + " <-- ";
			return BONUS_LIMIT * BONUS_FACTOR;
		} 
		return 0;
	}

	@Override
	public String toString() {
		String message = super.toString(); 
		message += " \n SubType: businessAccount [depositCounter=" + depositCounter + " ]";
		return message;
	}
}
