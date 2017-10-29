package src.ameedf.jb8223.assignments.hw02;

import java.util.Scanner;

public class ClockApplication {
    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);
        int hours;
        int minutes;
        int seconds;
        int millisecs;

        System.out.println("This is the default clock:");
        ClockBonus1 myClock1 = new ClockBonus1();
        printClock(myClock1);

        do {
            System.out.println("Please enter input for 'hours' (0..23):");
            hours = input.nextInt();
        } while (hours < 0 || hours > 23) ;

        do {
            System.out.println("Please enter input for 'minutes' (0..59):");
            minutes = input.nextInt();
        } while (minutes < 0 || minutes > 59) ;

        do {
            System.out.println("Please enter input for 'seconds' (0..59):");
            seconds = input.nextInt();
        } while (seconds < 0 || seconds > 59) ;

        do {
            System.out.println("Please enter input for 'milliseconds' (0..999):");
            millisecs = input.nextInt();
        } while (millisecs < 0 || millisecs > 999) ;

        ClockBonus1 myClock2 = new ClockBonus1(hours, minutes, seconds, millisecs);

        System.out.println("\nThis is your base hour:");
        printClock(myClock2);

        do {
            System.out.println("Please enter hours to add / subtract' (-1,000,000,000..1,000,000,000):");
            hours = input.nextInt();
        } while (hours < -1_000_000_000 || hours > 1_000_000_000) ;
        myClock2.addHours(hours);
        printClock(myClock2);

        do {
            System.out.println("Please enter minutes to add / subtract' (-1,000,000,000..1,000,000,000):");
            minutes = input.nextInt();
        } while (minutes < -1_000_000_000 || minutes > 1_000_000_000) ;
        myClock2.addMinutes(minutes);
        printClock(myClock2);

        do {
            System.out.println("Please enter seconds to add / subtract' (-1,000,000,000..1,000,000,000):");
            seconds = input.nextInt();
        } while (seconds < -1_000_000_000 || seconds > 1_000_000_000) ;
        myClock2.addSeconds(seconds);
        printClock(myClock2);

        do {
            System.out.println("Please enter milliseconds to add / subtract' (-1,000,000,000..1,000,000,000):");
            millisecs = input.nextInt();
        } while (millisecs < -1_000_000_000 || millisecs > 1_000_000_000) ;
        myClock2.addMilliseconds(millisecs);
        printClock(myClock2);
    }

        private static void printClock(ClockBonus1 clock) {
            clock.print(true);
            clock.print(false);
        }
}
