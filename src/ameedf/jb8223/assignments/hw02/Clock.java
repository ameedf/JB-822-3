package ameedf.jb8223.assignments.hw02;
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
	private int milliseconds;
	private int seconds;
	private int minutes;
	private int hours;
	
	public Clock(int milliseconds, int seconds, int minutes, int hours) {
		this.milliseconds = milliseconds;
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}
	
	public Clock() {
		this.milliseconds = 980;
		this.seconds = 53;
		this.minutes = 7;
		this.hours = 14;
	}
	
	public void addMilliseconds(int ms) {
		if (ms > 0 || ms < 1000000000) {
			int seconds = (this.milliseconds + ms) / 1000;
			this.addSeconds(seconds);
			this.milliseconds = (this.milliseconds + ms) % 1000;
		}
	}
	
	public void addSeconds(int sec) {
		if (sec > 0 || sec < 1000000000) {
			int minutes = (this.seconds + sec) / 60;
			this.addMinutes(minutes);			
			this.seconds = (this.seconds + sec) % 60;
		}
	}
	
	public void addMinutes(int mins) {
		if (mins > 0 || mins < 1000000000) {
			int hours = (this.minutes + mins) / 60;
			this.addHours(hours);
			this.minutes = (this.minutes + mins) % 60;
			
		}
	}
	
	public void addHours(int hrs) {
		if (hrs > 0 || hrs < 1000000000) {
			this.hours = (this.hours + hrs) % 24;			
		}
	}
	
	public void print(boolean format12) {
		// Handle AM/PM format
		int hoursOutput = this.hours;
		String daytimeOutput = "";
		if (format12) {
			if (this.hours <= 12) {
				daytimeOutput = "AM";
			} else {
				hoursOutput -= 12;
				daytimeOutput = "PM";
			}
		}
		
		// Handle prefixes for MM:SS:sss
		String secondsPrefix = "";
		String minutesPrefix = "";
		String millisecondsPrefix = "";
		
		// Handle Milliseconds prefix
		if (milliseconds < 100) {
			millisecondsPrefix += "0";
			if (milliseconds < 10) {
				millisecondsPrefix += "0";
			}
		}
		
		// Handle Seconds prefix
		if (seconds < 10) {
			secondsPrefix = "0";
		}
		
		// Handle Minutes prefix
		if (minutes < 10) {
			minutesPrefix = "0";
		}
		
		System.out.println(hoursOutput + ":" + minutesPrefix + this.minutes + ":" 
				+ secondsPrefix + this.seconds + ":" + millisecondsPrefix + this.milliseconds + " " + daytimeOutput);
	}
}
