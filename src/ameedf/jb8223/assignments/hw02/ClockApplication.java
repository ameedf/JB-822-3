package ameedf.jb8223.assignments.hw02;
import ameedf.jb8223.assignments.hw02.Clock;
import ameedf.jb8223.assignments.hw02.ClockBonus1;
import ameedf.jb8223.assignments.hw02.ClockBonus2;

public class ClockApplication { 
    public static void main(String[] args) {
/*
    		Clock timer1 = new Clock();
    		timer1.toString(false);
    		timer1.toString(true);
    		
    		//16:49:05.065
		Clock timer2 = new Clock(16,49,5,65);
		timer2.toString(false);
		timer2.addHours(25);
		timer2.toString(false);
		timer2.addMinutes(30);
		timer2.toString(false);
    	
    		ClockBonus1 timer3 = new ClockBonus1(0,0,0,0);
    		timer3.toString(true);
    		timer3.toString(false);
    		timer3.addMilliseconds(-1);
    		timer3.toString(false);
     	timer3.addHours(-1);
  		timer3.addMinutes(-90);
      	timer3.toString(false);
     	timer3.addSeconds(-60);
     	timer3.addMilliseconds(-1000);
    		timer3.addMinutes(90);
    		timer3.toString(false);
    		timer3.addMinutes(-30);
    		timer3.toString(false);
    		timer3.addMinutes(-121);
    		timer3.toString(false);
 */   		
    		ClockBonus2 timer4 = new ClockBonus2();
    		System.out.println(timer4.toString(false));
    		timer4.addHours(25);
    		System.out.println(timer4.toString(false));
    		timer4.addHours(-25);
    		System.out.println(timer4.toString(false));
    		timer4.addMinutes(53);
    		System.out.println(timer4.toString(false));
    		timer4.addMinutes(-53);
    		System.out.println(timer4.toString(false));
    		timer4.addSeconds(7);
    		System.out.println(timer4.toString(false));
    		timer4.addSeconds(-7);
    		System.out.println(timer4.toString(false));
    		timer4.addMilliseconds(1020);
    		System.out.println(timer4.toString(false));
    		timer4.addMilliseconds(-1020);
    		System.out.println(timer4.toString(false));
    		System.out.println();
    		
    		ClockBonus2 timer5 = new ClockBonus2(0,45,0,0);
    		timer5.toString(false);
    		timer5.toString(true);
    }
}
