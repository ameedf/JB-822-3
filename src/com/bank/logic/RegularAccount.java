package com.bank.logic;

public class RegularAccount {
	private final String CLIENT_ID;
	private int balance;
	protected int commissionOnWithdrawal = 3;
	protected int commissionOnDeposit = 1;
	
	public RegularAccount(String clientId) {
		CLIENT_ID = clientId;
	}

	public int getBalance() {
		return balance;
	}

	public String getCLIENT_ID() {
		return CLIENT_ID;
	}
	
	public void deposit(int sum) {
		this.balance += sum + this.commissionOnDeposit;
	}
	
	public void withdraw(int sum) {
		this.balance -= sum - this.commissionOnWithdrawal;
	}
}
