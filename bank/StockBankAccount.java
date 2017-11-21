package com.asad.bank;

import java.util.Random;

public class StockBankAccount extends RegularBankAccount {

	public StockBankAccount(String accountId) {
		super(accountId);
		this.commissionOnDeposit = 0;
		this.commissionOnWithdrawal = 0;

	}

	/**
	 * Override the deposit method from the RegularBankAccount class it pots a
	 * random number in the commission on deposit
	 */

	@Override
	public void deposit(float moneyAmount) {
		setRandomCommission();
		super.deposit(moneyAmount);
	}

	/**
	 * Override the deposit method from the RegularBankAccount class it pots a
	 * random number in the commission on withdrawal
	 */

	@Override
	public void withdraw(float moneyAmount) {
		setRandomCommission();
		super.withdraw(moneyAmount);
	}

	/**
	 * Override the getBonus method from the RegularBankAccount class and change the
	 * conditions to get a bonus. the bonus is the commission on deposit minus the
	 * commission on withdrawal
	 */
	@Override
	protected int getBonus() {

		return this.commissionOnDeposit - this.commissionOnWithdrawal;
	}

	private void setRandomCommission() {
		this.commissionOnWithdrawal = randomCommission();
		this.commissionOnDeposit = randomCommission();
	}

	/**
	 * 
	 * @return random number between 0 to 5
	 */
	private int randomCommission() {
		Random randomCommission = new Random();
		int number = randomCommission.nextInt(6);
		return number;
	}

	@Override
	public String toString() {

		return "your balance is " + getBalance() + " and the commissions are (deposit,withdraw)" + " ( "
				+ this.commissionOnDeposit + " , " + this.commissionOnWithdrawal + " )";
	}

}
