package com.bank.logic;

public class BusinessAccount extends RegularAccount {
	private int deposits;
	
	public BusinessAccount(String clientId) {
		super(clientId);
		this.commissionOnWithdrawal = 1;
		this.commissionOnDeposit = 1;
	}
	
	
	@Override
	public void deposit(int sum) {
		super.deposit(sum + this.getBonus());
		this.deposits++;
		
		if (deposits == 10) {
			this.commissionOnDeposit++;
			deposits = 0;
		}
		
		if (this.commissionOnDeposit == 7) {
			this.commissionOnDeposit = 1;
		}
	}
	
	private int getBonus() {
		if (this.commissionOnDeposit == 7) {
			return 20 * this.commissionOnDeposit;
		}
		return 0;
	}	
}