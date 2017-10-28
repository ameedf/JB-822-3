package src.ameedf.jb8223.assignments.hw02;

/**
 * This class will represent a 24-hours clock up to micro-seconds precision (1000 millisecond = 1 second).
 * That means that it will represent hours of the form "HH:MM:SS.mmm", where
 * HH - represents the hours in 24 format. Range: [0-23]
 * MM - represents the minutes. Range: [0-59]
 * SS - represents the seconds. Range: [0-59]
 * sss - represents the micro-seconds. Range: [0-999]
 *
 * It will have 2 constructors:
 * 1. One constructor with 4 parameters: hours, minutes, seconds and milliseconds.
 *    Assume the input is always valid for this constructor
 * 2. One constructor with no parameters. This will initialize the clock to 14:07:53.980
 *
 * It will have these methods:
 * 1. addHours - with a single parameter which represents the number of hours to add.
 *    It will add the hours only if it's in the range [0..1,000,000,000]. No value is returned
 * 2. addMinutes - with a single parameter which represents the number of minutes to add.
 *    It will add the minutes only if it's in the range [0..1,000,000,000]. No value is returned
 * 3. addSeconds - with a single parameter which represents the number of seconds to add.
 *    It will add the seconds only if it's in the range [0..1,000,000,000]. No value is returned
 * 4. addMilliseconds - with a single parameter which represents the number of milliseconds to add.
 *    It will add the milliseconds only if it's in the range [0..1,000,000,000]. No value is returned
 * 5. print - with a single boolean parameter that indicates weather we want to display a 24 hours clock
 *    or 12 hours clock. If a 12 hours clock is chosen it will add "AM/PM" at the end of the input.
 *    NOTE: the printout should include leading zeros (don't use any formatting methods !!)
 *    For example: 12:3:9.56 --> 12:03:09.056
 *
 * The implementation must NOT use any external classes (except for the printout)
 * BONUS 1: change the addHours, addMinutes, addSeconds and addMilliseconds methods to accept arguments
 *          within the range [-1,000,000,000 .. 1,000,000,000]. Meaning: negative values are allowed.
 *          For example, adding (-1) seconds to 00:00:00.000 will take the clock back to 23:59:59.000
 * BONUS 2: the same functionality as in "BONUS 1" while using as few member variables / memory as possible
 */
public class Clock {

    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;

    private final int minValueAllowed = 0;
    private final int maxValueAllowed = 1_000_000_000;

    // 1st constructor, initializes the clock to 14:07:53.980
    public Clock() {
        this.hours = 14;
        this.minutes = 7;
        this.seconds = 53;
        this.milliseconds = 980;
    }

    // 2nd constructor, accepts 4 parameters in the ranges of 0..23, 0..59, 0..59, 0..999
    public Clock (int hours, int minutes, int seconds, int microSeconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = microSeconds;
    }

    // addHours - with a single parameter which represents the number of hours to add.
    public void addHours(int hoursToAdd) {
        if (hoursToAdd >= minValueAllowed && hoursToAdd <= maxValueAllowed) {
                this.hours = (this.hours + hoursToAdd) % 24;
        }
    }

    // addMinutes - with a single parameter which represents the number of minutes to add.
    public void addMinutes(int minutesToAdd) {
        if (minutesToAdd >= minValueAllowed && minutesToAdd <= maxValueAllowed) {
                addHours(minutesToAdd / 60);
                this.minutes = (this.minutes + minutesToAdd) % 60;
        }
    }

    // addSeconds - with a single parameter which represents the number of seconds to add.
    public void addSeconds(int secondsToAdd) {
        if (secondsToAdd >= minValueAllowed && secondsToAdd <= maxValueAllowed) {
                addMinutes(secondsToAdd / 60);
                this.seconds = (this.seconds + secondsToAdd) % 60;
        }
    }

    // addMilliseconds - with a single parameter which represents the number of milliseconds to add.
    public void addMilliseconds(int millisecsToAdd) {
        if (millisecsToAdd >= minValueAllowed && millisecsToAdd <= maxValueAllowed) {
                addSeconds(millisecsToAdd / 1000);
                this.milliseconds = (this.milliseconds + millisecsToAdd) % 1000;
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
