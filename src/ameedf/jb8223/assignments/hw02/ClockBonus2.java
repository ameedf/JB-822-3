package src.ameedf.jb8223.assignments.hw02;

/**
 * The same clock where minimum memory is occupied
 */
public class ClockBonus2 {

    private TimeUnit timeUnit;

    private static final int minValueAllowed = -1_000_000_000;
    private static final int maxValueAllowed = 1_000_000_000;

    public ClockBonus2() {
        this.timeUnit = new TimeUnit();
    }

    public ClockBonus2(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    // addHours - with a single parameter which represents the number of hours to add.
    public void addHours(int hoursToAdd) {
        if (hoursToAdd >= minValueAllowed && hoursToAdd <= maxValueAllowed) {
            if (hoursToAdd < 0)  //subtraction
                timeUnit.hours = ((24 + (hoursToAdd % 24)) + timeUnit.hours) % 24;
            else
                timeUnit.hours = (timeUnit.hours + hoursToAdd) % 24;
        }
    }

    // addMinutes - with a single parameter which represents the number of minutes to add.
    public void addMinutes(int minutesToAdd) {
        if (minutesToAdd >= minValueAllowed && minutesToAdd <= maxValueAllowed) {
            if (minutesToAdd < 0) {   //subtraction
                if (timeUnit.minutes < (-minutesToAdd % 60))
                    addHours((minutesToAdd / 60) - 1);
                else
                    addHours(minutesToAdd / 60);
                timeUnit.minutes = ((60 + (minutesToAdd % 60)) + timeUnit.minutes) % 60;
            }
            else {
                if (timeUnit.minutes + minutesToAdd > 59) {
                    addHours((timeUnit.minutes + minutesToAdd) / 60);
                }
                timeUnit.minutes = (timeUnit.minutes + minutesToAdd) % 60;
            }
        }
    }

    // addSeconds - with a single parameter which represents the number of seconds to add.
    public void addSeconds(int secondsToAdd) {
        if (secondsToAdd >= minValueAllowed && secondsToAdd <= maxValueAllowed) {
            if (secondsToAdd < 0) {   //subtraction
                if (timeUnit.seconds < (-secondsToAdd % 60))
                    addMinutes((secondsToAdd / 60) - 1);
                else
                    addMinutes(secondsToAdd / 60);
                timeUnit.seconds = ((60 + (secondsToAdd % 60)) + timeUnit.seconds) % 60;
            }
            else {
                if (timeUnit.seconds + secondsToAdd > 59) {
                    addMinutes((timeUnit.seconds + secondsToAdd) / 60);
                }
                timeUnit.seconds = (timeUnit.seconds + secondsToAdd) % 60;
            }
        }
    }

    // addMilliseconds - with a single parameter which represents the number of milliseconds to add.
    public void addMilliseconds(int millisecsToAdd) {
        if (millisecsToAdd >= minValueAllowed && millisecsToAdd <= maxValueAllowed) {
            if (millisecsToAdd < 0) {    //subtraction
                if (timeUnit.milliseconds < (-millisecsToAdd % 1000))
                    addSeconds((millisecsToAdd / 1000) - 1);
                else
                    addSeconds(millisecsToAdd / 1000);
                timeUnit.milliseconds = ((1000 + (millisecsToAdd % 1000)) + timeUnit.milliseconds) % 1000;
            }
            else{
                if (timeUnit.milliseconds + millisecsToAdd > 999) {
                    addSeconds((timeUnit.milliseconds + millisecsToAdd) / 1000);
                }
                timeUnit.milliseconds = (timeUnit.milliseconds + millisecsToAdd) % 1000;
            }
        }
    }

    // print - with a single boolean parameter that indicates weather we want to display a 24 hours clock
    public void print(boolean show24HoursFormat) {
        String hourString = "";

        if (show24HoursFormat) {
            hourString = addZeroOrNotAndPrint() + "\n";
        }
        else {
            int hoursValueKeeper = timeUnit.hours;
            if (timeUnit.hours >= 12 && timeUnit.hours < 24) {
                if (timeUnit.hours > 12)
                    timeUnit.hours = timeUnit.hours % 12;
                hourString = addZeroOrNotAndPrint() + "PM\n";
            }
            else {
                hourString += addZeroOrNotAndPrint() + "AM\n";
            }
            timeUnit.hours = hoursValueKeeper;
        }
        System.out.print(hourString);
    }

    // addZeroOrNotAndPrint - a helper method that does the actual time fraction printing
    private String addZeroOrNotAndPrint() {
        String hourString = "";

        if (timeUnit.hours < 10)
            hourString += "0" + timeUnit.hours + ":";
        else
            hourString += timeUnit.hours + ":";

        if (timeUnit.minutes < 10)
            hourString += "0" + timeUnit.minutes + ":";
        else
            hourString += timeUnit.minutes + ":";

        if (timeUnit.seconds < 10)
            hourString += "0" + timeUnit.seconds + ".";
        else
            hourString += timeUnit.seconds + ".";

        if (timeUnit.milliseconds < 10)
            hourString += "00" + timeUnit.milliseconds + " ";
        else if (timeUnit.milliseconds < 100)
            hourString += "0" + timeUnit.milliseconds + " ";
        else
            hourString += timeUnit.milliseconds + " ";

        return hourString;
    }
}
