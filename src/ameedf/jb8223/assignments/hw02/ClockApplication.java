package src.ameedf.jb8223.assignments.hw02;

public class ClockApplication {
    public static void main(String[] args) {

        System.out.println("This is the default clock:");
        Clock myClock = new Clock();
        printClock(myClock);

        System.out.println("\nThis is the base hour:");
        Clock myClock1 = new Clock(20, 0, 0, 0);
        printClock(myClock1);

        System.out.println("\nAdd 2 hours:");
        myClock1.addHours(2);
        printClock(myClock1);

        System.out.println("\nAdd 4 hours:");
        myClock1.addHours(4);
        printClock(myClock1);

        System.out.println("\nAdd 30 hours:");
        myClock1.addHours(30);
        printClock(myClock1);

        System.out.println("\nAdd 45 minutes:");
        myClock1.addMinutes(45);
        printClock(myClock1);

        System.out.println("\nAdd 90 minutes (= 1.5 hours):");
        myClock1.addMinutes(90);
        printClock(myClock1);

        System.out.println("\nAdd 180 minutes (= 3 hours):");
        myClock1.addMinutes(180);
        printClock(myClock1);

        System.out.println("\nAdd 45 seconds:");
        myClock1.addSeconds(45);
        printClock(myClock1);

        System.out.println("\nAdd 90 seconds (= 1.5 minutes):");
        myClock1.addSeconds(90);
        printClock(myClock1);

        System.out.println("\nAdd 500 seconds (= 8 minutes, 20 seconds):");
        myClock1.addSeconds(500);
        printClock(myClock1);

        System.out.println("\nAdd 750 milliseconds:");
        myClock1.addMilliseconds(750);
        printClock(myClock1);

        System.out.println("\nAdd 1500 milliseconds (= 1.5 seconds):");
        myClock1.addMilliseconds(1500);
        printClock(myClock1);


//        System.out.println("This is the default clock:");
//        ClockBonus1 myClockBonus = new ClockBonus1();
//        printClock(myClockBonus);
//        System.out.println("\nThis is the base hour:");
//        ClockBonus1 myClockBonus1 = new ClockBonus1(2, 0, 0, 0);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 2 hours:");
//        myClockBonus1.addHours(-2);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 270 hours:");
//        myClockBonus1.addHours(-270);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 30 minutes:");
//        myClockBonus1.addMinutes(-30);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 180 minutes (= 3 hours):");
//        myClockBonus1.addMinutes(-180);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 260 minutes (= 4 hours, 20 minutes):");
//        myClockBonus1.addMinutes(-260);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 30 seconds:");
//        myClockBonus1.addSeconds(-30);
//        printClock(myClockBonus1);

//        System.out.println("\nSubtract 1250 milliseconds (= 1 second, 250 millisecs):");
//        myClockBonus1.addMilliseconds(-1250);
//        printClock(myClockBonus1);
    }

    private static void printClock(Clock clock) {
        clock.print(true);
        clock.print(false);
    }

//        private static void printClock(ClockBonus1 clock) {
//            clock.print(true);
//            clock.print(false);
//        }
}
