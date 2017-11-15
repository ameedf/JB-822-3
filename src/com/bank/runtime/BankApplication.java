package com.bank.runtime;

import com.bank.logic.RegularAccount;
import com.bank.logic.BusinessAccount;
import com.bank.logic.StockAccount;

public class BankApplication {
	public static void main(String[] args) {
		System.out.println("----- REGULAR ACCOUNT-----");
		RegularAccount regular = new RegularAccount("331385294");
		regular.deposit(5000);
		System.out.println("Current balance: " + regular.getBalance());
		regular.withdraw(2000);
		System.out.println("Current balance: " + regular.getBalance());
		
		System.out.println("----- REGULAR ACCOUNT-----");
		BusinessAccount business = new BusinessAccount("334585912");
		for (int i = 0; i < 80; i++) {
			business.deposit(100);
			System.out.println("Current balance: " + business.getBalance());
		}
		
		System.out.println("----- STOCK ACCOUNT-----");
		StockAccount stock = new StockAccount("337618795");
		for (int i = 0; i < 11; i++) {
			stock.deposit(100);
			System.out.println("Current balance: " + stock.getBalance());
		}
	}

}
