package src.ameedf.jb8223.assignments.hw02;

/**
 * The same clock where negative values are allowed to be added
 */
public class ClockBonus1 {

    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;

    private final int minValueAllowed = -1_000_000_000;
    private final int maxValueAllowed = 1_000_000_000;

    // 1st constructor, initializes the clock to 14:07:53.980
    public ClockBonus1() {
        this.hours = 14;
        this.minutes = 7;
        this.seconds = 53;
        this.milliseconds = 980;
    }

    // 2nd constructor, accepts 4 parameters in the ranges of 0..23, 0..59, 0..59, 0..999
    public ClockBonus1(int hours, int minutes, int seconds, int microSeconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = microSeconds;
    }

    // addHours - with a single parameter which represents the number of hours to add.
    public void addHours(int hoursToAdd) {
        if (hoursToAdd >= minValueAllowed && hoursToAdd <= maxValueAllowed) {
            if (hoursToAdd < 0)  //subtraction
                this.hours = ((24 + (hoursToAdd % 24)) + this.hours) % 24;
            else
                this.hours = (this.hours + hoursToAdd) % 24;
        }
    }

    // addMinutes - with a single parameter which represents the number of minutes to add.
    public void addMinutes(int minutesToAdd) {
        if (minutesToAdd >= minValueAllowed && minutesToAdd <= maxValueAllowed) {
            if (minutesToAdd < 0) {   //subtraction
                if (this.minutes < (-minutesToAdd % 60))
                    addHours((minutesToAdd / 60) - 1);
                else
                    addHours(minutesToAdd / 60);
                this.minutes = ((60 + (minutesToAdd % 60)) + this.minutes) % 60;
            }
            else {
                addHours(minutesToAdd / 60);
                this.minutes = (this.minutes + minutesToAdd) % 60;
            }
        }
    }

    // addSeconds - with a single parameter which represents the number of seconds to add.
    public void addSeconds(int secondsToAdd) {
        if (secondsToAdd >= minValueAllowed && secondsToAdd <= maxValueAllowed) {
            if (secondsToAdd < 0) {   //subtraction
                if (this.seconds < (-secondsToAdd % 60))
                    addMinutes((secondsToAdd / 60) - 1);
                else
                    addMinutes(secondsToAdd / 60);
                this.seconds = ((60 + (secondsToAdd % 60)) + this.seconds) % 60;
            }
            else {
                addMinutes(secondsToAdd / 60);
                this.seconds = (this.seconds + secondsToAdd) % 60;
            }
        }
    }

    // addMilliseconds - with a single parameter which represents the number of milliseconds to add.
    public void addMilliseconds(int millisecsToAdd) {
        if (millisecsToAdd >= minValueAllowed && millisecsToAdd <= maxValueAllowed) {
            if (millisecsToAdd < 0) {    //subtraction
                if (this.milliseconds < (-millisecsToAdd % 1000))
                    addSeconds((millisecsToAdd / 1000) - 1);
                else
                    addSeconds(millisecsToAdd / 1000);
                this.milliseconds = ((1000 + (millisecsToAdd % 1000)) + this.milliseconds) % 1000;
            }
            else{
                addSeconds((this.milliseconds + millisecsToAdd) / 1000);
                this.milliseconds = (this.milliseconds + millisecsToAdd) % 1000;
            }
        }
    }

    // print - with a single boolean parameter that indicates weather we want to display a 24 hours clock
    public void print(boolean show24HoursFormat) {
        if (show24HoursFormat) {
            addZeroOrNotAndPrint();
            System.out.printf("\n");
        }
        else {
            int hoursValueKeeper = hours;
            if (hours >= 12 && hours < 24) {
                if (hours > 12)
                    hours = hours % 12;
                addZeroOrNotAndPrint();
                System.out.println("PM");
            }
            else {
                addZeroOrNotAndPrint();
                System.out.println("AM");
            }
            hours = hoursValueKeeper;
        }
    }

    // addZeroOrNotAndPrint - a helper method that does the actual time fraction printing
    private void addZeroOrNotAndPrint() {
        if (hours < 10)
            System.out.printf("0" + hours + ":");
        else
            System.out.printf(hours + ":");

        if (minutes < 10)
            System.out.printf("0" + minutes + ":");
        else
            System.out.printf(minutes + ":");

        if (seconds < 10)
            System.out.printf("0" + seconds + ".");
        else
            System.out.printf(seconds + ".");

        if (milliseconds < 10)
            System.out.printf("00" + milliseconds + " ");
        else if (milliseconds < 100)
            System.out.printf("0" + milliseconds + " ");
        else
            System.out.printf(milliseconds + " ");
    }
}
