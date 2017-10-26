package ameedf.jb8223.assignments.hw02;

import java.util.Scanner;

public class ClockApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("please enter the number of hours between -1000000000 and 1,000,000,000");
		int hours = input.nextInt();
		
		while (hours < -1000000000 || hours > 1000000000) {
			System.out.println("please enter a valid number");
			hours = input.nextInt();
		}
		
		System.out.println("please enter the number of minutes between -1000000000 and 1,000,000,000");
		int minutes = input.nextInt();
		
		while (minutes < -1000000000 || minutes > 1000000000) {
			System.out.println("please enter a valid number");
			minutes = input.nextInt();
		}
		
		System.out.println("please enter the number of seconds between -1000000000 and 1,000,000,000");
		int seconds = input.nextInt();
		
		while (seconds < -1000000000 || seconds > 1000000000) {
			System.out.println("please enter a valid number");
			seconds = input.nextInt();
		}
		
		System.out.println("please enter the number of seconds between -1000000000 and 1,000,000,000");
		int milliseconds = input.nextInt();
		
		while (milliseconds < -1000000000 || milliseconds > 1000000000) {
			System.out.println("please enter a valid number");
			milliseconds = input.nextInt();
		}
		
		System.out.println("do you prefer the 24 hours desplay? (true/false)");
		Scanner input2 = new Scanner(System.in);
        boolean twentyFourDisplay = input2.nextBoolean();
		
        ClockBonus2 chosen = new ClockBonus2( hours, minutes, seconds, milliseconds, twentyFourDisplay);
        chosen.addHours(hours);
        chosen.addMinutes(minutes);
        chosen.addSeconds(seconds);
        chosen.addMilliseconds(milliseconds);
        chosen.print(twentyFourDisplay);
        
        
        
		
	}
}

