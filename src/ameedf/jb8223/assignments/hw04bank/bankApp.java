package ameedf.jb8223.assignments.hw04bank;

public class bankApp {
 
	public static void main(String[] args) {
		AbstractAccount regularAcc = new regularAccount("RA0001",0,0);
		System.out.println(regularAcc);
		System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.deposit(10.00);   System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.deposit(10.00);   System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.deposit(10.00);   System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.deposit(10.00);   System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.withdraw(10.00);  System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.withdraw(10.00);  System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.withdraw(5.9876); System.out.println(regularAcc.getLastOperationDescription());
		regularAcc.withdraw(10.00);  System.out.println(regularAcc.getLastOperationDescription());
		if(regularAcc.withdraw(10.00)) {
			System.out.println("Withdraw success!");
		} else {
			System.out.println("Withdraw Fail! No enoght money!");
		}
		
		System.out.println("--------------------------------------------------------------");
		
		AbstractAccount businessAcc = new businessAccount("BA0001",0,0);
		System.out.println(businessAcc);
		System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.deposit(10.00);   System.out.println(businessAcc.getLastOperationDescription());
		
		businessAcc.withdraw(130.00); System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.withdraw(0.1234); System.out.println(businessAcc.getLastOperationDescription());
		businessAcc.withdraw(99.99);  System.out.println(businessAcc.getLastOperationDescription());
		
		if(businessAcc.withdraw(99.99)) {
			System.out.println("Withdraw Success!");
		} else {
			System.out.println("Withdraw Fail! No enoght money!");
		}
		
		System.out.println("--------------------------------------------------------------");
		
		AbstractAccount stockAcc = new stockAccount("CA0001",0,0);
		System.out.println(stockAcc);
		System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.deposit(10.00);   System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.deposit(10.00);   System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.deposit(10.00);   System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.deposit(10.00);   System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.deposit(10.00);   System.out.println(stockAcc.getLastOperationDescription());
		
		stockAcc.withdraw(130.00); System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.withdraw(0.1234); System.out.println(stockAcc.getLastOperationDescription());
		stockAcc.withdraw(99.99);  System.out.println(stockAcc.getLastOperationDescription());
		
		if(stockAcc.withdraw(99.99)) {
			System.out.println("Withdraw Success!");
		} else {
			System.out.println("Withdraw Fail! No enoght money!");
		}
		
		
		
		
	}

}
