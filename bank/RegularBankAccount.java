package com.asad.bank;

public class RegularBankAccount {

	private final String accountId;
	private float balance;
	protected int commissionOnWithdrawal;
	protected int commissionOnDeposit;

	public RegularBankAccount(String accountId) {
		super();
		this.accountId = accountId;
		this.commissionOnWithdrawal = 3;
		this.commissionOnDeposit = 1;
	}

	public String getAccountId() {
		return accountId;
	}

	public float getBalance() {
		return balance;
	}

	/**
	 * deposit the amount of money the user want 
	 * @param moneyAmount the money amount
	 */
	public void deposit(float moneyAmount) {
		this.balance += moneyAmount + this.commissionOnDeposit + getBonus();
	}

	public void withdraw(float sum) {
		this.balance -= (sum + commissionOnWithdrawal);
	}

	protected int getBonus() {
		return 0;
	}
	@Override
	public String toString() {
		
		return "your account balance is "+ getBalance();
	}

}
