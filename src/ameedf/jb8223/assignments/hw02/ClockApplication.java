package ameedf.jb8223.assignments.hw02;
import ameedf.jb8223.assignments.hw02.Clock;
import ameedf.jb8223.assignments.hw02.ClockBonus1;

public class ClockApplication {
    public static void main(String[] args) {

    		Clock timer1 = new Clock();
    		timer1.print(false);
    		timer1.print(true);
    		
		Clock timer2 = new Clock(23,0,0,108);
		timer2.print(false);
		timer2.addHours(25);
		timer2.print(false);
    	
    		ClockBonus1 timer3 = new ClockBonus1(0,0,0,0);
    		timer3.print(false);
//   	timer3.addHours(-1);
    		timer3.addMinutes(-90);
//   	timer3.addSeconds(-60);
//   	timer3.addMilliseconds(-1000);

      	timer3.print(false);

    }
}
