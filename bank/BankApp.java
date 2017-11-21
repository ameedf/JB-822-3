package com.asad.bank;

public class BankApp {
	public static void main(String[] args) {
		RegularBankAccount bankAccount = new RegularBankAccount("305268104");
		bankAccount.deposit(16);
		System.out.println(bankAccount);
		System.out.println("____________________________________________________________________");
		BusinessBankAccount businessBankAccount = new BusinessBankAccount("451751325");
		for (int i = 0; i < 8; i++) {
			System.out.println(businessBankAccount.commissionOnDeposit);
			for (int j = 0; j < 10; j++) {
				businessBankAccount.deposit(100);
			System.out.println(businessBankAccount);
			}
			
		}
		System.out.println("____________________________________________________________________");
		StockBankAccount stockBankAccount = new StockBankAccount("4123658935");
		stockBankAccount.deposit(100);
		System.out.println(stockBankAccount);
		
		
		
	}
	
	
}
