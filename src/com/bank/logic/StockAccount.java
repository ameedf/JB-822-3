package com.bank.logic;

import java.util.Random;

public class StockAccount extends RegularAccount {	
	public StockAccount(String clientId) {
		super(clientId);
		this.commissionOnWithdrawal = 0;
		this.commissionOnDeposit = 0;
	}
	
	@Override
	public void deposit(int sum) {
		super.deposit(sum + this.getBonus());
		setRandomCommissions();
	}
	
	@Override
	public void withdraw(int sum) {
		super.withdraw(sum);
		setRandomCommissions();
	}
	
	private int getBonus() {
		return this.commissionOnDeposit - this.commissionOnWithdrawal;
	}
	
	private void setRandomCommissions() {
		Random r = new Random();
		this.commissionOnWithdrawal = r.nextInt(6);
		this.commissionOnDeposit = r.nextInt(6);
	}
}