package ameedf.jb8223.assignments.hw02;

public class ClockApplication {
    public static void main(String[] args) {
    		// Test main Clock class
    		Clock clock = new Clock();
    		clock.print(false);
    		
    		clock.addMinutes(123);
    		clock.print(false);
    		
    		clock.addMilliseconds(25);
    		clock.print(true);
    		
    		clock.addHours(30);
    		clock.print(true);
    }
}
