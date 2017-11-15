package com.bank.accounts;

public class RegularAccount {
	private final String clientId;
	private int balance;
	protected int commissionOnWithdrawal = 3;
	protected int commissionOnDeposit = 1;
	
	public RegularAccount(String clientId) {
		this.clientId = clientId;
	}

	public int getBalance() {
		return balance;
	}

	public String getClientId() {
		return clientId;
	}
	
	public void deposit(int sum) {
		this.balance += sum + this.commissionOnDeposit;
	}
	
	public void withdraw(int sum) {
		this.balance -= sum - this.commissionOnWithdrawal;
	}
}
