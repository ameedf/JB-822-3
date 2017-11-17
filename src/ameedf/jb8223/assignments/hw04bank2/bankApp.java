package ameedf.jb8223.assignments.hw04bank2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bankApp {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		regularAccount account;
		
		System.out.print("Enter account type [ regular | business | stock ]:");
		String accountType = s.nextLine();
		System.out.print("Enter account start balance:");
		double balance = s.nextDouble();
		System.out.print("Enter account start permittedOverdraft:");
		double permittedOverdraft = s.nextDouble();

		switch (accountType.toLowerCase()) {
			case "regular": account = new regularAccount("RA0000",balance,permittedOverdraft,3 ,1 ); break;
			case "business":  account = new businessAccount("BA0000",balance,permittedOverdraft); break;
			case "stock":  account = new stockAccount("CA0000",balance,permittedOverdraft); break;
			default:account = new regularAccount("RA0000",balance,permittedOverdraft, 3 ,1);break;
		}
		
		System.out.println(account.getLastOperationDescription());
		System.out.println(account);
		
		String op = s.nextLine();
		double sum;
		do {
			System.out.print("Enter account operation [ deposit | withdraw | status | exit ]:");
			op = s.next();
			switch (op.toLowerCase()) {
				case "d":
				case "deposit": System.out.print("Enter amount:"); 
								try {
									sum = s.nextDouble();
								} catch (InputMismatchException ex) {
					                System.out.println("Wrong input. Ony number input will be processed.");
					                sum = s.nextDouble();
					            }
				                account.deposit((double)sum);
				                System.out.println(account.getLastOperationDescription());
				                break;
				case "w":
				case "withdraw": System.out.print("Enter amount:"); 
				                 sum = s.nextDouble(); 
				                 account.withdraw((double)sum); 
				                 System.out.println(account.getLastOperationDescription());
				                 break;
				case "s":
				case "status":  System.out.println(account);
			}
			//Clean System.in buffer.
			s.reset();
		} while(!op.toLowerCase().equals("exit"));
		
		System.out.println("------------------------");
	}

}
