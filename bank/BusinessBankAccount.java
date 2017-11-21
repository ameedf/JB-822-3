package com.asad.bank;

public class BusinessBankAccount extends RegularBankAccount {

	// counts the number of deposits for the account
	private int DEPOSITS = 0;

	public BusinessBankAccount(String accountId) {
		super(accountId);
		this.commissionOnDeposit = 1;
		this.commissionOnWithdrawal = 1;
	}

	public int getDEPOSITS() {
		return DEPOSITS;
	}

	/**
	 * Override the deposit method from the RegularBankAccount class and change the
	 * conditions to get the bonus. every 10 deposits the commission on deposit well
	 * increase by 1
	 */
	@Override
	public void deposit(float moneyAmount) {

		
		if (DEPOSITS %10 == 0 && DEPOSITS!=0) {
			this.commissionOnDeposit += 1;
			
		}
		DEPOSITS++;
		super.deposit(moneyAmount);

	}

	/**
	 * Override the getBonus method from the RegularBankAccount class and change the
	 * conditions to get a bonus. when the commission on deposit reaches 7 the bonus
	 * well be (7 *20) else it is the default bonus
	 */
	@Override
	protected int getBonus() {
		if (this.commissionOnDeposit > 7) {
			this.commissionOnDeposit = 1;

			return 7 * 20;
		} else {
			return super.getBonus();
		}
	}

	@Override
	public String toString() {

		return super.toString() + " and number of  your deposits is " + getDEPOSITS();
	}

}
