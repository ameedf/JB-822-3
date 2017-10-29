package src.ameedf.jb8223.assignments.hw02;

public class TimeUnit {

    int hours;
    int minutes;
    int seconds;
    int milliseconds;

    // 1st constructor, initializes the clock to 14:07:53.980
    public TimeUnit() {
        this.hours = 14;
        this.minutes = 7;
        this.seconds = 53;
        this.milliseconds = 980;
    }

    // 2nd constructor, accepts 4 parameters in the ranges of 0..23, 0..59, 0..59, 0..999
    public TimeUnit(int hours, int minutes, int seconds, int microSeconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = microSeconds;
    }

}
