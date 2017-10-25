package ameedf.jb8223.assignments.hw02;

public class ClockApplication {
    public static void main(String[] args) {
    		// Test main Clock class
	    	System.out.println("-------------- Basic clock ---------------");
    		Clock clock = new Clock();
    		clock.print(false);
    		
    		clock.addMinutes(55);
    		clock.print(false);
    		
    		clock.addMilliseconds(25);
    		clock.print(true);
    		
    		clock.addHours(30);
    		clock.print(false);
    		
    		clock.addSeconds(10);
    		clock.print(true);
    		
    		// Test Bonus1 class
    		System.out.println("-------------- Clock with allowed negative parameter ---------------");
    		ClockBonus1 clock2 = new ClockBonus1();
    		clock2.print(false);
    		
    		clock2.addHours(-50);
    		clock2.print(false);
    		
    		clock2.addSeconds(-70);
    		clock2.print(false);
    		
    		clock2.addMinutes(-140);
    		clock2.print(false);
    		
    		clock2.addMilliseconds(-2500);
    		clock2.print(true);
    		
    		// Test Bonus2 class
	    	System.out.println("-------------- Refactored basic solution: Bonus 2 ---------------");
    		ClockBonus2 clock3 = new ClockBonus2();
    		clock3.print(false);
    		
    		clock3.addMinutes(3);
    		clock3.print(false);
    		
    		clock3.addMilliseconds(25);
    		clock3.print(true);
    		
    		clock3.addHours(30);
    		clock3.print(false);
    }
}
