package ameedf.jb8223.assignments.hw04bank;

public class regularAccount extends AbstractAccount{

	public regularAccount(String clientId, double balance, double permittedOverdraft) {
		super(clientId, balance, permittedOverdraft, 3, 1);
	}
	
	@Override
	public void deposit(double sum ) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnDeposit=" + commissionOnDeposit + " ";
		super.deposit(sum + commissionOnDeposit);
	}
	
	@Override
	public boolean withdraw(double sum ) {
		lastOperationDescription = "\t amount = " + sum + ", commissionOnWithdrawal=" + commissionOnWithdrawal + " ";
		return super.withdraw(sum + commissionOnWithdrawal);
	}
	
	public double getBonus() { return 0;	}

	@Override
	public String toString() {
		return "TYPE: regularAccount: " + super.toString();
	}
	
	

}
