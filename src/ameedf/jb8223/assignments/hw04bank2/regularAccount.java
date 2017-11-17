package ameedf.jb8223.assignments.hw04bank2;

public class regularAccount {
	
	private final String clientId;
	private double balance;
	private double permittedOverdraft;
	protected double commissionOnWithdrawal;
	protected double commissionOnDeposit;
	protected String lastOperationDescription;

	public regularAccount(String clientId, double balance, double permittedOverdraft, double commissionOnWithdrawal,
			double commissionOnDeposit) {
		this.clientId = clientId;
		this.balance = balance;
		this.permittedOverdraft = permittedOverdraft;
		this.commissionOnWithdrawal = commissionOnWithdrawal;
		this.commissionOnDeposit = commissionOnDeposit;
		this.lastOperationDescription = "Account ID " + clientId + " created successful!";
	}
	
	public String getClientId() {
		return clientId;
	}

	public double getBalance() {
		return balance;
	}

	public double getPermittedOverdraft() {
		return permittedOverdraft;
	}

	public String getLastOperationDescription() {
		String mess = lastOperationDescription;
		lastOperationDescription = "";
		return mess;
	}

	public void deposit(double sum) {
		this.balance += sum + this.commissionOnDeposit;
		lastOperationDescription += "deposit>" + sum + ", commission:" + this.commissionOnDeposit+ ", Current balance:" + round(balance, 3);
	}

	public boolean withdraw(double sum) {
		if ((balance + permittedOverdraft - (sum + this.commissionOnWithdrawal) ) >= 0) {
			this.balance -= (sum + this.commissionOnWithdrawal);
			lastOperationDescription += "withdraw>" + sum +", commission:" + this.commissionOnWithdrawal +" Success! Current balance:" + round(balance, 3);
			return true;
		} else {
			lastOperationDescription += "withdraw>" + sum +", commission:" + this.commissionOnWithdrawal +" Failed! Current balance:" + round(balance, 3);
			return false;
		}
	}

	protected double getBonus() { return 0.0;}
	
	@Override
	public String toString() {
		return "regularAccount [clientId=" + clientId + ", balance=" + balance + ", permittedOverdraft="
				+ permittedOverdraft + ", commissionOnWithdrawal=" + commissionOnWithdrawal + ", commissionOnDeposit="
				+ commissionOnDeposit + "]";
	}

	protected double round(double num, int count) {
		double tens = 1.0;
		while (count != 0) {
			tens *= 10.0;
			count--;
		}
		return Math.round(num * tens) / tens;
	}

}
