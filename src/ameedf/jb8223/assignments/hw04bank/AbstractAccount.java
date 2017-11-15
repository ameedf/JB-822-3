package ameedf.jb8223.assignments.hw04bank;

public abstract class AbstractAccount {

	private final String clientId;
	private double balance;
	private double permittedOverdraft;
	protected double commissionOnWithdrawal;
	protected double commissionOnDeposit;
	protected String lastOperationDescription;

	public AbstractAccount(String clientId, double balance, double permittedOverdraft, double commissionOnWithdrawal,
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
		return lastOperationDescription;
	}

	public void deposit(double sum) {
		this.balance += sum;
		lastOperationDescription += "deposit>" + sum + " Current balance:" + round(balance, 3);
	}

	public boolean withdraw(double sum) {
		if ((balance + permittedOverdraft - sum) >= 0) {
			this.balance -= sum;
			lastOperationDescription += "withdraw>" + sum + " Success! Current balance:" + round(balance, 3);
			return true;
		} else {
			lastOperationDescription += "withdraw>" + sum + " Failed! Current balance:" + round(balance, 3);
			return false;
		}
	}

	abstract double getBonus();

	@Override
	public String toString() {
		return "AbstractAccount [clientId=" + clientId + ", balance=" + balance + ", permittedOverdraft="
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
