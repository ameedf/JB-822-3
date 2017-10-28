package src.ameedf.jb8223.assignments.hw02;

public class ClockApplication {
    public static void main(String[] args) {

        System.out.println("This is the default clock:");
        ClockBonus1 myClockBonus = new ClockBonus1();
        printClock(myClockBonus);

        System.out.println("\nThis is the base hour:");
        ClockBonus1 myClockBonus1 = new ClockBonus1(2, 0, 0, 900);
        printClock(myClockBonus1);

        System.out.println("\nAdd 2 hours:");
        myClockBonus1.addHours(2);
        printClock(myClockBonus1);

        System.out.println("\nAdd 4 hours:");
        myClockBonus1.addHours(4);
        printClock(myClockBonus1);

        System.out.println("\nAdd 30 hours:");
        myClockBonus1.addHours(30);
        printClock(myClockBonus1);

        System.out.println("\nAdd 45 minutes:");
        myClockBonus1.addMinutes(45);
        printClock(myClockBonus1);

        System.out.println("\nAdd 90 minutes (= 1.5 hours):");
        myClockBonus1.addMinutes(90);
        printClock(myClockBonus1);

        System.out.println("\nAdd 180 minutes (= 3 hours):");
        myClockBonus1.addMinutes(180);
        printClock(myClockBonus1);

        System.out.println("\nAdd 45 seconds:");
        myClockBonus1.addSeconds(45);
        printClock(myClockBonus1);

        System.out.println("\nAdd 90 seconds (= 1.5 minutes):");
        myClockBonus1.addSeconds(90);
        printClock(myClockBonus1);

        System.out.println("\nAdd 500 seconds (= 8 minutes, 20 seconds):");
        myClockBonus1.addSeconds(500);
        printClock(myClockBonus1);

        System.out.println("\nAdd 750 milliseconds:");
        myClockBonus1.addMilliseconds(750);
        printClock(myClockBonus1);

        System.out.println("\nAdd 1500 milliseconds (= 1.5 seconds):");
        myClockBonus1.addMilliseconds(1500);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 2 hours:");
        myClockBonus1.addHours(-2);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 90 minutes:");
        myClockBonus1.addMinutes(-90);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 180 minutes (= 3 hours):");
        myClockBonus1.addMinutes(-180);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 1510 minutes (= 1 day, 1 hour, 10 minutes):");
        myClockBonus1.addMinutes(-1510);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 30 seconds:");
        myClockBonus1.addSeconds(-30);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 90 seconds:");
        myClockBonus1.addSeconds(-90);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 3666 seconds (= 1 hour, 1 minute, 6 seconds):");
        myClockBonus1.addSeconds(-3666);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 30 milliseconds:");
        myClockBonus1.addMilliseconds(-30);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 1000 milliseconds (= 1 second):");
        myClockBonus1.addMilliseconds(-1000);
        printClock(myClockBonus1);

        System.out.println("\nSubtract 3,600,020 milliseconds (= 1 hour, 20 millisecs):");
        myClockBonus1.addMilliseconds(-3600020);
        printClock(myClockBonus1);
    }

        private static void printClock(ClockBonus1 clock) {
            clock.print(true);
            clock.print(false);
        }
}
