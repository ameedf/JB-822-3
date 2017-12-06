package src.ameedf.jb8223.assignments.BankAccount;

public class BankApplication {

    public static void main(String[] args) {

        System.out.println("================ Regular account ======================");
        RegularAccount regularAccount = new RegularAccount();
        printAccountDetails(regularAccount);
        regularAccount.deposit(100);
        printAccountDetails(regularAccount);
        regularAccount.withdraw(50);
        printAccountDetails(regularAccount);

        System.out.println("================ Business account =====================");
        BusinessAccount businessAccount = new BusinessAccount();
        for (int i=0 ; i<70 ; i++) {
            businessAccount.deposit(10);
            printAccountDetails(businessAccount);
            businessAccount.withdraw(10);
            printAccountDetails(businessAccount);
        }

        System.out.println("================= Stock account =====================");
        StockAccount stockAccount = new StockAccount();
        printAccountDetails(stockAccount);
        stockAccount.deposit(10);
        printAccountDetails(stockAccount);
        stockAccount.withdraw(5);
        printAccountDetails(stockAccount);
        stockAccount.deposit(20.5);
        printAccountDetails(stockAccount);
        stockAccount.withdraw(15.7);
        printAccountDetails(stockAccount);
    }

    private static void printAccountDetails(RegularAccount account) {
        System.out.println(account);
    }
}
