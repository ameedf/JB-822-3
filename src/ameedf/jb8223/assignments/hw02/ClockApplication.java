package ameedf.jb8223.assignments.hw02;

public class ClockApplication {
    public static void main(String[] args) {
    		// Test main Clock class
	    	System.out.println("-------------- Basic clock ---------------");
    		Clock clock = new Clock();
    		clock.print(false);
    		
    		clock.addMinutes(3);
    		clock.print(false);
    		
    		clock.addMilliseconds(25);
    		clock.print(true);
    		
    		clock.addHours(30);
    		clock.print(false);
    		
    		System.out.println("-------------- Clock with allowed negative parameter ---------------");
    		
    		// Test Bonus1 class
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
    }
}
